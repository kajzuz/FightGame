package com.kajsa.demo;

public class Main {
    public static void main(String[] args) {


           while (true){

               try{
                   GameMenu.menu();
                   break;
               }catch(Exception e){
                   System.out.println("\nIncorrect input\nTry again!\n");
               }
           }
    }
}