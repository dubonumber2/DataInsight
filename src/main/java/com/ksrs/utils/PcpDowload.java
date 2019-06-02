package com.ksrs.utils;

import com.ksrs.entity.User_operation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 */
public class PcpDowload {
    public static void dowload(HttpServletResponse response, List<User_operation> list){
        OutputStream os=null;
        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd-HH-mm");
            String downFileName ="cluemining_pcp_user"+sdf.format(new Date())+".xls";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + new String(downFileName.getBytes(), "UTF-8") + "\"");
            //查出所有的投资记录
            //导出Excel
            os = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String [] title={"所属公司","账户","用户名","操作类型","操作详情","下载量","操作时间","统计时间"};
            HSSFRow xssfR = sheet.createRow(0);
            xssfR.setHeight((short)600);
            for (int j = 0; j < title.length; j++) {
                HSSFCell xssfCell = xssfR.createCell(j);
                xssfCell.setCellValue(title[j]);
            }
            sheet.setColumnWidth(0,50*256);
            for (int i = 0; i < list.size(); i++) {
             User_operation user=list.get(i);
                Object[] params1={user.getUser_company(),user.getUser_name(),user.getRealname(),user.getOperation_name(),user.getOperation_explain(),user.getDowloadcount(),user.getOperation_time(),user.getStatistic_time()};
                // 创建Excel的sheet的一行
                int r=i+1;
                HSSFRow xssfRow = sheet.createRow(r);
                sheet.setColumnWidth(r,25*256);
                for (int j = 0; j < params1.length; j++) {
                    Object cell =params1[j];
                    // 创建一个Excel的单元格
                    HSSFCell xssfCell = xssfRow.createCell(j);
                    if(cell!=null){
                        if(cell instanceof String) {
                            xssfCell.setCellValue(cell.toString());
                        }else if(cell instanceof Integer){
                            xssfCell.setCellValue(((Integer) cell).intValue());
                        }else{
                            xssfCell.setCellValue(cell.toString());
                        }
                    }else{
                        xssfCell.setCellValue("");
                    }

                }
            }
            wb.write(os);
        } catch (UnsupportedEncodingException e) {

        } catch (IOException e) {

        }finally{

            try {
                os.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
