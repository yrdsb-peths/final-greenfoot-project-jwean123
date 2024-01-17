import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author Juan 
 * @version January 2024
 */
public class Gun extends Actor
{
    Guy guy;
    GreenfootImage gunImage1;
    GreenfootImage gunImage2;
    
    public Gun()
    {
        gunImage1 = new GreenfootImage("gun1.png");
        gunImage1.scale(80, 20);
        this.setImage(gunImage1);
        
        gunImage2 = new GreenfootImage("gun2.png");
        gunImage2.scale(80, 20);
    }
    
    /**
     * Act - do whatever the gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Follow guy
        guy = (Guy)getWorld().getObjects(Guy.class).get(0);
        setLocation(guy.getX(), guy.getY());
        
        //Point in cursor direction
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            turnTowards(mouse.getX(), mouse.getY());
        }
        
        //Stay upright
        if(this.getRotation() >= 90 && this.getRotation() < 270)
        {
            this.setImage(gunImage2);
        }
        else
        {
            this.setImage(gunImage1);
        }
    }
}
