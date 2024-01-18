import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Door extends Actor
{
    SimpleTimer doorCooldown = new SimpleTimer();
    SimpleTimer spawnCooldown = new SimpleTimer();
    SimpleTimer openingTimer = new SimpleTimer();
    
    boolean isOpen;
    
    GreenfootImage doorImage0 = new GreenfootImage("images/Door/door0.png");
    GreenfootImage doorImage1 = new GreenfootImage("images/Door/door1.png");
    GreenfootImage doorImage2 = new GreenfootImage("images/Door/door2.png");
    GreenfootImage doorImage3 = new GreenfootImage("Images/Door/door3.png");
    
    public Door()
    {
        doorImage0.scale(140, 220);
        doorImage1.scale(140, 220);
        doorImage2.scale(140, 220);
        doorImage3.scale(140, 220);
        this.setImage(doorImage0);
        isOpen = false;
        openingTimer.mark();
    }
    
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void openDoor()
    {
        if(!isOpen)
        {
            this.setImage(doorImage1);
            openingTimer.mark();
            if(openingTimer.millisElapsed() >= 100)
            {
                
            }
        }
    }
}
