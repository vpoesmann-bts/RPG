<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

/**
 *
 * @author UnSbire
 */
public class Priest extends Character {

    protected static final int LVL1_MAX_HP = 70;
    protected static final int LVL1_MAX_MANA = 50;

    protected static final int LVL1_ATK_STAT = 2;
    protected static final int LVL1_DEF_STAT = 2;
    protected static final int LVL1_MAG_STAT = 3;
    protected static final int LVL1_MDF_STAT = 5;

    protected static int[] statsLevelUpMin = {5, 5, 1, 1, 2, 2};
    protected static int[] statsLevelUpMax = {10, 8, 2, 2, 3, 4};

    public Priest(String p_name) {
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
        int actualDefense = enemy.isGuarding() ? enemy.getMagicDefenseStat() * 2 : enemy.getMagicDefenseStat();
        int damage = (int) (100 * ((double) magicStat/ (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }

    @Override
    public String getClassName() {
        return "Priest";
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

=======
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
public class Priest extends Character {

    protected static final int LVL1_MAX_HP = 70;
    protected static final int LVL1_MAX_MANA = 50;

    protected static final int LVL1_ATK_STAT = 2;
    protected static final int LVL1_DEF_STAT = 2;
    protected static final int LVL1_MAG_STAT = 3;
    protected static final int LVL1_MDF_STAT = 5;

    protected static int[] statsLevelUpMin = {5, 5, 1, 1, 2, 2};
    protected static int[] statsLevelUpMax = {10, 8, 2, 2, 3, 4};

    public Priest(String p_name) {
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
        int actualDefense = enemy.isGuarding() ? enemy.getMagicDefenseStat() * 2 : enemy.getMagicDefenseStat();
        int damage = (int) (100 * ((double) magicStat/ (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }

    @Override
    public String getClassName() {
        return "Priest";
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

>>>>>>> 3415fa1 (add-priest)
