/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */
package life.myLife;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class LifeRock extends Rock
{
    final static Color colorAlive = Color.RED;
    final static Color colorDead = Color.WHITE;
    int phase;
    int numNeighbors;

    /**
     * Constructs a LifeRock for the Lige Game.
     * param phase innitialized
     */
    public LifeRock()
    {
        super();
        phase = 1;
        setDead();
    }

    /**
     * Returns true if the Rock is alive.
     * This method used as static for neighbours of the current actor
     */
    public static boolean isAlive(Actor actor){

        return actor.getColor() == colorAlive;
    }

    /**
     * Check what phase we?re in and calls the appropriate method.
     * Moves to the next phase.
     * Updates current status and the sets @param phase back to 1.
     */
    public void act() {

        if (phase == 1) {
            numNeighbors = countLiveNeighbors();
            phase = 2;
        } else {
            updateStatus(numNeighbors);
            phase = 1;
        }
    }

    /**
     * Overloaded method for current actor
     */
    public boolean isAlive(){

        return this.getColor() == colorAlive;
    }


    /**
     * Makes the Rock alive.
     */
    public void setAlive(){
        this.setColor(colorAlive);
    }
    /**
     * Makes the Rock dead.
     */
    public void setDead(){
        this.setColor(colorDead);
    }

    /**
     * Counts the number of live neighbors.
     */
    public int countLiveNeighbors(){
        Location loc = getLocation();
        Grid<Actor> grid = getGrid();
        ArrayList<Actor> neighbors = grid.getNeighbors(loc);
        int counter=0;

        for (Actor actorRock : neighbors)
        {
            if (isAlive(actorRock)) {
                counter++;
            }
        }
        return counter;
    }


    /**
     * Updates the status of the Rock (live or dead) based on
     * the number of neighbors.
     */
    public void updateStatus(int numNeighbors){
        if(isAlive()){
            if(numNeighbors != 2 && numNeighbors != 3){
            setDead();
            }
        } else {
            if(numNeighbors == 3){
                setAlive();
            }
        }
    }
}

