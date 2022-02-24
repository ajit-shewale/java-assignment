package com.springWeb2.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.repository.IssuedRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Service
public class ReportService {

    @Autowired
    private IssuedRepository repository;
    
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;

    public void exportReport(HttpServletResponse response) throws JRException, IOException {
        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportName", "Issued Books");

        List<IssuedBookDao> IBooks = repository.findAll();
        File file = ResourceUtils.getFile("classpath:reportDemo.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(IBooks);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\ajits\\Desktop\\tempReports\\reportDemo.pdf");
        System.out.println("Report created...");
        StringBuilder fileArg = new StringBuilder("attchment" + "; filename=");
        fileArg.append("reportDemo.pdf");

        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", fileArg.toString());

        JRPdfExporter exporter = new JRPdfExporter();
        OutputStream out = response.getOutputStream();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
        SimplePdfReportConfiguration reportCon;
    }

    public void exportAdvanceReport(HttpServletResponse response, String startDate, String endDate,String reportName) throws JRException, IOException{
        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
        Map<String, Object> parameters = new HashMap<>();
       parameters.put("reportName", reportName);
        parameters.put("endDate", endDate);
        parameters.put("startDate", startDate);
        
      LocalDate start = LocalDate.parse(startDate);
      LocalDate end = LocalDate.parse(endDate);
      
      List<IssuedBookDao> rowList = issuedServiceImpl.findAllBooks();
      List<IssuedBookDao> mainList = new LinkedList<IssuedBookDao>();
      
      for(IssuedBookDao book:rowList) {
          
          LocalDate tempDate = book.getIssuedDate();
          boolean check1 = tempDate.isAfter(start);
          boolean check2 = tempDate.isBefore(end);
          if(check1==true && check2==true) {
               mainList.add(book);
          }
      }
      int count = mainList.size();
      parameters.put("countBooks", count);
      
        File file = ResourceUtils.getFile("classpath:advanceReport.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(mainList);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\ajits\\Desktop\\tempReports\\advanceReport.pdf");
        System.out.println("Report created...");
        StringBuilder fileArg = new StringBuilder("attchment" + "; filename=");
        fileArg.append("advanceReport.pdf");

        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", fileArg.toString());

        JRPdfExporter exporter = new JRPdfExporter();
        OutputStream out = response.getOutputStream();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
        SimplePdfReportConfiguration reportCon;
    }
}