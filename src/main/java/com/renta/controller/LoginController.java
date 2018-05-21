package com.renta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.User;
import com.renta.services.SecurityService;


/**
 *  Login para usuario
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserDAO userDAO;
	

/*	
	@GetMapping("/")
	public String menu() {

		return "/login";
	}
*/
	
	//@GetMapping("/login")
	
	@GetMapping(value={"/", "login"})
	public ModelAndView preLogin() {
		User usr = new User();
		return new ModelAndView("login", "command", usr);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		
		logger.info("login()");
		logger.info(user.toString());

		ModelAndView modelAndView = null;

		try {
			User usr = securityService.validate(user.getUsername(), user.getPassword());
			logger.info(usr.toString());
			modelAndView = new ModelAndView("redirect:/admin/menu", "command", usr);
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("login", "command", new User());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("login", "command", new User());
		}

		return modelAndView;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	// Crear Usuario
	
	@GetMapping("/register")
	public ModelAndView register() {
		User usr = new User();
		return new ModelAndView("/admin/usr/createform", "command", usr);
	}
	
	
	

}
