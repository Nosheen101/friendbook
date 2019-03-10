package com.indorse.assigment.friend.book.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indorse.assigment.friend.book.entity.UserProfileEntity;
import com.indorse.assigment.friend.book.exception.FriendBookException;
import com.indorse.assigment.friend.book.repo.FriendBookRepo;
import com.indorse.assigment.friend.book.rest.pojo.UserProfile;
import com.indorse.assigment.friend.book.service.FriendBookService;

import lombok.extern.slf4j.Slf4j;

/**
 * implementation Class containing the business logic for friendBook and also
 * responsible for communicating with data bank.
 *
 * @author nosheen
 */

@Service
/** The Constant log. */
@Slf4j
public class FriendBookServiceImpl implements FriendBookService {

	/** The Constant USER_NOT_FOUND. */
	private static final String USER_NOT_FOUND = "user not found";

	/** The repository. */
	@Autowired
	private FriendBookRepo repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.indorse.assigment.friend.book.service.FriendBookService#signUp(com.
	 * indorse.assigment.friend.book.rest.pojo.UserProfile)
	 */
	public void signUp(UserProfile userProfile) {
		validateUserprofile(userProfile);
		UserProfileEntity entity = buildUserProfileEntity(userProfile);
		repository.save(entity);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#getUsersList()
	 */
	@Override
	public List<UserProfile> getUsersList() {
		Iterable<UserProfileEntity> iterable = repository.findAll();
		List<UserProfile> users = new ArrayList<>();
		for (UserProfileEntity userProfileEntity : iterable) {
			users.add(prepareUserProfile(userProfileEntity));
		}

		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#login(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void login(String username, String password) {
		Optional<UserProfileEntity> returnEntity = repository.findByUserNameAndPassword(username, password);
		if (!returnEntity.isPresent()) {
			throw new FriendBookException(USER_NOT_FOUND);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#searchUser(java.
	 * lang.String)
	 */
	@Override
	public List<UserProfile> searchUser(String name) {
		List<UserProfile> users = new ArrayList<>();
		List<UserProfileEntity> entities = repository.findByUserNameOrFirstNameOrLastName(name, name, name);
		for (UserProfileEntity userProfileEntity : entities) {
			users.add(prepareUserProfile(userProfileEntity));
		}

		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#addFriends(java.
	 * lang.String, java.util.List)
	 */
	@Override
	public void addFriends(String userId, List<Integer> ids) {
		Optional<UserProfileEntity> user = repository.findById(Integer.parseInt(userId));
		if (user.isPresent()) {
			List<UserProfileEntity> friends = new ArrayList();
			for (UserProfileEntity id : repository.findAllById(ids)) {
				friends.add(id);
			}
			log.info("friend list size: " + friends.size());
			user.get().setFriends(friends);
			repository.save(user.get());

		} else {
			throw new FriendBookException(USER_NOT_FOUND);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#removeFriends(
	 * java.lang.String, java.util.List)
	 */
	@Override
	public void removeFriends(String userId, List<Integer> ids) {
		Optional<UserProfileEntity> user = repository.findById(Integer.parseInt(userId));

		if (user.isPresent()) {

			for (Integer id : ids) {
				user.get().getFriends().removeIf(e -> e.getId().equals(id));
			}
			log.info("friend list size: " + user.get().getFriends().size());
			repository.save(user.get());
		} else {
			throw new FriendBookException(USER_NOT_FOUND);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.indorse.assigment.friend.book.service.FriendBookService#getUserId(java.
	 * lang.String)
	 */
	@Override
	public UserProfileEntity getUserId(@NotNull String username) {
		Optional<UserProfileEntity> userEntity = repository.findById(Integer.parseInt(username));
		if (userEntity.isPresent()) {
			return userEntity.get();
		} else {
			throw new FriendBookException(USER_NOT_FOUND);
		}

	}

	/**
	 * Prepare user profile.
	 *
	 * @param userProfileEntity the user profile entity
	 * @return the user profile
	 */
	private UserProfile prepareUserProfile(UserProfileEntity userProfileEntity) {
		UserProfile model = null;
		if (userProfileEntity != null) {
			model = new UserProfile();
			model.setId(userProfileEntity.getId());
			model.setEmailAddress(userProfileEntity.getEmailAddress());
			model.setFirstName(userProfileEntity.getFirstName());
			model.setLastName(userProfileEntity.getLastName());
			model.setPassword(userProfileEntity.getPassword());
			model.setUserName(userProfileEntity.getUserName());

			if (userProfileEntity.getFriends() != null && !userProfileEntity.getFriends().isEmpty()) {
				log.info("Friend for {} is {}" + userProfileEntity.getUserName(),
						userProfileEntity.getFriends().size());
				for (UserProfileEntity friend : userProfileEntity.getFriends()) {
					model.getFriends().add(prepareUserProfile(friend));
				}
			}

		}

		return model;
	}

	/**
	 * Validate userprofile.
	 *
	 * @param userProfile the user profile
	 */
	private void validateUserprofile(UserProfile userProfile) {
		if (!userProfile.getPassword().equals(userProfile.getConfirmPwd())) {
			throw new FriendBookException("password and confirm password not matched");
		}

	}

	/**
	 * Builds the user profile entity.
	 *
	 * @param userProfile the user profile
	 * @return the user profile entity
	 */
	private UserProfileEntity buildUserProfileEntity(UserProfile userProfile) {
		UserProfileEntity entity = new UserProfileEntity();
		entity.setEmailAddress(userProfile.getEmailAddress());
		entity.setFirstName(userProfile.getFirstName());
		entity.setLastName(userProfile.getLastName());
		entity.setPassword(userProfile.getPassword());
		entity.setUserName(userProfile.getUserName());

		return entity;
	}

}
