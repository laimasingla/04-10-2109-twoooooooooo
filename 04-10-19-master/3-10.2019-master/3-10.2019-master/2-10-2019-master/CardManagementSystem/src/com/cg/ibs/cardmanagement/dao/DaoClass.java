package com.cg.ibs.cardmanagement.dao;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.cg.ibs.cardmanagement.cardbean.CaseIdBean;
import com.cg.ibs.cardmanagement.cardbean.CreditCardBean;
import com.cg.ibs.cardmanagement.cardbean.CreditCardTransaction;
import com.cg.ibs.cardmanagement.cardbean.CustomerBean;
import com.cg.ibs.cardmanagement.cardbean.DebitCardBean;
import com.cg.ibs.cardmanagement.cardbean.DebitCardTransaction;


public class DaoClass  implements CustomerDao , BankDao{

	
	static long caseIdGenTwo=0;

    CaseIdBean caseIdObj= new CaseIdBean();
	private static Map<BigInteger ,DebitCardTransaction> debitCardTransactionDetails = new HashMap<BigInteger, DebitCardTransaction>();
	private static Map<String ,CreditCardTransaction> creditCardTransactionDetails = new HashMap<String , CreditCardTransaction>();
	private static Map<String, CaseIdBean> queryDetails = new HashMap<String, CaseIdBean>();
    private static Map<BigInteger, DebitCardBean> debitCardDetails = new HashMap<BigInteger, DebitCardBean>();
	private static Map<BigInteger, CreditCardBean> creditCardDetails = new HashMap<BigInteger, CreditCardBean>();
	private static Map<BigInteger, CustomerBean> customerDetails = new HashMap<BigInteger, CustomerBean>();
	
	
		String caseIdGenOne=" ";
		  String caseIdTotal=" ";
		  
		  String addToQueryTable(String caseIdGenOne) {
				caseIdTotal = caseIdGenOne+caseIdGenTwo;
				caseIdGenTwo++;
				return caseIdTotal;
				}
	
	
	static{
		
		DebitCardBean debit1= new DebitCardBean(new BigInteger("1234567890"), new BigInteger("1234567891012131"),true, "Laima", 067,1234,LocalDate.now(),"7894561239632587","Platinum");
		DebitCardBean debit2= new DebitCardBean(new BigInteger("1234547890"), new BigInteger("1234562391012131"),true, "Pragya", 057,1034,LocalDate.now(),"7894561239632587","Gold");
		DebitCardBean debit3= new DebitCardBean(new BigInteger("0234567890"), new BigInteger("3234567891012131"),true, "Shubham", 167,2234,LocalDate.now(),"7894561239632587","Silver");
		
		
		debitCardDetails.put(debit1.getDebitCardNumber(), debit1);
		debitCardDetails.put(debit2.getDebitCardNumber(),debit2);
		debitCardDetails.put(debit3.getDebitCardNumber(),debit3);
		
		CreditCardBean credit1= new CreditCardBean(new BigInteger("9012345678"),new BigInteger("1234567891012132"),true, "Laima",623,9856,LocalDate.now(),"7894561239632587"," ",200,new BigDecimal("1000000.00"),"gfdgfgfdgf" );
		CreditCardBean credit2= new CreditCardBean(new BigInteger("1234567890"),new BigInteger("1234569891012132"),true, "Pragya",683,9056,LocalDate.now(),"7894561239632587"," ",100,new BigDecimal("500000.00"),"gfdgfgfdgf" );
		CreditCardBean credit3= new CreditCardBean(new BigInteger("9018945678"),new BigInteger("2234567891012132"),true, "Mohit",223,9256,LocalDate.now(),"7894561239632587"," ",230,new BigDecimal("100000.00"),"gfdgfgfdgf" );
		
		creditCardDetails.put(credit1.getCreditCardNumber(),credit1);
		creditCardDetails.put(credit2.getCreditCardNumber(),credit2);
		creditCardDetails.put(credit3.getCreditCardNumber(),credit3);
		
		
		CustomerBean cust1 = new CustomerBean(new BigInteger("1234567890"), "7894561239632587","laima","singla","email.@gmail.com","65231351","42165431");
		CustomerBean cust2 = new CustomerBean(new BigInteger("9012345678"), "7894561239832587","laima","singla","email.@gmail.com","65233351","49165431");
		customerDetails.put(cust1.getAccountNumber(),cust1);
		customerDetails.put(cust2.getAccountNumber(),cust2);
	}
	
