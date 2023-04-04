USE test
GO

-- Create a new stored procedure called '[if_username_exist]' in schema '[campus]'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'campus'
    AND SPECIFIC_NAME = N'if_username_exist'
)
DROP PROCEDURE [campus].[if_username_exist]
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE [campus].[if_username_exist]
    @username [NVARCHAR](50) = N'',
    @if_exist [BIT] OUTPUT
-- add more stored procedure parameters here
AS
    -- body of the stored procedure
    IF EXISTS (
        SELECT user_id FROM [campus].[user]
        WHERE username = @username
    )
        SET @if_exist = 1
    ELSE
        SET @if_exist = 0
GO
-- example to execute the stored procedure we just created

-- Create a new stored procedure called '[login]' in schema 'campus'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'campus'
    AND SPECIFIC_NAME = N'login'
)
DROP PROCEDURE [campus].[login]
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE [campus].[login]
    @username [NVARCHAR](50) = N'',
    @password [CHAR](32),
    @ret [INT] = 0 OUTPUT,
    @user_id [INT] = -1 OUTPUT
-- @ret  0: success, 
--       1: username not exist, 
--       2: password not correct, 
--       3: user is banned
--       4: internal error
AS
    -- body of the stored procedure
    DECLARE @if_exist BIT
    EXECUTE [campus].[if_username_exist] @username, @if_exist OUTPUT
    IF @if_exist = 1 BEGIN
        DECLARE @pri CHAR
        SELECT @user_id = [user_id], @pri = [privilege] FROM [campus].[user]
        WHERE [username] = @username AND [password] = @password
        IF @user_id = NULL BEGIN
            SET @ret = 2
            SET @user_id = -1
        END
        ELSE BEGIN
            IF @pri = 'B' BEGIN -- banned
                SET @ret = 3
            END
            ELSE BEGIN
                SET @ret = 0
            END
        END
    END
    ELSE BEGIN
        SET @ret = 1
        SET @user_id = -1
    END
GO

-- Create a new stored procedure called '[signup]' in schema '[campus]'
-- Drop the stored procedure if it already exists
IF EXISTS (
SELECT *
    FROM INFORMATION_SCHEMA.ROUTINES
WHERE SPECIFIC_SCHEMA = N'campus'
    AND SPECIFIC_NAME = N'signup'
)
DROP PROCEDURE [campus].[signup]
GO
-- Create the stored procedure in the specified schema
CREATE PROCEDURE [campus].[signup]
    @username [NVARCHAR](50), 
    @password [char](32),
    @nickname [NVARCHAR](50),
    @ret [INT] OUTPUT
    -- @ret 0: success
    --      1: username exist
    --      2: null values
    --      3: internal error
AS
    -- body of the stored procedure
    IF @username = NULL OR @password = NULL OR @nickname = NULL BEGIN
        SET @ret = 2
    END
    ELSE BEGIN
        DECLARE @if_exist BIT
        EXECUTE [campus].[if_username_exist] @username, @if_exist OUTPUT
        IF @if_exist = 1 BEGIN
            SET @ret = 1
        END
        ELSE BEGIN
            INSERT INTO [campus].[user] (username, [password], nickname, privilege, user_info )
            VALUES (@username, @password, @nickname, 'U', N'')
            SET @ret = 0
        END     
    END
GO

