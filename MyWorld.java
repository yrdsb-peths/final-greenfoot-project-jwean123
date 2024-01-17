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
    Gun gun;
    
    static final int floorWidth = 200;
    static final int floorHeight = 20;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1300, 900, 1);
        guy = new Guy();
        addObject(guy, getWidth() / 2, getHeight() - 50);
        
        gun = new Gun();
        addObject(gun, guy.getX(), guy.getY());
        
        
        
        //Making tiles
        for(int i = 0; i < 4; i++)
        {
            //middle tiles
            makeFloor(floorWidth, floorHeight, getWidth() / 2, getHeight() - 200 - (200 * i));
            //left and right tiles
            makeFloor(floorWidth, floorHeight, getWidth() / 3, getHeight() - 100 - (200 * i));
            makeFloor(floorWidth, floorHeight, getWidth() / 3 * 2, getHeight() - 100 - (200 * i));
        }
        
    }
    
    public void makeFloor(int width, int height, int x, int y)
    {
        floor = new Floor(width, height);
        addObject(floor, x, y);
    }
}
