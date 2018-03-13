package com.xiao.web.controller;

import com.xiao.bean.LocalFile;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 〈文件服务〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 12:04
 * @since 1.0.0
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "D:\\projects\\MyGitHub\\xiao-security\\xiao-security-demo\\src\\main\\java\\com.xiao\\web\\controller";

    @PostMapping
    public LocalFile upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return new LocalFile(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }

}
