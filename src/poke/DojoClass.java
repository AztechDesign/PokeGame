package poke;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DojoClass {

    private String rank;
    private String action;
    private int classes;
    private int purchaseAmount;
    private int classesNeeded;
    private int testFee;
    private int compHP;
    private int userHP;
    private int compAction;
    private int consecutiveBlocks;
    private int consecutiveAttacks;
    private int consecutiveCompBlocks;
    private int consecutiveCompAttacks;
    private int crit;
    private boolean validAction;
    private boolean text;
    private boolean Stats;
    private String compActionString;
    private String userAction;
    private int wonMatch;
    private int a;
    private int b;
    private int c;
    private int place;
    private String settingThing;
    
    DojoClass() {
        rank = "Peasant";
        classes = 0;
        classesNeeded = 10;
        text = true;
        Stats = true;
    }// constructor

    /*
     "ADVANCED" DOJO RELATED METHODS START HERE
     */
    //*********************************************************************************************************************************************************
    String Enter(Scanner input) {
        System.out.println("Welcome to the dojo!\nThe higher rank you are, the fas"
        		+ "ter you can poke!\nType register to register for classes\nType train to participate in classes\n"
        		+ "Type test to test for your next rank\nType tournament to register and participate in a tournament\nType ranking t"
        		+ "o see your ranking\nType help for more information about the dojo\nType settings to view and change f"
        		+ "ighting settings\nType leave to leave");
        if(classesNeeded == 0){
        	System.out.println("You are eligible to test!");
        	System.out.println("The testing fee is " + findFee() + " pokelets");
        }else{
        	if (classes == 1) {
        		System.out.println("You have 1 paid for class!");
        	} else {
        		System.out.println("You have " + classes + " paid for classes!");
        	}
        	
        	if (classesNeeded == 1) {
        		System.out.println("You only need to participate in 1 more class to be eligible to test!");
        	} else {
        		System.out.println("You need to participate in " + classesNeeded + " more classes to be eligible to test!");
        	}
        }
        System.out.println("Your rank is: " + rank);
        action = input.nextLine();
        action = action.toLowerCase();
        return action;

    }//end of enter method

  //*********************************************************************************************************************************************************
    
    int tournament(Scanner input) {
        if(rank.equals("Peasant")){
        	JOptionPane.showMessageDialog(null, "Peasants can not compete in tournaments", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
        	return tourFightSequence(input);
        }
        return 0;
    }
    
  //*********************************************************************************************************************************************************
    
    void help() {
        System.out.println("Nobody is at the front desk to help you\nMaybe in the next update, someone will be here to help you");
    }

    //*********************************************************************************************************************************************************
    int register(int pokelets, int costPerClass, Scanner input) {
        System.out.println("How many classes would you like to buy?\nYou have " + pokelets + " pokelets\nOne class for someone of your rank costs " + costPerClass + " pokelets");
        try {
            purchaseAmount = input.nextInt();
        }// end of try
        catch (InputMismatchException e) {
            purchaseAmount = 0;
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }//end of catch
        if (purchaseAmount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if (pokelets >= costPerClass * purchaseAmount) {
            if (purchaseAmount <= 330) {
                classes = classes + purchaseAmount;
                if (classes != 1) {
                    System.out.println("You have successfully registered for " + purchaseAmount + " classes!\nParticipate in these classes by training at the dojo!");
                } else {
                    System.out.println("You have successfully registered for 1 class!\nParticipate in this class by training at the dojo!");
                }
                return costPerClass * purchaseAmount;
            } else {
                JOptionPane.showMessageDialog(null, "You do not need that many classes", "ERROR", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "You do not have enough pokelets to buy that many classes", "ERROR", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }// end of register method

    //*********************************************************************************************************************************************************
    void train(Scanner input) {
        if (classes >= 1) {
            if (classesNeeded >= 1) {
                classes = classes - 1;
                classesNeeded = classesNeeded - 1;
                spar(input);
                if (classesNeeded == 0) {
                    System.out.println("You are ready to test!");
                } else if (classesNeeded == 1) {
                    System.out.println("You only need to participate in 1 more class to be eligible to test!");
                    if (classes >= 1) {
                        System.out.println("Would you like to train again?\nType yes or no");
                        action = input.nextLine();
                        action = action.toLowerCase();
                        if (action.equals("yes")) {
                            train(input);
                        } else if (action.equals("no")) {
                            System.out.println("Oh\nToo bad");
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("You have no more paid for classes");
                    }
                } else {
                    System.out.println("You need to participate in " + classesNeeded + " more classes to be eligible to test!");
                    if (classes >= 1) {
                        System.out.println("Would you like to train again?\nType yes or no");
                        action = input.nextLine();
                        action = action.toLowerCase();
                        if (action.equals("yes")) {
                            train(input);
                        } else if (action.equals("no")) {
                            System.out.println("Oh\nToo bad");
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("You have no more paid for classes");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You are elgible to test!\nDo not waste your time training!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You do not have any paid for classes\nYou must register for classes!", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    //*********************************************************************************************************************************************************
    int test(int pokelets, String newRank, Scanner input) {
        testFee = findFee();
        if (classesNeeded == 0) {
            if (pokelets >= testFee) {
                System.out.println("The test fee was " + testFee + " pokelets");
                wonMatch = testFight(input);
                if (wonMatch == 1) {
                    rank = newRank;
                    classesNeeded = findClassesNeeded();
                    classes = 0;
                    System.out.println("You passed with flying colors!\nYour new rank: " + rank + "!");
                } else {
                    System.out.println("You failed the test\nYou must participate in 5 more classes to be eligible to test again");
                    classesNeeded = 5;
                }
                return testFee;
            } else {
                System.out.println("You do not have enough pokelets to pay the testing fee\nThe fee is " + testFee + " pokelets\nYou have " + pokelets + " pokelets\nYou need "
                        + (findFee() - pokelets) + " more pokelets to pay the testing fee");
            }
        } else {
            System.out.println("You are not eligible to test\nYou must train and prove that you are worthy of testing");
        }
        return 0;
    }

    //*********************************************************************************************************************************************************
    void ranking() {
        System.out.println("Peasant\n   Ninja Trainee\n   Ninja Amateur\n   Ninja\n   Ninja Pro\n   Ninja Instructor\n      Samurai Trainee\n      Samurai Amateur\n"
                + "      Samurai\n      Samurai Pro\n      Samurai Instructor\n         Assistant Sensei\n         Sensei\n            Dayimo\n               Emperor\n"
                + "Your rank: " + rank);
    }

    //*********************************************************************************************************************************************************
    
    void settings(Scanner input){
    	do{
    	System.out.println("***************SETTINGS**************");
    	if(Stats == true){
    		System.out.println("Stats: ON");
    	}else{
    		System.out.println("Stats: OFF");
    	}
    	if(text == true){
    		System.out.println("Text: ON");
    	}else{
    		System.out.println("Text: OFF");
    	}
    	System.out.println("*************************************");
    	System.out.println("Type toggletext to toggle text\nType togglestats to toggle stats\nType leave to leave");
    		settingThing = input.nextLine();
    		settingThing = settingThing.toLowerCase();
    		if(settingThing.equals("toggletext")){
    			System.out.println("Text has been toggled");
    			if(text == true){
    				text = false;
    			}else{
    				text = true;
    			}
    		}else if(settingThing.equals("togglestats")){
    			System.out.println("Stats have been toggled");
    			if(Stats == true){
    				Stats = false;
    			}else{
    				Stats = true;
    			}
    		}else if(settingThing.equals("leave")){
    			//DO NOTHING!!!
    		}else{
    			settingThing = "toggletext"; // it becomes toggle text so that it loops again
    			System.out.println("Invalid option, please try again\nType toggletext to toggle text"
    					+ "\nType togglestats to toggle stats\nType leave to leave");
    		}
    	}while(settingThing.equals("toggletext") || settingThing.equals("togglestats"));
    }
    
    /*
    simple methods start here
    */    
    
    int getTF(){
    	//Could make switch of rank.substring(0,4), but seems like too much work
    	//it is(0,4) because if it was 0,3 then for assistant sensei...
    	if(rank.equals("Peasant")){
        	JOptionPane.showMessageDialog(null, "Peasants can not compete in tournaments", "ERROR", JOptionPane.ERROR_MESSAGE);
    	}else if(rank.substring(0,3).equals("Nin")){
        	return 6250;
        }else if(rank.substring(0,3).equals("Sam")){
        	return 62500;
        }else if(rank.equals("Assistant Sensei")){ 
        	return 625000;
        }else if(rank.equals("Sensei")){   
        	return 6250000;
        }else if(rank.equals("Emperor")){
        	return 62500000;
        }else{
        	JOptionPane.showMessageDialog(null, "ERROR DOJOCLASS 282", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    void printTypeOfTournament(){
    	if(rank.substring(0,3).equals("Nin")){
    		System.out.println("*********NINJA TOURNAMENT!***********");
        }else if(rank.substring(0,3).equals("Sam")){
        	System.out.println("********SAMURAI TOURNAMENT!**********");
        }else if(rank.equals("Assistant Sensei")){ 
        	System.out.println("*****ASSISTANT SENSEI TOURNAMENT!****");
        }else if(rank.equals("Sensei")){   
        	System.out.println("*********SENSEI TOURNAMENT!**********");
        }else if(rank.equals("Emperor")){
        	System.out.println("********EMPEROR TOURNAMENT!**********");
        }else{
        	JOptionPane.showMessageDialog(null, "ERROR DOJOCLASS 291", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    int tourFightSequence(Scanner input){
    	Random generator = new Random();
    	System.out.println("*************************************");
    	printTypeOfTournament();
        System.out.println("*************************************");
        System.out.println("*********QUALIFYING ROUND!***********");
        setFightingVars(0,0);
        fightSequence(input);
        if(userHP == 0){
        	place = generator.nextInt(8) + 9;
        	System.out.println("You placed " + place + "th out of 16");
        	System.out.println("Your performance proved that you deserve 0 pokelets");
        	return 0;
        }else if(compHP == 0){
        	System.out.println("*************************************");
        	System.out.println("********YOU HAVE QUALIFIED!**********");
        	System.out.println("*************************************");
        	System.out.println("**********QUARTER FINALS!************");
        	setFightingVars(0,2); // give user no bonus and comp 2 HP bonus and set consectuive pokes and blocks for player and user to zero
        	fightSequence(input);
        	if(userHP == 0){
        		place = generator.nextInt(4) + 5;
        		System.out.println("You placed " + place + "th out of 16");
        		System.out.println("Your performance proved that you deserve 0 pokelets");
        		return 0;
        	}else if(compHP == 0){
        		System.out.println("*************************************");
            	System.out.println("YOU HAVE ADVANCED TO THE SEMI-FINALS!");
            	System.out.println("*************************************");
            	System.out.println("***********SEMI-FINALS!**************");
            	setFightingVars(0,3);
            	fightSequence(input);
            	if(userHP == 0){
            		place = generator.nextInt(2) + 3;
            		switch(place){
            			case 3:
            				System.out.println("You placed 3rd out of 16");
            				break;
            			case 4:
            				System.out.println("You placed 4th out of 16");
            				break;
        				default:
        					System.out.println("ERROR DOJOCLASS line 337");
            		}
            		System.out.println("Your performance proved that you deserve 0 pokelets");
            		return 0;
            	}else if(compHP == 0){
            		System.out.println("*************************************");
                	System.out.println("***YOU HAVE ADVANCED TO THE FINALS!**");
                	System.out.println("*************************************");
                	System.out.println("***************FINALS****************");
                	setFightingVars(0,5);
                	fightSequence(input);
                	if(userHP == 0){
                		System.out.println("You placed 2nd out of 16");
                		System.out.println("Your performance proved that you deserve 0 pokelets");
                		return 0;
                	}else if(compHP == 0){
                		System.out.println("*************************************");
                    	System.out.println("*******YOU WON THE TOURNAMENT!******");
                    	System.out.println("************************************");
                    	System.out.println("");
                    	System.out.println("Your performance proved that you deserve " + (getTF()*16) + " pokelets!");
                    	return (getTF()*16);
                	}
            	}//advance to finals else if
        	}//advance to semi-finals else if
        }//advance to quarter finals else if
        return 0;
    }
    
    int findUserHP() {
        if (rank.equals("Peasant")) {
            return 3;
        } else if (rank.substring(0,3).equals("Nin")) {
            return 5;
        } else if (rank.substring(0,3).equals("Sam")) {
            return 6;
        } else if (rank.equals("Assistant Sensei")) {
            return 7;
        } else if (rank.equals("Sensei")) {
            return 8;
        } else if (rank.equals("Dayimo")) {
            return 9;
        } else if (rank.equals("Emperor")) {
            return 10;
        } else {
            System.out.println("ERROR DOJOCLASS line 214");
            return 0;
        }
    }

    void setFightingVars(int userBonus, int compBonus){
    	userHP = findUserHP() + userBonus;
    	compHP = getcompHP() + compBonus;
    	consecutiveAttacks = 0;
        consecutiveBlocks = 0;
        consecutiveCompBlocks = 0;
        consecutiveCompAttacks = 0;
    }
    int testFight(Scanner input) {
        System.out.println("*************************************");
        System.out.println("***********TIME TO TEST!*************");
        setFightingVars(0,getcompHP());
        fightSequence(input);
        if (userHP <= 0) {
            System.out.println("*************************************");
            System.out.println("********YOU FAILED YOUR TEST*********");
            System.out.println("*************************************");
            return 0;
        }
        if (compHP <= 0) {
            System.out.println("*************************************");
            System.out.println("********YOU PASSED YOUR TEST*********");
            System.out.println("*************************************");
            return 1;
        }
        System.out.println("");
        System.out.println("*************FINAL SCORE*************");
        System.out.println("Your HP: " + userHP + "           Opponent HP: " + compHP);
        System.out.println("*************************************");
        return 0;
    }


    void spar(Scanner input) {
        setFightingVars(0,0);
        System.out.println("*************************************");
        System.out.println("***********TIME TO SPAR!*************");
        fightSequence(input);
        if (userHP <= 0) {
            System.out.println("*************************************");
            System.out.println("*********YOU LOST THE MATCH**********");
            System.out.println("*************************************");
            userHP = 0;
        }
        if (compHP <= 0) {
            System.out.println("*************************************");
            System.out.println("**********YOU WON THE MATCH**********");
            System.out.println("*************************************");
            compHP = 0;
        }
        System.out.println("");
        System.out.println("*************FINAL SCORE*************");
        System.out.println("Your HP: " + userHP + "           Opponent HP: " + compHP);
        System.out.println("*************************************");
        System.out.println("");
    }

    void fightSequence(Scanner input){
    	Random generator = new Random();
    	do {
            //start user attack
            do {
                if (Stats == true) {
                    System.out.println("*************************************");
                    System.out.println("You                          Opponent");
                    System.out.format("HP:%2d                        HP: %d\n", userHP, compHP);
                    System.out.format("CP:%2d                        CP: %d\n", consecutiveAttacks, consecutiveCompAttacks);
                    System.out.println("CB: " + consecutiveBlocks + "                        CB: " + consecutiveCompBlocks);
                }
                System.out.println("**************ATTACK*****************"); // print stars for less confusion
                validAction = false;
                System.out.println("Choose your attack: legpoke, stomachpoke, or headpoke");
                userAction = input.nextLine();
                userAction = userAction.toLowerCase();
                //end user attack
                if (userAction.equals("legpoke") || userAction.equals("stomachpoke") || userAction.equals("headpoke")) {
                    validAction = true;
                    compAction = generator.nextInt(3) + 1;// start comp block
                    switch (compAction) {
                        case 1:
                            compActionString = "legpoke";
                            if (text == true) {
                                System.out.println("Your opponent blocked their legs");
                            }
                            break;
                        case 2:
                            compActionString = "stomachpoke";
                            if (text == true) {
                                System.out.println("Your opponent blocked their stomach");
                            }
                            break;
                        case 3:
                            compActionString = "headpoke";
                            if (text == true) {
                                System.out.println("Your opponent blocked their head");
                            }

                    }//end comp block
                    // comp blocks with legpoke so that strings can be compared instead of having to deal with all nine possibilities
                    if (userAction.equals(compActionString)) {
                        consecutiveCompBlocks = consecutiveCompBlocks + 1;
                        if (consecutiveAttacks >= 3) {
                            if (text == true) {
                                System.out.println("Your opponent has ended your poking spree!\nYour opponent got +" + consecutiveAttacks + " HP!");
                            }
                            compHP = compHP + consecutiveAttacks;
                        }
                        consecutiveAttacks = 0;
                        if (text == true) {
                            System.out.println("Your attack was blocked!\nYour opponent took no damage"); // code for comp blocking correctly
                        }
                    } else {                            // code for scoring
                        consecutiveAttacks = consecutiveAttacks + 1;
                        if (consecutiveCompBlocks >= 3) {
                            if (text == true) {
                                System.out.println("You ended your opponent's blocking spree!\nYou got +" + consecutiveCompBlocks + " HP!");
                            }
                            userHP = userHP + consecutiveCompBlocks;
                        }
                        consecutiveCompBlocks = 0;
                        if (userAction.equals("legpoke")) {
                            if (text == true) {
                                System.out.println("You poked your opponent's leg!");
                            }
                        } else if (userAction.equals("stomachpoke")) {
                            if (text == true) {
                                System.out.println("You poked your opponent's stomach!"); // say where they hit the person
                            }
                        } else if (userAction.equals("headpoke")) {
                            if (text == true) {
                                System.out.println("You poked your opponent's head!");
                            }
                        }
                        crit = generator.nextInt(userHP);
                        if (crit == 0) {
                            if (text == true) {
                                System.out.println("Your poke was super effective!\nIt dealt 3 damage!");
                            } else {
                                System.out.println("Super Effective Poke!");
                            }
                            compHP = compHP - 3;
                        } else {
                            if (text == true) {
                                System.out.println("Your poke was not very effective...\nIt only dealt 1 damage...");
                            }
                            compHP = compHP - 1; // make comp take damage
                        }
                    }

                    if (consecutiveAttacks == 3) {
                        if (text == true) {
                            System.out.println("Poking Spree!\nYour opponent lost 3 HP!");
                        }else{
                        	System.out.println("Poking Spree!");
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveAttacks == 4) {
                        if (text == true) {
                            System.out.println("Poking Spree!\nYour opponent lost 1 HP!");
                        }else{
                        	System.out.println("Poking Spree!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveAttacks == 5) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 5 HP!");
                        }else{
                        	System.out.println("Super Poking Spree!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveAttacks == 6 || consecutiveAttacks == 7 || consecutiveAttacks == 8 || consecutiveAttacks == 9) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 2 HP!");
                        }else{
                        	System.out.println("Super Poking Spree!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveAttacks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 10 HP!");
                        }else{
                        	System.out.println("Legendary Poking Spree!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 3 HP!");
                        }else{
                        	System.out.println("Legendary Poking Spree!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompBlocks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 3 HP!");
                        } else{
                        	System.out.println("Blocking Spree!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompBlocks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 1 HP!");
                        }else{
                        	System.out.println("Blocking Spree!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompBlocks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 5 HP!");
                        }else{
                        	System.out.println("Super Blocking Spree!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompBlocks == 6 || consecutiveCompBlocks == 7 || consecutiveCompBlocks == 8 || consecutiveCompBlocks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 2 HP!");
                        }else{
                        	System.out.println("Super Blocking Spree!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompBlocks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 10 HP!");
                        }else{
                        	System.out.println("Legendary Blocking Spree!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompBlocks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 3 HP!");
                        }else{
                        	System.out.println("Legendary Blocking Spree!");
                        }
                        userHP = userHP - 3;
                    }

                    if (compHP == 1 && text == true) {
                        System.out.println("Your opponent can only take 1 more hit!");
                    } else {
                        if (compHP <= 5 && text == true && compHP > 1) {
                            System.out.println("Your opponent can only take " + compHP + " more hits!");
                        } else if (text == true && compHP > 5) {
                            System.out.println("Your opponent can take " + compHP + " more hits!");
                        }
                    }
                    
                    if(userHP <= 0 && text == true){
                    	System.out.println("You fainted!\nBetter luck next time!");
                    }
                } else {
                    //if user inputs wrong data
                    System.out.println("Invalid Attack\nTry again");
                    validAction = false;
                }
            } while (validAction == false);

            if (compHP <= 0 || userHP <= 0) {
                break;
            }
            if (Stats == true) {
                System.out.println("*************************************");
                System.out.println("You                          Opponent");
                System.out.format("HP:%2d                        HP: %d\n", userHP, compHP);
                System.out.format("CP:%2d                        CP: %d\n", consecutiveAttacks, consecutiveCompAttacks);
                System.out.println("CB: " + consecutiveBlocks + "                        CB: " + consecutiveCompBlocks);
            }
            System.out.println("**************DEFEND*****************"); // print stars for less confusion

            //end of code for user attack
            //start code for user defend
            do {
                validAction = false;
                System.out.println("Choose where to block: legblock, stomachblock, or headblock");
                userAction = input.nextLine();
                userAction = userAction.toLowerCase();
                if (userAction.equals("legblock") || userAction.equals("stomachblock") || userAction.equals("headblock")) {
                    validAction = true;
                    compAction = generator.nextInt(3) + 1;
                    switch (compAction) {
                        case 1:
                            compActionString = "legblock";
                            break;
                        case 2:
                            compActionString = "stomachblock";
                            break;
                        case 3:
                            compActionString = "headblock";
                    }//find out where comp poked

                    //custom messages for user blocking right part
                    if (userAction.equals(compActionString)) {
                        consecutiveBlocks = consecutiveBlocks + 1; // add one block for the user
                        if (consecutiveCompAttacks >= 3) {
                            if (text == true) {
                                System.out.println("You ended your opponent's poking spree!\nYou got +" + consecutiveCompAttacks + " HP!");
                            }
                            userHP = userHP + consecutiveCompAttacks;
                        }
                        consecutiveCompAttacks = 0;
                        if (text == true) {
                            switch (compActionString) {
                                case "legblock":
                                    System.out.println("Your opponent tried to poke your leg\nBut you blocked their poke!\nYou took no damage!");
                                    break;
                                case "stomachblock":
                                    System.out.println("Your opponent tried to poke your stomach\nBut you blocked their poke!\nYou took no damage!");
                                    break;
                                case "headblock":
                                    System.out.println("Your opponent tried to poke your head\nBut you blocked their poke!\nYou took no damage!");
                            }
                        }
                    } else {
                        //if user blocked wrong part then,
                        consecutiveCompAttacks = consecutiveCompAttacks + 1; // add one attack for comp
                        if (consecutiveBlocks >= 3) {
                            if (text == true) {
                                System.out.println("Your opponent has ended your blocking spree!\nYour opponent got +" + consecutiveBlocks + " HP!");
                            }
                            compHP = compHP + consecutiveBlocks;
                        }
                        consecutiveBlocks = 0;
                        if (text == true) {
                            switch (compAction) {//tell user what happened
                                case 1:
                                    System.out.println("Your opponent poked your leg!");
                                    break;
                                case 2:
                                    System.out.println("Your opponent poked your stomach!");
                                    break;
                                case 3:
                                    System.out.println("Your opponent poked your head!");
                            }
                        }
                        //code for changing values becuase user got hit
                        crit = generator.nextInt(compHP);
                        if (crit == 0) {
                            if (text == true) {
                                System.out.println("Your opponent's poke was super effective!\nIt dealt 3 damage!");
                            } else {
                                System.out.println("Super Effective Poke!");
                            }
                            userHP = userHP - 3;
                        } else {
                            if (text == true) {
                                System.out.println("Your opponent's poke was not very effective...\nIt only dealt 1 damage...");
                            }
                            userHP = userHP - 1; // make comp take damage
                        }
                    }
                    if (consecutiveBlocks == 3) {
                        if (text == true) {
                            System.out.println("Blocking Spree!\nYour opponent lost 3 HP!");
                        }else{
                        	System.out.println("Blocking Spree!");
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveBlocks == 4) {
                        if (text == true) {
                            System.out.println("Blocking Spree!\nYour opponent lost 1 HP!");
                        }else{
                        	System.out.println("Blocking Spree!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveBlocks == 5) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 5 HP!");
                        }else{
                        	System.out.println("Super Blocking Spree!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveBlocks == 6 || consecutiveBlocks == 7 || consecutiveBlocks == 8 || consecutiveBlocks == 9) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 2 HP!");
                        }else{
                        	System.out.println("Super Blocking Spree!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveBlocks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 10 HP!");
                        }else{
                        	System.out.println("Legendary Blocking Spree!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveBlocks >= 11) {
                        if (text == true){
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 3 HP!");
                        }else{
                        	System.out.println("Legendary Blocking Spree!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompAttacks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 3 HP!");
                        }else{
                        	System.out.println("Poking Spree!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompAttacks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 1 HP!");
                        }else{
                        	System.out.println("Poking Spree!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompAttacks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 5 HP!");
                        }else{
                        	System.out.println("Super Poking Spree!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompAttacks == 6 || consecutiveCompAttacks == 7 || consecutiveCompAttacks == 8 || consecutiveCompAttacks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 2 HP!");
                        }else{
                        	System.out.println("Super Poking Spree!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompAttacks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 10 HP!");
                        }else{
                        	System.out.println("Legendary Poking Spree!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 3 HP!");
                        }else{
                        	System.out.println("Legendary Poking Spree!");
                        }
                        userHP = userHP - 3;
                    }
                    //tell user how many hp they have left
                    if (userHP == 1 && text == true) {
                        System.out.println("You can only take 1 more hit!");
                    } else {
                        if (userHP <= 5 && text == true && userHP > 1) {
                            System.out.println("You can only take " + userHP + " more hits!");
                        } else if (text == true && userHP > 5) {
                            System.out.println("You can take " + userHP + " more hits!");
                        }
                    }
                } else {
                    System.out.println("Invalid block\nTry again");
                    validAction = false;
                }
            } while (validAction == false);

        } while (userHP > 0 && compHP > 0);
    	if(userHP <= 0){
    		System.out.println("You fainted!");
    		userHP = 0;
    	}
    	if(compHP <= 0){
    		System.out.println("Your opponent fainted!");
    		compHP = 0;
    	}
    }
    
    int getcompHP() {
    	switch(rank){
    		case "Peasant":
    			return 1;
    		case "Ninja Trainee":
    			return 2;
    		case "Ninja Amateur":
    			return 3;
    		case "Ninja":
    			return 4;
    		case "Ninja Pro":
    			return 5;
    		case "Ninja Instructor":
    			return 6;
    		case "Samurai Trainee":
    			return 7;
    		case "Samurai Amateur":
    			return 8;
    		case "Samurai":
    			return 9;
    		case "Samurai Pro":
    			return 10;
    		case "Samurai Instructor":
    			return 11;
    		case "Assistant Sensei":
    			return 12;
    		case "Sensei":
    			return 13;
    		case "Dayimo":
    			return 14;
    		case "Emperor":
    			return 15;
			default:
				return 100000;
    	}
    }
    String getRank() {
        return rank;
    }//end of rank getter

    int findCostPerClass() {
    	switch(rank){
			case "Peasant":
				return 500;
			case "Ninja Trainee":
				return 1000;
			case "Ninja Amateur":
				return 2500;
			case "Ninja":
				return 5000;
			case "Ninja Pro":
				return 7500;
			case "Ninja Instructor":
				return 10000;
			case "Samurai Trainee":
				return 25000;
			case "Samurai Amateur":
				return 50000;
			case "Samurai":
				return 75000;
			case "Samurai Pro":
				return 100000;
			case "Samurai Instructor":
				return 250000;
			case "Assistant Sensei":
				return 500000;
			case "Sensei":
				return 750000;
			case "Dayimo":
				return 1000000;
			default:
				return 0;
    	}
    }//end of cost of class method

    int findFee() {
        a = findCostPerClass();
        b = findClassesNeeded();
        c = a * b;
        return c / 2;
    }//end of test fee finder

    String findNewRank() {
    	switch(rank){
			case "Peasant":
				return "Ninja Trainee";
			case "Ninja Trainee":
				return "Ninja Amateur";
			case "Ninja Amateur":
				return "Ninja";
			case "Ninja":
				return "Ninja Pro";
			case "Ninja Pro":
				return "Ninja Instructor";
			case "Ninja Instructor":
				return "Samurai Trainee";
			case "Samurai Trainee":
				return "Samurai Amateur";
			case "Samurai Amateur":
				return "Samurai";
			case "Samurai":
				return "Samurai Pro";
			case "Samurai Pro":
				return "Samurai Instructor";
			case "Samurai Instructor":
				return "Assistant Sensei";
			case "Assistant Sensei":
				return "Sensei";
			case "Sensei":
				return "Dayimo";
			case "Dayimo":
				return "Emperor";
			default:
				return "DOJO 855";
    	}
       
    }

    int findClassesNeeded() {
    	switch(rank){
			case "Peasant":
				return 10;
			case "Ninja Trainee":
				return 25;
			case "Ninja Amateur":
				return 50;
			case "Ninja":
				return 75;
			case "Ninja Pro":
				return 100;
			case "Ninja Instructor":
				return 125;
			case "Samurai Trainee":
				return 150;
			case "Samurai Amateur":
				return 175;
			case "Samurai":
				return 200;
			case "Samurai Pro":
				return 225;
			case "Samurai Instructor":
				return 250;
			case "Assistant Sensei":
				return 275;
			case "Sensei":
				return 300;
			case "Dayimo":
				return 325;
			default:
				return 10000;
    	}
    }//end of findClassesNeeded method

    int getSpeed() {
    	switch(rank){
    		case "Peasant":
    			return 75;
    		case "Ninja Trainee":
    			return 70;
    		case "Ninja Amateur":
    			return 65;
    		case "Ninja":
    			return 60;
    		case "Ninja Pro":
    			return 55;
    		case "Ninja Instructor":
    			return 50;
    		case "Samurai Trainee":
    			return 45;
    		case "Samurai Amateur":
    			return 40;
    		case "Samurai":
    			return 35;
    		case "Samurai Pro":
    			return 30;
    		case "Samurai Instructor":
    			return 25;
    		case "Assistant Sensei":
    			return 20;
    		case "Sensei":
    			return 15;
    		case "Dayimo":
    			return 10;
    		case "Emperor":
    			return 5;
    		default:
    			return 5000;
    	}
    }// end of get speed
}//end of class

