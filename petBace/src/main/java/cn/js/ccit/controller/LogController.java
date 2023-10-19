package cn.js.ccit.controller;

import cn.js.ccit.entity.Log;
import cn.js.ccit.service.ILogService;
import cn.js.ccit.utils.R;
import cn.js.ccit.utils.Result;
import io.swagger.annotations.Api;
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
 * @since 2023-07-08
 */
@Api(tags = "日志模块")
@CrossOrigin
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private ILogService iLogService;

    @GetMapping("/list")
    public Result getList(@RequestParam String username) {

        return R.success(iLogService.getListByUserName(username));

    }


    @PostMapping("/upload")
    public Result upload(@RequestParam("files") MultipartFile[] files,
                         @RequestParam("context") String context,
                         @RequestParam("username") String username) {

        String uploadDir = "D:\\image\\";
        int i = 0;

        // 创建文件夹（如果不存在）
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        System.out.println(context);

        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = file.getOriginalFilename();
                        String filePath = uploadDir + fileName;
                        File targetFile = new File(filePath);
                        file.transferTo(targetFile);
                        System.out.println(fileName);

                        filePath = "http://127.0.0.1:8080\\image\\" + fileName;
                        Log log = new Log();
                        log.setUsername(username);
                        log.setImageUrl(filePath);
                        log.setDescription(context);

                        i = iLogService.insertOne(log);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (i == 0) {
            return R.fail("发布失败");
        }

        return R.success("发布成功");

    }

    @PostMapping("/update2")
    public Result updateOne2(@RequestParam("files") MultipartFile[] files,
                         @RequestParam("context") String context,
                         @RequestParam("id") Integer id) {

        String uploadDir = "D:\\image\\";
        int i = 0;

        // 创建文件夹（如果不存在）
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        System.out.println(context);

        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = file.getOriginalFilename();
                        String filePath = uploadDir + fileName;
                        File targetFile = new File(filePath);
                        file.transferTo(targetFile);
                        System.out.println(fileName);

                        filePath = "http://127.0.0.1:8080\\image\\" + fileName;
                        Log log = new Log();
                        log.setId(id);
                        log.setImageUrl(filePath);
                        log.setDescription(context);

                        i = iLogService.updateOne1(log);


                    } catch (IOException e) {
                    e.printStackTrace();
                }
                }
            }
        }

        if (i == 0) {
            return R.fail("修改失败");
        }

        return R.success("修改成功");

    }

    @PostMapping("/update1")
    public Result updateOne(@RequestBody Log log) {

        System.out.println(log);


        int i = iLogService.updateOne1(log);

        if(i == 0) {
            return R.fail("修改失败");
        }

        return R.success("修改成功");

    }

    @DeleteMapping("/{id}")
    public Result deleteOneById(@PathVariable("id") Integer id) {

        int i = iLogService.deleteOne(id);

        if(i == 0) {
            return R.fail("删除失败");
        }

        return R.success("删除成功");

    }



}
