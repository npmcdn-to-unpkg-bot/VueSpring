package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by mosl on 16/9/7.
 */
@Controller
public class DownloadController {

    @RequestMapping(value="/download-resource")
    public void downloadResource(HttpServletResponse response, HttpServletRequest request) {
        // 文件保存在/WEB_INF/data目录下
        String dataDirectory = request.
                getServletContext().getRealPath("/WEB-INF/data");
        File file = new File(dataDirectory, "hello.mp4");
        if (file.exists()) {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition",
                    "attachment; filename=hello.mp4");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            // if using Java 7, use try-with-resources
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (IOException ex) {
                // do something,
                // probably forward to an Error page
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}
