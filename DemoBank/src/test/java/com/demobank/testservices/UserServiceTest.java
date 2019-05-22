package com.demobank.testservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.DemoBankApplication;
import com.main.model.Transaction;
import com.main.model.User;
import com.main.repository.TransactionRepoIntf;
import com.main.repository.UserRepositoryIntf;
import com.main.service.UserServImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoBankApplication.class)
public class UserServiceTest {
	
	@Mock
	UserRepositoryIntf userRepo;
	
	@Mock
	TransactionRepoIntf transactionRepo;
	
	@InjectMocks
	UserServImpl userServ;

	
	@Test
	public void getUserById() {
		
		User user= new User(1,"logeshwar","sekar","logesh","pass","logesh@xyz.com",10000.0);
		
		Mockito.when(userRepo.findUserById(1)).thenReturn(user);
		
		User userOne = userServ.findUserById(1);
		
		assertThat(user).isEqualTo(userOne);
		
	}
	
	@Test
	public void getUserByUnameAndPasswd() {
		User user= new User(1,"logeshwar","sekar","logesh","pass","logesh@xyz.com",10000.0);
		
		Mockito.when(userRepo.findUserByUnameAndPasswd("logesh","pass")).thenReturn(user);
		
		User userOne = userServ.findUserByUnameAndPasswd(user);
		
		assertThat(user).isEqualTo(userOne);

	}
	
	@Test
	public void getSaveUser() {
		User user= new User(1,"logeshwar","sekar","logesh","pass","logesh@xyz.com",10000.0);
		
		Mockito.when(userRepo.save(user)).thenReturn(user);
		
		User userOne = userServ.saveUser(user);
		
		assertThat(user).isEqualTo(userOne);

	}
	
	@Test
	public void getUser() {
		User user = new User();
		user.setId(1);
		user.setFname("logeshwar");
		user.setLname("sekar");
		user.setUname("logesh");
		user.setPasswd("pass");
		user.setEmail("logesh@xyz.com");
		user.setDate(new Date());
		user.setBalance(10000.0);
        List<Transaction> transList = new ArrayList<Transaction>();
		Transaction transOne = new Transaction(1,"pay","credit",1000);
		transList.add(transOne);
		user.setTransactions(transList);
		Date date = new Date();
		assertTrue(user.getId()==1);
		assertTrue(user.getFname()=="logeshwar");
		assertTrue(user.getLname()=="sekar");
		assertTrue(user.getUname()=="logesh");
		assertTrue(user.getPasswd()=="pass");
		assertTrue(user.getEmail()=="logesh@xyz.com");
		assertTrue(user.getBalance()==10000.0);
		assertThat(user.getDate()).isAfterOrEqualsTo(date);
		assertThat(user.getTransactions().size()).isEqualTo(1);
		assertEquals(user.getTransactions().size(),transList.size());
	}	
}