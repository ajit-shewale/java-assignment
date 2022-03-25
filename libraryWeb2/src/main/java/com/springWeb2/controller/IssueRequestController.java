package com.springWeb2.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssueRequestDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.IssueRequestServiceImpl;

@Controller
public class IssueRequestController {

    @Autowired
    private IssueRequestServiceImpl issueRequestServiceImpl;

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;
    
    public String addIssueRequest(int id,String userName) {
        BookDao book = libraryServiceImpl.getBookById(id);
        IssueRequestDao request = new IssueRequestDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(),userName);
        issueRequestServiceImpl.saveRequest(request);
        book.setStatus("Pending..");
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }
    
    @GetMapping("/showAllIssueRequests")
    public String showAllIssueRequests(Model model) {
        model.addAttribute("listRequests", issueRequestServiceImpl.findAllRequests());
        return "issueRequest";
    }
    
    @GetMapping("/acceptIssueRequest/{id}")
    public String acceptIssueRequest(@PathVariable(value = "id") int id) {
        BookDao book = libraryServiceImpl.getBookById(id);
        IssueRequestDao request = issueRequestServiceImpl.getRequestById(id);
        LocalDate date = LocalDate.now();
        IssuedBookDao Ibook = new IssuedBookDao(book.getId(), book.getTitle(), book.getAuthor(), book.getCost(),date ,date.plusDays(10),request.getIssuedFor());
        issuedServiceImpl.saveBook(Ibook);
        book.setStatus("issued");
        libraryServiceImpl.saveBook(book);
        this.issueRequestServiceImpl.deleteRequest(id);
        return "redirect:/showAllIssueRequests";
    }
}
