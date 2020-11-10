/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sogeking
 */
public class Party {
    protected List<Warrior> characters;
    
    public Party(int formation) {
        characters = new ArrayList();
        
        switch (formation) {
            case 0:
                characters.add(new Warrior("Wigfried", 70, 10, 10));
                characters.add(new Warrior("Gonzague", 80, 8, 12));
                characters.add(new Warrior("Enguerrand", 50, 15, 15));
                characters.add(new Warrior("Norbert", 100, 5, 13));
                break;
            case 1:
                characters.add(new Warrior("Jean-Bâtard", 50, 10, 10));
                characters.add(new Warrior("Jean-Craqué", 200, 200, 15));
                break;
        }
    }
    
    public List<Warrior> getCharacters() {
        return characters;
    }
    
    public Warrior getCharacter(int index) {
        return characters.get(index);
    }
    
    public Warrior getAliveCharacter(int index) {
        return getAliveCharacters().get(index);        
    }
    
    public List<Warrior> getAliveCharacters() {
        List<Warrior> aliveCharacters = new ArrayList();
        for (Warrior character : characters) {
            if (character.isAlive()) {
                aliveCharacters.add(character);
            }
        }
        return aliveCharacters;
    }
    
    public int getAliveCharactersSize() {
        return getAliveCharacters().size();
    }

    boolean areAllDead() {
        return getAliveCharactersSize() == 0;
    }
}
