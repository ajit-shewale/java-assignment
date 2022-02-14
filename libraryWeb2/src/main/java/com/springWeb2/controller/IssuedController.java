package com.springWeb2.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class IssuedController {

    @Autowired
    private IssuedServiceImpl issuedServiceImpl;

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private ReportService reportServiceImpl;
    
    @GetMapping("/addIssuedBook/{id}")
    public String addIssuedBook(@PathVariable int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
      
        LocalDate date = LocalDate.now();
       
        IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(),date ,date.plusDays(10));
        issuedServiceImpl.saveBook(Ibook);
        book.setStatus("Issued");
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showIssuedBooks")
    public String showIssuedBooks(Model model) {
        model.addAttribute("listBooks", issuedServiceImpl.findAllBooks());
        return "issued_books";
    }

    @GetMapping("/deleteIssuedBook/{id}")
    public String deleteIssuedBook(@PathVariable(value = "id") int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
        book.setStatus("not issued");
        libraryServiceImpl.saveBook(book);
        this.issuedServiceImpl.deleteBook(id);
        return "redirect:/showIssuedBooks";
    }
    
    @GetMapping("/report")
    public void generateReport() throws FileNotFoundException, JRException {
        reportServiceImpl.exportReport();
    }
    
}
