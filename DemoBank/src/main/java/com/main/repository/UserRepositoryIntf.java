package com.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepositoryIntf extends CrudRepository<User,Integer>{



	User findUserByUnameAndPasswd(String uname, String passwd);

	User findUserById(int id);

}
