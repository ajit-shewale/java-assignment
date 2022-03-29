
package com.springWeb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springWeb2.entity.User;
import com.springWeb2.entity.BookDao;
import com.springWeb2.service.LibraryServiceImpl;
import com.springWeb2.service.UserDetailsServiceImpl;

@Controller
public class HomeController {

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    private IssueRequestController issueRequestController;

    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("booksList", libraryServiceImpl.findAllBooks());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        model.addAttribute("userName", userName);
        boolean hasRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
        if (hasRole) {
            return "index_admin";
        } else {
            return "index_user";
        }
    }

    @GetMapping(value = "/showNewBookForm")
    public String addBookForm(Model model) {
        BookDao book = new BookDao();
        model.addAttribute("book", book);
        return "new_book";
    }

    @GetMapping(value = "/showSearchBookForm")
    public String searchBookForm() {

        return "searchPage";
    }

    @GetMapping(value = "/searchBook")
    public String searchBook(Model model, String keyword) {
        if (keyword != null) {

            model.addAttribute("booksList", libraryServiceImpl.getByKeyword(keyword));
        } else {
            return "searchPage";
        }
        return "searchPage";
    }

    @PostMapping(value = "/saveBook")
    public String saveBook(@ModelAttribute("book") BookDao book) {
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        BookDao book = libraryServiceImpl.getBookById(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        this.libraryServiceImpl.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/preRequest/{id}")
    public String preRequest(@PathVariable int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        issueRequestController.addIssueRequest(id,userName);
        return "redirect:/";
    }
}
