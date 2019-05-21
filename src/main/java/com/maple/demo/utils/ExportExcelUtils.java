package com.maple.demo.utils;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 通用的导出excel
 * @author Feng
 *
 */
public class ExportExcelUtils {
    /**
     * 这是一个通用的方法，导出excel，后缀为.xls，暂未实现添加图片的导出
     *
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,类型为List<Map<String, Object>>
     * @param keyList
     *            Map集合中的对应的key
     * @param out
     *            可以将EXCEL文档导出到本地文件或者网络中
     */
    public static void exportExcel2003(String title, String[] headers,
          List<Map<String, Object>> dataset, String[] keyList, OutputStream out) {
       // 声明一个工作薄
       HSSFWorkbook workbook = new HSSFWorkbook();
       // 生成一个表格
       HSSFSheet sheet = workbook.createSheet(title);
       // 设置表格默认列宽度为15个字节
       sheet.setDefaultColumnWidth((int) 16);
       // 生成一个样式
       HSSFCellStyle style = workbook.createCellStyle();
       // 设置这些样式
       style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
       style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
       style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       style.setBorderRight(HSSFCellStyle.BORDER_THIN);
       style.setBorderTop(HSSFCellStyle.BORDER_THIN);
       style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
       // 生成一个字体
       HSSFFont font = workbook.createFont();
       font.setColor(HSSFColor.VIOLET.index);
       font.setFontHeightInPoints((short) 12);
       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
       // 把字体应用到当前的样式
       style.setFont(font);
       // 生成并设置另一个样式
       HSSFCellStyle style2 = workbook.createCellStyle();
       style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
       style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
       style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
       style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
       style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
       style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
       style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       // 生成另一个字体
       HSSFFont font2 = workbook.createFont();
       font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
       // 把字体应用到当前的样式
       style2.setFont(font2);

       // 声明一个画图的顶级管理器
//	       HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
       // 定义注释的大小和位置,详见文档
//	       HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
       // 设置注释内容
//	       comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
       // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
//	       comment.setAuthor("leno");

       //产生表格标题行
       HSSFRow row = sheet.createRow(0);
       for (int i = 0; i < headers.length; i++) {
          HSSFCell cell = row.createCell(i);
          cell.setCellStyle(style);
          HSSFRichTextString text = new HSSFRichTextString(headers[i]);
          cell.setCellValue(text);
       }

       //循环放置表格中的值
       for(int i = 0; i<dataset.size(); i++){
           row = sheet.createRow(i + 1);
           //产生编号，1,2,3,4,5...的递增编号，不需要，header去掉编号，这里注释掉就可以 
           row.createCell(0).setCellValue(i+1+"");
           Map<String, Object> obj=dataset.get(i); 
           for(int j = 0; j < keyList.length; j ++){
               if(obj.get(keyList[j]) != null){ row.createCell(j+1).setCellValue(obj.get(keyList[j])+""); }
           }
       }

       try {
          workbook.write(out);
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
    /**
     * 这是一个通用的方法，导出excel2007版，后缀为.xlsx。暂未实现添加图片的导出
     * 不支持WPS，不知道不为什么，在找原因。
     *
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,类型为List<Map<String, Object>>
     * @param keyList
     *            Map集合中的对应的key
     * @param out
     *            可以将EXCEL文档导出到本地文件或者网络中
     */
    public static void exportExcel2007(String title, String[] headers,
          List<Map<String, Object>> dataset, String[] keyList, OutputStream out) {
       // 声明一个工作薄
       XSSFWorkbook workbook = new XSSFWorkbook();
       // 生成一个表格
       XSSFSheet sheet = workbook.createSheet(title);
       // 设置表格默认列宽度为15个字节
       sheet.setDefaultColumnWidth((int) 16);
       // 生成一个样式
       XSSFCellStyle style = workbook.createCellStyle();
       // 设置这些样式
       style.setFillForegroundColor(new XSSFColor(new Color(181,181,181)));
       style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
       style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
       style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
       style.setBorderRight(XSSFCellStyle.BORDER_THIN);
       style.setBorderTop(XSSFCellStyle.BORDER_THIN);
       style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
       // 生成一个字体
       XSSFFont font = workbook.createFont();
       font.setColor(new XSSFColor(new Color(181,181,181)));
       font.setFontHeightInPoints((short) 12);
       font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
       // 把字体应用到当前的样式
       style.setFont(font);
       // 生成并设置另一个样式
       XSSFCellStyle style2 = workbook.createCellStyle();
       style2.setFillForegroundColor(new XSSFColor(new Color(181,181,181)));
       style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
       style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
       style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
       style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
       style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
       style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
       style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
       // 生成另一个字体
       XSSFFont font2 = workbook.createFont();
       font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
       // 把字体应用到当前的样式
       style2.setFont(font2);

       //产生表格标题行
       XSSFRow row = sheet.createRow(0);
       for (int i = 0; i < headers.length; i++) {
          XSSFCell cell = row.createCell(i);
          cell.setCellStyle(style);
          XSSFRichTextString text = new XSSFRichTextString(headers[i]);
          cell.setCellValue(text);
       }

       //循环放置表格中的值
       for(int i = 0; i<dataset.size(); i++){
           row = sheet.createRow(i + 1);
           //产生编号，1,2,3,4,5...的递增编号，不需要，header去掉编号，这里注释掉就可以 
           row.createCell(0).setCellValue(i+1+"");
           Map<String, Object> obj=dataset.get(i); 
           for(int j = 0; j < keyList.length; j ++){
               if(obj.get(keyList[j]) != null){ 
            	   row.createCell(j+1).setCellValue(obj.get(keyList[j])+""); 
               }
           }
       }

       try {
          workbook.write(out);
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
    
}
