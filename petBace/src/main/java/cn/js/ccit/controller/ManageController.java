package cn.js.ccit.controller;

import cn.js.ccit.entity.Manage;
import cn.js.ccit.service.IManageService;
import cn.js.ccit.service.IUserService;
import cn.js.ccit.utils.R;
import cn.js.ccit.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2023-07-11
 */
@Api(tags = "管理模块")
@CrossOrigin
@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private IManageService iManageService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public Result getList() {

        List<Manage> list = iManageService.getList();
        return R.success(list);

    }

    @PostMapping
    public Result insertOne(@RequestBody Manage manage) {

        int i = iManageService.insertOne(manage);

        if (i == 0) {
            return R.fail("举报失败");
        }

        return R.success("举报成功");
    }

    @PutMapping
    public Result updateOne(@RequestParam("id") Integer id ,@RequestParam("name") String name) {

        int i = iManageService.updateOne(id);

        if (i == 0) {
            return R.fail("处理失败");
        }

        iUserService.changePermissions(name);

        return R.success("处理成功");

    }


}
