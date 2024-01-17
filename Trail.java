import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class trail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trail extends Actor
{
    GreenfootImage trailImage[] = new GreenfootImage[5];
    
    public Trail()
    {
        for(int i = 0; i < trailImage.length; i++)
        {
            trailImage[i] = new GreenfootImage("trail" + i + ".png");
            trailImage[i].scale(15, 7);
        }
    }
    
    /**
     * Act - do whatever the trail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
