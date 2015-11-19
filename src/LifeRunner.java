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

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;


/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class LifeRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        makeRocks(world);
        world.show();
    }

    /**
     * Makes a Game of Life grid with an r-pentomino.
     */
    public static void makeLifeWorld(int rows, int cols){

    }
    /**
     * Fills the grid with LifeRocks.
     */
    public static void makeRocks(ActorWorld world){
        for (int i = 0; i <world.getGrid().getNumCols() ; i++) {
            for (int j = 0; j < world.getGrid().getNumRows(); j++) {
                Location loc = new Location(i, j);
                LifeRock rock = new LifeRock();
                world.add(loc, rock);
                rock.setAlive();
                rock.act();
            }
        }
    }

}
