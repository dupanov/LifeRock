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
    final static Color colorDead = Color.BLACK;
    int phase;
    int numNeighbors;

    /**
     * Constructs a LifeRock for the Lige Game.
     * @param phase innitialized
     */
    public LifeRock()
    {

        phase = 1;
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
            updateStatus();
            phase = 1;
        }
    }

    /**
     * Returns true if the Rock is alive.
     * This method used as static for neighbours of the current actor
     */
    public static boolean isAlive(Actor actor){

        return actor.getColor() == colorAlive;
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
       // ArrayList<Location> loc = this.getGrid().getValidAdjacentLocations(this.getLocation());
        // Location loc = this.getLocation().getAdjacentLocation(i * 45);
        for (Actor actor : neighbors)
            if (isAlive(actor)) {
                counter++;
            }
        return counter;
    }



    /**
     * Updates the status of the Rock (live or dead) based on
     * the number of neighbors.
     */
    public void updateStatus(){
        if(isAlive()){
            int members = countLiveNeighbors();
            if(members != 2 && members != 3){
            setDead();
            }
        }
        if(!isAlive()){
            int members = countLiveNeighbors();
            if(members == 3){
                this.setAlive();
            }
        }
    }
}

