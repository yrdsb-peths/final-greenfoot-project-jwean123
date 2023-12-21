import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author Juan
 * @version December 2023
 */
public class Guy extends Actor
{
    int speed = 5;
    int vSpeed = 3;
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage("Drawing.png");
        guyImage.scale(30, 30);
        setImage(guyImage);
    }
    
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fall();
        moveKeys();
    }
    
    public void moveKeys()
    {
        MyWorld world = (MyWorld) getWorld();
        
        if(Greenfoot.isKeyDown("A"))
        {
            move(-speed);
        }
        if(Greenfoot.isKeyDown("D"))
        {
            move(speed);
        }
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
    }
}
