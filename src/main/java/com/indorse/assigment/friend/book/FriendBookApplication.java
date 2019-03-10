package com.indorse.assigment.friend.book;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starter Classfor FriendBookApplication
 * 
 * @author nosheen
 */
@SpringBootApplication(scanBasePackages = { "com.indorse.assigment" })
public class FriendBookApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		configureSystem();
		SpringApplication.run(FriendBookApplication.class, args);
	}

	/**
	 * Configure system.
	 */
	private static void configureSystem() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
