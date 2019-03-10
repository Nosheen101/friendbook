package com.indorse.assigment.friend.book.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.indorse.assigment.friend.book.entity.UserProfileEntity;
import com.indorse.assigment.friend.book.rest.pojo.UserProfile;

/**
 * Interface FriendBookService.
 * 
 * @author nosheen
 */
public interface FriendBookService {

	/**
	 * Sign up.
	 *
	 * @param userProfile the user profile
	 */
	public void signUp(UserProfile userProfile);

	/**
	 * Gets the users list.
	 *
	 * @return the users list
	 */
	public List<UserProfile> getUsersList();

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param pwd      the pwd
	 */
	public void login(String username, String pwd);

	/**
	 * Search user.
	 *
	 * @param username the username
	 * @return the list
	 */
	public List<UserProfile> searchUser(@NotNull String username);

	/**
	 * Adds the friends.
	 *
	 * @param userId the user id
	 * @param ids    the ids
	 */
	public void addFriends(String userId, List<Integer> ids);

	/**
	 * Removes the friends.
	 *
	 * @param userId the user id
	 * @param ids    the ids
	 */
	public void removeFriends(String userId, List<Integer> ids);

	/**
	 * Gets the user id.
	 *
	 * @param username the username
	 * @return the user id
	 */
	public UserProfileEntity getUserId(@NotNull String username);

}
