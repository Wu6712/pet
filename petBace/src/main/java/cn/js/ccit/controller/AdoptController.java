package cn.js.ccit.controller;

import cn.js.ccit.entity.Adopt;
import cn.js.ccit.service.IAdoptService;
import cn.js.ccit.utils.R;
import cn.js.ccit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2023-07-06
 */
@Api(tags = "领养模块")
@CrossOrigin
@RestController
@RequestMapping("/adopt")
public class AdoptController {

    @Autowired
    private IAdoptService iAdoptService;

    @Operation(summary = "领养列表")
    @GetMapping("/list")
    public Result getList() {


        List<Adopt> list = iAdoptService.getList();

        return R.success(list);

    }

    @GetMapping("lists")
    public Result getAdoptList() {

        return R.success(iAdoptService.getLists());

    }

    @Operation(summary = "宠物详情")
    @GetMapping("/{id}")
    public  Result getPetInfo(@PathVariable(value = "id") Integer id) {

        Adopt pet = iAdoptService.getById(id);

        return R.success(pet);

    }

    @Operation(summary = "领养申请")
    @PutMapping("/filed")
    public Result filed(@RequestParam(value = "username") String username,
                        @RequestParam(value = "id") Integer id) {

        int i = iAdoptService.updateOne(id, username);

        return i == 0 ? R.fail("领养失败") : R.success("领养成功");

    }

    @Operation(summary = "宠物品种模糊查询")
    @GetMapping
    public Result getPetList(@RequestParam String keywords) {

        return R.success(iAdoptService.getListByType(keywords));

    }

    @PutMapping("/{id}")
    public Result audit(@PathVariable Integer id) {

        return iAdoptService.audit(id) == 1 ? R.success("操作成功") : R.fail("操作失败");

    }

}
