# Server and Services

## Windows server

### Editions

- Essential: 25 Users. Nobody uses it.
- Standard: Enough for a bunch of users and mid-size operations.
- Datacenter: most complete package.

These can be installed as

1. new installation (preferred)
2. upgrade
3. migration (moving from other server)

**A server requires an Access License.** Note the difference between Device (CAL) and User (CAL). Depending on implementation, it might make sense to use one or the other.

-----

## Active Directory Installation

### What is it?

A directory service. It provides information about objects in a logical, hierarchical structure. It allows to manage everything centrally.

### Domain

A local safety area that has centrally controlled resources. Each domain needs **at least one** Domain Controller. 

Some domain names:

- post.ch
- spiessh.ch
- ict-campu.net

### Components of AD

Digital

- Partition
- Schema
- Forests
- Domain
- Domain Tree
- Sites
- OUs (organizational units)
- Containers

Physical

- Domain Controller
- Data stores
- global catalog servers
- RODC (Read only domain controller)

### Qualities

- Scalable
- Expandable
- Available
- Performant
- Safe

### Structure and Use: Organizational Unit (OU)

An object OU is like a container. It contains stuff like users, groups and so on.

-----

## Shares

### Permission and formats

- FAT: no permissions, size limited
- NTFS: ACL (access control list), auditing and journaling
- ReFS (Resilient file system): NTFS compatible, error correction builtin

### Permissions Windows

Can be explicit or inherited. You can pick and choose which users or groups get what permissions. They're also cumulative: a user can get multiple types of permissions

POLP: Principle of least privilege.

Permission inheritance can be turned off.

**Best practices:**

- clear guidelines
- don't assign single permissions. Work with groups.

Shared directories can be copied. If they're copied, the copy is still available. Now, if the original is moved, the original is not shared anymore.

### Administrative shares

SYSVOL and LOGON:

### Connecting to share

Use: `\\server-name\share-name` or `net use \\server-name\share-name`.

### Access Based Enumeration

Only the shares that the user has access on are actually shown. All the rest are not shown.

### Shadow copies

### NTFS Permission (FAIL)

Because of UAC (User Account Control) the Admin has no NTFS permissions on the file server. The permissions have to be edited on the local group policy editor.

-----

## AD Basics

### Domain name

An area of management. It has a unique name and allows an admin to built an infrastructure in it.

### Structure

OU -> Domain -> Tree -> Forest

### Container vs OU

OU can receive GPO (Group Policies) and a Container can not.

### User Object

Important:

- logon name
- password
  - deactivate
  - set password
  - reset password
- groups

### Groups

A summary of Users or Computers

### Computers

Can be saved as an OU. Each belongs to a domain and has a Computer Account.  These allow the authentication and surveillance of the system.

### FSMO Roles

- Domain Naming Master: gives and manages domain name
- Schema Master: defines the class templates for the objects, as well as attributes assigned to each object
- RID (relative ID) Master: Knows the naming of each object. Allocates active and standard relative ID to DCs in the domain.
- PDC (Primary Domain Controller) Emulator: Time synchronization in the organization. Important for authentication (via Kerberos)
- Domain Infrastructure Master: unpacking of user groups

-----

## IGDLA

Stands for **Identities, Global groups, Domain local groups, and Access**.

- Identities: User and PC Accounts that represent roles in an organization
- Global groups: members of Domain Local Groups that represent management groups by grouping together Identities with similar permissions
- Domain Local groups: grants Users access to resources based on the policies of the local domain
- Access: assigned Access to a resource that is inherited down the hierarchy until needed

-----

## Userhome

Personal directory for each user. It contains all the personal files of a user. **Only the user has access to it.**  The address to it is `\\server\userhome(&)\%username%`.

How to set it up:

- Create directories for each user
- Remove all security permission except Administrator and SYSTEM
- Go to the User on the AD and set the home path in the user's settings.

-----

## File Server Resource Manager (FSRM)

What a file server has to be able to do:

- share directories
- set limits
- recognize file types
- create status summaries

For this, we can set FSRM as a role.

### Quotas

FSRM can set quotas for different things. These can be derived from the MS templates or by creating new ones. These can be "hard" or "soft". The difference lies in how these announce when the limit is exceeded.

You can then apply quotas to different directories

### File Screening

Helps to analyze files and notify the user when they're creating or pasting a file type that is not allowed. Can be done in **File Screen Management.**

### More server roles

- Data deduplication: instead of duplicating files, it references copies to the original, until the copy is modified.
- DFS Namespaces: enables you to group shared folders located on different servers into one or more logically structured namespaces.

-----

## DNS

### DNS Translation

Browser -> DNS Cache -> DNS (AD) -> ISP -> Root (recursor)