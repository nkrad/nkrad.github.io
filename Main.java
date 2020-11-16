/********************************
Author: Joshua Wiebe, Nick Radocaj, David Hughes, Tanner Bouteiller
Date Started: Nov 2, 2020
Instructor: Ken Carpenter & Damien Altenburg
Question: Bonus marks? XDDD

Task: Create a text-based Monopoly in Java

CURRENT PROBLEMS:
-
********************************/
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.Date;

class Main {
  public static int mapPlace;

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    //arrays
    ArrayList<Property> properties = new ArrayList<>();
    ArrayList<Property> ownedProperties = new ArrayList<>();
    ArrayList<String> ownedPropertiesNames = new ArrayList<>();
    ArrayList<Property> ownedProperties2 = new ArrayList<>();
    ArrayList<String> ownedPropertiesNames2 = new ArrayList<>();
    // variables

    //object to set Map Place
    Mapplace m = new Mapplace(1);

    int place = 1;
    int place2 = 1;
    int money = 1500;
    int money2 = 1500;
    int timeInJail = 0;
    int timeInJail2 = 0;

    boolean gameStart = false;
    boolean jail = false;
    boolean jail2 = false;
    boolean turn = true;

    //time variables
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0L;

    String answer = "";
    String name = "";
    // end of variables

