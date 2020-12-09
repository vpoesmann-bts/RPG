/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

/**
 *
 * @author Piranoss	
 */
public class Bard extends Character {

    protected static final int LVL1_MAX_HP = 80;
    protected static final int LVL1_MAX_MANA = 40;

    protected static final int LVL1_ATK_STAT = 2;
    protected static final int LVL1_DEF_STAT = 2;
    protected static final int LVL1_MAG_STAT = 5;
    protected static final int LVL1_MDF_STAT = 4;

    protected static final int BASE_LVL_UP_EXP = 80;
    protected static final int[] statsLevelUpMin = {6, 4, 1, 1, 2, 2};
    protected static final int[] statsLevelUpMax = {10, 6, 3, 3, 4, 4};
    
    public Bard(String p_name) {
        super(p_name);

        this.maxHPStat = LVL1_MAX_HP;
        this.currentHP = this.maxHPStat;

        this.maxManaStat = LVL1_MAX_MANA;
        this.currentMana = this.maxManaStat;

        this.attackStat = LVL1_ATK_STAT;
        this.defenseStat = LVL1_DEF_STAT;
        this.magicStat = LVL1_MAG_STAT;
        this.magicDefStat = LVL1_MDF_STAT;

        this.gainExp(2000000);
    }

    public void attack(Character enemy) {
        int actualDefense = enemy.isGuarding() ? enemy.getMagicDefenseStat() * 2 : enemy.getMagicDefenseStat();
        int damage = (int) (100 * ((double) magicStat / (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }
    
    @Override
    public String getClassName() {
        return "Warrior";
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
