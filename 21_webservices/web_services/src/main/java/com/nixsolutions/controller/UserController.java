package com.nixsolutions.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.ServletContextAware;

import com.nixsolutions.dto.AddressDTO;
import com.nixsolutions.dto.RoleDTO;
import com.nixsolutions.dto.UserDTO;
import com.nixsolutions.entity.Address;
import com.nixsolutions.entity.Role;
import com.nixsolutions.entity.User;
import com.nixsolutions.service.ServiceApi.RoleService;
import com.nixsolutions.service.ServiceApi.UserService;

@Controller
@RequestMapping("/user")
public class UserController implements ServletContextAware {

	private ServletContext context;
	private UserService userService;
	private RoleService roleService;

	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String printUser(Principal principal, Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "users/users";
	}

	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.POST)
	public String deleteUser(Model model, @PathVariable("userId") int userId) throws Exception {
		userService.delete(userId);
		model.addAttribute("title", "User deleted!");
		return "redirect:/user";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String printRegisterUserForm() {
		return "users/userAdd";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createUser(Model model, @ModelAttribute UserDTO userDTO, @ModelAttribute AddressDTO addressDTO)
			throws IOException, ServletException, SQLException {
		model.addAttribute("user", userDTO);
		model.addAttribute("address", addressDTO);
		userService.createUser(userDTO, addressDTO);
		return "redirect:/user";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	  public String printUpdateUserForm(Model model,  @PathVariable("userId") int userId) throws SQLException {
	   User user = userService.getById(userId);
	   Role role = roleService.getById(user.getRole().getId());
	    Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
	        .getContext().getAuthentication().getAuthorities();
	    if (!user.getRole().getName().equals("user")) {
	      if (!authorities.contains(new SimpleGrantedAuthority("admin"))) {
	        model.addAttribute("message", "Only admin can edit librarians.");
	        return "/user";
	      }
	    }
	        model.addAttribute("user", user);
	        model.addAttribute("role", role);
	        return "users/userEdit";
	}
	
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	   public String udpateUser(Model model, @ModelAttribute UserDTO userDTO,  @ModelAttribute RoleDTO roleDTO) throws IOException, ServletException, SQLException {
	       userService.update(userDTO, roleDTO);
	     model.addAttribute("title", "User updated!");
	     return "redirect:/user";
	   }	
}
