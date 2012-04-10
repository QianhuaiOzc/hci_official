package org.scauhci.official.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class ImageZip {

	 /**
    *
    * @param oldFile :源文件
    * @param filePath :压缩后的文件路径
    * @param fileName :压缩后的文件名
    * @return :压缩结果
    */
   public static boolean  zipImageFile(String oldFile, String filePath,String fileName) {

       if (oldFile == null) {
           return false;
       }
       String newImage = null;
       int height;
       int width;
       float quality=5000f;
       try {
           /** 对服务器上的临时文件进行处理 */
            System.err.println(oldFile);
           Image srcFile = ImageIO.read(new File(oldFile));
          if(srcFile==null){
              return false;
           }
           int w = srcFile.getWidth(null);
           System.out.println(w);
           int h = srcFile.getHeight(null);
           System.out.println(h);
           /**设定压缩大小  */
           width=180;
           height=width*h/w;

           /** 宽,高设定 */
           BufferedImage tag = new BufferedImage(width, height,
                   BufferedImage.TYPE_INT_RGB);
           tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
           
           /** 压缩后的文件名 */
           newImage = filePath+"/"+fileName;

           /** 压缩之后临时存放位置 */
           FileOutputStream out = new FileOutputStream(newImage);

           JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
           JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
           /** 压缩质量 */
           jep.setQuality(quality, true);
           encoder.encode(tag, jep);
           out.close();

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return true;
   }
}
