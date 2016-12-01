/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.bidservice.domain.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author avish9 Resource representing a User within the system.
 */
public class User {

	/** user id of given user. */
	private int userId;

	/** The user given (first)name. */
	@NotEmpty(message = "Please enter name")
	private String firstName;

	/** The user given (last) name. */
	private String lastName;

	/** The user preferred user name. */
	@NotEmpty(message = "Please enter user name")
	@Email
	private String userName;

	/** The user preferred password. */
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;

	/** The user's preferred address. */
	@NotEmpty(message = "Please enter address")
	private String address;

	/** user creation date */
	private Date createDate;

	/**
	 * @return user id.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * set user id.
	 * 
	 * @param userId.
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return username of given user.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * set username of given user.
	 * 
	 * @param userName.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return user password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set user password.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return user address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set user address.
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return user creation date.
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * set user creation date
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;

		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ",  userName="
				+ userName + ", password=" + password + ", address=" + address + ", createDate=" + createDate + "]";
	}
}
