package com.springWeb2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.springWeb2.entity.User;
import com.springWeb2.repository.UserRepository;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.ReportService;
import com.springWeb2.service.UserDetailsServiceImpl;

import net.sf.jasperreports.engine.JRException;

@Controller
public class IssuedController {

    @Autowired
    private IssuedServiceImpl issuedServiceImpl;

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private UserRepository userRepository;
    
    
    @GetMapping("/addIssuedBook/{id}")
    public String addIssuedBook(@PathVariable int id) {
       //
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        //
        BookDao book = libraryServiceImpl.getBookById(id);
        LocalDate date = LocalDate.now();
        IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(),date ,date.plusDays(10),userName);
        issuedServiceImpl.saveBook(Ibook);
        book.setStatus("Pending..");
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showIssuedBooks")
    public String showIssuedBooks(Model model) {
//        model.addAttribute("listBooks", issuedServiceImpl.findAllIssuedBooks());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        model.addAttribute("listBooks", issuedServiceImpl.findAllIssuedBooksIssuedBy(userName));
        return "issuedBooksUser";
    }
    
    @GetMapping("/showAllIssuedBooks")
    public String showAllIssuedBooks(Model model) {
        model.addAttribute("listBooks", issuedServiceImpl.findAllIssuedBooks());
        return "issuedBooksAdmin";
    }

    @GetMapping("/deleteIssuedBook/{id}")
    public String deleteIssuedBook(@PathVariable(value = "id") int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
        book.setQuantity(book.getQuantity()+1);
        book.setStatus("not issued");
        libraryServiceImpl.saveBook(book);
        this.issuedServiceImpl.deleteBook(id);
        return "redirect:/showIssuedBooks";
    }
    
    public String deadlineBooks() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
         List<IssuedBookDao> rawList = issuedServiceImpl.findAllIssuedBooksIssuedBy(userName);
         List<String> mainList = new ArrayList<String>();

         for (IssuedBookDao book : rawList) {
             LocalDate returnDate = book.getReturnDate();
             LocalDate todaysDate= LocalDate.now();
             long daysBetween = ChronoUnit.DAYS.between(todaysDate,returnDate);
             if(daysBetween<=3)
             {
                 mainList.add(book.getTitle());
             }
         }
        String bookList = mainList.toString();
        return bookList;
    }
   
}
