package com.example.demo.security;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class webPageController {

		@RequestMapping("/")
		public String home()
		{
			return "home.html";
		}
		
		@RequestMapping("/login")
		public String loginPage()
		{
			return "login.html";
		}
		
		@RequestMapping("/login_success")
		public String logoutPage()
		{
			return "logout.html";
		}
		
		@RequestMapping("user")
		@ResponseBody
		public Principal user(Principal principal) {
			return principal;
		}
}

