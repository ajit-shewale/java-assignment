package com.springWeb2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
 
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/report")
    public void generateReport(HttpServletResponse response ) throws JRException, IOException {
        
        reportService.exportReport(response);
    }
    
    @GetMapping(value = "/reportInput")
    public String reportInput(Model model) {  
        IssuedBookDao book = new IssuedBookDao();
        model.addAttribute("book", book);
        return "reportInput";
    }
    
    @PostMapping("/reportPage")
    public void generateAdvanceReport(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
            @RequestParam(value = "button") String field, HttpServletResponse response) throws JRException, IOException  {
       
        reportService.exportAdvanceReport(response,startDate,endDate,reportName,field);
    }
    
    @GetMapping(value = "/CSVReport")
    public void CSVReportInput(HttpServletResponse response)throws IOException {  
       response.setContentType("text/csv");
       String fileName = "issuedBooks.csv";
       String headerKey = "Contenet-Disposition";
       String headerValue = "attachment; fileName="+ fileName;
       
       response.setHeader(headerKey, headerValue);
       List<IssuedBookDao> IBooks = issuedServiceImpl.findAllBooks();
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
