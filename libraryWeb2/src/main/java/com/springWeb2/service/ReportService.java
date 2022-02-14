package com.springWeb2.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.repository.IssuedRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.data.http.RequestMethod;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private IssuedRepository repository;


//    public String exportReport() throws FileNotFoundException, JRException {
//        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
//        //Map<String, Object> parameters = new HashMap<>();
//      //  parameters.put("book", "book");
//       
//        List<IssuedBookDao> IBooks = repository.findAll();
//        File file = ResourceUtils.getFile("classpath:report20.jrxml");
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(IBooks);
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ajits\\Desktop\\tempReports\\firstReport.pdf");
//        System.out.println("Report created...");
//        return "file is created on C:\\Users\\ajits\\Desktop\\tempReports";
//    }
    
    
        public String exportReport() throws FileNotFoundException, JRException {
        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("studentName", "ajit");
       
        List<IssuedBookDao> IBooks = repository.findAll();
        File file = ResourceUtils.getFile("classpath:report12.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(IBooks);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\ajits\\Desktop\\tempReports\\firstReport.pdf");
        System.out.println("Report created...");
        return "file is created on C:\\Users\\ajits\\Desktop\\tempReports";
    }
}
