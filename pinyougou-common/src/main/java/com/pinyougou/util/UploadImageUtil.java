package com.pinyougou.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author:  
 * 描述: TODO 上传照片到服务器
 * @date: 
 * @version: 
 */
public class UploadImageUtil {

	/**
	 * @Description: 对图片的重新命名
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param frontFileData
	 * @return
	 * @return: String
	 */
	public static String reName(MultipartFile frontFileData) {
		String fileName = frontFileData.getOriginalFilename();
		String extendsionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		String newFileName = String.valueOf(System.currentTimeMillis() + "." + extendsionName);
		return newFileName;
	}

	/**
	 * 
	 * @Description: TODO
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param newFileName
	 *            文件名称
	 * @param filedata
	 *            文件内容
	 * @param picDir
	 *            存放路径
	 * @return: void
	 */
	public static void saveFile(String fileName, MultipartFile filedata, String picDir) {
		// 从配置文件中获取图片的存放路径和获取地址
		// Properties properties =PropertiesUtil.
		String saveFilePath = picDir;
		File fileDir = new File(saveFilePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
			fileDir.setReadable(true);
			fileDir.setWritable(true);
		}
		try {
			FileOutputStream out = new FileOutputStream(
					saveFilePath /* + File.separator */ + fileName);
			out.write(filedata.getBytes());
			// 对文件存放在服务器上市设置为可读，可写
			Runtime.getRuntime()
					.exec("chmod 777 " + saveFilePath /* + File.separator */ + fileName);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: TODO 删除路径下文件的操作
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param fileName
	 *            文件名称
	 * @param pathDir
	 *            文件路劲
	 * @return: void
	 */
	public static void deleteFile(String fileName, String pathDir) {
		File fileDir = new File(pathDir + "/" + fileName);
		if (fileDir.exists()) {
			fileDir.delete();
		}
	}

	public static void deleteFileUrl(String url) {
		File fileDir = new File(url);
		if (fileDir.exists()) {
			fileDir.delete();
		}
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	public static void main(String[] args) {
		deleteFile("E:\\esign\\sscc.pdf");
	}
	
	/**
	 * @Description: 根据文件路劲获取文件头部信息
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param filePath
	 * @return
	 * @return: String
	 */
	public static String getFileHeader(String filePath) {
		FileInputStream is = null;
		String value = null;
		try {
			is = new FileInputStream(filePath);
			byte[] b = new byte[4];
			/*
			 * int read() 从此输入流中读取一个数据字节。int read(byte[] b) 从此输入流中将最多 b.length
			 * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len)
			 * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
			 */
			is.read(b, 0, b.length);
			value = bytesToHexString(b);
		} catch (Exception e) {
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return value;
	}

	/**
	 * @Description: 根据文件流获取文件信息
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param is
	 * @return
	 * @return: String
	 */
	public static String getFileHeaderByFileInputStream(FileInputStream is) {
		String value = null;
		try {
			byte[] b = new byte[4];
			/*
			 * int read() 从此输入流中读取一个数据字节。int read(byte[] b) 从此输入流中将最多 b.length
			 * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len)
			 * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
			 */
			is.read(b, 0, b.length);
			value = bytesToHexString(b);
		} catch (Exception e) {
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return value;
	}

	/**
	 * @Description: 将要读取文件头信息的byte数组转换成string类型表示
	 * @author: 
	 * @date: 
	 * @version: 
	 * @param src
	 * @return
	 * @return: String
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder builder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		String hv;
		// 只取前四位
		for (int i = 0; i < (src.length > 4 ? 4 : src.length); i++) {
			// 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
			hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
			if (hv.length() < 2) {
				builder.append(0);
			}
			builder.append(hv);
		}
		// System.out.println(builder.toString());
		return builder.toString();
	}

/*	public static void main(String[] args) throws Exception {
		
		 * //测试1...根据文件全路径 final String fileType =
		 * getFileType("E:\\服务申请模板.xlsx"); System.out.println(fileType);
		 

		// 测试2...根据流
		FileInputStream is = null;
		is = new FileInputStream(new File("E:\\QQ图片20170604214454.jpeg"));
		final String fileType2 = getFileHeaderByFileInputStream(is);
		System.out.println(fileType2);
	}*/
}
