package com.springWeb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("booksList", libraryServiceImpl.findAllBooks());
        return "index";
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
    
//    @GetMapping(value = "/newUser")
//    public String addNewUser(Model model) {
//       User user = new User();
//        model.addAttribute("User", user);
//        return "signinPage";
//    }
//    
//    @PostMapping(value = "/saveUser")
//    public String saveUser(@ModelAttribute("book") User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDetailsServiceImpl.saveUser(user);
//        return "redirect:/";
//    }
}
