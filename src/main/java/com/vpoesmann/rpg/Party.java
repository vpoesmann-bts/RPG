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
                characters.add(new Warrior("Wigfried"));
                characters.add(new Warrior("Gonzague"));
                characters.add(new Warrior("Enguerrand"));
                characters.add(new Warrior("Norbert"));
                break;
            case 1:
                characters.add(new Warrior("Jean-Bâtard"));
                characters.add(new Warrior("Jean-Craqué"));
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

    public boolean areAllDead() {
        return getAliveCharactersSize() == 0;
    }
}
