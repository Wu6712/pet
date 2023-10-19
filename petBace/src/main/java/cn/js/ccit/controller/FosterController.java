package cn.js.ccit.controller;

import cn.js.ccit.entity.Adopt;
import cn.js.ccit.entity.Foster;
import cn.js.ccit.service.IAdoptService;
import cn.js.ccit.service.IFosterService;
import cn.js.ccit.utils.R;
import cn.js.ccit.utils.Result;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 123
 * @since 2023-07-06
 */
@Api(tags = "寄养模块")
@CrossOrigin
@RestController
@RequestMapping("/foster")
public class FosterController {

    @Autowired
    private IFosterService iFosterService;

    @Autowired
    private IAdoptService iAdoptService;

    @Operation(summary = "提交寄养")
    @PostMapping
    public Result insertOne(@RequestBody Foster foster) {

        foster.setImageUrl("http://127.0.0.1:8080\\image\\" + foster.getImageUrl());

        foster.setVaccine(0);

        System.out.println(foster);

        int i = iFosterService.insertOne(foster);

        if (i == 0) {
            return R.fail("申请失败");
        }

        return R.success("申请成功");

    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        System.out.println(file);

        String uploadDir = "D:\\image\\";
        // 创建文件夹（如果不存在）
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // 在指定目录创建文件
            String fileName = file.getOriginalFilename();
            String filePath = uploadDir + fileName;
            File targetFile = new File(filePath);
            file.transferTo(targetFile);
        } catch (IOException e) {
            return R.fail("照片上传失败");
        }

        return R.success("成功");
    }

    @GetMapping("/list")
    public Result list() {
        return R.success(iFosterService.getList());
    }

    @PutMapping("/{id}")
    public Result updateOne(@PathVariable("id") Integer id) {

        int i = iFosterService.updateOneById(id);

        if (i == 0) {
            return R.fail("操作失败");
        }

        Foster foster = iFosterService.selectById(id);
        Adopt adopt = new Adopt();
        adopt.setPetName(foster.getPetName());
        adopt.setPetType(foster.getPetType());
        adopt.setVaccine(0);
        adopt.setImageURL(foster.getImageUrl());
        System.out.println(foster);
        System.out.println(adopt);
        iAdoptService.insertOne(adopt);

        return R.success("操作成功");

    }


}
