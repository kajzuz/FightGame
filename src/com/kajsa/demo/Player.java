package com.kajsa.demo;

import java.util.Random;

import static com.kajsa.demo.Colors.*;

public class Player implements ICombat {

    //Instantiate/declaring variables
    private String name;
    private int strength = 27;
    private int intelligence = 54;
    private int agility = 45;
    private int health = 23;
    private int experience;
    private int level = 8;
    private int baseDamage = 19;


    // Getters and Setters
    public String getterName()

    {
        return name;
    }

    public void setterName(String name)
    {
        this.name = name;
    }

    public int getterPlayerStrength()

    {
        return strength;
    }

    public void setterPlayerStrength(int strength){
        this.strength = strength;
    }// Strength


    public int getterPlayerIntelligence()

    {
        return intelligence;
    }

    public void setterPlayerIntelligence(int intelligence){
        this.intelligence = intelligence;
    }


    public int getterPLayerAgility()

    {
        return agility;
    }

    public void setterPlayerAgility(int agility){
        this.agility = agility;
    }//agility

    public int getterPLayerHealth()

    {
        return health;
    }

    public void setterPlayerHealth(int health){
        this.health = health;
    }

    public int getterPLayerExperience()

    {
        return experience;
    }

    public void setterPlayerExperience(int experience){
        this.experience = experience;
    }

    public int getterPLayerLevel()

    {
        return level;
    }

    public void setterPlayerLevel(int level){
        this.level = level;
    }

    public int getterPLayerBaseDamage()

    {
        return baseDamage;
    }

    public void setterPlayerBaseDamage(int baseDamage){
        this.baseDamage = baseDamage;
    }


    public int playerLevelUp(){

            setterPlayerLevel(getterPLayerLevel() + 1);

            System.out.println("\nYou just reached a new level!");
            System.out.println(CYAN_BRIGHT + "You level is now " + getterPLayerLevel() + RESET + "\n");

            setterPlayerStrength(27 * 2);
            setterPlayerIntelligence(54 * 2);
            setterPlayerAgility(45 * 2);

            System.out.println("Some of your things has been upgraded: \n--------------------------------------");
            System.out.println("*" + CYAN_BRIGHT + " New Strength = " + getterPlayerStrength() + RESET);
            System.out.println("*" + CYAN_BRIGHT + " New Intelligence = " + getterPlayerIntelligence() + RESET);
            System.out.println("*" + CYAN_BRIGHT + " New Agility = " + getterPLayerAgility() + RESET);

        return getterPLayerLevel();
    }


    public void playerEscape(Player player, Monster monster){

        Random random = new Random();
        player.setterPlayerLevel(8);

        int randomValue = random.nextInt(20,36);
        experience = random.nextInt(5,40);

        if (experience > randomValue){
            System.out.println("\n" + player.getterName() + " escaped the intimidating " + monster.getterMonsterName());
        }else{
            System.out.println("The " + monster.getterMonsterName() + " is to fast, escape was not successful..");
            playerFight(player,monster);
        }
    }

    public void playerFight(Player player, Monster monster){

        playerDidDodge(player,monster);
        calculateDamage();
    }

    public void getStatus(){

        System.out.println("\n" + CYAN_BRIGHT + getterName());
        System.out.println("Hp: " + RESET + getterPLayerHealth() + CYAN_BRIGHT);
        System.out.println("Strength: " + RESET + getterPlayerStrength());
        System.out.println("-------------------");
    }

    public void getPlayerStatus(){

        Random random = new Random();

        experience = random.nextInt(40,50);

        setterPlayerHealth(health);
        setterPlayerStrength(strength);
        setterPlayerIntelligence(intelligence);
        setterPlayerAgility(agility);
        setterPlayerExperience(experience);
        setterPlayerBaseDamage(baseDamage);
        setterPlayerLevel(level);

        System.out.println("\n" + CYAN_BRIGHT + getterName() +" status: ");
        System.out.println("<><><><><><><><><><>");
        System.out.println("- Hp: " + RESET + getterPLayerHealth());
        System.out.println(CYAN_BRIGHT + "- Strength: " + RESET + getterPlayerStrength());
        System.out.println(CYAN_BRIGHT + "- Intelligence: " + RESET + getterPlayerIntelligence());
        System.out.println(CYAN_BRIGHT + "- BaseDamage: " + RESET +  getterPLayerBaseDamage());
        System.out.println(CYAN_BRIGHT + "- Agility: " + RESET + getterPLayerAgility());
        System.out.println(CYAN_BRIGHT + "- Level: " + RESET + getterPLayerLevel());
        System.out.println(CYAN_BRIGHT + "- EXP: "  + RESET + getterPLayerExperience());
        System.out.println(CYAN_BRIGHT + "<><><><><><><><><><>" + RESET);
    }
    public void playerDidDodge(Player player, Monster monster) {

        Random random = new Random();

        int randomNumber = random.nextInt(5, 40);
        agility = random.nextInt(20,36);

        if (randomNumber < agility) {
            setterPlayerHealth(getterPLayerHealth());
            System.out.println("\n" + player.getterName() + " got hit bad by the " + monster.getterMonsterName());
            setterPlayerHealth(- monster.calculateDamage());
            System.out.println(RED_BRIGHT + getterName() + " hp is now " + getterPLayerHealth() + RESET);
            if (getterPLayerHealth() <= 0){
                defeat(player,monster);
            }
        }
        else{
            monster.monsterAttack(player, monster);
        }
    }

    public void victory(Player player,Monster monster){

            Random random = new Random();

            experience = random.nextInt(40, 50);

            System.out.println("\n" + player.getterName() + " totally destroyed the " + monster.getterMonsterName());
            System.out.println("\n"+ player.getterName() + YELLOW_BRIGHT + " is victorius!\n" + RESET);
            setterPlayerExperience(experience * 2);
            System.out.println("Your reward will be double EXP:" + CYAN_BRIGHT +" \nYour" + " EXP is now " + getterPLayerExperience() + RESET);
            playerLevelUp();
    }

    public boolean defeat(Player player, Monster monster){

            System.out.println(RED_BRIGHT +"\n"+ monster.getterMonsterName() + " defeated " + player.getterName() + "!" + RESET);
            System.out.println("\n" + player.getterName() + ": You may have won this time but i will be back!");
            System.out.println(RED_BRIGHT + "\nGame Over.....\n" + RESET);

        return true;
    }


    @Override
    public int calculateDamage() {

        return baseDamage + (strength * 2 / 4 + 1);
    }

    @Override
    public void status() {

        getStatus();

    }
}
