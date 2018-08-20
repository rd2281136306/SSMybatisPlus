package com.pinyougou.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * @author: 
 * 描述: TODO
 * @date: 
 * @version: 
 */
public class ExcelUtil {
	
    //excel默认宽度；  
    private static int width = 256*14;  
    //默认字体  
    private static String excelfont = "微软雅黑";  
      
    /** 
     *  
     * @param excelName  导出的EXCEL名字 
     * @param sheetName  导出的SHEET名字  当前sheet数目只为1 
     * @param headers      导出的表格的表头 
     * @param ds_titles    导出的数据 map.get(key) 对应的 key 
     * @param ds_format    导出数据的样式 
     *                          1:String left;  
     *                          2:String center    
     *                          3:String right 
     *                          4 int  right 
     *                          5:float ###,###.## right  
     *                          6:number: #.00% 百分比 right 
     * @param widths      表格的列宽度  默认为 256*14(数组为null时为默认宽度)
     * @param data        数据集  List<Map> 
     * @param response 
     * @throws IOException 
     */  
    @SuppressWarnings("deprecation")
	public static void export(String excelName, String sheetName,String[] headers,String[] ds_titles,int[] ds_format,int[] widths, List<Map<String,Object>> data ,HttpServletRequest request, HttpServletResponse response) throws IOException {  
        HttpSession session = request.getSession();    
        session.setAttribute("state", null);    
        if(widths==null){  
              widths = new int[ds_titles.length];  
              for(int i=0;i<ds_titles.length;i++){  
                  widths[i]=width;  
              }  
          }  
          if(ds_format==null){  
              ds_format = new int[ds_titles.length];  
              for(int i=0;i<ds_titles.length;i++){  
                  ds_format[i]=1;  
              }  
          }  
           //设置文件名  
            String fileName = "";  
            if(StringUtils.isNotEmpty(excelName)){  
                fileName = excelName;  
            }  
            //创建一个工作薄  
            HSSFWorkbook wb = new HSSFWorkbook();  
            //创建一个sheet  
            HSSFSheet  sheet = wb.createSheet(StringUtils.isNotEmpty(sheetName)?sheetName:"excel");  
            //创建表头，如果没有跳过  
            int headerrow = 0;  
            if(headers!=null){  
                HSSFRow  row = sheet.createRow(headerrow);  
                //表头样式  
                HSSFCellStyle style = wb.createCellStyle();    
                HSSFFont font = wb.createFont();  
                /*
                 *  示例：字体设置为幼圆、9px、颜色黄色、加粗、斜体、下划线、删除线作为示例
                 *  font.setFontName("幼圆");
					font.setFontHeightInPoints((short)9);
					font.setColor(HSSFColor.YELLOW.index);
					font.setBoldweight(font.BOLDWEIGHT_BOLD);
					font.setItalic(true);
					font.setStrikeout(true);
					font.setUnderline((byte)1);
                 */
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
                font.setFontName(excelfont);  
                font.setFontHeightInPoints((short) 11);  
                /*
                 * 单元格样式：
                 *  1.单元格边框分为上、下、左、右四部分，可以设置其边框的宽度、样式及颜色。边框默认为无边框，若加上边框默认为黑色。
				           现在为一行10个单元格全部加上边框（细），并设置颜色为红色
				    //设置上下左右四个边框宽度
					style.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
					style.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
					style.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
					style.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
					//设置上下左右四个边框颜色
					style.setTopBorderColor(HSSFColor.RED.index);
					style.setBottomBorderColor(HSSFColor.RED.index);
					style.setLeftBorderColor(HSSFColor.RED.index);
					style.setRightBorderColor(HSSFColor.RED.index); 
				
					2.单元格背景色填充涉及到填充颜色和填充方式，现以最常用的填充方式填充天蓝色背景。
					style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
					style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
					
					3.单元格的对齐方式是针对单元格中的内容，单元格中的内容可以靠左、靠右、靠上、靠下、以及垂直居中、水平居中等等。
					style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//靠左			
					style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//靠右
					style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);//垂直靠上
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);//垂直靠下
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_JUSTIFY);//垂直平铺
					style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);//跨列居中
					style.setAlignment(HSSFCellStyle.ALIGN_FILL);//填充
					style.setAlignment(HSSFCellStyle.ALIGN_GENERAL);//普通默认
					style.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);//两端对齐
					style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//水平居中且垂直居中
					style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
					
					4.数据格式化：
					第一种：日期格式
					style.setDataFormat(format.getFormat("yyyy年m月d日"));
  					第二种：保留两位小数格式
            		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
     				第三种：货币格式      
            		style.setDataFormat(format.getFormat("¥#,##0"));
           			第四种：百分比格式
           			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
            		第五种：中文大写格式
 					style.setDataFormat(format.getFormat("[DbNum2][$-804]0"));
          			第六种：科学计数法格式
            		style.setDataFormat( HSSFDataFormat.getBuiltinFormat("0.00E+00"));
 					
 					5.设置宽高(需转换下)：
 					高 单位：15.625  例：10px = 15.625*10
 					宽 单位：35.7  例：10px = 35.7*10
 					将Excel的第一、二行设置为高度为40px（两种方法），A列宽度为80px
 					HSSFRow row0 = sheet.createRow(0);
					HSSFRow row1 = sheet.createRow(1);
					//设置行高40px
					row0.setHeight((short)(15.625*40));
					row1.setHeightInPoints((float)40);
					//设置列宽100px
					sheet.setColumnWidth(0, (int)35.7*100);	
				     
                 */
                style.setFont(font);  
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
                 for (int i = 0; i < headers.length; i++) {    
                    sheet.setColumnWidth((short)i,(short)widths[i]);   
                    HSSFCell cell = row.createCell(i);    
                    cell.setCellValue(headers[i]);    
                    cell.setCellStyle(style);    
                }    
                headerrow++;  
            }  
            //表格主体  解析list  
            if(data != null){  
                List<HSSFCellStyle> styleList = new ArrayList<HSSFCellStyle>();  
                  
                for (int i = 0; i <ds_titles.length; i++) {  //列数  
                    HSSFCellStyle style = wb.createCellStyle();    
                    HSSFFont font = wb.createFont();  
                    font.setFontName(excelfont);  
                    font.setFontHeightInPoints((short) 10);  
                    style.setFont(font);  
                    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                    style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                    style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
                    if(ds_format[i]==1){  
                        style.setAlignment(HSSFCellStyle.ALIGN_LEFT);    
                    }else if(ds_format[i]==2){  
                        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
                    }else if(ds_format[i]==3){  
                        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);   
                         //int类型  
                    }else if(ds_format[i]==4){  
                        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);   
                         //int类型  
                        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));     
                    }else if(ds_format[i]==5){  
                        //float类型  
                        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);   
                        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));     
                    }else if(ds_format[i]==6){  
                        //百分比类型  
                        style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);   
                        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));    
                    }  
                    styleList.add(style);  
                }  
                for (int i = 0; i < data.size() ; i++) {  //行数  
                    HSSFRow  row = sheet.createRow(headerrow);  
                    Map<String,Object> map = data.get(i);  
                    for (int j = 0; j <ds_titles.length; j++) {  //列数  
                         HSSFCell cell = row.createCell(j);    
                         Object o = map.get(ds_titles[j]);  
                         if(o==null||"".equals(o)){  
                             cell.setCellValue("");  
                         }else if(ds_format[j]==4){  
                             //int  
                             cell.setCellValue((Long.valueOf((map.get(ds_titles[j]))+"")).longValue());   
                         }else if(ds_format[j]==5|| ds_format[j]==6){  
                             //float  
                             cell.setCellValue((Double.valueOf((map.get(ds_titles[j]))+"")).doubleValue());   
                         }else {  
                             cell.setCellValue(map.get(ds_titles[j])+"");   
                         }  
                           
                         cell.setCellStyle((HSSFCellStyle)styleList.get(j));    
                    }  
                    headerrow++;  
                }  
            }  
             
            fileName=fileName+".xls";  
            String filename = "";  
            try{  
               filename =encodeChineseDownloadFileName(request,fileName);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
//          final String userAgent = request.getHeader("USER-AGENT");  
//            if(userAgent.indexOf( "MSIE")!=-1){//IE浏览器  
//              filename = URLEncoder.encode(fileName,"UTF8");  
//            }else if(userAgent.indexOf( "Mozilla")!=-1){//google,火狐浏览器  
//              filename = new String(fileName.getBytes(), "ISO8859-1");  
//            }else{  
//              filename = URLEncoder.encode(fileName,"UTF8");//其他浏览器  
//            }  
              
            response.setHeader("Content-disposition", filename);  
            response.setContentType("application/vnd.ms-excel");    
            response.setHeader("Content-disposition", "attachment;filename="+filename);    
            response.setHeader("Pragma", "No-cache");  
            OutputStream ouputStream = response.getOutputStream();    
            wb.write(ouputStream);    
            ouputStream.flush();    
            ouputStream.close();  
            session.setAttribute("state", "open");  
              
    }  
      
    /**  
     * 对文件流输出下载的中文文件名进行编码 屏蔽各种浏览器版本的差异性  
     * @throws UnsupportedEncodingException   
     */    
    public static String encodeChineseDownloadFileName(    
            HttpServletRequest request, String pFileName) throws Exception {    
            
         String filename = null;      
            String agent = request.getHeader("USER-AGENT");      
            if (null != agent){      
                if (-1 != agent.indexOf("Firefox")) {//Firefox      
                    filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))+ "?=";      
                }else if (-1 != agent.indexOf("Chrome")) {//Chrome      
                    filename = new String(pFileName.getBytes(), "ISO8859-1");      
                } else {//IE7+      
                    filename = java.net.URLEncoder.encode(pFileName, "UTF-8");      
                    filename = filename.replace("+", "%20");  
                }      
            } else {      
                filename = pFileName;      
            }      
            return filename;     
    }    
 
	
	public static Workbook createWorkBook(List<Map<String, Object>> list, String[] columnNames) {
		// 创建excel工作簿
		Workbook wb = new HSSFWorkbook();

		// 创建第一个sheet（页），并命名
		Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
		String[] keys = (String[]) list.get(0).get("keys");
		// 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。

		for (int i = 0; i < keys.length; i++) {
			sheet.setColumnWidth((short) i, (short) (35.7 * 150));
		}

		// 创建第一行
		Row row = sheet.createRow((short) 0);

		// 创建两种单元格格式
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();

		// 创建两种字体
		Font f = wb.createFont();
		Font f2 = wb.createFont();

		// 创建第一种字体样式（用于列名）
		f.setFontHeightInPoints((short) 10);
		f.setColor(IndexedColors.BLACK.getIndex());
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);

		// 创建第二种字体样式（用于值）
		f2.setFontHeightInPoints((short) 10);
		f2.setColor(IndexedColors.BLACK.getIndex());

		// Font f3=wb.createFont();
		// f3.setFontHeightInPoints((short) 10);
		// f3.setColor(IndexedColors.RED.getIndex());

		// 设置第一种单元格的样式（用于列名）
		cs.setFont(f);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setAlignment(CellStyle.ALIGN_CENTER);

		// 设置第二种单元格的样式（用于值）
		cs2.setFont(f2);
		cs2.setBorderLeft(CellStyle.BORDER_THIN);
		cs2.setBorderRight(CellStyle.BORDER_THIN);
		cs2.setBorderTop(CellStyle.BORDER_THIN);
		cs2.setBorderBottom(CellStyle.BORDER_THIN);
		cs2.setAlignment(CellStyle.ALIGN_CENTER);
		// 设置列名
		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(cs);
		}
		// 设置每行每列的值
		for (short i = 1; i < list.size(); i++) {
			// Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
			// 创建一行，在页sheet上
			Row row1 = sheet.createRow((short) i);
			// 在row行上创建一个方格
			for (short j = 0; j < keys.length; j++) {
				Cell cell = row1.createCell(j);
				cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]).toString());
				cell.setCellStyle(cs2);
			}
		}
		return wb;
	}

	/*public <T> List<Map<String, Object>> createExcelRecord(List<T> useCases) {
	    Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		Class cls = (Class) params[0]; 
	//	Class cls = GenericsUtils.getSuperClassGenricType();
	//	Class cls = UseCase.class;
		Type type = getClass().getGenericSuperclass();
		if(!(type instanceof ParameterizedType)){
		    type = getClass().getSuperclass().getGenericSuperclass();
		}
		@SuppressWarnings("unchecked")
		Class<T> cls = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
		String[] ks = new String[100];
		Field[] fields = cls.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			String s = f.getName();
			ks[i] = s;
		}
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		map.put("keys", ks);
		listmap.add(map);
		//UseCase useCase = null;
		UseCase useCase=null;
		for (int j = 0; j < useCases.size(); j++) {
			useCase = (UseCase) useCases.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put(ks[0], useCase.getId());
			mapValue.put(ks[1], useCase.getName());
			mapValue.put(ks[2], useCase.getAge());
			listmap.add(mapValue);
		}
		return listmap;
	}
*/
	
	public static void wirteExcel(ByteArrayOutputStream os, HttpServletResponse response, HttpServletRequest request,
			String fileName) throws IOException {
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}
	
	
	

}
