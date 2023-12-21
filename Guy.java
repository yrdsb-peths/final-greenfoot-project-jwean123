import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guy extends Actor
{
    GreenfootImage guyImage = new GreenfootImage("Drawing.png");
    
    public Guy()
    {
        setImage(guyImage);
    }
    
    
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        if(Greenfoot.isKeyDown("A"))
        {
            move(-world.getSpeed());
        }
        if(Greenfoot.isKeyDown("D"))
        {
            move(world.getSpeed());
        }
    }
}
