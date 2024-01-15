import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author Juan
 * @version December 2023
 */
public class Guy extends Actor
{
    Actor floor;
    
    int speed = 5;
    int vSpeed = 0;
    int jumpHeight = 60;
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage(40, 40);
        guyImage.setColor(Color.GREEN);
        guyImage.drawOval(0, 0, 40, 40);
        guyImage.fillOval(0, 0, 40, 40);
        this.setImage(guyImage);
    }
    
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fall();
        jump();
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
    
    public boolean isGrounded()
    {
        floor = getOneObjectAtOffset(0, 0, Floor.class);
        return floor != null;
    }
    
    public void fall()
    {
        if(isGrounded())
        {
            setLocation(getX(), floor.getY());
            vSpeed = 0;
        }
        else
        {
            setLocation(getX(), getY() + vSpeed);
            vSpeed++;
        }
    }
    
    public void jump()
    {
        if(isGrounded())
        {
            jumpHeight = 30;
        }
        if(isGrounded() && Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY() - jumpHeight);
        }
    }
}
