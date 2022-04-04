package com.springWeb2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping(value = "/reportInput")
    public String reportInput() {
        return "reportInput";
    }

    @PostMapping("/generateReport")
    public void generateAdvanceReport(@RequestParam(value = "reportName") String reportName,
            @RequestParam(value = "reportType") String reportType, @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate, @RequestParam(value = "button") String field,
            HttpServletResponse response) throws JRException, IOException {
        if ("AllBooks".equals(reportType)) {
            reportService.exportReport(response, reportName, field);
        } else if ("Custom".equals(reportType)) 
            reportService.exportAdvanceReport(response, startDate, endDate, reportName, field);
    }

}
