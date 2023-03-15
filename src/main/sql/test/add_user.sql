USE test
GO

INSERT INTO [campus].[user] (username, password, nickname, user_info, create_time) VALUES
    ('zhangsan@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
    N'张三', N'张三个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, user_info, create_time) VALUES
    ('lisi@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'李四', N'李四个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, user_info, create_time) VALUES
    ('wangwu@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'王五', N'王五个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, user_info, create_time) VALUES
    ('zhaoliu@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'赵六', N'赵六个人信息', getdate())

GO
