/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

import java.util.Random;

/**
 *
 * @author sogeking
 */
public abstract class Character {

    protected static final int BASE_LVL_UP_EXP = 80;

    protected String name;

    protected int exp;
    protected int level;

    protected int maxHPStat;
    protected int maxManaStat;

    protected int attackStat;
    protected int defenseStat;

    protected int magicStat;
    protected int magicDefStat;

    protected int currentHP;
    protected int currentMana;

    protected boolean isAlive;

    protected boolean isGuarding;

    public Character(String p_name) {
        this.name = p_name;

        this.isAlive = true;

        this.level = 1;
        this.exp = 0;

    }

    public int nombreAleatoire(int min, int max) {
        Random r = new Random();
        return r.nextInt((max + 1) - min) + min;
    }

    public int getExpToNextLevel() {
        return (int) (BASE_LVL_UP_EXP * Math.pow(1.1, level));
    }

    public final void gainExp(int amount) {
        exp += amount;
        while (exp > getExpToNextLevel()) {
            exp -= getExpToNextLevel();
            levelUp();
            System.out.println(getExpToNextLevel());
        }
    }

    public void levelUp() {
        level++;
        int hpGain = nombreAleatoire(getStatsLevelUpMin()[0], getStatsLevelUpMax()[0]);
        int mpGain = nombreAleatoire(getStatsLevelUpMin()[1], getStatsLevelUpMax()[1]);
        maxHPStat += hpGain;
        maxManaStat += mpGain;
        attackStat += nombreAleatoire(getStatsLevelUpMin()[2], getStatsLevelUpMax()[2]);
        defenseStat += nombreAleatoire(getStatsLevelUpMin()[3], getStatsLevelUpMax()[3]);
        magicStat += nombreAleatoire(getStatsLevelUpMin()[4], getStatsLevelUpMax()[4]);
        magicDefStat += nombreAleatoire(getStatsLevelUpMin()[5], getStatsLevelUpMax()[5]);

        currentHP += hpGain;
        currentMana += mpGain;
        System.out.println(maxHPStat);
    }

    protected abstract int[] getStatsLevelUpMin();

    protected abstract int[] getStatsLevelUpMax();

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getMaxHPStat() {
        return maxHPStat;
    }

    public int getMaxManaStat() {
        return maxManaStat;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public int getDefenseStat() {
        return defenseStat;
    }

    public int getMagicStat() {
        return magicStat;
    }

    public int getMagicDefenseStat() {
        return magicDefStat;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isGuarding() {
        return isGuarding;
    }

    public abstract void attack(Character enemy);

    public void guard() {
        isGuarding = true;
    }

    public void takeDamage(int amount) {

        currentHP -= amount;
        if (currentHP <= 0) {
            currentHP = 0;
            isAlive = false;
        }
        System.out.println("ouch ! " + getName() + " : " + currentHP + "/" + maxHPStat);
    }

    @Override
    public String toString() {
        String result = getClassName() + " " + name + " => ";
        result += "HP : " + currentHP + "/" + maxHPStat + " | ";
        result += "MP : " + currentMana + "/" + maxManaStat + " | ";
        result += "ATK : " + attackStat + " | ";
        result += "DEF : " + defenseStat + " | ";
        result += "MAG : " + magicStat + " | ";
        result += "MDF : " + magicDefStat + " | ";

        return result;
    }

    public abstract String getClassName();
}
