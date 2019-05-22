package com.main.service;

import com.main.model.User;

public interface UserServIntf {

	User saveUser(User user);

	User findUserByUnameAndPasswd(User user);

	User findUserById(int userId);

}
