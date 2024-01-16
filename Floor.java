import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author Juan 
 * @version January 2024
 */
public class Floor extends Actor
{    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Floor()
    {
        GreenfootImage floorImage = new GreenfootImage("floor.png");
        floorImage.scale(200, 10);
        this.setImage(floorImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
