package com.tqk.secure;

import java.io.Serializable;

/**
*
* @author khaitq on 22 juin 2018
*/

public class User  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2680812159042559303L;
	
	private String username;
	
	private String password;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}


