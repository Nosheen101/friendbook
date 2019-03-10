package com.indorse.assigment.friend.book.rest.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indorse.assigment.friend.book.entity.UserProfileEntity;
import com.indorse.assigment.friend.book.rest.pojo.UserProfile;
import com.indorse.assigment.friend.book.service.FriendBookService;

/**
 * Class containing all end points for friend book.
 *
 * @author nosheen
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(path = "/friendbook")
public class FriendBookController {

	/** The service. */
	@Autowired
	private FriendBookService service;

	/**
	 * Sign up.
	 *
	 * @param userProfile the user profile
	 * @return the string
	 */
	@PostMapping(path = "/signup")
	public String signUp(@Valid @RequestBody UserProfile userProfile) {

		service.signUp(userProfile);
		return "User Created Successfully";
	}

	/**
	 * Login.
	 *
	 * @param userProfile the user profile
	 * @return the string
	 */
	@PostMapping(path = "/login")
	public String login(@RequestBody UserProfile userProfile) {

		service.login(userProfile.getUserName(), userProfile.getPassword());
		return "User login Successfully";
	}

	/**
	 * Serach user.
	 *
	 * @param username the username
	 * @return the list
	 */
	@GetMapping(path = "/search/{username}")
	public List<UserProfile> serachUser(@NotNull @PathVariable("username") String username) {
		return service.searchUser(username);
	}

	/**
	 * Gets the user id.
	 *
	 * @param username the username
	 * @return the user id
	 */
	@GetMapping(path = "/{username}")
	public UserProfileEntity getUserId(@NotNull @PathVariable("username") String username) {
		return service.getUserId(username);
	}

	/**
	 * Adds the friends.
	 *
	 * @param userId the user id
	 * @param ids    the ids
	 * @return the string
	 */
	@PostMapping(path = "/{userid}/addfriends")
	public String addFriends(@NotNull @PathVariable("userid") String userId, @RequestBody List<Integer> ids) {
		service.addFriends(userId, ids);
		return "friends added SuccessFully";
	}

	/**
	 * Removes the friends.
	 *
	 * @param userId the user id
	 * @param ids    the ids
	 * @return the string
	 */
	@PostMapping(path = "/{userid}/removefriends")
	public String removeFriends(@NotNull @PathVariable("userid") String userId, @RequestBody List<Integer> ids) {
		service.removeFriends(userId, ids);
		return "friends removed SuccessFully";
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GetMapping(path = "/")
	public List<UserProfile> getUsers() {
		return service.getUsersList();
	}

}
