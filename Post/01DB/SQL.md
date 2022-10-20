# Database Test 1 (SQL)

## Database Basics

Show all databases
```sql
SHOW DATABASES;
```

Choose a database
```sql
USE database_name;
```

Create a new database
```sql
CREATE DATABASE database_name;
```

Delete a database
```sql
DROP DATABASE database_name;
```

## Table basics
Show all tables in a database
```sql
SHOW tables;
```

Create a new table
```sql
CREATE TABLE table_name(
    ID_Plane INT AUTO_INCREMENT PRIMARY KEY,
    AirportName VARCHAR(45)
    Place VARCHAR(45)
    Producer_ID INT
    FOREIGN KEY (Producer ID) REFERENCES Producer(ID_Producer)
);
```

Put values into a table
```sql
INSERT INTO table_name (value1, value2, value3, value4)
VALUES
    ("value", "value", "value", "value"),
    ("value", "value", "value", "value"),
    ("value", "value", "value", "value");
```

Import into a table
```sql
LOAD DATA LOCAL INFILE 'Path/to/file.csv'
INTO TABLE table_name
CHARACTER SET latin1
FIELDS #(or COLUMNS)
    TERMINATED BY ','
    ENCLOSED BYE 'char'
IGNORE 1 ROWS #(or LINES)
(col_name_user_var, col_name_user_var, col_name_user_var)
SET
    col_name = {expression}
```

Select everything from a table
```sql
SELECT * FROM table_name;
```

## Selecting from a table

Select a column by name 
```sql
SELECT name from family;
```

Select a row by one of its values
```sql
Select * from family
where name = "Max";
```

## Edit a column

Rename a column
```sql
ALTER TABLE table_name
RENAME COLUMN airplains TO airplanes;
```

Change a column data type
```sql
ALTER TABLE table_name
MODIFY COLUMN airplanes VARCHAR(20);
```

Add a column+
```sql
ALTER TABLE table_name
ADD COLUMN column_name datatype;
```

Delete a column
```sql
ALTER TABLE table_name
DROP COLUMN column_name;
```

Delete a row
```sql
DELETE FROM table_name WHERE condition;
```

Delete everything from a table
```sql
DELETE FROM table_name;
```
or
```sql
TRUNCATE TABLE table_name;
```

## Joining tables

Join tables by using the `PRIMARY` and `FOREIGN` keys.
Here we join table "airline" onto "airport" by the airport's foreign key `Airline_ID` and the airline's primary key `ID_AIRLINE`

```sql
SELECT * FROM airport
JOIN airline ON aiport.Airline_ID=ID_Airline;
```

You can join multiple tables at once as long as you have enough keys.

## Users and access restriction

Create a new user
```sql
CREATE USER IF NOT EXISTS 'user_name'@'host'
DEFAULT ROLE user_role
IDENTIFIED BY 'password';
```

Give permissions to user
```sql
GRANT SELECT, INSERT, DROP (or ALL) on database_name.table_name TO 'user_name'@'host';
```

Revoke permissions from user
```sql
REVOKE DROP on database_name.table_name FROM 'user_name'@'host';
```

Show all users
```sql
SELECT * FROM mysql.user;
```

Delete a user
```sql
DROP USER 'user_name'@'host';
```












