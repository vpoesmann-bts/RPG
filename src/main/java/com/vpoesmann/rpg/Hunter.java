/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;
/**
 *
 * @author jouault
 */

public class Hunter extends Character {

    protected static final int LVL1_MAX_HP = 80;
    protected static final int LVL1_MAX_MANA = 20;

    protected static final int LVL1_ATK_STAT = 15;
    protected static final int LVL1_DEF_STAT = 3;
    protected static final int LVL1_MAG_STAT = 2;
    protected static final int LVL1_MDF_STAT = 2;

    protected static int[] statsLevelUpMin = {8, 1, 2, 2, 0, 0};
    protected static int[] statsLevelUpMax = {12, 2, 4, 4, 1, 1};

    public Hunter(String p_name) {
        super(p_name);

        this.maxHPStat = LVL1_MAX_HP;
        this.currentHP = this.maxHPStat;

        this.maxManaStat = LVL1_MAX_MANA;
        this.currentMana = this.maxManaStat;

        this.attackStat = LVL1_ATK_STAT;
        this.defenseStat = LVL1_DEF_STAT;
        this.magicStat = LVL1_MAG_STAT;
        this.magicDefStat = LVL1_MDF_STAT;

        this.gainExp(200);
    }

    @Override
    public void attack(Character enemy) {
        int actualDefense = enemy.isGuarding() ? enemy.getDefenseStat() * 2 : enemy.getDefenseStat();
        int damage = (int) (100 * ((double) attackStat / (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }

    @Override
    public String getClassName() {
        return "Hunter";
    }

    @Override
    protected int[] getStatsLevelUpMin() {
        return statsLevelUpMin;
    }

    @Override
    protected int[] getStatsLevelUpMax() {
        return statsLevelUpMax;
    }
}
