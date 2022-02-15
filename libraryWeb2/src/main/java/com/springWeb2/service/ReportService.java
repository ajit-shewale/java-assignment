package com.springWeb2.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
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

//    public String exportReport() throws FileNotFoundException, JRException {
//        String path = "D:\\Report";
//        List<IssuedBookDao> employees = repository.findAll();
//        //load file and compile it
//        File file = ResourceUtils.getFile("classpath:report11.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
//        Map<String, Object> parameters = new HashMap<>();
//        //parameters.put("createdBy", "Java Techie");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Report\\report11.pdf");
//        
//
//        return "report generated in path : " + "D:\\Report";
//    }

    public void exportReport(HttpServletResponse response) throws JRException, IOException {
        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportName", "Ajit");

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
}