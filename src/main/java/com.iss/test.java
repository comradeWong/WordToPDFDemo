package com.iss;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by Avenger on 2017/10/26 0026
 */
public class test {
    public static void convertPdf(String docxFilePath,String pdfFilePath) throws Exception{
        File docxFile=new File(docxFilePath);
        File pdfFile=new File(pdfFilePath);

//转换pdf文件
        if(docxFile.exists()){
            if(!pdfFile.exists()){
                InputStream inStream=new FileInputStream(docxFilePath);
                XWPFDocument document = new XWPFDocument(inStream);
                //HWPFDocument document = new HWPFDocument(inStream);
                OutputStream out = new FileOutputStream(pdfFilePath);
                PdfOptions options = PdfOptions.create();
                ExtITextFontRegistry fontProvider=ExtITextFontRegistry.getRegistry();
                options.fontProvider(fontProvider);
                PdfConverter.getInstance().convert(document, out, options);
            }else{
                System.out.println("PDF文件已存在，无需再次转换");
            }
        }else{
        }
    }

}
