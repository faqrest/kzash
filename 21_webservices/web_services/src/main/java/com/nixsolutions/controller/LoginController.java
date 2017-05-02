package com.nixsolutions.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.Book;
import com.nixsolutions.entity.User;
import com.nixsolutions.service.ServiceApi.BookService;
import com.nixsolutions.service.ServiceApi.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	  public String printProfile(Model model, Principal principal) {
	    User user = userService.getByEmail(principal.getName());
	    List<Book> books = bookService.getAll();
	    model.addAttribute("user", user);
	    model.addAttribute("title", "Home page");
	    model.addAttribute("books", books);
	    return "home";
	  }
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	  public String signUpForm(Model model, Principal principal) {
	    return "/signUp";
	  }
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	  public String signUpUser(Model model, @ModelAttribute UserDTO userDTO, @ModelAttribute AddressDTO addressDTO) throws SQLException {
		model.addAttribute("user", userDTO);
		model.addAttribute("address", addressDTO);
	    userService.createUser(userDTO, addressDTO);
	    model.addAttribute("message", "Your profile was created");
	    
		return "redirect:/login";
	  }
}
