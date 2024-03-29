USE master
GO
-- Select rows from a Table or View 'TableOrViewName' in schema 'SchemaName'
SELECT * FROM [dbo].[user]
WHERE age=15/* add search conditions here */
GO

-- Select rows from a Table or View '[user]' in schema '[dbo]'
SELECT * FROM [dbo].[user]
WHERE id=1	/* add search conditions here */
GO

-- Insert rows into table  [user]'
INSERT INTO [user]
( -- columns to insert data into
 [name] , [age]     
)
VALUES
( -- first row: values for the columns in the list above
  N'李4',20
)

GO

SELECT * FROM [dbo].[user]
Go

-- Create a new database called 'master2'
-- Connect to the 'master' database to run this snippet
USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
    SELECT name
        FROM sys.databases
        WHERE name = N'master2'
)
CREATE DATABASE master2
GO
USE master2
GO
 -- Create a new table called '[user]' in schema '[dbo]'
 -- Drop the table if it already exists
 IF OBJECT_ID('[dbo].[user]', 'U') IS NOT NULL
 DROP TABLE [dbo].[user]
 GO
 -- Create the table in the specified schema
 CREATE TABLE [dbo].[user]
 (
    id INT NOT NULL PRIMARY KEY IDENTITY, -- primary key column
    name [NVARCHAR](50) NOT NULL,
    age [INT] NOT NULL
    -- specify more columns here
 );
 GO
 -- Insert rows into table '[dbo].[user]'
 INSERT INTO [dbo].[user]
 ( -- columns to insert data into
  [name],[age]
 )
 VALUES
 ( -- first row: values for the columns in the list above
  N'李3',21
 ),
 ( -- second row: values for the columns in the list above
  N'王5',15
 ),
 (
    N'张6',17
 );
 -- add more rows here
 GO

DECLARE @exists BIT
EXECUTE [campus].[if_username_exist] N'zhangsan@abc.com', @exists OUT
SELECT @exists
GO

DECLARE @ret INT
DECLARE @user_id INT
EXECUTE [campus].[login] N'zhangsan@abc.com', 'E10ADC3949BA59ABBE56E057F20F883E', @ret OUTPUT, @user_id OUTPUT
SELECT @ret, @user_id
GO

DECLARE @ret INT
DECLARE @user_id INT
EXECUTE [campus].[login] N'ban@abc.com', '670B14728AD9902AECBA32E22FA4F6BD', @ret OUTPUT, @user_id OUTPUT
SELECT @ret, @user_id
GO

DECLARE @ret INT
EXECUTE [campus].[signup] N'ftb@abc.com', 'A9A708EEBBFD48267AFB1F146CAF5229', N'方某', @ret OUTPUT
SELECT @ret
GO
