import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author Juan 
 * @version January 2024
 */
public class Gun extends Actor
{
    public Gun()
    {
        GreenfootImage gunImage = new GreenfootImage("black square.png");
        gunImage.scale(20, 10);
        this.setImage(gunImage);
    }
    
    /**
     * Act - do whatever the gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Guy guy = (Guy)getWorld().getObjects(Guy.class).get(0);
        setLocation(guy.getX(), guy.getY() - 45);
    }
}
