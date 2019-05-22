package com.demobank.testservices;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.main.service.TransactionServImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoBankApplication.class)
public class TransactionServiceTest {

	@Mock
	TransactionRepoIntf transactionRepo;
	
	@Mock
	UserRepositoryIntf userRepo;
	
	@InjectMocks
	TransactionServImpl transactionServ;
	
	@Test 
	public void getTransactionById() {
		List<Transaction> transList = new ArrayList<Transaction>();
		
		Transaction transOne = new Transaction(1,"pay","credit",1000);
		
		transList.add(transOne);
		
		Mockito.when(transactionRepo.findTransactionById(1)).thenReturn(transList);
		
		List<Transaction> list = transactionServ.findById(1);
		
		assertThat(transList).isEqualTo(list);
		
	}
	
	/*
	 * @Test public void getReportById() { List<Report> reportList = new
	 * ArrayList<Report>();
	 * 
	 * Report reportOne = new Report(1,1000.0,0.0,10000.0);
	 * 
	 * reportList.add(reportOne);
	 * 
	 * Mockito.when(transactionRepo.findReportById(1)).thenReturn((List<Report>)
	 * reportList);
	 * 
	 * List<Report> list =(List<Report>) transactionServ.findReportById(1);
	 * 
	 * assertThat(reportList).isEqualTo(list);
	 * 
	 * }
	 */
	
	@Test
	public void getSave() {
				
		Transaction trans = new Transaction(1,"pay","credit",1000);
		
		Mockito.when(transactionRepo.save(trans)).thenReturn(trans);
		
		boolean transOne = transactionServ.save(trans);
		
		boolean string;
		if(trans.getTid() >= 1) {
			string = true;
		}
		else {
			string = false;
		}
		assertTrue(transOne);
		assertTrue(string);
	}
	
	@Test
	public void getTransaction() {
		Transaction trans =new Transaction();
		trans.setTid(1);
		trans.setPayType("credit");
		trans.setDescription("pay");
		trans.setAmount(1000.0);
		trans.setDate(new Date());
        User user= new User(1,"logeshwar","sekar","logesh","pass","logesh@xyz.com",10000.0);
		trans.setUser(user);
		Date date = new Date();
		assertTrue(trans.getTid()==1);
		assertTrue(trans.getPayType()=="credit");
		assertTrue(trans.getDescription()=="pay");
		assertTrue(trans.getAmount()==1000.0);
		assertThat(trans.getUser()==user);
		assertThat(trans.getDate()).isAfterOrEqualsTo(date);
	}
}