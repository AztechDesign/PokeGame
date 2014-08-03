package poke;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ShopClass {
	
	private boolean boughtSteve ;
	private boolean boughtBowie;
	private boolean boughtSanta;
	private boolean boughtZachary;
	private boolean boughtQuincy;
	private boolean boughtGeorgeWashington;
	private boolean boughtBatman;
	private boolean boughtElPresidente;
	private boolean boughtSMOO;
	private boolean boughtRishi;
	private boolean boughtSharpenedNails;
	private boolean boughtWolfPack;
	private boolean boughtChainsaw;
	private boolean boughtTicklingPoke;
	private boolean boughtPointDoubler;
	private boolean boughtPointTripler;
	private boolean boughtPointQuadrupler;
	private boolean boughtPointPentuplefier;
	private boolean boughtFlamingPoke; 
	private boolean boughtMetalFinger;
	private boolean boughtHairyFinger;
	private boolean boughtSnotCoatedFinger;
	private boolean boughtTitaniumFinger;
	private boolean friends;
	private boolean boughtBronzeMembership;
	private boolean boughtSilverMembership;
	private boolean boughtGoldMembership;
	private boolean boughtPlatinumMembership;
	private String pokestring;
	private String pokee;
	private String action;
	private String answer;
	private String converAnswer;
	private int charval;
	private int enchilada;
	private int difference;
	private int random;
	private int hotSauceCounter;
	private int numBottles;
	private double discount;
	
	ShopClass(){
		boughtSteve = false;
		friends = false;
		boughtBowie = false;
	    boughtSanta = false;
		boughtZachary = false;
		boughtQuincy = false;
		boughtGeorgeWashington = false;
		boughtBatman = false;
		boughtElPresidente = false;
		boughtSMOO = false;
		boughtRishi = false;
		boughtSharpenedNails = false;
		boughtWolfPack = false;
		boughtChainsaw = false;
		boughtTicklingPoke = false;
		boughtPointDoubler = false;
		boughtPointTripler = false;
		boughtPointQuadrupler = false;
		boughtPointPentuplefier = false;
		boughtFlamingPoke = false;
	    boughtMetalFinger = false;
		boughtHairyFinger = false;
		boughtTitaniumFinger = false;
		boughtSnotCoatedFinger = false;
		boughtBronzeMembership = false;
		boughtSilverMembership = false;
		boughtGoldMembership = false;
		boughtPlatinumMembership = false;
		pokestring = "poke";
		pokee = "Marty";
		charval = 1;
	}// end constructor
	
	int Enter(int pokelets,Scanner input){
	    Random generator = new Random();
	    random = generator.nextInt(100) + 1;
	    if(random >= 1 && random <= 10 && friends == false){
	        questionAsk(input);
	    }else{
	    	System.out.println("Welcome to Gotta' Buy It ALL!\nType the appropriate command to buy upgrades\nType leave to leave");
	    }
	    findDiscount();
	    sharpenedNailsMessage();
	    flamingPokeMessage();
	    pointMultiplierMessage();
	    hotSauceMessage();
	    hairyMessage();
	    metallicMessage();
	    characterMessage();
	    membershipMessage();
	    System.out.println("*********************");
	    System.out.println("You have " + pokelets + " pokelets");
	    action = input.nextLine();
	    action = action.toLowerCase();
	    enchilada = buyItem(action, pokelets, input);
	    return enchilada;
	}//end of enter
	
	void findDiscount(){
	    discount = 1;
	    if(friends == true){
	        discount = discount - 0.02;
	    }
	    if(boughtBronzeMembership == true && boughtSilverMembership == false){
	        discount = discount - 0.01;
	    }
	    if(boughtSilverMembership == true && boughtGoldMembership == false){
	        discount = discount - 0.02;
	    }
	    if(boughtGoldMembership == true && boughtPlatinumMembership == false){
	        discount = discount - 0.03;
	    }
	    if(boughtPlatinumMembership == true){
	        discount = discount - 0.05;
	    }
	}
	
	void questionAsk(Scanner input){
	    System.out.println("Hello!\nI am the shopkeeper!\nPlease tell me, who is your favorite pokémon?");
	    answer = input.nextLine();
	    converAnswer = answer.toLowerCase();
	    if(converAnswer.equals("snorlax")){
	        System.out.println("SNORLAX IS MY FAVORITE TOO!\nWe should be friends! I'll give you 2% off of all your purchases in the shop!\nNow what did you want to buy?");
	        friends = true;
	    }else{
	        System.out.println("Oh");
	        try{
	        	Thread.sleep(2000);
	        }catch(Excpetionn e){
	        	//DO NOTHING!
	        }
	    }
	}
	
	int buyItem(String purchase, int pokelets, Scanner input){
	    if(purchase.equals("buysharpenednails")){
	        if(boughtSharpenedNails == false){
	            if(pokelets >= (int)(1000*discount)){
	                System.out.println("You have bought Sharpened Nails for " + (int)(1000*discount) + " pokelets");
	                boughtSharpenedNails = true;
	                return (int)(1000*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Sharpened Nails");
	                difference = (int)(1000*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");
	            }
	        }else{
	            System.out.println("You already own the Sharpened Nails...\nWhy would you try to buy it again?!?!");
	        }
	    }else if(purchase.equals("buywolfpack")){
	        if(boughtSharpenedNails == true){
	            if(boughtWolfPack == false){
	                if(pokelets >= (int)(100000*discount)){
	                    System.out.println("You have bought the Wolverine Package for " + (int)(10000*discount) + " pokelets");
	                    boughtWolfPack = true;
	                    return (int)(100000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy the Wolverine Package");
	                    difference = (int)(100000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own the Wolverine Package...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("The Wolverine Package is locked\nUnlock it by buying Sharpened Nails");
	        }
	    }else if(purchase.equals("buychainsaw")){
	        if(boughtWolfPack == true){
	            if(boughtChainsaw == false){
	                if(pokelets >= (int)(1000000*discount)){
	                    System.out.println("You have bought the Chainsaw for " + (int)(100000*discount) + " pokelets");
	                    boughtChainsaw = true;
	                    return (int)(1000000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy the Chainsaw");
	                    difference = (int)(1000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own the Chainsaw...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("The Chainsaw is locked\nUnlock it by buying the Wolverine Package");
	        }
	    }else if(purchase.equals("buyticklingpoke")){
	        if(boughtChainsaw == true){
	            if(boughtTicklingPoke == false){
	                if(pokelets >= (int)(5000000*discount)){
	                    System.out.println("You have bought Tickling Poke for " + (int)(5000000*discount) + " pokelets");
	                    boughtTicklingPoke = true;
	                    return (int)(5000000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Tickling Poke");
	                    difference = (int)(5000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");	                    
	                }
	            }else{
	                System.out.println("You already own Tickling Poke...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("Tickling Poke is locked\nUnlock it by buying the Chainsaw");
	        }
	    }else if(purchase.equals("buyflamingpoke")){
	        if(boughtFlamingPoke == false){
	            if(pokelets >= (int)(2500*discount)){
	                System.out.println("You have bought Flaming Poke for " + (int)(2500*discount) + " pokelets");
	                boughtFlamingPoke = true;
	                return (int)(2500*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Flaming Poke");
	                difference = (int)(2500*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");	 	                
	            }
	        }else{
	            System.out.println("You already own Flaming Poke...\nWhy would you try to buy it again?!?!");
	        }
	    }else if(purchase.equals("buypointdoubler")){
	        if(boughtPointDoubler == false){
	            if(pokelets >= (int)(10000*discount)){
                    System.out.println("You have bought Point Doubler for " + (int)(10000*discount) + " pokelets");
	                boughtPointDoubler = true;
	                return (int)(10000*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Point Doubler");
	                difference = (int)(10000*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");		                
	            }
	        }else{
	            System.out.println("You already own Point Doubler...\nWhy would you try to buy it again?!?!");
	        }
	    }else if(purchase.equals("buypointtripler")){
	        if(boughtPointDoubler == true){
	            if(boughtPointTripler == false){
	                if(pokelets >= (int)(100000*discount)){
	                    System.out.println("You have bought Point Tripler for " + (int)(100000*discount) + " pokelets");
	                    boughtPointTripler = true;
	                    return (int)(100000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Point Tripler");
	                    difference = (int)(100000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Point Tripler...\nWhy would you try to buy it again?!?!");    
	            }
	        }else{
	            System.out.println("Point Tripler is locked\nUnlock it by buying Point Doubler");
	        }
	    }else if(purchase.equals("buypointquadrupler")){
	        if(boughtPointTripler == true){
	            if(boughtPointQuadrupler == false){
	                if(pokelets >= (int)(1000000*discount)){
	                    System.out.println("You have bought Point Quadrupler for " + (int)(1000000*discount) + " pokelets");
	                    boughtPointQuadrupler = true;
	                    return (int)(1000000*discount);	                    
	                }else{
                        System.out.println("You do not have enough pokelets to buy Point Quadrupler");
	                    difference = (int)(1000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");	                    
	                }
	            }else{
	                System.out.println("You already own Point Quadrupler...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("Point Quadrupler is locked\nUnlock it by buying Point Tripler");
	        }
	    }else if(purchase.equals("buypointpentuplefier")){
	        if(boughtPointQuadrupler == true){
	            if(boughtPointPentuplefier == false){
	                if(pokelets >= (int)(10000000*discount)){
	                    System.out.println("You have bought Point Pentuplefier for " + (int)(10000000*discount) + " pokelets");
	                    boughtPointPentuplefier = true;
	                    return (int)(10000000*discount);	 
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Point Pentuplefier");
	                    difference = (int)(10000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Point Pentuplefier...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("Point Pentuplefier is locked\nUnlock it by buying Point Quadrupler");
	        }
	    }else if(purchase.equals("buyhairyfinger")){
	        if(boughtHairyFinger == false){
	            if(pokelets >= (int)(5000*discount)){
	                System.out.println("You have bought Hairy Finger for " + (int)(5000*discount) + " pokelets");
	                boughtHairyFinger = true;
	                return (int)(5000*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Hairy Finger");
	                difference = (int)(5000*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");
	            }
	        }else{
	            System.out.println("You already own Hairy Finger...\nWhy would you try to buy it again?!?!");
	        }
	    }else if(purchase.equals("buysnotcoatedfinger")){
	        if(boughtHairyFinger == true){
	            if(boughtSnotCoatedFinger == false){
	                if(pokelets >= (int)(1500000*discount)){
	                    System.out.println("You have bought Snot Coated Finger for " + (int)(1500000*discount) + " pokelets");
	                    boughtSnotCoatedFinger = true;
	                    return (int)(1500000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Snot Coated Finger");
	                    difference = (int)(1500000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Snot Coated Finger...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("Snot Coated Finger is locked\nUnlock it by buying Hairy Finger");
	        }
	    }else if(purchase.equals("buyhotsauce")){
	        System.out.println("How many bottles would you like to buy?");
	        try{
	            numBottles = input.nextInt();   
	        }
	        catch(InputMismatchException e){
	            numBottles = 0;
	            JOptionPane.showMessageDialog(null, "Invalid Number", "ERROR", JOptionPane.ERROR_MESSAGE);
	        }
	        if(pokelets >= (int)(100000*discount)*numBottles){
	            if(numBottles > 0){
	            	if(numBottles == 1){
	            		System.out.println("Thank you for your purchase of 1 bottle of hot sauce");
	            	}else{
	            		System.out.println("Thank you for your purchase of " + numBottles + " bottles of hot sauce");
	            	}
	                hotSauceCounter += numBottles*10;
	                System.out.println("You now have " + hotSauceCounter + " turns of bite-free poking");
	                return (int)(100000*discount)*numBottles;
	            }else{
	                if(numBottles <= 0){
	                	
	                }
	            }
	        }else{
	            System.out.println("You do not have enough pokelets to buy " + numBottles + " bottles of hot sauce");
	            difference = (int)(100000*discount)*numBottles - pokelets;
	            System.out.println("You need " + difference + " more pokelets");
	        }
	    }else if(purchase.equals("buymetalfinger")){
	        if(boughtMetalFinger == false){
	            if(pokelets >= (int)(7500*discount)){
	                System.out.println("You have bought Metal Finger for " + (int)(7500*discount) + " pokelets");
	                boughtMetalFinger = true;
	                return (int)(7500*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Metal Finger");
	                difference = (int)(7500*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");
	            }
	        }else{
	            System.out.println("You already own Metal Finger...\nWhy would you try to buy it again?!?!");
	        }
	    }else if(purchase.equals("buytitaniumfinger")){
	        if(boughtMetalFinger == true){
	            if(boughtTitaniumFinger == false){
	                if(pokelets >= (int)(2000000*discount)){
	                    System.out.println("You have bought Titanium Finger for " + (int)(2000000*discount) + " pokelets");
	                    boughtTitaniumFinger = true;
	                    return (int)(2000000*discount);   
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Titanium finger");
	                    difference = (int)(2000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Titanium Finger...\nWhy would you try to buy it again?!?!");
	            }
	        }else{
	            System.out.println("Titanium Finger is locked\nUnlock it by buying Metal Finger");
	        }
	    }else if(purchase.equals("buysteve")){
	        if(boughtSteve == false){
	            if(pokelets >= (int)(1000*discount)){
	                System.out.println("Say goodbye to Marty because you just unlocked Steve!");
	                boughtSteve = true;
	                pokee = "Steve";
	                charval = 2;
	                return (int)(1000*discount);
	            }else{
	                System.out.println("You do not have enough pokelets to buy Steve");
	                difference = (int)(1000*discount) - pokelets; 
	                System.out.println("You need " + difference + " more pokelets");
	            }
	        }else{
	            System.out.println("You already own Steve... \nWhy would you try to buy him again?!?!");
	        }
	    }else if(purchase.equals("buybowie")){
	        if(boughtSteve == true){
	            if(boughtBowie == false){
	                if(pokelets >= (int)(5000*discount)){
	                    System.out.println("Say goodbye to Steve because you just unlocked Bowie!");
	                    boughtBowie = true;
	                    pokee = "Bowie";
	                    charval = 3;
	                    return (int)(5000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Steve");
	                    difference = (int)(5000*discount) - pokelets; 
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Bowie \nWhy would you try to buy him again?!?!");
	            }
	        }else{
	            System.out.println("Bowie is locked\nUnlock him by buying Steve");
	        }
	    }else if(purchase.equals("buysanta")){
	        if(boughtBowie == true){
	            if(boughtSanta == false){
	                if(pokelets >= (int)(10000*discount)){
	                    System.out.println("Say goodbye to Bowie because you just unlocked Santa!");
	                    boughtSanta = true;
	                    pokee = "Santa";
	                    charval = 4;
	                    return (int)(10000*discount);	                    
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Santa");
	                    difference = (int)(10000*discount) - pokelets; 
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println(" You already own Santa\nWhy would you try to buy him again?!?!");
	            }
            }else{
	            System.out.println("Santa is locked\nUnlock him by buying Bowie");
	        }
	    }else if(purchase.equals("buyquincy")){
	        if(boughtSanta == true){
	            if(boughtQuincy == false){
	                if(pokelets >= (int)(25000*discount)){
	                    System.out.println("Say goodbye to Santa because you just unlock Quincy!");
	                    boughtQuincy = true;
	                    pokee = "Quincy";
	                    charval = 5;
	                    return (int)(25000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Quincy");
	                    difference = (int)(25000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Quincy\nWhy would you try to buy him again?!?!");
	            }
	        }else{
	            System.out.println("Quincy is locked\nUnlock him by buying Santa");
	        }
	    }else if(purchase.equals("buyzachary")){
	        if(boughtQuincy == true){
	            if(boughtZachary == false){
	                if(pokelets >= (int)(50000*discount)){
	                    System.out.println("Say goodbye to Quincy because you just unlock Zachary!");
	                    boughtZachary = true;
	                    pokee = "Zachary";
	                    charval = 6;
	                    return (int)(50000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Zachary");
	                    difference = (int)(50000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
                }else{
	                System.out.println("You already own Zachary\nWhy would you try to buy him again?!?!");
	            }
	        }else{
	              System.out.println("Zachary is locked\nUnlock him by buying Quincy");
	        }
	    }else if(purchase.equals("buygeorgewashington")){
	        if(boughtZachary == true){
	            if(boughtGeorgeWashington == false){
	                if(pokelets >= (int)(100000*discount)){
	                    System.out.println("Say goodbye to Zachary because you just unlocked George Washington!");
	                    boughtGeorgeWashington = true;
	                    pokee = "George Washington";
	                    charval = 7;
	                    return (int)(100000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy George Washington");
	                    difference = (int)(100000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own George Washington\nWhy would you try to buy him again?!?!");
	            }
	        }else{
	            System.out.println("George Washington is locked\nUnlock him by buying Zachary");
	        }
	    }else if(purchase.equals("buybatman")){
	        if(boughtGeorgeWashington == true){
	            if(boughtBatman == false){
	                if(pokelets >= (int)(250000*discount)){
	                    System.out.println("Say goodbye to George Washington because you just unlocked Batman!");
	                    boughtBatman = true;
	                    pokee = "Batman";
	                    charval = 8;
	                    return (int)(250000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Batman");
	                    difference = (int)(250000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own Batman\nWhy would you try to buy him again?!?!");
	            }
	        }else{
	            System.out.println("Batman is locked\nUnlock him by buying George Washington");
	        }
	    }else if(purchase.equals("buyelpresidente")){
	        if(boughtBatman == true){
	            if(boughtElPresidente == false){
	                if(pokelets >= (int)(500000*discount)){
	                     System.out.println("Say goodbye to Batman because you just unlocked El Presidente!");
	                    boughtElPresidente = true;
	                    pokee = "El Presidente";
	                    charval = 9;
	                    return (int)(500000*discount);
	                }else{
	                    System.out.println("You do not have enough pokelets to buy El Presidente");
	                    difference = (int)(500000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                System.out.println("You already own El Presidente\nWhy would you try to buy him again?!?!");
	            }
	        }else{
	            System.out.println("El Presidente is locked\nUnlock him by buying Batman");
	        }
	    }else if(purchase.equals("buysmoo")){
	        if(boughtElPresidente == true){
	            if(boughtSMOO == false){
	                if(pokelets >= (int)(1000000*discount)){
	                    System.out.println("Say goodbye to El Presidente because you just unlocked Smoo!");
	                    boughtSMOO = true; 
	                    charval = 10;
	                    pokee = "Smoo";
	                    return (int)(1000000*discount);   
	                }else{
	                    System.out.println("You do not have enough pokelets to buy Smoo");
	                    difference = (int)(1000000*discount) - pokelets;
	                    System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	                  System.out.println("You already own Smoo\nWhy would you try to buy her again?!?!");
	            }
	        }else{
	              System.out.println("Smoo is locked\nUnlock her by buying El Presidente");
	        }
	    }else if(purchase.equals("buyrishi")){
	        if(boughtSMOO == true){
	            if(boughtRishi == false){
	                if(pokelets >= (int)(2500000*discount)){
	                    System.out.println("Congratz! You have completed the first set of characters by unlocking Rishi!");
	                    boughtRishi = true;
	                    charval = 11;
	                    pokee = "Rishi";
	                    return (int)(2500000*discount);
	                }else{
	                System.out.println("You do not have enought pokelets to unlock Rishi");
	                difference = (int)(2500000*discount) - pokelets;
	                System.out.println("You need " + difference + " more pokelets");
	                }
	            }else{
	            System.out.println("You already unlocked Rishi! \nWhy would you want to buy him again?");
	            }
	        }else{
	            System.out.println("Rishi is locked \nPurchase Smoo to unlock");
	            return 0;
	        }
	    }else if(purchase.equals("buybronzemembership")){
	    	if(boughtBronzeMembership == false){
	    		if(pokelets >= 1000000){
	    			System.out.println("You have bought a Bronze Membership for 1000000 pokelets");
	    			boughtBronzeMembership = true;
	    			return 1000000;
	    		}else{
	    			System.out.println("You do not have enough pokelets for a Bronze Membership");
	    			difference = 1000000 - pokelets;
	                System.out.println("You need " + difference + " more pokelets");
	    		}
	    	}else{
	    		System.out.println("You already have a Bronze Membership...\nWhy would you want to buy another one?!?!");
	    	}
	    }else if(purchase.equals("buysilvermembership")){
	    	if(boughtBronzeMembership == true){
	    		if(boughtSilverMembership == false){
	    			if(pokelets >= 10000000){
	    				System.out.println("You have bought a Silver Membership for 10000000 pokelets");
		    			boughtSilverMembership = true;
		    			return 10000000;
	    			}else{
	    				System.out.println("You do not have enough pokelets for a Silver Membership");
		    			difference = 10000000 - pokelets;
		                System.out.println("You need " + difference + " more pokelets");
	    			}
	    		}else{
	    			System.out.println("You already have a Silver Membership...\nWhy would you want to buy another one?!?!");
	    		}
	    	}else{
	    		System.out.println("Silver Membership is locked\nUnlock it by buying Bronze Membership");
	    	}
	    }else if(purchase.equals("buygoldmembership")){
	    	if(boughtSilverMembership == true){
	    		if(boughtGoldMembership == false){
	    			if(pokelets >= 100000000){
	    				System.out.println("You have bought a Gold Membership for 100000000 pokelets");
		    			boughtGoldMembership = true;
		    			return 100000000;
	    			}else{
	    				System.out.println("You do not have enough pokelets for a Gold Membership");
		    			difference = 100000000 - pokelets;
		                System.out.println("You need " + difference + " more pokelets");
	    			}
	    		}else{
	    			System.out.println("You already have a Gold Membership...\nWhy would you want to buy another one?!?!");
	    		}
	    	}else{
	    		System.out.println("Gold Membership is locked\nUnlock it by buying Silver Membership");
	    	}
	    }else if(purchase.equals("buyplatinummembership")){
	    	if(boughtGoldMembership == true){
	    		if(boughtPlatinumMembership == false){
	    			if(pokelets >= 1000000000){
	    				System.out.println("You have bought a Platinum Membership for 1000000000 pokelets");
		    			boughtPlatinumMembership = true;
		    			return 1000000000;
	    			}else{
	    				System.out.println("You do not have enough pokelets for a Platinum Membership");
		    			difference = 1000000000 - pokelets;
		                System.out.println("You need " + difference + " more pokelets");
	    			}
	    		}else{
	    			System.out.println("You already have a Platinum Membership...\nWhy would you want to buy another one?!?!");
	    		}
	    	}else{
	    		System.out.println("Platinum Membership is locked\nUnlock it by buying Gold Membership");
	    	}
	    }else if(purchase.equals("leave")){
	    	return 0;
	    }else{
	        //if purchase is invalid      
	        JOptionPane.showMessageDialog(null, "Invalid Purchase", "ERROR", JOptionPane.ERROR_MESSAGE); 
	        return 0;
	    }
	    return 0;
	}//end buyItem
	
	void sharpenedNailsMessage(){
	    if(boughtSharpenedNails == false){
	        System.out.println("*********************");
	        System.out.println("Sharpened Nails");
	        System.out.println("Buy for " + (int)(1000*discount) + " pokelets");
	        System.out.println("Increases chance of poking");
	        System.out.println("a better place");
	        System.out.println("command to buy:");
	        System.out.println("buysharpenednails");
	    }else if(boughtSharpenedNails == true && boughtWolfPack == false){
	        System.out.println("*********************");
	        System.out.println("Sharpened Nails");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Wolverine Package");
	        System.out.println("Buy for " + (int)(100000*discount) + " pokelets");
	        System.out.println("Increases chance of poking");
	        System.out.println("a better place even more");
	        System.out.println("Buy this and you will scratch");
	        System.out.println("instead of poke!");
	        System.out.println("command to buy:");
	        System.out.println("buywolfpack");
	    }else if(boughtWolfPack == true && boughtChainsaw == false){
	        System.out.println("*********************");
	        System.out.println("Sharpened Nails");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Wolverine Package");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Finger Chainsaw");
	        System.out.println("Buy for " + (int)(1000000*discount) + " pokelets");
	        System.out.println("Increases chance of poking");
	        System.out.println("a better place even more");
	        System.out.println("Buy this and you will slice");
	        System.out.println("instead of scratch!");
	        System.out.println("command to buy:");
	        System.out.println("buychainsaw");
	    }else if(boughtChainsaw == true && boughtTicklingPoke == false){
	        System.out.println("*********************");
	        System.out.println("Sharpened Nails");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Wolverine Package");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Finger Chainsaw");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Tickling Poke");
	        System.out.println("Buy for " + (int)(5000000*discount) + " pokelets");
	        System.out.println("Increases chance of poking");
	        System.out.println("a better place even more");
	        System.out.println("Everyone is ticklish,");
	        System.out.println("why not take advantage of that!");
	        System.out.println("Buy the Tickling Poke and tickle");
	        System.out.println("instead of slice!");
	        System.out.println("command to buy:");
	        System.out.println("buyticklingpoke");
	    }else if(boughtTicklingPoke == true){
	        System.out.println("*********************");
	        System.out.println("Sharpened Nails");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Wolverine Package");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Finger Chainsaw");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("TicklingPoke");
	        System.out.println("Already Bought");
	    }
	}//end nails
	
	void flamingPokeMessage(){
	    if(boughtFlamingPoke == false){
	        System.out.println("*********************");
		    System.out.println("Flaming Poke");
		    System.out.println("Buy for " + (int)(2500*discount) + " pokelets");
			System.out.println("Wanna set someone's hair");
			System.out.println("on fire? If so, then flaming");
			System.out.println("poke is perfect for you!");
			System.out.println("Just poke their head and");
			System.out.println("watch the pokelets roll in!");
			System.out.println("command to buy:");
			System.out.println("buyflamingpoke");
	    }else if(boughtFlamingPoke == true){
	        System.out.println("*********************");
	        System.out.println("Flaming Poke");
	        System.out.println("Already Bought");
	    }   
	}//end flames
	
	void pointMultiplierMessage(){
	    if(boughtPointDoubler == false){
	        System.out.println("*********************");
			System.out.println("Point Doubler");
			System.out.println("Buy for " + (int)(10000*discount) + " pokelets");
			System.out.println("Doubles your pokelets");
			System.out.println("Once bought, allows");
			System.out.println("you to buy Point");
			System.out.println("Tripler");
			System.out.println("command to buy:");
			System.out.println("buypointdoubler");
	    }else if(boughtPointDoubler == true && boughtPointTripler == false){
	        System.out.println("*********************");
			System.out.println("Point Doubler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Tripler");
			System.out.println("Buy for " + (int)(100000*discount) + " pokelets");
			System.out.println("Triples your pokelets");
			System.out.println("Once bought, allows");
			System.out.println("you to buy Point");
			System.out.println("Quadrupler");
			System.out.println("command to buy:");
			System.out.println("buypointtripler");
	    }else if(boughtPointTripler == true && boughtPointQuadrupler == false){
	        System.out.println("*********************");
			System.out.println("Point Doubler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Tripler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Quadrupler");
			System.out.println("Buy for " + (int)(1000000*discount) + " pokelets");
			System.out.println("Quadruples your pokelets");
			System.out.println("Once bought, allows");
			System.out.println("you to buy the Point");
			System.out.println("Pentuplefier");
			System.out.println("command to buy: ");
			System.out.println("buypointquadrupler");
	    }else if(boughtPointQuadrupler == true && boughtPointPentuplefier == false){
	        System.out.println("*********************");
			System.out.println("Point Doubler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Tripler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Quadrupler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Pentuplerfier ");
			System.out.println("Buy for " + (int)(10000000*discount) + " pokelets");
			System.out.println("Pentuples your pokelets");
			System.out.println("command to buy: ");
			System.out.println("buypointpentuplefier");
	    }else if(boughtPointPentuplefier == true){
	        System.out.println("*********************");
			System.out.println("Point Doubler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Tripler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Quadrupler");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Point Pentuplerfier ");
			System.out.println("Already Bought");
	    }
	}//end pointmult
	
	void hotSauceMessage(){
	    System.out.println("*********************");
		System.out.println("Hot Sauce");
		System.out.println("One bottle for " + (int)(100000*discount) + " pokelets");
		System.out.println("Pour hot sauce on your");
		System.out.println("finger to prevent being");
		System.out.println("bitten. Wears out after");
		System.out.println("10 pokes");
		System.out.println("command to buy:");
		System.out.println("buyhotsauce");
	}//end hotsauce
	
	void hairyMessage(){
	    if(boughtHairyFinger == false){
	        System.out.println("*********************");
		    System.out.println("Hairy Finger");
		    System.out.println("Buy for " + (int)(5000*discount) + " pokelets");
		    System.out.println("When you poke the ");
		    System.out.println("mouth a hairy finger");
		    System.out.println("will decrease your ");
		    System.out.println("chance that you will ");
		    System.out.println("be bitten");
		    System.out.println("command to buy:");
		    System.out.println("buyhairyfinger");
	    }else if(boughtHairyFinger == true && boughtSnotCoatedFinger == false){
    		System.out.println("*********************");
			System.out.println("Hairy Finger");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Snot Coated Finger");
			System.out.println("Buy for " + (int)(1500000*discount) + " pokelets");
			System.out.println("Decreases chance of ");
			System.out.println("being bitten even more");
			System.out.println("command to buy:");
			System.out.println("buysnotcoatedfinger");
	    }else if(boughtSnotCoatedFinger == true){
            System.out.println("*********************");
			System.out.println("Hairy Finger");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Snot Coated Finger");
        	System.out.println("Already Bought");
	    }
	}//end of hairy message
	
	void metallicMessage(){
	    if(boughtMetalFinger == false){
            System.out.println("*********************");
			System.out.println("Metal Finger");
			System.out.println("Buy for " + (int)(7500*discount) + " pints");
			System.out.println("When your finger is");
			System.out.println("bitten you lose less");
			System.out.println("pokelets");
			System.out.println("command to buy:");
			System.out.println("buymetalfinger");
	    }else if(boughtMetalFinger == true && boughtTitaniumFinger == false){
	        System.out.println("*********************");
			System.out.println("Metal Finger");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Titanium Finger");
			System.out.println("Buy for " + (int)(2000000*discount) + " pokelets");
			System.out.println("When your finger is");
			System.out.println("bitten you lose even");
			System.out.println("less pokelets");
			System.out.println("command to buy:");
			System.out.println("buytitaniumfinger");
	    }else if(boughtTitaniumFinger == true){
	        System.out.println("*********************");
			System.out.println("Metal Finger");
			System.out.println("Already Bought");
			System.out.println("*********************");
			System.out.println("Titanium Finger");
			System.out.println("Already Bought");
	    }
	}//end metal
	
	void characterMessage(){
	    if(boughtSteve == false){
		    System.out.println("*********************");
			System.out.println("Steve");
			System.out.println("Buy for " + (int)(1000*discount) + " pokelets");
			System.out.println("Tired of poking Marty?");
			System.out.println("Poke Steve AND get ");
			System.out.println("more pokelets AND ");
			System.out.println("unlock Bowie!");
			System.out.println("command to buy: ");
			System.out.println("buysteve");
		}else{
			System.out.println("*********************");
			System.out.println("Steve");
			System.out.println("Already Bought");
		        if(boughtBowie == false){
					System.out.println("*********************");
					System.out.println("Bowie");
					System.out.println("Buy for " + (int)(5000*discount) + " pokelets");
					System.out.println("Tired of poking Steve?");
					System.out.println("Poke Bowie And get");
					System.out.println("more pokelets AND");
					System.out.println("unlock Santa!");
					System.out.println("command to buy: ");
				    System.out.println("buybowie");
				}else{
					System.out.println("*********************");
					System.out.println("Bowie");
					System.out.println("Already Bought");
				    	if(boughtSanta == false){
						    System.out.println("*********************");
						    System.out.println("Santa");
						    System.out.println("Buy for " + (int)(10000*discount) + " pokelets");
							System.out.println("Tired of poking Bowie?");
							System.out.println("Poke Santa AND get");
							System.out.println("more pokelets AND");
							System.out.println("unlock Quincy!");
							System.out.println("command to buy: ");
							System.out.println("buysanta");
						}else{
							System.out.println("*********************");
							System.out.println("Santa");
							System.out.println("Already Bought");
						    	if(boughtQuincy == false){
									System.out.println("*********************");
									System.out.println("Quincy");
									System.out.println("Buy for " + (int)(25000*discount) + " pokelets");
									System.out.println("Tired of pok/ng Santa?");
									System.out.println("Poke Quincy AND get");
									System.out.println("more pokelets AND");
									System.out.println("unlock Zachary!");
									System.out.println("command to buy: ");
									System.out.println("buyquincy");
								}else{
									System.out.println("*********************");
									System.out.println("Quincy");
									System.out.println("Already Bought");
									    if(boughtZachary == false){
									    	System.out.println("*********************");
    										System.out.println("Zachary");
										    System.out.println("Buy for " + (int)(50000*discount) + " pokelets");
										    System.out.println("Tired of poking Quincy?");
										    System.out.println("Poke Zachary AND get");
										    System.out.println("more pokelets AND");
										    System.out.println("unlock George Washington!");
										    System.out.println("command to buy: ");
										    System.out.println("buyzachary");
									    }else{
    										System.out.println("*********************");
										    System.out.println("Zachary");
										    System.out.println("Already Bought");
										        if(boughtGeorgeWashington == false){
											        System.out.println("*********************");
											        System.out.println("George Washington");
											        System.out.println("Buy for " + (int)(100000*discount) + " pokelets");
											        System.out.println("Tired of poking Zachary?");
											        System.out.println("Poke George Washington AND get");
											        System.out.println("more pokelets AND");
											        System.out.println("unlock Batman!");
											        System.out.println("command to buy: ");
											        System.out.println("buygeorgewashington");
										        }else{
											        System.out.println("*********************");
											        System.out.println("George Washington");
											        System.out.println("Already Bought");
											            if(boughtBatman == false){
												            System.out.println("*********************");
												            System.out.println("Batman");
												            System.out.println("Buy for " + (int)(250000*discount) + " pokelets");
												            System.out.println("Tired of poking George Washington?");
												            System.out.println("Poke Batman AND get");
												            System.out.println("more pokelets AND");
												            System.out.println("unlock El Presidente!");
												            System.out.println("command to buy: ");
											        	    System.out.println("buybatman");
											            }else{
												            System.out.println("*********************");
												            System.out.println("Batman");
												            System.out.println("Already Bought");
												                if(boughtElPresidente == false){
													                System.out.println("*********************");
													                System.out.println("El Presidente");
													                System.out.println("Buy for " + (int)(500000*discount) + " pokelets");
													                System.out.println("Tired of poking Batman?");
													                System.out.println("Poke El Presidente AND get");
													                System.out.println("more pokelets AND");
													                System.out.println("unlock SMOO!");
													                System.out.println("command to buy: ");
													                System.out.println("buyelpresidente");
												                }else{
													                System.out.println("*********************");
													                System.out.println("El Presidente");
													                System.out.println("Already Bought");
													                    if(boughtSMOO == false){
														                    System.out.println("*********************");
														                    System.out.println("SMOO");
														                    System.out.println("Buy for " + (int)(1000000*discount) + " pokelets");
														                    System.out.println("Tired of poking El Presidente?");
														                    System.out.println("Poke SMOO AND get");
														                    System.out.println("more pokelets AND");
														                    System.out.println("unlock Rishi!");
														                    System.out.println("command to buy: ");
														                    System.out.println("buysmoo");
													                    }else{
														                    System.out.println("*********************");
														                    System.out.println("SMOO");
														                    System.out.println("Already Bought");
														                        if(boughtRishi == false){
															                        System.out.println("*********************");
															                        System.out.println("Rishi");
															                        System.out.println("Buy for " + (int)(2500000*discount) + " pokelets");
															                        System.out.println("Tired of poking SMOO?");
															                        System.out.println("Poke Rishi AND get");
															                        System.out.println("more pokelets ");
															                        System.out.println("command to buy: ");
															                        System.out.println("buyrishi");
														                        }else{
															                        System.out.println("*********************");
															                        System.out.println("Rishi");
															                        System.out.println("Already Bought");
														                        }//Rishi else
													                   }//SMOO else
												                }//El Presidente else
											            }//Batman else
										        }//George Washington else
									    }//Zachary else
								}//Quincy else
						}//Santa else
				}//Bowie else
		}//Steve else
	}//end character
	
	void membershipMessage(){
	    if(boughtBronzeMembership == false){
	        System.out.println("*********************");
	        System.out.println("Bronze Membership");
	        System.out.println("Buy for 1000000 pokelets");
	        System.out.println("Get 1% off of all");
	        System.out.println("purchases excluding");
	        System.out.println("membership purchases");
	        System.out.println("command to buy: ");
	        System.out.println("buybronzemembership");
	    }else if(boughtBronzeMembership == true && boughtSilverMembership == false){
	    	System.out.println("*********************");
	        System.out.println("Bronze Membership");
	        System.out.println("Already Bought");
	    	System.out.println("*********************");
	        System.out.println("Silver Membership");
	        System.out.println("Buy for 10000000 pokelets");
	        System.out.println("Get 2% off of all");
	        System.out.println("purchases excluding");
	        System.out.println("membership purchases");
	        System.out.println("command to buy: ");
	        System.out.println("buysilvermembership");
	    }else if(boughtSilverMembership == true && boughtGoldMembership == false){
	    	System.out.println("*********************");
	        System.out.println("Bronze Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Silver Membership");
	        System.out.println("Already Bought");
	    	System.out.println("*********************");
	        System.out.println("Gold Membership");
	        System.out.println("Buy for 100000000 pokelets");
	        System.out.println("Get 3% off of all");
	        System.out.println("purchases excluding");
	        System.out.println("membership purchases");
	        System.out.println("command to buy: ");
	        System.out.println("buygoldmembership");
	    }else if(boughtGoldMembership == true && boughtPlatinumMembership == false){
	    	System.out.println("*********************");
	        System.out.println("Bronze Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Silver Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Gold Membership");
	        System.out.println("Already Bought");
	    	System.out.println("*********************");
	        System.out.println("Platinum Membership");
	        System.out.println("Buy for 1000000000 pokelets");
	        System.out.println("Get 5% off of all");
	        System.out.println("purchases");
	        System.out.println("command to buy: ");
	        System.out.println("buyplatinummembership");
	    }else if(boughtPlatinumMembership == true){
	    	System.out.println("*********************");
	        System.out.println("Bronze Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Silver Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Gold Membership");
	        System.out.println("Already Bought");
	        System.out.println("*********************");
	        System.out.println("Platinum Membership");
	        System.out.println("Already Bought");
	    }
	}
	
	int getHotSauceCounter(){
		return hotSauceCounter;
	}
	
	boolean getFlamingPoke(){
		if(boughtFlamingPoke == true){
			return true;
		}else{
			return false;
		}
	}
	
	int getMetalLevel(){
		if(boughtMetalFinger == false){
			return 0;
		}else if(boughtMetalFinger == true && boughtTitaniumFinger == false){
			return 1;
		}else if(boughtTitaniumFinger == true){
			return 2;
		}else{
			return 0;
		}
	}
	
	int getHairyLevel(){
		if(boughtHairyFinger == false){
			return 0;
		}else if(boughtHairyFinger == true && boughtSnotCoatedFinger == false){
			return 1;
		}else if(boughtSnotCoatedFinger == true){
			return 2;
		}else{
			return 0;
		}
	}
	
	int getNailLevel(){
		if(boughtSharpenedNails == false){
			return 0;
		}else if(boughtSharpenedNails == true && boughtWolfPack == false){
			return 1;
		}else if(boughtWolfPack == true && boughtChainsaw == false){
			return 2;
		}else if(boughtChainsaw == true && boughtTicklingPoke == false){
			return 3;
		}else if(boughtTicklingPoke == true){
		    return 4;
		}
		return 0;
	}// end getNailLevel
	
	String getPokeString(){
		return pokestring;
	}// end getPokeString
	
	int getCharval(){
		return charval;
	}// end getCharval
	
	int getPointMult(){
		if(boughtPointDoubler == false){
			return 5;
		}else if(boughtPointDoubler == true && boughtPointTripler == false){
			return 10;
		}else if(boughtPointTripler == true && boughtPointQuadrupler == false){
			return 15;
		}else if(boughtPointQuadrupler == true && boughtPointPentuplefier == false){
			return 20;
		}else if(boughtPointPentuplefier == true){
			return 25;
		}else{
			return 0; // never get here
		}
	}// end getPointMult
	
	String getPokee(){
	    return pokee;
	}
	
	void subtractHotSauce(){
		if(hotSauceCounter > 0){
			hotSauceCounter = hotSauceCounter - 1;
			System.out.println("Hot sauce will expire in " + hotSauceCounter + " pokes");
		}
	}
	
}// end class