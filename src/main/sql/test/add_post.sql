USE test
GO

-- Insert rows into table '[campus].[post]'
INSERT INTO [campus].[post]
( -- columns to insert data into
 [title], [author_id], [type_tag], [status_tag], [content], [create_time]
)
VALUES
( -- first row: values for the columns in the list above
    N'测试', 1, 1, 4, N'张三 测试 学习求助 未完成', GETDATE()
),
( -- second row: values for the columns in the list above
    N'测试2', 3, 7, 6, N'王五 测试2 信息咨询， 已完成', GETDATE()
)
-- add more rows here
GO