import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Bullet extends Actor
{
    public Bullet()
    {
        GreenfootImage bulletImage = new GreenfootImage("black square.png");
        bulletImage.scale(15, 5);
        this.setImage(bulletImage);
    }
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
