package com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.User;
import com.main.repository.UserRepositoryIntf;

@Service
@Transactional
public class UserServImpl implements UserServIntf{

	
	@Autowired
	UserRepositoryIntf userRepo;
	
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}

	
	public User findUserByUnameAndPasswd(User user) {
		User user1;
		try {
			String uname=user.getUname();
			String passwd=user.getPasswd();
      user1 = userRepo.findUserByUnameAndPasswd(uname,passwd);
      return user1;

		} catch (Exception e) {
			return null;
		}	
	}



	public User findUserById(int id) {
		
		return userRepo.findUserById(id);
	}

}
