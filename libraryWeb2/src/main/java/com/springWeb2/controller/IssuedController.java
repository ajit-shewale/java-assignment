package com.springWeb2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class IssuedController {

    @Autowired
    private IssuedServiceImpl issuedServiceImpl;

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
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
        model.addAttribute("listBooks", issuedServiceImpl.findAllIssuedBooks());
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
    
   
}
