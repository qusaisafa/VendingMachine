package com.vendingmachine.app;

import java.util.Scanner;

import com.vendingmachine.model.Code;
import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Notes;

public class Test {

	public static void main(String args[]) {
		VendingMachineImp vendingMachine = new VendingMachineImp();
		Scanner sc = new Scanner(System.in);	

		while(true) {
			System.out.println("\n Please insert money using :");
			System.out.println("1-coin inserter");
			System.out.println("2-card");
			System.out.println("3-notes");
			
			if(sc.nextInt() == 1) {
				System.out.println("insert coins(C10, C20, C50, DOLLAR)");
				System.out.println("enter E after adding all coins");

				String input = sc.next();
				while(!input.equals("E")) {
					try {
						vendingMachine.insertCoins(Coin.valueOf(input));
					}catch(Exception e) {
						e.printStackTrace();
					}
					input = sc.next();
				}
				
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					input = sc.next();
					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(Code.valueOf(input));
					System.out.println("snack picked successfully");
					System.out.println("money back ="+moneyBack);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(sc.nextInt() == 2){
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					Code code = Code.valueOf(sc.next());
					vendingMachine.insertCard(code);
					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(code);
					
					System.out.println("money back ="+moneyBack);
					System.out.println("snack picked successfully");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(sc.nextInt() == 3) {
				System.out.println("insert Notes(N20, N50)");
				System.out.println("enter E after adding all Notes");

				String input = sc.next();
				while(!input.equals("E")) {
					try {
						vendingMachine.insertNotes(Notes.valueOf(input));
					}catch(Exception e) {
						e.printStackTrace();
					}
					input = sc.next();
				}
				
				try {
					System.out.println("enter snack code(A B C D E 1 2 3 4 5)");
					double moneyBack = vendingMachine.pickupSnackReturnExtraMoney(Code.valueOf(sc.next()));
					if(moneyBack >= 0) {
						System.out.println("snack picked successfully");
						System.out.println("money back ="+moneyBack);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		 }
		}
	}
}
