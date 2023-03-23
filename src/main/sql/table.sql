-- Create a new database called 'test'
-- Connect to the 'master' database to run this snippet
USE master;
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
    SELECT name
        FROM sys.databases
        WHERE name = N'test'
)
CREATE DATABASE [test];
GO

USE test;
GO

CREATE SCHEMA campus;
GO


-- Drop the table if it already exists
IF OBJECT_ID('campus.comment', 'U') IS NOT NULL
    DROP TABLE [campus].[comment]
GO
-- Drop the table if it already exists
IF OBJECT_ID('campus.post', 'U') IS NOT NULL
    DROP TABLE [campus].[post]
GO
-- Drop the table if it already exists
IF OBJECT_ID('campus.tag', 'U') IS NOT NULL
DROP TABLE [campus].[tag]
GO
-- Drop the table if it already exists
IF OBJECT_ID('campus.user', 'U') IS NOT NULL
DROP TABLE [campus].[user]
GO

-- Create a new table called '[user]' in schema '[campus]'
-- Create the table in the specified schema
CREATE TABLE [campus].[user]
(
    user_id INT NOT NULL PRIMARY KEY IDENTITY,
    username [NVARCHAR](50) UNIQUE NOT NULL,
    password [CHAR](32) NOT NULL,
    nickname [NVARCHAR](50) NOT NULL,
    -- D: Dev, A: Admin, U: User, G: Guest, B: Ban
    privilege [CHAR] NOT NULL DEFAULT 'U' CHECK (privilege IN ('D', 'A', 'U', 'G', 'B')), 
    user_info [NVARCHAR](1000),
    create_time DATETIME NOT NULL DEFAULT (getdate())
    -- specify more columns here
);
GO

-- Create a new table called 'tag' in schema 'campus'
-- Create the table in the specified schema
CREATE TABLE [campus].[tag]
(
    tag_id INT NOT NULL PRIMARY KEY IDENTITY, -- primary key column
    tag_name [NVARCHAR](50) NOT NULL,
    -- T: Type, S: Status
    tag_type [CHAR] NOT NULL CHECK (tag_type IN ('T', 'S')),
    style [NVARCHAR](512)
    -- specify more columns here
);
GO

-- Create a new table called '[post]' in schema '[campus]'
-- Create the table in the specified schema
CREATE TABLE [campus].[post]
(
    post_id INT NOT NULL PRIMARY KEY IDENTITY, -- primary key column
    title [NVARCHAR](200) NOT NULL,
    content NVARCHAR(MAX) NOT NULL,
    type_tag INT,
    status_tag INT,
    author_id INT NOT NULL,
    create_time DATETIME NOT NULL DEFAULT (getdate()),
    CONSTRAINT fk_campuspost_userid FOREIGN KEY (author_id) REFERENCES [campus].[user] (user_id),
    CONSTRAINT fk_campuspost_ttagid FOREIGN KEY (type_tag) REFERENCES [campus].[tag] (tag_id), 
    CONSTRAINT fk_campuspost_stagid FOREIGN KEY (status_tag) REFERENCES [campus].[tag] (tag_id)
    -- specify more columns here
);
GO

-- Create a new table called '[comment]' in schema '[campus]'
-- Create the table in the specified schema
CREATE TABLE [campus].[comment]
(
    comment_id INT NOT NULL PRIMARY KEY IDENTITY, -- primary key column
    content [NVARCHAR](200) NOT NULL,
    author_id INT NOT NULL,
    comment_post INT NOT NULL,
    parent_id INT DEFAULT (NULL),
    depth INT NOT NULL DEFAULT (0),
    create_time DATETIME NOT NULL DEFAULT (getdate())
    CONSTRAINT fk_campuscomment_userid FOREIGN KEY (author_id) REFERENCES [campus].[user] (user_id),
    CONSTRAINT fk_campuscomment_postid FOREIGN KEY (comment_post) REFERENCES [campus].[post] (post_id),
    CONSTRAINT fk_campuscomment_commentid FOREIGN KEY (parent_id) REFERENCES [campus].[comment] (comment_id)
    -- specify more columns here
);
GO