package com.main.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Transaction;
import com.main.repository.TransactionRepoIntf;

@Service
@Transactional
public class TransactionServImpl implements TransactionServIntf{

	@Autowired
	TransactionRepoIntf transRepo;
	
	public boolean save(Transaction transaction) {
		Transaction trans=transRepo.save(transaction);
		if(trans.getTid()>0) {
		return true;
		}
		else {
			return false;
		}
	}


	public List<Transaction> findById(int id) {
	
		return transRepo.findTransactionById(id);
	}



	public List<?> findReportById(int userId) {
		
		return transRepo.findReportById(userId);
	}

}
