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
        System.out.println("Welcome to the dojo!\nThe higher rank you are, the faster you can poke!\nType register to register for classes\nType train to participate in classes\nType test to test for your next rank\nType tournament to register and participate in a tournament\nType ranking to see your ranking\nType help for more information about the dojo");
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
        System.out.println("Your rank is: " + rank);
        action = input.nextLine();
        return action;

    }//end of enter method

    int tournament() {
        System.out.println("The stadium is under construction\nPlease come back later");
        return 0;
    }

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
    int findUserHP() {
        if (rank.equals("Peasant")) {
            return 3;
        } else if (rank.equals("Ninja Trainee") || rank.equals("Ninja Amateur") || rank.equals("Ninja") || rank.equals("Ninja Pro") || rank.equals("Ninja Instructor")) {
            return 5;
        } else if (rank.equals("Samurai Trainee") || rank.equals("Samurai Amateur") || rank.equals("Samurai") || rank.equals("Samurai") || rank.equals("Samurai Instructor")) {
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

    int testFight(Scanner input) {
        Random generator = new Random();
        userHP = findUserHP();
        compHP = getcompHP() * 2;
        consecutiveAttacks = 0;
        consecutiveBlocks = 0;
        consecutiveCompBlocks = 0;
        consecutiveCompAttacks = 0;
        System.out.println("*************************************");
        System.out.println("***********TIME TO TEST!*************");
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
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveAttacks == 4) {
                        if (text == true) {
                            System.out.println("Poking Spree!\nYour opponent lost 1 HP!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveAttacks == 5) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 5 HP!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveAttacks == 6 || consecutiveAttacks == 7 || consecutiveAttacks == 8 || consecutiveAttacks == 9) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 2 HP!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveAttacks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 10 HP!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 3 HP!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompBlocks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompBlocks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 1 HP!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompBlocks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 5 HP!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompBlocks == 6 || consecutiveCompBlocks == 7 || consecutiveCompBlocks == 8 || consecutiveCompBlocks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 2 HP!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompBlocks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 10 HP!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompBlocks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    }

                    if (compHP <= 0 && text == true) {
                        System.out.println("Your opponent fainted!");
                    } else if (compHP == 1 && text == true) {
                        System.out.println("Your opponent can only take 1 more hit!");
                    } else {
                        if (compHP <= 5 && text == true) {
                            System.out.println("Your opponent can only take " + compHP + " more hits!");
                        } else if (text == true && compHP > 5) {
                            System.out.println("Your opponent can take " + compHP + " more hits!");
                        }
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
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveBlocks == 4) {
                        if (text == true) {
                            System.out.println("Blocking Spree!\nYour opponent lost 1 HP!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveBlocks == 5) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 5 HP!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveBlocks == 6 || consecutiveBlocks == 7 || consecutiveBlocks == 8 || consecutiveBlocks == 9) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 2 HP!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveBlocks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 10 HP!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveBlocks >= 11) {
                        {
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 3 HP!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompAttacks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompAttacks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 1 HP!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompAttacks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 5 HP!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompAttacks == 6 || consecutiveCompAttacks == 7 || consecutiveCompAttacks == 8 || consecutiveCompAttacks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 2 HP!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompAttacks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 10 HP!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    }
                    //tell user how many hp they have left
                    if (userHP <= 0 && text == true) {
                        System.out.println("You fainted!\nBetter luck next time!");
                    } else if (userHP == 1 && text == true) {
                        System.out.println("You can only take 1 more hit!");
                    } else {
                        if (userHP <= 5 && text == true) {
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
    /*
     simple methods start here
     */

    void spar(Scanner input) {
        Random generator = new Random();
        userHP = findUserHP();
        compHP = getcompHP();
        consecutiveAttacks = 0;
        consecutiveBlocks = 0;
        consecutiveCompBlocks = 0;
        consecutiveCompAttacks = 0;
        System.out.println("*************************************");
        System.out.println("***********TIME TO SPAR!*************");
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
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveAttacks == 4) {
                        if (text == true) {
                            System.out.println("Poking Spree!\nYour opponent lost 1 HP!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveAttacks == 5) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 5 HP!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveAttacks == 6 || consecutiveAttacks == 7 || consecutiveAttacks == 8 || consecutiveAttacks == 9) {
                        if (text == true) {
                            System.out.println("Super Poking Spree!\nYour opponent lost 2 HP!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveAttacks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 10 HP!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Legendary Poking Spree!\nYour opponent lost 3 HP!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompBlocks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompBlocks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Blocking Spree!\nYou lost 1 HP!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompBlocks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 5 HP!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompBlocks == 6 || consecutiveCompBlocks == 7 || consecutiveCompBlocks == 8 || consecutiveCompBlocks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Blocking Spree!\nYou lost 2 HP!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompBlocks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 10 HP!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompBlocks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Blocking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    }

                    if (compHP <= 0 && text == true) {
                        System.out.println("Your opponent fainted!");
                    } else if (compHP == 1 && text == true) {
                        System.out.println("Your opponent can only take 1 more hit!");
                    } else {
                        if (compHP <= 5 && text == true) {
                            System.out.println("Your opponent can only take " + compHP + " more hits!");
                        } else if (text == true && compHP > 5) {
                            System.out.println("Your opponent can take " + compHP + " more hits!");
                        }
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
                        }
                        compHP = compHP - 3;
                    } else if (consecutiveBlocks == 4) {
                        if (text == true) {
                            System.out.println("Blocking Spree!\nYour opponent lost 1 HP!");
                        }
                        compHP = compHP - 1;
                    } else if (consecutiveBlocks == 5) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 5 HP!");
                        }
                        compHP = compHP - 5;
                    } else if (consecutiveBlocks == 6 || consecutiveBlocks == 7 || consecutiveBlocks == 8 || consecutiveBlocks == 9) {
                        if (text == true) {
                            System.out.println("Super Blocking Spree!\nYour opponent lost 2 HP!");
                        }
                        compHP = compHP - 2;
                    } else if (consecutiveBlocks == 10) {
                        if (text == true) {
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 10 HP!");
                        }
                        compHP = compHP - 10;
                    } else if (consecutiveBlocks >= 11) {
                        {
                            System.out.println("Legendary Blocking Spree!\nYour opponent lost 3 HP!");
                        }
                        compHP = compHP - 3;
                    }

                    if (consecutiveCompAttacks == 3) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    } else if (consecutiveCompAttacks == 4) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Poking Spree!\nYou lost 1 HP!");
                        }
                        userHP = userHP - 1;
                    } else if (consecutiveCompAttacks == 5) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 5 HP!");
                        }
                        userHP = userHP - 5;
                    } else if (consecutiveCompAttacks == 6 || consecutiveCompAttacks == 7 || consecutiveCompAttacks == 8 || consecutiveCompAttacks == 9) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Super Poking Spree!\nYou lost 2 HP!");
                        }
                        userHP = userHP - 2;
                    } else if (consecutiveCompAttacks == 10) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 10 HP!");
                        }
                        userHP = userHP - 10;
                    } else if (consecutiveCompAttacks >= 11) {
                        if (text == true) {
                            System.out.println("Your opponent is on a Legendary Poking Spree!\nYou lost 3 HP!");
                        }
                        userHP = userHP - 3;
                    }
                    //tell user how many hp they have left
                    if (userHP <= 0 && text == true) {
                        System.out.println("You fainted!\nBetter luck next time!");
                    } else if (userHP == 1 && text == true) {
                        System.out.println("You can only take 1 more hit!");
                    } else {
                        if (userHP <= 5 && text == true) {
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

    int getcompHP() {
        if (rank.equals("Peasant")) {
            return 1;
        } else if (rank.equals("Ninja Trainee")) {
            return 2;
        } else if (rank.equals("Ninja Amateur")) {
            return 3;
        } else if (rank.equals("Ninja")) {
            return 4;
        } else if (rank.equals("Ninja Pro")) {
            return 5;
        } else if (rank.equals("Ninja Instructor")) {
            return 6;
        } else if (rank.equals("Samurai Trainee")) {
            return 7;
        } else if (rank.equals("Samurai Amateur")) {
            return 8;
        } else if (rank.equals("Samurai")) {
            return 9;
        } else if (rank.equals("Samurai Pro")) {
            return 10;
        } else if (rank.equals("Samurai Instructor")) {
            return 11;
        } else if (rank.equals("Assistant Sensei")) {
            return 12;
        } else if (rank.equals("Sensei")) {
            return 13;
        } else if (rank.equals("Dayimo")) {
            return 14;
        } else {
            return 15;
        }
    }

    String getRank() {
        return rank;
    }//end of rank getter

    int findCostPerClass() {
        if (rank.equals("Peasant")) {
            return 500;
        } else if (rank.equals("Ninja Trainee")) {
            return 1000;
        } else if (rank.equals("Ninja Amateur")) {
            return 2500;
        } else if (rank.equals("Ninja")) {
            return 5000;
        } else if (rank.equals("Ninja Pro")) {
            return 7500;
        } else if (rank.equals("Ninja Instructor")) {
            return 10000;
        } else if (rank.equals("Samurai Trainee")) {
            return 25000;
        } else if (rank.equals("Samurai Amateur")) {
            return 50000;
        } else if (rank.equals("Samurai")) {
            return 75000;
        } else if (rank.equals("Samurai Pro")) {
            return 100000;
        } else if (rank.equals("Samurai Instructor")) {
            return 250000;
        } else if (rank.equals("Assistant Sensei")) {
            return 500000;
        } else if (rank.equals("Sensei")) {
            return 750000;
        } else if (rank.equals("Dayimo")) {
            return 1000000;
        } else {
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
        if (rank.equals("Peasant")) {
            return "Ninja Trainee";
        } else if (rank.equals("Ninja Trainee")) {
            return "Ninja Amateur";
        } else if (rank.equals("Ninja Amateur")) {
            return "Ninja";
        } else if (rank.equals("Ninja")) {
            return "Ninja Pro";
        } else if (rank.equals("Ninja Pro")) {
            return "Ninja Instructor";
        } else if (rank.equals("Ninja Instructor")) {
            return "Samurai Trainee";
        } else if (rank.equals("Samurai Trainee")) {
            return "Samurai Amateur";
        } else if (rank.equals("Samurai Amateur")) {
            return "Samurai";
        } else if (rank.equals("Samurai")) {
            return "Samurai Pro";
        } else if (rank.equals("Samurai Pro")) {
            return "Samurai Instructor";
        } else if (rank.equals("Samurai Instructor")) {
            return "Assistant Sensei";
        } else if (rank.equals("Assistant Sensei")) {
            return "Sensei";
        } else if (rank.equals("Sensei")) {
            return "Dayimo";
        } else if (rank.equals("Dayimo")) {
            return "Emperor";
        }
        return "";
    }

    int findClassesNeeded() {
        if (rank.equals("Peasant")) {
            return 10;
        } else if (rank.equals("Ninja Trainee")) {
            return 25;
        } else if (rank.equals("Ninja Amateur")) {
            return 50;
        } else if (rank.equals("Ninja")) {
            return 75;
        } else if (rank.equals("Ninja Pro")) {
            return 100;
        } else if (rank.equals("Ninja Instructor")) {
            return 125;
        } else if (rank.equals("Samurai Trainee")) {
            return 150;
        } else if (rank.equals("Samurai Amateur")) {
            return 175;
        } else if (rank.equals("Samurai")) {
            return 200;
        } else if (rank.equals("Samurai Pro")) {
            return 225;
        } else if (rank.equals("Samurai Instructor")) {
            return 250;
        } else if (rank.equals("Assistant Sensei")) {
            return 275;
        } else if (rank.equals("Sensei")) {
            return 300;
        } else if (rank.equals("Dayimo")) {
            return 325;
        }//empty stuff
        return 0;
    }//end of findClassesNeeded method

    int getSpeed() {
        if (rank.equals("Peasant")) {
            return 75;
        } else if (rank.equals("Ninja Trainee")) {
            return 70;
        } else if (rank.equals("Ninja Amateur")) {
            return 65;
        } else if (rank.equals("Ninja")) {
            return 60;
        } else if (rank.equals("Ninja Pro")) {
            return 55;
        } else if (rank.equals("Ninja Instructor")) {
            return 50;
        } else if (rank.equals("Samurai Trainee")) {
            return 45;
        } else if (rank.equals("Samurai Amateur")) {
            return 40;
        } else if (rank.equals("Samurai")) {
            return 35;
        } else if (rank.equals("Samurai Pro")) {
            return 30;
        } else if (rank.equals("Samurai Instructor")) {
            return 25;
        } else if (rank.equals("Assistant Sensei")) {
            return 20;
        } else if (rank.equals("Sensei")) {
            return 15;
        } else if (rank.equals("Dayimo")) {
            return 10;
        } else if (rank.equals("Emperor")) {
            return 5;
        }
        return 0;
    }// end of main
}//end of class
