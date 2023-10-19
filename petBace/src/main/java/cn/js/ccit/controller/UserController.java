package cn.js.ccit.controller;

import cn.js.ccit.entity.User;
import cn.js.ccit.service.IUserService;
import cn.js.ccit.utils.Auth0Jwt;
import cn.js.ccit.utils.R;
import cn.js.ccit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2023-07-03
 */
@CrossOrigin
@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody User user) {

        int i = iUserService.register(user);

        if (i == 2) {
            return R.fail("该用户已经存在");
        }

        return i == 1 ? R.success("注册成功") : R.fail("注册失败");

    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {

        User user = iUserService.login(username, password);

        if (user == null) {
            return R.fail("登录失败");
        }

        return R.LOGIN_SUCCESS(Auth0Jwt.sign(user.getId(), user.getUsername(), user.getPassword()));

    }

    @Operation(summary = "修改密码")
    @PutMapping
    public Result changePasswd(@RequestParam(value = "oldPassword") String oldPassword,
                               @RequestParam(value = "newPassword") String newPassword,
                               @RequestParam(value = "username") String username) {
        System.out.println("旧密码" + oldPassword);
        System.out.println("新密码" + newPassword);
        System.out.println("用户名" + username);

        int i = iUserService.changePasswd(username, oldPassword, newPassword);


        if (i == 2) {
            return R.fail("旧密码错误");
        }

        return i == 0 ? R.fail("修改失败") : R.success("修改成功");

    }

    @Operation(summary = "用户详情")
    @GetMapping("/{username}")
    public Result userInfo(@PathVariable(value = "username") String username) {

        User user = iUserService.getByUserName(username);

        return R.LOGIN_SUCCESS(Auth0Jwt.sign(user.getId(), user.getUsername(), user.getPassword()));

    }

    @GetMapping("/getInfo")
    public Result getInfo(@RequestParam String username) {
        User user = iUserService.getByUserName(username);

        if(user == null) {
            return R.fail("查询失败");
        }

        return R.success(user);
    }

}