    // general properties
    //(name, price, colour, place on board, bought status, property type, rent, # of houses)
    properties.add(new Property("GO", 0, Colour.CORNER,  1, false, Type.CORNER, 0, 0));
    properties.add(new Property("Mediterranean Avenue", 60, Colour.BROWN, 2, false, Type.PROPERTY, 2, 0));
    properties.add(new Property("COMMUNITY CHEST", 0, Colour.CHEST, 3, false, Type.CHEST, 0, 0));
    properties.add(new Property("Baltic Avenue", 60, Colour.BROWN, 4, false, Type.PROPERTY, 4, 0));
    properties.add(new Property("INCOME TAX", 0, Colour.TAX, 5, false, Type.TAX, 200, 0));
    properties.add(new Property("READING RAILROAD", 200, Colour.RAILROAD, 6, false, Type.PROPERTY, 25, 0));
    properties.add(new Property("Oriental Avenue", 100, Colour.LIGHTBLUE, 7, false, Type.PROPERTY, 6, 0));
    properties.add(new Property("CHANCE", 0, Colour.CHANCE, 8, false, Type.CHANCE, 0, 0));
    properties.add(new Property("Vermont Avenue", 100, Colour.LIGHTBLUE, 9, false, Type.PROPERTY, 6, 0));
    properties.add(new Property("Conneticut Avenue", 120, Colour.LIGHTBLUE, 10, false, Type.PROPERTY, 8, 0));
    properties.add(new Property("JAIL", 0, Colour.CORNER, 11, false, Type.CORNER, 0, 0));
    properties.add(new Property("St. Charles Place", 140, Colour.PINK, 12, false, Type.PROPERTY, 10, 0));
    properties.add(new Property("ELECTRIC COMPANY", 150, Colour.UTILITY, 13, false, Type.PROPERTY, 75, 0));
    properties.add(new Property("States Avenue", 140, Colour.PINK, 14, false, Type.PROPERTY, 10, 0));
    properties.add(new Property("Virginia Avenue", 160, Colour.PINK, 15, false, Type.PROPERTY, 12, 0));
    properties.add(new Property("PENNSYLVANIA RAILROAD", 200, Colour.RAILROAD, 16, false, Type.PROPERTY, 25, 0));
    properties.add(new Property("St. James Place", 180, Colour.ORANGE, 17, false, Type.PROPERTY, 14, 0));
    properties.add(new Property("COMMUNITY CHEST", 0, Colour.CHEST, 18, false, Type.CHEST, 0, 0));
    properties.add(new Property("Tennesee Avenue", 180, Colour.ORANGE, 19, false, Type.PROPERTY, 14, 0));
    properties.add(new Property("New York Avenue", 200, Colour.ORANGE, 20, false, Type.PROPERTY, 16, 0));
    properties.add(new Property("FREE PARKING", 0, Colour.CORNER, 21, false, Type.CORNER, 0, 0));
    properties.add(new Property("Kentucky Avenue", 220, Colour.RED, 22, false, Type.PROPERTY, 18, 0));
    properties.add(new Property("CHANCE", 0, Colour.CHANCE, 23, false, Type.CHANCE, 0, 0));
    properties.add(new Property("Indiana Avenue", 220, Colour.RED, 24, false, Type.PROPERTY, 18, 0));
    properties.add(new Property("Illinois Avenue", 240, Colour.RED, 25, false, Type.PROPERTY, 20, 0));
    properties.add(new Property("B & O RAILROAD", 200, Colour.RAILROAD, 26, false, Type.PROPERTY, 25, 0));
    properties.add(new Property("Atlantic Avenue", 260, Colour.YELLOW, 27, false, Type.PROPERTY, 22, 0));
    properties.add(new Property("Ventor Avenue", 260, Colour.YELLOW, 28, false, Type.PROPERTY, 22, 0));
    properties.add(new Property("WATER WORKS", 150, Colour.UTILITY, 29, false, Type.PROPERTY,75, 0));
    properties.add(new Property("Marvin Gardens", 280, Colour.YELLOW, 30, false, Type.PROPERTY, 24, 0));
    properties.add(new Property("GO TO JAIL", 0, Colour.CORNER, 31, false, Type.JAIL, 0, 0));
    properties.add(new Property("Pacific Avenue", 300, Colour.GREEN, 32, false, Type.PROPERTY, 26, 0));
    properties.add(new Property("North Carolina Avenue", 300, Colour.GREEN, 33, false, Type.PROPERTY, 26, 0));
    properties.add(new Property("COMMUNITY CHEST", 0, Colour.CHEST, 34, false, Type.CHEST, 0, 0));
    properties.add(new Property("Pennsylvania Avenue", 320, Colour.GREEN, 35, false, Type.PROPERTY, 28, 0));
    properties.add(new Property("SHORT LINE", 200, Colour.RAILROAD, 36, false, Type.PROPERTY, 25, 0));
    properties.add(new Property("CHANCE", 0, Colour.CHANCE, 37, false, Type.CHANCE, 0, 0));
    properties.add(new Property("Park Place", 350, Colour.BLUE, 38, false, Type.PROPERTY, 35, 0));
    properties.add(new Property("LUXURY TAX", 0, Colour.TAX, 39, false, Type.TAX, 100, 0));
    properties.add(new Property("Boardwalk", 400, Colour.BLUE, 40, false, Type.PROPERTY, 50, 0));
    // end of general properties



    // Start Screen Monopoly Man
    System.out.println("            `::-                                  \r\n            ://o+         /oy/:.                  \r\n             :+o-       `smd+//+so.               \r\n           -+o:     /. :hdhso++unixo.             \r\n         .+o/`      `sohdhssoydmmmmds             \r\n      .//o/`       ./--..-+ssyhdddy:              \r\n    ./:+.-+.       +:/....--:.:sdh:       ::.     \r\n   `/++:.:-hdo-  .:+::+..-/...//mhd`    `-+.+::-` \r\n  :oo-----dmmmmdyy/.  ``::.....-o+:`-/odm:/...++/.\r\n:oo:     .smmmmmmmmm+/o- .:/-/yyddmnickmmd-+/::::.\r\no:         `-+yjoshmy++/+o++dmmposixmmmmmh/       \r\n                `-:d/+mmmm-smmmmmhyso+:-`         \r\n                   :+  . ``:mmmmms                \r\n                   .d` .`   ymmmmm+               \r\n                  `yms  :`  -hmmmmmy-             \r\n                 -ydyo+oos++oooyhmhhyo`           \r\n                 .oooooooosooooooos+:             \r\n                 sooooooso+oooooooooy/            \r\n                `yooooss:  `+soooooooy/`  `/o     \r\n                `soooooy`    .oyooodavidshdd.     \r\n                 :oooooso      .+ssoooohdy/`      \r\n              :yytannerd/         -/oymh`         ");
   System.out.println("\n\n                   |... Loading ...|");

