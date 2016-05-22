package com.spr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spr.model.Shop;
import com.spr.repository.UserRepository;
import com.spr.validation.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserCreation(@ModelAttribute @Valid Shop shop, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();
		return mav;
	}

}
