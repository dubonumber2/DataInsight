package com.ksrs.utils;

import com.ksrs.entity.Result;
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
public class DowloadUtils2 {
    public static void dowload(HttpServletResponse response, List<Result> list){
        OutputStream os=null;
        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd-HH-mm");
            String downFileName ="全国工商实体统计2"+sdf.format(new Date())+".xls";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + new String(downFileName.getBytes(), "UTF-8") + "\"");
            //查出所有的投资记录
            //导出Excel
            os = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String [] title={ "省份",  "国家统计总(万)",    "国家统计个体工商(万)",    "国家统计企业(万)",   "KSRS库内统计(万户)","获取占比","KSRS库内有电话数(户)","电话数量占比","国家统计数据源"};
            //String [] params={"province","nats","natsp","natcs","natso","cumy","cmpd","nrcp","nrcd","ambd","hpho","htel","procov","ncm","cdc","bcs","pc","fc","ct"};
            HSSFRow xssfR = sheet.createRow(0);
            for (int j = 0; j < title.length; j++) {
                HSSFCell xssfCell = xssfR.createCell(j);
                xssfCell.setCellValue(title[j]);
            }
            for (int i = 0; i < list.size(); i++) {
                Result result=list.get(i);
                Object[] params1={result.getProvince(),result.getNats(),result.getNatsp(),
                        result.getNatcs(),result.getNatso(),
                       result.getProcov(),result.getHtel(),result.getPc(),result.getFc()};

                // 创建Excel的sheet的一行
                int r=i+1;
                HSSFRow xssfRow = sheet.createRow(r);
                for (int j = 0; j < params1.length; j++) {

                    Object cell =params1[j];
                    // 创建一个Excel的单元格
                    HSSFCell xssfCell = xssfRow.createCell(j);
                    if(cell!=null){
                        xssfCell.setCellValue(cell.toString());
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
