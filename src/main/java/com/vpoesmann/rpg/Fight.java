/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

import java.util.Scanner;

/**
 *
 * @author sogeking
 */
public class Fight {

    protected Party party;
    protected Party foes;

    protected boolean ended;
    protected boolean hasPartyWon;

    protected static String menuMsg = "Que doit faire # ?\n1-Attaque\n2-Compétence\n3-Objet\n4-Garde";
    protected static String targetMsg = "Sur quelle cible ?";
    protected static String victoryMsg = "Victoire ! GGs boyz";
    protected static String defeatMsg = "Défaite ! L'équipe a été éradiquée, le monde est condamné à la nuit !";

    public Fight() {
        party = new Party(0);
        foes = new Party(1);

        ended = false;
        hasPartyWon = false;
    }

    public void start() {
        while (!ended) {
            playerTurn();
            enemyTurn();
        }
        if (hasPartyWon) {
            System.out.println(victoryMsg);
        } else {
            System.out.println(defeatMsg);
        }
    }

    protected void playerTurn() {
        for (Warrior character : party.getAliveCharacters()) {
            displayFightState();
            playerAction(character);
            checkFightEnded();
            waitForText();

            if (ended) {
                return;
            }
        }
    }

    protected void enemyTurn() {
        for (Warrior enemy : foes.getAliveCharacters()) {
            displayFightState();
            enemyAction(enemy);
            checkFightEnded();
            waitForText();

            if (ended) {
                return;
            }
        }
    }

    protected void playerAction(Warrior character) {
        displayMenuMsg(character.getName());
        int mainAction = pickMainMenuAction();

        Warrior target;
        switch (mainAction) {
            case 1:
                // Attack
                displayTargetMsg();
                target = pickTarget();
                character.attack(target);
                break;
            case 2:
                // TODO : Skill
                break;
            case 3:
                // TODO : Object
                break;
            case 4:
                // Guard
                character.guard();
                break;

        }
    }

    protected int pickMainMenuAction() {
        Scanner in = new Scanner(System.in);

        int result = -1;
        while (result == -1) {
            try {
                String action = in.nextLine();
                int tmp = Integer.parseInt(action);
                if (tmp < 1 || tmp > 4) {
                    throw new NumberFormatException();
                }
                result = tmp;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide");
            }
        }
        return result;
    }

    protected Warrior pickTarget() {
        Scanner in = new Scanner(System.in);

        int result = -1;
        while (result == -1) {
            try {
                String action = in.nextLine();
                int tmp = Integer.parseInt(action);
                if (tmp < 1 || tmp > party.getAliveCharactersSize() + foes.getAliveCharactersSize()) {
                    throw new NumberFormatException();
                }
                result = tmp;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide");
            }
        }

        if (result <= foes.getAliveCharactersSize()) {
            return foes.getAliveCharacter(result - 1);
        } else {
            return party.getAliveCharacter(result - 1 - foes.getAliveCharactersSize());
        }
    }

    private void enemyAction(Warrior enemy) {
        enemy.attack(party.getAliveCharacter(0));
    }

    protected void displayFightState() {
        System.out.println("Personnages : \n");
        for (Warrior character : party.getCharacters()) {
            System.out.println(character.toString());
        }
        System.out.println("\nEnnemis : \n");
        for (Warrior enemy : foes.getCharacters()) {
            System.out.println(enemy.toString());
        }
        System.out.println("");
    }

    protected void displayMenuMsg(String name) {
        System.out.println(menuMsg.replace("#", name));
    }

    protected void displayTargetMsg() {
        System.out.println(targetMsg);
        int index = 1;
        for (Warrior enemy : foes.getAliveCharacters()) {
            System.out.println(index + "- " + enemy.getName());
            index++;
        }
        for (Warrior character : party.getAliveCharacters()) {
            System.out.println(index + "- " + character.getName());
            index++;
        }
    }

    private void checkFightEnded() {
        if (party.areAllDead()) {
            ended = true;
        } else if (foes.areAllDead()) {
            ended = true;
            hasPartyWon = true;
        }
    }

    private void waitForText() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}
