package org.scauhci.official.util;

import java.awt.image.BufferedImage;
import java.io.File;

import org.nutz.img.Images;

public class ImageZip {

	/**
	 * 
	 * @param oldFile
	 *            :源文件
	 * @param filePath
	 *            :压缩后的文件路径
	 * @param fileName
	 *            :压缩后的文件名
	 * @return :压缩结果
	 */
	public static boolean zipImageFile(String oldFile, String filePath,
			String fileName) {

		if (oldFile == null) {
			return false;
		}
		/** 对服务器上的临时文件进行处理 */
		BufferedImage sourceImage = Images.read(oldFile);
		if (sourceImage == null) {
			return false;
		}
		int sourceImageWidth = sourceImage.getWidth(), sourceImageHeight = sourceImage
				.getHeight();
		/** 设定压缩大小 */
		int newImageWidth = 180, newImageHeight = newImageWidth
				* sourceImageHeight / sourceImageWidth;

		File newImageFile = new File(filePath + File.separator + fileName);
		BufferedImage newImage = Images.zoomScale(sourceImage, newImageWidth,
				newImageHeight);
		Images.write(newImage, newImageFile);
		return true;
	}
	
	public static void main(String[] args) {
		File file = new File("P1080349.jpg");
		BufferedImage bufImg = Images.read(file);
		int sourceImgWidth = bufImg.getWidth(), sourceImgHeight = bufImg
				.getHeight();
		int destImgWidth = sourceImgWidth / 2, destImgHeight = destImgWidth
				* sourceImgHeight / sourceImgWidth;
		BufferedImage newImg = Images.zoomScale(bufImg, destImgWidth,
				destImgHeight);
		Images.writeJpeg(newImg, new File("newFile.jpg"), 0.5f);
		// System.out.println(bufImg.getHeight());
	}
}
