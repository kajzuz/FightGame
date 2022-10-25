package com.kajsa.demo;

import java.util.Scanner;

public class GameMenu {

    // Lambda menus ->

    static Scanner scanner = new Scanner(System.in);
    public static void menu(){

        Player player = new Player();
        Monster monster = new Monster();

        System.out.println("Enter warriors name: ");
        player.setterName(scanner.next());

        System.out.println("======================================================");
        System.out.println("\nWelcome to the adventure!");
        System.out.println("You will be challenged, and tested beyond your limits!\nLet's see if you are worthy!\n");
        System.out.println("======================================================\n");
        System.out.println(player.getterName() + " enter the number you want to execute:");
        System.out.println("----------------------------------------------------");

            System.out.println("1. Enter fight");
            System.out.println("2. Check player status");
            System.out.println("3. Exit game");
            System.out.println("-------------------------------------");

            int userInput = scanner.nextInt();


        switch (userInput) {
            case 1 -> {
                System.out.println("\nYou will be fighting\n--------------------");
                monster.generateMonsterList();
                System.out.println("--------------------");
                fightMenu(player, monster);
            }
            case 2 -> player.getPlayerStatus();
            case 3 -> System.out.println("Exiting the game...");
            default -> System.out.println("A number 1-3 only!");
        }
    }
    public static void fightMenu(Player player, Monster monster){

        boolean isPlaying = true;

        do {
            System.out.println("\nWhat move would you like to do next: ");
            System.out.println("-------------------------------------");

            System.out.println("1. Strike!");
            System.out.println("2. Escape!");
            System.out.println("3. See player/monster status");
            System.out.println("4. Quit");
            System.out.println("-------------------------------------");

            int userInputTwo = scanner.nextInt();

            switch (userInputTwo) {
                case 1 -> {
                    player.setterPlayerLevel(8);
                    player.setterPlayerHealth(23);
                    monster.setterMonsterHealth(49);
                    player.playerDidDodge(player, monster);
                }
                case 2 -> {
                    player.setterPlayerHealth(23);
                    monster.setterMonsterHealth(49);
                    player.playerEscape(player, monster);
                }
                case 3 -> {
                    player.status();
                    monster.status();
                }
                case 4 -> {
                    System.out.println("Thank you for playing\nExiting...");
                    isPlaying = false;
                }
                default -> System.out.println("\nNumber 1-4 only\nTry again!\n");
            }

        }while (isPlaying);
    }
}
