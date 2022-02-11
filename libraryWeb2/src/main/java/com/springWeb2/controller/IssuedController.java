package com.springWeb2.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;

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
}
