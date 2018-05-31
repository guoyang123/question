package com.neuedu.service.impl;

import com.neuedu.dao.AnswerMapper;
import com.neuedu.entity.QAnswer;
import com.neuedu.service.AnswerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public void saveBatch(List<QAnswer> qAnswerList) {
        answerMapper.saveBatch(qAnswerList);
    }

    @Override
    public List<QAnswer> findAllByQno(String qno,HttpServletResponse response) {
        List<QAnswer> qAnswerList=answerMapper.findAllByQno(qno);

        System.out.println("====answer="+qAnswerList.size());
        writeObject2Excel(qAnswerList,response);
        return qAnswerList;
    }

    @Override
    public String writeObject2Excel(List<QAnswer> qAnswerList,HttpServletResponse response) {
        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("问卷调查结果反馈");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("问题");
        cell = row.createCell(1);
        cell.setCellValue("答案");
        cell = row.createCell(2);
        cell.setCellValue("回答时间");
        cell = row.createCell(3);
        cell.setCellValue("用户ip");

        FileOutputStream fos = null;


            //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值

            for (int i = 0; i < qAnswerList.size(); i++) {
                HSSFRow row1 = sheet.createRow(i + 1);
                QAnswer qAnswer = qAnswerList.get(i);
                //创建单元格设值
                row1.createCell(0).setCellValue(qAnswer.getQtitle());
                row1.createCell(1).setCellValue(qAnswer.getAnswer());
                row1.createCell(2).setCellValue(qAnswer.getAnswertime()+"");
                row1.createCell(3).setCellValue(qAnswer.getUserip());
            }

            //将文件保存到指定的位置
             File file=new File("/usr/gy/download/user1.xls");
            try {
                fos = new FileOutputStream(file);
                workbook.write(fos);
                System.out.println("写入成功");
                downloadFile(response,file);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }

            }


        return null;
    }


    /**文件下载*/

    public String downloadFile( HttpServletResponse response,File file) {
       // String fileName = "7102db1c-59f1-46be-92b7-cef8f0ec25e3.png";// 设置文件名，根据业务需要替换成要下载的文件名
        if (file != null) {
            //设置文件路径
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + file.getName());// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        System.out.println("下载时每一桶数据:"+buffer.toString());
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
