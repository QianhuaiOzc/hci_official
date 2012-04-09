package org.scauhci.official.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintImage {
	public static  void writePhoto(String photoBase, String name,boolean thumb, HttpServletRequest request, HttpServletResponse response) {

        if (!photoBase.endsWith("/")) {
            photoBase += '/';
        }
        StringBuilder sb = new StringBuilder(photoBase);  
        sb.append(thumb ? "thumb_" : "");
        sb.append(name);
        String[] suffix = new String[]{
            ".jpg", ".png", ".JPG", ".PNG"
        };
        for (String s : suffix) {
            File file = new File(sb.toString() + s);
            if (file.exists()) {
                //write photo to the stream
                write(file, response, request.getSession().getServletContext());
                return;
            }
        }
        write(new File(photoBase +  "user.jpg"), response, request.getSession().getServletContext());

    }

    private static  void write(File file, HttpServletResponse response, ServletContext servletContext) {
        response.setContentType(getMIME(file.getAbsolutePath(), servletContext));
        response.setContentLength((int) file.length());
        OutputStream out = null;
        InputStream in = null;
        try {
            out = response.getOutputStream();
            in = new FileInputStream(file);
            int len;
            byte[] buff = new byte[1024 * 5];
            while ((len = in.read(buff)) > 0) {
                out.write(buff, 0, len);
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    private static  String getMIME(String photo, ServletContext servletContext) {
        return servletContext.getMimeType(photo);
    }
}
