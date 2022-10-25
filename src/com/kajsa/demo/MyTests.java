package com.kajsa.demo;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.testng.Assert.*;

    @Timeout(4)

public class MyTests {

    Player player;
    Monster monster;

    @BeforeAll
    public static void beforeTests(){
        System.out.println("Running tests...\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }

    @BeforeEach
    public void beforeEachTest(){

        player = new Player();
        monster = new Monster();

        monster.setterMonsterName("Monster");
        player.setterName("Player");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Player level up")
    public void playerLevelUpTest() throws InterruptedException {

        Thread.sleep(900);

        assertNotNull(player.getterName());

        assertEquals(player.getterPLayerLevel(),8);

        assertEquals(player.playerLevelUp(),9);

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Player can lose")
    public void playerCanLoseTest() throws InterruptedException {

        Thread.sleep(800);

        assertEquals(player.getterPLayerHealth(),23);

        assertNotNull(monster.getterMonsterName());
        assertNotNull(player.getterName());

        assertTrue(player.defeat(player, monster));

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Players damage/monsters strength")
    public void IfDamageIsAsMuchAsReceivedTest() throws InterruptedException {

        Thread.sleep(1000);

        Random random = new Random();

        assertNotNull(player.getterName());
        assertNotNull(monster.getterMonsterName());

        int rangeOfMonsterStrength = random.nextInt(13,51);

        monster.setterMonsterStrength(rangeOfMonsterStrength);


        assertEquals(player.calculateDamage(),33);

        assertTrue(player.calculateDamage() > 0);

        assertTrue(monster.getterMonsterStrength() >= 13 && monster.getterMonsterStrength() <= 50);

    }
    @AfterAll
    public static void afterTests(){
        System.out.println("\nAll tests was successful!\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }
}