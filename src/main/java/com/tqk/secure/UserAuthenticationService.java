package com.tqk.secure;

import java.util.Optional;

/**
*
* @author khaitq on 17 juin 2018
*/

public interface UserAuthenticationService {
	
	  Optional<String> login(String username, String password);


}


