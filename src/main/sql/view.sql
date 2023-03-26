use test
GO

-- Create a new view called '[user_auth]' in schema '[campus]'
-- Drop the view if it already exists
IF EXISTS (
SELECT *
    FROM sys.views
    JOIN sys.schemas
    ON sys.views.schema_id = sys.schemas.schema_id
    WHERE sys.schemas.name = N'campus'
    AND sys.views.name = N'user_auth'
)
DROP VIEW [campus].[user_auth]
GO
-- Create the view in the specified schema
CREATE VIEW [campus].[user_auth]
AS
    -- body of the view
    SELECT [user_id],
        [username],
        [password]
    FROM [campus].[user]
GO

-- Create a new view called '[user_detail]' in schema '[campus]'
-- Drop the view if it already exists
IF EXISTS (
SELECT *
    FROM sys.views
    JOIN sys.schemas
    ON sys.views.schema_id = sys.schemas.schema_id
    WHERE sys.schemas.name = N'campus'
    AND sys.views.name = N'user_detail'
)
DROP VIEW [campus].[user_detail]
GO
-- Create the view in the specified schema
CREATE VIEW [campus].[user_detail]
AS
    -- body of the view
    SELECT [user_id],
        [username],
        [nickname],
        [user_info]
    FROM [campus].[user]
GO

-- Create a new view called '[ttag]' in schema '[campus]'
-- Drop the view if it already exists
IF EXISTS (
SELECT *
    FROM sys.views
    JOIN sys.schemas
    ON sys.views.schema_id = sys.schemas.schema_id
    WHERE sys.schemas.name = N'campus'
    AND sys.views.name = N'ttag'
)
DROP VIEW [campus].[ttag]
GO
-- Create the view in the specified schema
CREATE VIEW [campus].[ttag]
AS
    -- body of the view
    SELECT [tag_id],
        [tag_name],
        [style]
    FROM [campus].[tag]
    WHERE [tag_type] = 'T'
GO

-- Create a new view called 'stag' in schema 'campus'
-- Drop the view if it already exists
IF EXISTS (
SELECT *
    FROM sys.views
    JOIN sys.schemas
    ON sys.views.schema_id = sys.schemas.schema_id
    WHERE sys.schemas.name = N'campus'
    AND sys.views.name = N'stag'
)
DROP VIEW [campus].[stag]
GO
-- Create the view in the specified schema
CREATE VIEW [campus].[stag]
AS
    -- body of the view
    SELECT [tag_id],
        [tag_name],
        [style]
    FROM [campus].[tag]
    WHERE [tag_type] = 'S'
GO


-- Create a new view called '[post_view]' in schema '[campus]'
-- Drop the view if it already exists
IF EXISTS (
SELECT *
    FROM sys.views
    JOIN sys.schemas
    ON sys.views.schema_id = sys.schemas.schema_id
    WHERE sys.schemas.name = N'campus'
    AND sys.views.name = N'post_view'
)
DROP VIEW [campus].[post_view]
GO
-- Create the view in the specified schema
CREATE VIEW [campus].[post_view]
AS
    -- body of the view
    SELECT [campus].[post].[post_id],
    [campus].[post].[author_id],
    [campus].[user].[nickname] AS [author_name],
    [campus].[post].[type_tag],
    [campus].[ttag].[tag_name] AS [ttag_name],
    [campus].[post].[status_tag],
    [campus].[stag].[tag_name] AS [stag_name],
    [campus].[post].[content],
    [campus].[post].[create_time]
FROM [campus].[post], [campus].[user], [campus].[ttag], [campus].[stag]
WHERE [campus].[post].[author_id] = [campus].[user].[user_id]
AND [campus].[post].[type_tag] = [campus].[ttag].[tag_id]
AND [campus].[post].[status_tag] = [campus].[stag].[tag_id]
GO
