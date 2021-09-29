package com.lti.repository;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Transaction;

public interface TransactionDao {

	
//	addTransaction(int fromAct, int toAcc);
//	viewTransactionByAccoutNo(int accountNo);
//	viewAccountDetails(int accountNo);

	Account addAccountWithMultipleTransactions(Account account);

	//1st method
	Account addATransactionToAnAccount(Account account);
	
	//2nd method
	List<Transaction> fetchAllTransactionsOfAnAccount(int accountNo);

	//3rd
	Account fetchAccountDetailsByTransactionId(int transactionId);
	
	//4th
	Beneficiary addBeneficiaryToAnAccount(Beneficiary beneficiary);
	
	//5th
	List<Beneficiary> fetchAllBeneficiaryOfAnAccount(int accountNo);

    //6th
    List<Account> updateAccountBalanceOnTransaction(Beneficiary beneficiary,int amount);
    
    //7th
    Beneficiary findBeneficiaryById(int beneficiaryId);

}

