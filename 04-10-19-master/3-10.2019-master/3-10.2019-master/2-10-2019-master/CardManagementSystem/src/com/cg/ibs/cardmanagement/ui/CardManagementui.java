
package com.cg.ibs.cardmanagement.ui;

import java.util.*;

import com.cg.ibs.cardmanagement.service.CustomerServiceImpl;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.cg.ibs.cardmanagement.cardbean.CaseIdBean;
import java.io.*;
import java.math.BigInteger;
enum CardMenu {
    APPLY_NEW_DEBIT_CARD, 
    
    APPLY_NEW_CREDIT_CARD, 
	UPGRADE_EXISTING_DEBIT_CARD,UPGRADE_EXISTING_CREDIT_CARD,
	RESET_DEBIT_CARD_PIN,RESET_CREDIT_CARD_PIN,
	REPORT_DEBIT_CARD_LOST,REPORT_CREDIT_CARD_LOST, 
	REQUEST_DEBIT_CARD_STATEMENT,REQUEST_CREDIT_CARD_STATEMENT,
	REPORT_DEBITCARD_STATEMENT_MISMATCH,REPORT_CREDITCARD_STATEMENT_MISMATCH,QUIT;
}
public class CardManagementui

{

	public static void main(String args[]) throws Exception{
		
		
		 
		
		BigInteger accountNumber;
		Scanner scan = new Scanner(System.in);
		 CardManagementui obj = new CardManagementui();
		 CustomerServiceImpl  customService=new CustomerServiceImpl();
		System.out.println("Welcome to card management System");
		System.out.println("Enter 1 to login as a customer");
		System.out.println("Enter 2 to login as a bank admin");
		int userInput = scan.nextInt();
		if(userInput==1){
			System.out.println("You are logged in as a customer");
			CardMenu choice = null;
			while (choice != CardMenu.QUIT) {
				System.out.println("Menu");
				System.out.println("--------------------");
				System.out.println("Choice");
				System.out.println("--------------------");
				for (CardMenu menu : CardMenu.values()) {
					System.out.println(menu.ordinal() + "\t" + menu);
				}
				System.out.println("Choice");
				int ordinal = scan.nextInt();
				if (ordinal >= 0 && ordinal < CardMenu.values().length) {
					choice = CardMenu.values()[ordinal];

					switch (choice) {
					case APPLY_NEW_DEBIT_CARD:
						
						System.out.println("Enter Account Number you want to apply debit card for :");
						accountNumber = scan.nextBigInteger();
					
						customService.applyNewDebitCard(accountNumber);
						break;
					case APPLY_NEW_CREDIT_CARD:
						
						System.out.println("You are applying for a new Credit Card");
						System.out.println("Enter Credit Score");
						int creditScore= scan.nextInt();
						System.out.println("Enter Url for Income Tax Returns");
						String incomeTaxReturns=scan.nextLine();
						customService.applyNewCreditCard(creditScore, incomeTaxReturns);
						
						break;
					case UPGRADE_EXISTING_DEBIT_CARD:
						break;
					case UPGRADE_EXISTING_CREDIT_CARD:
						break;
					case RESET_DEBIT_CARD_PIN:
						break;
					case RESET_CREDIT_CARD_PIN:
						break;
					case REPORT_DEBIT_CARD_LOST:
						
						System.out.println("Enter your Debit Card Number: ");
						BigInteger debitCardNumber;
						debitCardNumber=scan.nextBigInteger();
						customService.requestDebitCardLost(debitCardNumber);
						break;
					case REPORT_CREDIT_CARD_LOST:
						System.out.println("Enter your Credit Card Number: ");
						BigInteger creditCardNumber;
						creditCardNumber=scan.nextBigInteger();
						customService.requestCreditCardLost(creditCardNumber);
						break;
					case REQUEST_DEBIT_CARD_STATEMENT:
						break;
					case REQUEST_CREDIT_CARD_STATEMENT:
						break;
					case REPORT_DEBITCARD_STATEMENT_MISMATCH:
						break;
					case REPORT_CREDITCARD_STATEMENT_MISMATCH:
						break;
					case QUIT:
						System.out.println("App Closed.");
						break;
					}
				} else {
					System.out.println("Invalid Option!!");
					choice = null;
				}
			}			
		
		

		

	
		

	}
				}
				}
