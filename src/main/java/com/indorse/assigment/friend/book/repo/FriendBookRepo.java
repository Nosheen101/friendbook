package com.indorse.assigment.friend.book.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.indorse.assigment.friend.book.entity.UserProfileEntity;

/**
 * Repository for performing database operation
 * 
 * @author nosheen
 */
public interface FriendBookRepo extends CrudRepository<UserProfileEntity, Integer> {

	/**
	 * Find by user name and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the optional
	 */
	Optional<UserProfileEntity> findByUserNameAndPassword(String username, String password);

	/**
	 * Find by user name or first name or last name.
	 *
	 * @param username  the username
	 * @param firstname the firstname
	 * @param lastname  the lastname
	 * @return the list
	 */
	List<UserProfileEntity> findByUserNameOrFirstNameOrLastName(String username, String firstname, String lastname);

}
