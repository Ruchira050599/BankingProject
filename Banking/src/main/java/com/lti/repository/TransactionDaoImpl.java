package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@PersistenceContext
	EntityManager em;
	
	AccountDao accDao;
	
	@Override
	@Transactional
	public Account addATransactionToAnAccount(Account account) {	
		Account acc = em.merge(account);
		return acc;
	}
	@Override
	public List<Transaction> fetchAllTransactionsOfAnAccount(int accountNo) {
		String jpql = "select trans from Transaction trans where accountNo=:accId";
		Query query = em.createQuery(jpql);
		query.setParameter("accId", accountNo);
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}

	@Override
	public Account fetchAccountDetailsByTransactionId(int transactionId) {
		return em.find(Transaction.class, transactionId).getAccount();
	}

	@Override
	@Transactional
	public Beneficiary addBeneficiaryToAnAccount(Beneficiary beneficiary) {
		Beneficiary bene = em.merge(beneficiary);
		return bene;
	}
	
	@Override
	public List<Beneficiary> fetchAllBeneficiaryOfAnAccount(int accountNo) {
		String jpql = "select b from Beneficiary b where accountNo=:accId";
		Query query = em.createQuery(jpql);
		query.setParameter("accId", accountNo);
		List<Beneficiary> beneficiary = query.getResultList();
		return beneficiary;
	}
	@Override
	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		return em.find(Beneficiary.class,beneficiaryId);
	}
	
	//-----------------------------------------------------------------------//
	
	
	
	
	
	
	@Override
    @Transactional
	public Account addAccountWithMultipleTransactions(Account account) {
		Account acc = em.merge(account);	
		return acc;
	}
	@Override
	public List<Account> updateAccountBalanceOnTransaction(Beneficiary beneficiary, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Account> updateAccountBalanceOnTransaction(Beneficiary beneficiary,int amount) {
//		
//		Account  fromAccount=beneficiary.getAccount();
//		Account acc = em.merge(fromAccount);
//		
//	
//		int fromAccountBalance=fromAccount.getBalance();
//		int fromBal=fromAccountBalance-amount;
//		fromAccount.setBalance(fromBal);
//		Account fa=accDao.addAccountWithAnExistingCustomer(fromAccount);
//		
//		Account toAccount=accDao.findAccountByAccountNo(beneficiary.getToAccountNo());
//		
//		int toAccountBalance=toAccount.getBalance();
//		int toBal=toAccountBalance+amount;
//		toAccount.setBalance(toBal);
//		Account ta=accDao.addAccountWithAnExistingCustomer(toAccount);
//		
//		
//		List<Account> accounts=new ArrayList<>();
//		accounts.add(acc);
//		accounts.add(fa);
//		accounts.add(ta);
//		
//		return accounts;
//		
//	}

	
}
