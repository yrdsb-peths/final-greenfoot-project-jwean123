import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Juan
 * @version January 2024
 */
public class MyWorld extends World
{
    Guy guy;
    Floor floor;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1200, 900, 1);
        guy = new Guy();
        addObject(guy, getWidth() / 2, getHeight() - 50);
        
        //First floor
        makeFloor(200, 10, getWidth() / 3, getHeight() - 100);
        makeFloor(200, 10, getWidth() / 3 * 2, getHeight() - 100);
        //Second floor
        makeFloor(200, 10, getWidth() / 2, getHeight() - 200);
        //Third floor
        makeFloor(200, 10, getWidth() / 3, getHeight() - 300);
        makeFloor(200, 10, getWidth() / 3 * 2, getHeight() - 300);
        //Fourth floor
        makeFloor(200, 10, getWidth() / 2, getHeight() - 400);
        //Fifth floor
        makeFloor(200, 10, getWidth() / 3, getHeight() - 500);
        makeFloor(200, 10, getWidth() / 3 * 2, getHeight() - 500);
        //Sixth floor
        makeFloor(200, 10, getWidth() / 2, getHeight() - 600);
    }
    
    public void makeFloor(int width, int height, int x, int y)
    {
        floor = new Floor(width, height);
        addObject(floor, x, y);
    }
}
