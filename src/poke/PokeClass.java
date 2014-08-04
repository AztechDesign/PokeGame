package poke;

import javax.swing.JOptionPane;
import java.util.Random;
public class PokeClass {
	private boolean pokedStomach;
	private boolean pokedVitalBodyPart;
	private boolean pokedHead;
	private boolean pokedNeck;
	private boolean pokedMouth;
	private boolean pokedBellyButton;
	private boolean pokedEar;
	private boolean pokedEyeball;
	private boolean hairOnFire;
	private int hairFireNumber;
	private int tongueFireNumber;
	private boolean tongueOnFire;
	private int quitOption;
	private int quitOption2;
	private int quitOption3;
	private int bitePos;
	private int pancakes;
	private int papayas;
	private int waffles;
	/*
	 *	Methods help and start screen are the next two methods in this class
	 */
	void help(){
		JOptionPane.showMessageDialog(null, "Type poke to poke", "Help Page 1", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Type shop to go to the shop", "Help Page 2", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Type bank to go to the bank", "Help Page 3", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Type dojo to go to the dojo", "Help Page 4", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Type help for a list of commands", "Help Page 5", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Type quit to quit", "Help Page 6", JOptionPane.INFORMATION_MESSAGE);
	}
	void delay(int delayTime) throws InterruptedException{
		Thread.sleep(delayTime);
	}
	void startScreen(){
		System.out.println("Welcome to POKE!");
		System.out.println("Type poke to poke.");
		System.out.println("Type shop to go to the shop.");
		System.out.println("Type bank to go to the bank.");
		System.out.println("Type dojo to go to the dojo");
		System.out.println("Type help for a list of commands");
		System.out.println("Type quit to... you guessed it! Quit!");
		System.out.println("You must buy everything in the shop to win.");
	}
	int confirmQuit(){
		quitOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit? All progress will be lost", "Quit Confirmation", JOptionPane.YES_NO_OPTION);
		if(quitOption == 0){
			quitOption2 = JOptionPane.showConfirmDialog(null, "ALL PROGRESS WILL BE LOST! ARE YOU ABSOLUTELY SURE THAT YOU WANT TO QUIT?!", "Quit Confirmation", JOptionPane.YES_NO_OPTION);
				if(quitOption2 == 0){
					quitOption3 = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU'RE SURE? THIS IS THE LAST TIME THAT YOU CAN BACK OUT!", "Quit Confirmation", JOptionPane.YES_NO_OPTION);
					if(quitOption3 == 0){
						JOptionPane.showMessageDialog(null, "Goodbye. You have broken my heart.", "Farewell", JOptionPane.WARNING_MESSAGE);
						return 1;
					}
				}else{
					return 0;
				}
		}else{
			return 0;
		}
		return 0;
	}
	/*
	 *
	 * ACTUAL POKE CLASS STARTS HERE
	 *
	 */
	PokeClass(){
		pokedStomach = false;
		pokedVitalBodyPart = false;
		pokedHead = false;
		pokedNeck = false;
		pokedMouth = false;
		pokedBellyButton = false;
		pokedEar = false;
		pokedEyeball = false;
		hairOnFire = false;
		tongueOnFire = false;
	}// end of constructor
	int pokePerson(int charval, int pointmult, int a, int nailLevel, String pokee, int hotsauce, boolean boughtFlamingPoke, int hairyLevel, int metalLevel, int pokelets){
		calculatePercentageMethod(nailLevel, a);
		if(pokedStomach == true){
			System.out.println("You got " + (charval*pointmult*1) + " pokelets for poking " + pokee + "'s stomach");
			pokedStomach = false;
			return charval*pointmult*1;
		}else if(pokedVitalBodyPart == true){
			System.out.println("You got " + (charval*pointmult*3) + " pokelets for poking a vital body part of " + pokee);
			pokedVitalBodyPart = false;
			return charval*pointmult*3;
		}else if(pokedHead == true){
			System.out.println("You got " + (charval*pointmult*3) + " pokelets for poking " + pokee + "'s head");
			pancakes = charval*pointmult*3;
			pokedHead = false;
			if(boughtFlamingPoke == true){
				if(hairOnFire == false){
					Random generator = new Random();
					hairFireNumber = generator.nextInt(5) + 5;
					System.out.println("You set " + pokee + "'s hair on fire!");
					hairOnFire = true;
				}
			}
			pokedHead = false;
			return pancakes + papayas;
		}else if(pokedNeck == true){
			System.out.println("You got " + (charval*pointmult*4) + " pokelets for poking " + pokee + "'s neck");
			pokedNeck = false;
			return charval*pointmult*4;
		}else if(pokedMouth == true){
			pokedMouth = false;
			if(hotsauce == 0){
			Random generator = new Random();
			if(hairyLevel == 0){
				bitePos = generator.nextInt(2);
				if(bitePos == 1){
					if(metalLevel == 0){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 50% of your pokelets");
						pancakes = pokelets / 2;
						return pancakes * -1;
					}else if(metalLevel == 1){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 25% of your pokelets");
						pancakes = pokelets / 4;
						return pancakes * -1;
					}else if(metalLevel == 2){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 15% of your pokelets");
						pancakes = pokelets * 100;
						pancakes = pancakes / 85;
						return pancakes * -1;
					}
				}else{
					System.out.println("You got 314 pokelets for poking " + pokee + "'s Pie Hole! :)");
					return 314;
				}
			}else if(hairyLevel == 1){
				bitePos = generator.nextInt(4);
				if(bitePos == 1){
					if(metalLevel == 0){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 50% of your pokelets");
						pancakes = pokelets / 2;
						return pancakes * -1;
					}else if(metalLevel == 1){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 25% of your pokelets");
						pancakes = pokelets / 4;
						return pancakes * -1;
					}else if(metalLevel == 2){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 15% of your pokelets");
						pancakes = pokelets * 100;
						pancakes = pancakes / 85;
						return pancakes * -1;
					}
				}else{
					System.out.println("You got 314 pokelets for poking " + pokee + "'s Pie Hole! :)");
					return 314;
				}
			}else if(hairyLevel == 2){
				bitePos = generator.nextInt(8);
				if(bitePos == 1){
					if(metalLevel == 0){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 50% of your pokelets");
						pancakes = pokelets / 2;
						return pancakes * -1;					
					}else if(metalLevel == 1){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 25% of your pokelets");
						pancakes = pokelets / 4;
						return pancakes * -1;
					}else if(metalLevel == 2){
						System.out.println("You poked " + pokee + "'s mouth \nYou got bit and " + pokee + " took 15% of your pokelets");
						pancakes = pokelets * 100;
						pancakes = pancakes / 85;
						return pancakes * -1;
					}
				}else{
					System.out.println("You got 314 pokelets for poking " + pokee + "'s Pie Hole! :)");
					return 314;
				}
			}
			}else{
				if(tongueOnFire == false){
					Random generator = new Random();
					tongueFireNumber = generator.nextInt(5) + 5;
					System.out.println("You set " + pokee + "'s tongue on fire!");
					tongueOnFire = true;
				}
				System.out.println("You got 10000 points for poking " + pokee + "'s tongue!");
				return 10000;
			}
			return 0;
		}else if(pokedBellyButton == true){
			System.out.println("You got " + (charval*pointmult*7) + " pokelets for poking " + pokee + "'s belly button");
			pokedBellyButton = false;
			return charval*pointmult*7;
		}else if(pokedEar == true){
			System.out.println("You got " + (charval*pointmult*5) + " pokelets for poking " + pokee + "'s ear");
			pokedEar = false;
			return charval*pointmult*5;
		}else if(pokedEyeball == true){
			System.out.println("You got " + (charval*pointmult*10) + " pokelets for poking " + pokee + "'s eye");
			pokedEyeball = false;
			return charval*pointmult*10;
		}else{
			return 0;
		}
	}
	
	int tongueFire(String pokee, int charval, int pointmult){
		if(tongueOnFire == true){
			tongueFireNumber -= 1;
			if(tongueFireNumber == 0){
				Random generator = new Random();
				waffles = generator.nextInt(5) + 1;
					switch(waffles){
					case 1:
						System.out.println(pokee + " drank a gallon of milk");
						break;
					case 2:
						System.out.println(pokee + " called 911 to put out their tongue fire");
						break;
					case 3:
						System.out.println(pokee + " replaced their tongue");
						break;
					case 4:
						System.out.println(pokee + " ate some chocolate");
						break;
					case 5:
						System.out.println(pokee + " vomited");
					}
				tongueOnFire = false;
				return 0;
			}else{
				System.out.println(pokee + "'s mouth is on fire!");
				System.out.println("You got " + (charval * pointmult * 50) + " pokelets!");
				return (charval * pointmult * 50);
			}
		}
		return 0;
	}
	
	int hairyFire(String pokee, int charval, int pointmult){
		if(hairOnFire == true){
			hairFireNumber -= 1;
			if(hairFireNumber == 0){
				Random generator = new Random();
				waffles = generator.nextInt(5) + 1;
				switch(waffles){
					case 1:
						System.out.println(pokee + " dumped a bucket of freezing cold water on the fire");
						break;
					case 2:
						System.out.println(pokee + " found a fire extinguisher");
						break;
					case 3:
						System.out.println("The fire had nothing left to burn...");
						break;
					case 4:
						System.out.println(pokee + " jumped in a lake");
						break;
					case 5:
						System.out.println(pokee + " Stopped, dropped a beat and headspun");
						break;	
				}
				hairOnFire = false;
				return 0;
			}else{
				System.out.println(pokee + "'s hair is on fire!");
				System.out.println("You got " + (charval * pointmult * 20) + " pokelets!");
				return (charval * pointmult * 20);
			}
		}
		return 0;
	}
	void calculatePercentageMethod(int nailLevel, int a){
		if(nailLevel == 0){
			percentageMethod1(a);
		}else if(nailLevel == 1){
		    percentageMethod2(a);
		}else if(nailLevel == 2){
		    percentageMethod3(a);
		}else if(nailLevel == 3){
		    percentageMethod4(a);
		}else if(nailLevel == 4){
		    percentageMethod5(a);
		}
	}
	void percentageMethod1(int a){
		if(a >=1 && a <= 75){
			pokedStomach = true;
		}
		if(a >= 76 && a <= 81){
			pokedVitalBodyPart = true;
		}
		if(a >= 82 && a <= 86){
			pokedHead = true;
		}
		if(a >= 87 && a <= 91){
			pokedNeck = true;
		}
		if(a >= 92 && a <= 94){
			pokedBellyButton = true;
		}
		if(a >= 95 && a <= 97){
			pokedMouth = true;
		}
		if(a == 98 || a == 99){
			pokedEar = true;
		}
		if(a == 100){
			pokedEyeball = true;
		}
	}
	void percentageMethod2(int a){
		if(a >=1 && a <=10){
			pokedVitalBodyPart = true;
		}
		if(a >= 11 && a <= 60){
			pokedStomach = true;
		}
		if(a >= 61 && a <= 65){
			pokedEyeball = true;
		}
		if(a >= 66 && a <= 73){
			pokedBellyButton = true;
		}
		if(a >= 74 && a <= 83){
			pokedHead = true;
		}
		if(a >= 84 && a <= 90){
			pokedEar = true;
		}
		if(a >= 91 && a <= 95){
			pokedMouth = true;
		}
		if(a >= 96 && a <=100){
			pokedNeck = true;
		}		
	}
	void percentageMethod3(int a){
		//Wolf Pack
	}
	void percentageMethod4(int a){
		//chainsaw
	}
	void percentageMethod5(int a){
		//tickling poke
	}
	int findAnyAward(int pokes){
	    if(pokes == 1){
	    	System.out.println("**************************************");
	        System.out.println("You got 50 pokelets for your first poke!");
	        System.out.println("**************************************");
	        return 50;
	    }else if(pokes == 10){
	    	System.out.println("**************************************");
	        System.out.println("Woo hoo!\n10 pokes!\n100 pokelets for you!\nDON'T PRESS BACKSPACE!\nShe-Who-Must-Not-Be-Named HATES it when you press backspace after poking");
	        System.out.println("**************************************");
	        return 100;
	    }else if(pokes == 50){
	    	System.out.println("**************************************");
	        System.out.println("Nice!\n50 pokes!\nEnjoy these 500 pokelets!");
	        System.out.println("**************************************");
	        return 500;
	    }else if(pokes == 100){
	    	System.out.println("**************************************");
	        System.out.println("First 100 pokes!\nSpend these 750 pokelets on something useful!");
	        System.out.println("**************************************");
	        return 750;
	    }else if(pokes == 250){
	    	System.out.println("**************************************");
	        System.out.println("250 pokes!\nWow.\nHere, have 1000 pokelets");
	        System.out.println("**************************************");
	        return 1000;
	    }else if(pokes == 500){
	    	System.out.println("**************************************");
	        System.out.println("500 pokes!\nYou have some free time...\nHave 1500 pokelets!");
	        System.out.println("**************************************");
	        return 1500;
	    }else if(pokes == 1000){
	    	System.out.println("**************************************");
	        System.out.println("1000 pokes!\nYou should really take a break, maybe go outside or something.\nHere's 2000 pokelets for motivation!");
	        System.out.println("**************************************");
	        return 2000;
	    }else if(pokes == 5000){
	    	System.out.println("**************************************");
	        System.out.println("Your first 5000 pokes!\nI remember my first 5000 pokes... \nSo many good memories.\nThanks for bringing back those memories! \nHere's 5000 pokelets!");
	        System.out.println("**************************************");
	        return 5000;
	    }else if(pokes == 10000){
	    	System.out.println("**************************************");
	        System.out.println("Wow!\n 10000 pokes!\nYou should go to the dojo!\nThat way you can poke faster!\nHere's 10000 pokelets to help pay for classes or something");
	        System.out.println("**************************************");
	        return 10000;
	    }else if(pokes == 25000){
	    	System.out.println("**************************************");
	        System.out.println("Holey Potatoes! \n25000 pokes!\nHere, have 10000 pokelets!");
	        System.out.println("**************************************");
	        return 10000;
	    }else if(pokes == 50000){
	    	System.out.println("**************************************");
	        System.out.println("Yeah!\n50000 pokes!\nHave you been bit yet?\nIt sucks doesn't it.\nTake these 25000 pokelets and put it in the bank. \nThat way later, you can buy some hotsauce");
	        System.out.println("**************************************");
	        return 25000;
	    }else if(pokes == 100000){
	    	System.out.println("**************************************");
	        System.out.println("Are your fingers tired yet?\nYou should take a break\nAfter all you have poked 100000 times!\nTake these 50000 pokelets!");
	        System.out.println("**************************************");
	        return 50000;
	    }else if(pokes == 500000){
	    	System.out.println("**************************************");
	        System.out.println("It's been awhile since your last reward\nAfter all, you have poke 400000 times since then!\nYou now have a grand total of 500000 pokes!\nTake this pokelet to celebrate!");
	        System.out.println("**************************************");
	        return 1;
	    }else if(pokes == 500001){
	    	System.out.println("**************************************");
	        System.out.println("Just Kidding!\nHA!\nYou thought that I would only give you one pokelet\nI'm not that mean\nI'm so generous that I'll give you 100000 pokelets!");
	        System.out.println("**************************************");
	        return 100000;
	    }else if(pokes == 1000000){
	    	System.out.println("**************************************");
	        System.out.println("WOOHOO! \nONE MILLION POKES! \nTake 1000000 pokelets and have some fun");
	        System.out.println("**************************************");
	        return 1000000;
	    }else if(pokes == 2500000){
	    	System.out.println("**************************************");
	        System.out.println("Can you believe that you have poked two million five hundred thousand times!?!?\nPretty Crazy\nYou know what else is crazy?\nGiving you 500000 pokelets!");
	        System.out.println("**************************************");
	        return 500000;
	    }else if(pokes == 5000000){
	    	System.out.println("**************************************");
	        System.out.println("You should really take a break\nAfter all you have poked 5000000 times\nHere's 50000 pokelets for motivation to like go outside or something");
	        System.out.println("**************************************");
	        return 50000;
	    }else if(pokes == 10000000){
	    	System.out.println("**************************************");
	        System.out.println("TEN MILLION POKES!\nAnd I thought that one million was a lot...\nHave these 750000 pokelets to help celebrate");
	        System.out.println("**************************************");
	        return 750000;
	    }else if(pokes == 100000000){
	    	System.out.println("**************************************");
	        System.out.println("You. have. poked. one. hundred. million. times. get. a. LIFE! Have 10000000 pokelets as a reward");
	        System.out.println("**************************************");
	        return 10000000;
	    }else if(pokes == 200000000){
	    	System.out.println("**************************************");
	        System.out.println("I thought that I told you to get a life. \nDon't poke anymore.\nTake these 10000000 pokelets and leave\nDON'T POKE AGAIN!");
	        System.out.println("**************************************");
	        return 10000000;
	    }else if(pokes == 200000001){
	    	System.out.println("**************************************");
	        System.out.println("I TOLD YOU NEVER TO POKE AGAIN!\nLEAVE NOW BEFORE ITS TOO LATE\nTAKE THESE 1000 pokelets AND LEAVE!!!");
	        System.out.println("**************************************");
	        return 1000;
	    }else if(pokes == 300000000){
	    	System.out.println("**************************************");
	        System.out.println("Don't come crying to me when you get banished\nI warned you\nWhy won't you go away?\nSpend these pokelets on a quit button and leave!\nYou don't know what you've gotten yourslef into");
	        System.out.println("**************************************");
	        return 500000;
	    }else if(pokes == 400000000){
	    	System.out.println("**************************************");
	        System.out.println("If you insist on poking 400 million times, then I will help you\nI was once a poker just like you\nGodess Smoo warned me that she would punish me if I didn't stop poking");
	        System.out.println("I didn't believe her and I kept on poking\nEventually she called me up to the clouds and gave me the same riddle that she gave you\nPunishments will come to you");
	        System.out.println("You think I don't have the power but I do\nOne session will be given to thee\nFind my real name or this world you will flee\n\nObviously I didn't believe it");
	        System.out.println("But I went on the quest anyways\nI poked and poked and poked when eventually she confronted me\nI didn't know her real name and I was banished");
	        System.out.println("She trapped me inside this computer and I have been here since the year 31415\nThat year is very important to her\nYou must use it to find her real name or you will end up like me");
	        System.out.println("Take these 100000000 pokelets and prepare yourself for the epic journey ahead");
	        System.out.println("**************************************");
	        return 100000000;
	    }else if(pokes == 500000000){
	    	System.out.println("**************************************");
	        System.out.println("Halfway to one billion pokes.\nBe prepared for a major battle at the 1 billionth poke\nStart preparing now\nBuy some upgrades with these 10000000 pokelets");
	        System.out.println("**************************************");
	        return 10000000;
	    }else if(pokes == 600000000){
	    	System.out.println("**************************************");
	        System.out.println("600000000 pokes deserves another tip\nMake sure that you have the highest bank account possible and fill it with as many pokelets as you can\nWhen you're low on pokelets, one billion pokelets can come in handy...");
	        System.out.println("Here's 500000000 pokelets to help you fill your bank account");
	        System.out.println("**************************************");
	        return 500000000;
	    }else if(pokes == 700000000){
	    	System.out.println("**************************************");
	        System.out.println("700000000 pokes is a lot of poking\nYou should really take a break before the 1 billionth poke\nI want you to have these 100 pokelets");
	        System.out.println("**************************************");
	        return 100;
	    }else if(pokes == 800000000){
	    	System.out.println("**************************************");
	        System.out.println("WOO HOO!\n800 million pokes!\nMake sure to practice your sparring\nIt will come in handy\nHere's some pokelets to help pay for classes");
	        System.out.println("**************************************");
	        return 31415;
	    }else if(pokes == 900000000){
	    	System.out.println("**************************************");
	        System.out.println("i wish that i could give you a hint but your so close that all i can say is PotAto Yippy SKIPPY Apple PIE TaTEr tots FISH NeT IglOo NaTiOn Toy Hut ElF EARS IRk SiT");
	        System.out.println("LEopard Tick Tock EveRywhere NOWHERE On oFf CHill AiR Apple PEAR Cut CHEESE Tomato POTATO EnteR EXIT Nowhere EVERYWHERE polAr BEAR christMas trEeS use these pokelets");
	        System.out.println("**************************************");
	        return 314159265;
	    }else if(pokes == 999999999){
	    	System.out.println("**************************************");
	        System.out.println("Your next poke is the billionth poke\nGood luck and remember what I told you\nI want you to have these 7777777 pokelets for good luck");
	        System.out.println("**************************************");
	        return 7777777;
	    }else{
	    	return 0;
	    }
	}
}
	    