# SQL

## Data modification

### Deletion

Delete everything from instructors

```SQL
delete all from instructors;
```

Delete everything from the physics department

```SQL
delete all from instructors
where dept_name = 'physics';
```

Subqueries are always evaluated before deleting.

### Insertion

```SQL
insert into student
    select ID, name, dept_name, 0
    from instructor;
```

```SQL
insert into course
values ('CS-342',
        'Databases',
        'Comp. Sci',
        4);
```

### Updates

Increasing all salaries by 5%

```SQL
update instructor
    set salary = salary * 1.05;
```

Now, what if we want to update certain salaries by 3% and some by 5%? Two queries? No, there's a faster way:

```SQL
update instructor
    set salary =
        case
            when salary <= 100000
            then salary = salary * 1.03
            else salary = salary * 1.05
        end 
```

How about updating all the students' scores?
To avoid changing scores of students who didn't take any courses, we could do:

```SQL
update student S
set tot_cred = (
        select case
            when sum(credits) is not null
            them sum(credits)
            else 0
        end
        from takes natural join course
        where S.ID = takes.ID
            and takes.grade != 'F'
            and takes.grade is not null)   
```

But that's kind of a lot. So we use coalesce:

```SQL
update student S
set tot_cred = (
    select coalesce(sum(credits), 0)
    from takes natural join course
    where S.ID = takes.ID
        and takes.grade != 'F'
        and takes.grade is not null)
```

### Referential actions

When, for example, deleting an attribute that is also a foreign key, it's not going to work. In order to delete it, you have to first create a new attribute that will replace the existing one, change all the instances to the new attribute, and then delete the old attribute.

This has a value on each attribute, which can be:

    - cascade
    - set null
    - set default
    - no action

## Join expressions

![SQL Joins](../99Res/sqljoins.png)

### Join Type Using:

Incorrect query to find instructors and name of courses they teach

```SQL
select name, title
from instructor
    natural join teaches
    natural join course
```

because we won't cover all cases for each instructor, since some instructors give classes in departments they're not in. Hence, the correct way would be

```SQL
select name, title
from instructor
    natural join teaches
    join course using (course_id)
```

or better

```SQL
select name, title
from instructor
    join teaches using (ID)
    join course using (course_id)
```

### Join Type On

Find all courses which have a prerequisite offered by the CompSci dept:

```SQL
select prereq.course_id
from course join prereq
    on course.course._id = prereq.prereq_id
where course.dept_name = 'Comp. Sci'
```

## Views

We use views to store the results of a query into something, to be used later.

```SQL
create view physics as
select *
from course natural join section
where dept_name = 'Physics';

create view physics_watson as
select * 
from physics
where building = 'Watson';
```

## Transactions

A sequence of statements defined by ACID:

- A: Atomicity: Each state of the database is as if the transactions was fully done or not at all
- C: Consistency: Execution maintains the consistency of the database
- I: Isolation: The result of the transaction is the same, no mater if done concurrently or sequentially
- D: Durability: After a transaction commits, its change persists

## Indexing

Finding an ID in a table:

- Unsorted: O(n), because it has to go through every entry.
- Sorted: O(log(n)), because it uses binary search.

But what if we sort by ID, but then want to search by dept_name? We use **indices**.

How it works: Every table has a hidden attribute: *rowid*. These are strictly increasing and cannot be repeated. We create an index like this:

```SQL
create index inst_dn_idx
on instructor(dept_name)

select dept_name, rowid
from instructor
order by dept_name
```

This helps find by dept_name a lot faster, since we only do two binary searches, instead of one linear search.

## Access Control

Following privileges exist:

- select
- insert
- update
- delete
- reference

Short form: `all privileges`.

```SQL
-- give priv
grant update on department to john
-- remove priv
revoke update on department from john
```

But we don't normally give single privileges, but we give roles that have privileges:

```SQL
create role instructor;

grant all privileges on takes
to instructor;

grant instructor to john;
```

We can go even one step further and give roles to roles:

```SQL
create role dean;

grant instructor to dean;
```

### View access

Giving rights to views really only limits the access to that view, but not to the underlying tables! So you need both.

### Grant granting

We can allow others to grant others:

```SQL
grant select on department to john
with grant option;
```

In case we remove this right, we can cascade or restrict the rights given by john

```SQL
revoke select on department
from john cascade/restrict
```

### Granting as role

So we don't grant by person but by role, we can specify this:

```SQL
grant select on department
to john
granted by current role;
```

## Triggers

We can make triggers for specific actions on a table. These can check inputs or other aspects of a table. They can be dangerous though. A trigger have to give the same result, no matter if you run them 1 time or 20 times. Hence, we have to be careful how we design them.

## Recursion

If we have courses and their required course, we could take course X and find it's requirements. These could be a required course of a required course. For this, we look for the **transitive closure**.
But it's not possible to calculate this dependency directly!
