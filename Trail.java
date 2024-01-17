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
    SimpleTimer trailTimer = new SimpleTimer();
    SimpleTimer deleteTimer = new SimpleTimer();
    
    public Trail()
    {
        for(int i = 1; i < trailImage.length; i++)
        {
            trailImage[i] = new GreenfootImage("trail" + i + ".png");
            trailImage[i].scale(15, 7);
        }
        
        trailTimer.mark();
        
        //Initial trail image
        setImage(trailImage[3]);
    }
    
    /**
     * Act - do whatever the trail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int imageIndex = 0;
    public void trailing()
    {
        if(deleteTimer.millisElapsed() >= 100)
        {
            getWorld().removeObject(this);
        }
        
        if(trailTimer.millisElapsed() < 70)
        {
            return;
        }
        trailTimer.mark();
        
        this.setImage(trailImage[imageIndex]);
        imageIndex = (imageIndex + 1) % trailImage.length;
        
        if(imageIndex == 5)
        {
            deleteTimer.mark();
        }
    }
    
    public void act()
    {
        trailing();
    }
}
