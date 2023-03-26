USE test
GO

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

SELECT * FROM [campus].[post_view]
GO
