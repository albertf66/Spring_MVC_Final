package com.spring.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.UserMapper;
import com.spring.entity.User;

@Controller
public class UserController {
	@Autowired
	UserMapper mapper;

	@ModelAttribute("user")
	public User getUserObject() {
		return new User();
	}

	@RequestMapping("/")
	public String home() {
		return "register";
	}

	@RequestMapping("/register")
	public ModelAndView addProcess(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Pattern email_pattern = Pattern.compile("^(.+)@(.+)$");
		Pattern phone_pattern = Pattern.compile("^\\d{10}$");
		Matcher email_matcher = email_pattern.matcher(user.getUser_email());
		Matcher phone_matcher = phone_pattern.matcher(user.getUser_phone());
		if (user.getUser_id() == null) {
			User current_user = mapper.findByEmail(user.getUser_email());
			if (user.getUser_name() == "") {
				result.rejectValue("user_name", "error.null.name", "name is empty!");
				mav.setViewName("register");
			}
			if (user.getUser_email() == "") {
				result.rejectValue("user_email", "error.null.email", "email is empty!");
				mav.setViewName("register");
			} else if (!email_matcher.matches()) {
				result.rejectValue("user_email", "error.valid.email", "email is not valid!");
				mav.setViewName("register");
			}
			if (user.getUser_phone() == "") {
				result.rejectValue("user_phone", "error.null.phone", "password is empty!");
				mav.setViewName("register");
			} else if (!phone_matcher.matches()) {
				result.rejectValue("user_phone", "error.valid.phone", "phone is not valid!");
				mav.setViewName("register");
			}
			if (user.getUser_pw() == "") {
				result.rejectValue("user_pw", "error.null.pw", "password is empty!");
				mav.setViewName("register");
			} else if (user.getUser_pw().length() < 6 || user.getUser_pw().length() > 32) {
				result.rejectValue("user_pw", "error.length.pw", "password must be around 6-32 characters!");
				mav.setViewName("register");
			}
			if (current_user != null) {
				result.rejectValue("user_email", "error.exist.email", "email has been registered!");
				mav.setViewName("register");
			}
			if (!result.hasErrors()) {
				user.setUser_status("GUEST");
				mapper.addUser(user);
				mav.setViewName("login");
			}
		}
		return mav;
	}

	@RequestMapping("/editGuest")
	public ModelAndView editGuest(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Pattern email_pattern = Pattern.compile("^(.+)@(.+)$");
		Pattern phone_pattern = Pattern.compile("^\\d{10}$");
		Matcher email_matcher = email_pattern.matcher(user.getUser_email());
		Matcher phone_matcher = phone_pattern.matcher(user.getUser_phone());
		if (user.getUser_name() == "") {
			result.rejectValue("user_name", "error.null.name", "name is empty!");
			mav.setViewName("edit");
		}
		if (user.getUser_email() == "") {
			result.rejectValue("user_email", "error.null.email", "email is empty!");
			mav.setViewName("edit");
		} else if (!email_matcher.matches()) {
			result.rejectValue("user_email", "error.valid.email", "email is not valid!");
			mav.setViewName("edit");
		}
		if (user.getUser_phone() == "") {
			result.rejectValue("user_phone", "error.null.phone", "password is empty!");
			mav.setViewName("edit");
		} else if (!phone_matcher.matches()) {
			result.rejectValue("user_phone", "error.valid.phone", "phone is not valid!");
			mav.setViewName("edit");
		}
		if (user.getUser_pw() == "") {
			result.rejectValue("user_pw", "error.null.pw", "password is empty!");
			mav.setViewName("edit");
		} else if (user.getUser_pw().length() < 6 || user.getUser_pw().length() > 32) {
			result.rejectValue("user_pw", "error.length.pw", "password must be around 6-32 characters!");
			mav.setViewName("edit");
		}
		if (!result.hasErrors()) {
			mapper.updateUser(user);
			mav.addObject("listofguests", mapper.getAllGuest());
			mav.setViewName("adminpage");
		}
		return mav;
	}
	
