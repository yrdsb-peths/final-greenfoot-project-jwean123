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
        super(825, 550, 1);
        guy = new Guy();
        addObject(guy, getWidth() / 2, getHeight() / 2);
        
        floor = new Floor();
        addObject(floor, getWidth() / 2, (getHeight() / 2) + 200);
    }
}
