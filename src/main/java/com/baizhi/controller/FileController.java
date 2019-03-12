package com.baizhi.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
class FileController {
    //上传
    @RequestMapping("upload")
    public void upchuan(MultipartFile file, HttpServletRequest request)throws Exception{
        MultipartFile file1=file;
        String filename = file.getOriginalFilename();//文件名
        String url="F:\\";//保存url
        File file2 = new File(url, filename);//得到新的文件
        InputStream inputStream = file1.getInputStream();//得到原始文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file2);//新的输出流
        IOUtils.copy(inputStream,fileOutputStream);//提交
        //关流
        inputStream.close();
        fileOutputStream.close();
        System.out.println("上传成功");
    }
    @RequestMapping("download")
    public void download(HttpServletResponse res) {
        String fileName = "1.png";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("G://"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("下载成功");
    }

}
