package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.AccountDao;
import com.lti.repository.TransactionDao;
import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	AccountDao accDao;
	
	@Override
	public Account addAccountWithMultipleTransactions(Account account) {
		
		return transactionDao.addAccountWithMultipleTransactions(account);
	}

	@Override
	public Account addATransactionToAnAccount(Account account) {
		
		return transactionDao.addATransactionToAnAccount(account);
	}
	
	@Override
	public List<Transaction> fetchAllTransactionsOfAnAccount(int accountNo) {
		
		return transactionDao.fetchAllTransactionsOfAnAccount(accountNo);
	}

	@Override
	public Account fetchAccountDetailsByTransactionId(int transactionId) {
		
		return transactionDao.fetchAccountDetailsByTransactionId(transactionId);
	}

	@Override
	public List<Account> updateAccountBalanceOnTransaction(Beneficiary beneficiary,int amount) {
		
		return transactionDao.updateAccountBalanceOnTransaction(beneficiary,amount);
	}

	@Override
	public Beneficiary addBeneficiaryToAnAccount(Beneficiary beneficiary) {
		
		return transactionDao.addBeneficiaryToAnAccount(beneficiary);
	}

	@Override
	public List<Beneficiary> fetchAllBeneficiaryOfAnAccount(int accountNo) {
		
		return transactionDao.fetchAllBeneficiaryOfAnAccount(accountNo);
	}

	@Override
	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		return transactionDao.findBeneficiaryById(beneficiaryId);
	}
}
