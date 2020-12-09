package com.vpoesmann.rpg;

public class Berserker extends Character{
    protected static final int LVL1_MAX_HP = 120;
    protected static final int LVL1_MAX_MANA = 10;

    protected static final int LVL1_ATK_STAT = 8;
    protected static final int LVL1_DEF_STAT = 3;
    protected static final int LVL1_MAG_STAT = 2;
    protected static final int LVL1_MDF_STAT = 2;

    protected static int[] statsLevelUpMin = {10, 1, 4, 1, 0, 0};
    protected static int[] statsLevelUpMax = {14, 2, 6, 2, 1, 1};

    public Berserker(String p_name) {
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

    @Override
    public void attack(Character enemy) {
        int actualDefense = enemy.isGuarding() ? enemy.getDefenseStat() * 2 : enemy.getDefenseStat();
        int damage = (int) (100 * ((double) attackStat / (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }

    @Override
    public String getClassName() {
        return "Berserker";
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