package com.main.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Transaction;


@Repository
public interface TransactionRepoIntf extends CrudRepository<Transaction,Integer> {



	@Query(value = "select * from transaction where user_id=?1",nativeQuery = true)
	List<Transaction> findTransactionById(int id);

	@Query(value = "SELECT user_id, SUM(COALESCE(CASE WHEN pay_type = 'credit' THEN amount END,0)) total_credits  , SUM(COALESCE(CASE WHEN pay_type = 'debit' THEN amount END,0)) total_debits , SUM(COALESCE(CASE WHEN pay_type = 'credit' THEN amount END,0))- SUM(COALESCE(CASE WHEN pay_type = 'debit' THEN amount END,0)) balance,MONTHNAME(DATE)FROM TRANSACTION WHERE user_id=1 GROUP BY MONTH(DATE)",nativeQuery = true)   
	List<?> findReportById(int userId);

}