    public DaoClass() {
		super();
	}
    

	public DaoClass( CaseIdBean caseIdObj, String caseIdGenOne, String caseIdTotal) {
		super();
		
		this.caseIdObj = caseIdObj;
		this.caseIdGenOne = caseIdGenOne;
		this.caseIdTotal = caseIdTotal;
	}

	 
	
	public void newDebitCard(CaseIdBean customIdBean, BigInteger accountNumber) {


		   Boolean accountNumberResult= customerDetails.containsKey(accountNumber);
		   if(accountNumberResult) {
			   customIdBean.setAccountNumber(accountNumber);
			   caseIdGenOne="ANDC";
				LocalDate timestamp = LocalDate.now();
		
				caseIdObj.setCaseIdTotal(addToQueryTable(caseIdGenOne));
				caseIdObj.setCaseTimeStamp(timestamp);
				caseIdObj.setStatusOfQuery("Pending");
				caseIdObj.setUCI(caseIdObj.getUCI());
				caseIdObj.setCardNumber(null);
	         	queryDetails.put(customIdBean.getCaseIdTotal(),customIdBean);
		        System.out.println("Successfully applied");
              }
		     else {
			   System.out.println("Account number does not exist");
			   
		   }
		
	}
	
	@Override
	public void viewAllQueries(CaseIdBean  caseIdObj) {
		
		
		
		}
	
	@Override
	public List<DebitCardBean> viewAllDebitCards() {
		List <DebitCardBean > debitCards = new ArrayList();
		
		
		 for(Entry<BigInteger, DebitCardBean> entry:debitCardDetails.entrySet()) {
		debitCards.add(entry.getValue());}
		return debitCards;
		  
		
	}
	
	public List<CreditCardBean> viewAllCreditCards() {
		List <CreditCardBean > creditCards = new ArrayList();
		
		
		 for(Entry<BigInteger, CreditCardBean> entry:creditCardDetails.entrySet()) {
		creditCards.add(entry.getValue());}
		return creditCards;
		  
}
	public void requestDebitCardLost(CaseIdBean customIdBean, BigInteger debitCardNumber) {
		   Boolean debitCardResult= debitCardDetails.containsKey(debitCardNumber);
		   System.out.println(debitCardResult);
		   if(debitCardResult) {
			   customIdBean.setCardNumber(debitCardNumber);
			   
			   caseIdGenOne="RDCL";
			   LocalDate timestamp = LocalDate.now();
				
				caseIdObj.setCaseIdTotal(addToQueryTable(caseIdGenOne));
				caseIdObj.setCaseTimeStamp(timestamp);
				caseIdObj.setStatusOfQuery("Pending");
				caseIdObj.setUCI(caseIdObj.getUCI());
		        queryDetails.put(customIdBean.getCaseIdTotal(),customIdBean);
		        System.out.println("TICKET RAISED SUCCESSFULLY");}
		        else {
			    System.out.println("INVALID DEBIT CARD NUMBER");
			   
		         }
		 
	}
	
	public void requestCreditCardLost(CaseIdBean customIdBean, BigInteger creditCardNumber) {
		   Boolean creditCardResult= customerDetails.containsKey(creditCardNumber);
		   if(creditCardResult) {
			   customIdBean.setCardNumber(creditCardNumber);
			   
			   caseIdGenOne="RCCL";
			   LocalDate timestamp = LocalDate.now();
				
				caseIdObj.setCaseIdTotal(addToQueryTable(caseIdGenOne));
				caseIdObj.setCaseTimeStamp(timestamp);
				caseIdObj.setStatusOfQuery("Pending");
				caseIdObj.setUCI(caseIdObj.getUCI());
		        queryDetails.put(customIdBean.getCaseIdTotal(),customIdBean);
		        System.out.println("TICKET RAISED SUCCESSFULLY");}
		         else {
			     System.out.println("INVALID CREDIT CARD NUMBER");
			   
		   }
		
	}








}