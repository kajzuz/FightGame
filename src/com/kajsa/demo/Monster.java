package com.kajsa.demo;

import java.util.Random;

import static com.kajsa.demo.Colors.*;

public class Monster implements ICombat{

    // Declaring private
    private String monsterName;
    private int monsterHealth;
    private int monsterStrength;

    // Getters and Setters
    public String getterMonsterName(){
        return monsterName;
    }

    public void setterMonsterName(String monsterName)
    {
        this.monsterName = monsterName;
    }

    public int getterMonsterHealth(){
        return monsterHealth;
    }

    public void setterMonsterHealth(int monsterHealth)
    {
        this.monsterHealth = monsterHealth;
    }

    public int getterMonsterStrength(){
        return monsterStrength;
    }

    public void setterMonsterStrength(int monsterStrength)
    {
        this.monsterStrength = monsterStrength;
    }



    public void monsterAttack(Player player, Monster monster){

        Random random = new Random();
        int randomNumber = random.nextInt(45,75);

        if (player.getterPlayerIntelligence() > randomNumber){
            System.out.println("\n" + monster.getterMonsterName() + " attacking..." + player.getterName() + " dodged right in time!");
            System.out.println("\n" + player.getterName() + " hits back and severely hurts the " + monster.getterMonsterName() + " with double damage!");
            int timesTwoInDamage = player.calculateDamage() * 2;
            setterMonsterHealth(getterMonsterHealth() - timesTwoInDamage);
            System.out.println("\n" + CYAN_BRIGHT + getterMonsterName() + " hp is now: " + getterMonsterHealth() + RESET);
        }else{
            System.out.println("\n" + player.getterName() + " hit the " + monster.getterMonsterName() + " with a big right fist!");
            setterMonsterHealth(-player.calculateDamage());
            System.out.println("That got to hurt!");
            System.out.println("\n" + CYAN_BRIGHT + monster.getterMonsterName() + " hp is now " + getterMonsterHealth() + RESET);
        }
        if (getterMonsterHealth() <= 0){
            player.victory(player, monster);
        }
    }

    public void monsterGetStatus(){

        System.out.println("\n" + RED_BRIGHT + getterMonsterName());
        System.out.println("Hp: " + RESET + getterMonsterHealth() + RED_BRIGHT);
        System.out.println("Strength: " + RESET + getterMonsterStrength());
        System.out.println("-------------------");
    }

    public void generateMonsterList(){

        // Generate different monsters with different strength

        String[] monsters = {"Orc","Demogorgon","Germling","Murloc"};

        int[] monstersHealth = {23, 45, 30, 49};

        int[] monstersStrength = {34, 17, 13, 50};

        setterMonsterName(monsters [new Random().nextInt(monsters.length)]);
        setterMonsterHealth(monstersHealth[3]);
        setterMonsterStrength(monstersStrength [new Random().nextInt(monstersStrength.length)]);

        System.out.println(RED_BRIGHT + "Monster: " + RESET + getterMonsterName());
        System.out.println(RED_BRIGHT +  "Health: " + RESET + getterMonsterHealth() + RED_BRIGHT);
        System.out.println("Strength: " + RESET + getterMonsterStrength());
    }

    @Override
    public int calculateDamage() {
        Random random = new Random();

        return random.nextInt(1,26) + (monsterStrength * 2 / 5);
    }

    @Override
    public void status() {

        monsterGetStatus();

    }
}
