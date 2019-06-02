package com.ksrs.utils;

import com.ksrs.entity.Result;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;

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
public class DowloadUtils {
    public static void dowload(HttpServletResponse response, List<Result> list){
        OutputStream os=null;
        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd-HH-mm");
            String downFileName ="全国工商实体统计"+sdf.format(new Date())+".xls";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + new String(downFileName.getBytes(), "UTF-8") + "\"");
            //查出所有的投资记录
            //导出Excel
            os = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String [] title={ "省份",  "国家统计总(万)",    "国家统计个体工商(万)",    "国家统计企业(万)",   "其它(万)",   "库内线索","线索挖掘数量","完整数据(电话&经营范围&法人或联系人)", "正常公司"  ,  "正常且数据完整", "有百度标签的公司","有手机"                ,"有固话",     "产品覆盖率",       "正常公司覆盖率",     "公司完整数据覆盖率",   "百度客户占比",  "手机覆盖率"    , "固话覆盖率","统计时间"};
            //String [] params={"province","nats","natsp","natcs","natso","cumy","cmpd","nrcp","nrcd","ambd","hpho","htel","procov","ncm","cdc","bcs","pc","fc","ct"};
            HSSFRow xssfR = sheet.createRow(0);
            for (int j = 0; j < title.length; j++) {
                HSSFCell xssfCell = xssfR.createCell(j);
                xssfCell.setCellValue(title[j]);
            }
            for (int i = 0; i < list.size(); i++) {
                Result result=list.get(i);
                Object[] params1={result.getProvince(),result.getNats(),result.getNatsp(),
                        result.getNatcs(),result.getNatso(),result.getCumy(),result.getXswjsl(),
                        result.getCmpd(),result.getNrcp(),result.getNrcd(),result.getAmbd(),result.getHpho(),result.getHtel(),result.getProcov(),result.getNcm(),result.getCdc(),result.getBcs(),result.getPc(),result.getFc(),result.getCt()};

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
