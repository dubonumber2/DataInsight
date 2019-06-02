package com.ksrs.utils;

import com.ksrs.entity.Result;
import com.ksrs.entity.Statistics_zh;
import org.apache.poi.hssf.usermodel.*;

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
public class DowloadMongo {
    public static void dowload(HttpServletResponse response, List<Statistics_zh> list){
        OutputStream os=null;
        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd-HH-mm");
            String downFileName ="Mongo to Mysql"+sdf.format(new Date())+".xls";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + new String(downFileName.getBytes(), "UTF-8") + "\"");
            //查出所有的投资记录
            //导出Excel
            os = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String [] title={ "数据源",  "MongoDB总量","Mysql总量","MongoDB增量","Mysql增量","增量的误差数","MongoDB最新时间", "统计时间"};
            //String [] params={"province","nats","natsp","natcs","natso","cumy","cmpd","nrcp","nrcd","ambd","hpho","htel","procov","ncm","cdc","bcs","pc","fc","ct"};
            HSSFRow xssfR = sheet.createRow(0);
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            for (int j = 0; j < title.length; j++) {
                HSSFCell xssfCell = xssfR.createCell(j);
                xssfCell.setCellValue(title[j]);
            }
            for (int i = 0; i < list.size(); i++) {
               Statistics_zh statistics_zh=list.get(i);
                Object[] params1={statistics_zh.getType(),statistics_zh.getMongoCount(),statistics_zh.getMysqlCount(),statistics_zh.getMongoIncrement(),statistics_zh.getMysqlIncrement(),statistics_zh.getErrorCount(),statistics_zh.getMongoNewTime(),statistics_zh.getOverTime()};

                // 创建Excel的sheet的一行
                int r=i+1;
                HSSFRow xssfRow = sheet.createRow(r);
                for (int j = 0; j < params1.length; j++) {

                    Object cell =params1[j];
                    // 创建一个Excel的单元格
                    HSSFCell xssfCell = xssfRow.createCell(j);
                    if(cell!=null){
                        if(cell instanceof String){
                            xssfCell.setCellValue(cell.toString());
                        }else if(cell instanceof Integer){
                            xssfCell.setCellValue(((Integer) cell).intValue());
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
