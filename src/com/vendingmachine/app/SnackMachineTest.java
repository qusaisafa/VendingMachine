package com.vendingmachine.app;

import java.util.Scanner;
import com.vendingmachine.model.Code;
import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Notes;

public class SnackMachineTest {

	public static void main(String args[]) {
		SnackMachineInterface vendingMachine = new SnackMachineImp();
		Scanner sc = new Scanner(System.in);	
		while(true) {
			System.out.println("==============");
			System.out.println("snacks on the machine with code and price");
			System.out.println(vendingMachine.printMachine());
			System.out.println("\n Please insert money using :");
			System.out.println("1-coin inserter");
			System.out.println("2-card");
			System.out.println("3-notes");
			System.out.println("4-cancel");

			int choiceInput = sc.nextInt();
			if(choiceInput == 1) {
				System.out.println("insert coins(C10, C20, C50, DOLLAR)");
				System.out.println("enter ok after adding all coins");

				String input = sc.next();
				while(!input.equals("ok")) {
					try {
						vendingMachine.insertCoins(Coin.valueOf(input));
					}catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("moneyInserted="+vendingMachine.getInsertedMoney());
					input = sc.next();
				}
				
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					input = sc.next();
					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(Code.valueOf(input));
					System.out.println("snack "+input+" picked successfully");
					System.out.println("money back ="+moneyBack+"$");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(choiceInput == 2){
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					String input = sc.next();
					Code code = Code.valueOf(input);
					vendingMachine.insertCard(code);
					System.out.println("money Cashed out from card="+vendingMachine.getInsertedMoney()+"$");

					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(code);
					
					System.out.println("money back ="+moneyBack);
					System.out.println("snack "+input+" picked successfully");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(choiceInput == 3) {
				System.out.println("insert Notes(N20, N50)");
				System.out.println("insert ok after adding all Notes");

				String input = sc.next();
				while(!input.equals("ok")) {
					try {
						vendingMachine.insertNotes(Notes.valueOf(input));
					}catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("moneyInserted="+vendingMachine.getInsertedMoney());
					input = sc.next();
				}
				
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(Code.valueOf(sc.next()));
					if(moneyBack >= 0) {
						System.out.println("snack "+input+" picked successfully");
						System.out.println("money back ="+moneyBack);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		 }else if(choiceInput == 4) {
			 System.out.println("operation canceled ");
			 System.out.println("money Back ="+vendingMachine.cancelAndReturnMoney());
		 }else {
			 System.out.println("incorrect input");
		 }
		}
	}
	
}
