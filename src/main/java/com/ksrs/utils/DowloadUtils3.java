package com.ksrs.utils;

import com.ksrs.entity.QggsZl;
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
public class DowloadUtils3 {
    public static void dowload(HttpServletResponse response, List<QggsZl> list){
        OutputStream os=null;
        try {
            String    mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd-HH-mm");
            String downFileName ="statisticszl"+sdf.format(new Date())+".xls";
            String inlineType = "attachment"; // 是否内联附件
            response.setHeader("Content-Disposition", inlineType
                    + ";filename=\"" + new String(downFileName.getBytes(), "UTF-8") + "\"");
            //查出所有的投资记录
            //导出Excel
            os = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            String [] title={ "省份","有网络推广标签","百度客户标签","58客户标签","赶集客户标签","百姓客户标签","有联系方式","工商手机","工商固话","招聘手机","招聘固话","商情手机","商情固话","招商加盟手机","招商加盟固话","其它手机","其它固话","有邮箱","有网站","有三个月招聘信息","有注册资本","有注册号","有经营范围","有注册地","有法人","有员工数","有融资轮次","数据完整(交集)","数据完整(并集)","统计时间"};
            //String [] params={"province","nats","natsp","natcs","natso","cumy","cmpd","nrcp","nrcd","ambd","hpho","htel","procov","ncm","cdc","bcs","pc","fc","ct"};
            HSSFRow xssfR = sheet.createRow(0);
            for (int j = 0; j < title.length; j++) {
                HSSFCell xssfCell = xssfR.createCell(j);
                xssfCell.setCellValue(title[j]);
            }
            for (int i = 0; i < list.size(); i++) {
               QggsZl result=list.get(i);
                Object[] params1={result.getProvince(),result.getHave_webtype(),result.getHave_baidu(),
                        result.getHave_58(),result.getHave_gj(),result.getHave_baixin(),
                       result.getHave_lx(),result.getHave_gssj(),result.getHave_gsgh(),result.getHave_zpsj(),result.getHave_zpgh()
                        ,result.getHave_sqsj(),result.getHave_sqgh(),result.getHave_zsjmsj(),result.getHave_zsjmgh()
                        ,result.getHave_qtsj(),result.getHave_qtgh(),
                        result.getHave_email(),result.getHave_web(),result.getHave_zpxx(),
                        result.getHave_zczb(),result.getHave_zch(),
                        result.getHave_jyfw(),result.getHave_zcdz(),
                        result.getHave_fr(),result.getHave_ygs(),result.getHave_rzlc(),
                        result.getHave_sjwzjj(),result.getHave_sjwzbj(),result.getCountTime()};

                // 创建Excel的sheet的一行
                int r=i+1;
                HSSFRow xssfRow = sheet.createRow(r);
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

            String[] zhushi={"即省份","这是KSRS库内线索非正常的量中有网络标签(包含百度，58，赶集，百信)的量","这是KSRS库内线索非正常的量中有百度标签的量","这是KSRS库内线索非正常的量中有58标签的量","这是KSRS库内线索非正常的量中有赶集标签的量","这是KSRS库内线索非正常的量中有百姓客户标签的量","这是KSRS库内线索非正常的量中有联系方式的量(base+招聘+商情+招商加盟+其它)有其一)","这是KSRS库内线索非正常的量中有工商手机(base表中有手机)的量","这是KSRS库内线索非正常的量中有工商固话(base表中有固话)的量",
                            "这是KSRS库内线索非正常的量中有招聘手机的量","这是KSRS库内线索非正常的量中有招聘固话的量","这是KSRS库内线索非正常的量中有商情手机的量","这是KSRS库内线索非正常的量中有商情固话的量","这是KSRS库内线索非正常的量中有招商加盟手机的量","这是KSRS库内线索非正常的量中有招商加盟固话的量","这是KSRS库内线索非正常的量中有其它(投资界、ICP等)手机的量","这是KSRS库内线索非正常的量中有其它(投资界、ICP等)固话的量","这是KSRS库内线索非正常的量中有邮箱(base表中邮箱)的量","这是KSRS库内线索非正常的量中有网站(base表中网站)的量","这是KSRS库内线索非正常的量中有招聘信息的量","这是KSRS库内线索非正常的量中有注册资本的量","这是KSRS库内线索非正常的量中有注册号的量",
                            "这是KSRS库内线索非正常的量中有经营范围的量","这是KSRS库内线索非正常的量中有注册地址的量","这是KSRS库内线索非正常的量中有法人的量","这是KSRS库内线索非正常的量中有员工数的量","这是KSRS库内线索非正常的量中有融资轮次的量","这是KSRS库内线索非正常的量中有数据完整交集(即电话（Base＋招聘）&经营范围&（法人或招聘联系人）都不为空)的量","这是KSRS库内线索非正常的量中有数据完整并集(即电话（Base＋招聘）or经营范围or（法人或招聘联系人）有一个即可)的量","即统计的时间"};
            for (int j = 0; j < title.length; j++) {
                HSSFRow xssfRow = sheet.createRow(list.size()+5+j);
                for(int i=0;i<2;i++){
                    HSSFCell xssfCell = xssfRow.createCell(i);

                    if(i==0){
                        xssfCell.setCellValue(title[j]);
                    }else{
                        xssfCell.setCellValue(zhushi[j]);
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
