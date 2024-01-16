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
    Hands hands;
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage("green guy.png");
        guyImage.scale(60, 60);
        this.setImage(guyImage);
        
        if(this.getWorld() != null)
        {
            hands = new Hands();
            getWorld().addObject(hands, 100, 100);

        }
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
    
    public void jump()
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
