package com.cg.ibs.cardmanagement.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.ibs.cardmanagement.cardbean.CaseIdBean;
import com.cg.ibs.cardmanagement.cardbean.CreditCardBean;
import com.cg.ibs.cardmanagement.cardbean.DebitCardBean;
import com.cg.ibs.cardmanagement.dao.BankDao;
import com.cg.ibs.cardmanagement.dao.CustomerDao;
import com.cg.ibs.cardmanagement.dao.DaoClass;


public class CustomerServiceImpl implements CustomerService{
	
	
	
	CustomerDao customerDao=new DaoClass ();
	
	
	
	CaseIdBean caseIdObj = new CaseIdBean();

	Scanner scan = new Scanner(System.in);
	 
	

	 public CustomerServiceImpl() {
		super();
	}
	@Override
	 public void applyNewDebitCard(BigInteger accountNumber) {
	customerDao.newDebitCard(caseIdObj,accountNumber);
		     }
	@Override
	public void applyNewCreditCard(int creditScore, String incomeTaxReturns) {
       if(creditScore)
		
	}
	@Override
	public void resetCreditPin(BigInteger creditCardNumber, long currentCreditPin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetDebtitPin(BigInteger debitCardNumber, long currentDebitPin) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void requestDebitCardLost(BigInteger debitCardNumber) {
		// TODO Auto-generated method stub
		customerDao.requestDebitCardLost(caseIdObj,debitCardNumber);
		
	}
	@Override
	public void requestCreditCardLost(BigInteger creditCardNumber) {
		// TODO Auto-generated method stub
		customerDao.requestCreditCardLost(caseIdObj,creditCardNumber);
		
		
	}
	@Override
	public void requestDebitCardUpgrade(BigInteger debitCardNumber) {
		// TODO Auto-generated method stub
		
		
		
	}
	@Override
	public void requestCreditCardUpgrade(BigInteger creditCardNumber) {
		// TODO Auto-generated method stub
		
	}
	
	/*public TransactionBean showDebitCardStatement(Date fromDate, Date toDate, BigInteger debitCardNumber) {
		// TODO Auto-generated method stub
		return null;
	}*/
	@Override
	public void raiseDebitMismatchTicket(BigInteger debitCardNumber, BigInteger transactionId) {
		// TODO Auto-generated method stub
	}
	
	
	
	public List<DebitCardBean> viewAllDebitCards() {
		// TODO Auto-generated method stub
		
		 return customerDao.viewAllDebitCards();
	}
	@Override
	public List<CreditCardBean> viewAllCreditCards() {
		// TODO Auto-generated method stub
		return customerDao.viewAllCreditCards();
	
	}
	
	
	

}
 