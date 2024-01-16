import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Guy extends Actor
{
    Actor floor;
    
    int speed = 5;
    int vSpeed = 0;
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage("green guy.png");
        guyImage.scale(60, 60);
        this.setImage(guyImage);
        
    }
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        fall();
        jumpKey();
        moveHorizontally();
    }
    
    
    public void moveHorizontally()
    {
        int myWidth = getImage().getWidth();
        int dx = 0; //for the direction of movement
        
        //choose if moving left or right
        
        if(Greenfoot.isKeyDown("A"))
        {
            dx--;
        }
        if(Greenfoot.isKeyDown("D"))
        {
            dx++;
        }
        
        //actual movement left and right
        setLocation(getX() + dx * speed, getY());
        
        if(getX() < myWidth / 2)
        {
            setLocation(myWidth / 2, getY());
        }
        if(getX() > getWorld().getWidth() - myWidth / 2)
        {
            setLocation(getWorld().getWidth() - myWidth / 2, getY());
        }
    }
    
    public boolean isGrounded()
    {
        floor = getOneObjectAtOffset(0, 30, Floor.class);
        return floor != null;
    }
    
    public void fall()
    {
        if(isGrounded())
        {
            setLocation(getX(), floor.getY() - 30);
            vSpeed = 0;
        }
        else
        {
            setLocation(getX(), getY() + vSpeed);
            vSpeed++;
        }
    }
    
    public void jumpKey()
    {
        if(isGrounded())
        {
            vSpeed = 0;
        }
        if(isGrounded() && Greenfoot.isKeyDown("W"))
        {
            vSpeed = -30;
            setLocation(getX(), getY() + vSpeed);
            vSpeed += 20;
        }
    }
}
