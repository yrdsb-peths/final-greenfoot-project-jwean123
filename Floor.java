import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    GreenfootImage floorImage = new GreenfootImage("Red_rectangle.svg.png");
    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Floor()
    {
        floorImage.scale(100, 25);
        setImage(floorImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
