package de.kluge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.kluge.model.User;
import de.kluge.model.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userDao;

	@RequestMapping("/User/create")
	@ResponseBody
	public String create(String username, String password) {
		String userId = "";
		try {
			User user = new User(username, password);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	/**
	 * GET /delete --> Delete the user having the passed id.
	 */
	@RequestMapping("/User/delete")
	//@ResponseBody
	public String delete(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		/*
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
		*/		
		
		model.addAttribute("name", name);
		
		User user = new User("email", "name");
		model.addAttribute("testuser", user);
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		User user2 = new User("email2", "name2");
		userList.add(user2);
		model.addAttribute("userList", userList);
		
		return "User/delete";  // Template name

	}

	/**
	 * GET /get-by-email --> Return the id for the user having the passed email.
	 */
//	@RequestMapping("/get-by-email")
//	@ResponseBody
//	public String getByEmail(@RequestParam(value="email", required=false, defaultValue="") String email, Model model) {
//		String userId = "";
//		try {
//			User user = userDao.findByEmail(email);
//			userId = String.valueOf(user.getId());
//		} catch (Exception ex) {
//			return "User not found";
//		}
//		return "The user id is: " + userId;
//	}

	/**
	 * GET /update --> Update the email and the name for the user in the
	 * database having the passed id.
	 */
	@RequestMapping("/User/update")
	@ResponseBody
	public String updateUser(long id, String username, String password) {
		try {
			User user = userDao.findOne(username);
			user.setUsername(username);
			user.setPassword(password);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

}