    //timer for loading screen
    while (elapsedTime < 3600)
    {
      elapsedTime = (new Date()).getTime() - startTime;
    }

    gameStart = true;
    while(gameStart){
      Random die = new Random();

      if(timeInJail > 4 & timeInJail > 1){
        jail = false;
        System.out.println("You've done your time, Player 1. Don't be back.");
      }

      if(timeInJail2 > 4 & timeInJail2 > 1){
        jail2 = false;
        System.out.println("You've done your time, Player 2. Don't be back.");
      }

      //Player 1
      while (turn) {
        System.out.println("PLAYER 1\n\n\n");
        // roll of the die

        int roll = die.nextInt(5) + 1;
        int roll2 = die.nextInt(5) + 1;

        if(jail){
          System.out.println("\nYou are in jail");
          timeInJail += 1;
          if(roll == roll2){
            jail = false;
          }else{
            turn = false;
          }
        }
        place += roll + roll2;
        m.mapPlace = place;

        // landing on jail
        if(place == 11){
          place = 30;
          System.out.println("\tYou are now in JAIL.");
          timeInJail = 1;
          jail = true;
          turn = false;
        }

        //going around the board
        if(place > 39){
          place = place - 40;
          money = money + 200;
        }

        System.out.println("You roll " + (roll + roll2) + "\n");

        // landing on the tiles
        Property currentTile = null;
        for(Property p : properties){
          if(p.getBoardPlace() == place){
              System.out.println("\tYou land on " + p.getName() + " with $" + money);
                  if(p.getType() == Type.PROPERTY){
                    System.out.println("\tThe price of this property is $" + p.getPrice() + ".\n");
                  }else if(p.getType() == Type.JAIL){
                    System.out.println("\tYou are in JAIL.\n");
                  }else if(p.getType() == Type.CHEST){
                    System.out.println("\tYou pick up a Community Chest card, it reads ADD FUNCTIONALITY\n");
                  }else if(p.getType() == Type.CHANCE){
                    System.out.println("\tYou pick up a Chance card, it reads ADD FUNCTIONALITY\n");
                  }else if(p.getType() == Type.TAX){
                    if(p.getName().equals("LUXURY TAX")){
                      money -= 100;
                      System.out.println("You land on LUXURY TAX. 100$ has been deducted from your account.");
                    }else if(p.getType() == Type.TAX){
                      if(p.getName().equals("INCOME TAX")){
                        money -= 200;
                        System.out.println("You land on INCOME TAX. 200$ has been deducted from your account.");
                        }
                    }
                  }
                currentTile = p;
                }
              }

          //purchasing
          boolean purchasing = true;
          while(purchasing){
            //so you cant buy non-properties
            if(currentTile.getBought() == false && currentTile.getType() == Type.PROPERTY){
              System.out.print("Would you like to purchase " + currentTile.getName() + "? (y/n) ");

              answer = keyboard.nextLine();
              if (answer.equalsIgnoreCase("y")) {
                money -= currentTile.getPrice();
                System.out.println("\tYou now have $" + money + "\n");
                currentTile.setBuy();

                //adding to parallel arrays (inventory)
                ownedProperties.add(currentTile);
                ownedPropertiesNames.add(currentTile.toString());

                purchasing = false;
                }else if (answer.equalsIgnoreCase("n")) {
                  System.out.println("You have elected to not purchase " + currentTile.getName() + " \n");
                  purchasing = false;

                }else
                  System.out.println("\nThat is not a command.\n");

            }else{
              if(currentTile.getType() == Type.PROPERTY){
                System.out.println("\tThis property is already bought");
                System.out.println("You pay $" + currentTile.getRent() + " in rent.");
                money -= currentTile.getRent();
                money2 += currentTile.getRent();
                System.out.println("\tYou now have :$" + money + "\n");
                purchasing = false;
              }
            }
            purchasing = false;
          }
          //actions at end of turn
          boolean actions = true;
          while(actions){

            System.out.println("What would you like to do now?");
            System.out.println("\tType 'c' to see your cash");
            System.out.println("\tType 'n' to finish your turn");
            System.out.println("\tType 'h' to add a house");
            System.out.println("\tType 'r' to check the rents for your properties");
            System.out.println("\tType 'm' to see the map of the Board");
            System.out.println("\tType 'i' to check your properties\n");


          answer = keyboard.nextLine();
          //displays money
          if(answer.equals("c")){
            System.out.println("$" + money);
            System.out.println("");

            //display owned properties
          }else if(answer.equals("i")){
            System.out.println("\nYOU OWN THESE PROPERTIES");
            System.out.println("***************************\n");
            for(int i = 0; i <= ownedPropertiesNames.size()-1; i++){
              System.out.println(ownedPropertiesNames.get(i));
              System.out.println("");
            }

            //user adds houses
          }else if(answer.equals("h")){
            for(int i = 0; i <= ownedPropertiesNames.size()-1; i++){
              System.out.println(ownedPropertiesNames.get(i));
            }

            System.out.print("Which property would you like to add a house on? (Use exact names)  ");
            answer = keyboard.nextLine();
            for(Property p: ownedProperties){

              if(answer.equalsIgnoreCase(p.getName())){
                p.addHouse();
                System.out.println("\tYou added a house onto " + p.getName() + "\n");
                p.setRent();

              }
            }
            //display rent
          }else if(answer.equals("r")){
            for(int i = 0; i <= ownedPropertiesNames.size()-1; i++){
              System.out.println("\t" + ownedPropertiesNames.get(i)+ ": $" + ownedProperties.get(i).getRent());
            }
            System.out.println("");

            //next turn
          }else if(answer.equals("m")){
            map.mapDisplay();
          }else if(answer.equals("n")){
            actions = false;
          }
        }
            //clearing the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //rolling doubles to go again
            if(roll == roll2){
              System.out.println("You rolled doubles, Player 1. Go again");
            }else{
              turn = false;
            }

      }

      //Player 2
      while (turn == false) {
        System.out.println("PLAYER 2\n\n\n");
        // roll of the die
        int roll = die.nextInt(6) + 1;
        int roll2 = die.nextInt(6) + 1;

        if(jail2){
          System.out.println("\tYou are in jail\n");
          timeInJail += 1;
          if(roll == roll2){
            jail2 = false;
          }else{
            turn = true;
          }
        }

        place2 += roll + roll2;
        m.mapPlace = place2;

        // landing on jail
        if(place2 == 11){
          place2 = 11;
          System.out.println("\tYou are now in JAIL.\n");
          timeInJail2 = 1;
          jail2 = true;
          turn = true;
        }

        //going around the board
        if(place2 > 40){
          place2 = place2 - 40;
          money2 = money2 + 200;
        }

        System.out.println("You roll " + (roll + roll2) + "\n");

        // landing on the tiles
        Property currentTile2 = null;
        for(Property p : properties){
          if(p.getBoardPlace() == place2){
              System.out.println("\tYou land on " + p.getName() + " with $" + money2);
                  if(p.getType() == Type.PROPERTY){
                    System.out.println("\tThe price of this property is $" + p.getPrice() + ".\n");
                  }else if(p.getType() == Type.JAIL){
                    System.out.println("\tYou are in JAIL.\n");
                  }else if(p.getType() == Type.CHEST){
                    System.out.println("\tYou pick up a Community Chest card, it reads ADD FUNCTIONALITY\n");
                  }else if(p.getType() == Type.CHANCE){
                    System.out.println("\tYou pick up a Chance card, it reads ADD FUNCTIONALITY\n");
                  }else if(p.getType() == Type.TAX){
                    if(p.getName().equals("LUXURY TAX")){
                      money2 -= 100;
                      System.out.println("You land on LUXURY TAX. 100$ has been deducted from your account.\n");
                    }else if(p.getType() == Type.TAX){
                      if(p.getName().equals("INCOME TAX")){
                        money2 -= 200;
                        System.out.println("You land on INCOME TAX. 200$ has been deducted from your account.\n");
                        }
                    }
                  }
                currentTile2 = p;
                }
              }

          //purchasing
          boolean purchasing = true;
          while(purchasing){
            //so you cant buy non-properties
            if(currentTile2.getBought() == false && currentTile2.getType() == Type.PROPERTY){
              System.out.print("Would you like to purchase " + currentTile2.getName() + "? (y/n) ");

              answer = keyboard.nextLine();
              if (answer.equalsIgnoreCase("y")) {
                money2 -= currentTile2.getPrice();
                System.out.println("\tYou now have $" + money2 + "\n");
                currentTile2.setBuy();

                //adding to parallel arrays (inventory)
                ownedProperties2.add(currentTile2);
                ownedPropertiesNames2.add(currentTile2.toString());

                purchasing = false;
                }else if (answer.equalsIgnoreCase("n")) {
                  System.out.println("You have elected to not purchase " + currentTile2.getName() + " \n");
                  purchasing = false;

                }else
                  System.out.println("\nThat is not a command.\n");

            }else{
              if(currentTile2.getType() == Type.PROPERTY){
                System.out.println("\tThis property is already bought \n");
                System.out.println("You pay $" + currentTile2.getRent() + " in rent.");
                money2 -= currentTile2.getRent();
                money += currentTile2.getRent();
                System.out.println("You now have :$" + money2 + "\n");
                purchasing = false;
              }
            }
            purchasing = false;
          }
          //actions at end of turn
          boolean actions = true;
          while(actions){

            System.out.println("What would you like to do now?");
            System.out.println("\tType 'c' to see your cash");
            System.out.println("\tType 'n' to finish your turn");
            System.out.println("\tType 'h' to add a house");
            System.out.println("\tType 'r' to check the rents for your properties");
            System.out.println("\tType 'm' to see the map of the Board");
            System.out.println("\tType 'i' to check your properties\n");


          answer = keyboard.nextLine();
          //displays money
          if(answer.equals("c")){
            System.out.println("$" + money2);
            System.out.println("");

            //display owned properties
          }else if(answer.equals("i")){
            System.out.println("\nYOU OWN THESE PROPERTIES");
            System.out.println("***************************\n");
            for(int i = 0; i <= ownedPropertiesNames2.size()-1; i++){
              System.out.println(ownedPropertiesNames2.get(i));
              System.out.println("");
            }

            //user adds houses
          }else if(answer.equals("h")){
            for(int i = 0; i <= ownedPropertiesNames2.size()-1; i++){
              System.out.println(ownedPropertiesNames2.get(i));
            }

            System.out.print("Which property would you like to add a house on? (Use exact names)  ");
            answer = keyboard.nextLine();
            for(Property p: ownedProperties2){

              if(answer.equalsIgnoreCase(p.getName())){
                p.addHouse();
                System.out.println("\tYou added a house onto " + p.getName() + "\n");
                p.setRent();

              }
            }
            //display rent
          }else if(answer.equals("r")){
            for(int i = 0; i <= ownedPropertiesNames2.size()-1; i++){
              System.out.println("\t" + ownedPropertiesNames2.get(i)+ ": $" + ownedProperties2.get(i).getRent());
            }
            System.out.println("");

            //next turn
          }else if(answer.equals("m")){
            map.mapDisplay();
          }else if(answer.equals("n")){
            actions = false;
          }
        }
            //clearing the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(roll == roll2){
              System.out.println("You rolled doubles, Player 2. Go again");
            }else{
              turn = true;
            }

        }
    }
  }
  }
