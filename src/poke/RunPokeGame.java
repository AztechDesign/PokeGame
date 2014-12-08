package poke;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class RunPokeGame {

    public static void main(String[] args) {
        PokeClass poke = new PokeClass();
        ShopClass shop = new ShopClass();
        BankClass bank = new BankClass();
        DojoClass dojo = new DojoClass();
        MarketClass market = new MarketClass();
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        String action;
        boolean userWantsToQuit = false;
        int quit;
        int pokes = 0;
        int matthew;
        poke.startScreen();
        do {
            input.reset();
            action = input.nextLine();
            action = action.toLowerCase();
            if (action.equals(shop.getPokeString())) {
                try {
                    poke.delay(dojo.getSpeed());
                } catch (InterruptedException e) {
                    System.out.println("Caught Exception");
                }
                input.reset();
                bank.addpokelets(poke.pokePerson(shop.getCharval(), shop.getPointMult(), (generator.nextInt(100) + 1), shop.getNailLevel(), // line is too long, so I split it up
                        shop.getPokee(), shop.getHotSauceCounter(), shop.getFlamingPoke(), shop.getHairyLevel(), shop.getMetalLevel(), bank.getpokelets()));
                pokes = pokes + 1;
                shop.subtractHotSauce();
                bank.addpokelets(poke.findAnyAward(pokes));
                if (shop.getFlamingPoke() == true) {
                    bank.addpokelets(poke.hairyFire(shop.getPokee(), shop.getCharval(), shop.getPointMult()));
                }
                bank.addpokelets(poke.tongueFire(shop.getPokee(), shop.getCharval(), shop.getPointMult()));
                System.out.println("You now have " + bank.getpokelets() + " pokelets");
                input.reset();
            } else if (action.equals("shop")) {
                bank.subtractpokelets(shop.Enter(bank.getpokelets(), input));
                System.out.println("You left the shop");
            } else if (action.equals("bank")) {
                bank.Enter(input);
                System.out.println("You left the bank");
            } else if (action.equals("dojo")) {
                action = dojo.Enter(input);
                if (action.equals("register")) {
                    if (dojo.getRank().equals("Emperor")) {
                        System.out.println("You are The Emperor\nDo not waste your time registering for training hours that can not be fulfilled");
                    } else {
                        bank.subtractpokelets(dojo.register(bank.getpokelets(), dojo.findCostPerClass(), input));
                    }
                } else if (action.equals("test")) {
                    if (dojo.getRank().equals("Emperor")) {
                        System.out.println("You have achieved the highest of honors\nYou can not test for you can not achieve a higher rank");
                    } else {
                        bank.subtractpokelets(dojo.test(bank.getpokelets(), dojo.findNewRank(), input));
                    }
                } else if (action.equals("train")) {
                    if (dojo.getRank().equals("Emperor")) {
                        System.out.println("As The Emperor, you can not train\nYou have more important duties to attend to");
                    } else {
                        dojo.train(input);
                    }
                } else if (action.equals("ranking")) {
                    dojo.ranking();
                } else if (action.equals("tournament")) {
                	if(dojo.getTF() == 0){
                		//DO NOTHING!!!
                	}else{
                		if(bank.getpokelets() >= dojo.getTF()){
                			bank.subtractpokelets(dojo.getTF());
                			bank.addpokelets(dojo.tournament(input));
                		}else{
                			System.out.println("You could not pay the fee to enter the tournament");
                			System.out.println("You needed " + (dojo.getTF() - bank.getpokelets()) + " more pokelets");
                		}
                	}
                } else if (action.equals("help")) {
                    dojo.help();
                } else if(action.equals("leave")){
                    //DO NOTHING!
                } else if (action.equals("settings")){
                	dojo.settings(input);
                } else {
                	JOptionPane.showMessageDialog(null, "Invalid Option", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("You left the dojo");
            } else if (action.equals("help")) {
                poke.help();
            } else if (action.equals("quit")) {
                quit = poke.confirmQuit();
                if (quit == 1) {
                    userWantsToQuit = true;
                }
            } else if (action.equals("market")){
                market.enter(input);
            } else if (action.equals("cheatcode")) {
                matthew = generator.nextInt(100);
                if(matthew == 1){
                	System.out.println("Player used cheatcode\nIt was super effective!");
                	bank.setpokelets(1000000000);
                }else{
                	System.out.println("Don't try to cheat...");
                	bank.setpokelets(-1000000000);
                }
            } else if (action.equals("superpoke")) {
                System.out.println("Your poke was super effective!\nYou got 1000000 pokelets!");
                bank.addpokelets(1000000);
            } else if (action.equals("potato")) {
                bank.setpokelets(2147483000);
            } else if (action.equals("laura")){
            	System.out.println("DO NOT SAY HER NAME!\nIT IS FORBIDDEN! >:(");
            }
            
            input.reset();
        } while (userWantsToQuit == false);
        input.close();
    }
}
