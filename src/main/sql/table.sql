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

-- Create a new table called '[user]' in schema '[campus]'
-- Drop the table if it already exists
IF OBJECT_ID('campus.user', 'U') IS NOT NULL
DROP TABLE [campus].[user]
GO
-- Create the table in the specified schema
CREATE TABLE [campus].[user]
(
    user_id INT NOT NULL PRIMARY KEY IDENTITY,
    username [NVARCHAR](50) UNIQUE NOT NULL,
    password [CHAR](32) NOT NULL,
    nickname [NVARCHAR](50) NOT NULL,
    user_info [NVARCHAR](1000),
    create_time DATETIME NOT NULL DEFAULT (getdate())
    -- specify more columns here
);
GO

-- Create a new table called '[post]' in schema '[campus]'
-- Drop the table if it already exists
IF OBJECT_ID('campus.post', 'U') IS NOT NULL
DROP TABLE [campus].[post]
GO
-- Create the table in the specified schema
CREATE TABLE [campus].[post]
(
    post_id INT NOT NULL PRIMARY KEY IDENTITY, -- primary key column
    title [NVARCHAR](200) NOT NULL,
    content NVARCHAR(MAX) NOT NULL,
    author_id INT NOT NULL,
    create_time DATETIME NOT NULL DEFAULT (getdate()),
    CONSTRAINT fk_campuspost_userid FOREIGN KEY (author_id) REFERENCES [campus].[user] (user_id)
    -- specify more columns here
);
GO

-- Create a new table called '[comment]' in schema '[campus]'
-- Drop the table if it already exists
IF OBJECT_ID('campus.comment', 'U') IS NOT NULL
DROP TABLE [campus].[comment]
GO
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