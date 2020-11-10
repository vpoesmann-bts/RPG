/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

/**
 *
 * @author sogeking
 */
public class Warrior {

    protected String name;

    protected int maxHPStat;
    protected int attackStat;
    protected int defenseStat;

    protected int currentHP;
    protected boolean isAlive;

    protected boolean isGuarding;

    public Warrior(String p_name, int p_maxHPStat, int p_attackStat, int p_defenseStat) {
        this.name = p_name;

        this.maxHPStat = p_maxHPStat;
        this.currentHP = this.maxHPStat;
        this.attackStat = p_attackStat;
        this.defenseStat = p_defenseStat;
        this.isAlive = true;

    }

    public String getName() {
        return name;
    }

    public int getMaxHPStat() {
        return maxHPStat;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public int getDefenseStat() {
        return defenseStat;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public boolean isAlive() {
        return isAlive;
    }
    
    public boolean isGuarding() {
        return isGuarding;
    }

    public void attack(Warrior enemy) {
        int actualDefense = enemy.isGuarding() ? enemy.getDefenseStat() * 2 : enemy.getDefenseStat();
        int damage = (int) (100 * ((double) attackStat / (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }

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

    public String toString() {
        String result = getClassName() + " " + name + " => ";
        result += "HP : " + currentHP + "/" + maxHPStat + " | ";
        result += "ATK : " + attackStat + " | ";
        result += "DEF : " + defenseStat + " | ";

        return result;
    }

    public String getClassName() {
        return "Warrior";
    }
}
