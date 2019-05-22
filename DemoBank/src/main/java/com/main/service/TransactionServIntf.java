package com.main.service;

import java.util.List;

import com.main.model.Transaction;

public interface TransactionServIntf {

	public boolean save(Transaction transaction);

	public List<Transaction> findById(int userId);

	public List<?> findReportById(int userId);

}
