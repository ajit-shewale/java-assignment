package com.springWeb2.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springWeb2.entity.BookDao;
import com.springWeb2.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
 
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/report")
    public void generateReport(HttpServletResponse response ) throws JRException, IOException {
        
        reportService.exportReport(response);
    }
    
    @GetMapping(value = "/reportInput")
    public String reportInput(Model model) {
        Date startDate1 = null ;
        Date endDate1 = null;
        model.addAttribute("startDate1",startDate1);
        model.addAttribute("endDate1",endDate1);
        return "reportInput";
    }
    
    @PostMapping("/reportPage")
    public String generateAdvanceReport(@ModelAttribute("startDate1") Date startDate1,@ModelAttribute("endDate1") Date endDate1,HttpServletResponse response) throws JRException, IOException  {
       
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        LocalDate startDate = LocalDate.parse(startDate1, formatter);
//        LocalDate endDate = LocalDate.parse(endDate1, formatter);
        
//        List<IssuedBookDao> rowList = issuedServiceImpl.findAllBooks();
//       List<IssuedBookDao> mainList = null;   // = new List<>();
//       int count = 0;
//        for(IssuedBookDao tempBook : rowList)
//        {
//          LocalDate  tempDate = tempBook.getIssued_date();
//          int cmprStart = tempDate.compareTo(startDate);
//          int cmprEnd = tempDate.compareTo(endDate);
//           if(cmprStart >= 0 && cmprEnd <=0) {
//               mainList.add(tempBook);
//               count++;
//           }
//        }
//        reportService.exportAdvanceReport(response,mainList,count);
       return "reportInput";
    }
    
}
