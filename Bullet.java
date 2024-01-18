import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Bullet extends SmoothMover
{
    MouseInfo mouse;
    Guy guy;
    int speed = 40;
    
    public Bullet()
    {
        GreenfootImage bulletImage = new GreenfootImage(15, 7);
        bulletImage.fill();
        this.setImage(bulletImage);
    }
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        move(speed);
        
        //check for zombies and platforms
        if(isTouching(Floor.class))
        {
            getWorld().removeObject(this);
        }    
        //check for world edges
        else if(getX() < getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
        else if(getX() > getWorld().getWidth() - getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
        else if(getY() < getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
        else if(getY() > getWorld().getHeight() - getImage().getHeight() / 2)
        {
            getWorld().removeObject(this);
        }
    }
}
