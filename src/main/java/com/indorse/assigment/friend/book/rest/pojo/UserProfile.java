package com.indorse.assigment.friend.book.rest.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * PoJo class mapping for Rest Controller
 * 
 * @author nosheen
 */
@Data
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserProfile {

	/** The id. */
	private Integer id;

	/** The first name. */
	@NotBlank
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The user name. */
	@NotBlank
	private String userName;

	/** The password. */
	@NotBlank
	private String password;

	/** The confirm pwd. */
	@NotBlank
	private String confirmPwd;

	/** The email address. */
	@Email
	private String emailAddress;

	/** The friends. */
	private List<UserProfile> friends = new ArrayList<>();

}