	@RequestMapping("/editInfo")
	public ModelAndView editInfo(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		Pattern email_pattern = Pattern.compile("^(.+)@(.+)$");
		Pattern phone_pattern = Pattern.compile("^\\d{10}$");
		Matcher email_matcher = email_pattern.matcher(user.getUser_email());
		Matcher phone_matcher = phone_pattern.matcher(user.getUser_phone());
		if (user.getUser_name() == "") {
			result.rejectValue("user_name", "error.null.name", "name is empty!");
			mav.setViewName("editinfo");
		}
		if (user.getUser_email() == "") {
			result.rejectValue("user_email", "error.null.email", "email is empty!");
			mav.setViewName("editinfo");
		} else if (!email_matcher.matches()) {
			result.rejectValue("user_email", "error.valid.email", "email is not valid!");
			mav.setViewName("editinfo");
		}
		if (user.getUser_phone() == "") {
			result.rejectValue("user_phone", "error.null.phone", "password is empty!");
			mav.setViewName("editinfo");
		} else if (!phone_matcher.matches()) {
			result.rejectValue("user_phone", "error.valid.phone", "phone is not valid!");
			mav.setViewName("edit");
		}
		if (user.getUser_pw() == "") {
			result.rejectValue("user_pw", "error.null.pw", "password is empty!");
			mav.setViewName("edit");
		} else if (user.getUser_pw().length() < 6 || user.getUser_pw().length() > 32) {
			result.rejectValue("user_pw", "error.length.pw", "password must be around 6-32 characters!");
			mav.setViewName("edit");
		}
		if (!result.hasErrors()) {
			mapper.updateUser(user);
			model.addAttribute("userEmail", user.getUser_email());
			mav.setViewName("index");
		}
		return mav;
	}

	@RequestMapping("/deleteUser")
	public ModelAndView deleteProcess(@RequestParam("userId") int userId) {
		ModelAndView mav = new ModelAndView("adminpage");
		mapper.deleteUser(userId);
		mav.addObject("listofguests", mapper.getAllGuest());
		return mav;
	}

	@RequestMapping("/editUser")
	public ModelAndView editUser(@RequestParam("userId") int userId) {
		ModelAndView mav = new ModelAndView("edit");
		User user = mapper.findById(userId);
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/editUserforGuest")
	public ModelAndView editUserGuest(@RequestParam("userEmail") String userEmail) {
		ModelAndView mav = new ModelAndView("editinfo");
		User user = mapper.findByEmail(userEmail);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult result, ModelMap model){
		ModelAndView mav = new ModelAndView();
		User check_user = mapper.findByEmail(user.getUser_email());
		try {
			if (user.getUser_email().equals("")) {
				result.rejectValue("user_email", "error.null.email", "Email is empty!");
				mav.setViewName("login");
			}
			else if (check_user == null) {
				result.rejectValue("user_email", "error.valid.email", "Email is wrong!");
				mav.setViewName("login");
				return mav;
			}
			if (user.getUser_pw().equals("")) {
				result.rejectValue("user_pw", "error.null.pw", "Password is empty!");
				mav.setViewName("login");
				return mav;
			}
			else if (!user.getUser_pw().equals(mapper.findPw(user.getUser_email()))) {
				result.rejectValue("user_pw", "error.valid.pw", "Password is wrong!");
				mav.setViewName("login");
			}
			if (!result.hasErrors()) {
				user = mapper.findByEmail(user.getUser_email());
				mav.addObject("user", user);
				String current_email = user.getUser_email();
				if (user.getUser_status().equals("GUEST")) {
					mav.setViewName("index");
					model.addAttribute("userEmail", current_email);
				} else {
					mav.setViewName("adminpage");
					mav.addObject("listofguests", mapper.getAllGuest());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}
