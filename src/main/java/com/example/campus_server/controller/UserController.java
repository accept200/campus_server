package com.example.campus_server.controller;

import com.example.campus_server.data.LoginRet;
import com.example.campus_server.entity.LoginInfo;
import com.example.campus_server.entity.UserDetail;
import com.example.campus_server.service.RedisService;
import com.example.campus_server.service.UserService;
import com.example.campus_server.utils.Result;
import com.example.campus_server.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public Result getAllUser(@RequestHeader Map<String, String> headers) {
        int uid = Integer.parseInt(headers.get("uid"));
        char priv = redisService.getUserPrivilege(uid);
        if (priv == 'A') {
            return ResultFactory.getSuccessResult("成功", userService.getAllUser());
        } else {
            return ResultFactory.getErrorResult("无权限");
        }
    }

    @RequestMapping(value = "/ifUserExist")
    public Result ifUserExist(String username) {
        if (userService.isUsernameExist(username))
            return ResultFactory.getSuccessResult("用户名存在", true);
        else
            return ResultFactory.getSuccessResult("用户名不存在", false);
    }

    @RequestMapping(value = "login")
    public Result login(String username, String password) {
        LoginRet ret = userService.login(username, password);
        switch (ret.ret) {
            case 0:
                String uuid = redisService.userLogin(ret.uid);
                redisService.setUserPrivilege(ret.uid, 'U');
                return ResultFactory.getSuccessResult("登录成功", new LoginInfo(ret.uid, uuid));
            case 1:
                return ResultFactory.getErrorResult("用户名不存在");
            case 2:
                return ResultFactory.getErrorResult("密码错误");
            case 3:
                return ResultFactory.getErrorResult("用户被禁用");
            case 4:
                return ResultFactory.getErrorResult("内部错误");
            default:
                return ResultFactory.getErrorResult("未知错误");
        }
    }

    @RequestMapping(value = "signup")
    public Result signup(String username, String password, String nickname) {
        int ret = userService.signup(username, password, nickname);
        return switch (ret) {
            case 0 -> ResultFactory.getSuccessResult("注册成功");
            case 1 -> ResultFactory.getErrorResult("用户名已存在");
            case 2 -> ResultFactory.getErrorResult("参数不能为空");
            case 3 -> ResultFactory.getErrorResult("内部错误");
            default -> ResultFactory.getErrorResult("未知错误");
        };
    }

    @RequestMapping(value = "logout")
    public Result logout(@RequestHeader Map<String, String> headers) {
        int uid = Integer.parseInt(headers.get("uid"));
        String token = headers.get("token");
        redisService.userLogout(token);
        return ResultFactory.getSuccessResult("退出成功");
    }

    @RequestMapping(value = "userInfo")
    public Result getUserInfo(@RequestHeader Map<String, String> headers) {
        int uid = Integer.parseInt(headers.get("uid"));
        UserDetail userDetail =  userService.getUserInfo(uid);
        return ResultFactory.getSuccessResult("成功", userDetail);
    }

    @RequestMapping(value = "updatePassword")
    public Result updatePassword(@RequestHeader Map<String, String> headers, String old_password, String new_password) {
        int uid = Integer.parseInt(headers.get("uid"));
        int ret = userService.updatePassword(uid, old_password, new_password);
        return switch (ret) {
            case 0 -> ResultFactory.getSuccessResult("成功");
            case 1 -> ResultFactory.getErrorResult("密码错误");
            case 2 -> ResultFactory.getErrorResult("密码不能相同");
            case 3 -> ResultFactory.getErrorResult("内部错误");
            default -> ResultFactory.getErrorResult("未知错误");
        };
    }

    @RequestMapping(value = "updateUserInfo")
    public Result updateUserInfo(@RequestHeader Map<String, String> headers, String new_nickname, String new_user_info) {
        int uid = Integer.parseInt(headers.get("uid"));
        int ret = userService.updateUserInfo(uid, new_nickname, new_user_info);
        return ResultFactory.getSuccessResult("success", ret);
    }
}


