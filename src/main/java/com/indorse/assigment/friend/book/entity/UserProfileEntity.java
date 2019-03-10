package com.indorse.assigment.friend.book.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mapping Class for database.
 * 
 * @author nosheen
 */
@Entity
@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
public class UserProfileEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user profile entity.
	 *
	 * @param id the id
	 */
	public UserProfileEntity(Integer id) {
		this.id = id;
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/** The email address. */
	private String emailAddress;

	/** The friends. */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<UserProfileEntity> friends;

}
