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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

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

   public List<IssuedBookDao> booksByRole() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       boolean hasRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
       if (hasRole) {
          List<IssuedBookDao> IBooks = issuedServiceImpl.findAllIssuedBooks();
          return IBooks;
       } else {
           String userName = authentication.getName();
           List<IssuedBookDao> IBooks = issuedServiceImpl.findAllIssuedBooksIssuedBy(userName);
           return IBooks;
       }
       
   }
    
    public void exportReport(HttpServletResponse response ,String reportName,
            String field) throws JRException, IOException {
        
        if(("Download PDF Report".equals(field))) {
        String path = "C:\\Users\\ajits\\Desktop\\tempReports";
        List<IssuedBookDao> IBooks = booksByRole();
        int count = IBooks.size();
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportName", reportName);
        parameters.put("countBooks", count);
        File file = ResourceUtils.getFile("classpath:reportDemo.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(IBooks);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=" + reportName + ".pdf");
        OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        }
         if("Download CSV Report".equals(field)){
             response.setContentType("text/csv");
             String fileName = reportName.concat(".csv");
             
             response.setHeader(HttpHeaders.CONTENT_DISPOSITION,  "attachment; filename=\"" + fileName + "\"");
             List<IssuedBookDao> IBooks = booksByRole();
             ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
             
             String[] csvHeader = {"Book Id","Title","Author","Cost","IssuedDate","ReturnDate"};
             String[] nameMapping = {"id","title","author","cost","issuedDate","returnDate"};
             csvWriter.writeHeader(csvHeader);
             
             for(IssuedBookDao book : IBooks) {
                 csvWriter.write(book,nameMapping);
             }
             csvWriter.close();
         }
        
    }

    public void exportAdvanceReport(HttpServletResponse response, String startDate, String endDate, String reportName,
            String field) throws JRException, IOException {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<IssuedBookDao> rawList =booksByRole();
        List<IssuedBookDao> mainList = new ArrayList<IssuedBookDao>();

        for (IssuedBookDao book : rawList) {
            LocalDate tempDate = book.getIssuedDate();
            int check1 = tempDate.compareTo(start);
            int check2 = tempDate.compareTo(end);
            if (check1 >= 0) {
                if (check2 <= 0) {
                    mainList.add(book);
                }
            }
        }

        if ("Download PDF Report".equals(field)) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("reportName", reportName);
            parameters.put("endDate", endDate);
            parameters.put("startDate", startDate);
            int count = mainList.size();
            parameters.put("countBooks", count);

            File file = ResourceUtils.getFile("classpath:advanceReport.jrxml");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(mainList);
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=" + reportName + ".pdf");
            OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        }
        
        if("Download CSV Report".equals(field))
        {
            response.setContentType("text/csv");
            String fileName =reportName.concat(".csv");  
        
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
            
            String[] csvHeader = {"Book Id","Title","Author","Cost","IssuedDate","ReturnDate"};
            String[] nameMapping = {"id","title","author","cost","issuedDate","returnDate"};
            csvWriter.writeHeader(csvHeader);
            
            for(IssuedBookDao book : mainList) {
                csvWriter.write(book,nameMapping);
            }
            csvWriter.close();
        }

    }

}