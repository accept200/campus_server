USE test
GO

INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('zhangsan@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'张三', 'U', N'张三个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('lisi@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'李四', 'U', N'李四个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('wangwu@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'王五', 'U', N'王五个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('zhaoliu@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', '123456')),3,32)),
     N'赵六', 'U', N'赵六个人信息', getdate())
INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('admin@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', 'admin123')),3,32)),
     N'管理员', 'A', N'管理员测试0000', getdate())
INSERT INTO [campus].[user] (username, password, nickname, privilege, user_info, create_time) VALUES
    ('dev@abc.com', UPPER(SUBSTRING(sys.fn_VarBinToHexStr(HASHBYTES('MD5', 'T22yD%dNk!B1OyAAG%0Vq2^Mkce8u5V8')),3,32)),
     N'DEV', 'A', N'DEV Account', getdate())
GO
