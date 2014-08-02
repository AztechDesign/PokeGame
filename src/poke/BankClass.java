package poke;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankClass {

    private int pokelets;
    private int bankBalance;
    private int transactionAmount;
    private String action;
    private String accountType;

    BankClass() {
        pokelets = 0;
        bankBalance = 0;
        transactionAmount = 0;
        accountType = "Student Saver";
    }

    void Enter(Scanner input) {
        System.out.println("Welcome to the bank!\nType deposit to deposit pokelets\nType withdraw to withdraw pokelets\nType upgrade to upgrade pokelets");
        System.out.println("You have " + pokelets + " pokelets");
        System.out.println("You are a " + accountType);
        System.out.println("Your account can hold a maximum of " + findMaxBalance() + " pokelets");
        System.out.println("It costs " + findUpgradeCost() + " pokelets to upgrade your account");
        System.out.println("When you withdraw pokelets, you lose " + (100 - taxWithdraw(100)) + "% of your pokelets");
        System.out.println("You have " + bankBalance + " pokelets in the bank and " + pokelets + " pokelets in your wallet");
        action = input.nextLine();
        if (action.equals("deposit")) {
            deposit(input);
        } else if (action.equals("withdraw")) {
            withdraw(input);
        } else if (action.equals("upgrade")) {
            upgrade(input);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    void deposit(Scanner input) {
        System.out.println("You have " + pokelets + " pokelets\nHow many pokelets would you like to deposit?");
        try {
            transactionAmount = input.nextInt();
        } catch (InputMismatchException e) {
            transactionAmount = 0;
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if (transactionAmount > 0) {
            if (pokelets >= transactionAmount) {
                if ((transactionAmount + bankBalance) <= findMaxBalance()) {
                    System.out.println("Thank you for depositing " + transactionAmount + " pokelets!");
                    bankBalance += transactionAmount;
                    pokelets = pokelets - transactionAmount;
                } else {
                    JOptionPane.showMessageDialog(null, "Your bank account can not hold that many pokelets", "UPGRADE REQUIRED", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You do not have that many pokelets", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    void withdraw(Scanner input) {
        System.out.println("You have " + bankBalance + " pokelets in your account\nHow many pokelets would you like to withdraw?");
        try {
            transactionAmount = input.nextInt();
        } catch (InputMismatchException e) {
            transactionAmount = 0;
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        if (transactionAmount > 1) {
            if (bankBalance >= transactionAmount) {
                System.out.println("You withdrew " + transactionAmount + " pokelets\nYou were taxed for your withdrawl\nYou got " + taxWithdraw(transactionAmount) + " pokelets");
                bankBalance = bankBalance - transactionAmount;
                pokelets = pokelets + taxWithdraw(transactionAmount);
                transactionAmount = 0;
            } else {
                JOptionPane.showMessageDialog(null, "You do not have that many pokelets in the bank", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    void upgrade(Scanner input) {
        if (accountType.equals("Very Important Member")) {
            System.out.println("You can not upgrade your account");
        } else {
            if (pokelets >= findUpgradeCost()) {
                pokelets = pokelets - findUpgradeCost();
                upgradeAccount();
                System.out.println("Thank you for upgrading your account!");
                switch (accountType) {
                    case "Very Important Member":
                        System.out.println("You are now a Very Important Member of the Millionaire Club\nYour account can hold 1,000,000,000 pokelets!");
                        break;
                    case "Bronze Member":
                        System.out.println("You have become a Bronze Member of the Millionaire Club!\nYour account can hold 1,000,000 pokelets!");
                        break;
                    default:
                        System.out.println("You are now a " + accountType + "!\nYour account can hold " + findMaxBalance() + " pokelets!");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "You do not have enough pokelets to upgrade your account\nYou need " + (findUpgradeCost() - pokelets) + " more pokelets to upgrade your account",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    int findUpgradeCost() {
        switch (accountType) {
            case "Student Saver":
                return 1000;
            case "Bronze Saver":
                return 2500;
            case "Super Bronze Saver":
                return 5000;
            case "Mega Bronze Saver":
                return 7500;
            case "Deluxe Bronze Saver":
                return 10000;
            case "Silver Saver":
                return 25000;
            case "Super Silver Saver":
                return 50000;
            case "Mega Silver Saver":
                return 75000;
            case "Deluxe Silver Saver":
                return 100000;
            case "Gold Saver":
                return 200000;
            case "Super Gold Saver":
                return 300000;
            case "Mega Gold Saver":
                return 400000;
            case "Deluxe Gold Saver":
                return 500000;
            case "Diamond Saver":
                return 600000;
            case "Super Diamond Saver":
                return 700000;
            case "Mega Diamond Saver":
                return 800000;
            case "Deluxe Diamond Saver":
                return 900000;
            case "Super Mega Deluxe Emerald Saver":
                return 1000000;
            case "Bronze Member":
                return 1250000;
            case "Super Bronze Member":
                return 1500000;
            case "Mega Bronze Member":
                return 1750000;
            case "Deluxe Bronze Member":
                return 2000000;
            case "Silver Member":
                return 2500000;
            case "Super Silver Member":
                return 5000000;
            case "Mega Silver Member":
                return 7500000;
            case "Deluxe Silver Member":
                return 10000000;
            case "Gold Member":
                return 25000000;
            case "Super Gold Member":
                return 50000000;
            case "Mega Gold Member":
                return 75000000;
            case "Deluxe Gold Member":
                return 100000000;
            case "Diamond Member":
                return 200000000;
            case "Super Diamond Member":
                return 300000000;
            case "Mega Diamond Member":
                return 400000000;
            case "Deluxe Diamond Member":
                return 500000000;
            case "Platinum Member":
                return 600000000;
            case "Super Platinum Member":
                return 700000000;
            case "Mega Platinum Member":
                return 800000000;
            case "Deluxe Platinum Member":
                return 900000000;
            case "Super Mega Deluxe Emerald Member":
                return 1000000000;
        }
        return 0;
    }

    void upgradeAccount() {
        switch (accountType) {
            case "Student Saver":
                accountType = "Bronze Saver";
                break;
            case "Bronze Saver":
                accountType = "Super Bronze Saver";
                break;
            case "Super Bronze Saver":
                accountType = "Mega Bronze Saver";
                break;
            case "Mega Bronze Saver":
                accountType = "Deluxe Bronze Saver";
                break;
            case "Deluxe Bronze Saver":
                accountType = "Silver Saver";
                break;
            case "Silver Saver":
                accountType = "Super Silver Saver";
                break;
            case "Super Silver Saver":
                accountType = "Mega Silver Saver";
                break;
            case "Mega Silver Saver":
                accountType = "Deluxe Silver Saver";
                break;
            case "Deluxe Silver Saver":
                accountType = "Gold Saver";
                break;
            case "Gold Saver":
                accountType = "Super Gold Saver";
                break;
            case "Super Gold Saver":
                accountType = "Mega Gold Saver";
                break;
            case "Mega Gold Saver":
                accountType = "Deluxe Gold Saver";
                break;
            case "Deluxe Gold Saver":
                accountType = "Diamond Saver";
                break;
            case "Diamond Saver":
                accountType = "Super Diamond Saver";
                break;
            case "Super Diamond Saver":
                accountType = "Mega Diamond Saver";
                break;
            case "Mega Diamond Saver":
                accountType = "Deluxe Diamond Saver";
                break;
            case "Deluxe Diamond Saver":
                accountType = "Super Mega Deluxe Emerald Saver";
                break;
            case "Super Mega Deluxe Emerald Saver":
                accountType = "Bronze Member";
                break;
            case "Bronze Member":
                accountType = "Super Bronze Member";
                break;
            case "Super Bronze Member":
                accountType = "Mega Bronze Member";
                break;
            case "Mega Bronze Member":
                accountType = "Deluxe Bronze Member";
                break;
            case "Deluxe Bronze Member":
                accountType = "Silver Member";
                break;
            case "Silver Member":
                accountType = "Super Silver Member";
                break;
            case "Super Silver Member":
                accountType = "Mega Silver Member";
                break;
            case "Mega Silver Member":
                accountType = "Deluxe Silver Member";
                break;
            case "Deluxe Silver Member":
                accountType = "Gold Member";
                break;
            case "Gold Member":
                accountType = "Super Gold Member";
                break;
            case "Super Gold Member":
                accountType = "Mega Gold Member";
                break;
            case "Mega Gold Member":
                accountType = "Deluxe Gold Member";
                break;
            case "Deluxe Gold Member":
                accountType = "Diamond Member";
                break;
            case "Diamond Member":
                accountType = "Super Diamond Member";
                break;
            case "Super Diamond Member":
                accountType = "Mega Diamond Member";
                break;
            case "Mega Diamond Member":
                accountType = "Deluxe Diamond Member";
                break;
            case "Deluxe Diamond Member":
                accountType = "Platinum Member";
                break;
            case "Platinum Member":
                accountType = "Super Platinum Member";
                break;
            case "Super Platinum Member":
                accountType = "Mega Platinum Member";
                break;
            case "Mega Platinum Member":
                accountType = "Deluxe Platinum Member";
                break;
            case "Deluxe Platinum Member":
                accountType = "Super Mega Deluxe Emerald Member";
                break;
            case "Super Mega Deluxe Emerald Member":
                accountType = "Very Important Member";
                break;
        }
    }

    int findMaxBalance() {
        switch (accountType) {
            case "Student Saver":
                return 500;
            case "Bronze Saver":
                return 1000;
            case "Super Bronze Saver":
                return 2500;
            case "Mega Bronze Saver":
                return 5000;
            case "Deluxe Bronze Saver":
                return 7500;
            case "Silver Saver":
                return 10000;
            case "Super Silver Saver":
                return 25000;
            case "Mega Silver Saver":
                return 50000;
            case "Deluxe Silver Saver":
                return 75000;
            case "Gold Saver":
                return 100000;
            case "Super Gold Saver":
                return 200000;
            case "Mega Gold Saver":
                return 300000;
            case "Deluxe Gold Saver":
                return 400000;
            case "Diamond Saver":
                return 500000;
            case "Super Diamond Saver":
                return 600000;
            case "Mega Diamond Saver":
                return 700000;
            case "Deluxe Diamond Saver":
                return 800000;
            case "Super Mega Deluxe Emerald Saver":
                return 900000;
            case "Bronze Member":
                return 1000000;
            case "Super Bronze Member":
                return 1250000;
            case "Mega Bronze Member":
                return 1500000;
            case "Deluxe Bronze Member":
                return 1750000;
            case "Silver Member":
                return 2000000;
            case "Super Silver Member":
                return 2500000;
            case "Mega Silver Member":
                return 5000000;
            case "Deluxe Silver Member":
                return 7500000;
            case "Gold Member":
                return 10000000;
            case "Super Gold Member":
                return 25000000;
            case "Mega Gold Member":
                return 50000000;
            case "Deluxe Gold Member":
                return 75000000;
            case "Diamond Member":
                return 100000000;
            case "Super Diamond Member":
                return 200000000;
            case "Mega Diamond Member":
                return 300000000;
            case "Deluxe Diamond Member":
                return 400000000;
            case "Platinum Member":
                return 500000000;
            case "Super Platinum Member":
                return 600000000;
            case "Mega Platinum Member":
                return 700000000;
            case "Deluxe Platinum Member":
                return 800000000;
            case "Super Mega Deluxe Emerald Member":
                return 900000000;
            case "Very Important Member":
                return 1000000000;
        }
        return 0;
    }

    int taxWithdraw(int lemonGuts) {
    	switch(accountType){
    	    case "Student Saver":
    			return lemonGuts / 2;
    		case "Bronze Saver":
    	    	lemonGuts = lemonGuts / 100;
            	return lemonGuts * 51;
    		case "Super Bronze Saver":
    		    lemonGuts = lemonGuts / 100;
            	return lemonGuts * 52;
    		case "Mega Bronze Saver":
	    	    lemonGuts = lemonGuts / 100;
            	return lemonGuts * 53;
    		case "Deluxe Bronze Saver":
	    	    lemonGuts = lemonGuts / 100;
            	return lemonGuts * 54;
    		case "Silver Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 56;
    		case "Super Silver Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 57;
    		case "Mega Silver Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 58;
    		case "Deluxe Silver Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 59;
    		case "Gold Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 61;
    		case "Super Gold Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 62;
    		case "Mega Gold Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 63;
    		case "Deluxe Gold Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 64;
    		case "Diamond Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 66;
    		case "Super Diamond Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 67;
    		case "Mega Diamond Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 68;
    		case "Deluxe Diamond Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 69;
    		case "Super Mega Deluxe Emerald Saver":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 70;
    		case "Bronze Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 74;
    		case "Super Bronze Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 75;
    		case "Mega Bronze Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 76;
    		case "Deluxe Bronze Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 77;
    		case "Silver Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 80;
    		case "Super Silver Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 81;
    		case "Mega Silver Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 82;
    		case "Deluxe Silver Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 83;
    		case "Gold Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 85;
    		case "Super Gold Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 86;
    		case "Mega Gold Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 87;
    		case "Deluxe Gold Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 88;
    		case "Diamond Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 90;
    		case "Super Diamond Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 91;
    		case "Mega Diamond Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 92;
    		case "Deluxe Diamond Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 93;
    		case "Platinum Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 95;
    		case "Super Platinum Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 96;
    		case "Mega Platinum Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 97;
    		case "Deluxe Platinum Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 98;
    		case "Super Mega Deluxe Emerald Member":
	    		lemonGuts = lemonGuts / 100;
            	return lemonGuts * 99;
    		case "Very Important Member":
	    		return lemonGuts;
    		default:
	    		JOptionPane.showMessageDialog(null, "ERROR BANKCLASS 530", "ERROR", JOptionPane.ERROR_MESSAGE);
    	}
	}

    void addpokelets(int valueToAdd) {
        pokelets = pokelets + valueToAdd;
    }

    void setpokelets(int valueToSet) {
        pokelets = valueToSet;
    }

    void dividepokelets(int PercentageLeft) {
        pokelets = pokelets / 100;
        pokelets = pokelets * PercentageLeft;
    }

    void subtractpokelets(int valueToSubtract) {
        pokelets = pokelets - valueToSubtract;
    }

    int getpokelets() {
        return pokelets;
    }
	//nothing here
}
