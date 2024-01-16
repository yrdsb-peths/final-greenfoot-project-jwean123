import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Guy extends Actor
{
    Actor gun;
    
    Actor floor;
    static final int gravity = 2;
    static final int jumpForce = 25;
    
    int walkSpeed = 5;
    int ySpeed = 0;
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage("green guy.png");
        guyImage.scale(40, 40);
        this.setImage(guyImage);
        
    }
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        moveHorizontally();
        moveVertically();
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
        setLocation(getX() + dx * walkSpeed, getY());
        
        //world border check
        if(getX() < myWidth / 2)
        {
            setLocation(myWidth / 2, getY());
        }
        if(getX() > getWorld().getWidth() - myWidth / 2)
        {
            setLocation(getWorld().getWidth() - myWidth / 2, getY());
        }
    }
    
    public void moveVertically()
    {
        int myHeight = getImage().getHeight();
        int dy;
        boolean isGrounded = false;
        
        //falling
        ySpeed += gravity;
        setLocation(getX(), getY() + ySpeed);
        
        //check for world edge
        if(getY() > getWorld().getHeight() - myHeight / 2)
        {
            setLocation(getX(), getWorld().getHeight() - myHeight / 2);
            ySpeed = 0;
            isGrounded = true;
        }
        
        //check for obstacles / floor
        dy = (int) Math.signum(ySpeed); //direction of movement
        while(getOneIntersectingObject(null) != null)
        {
            setLocation(getX(), getY() - dy);
            if(dy > 0)
            {
                isGrounded = true;
                ySpeed = 0;
            }
        }
        
        //jumping functionality
        if(isGrounded && Greenfoot.isKeyDown("space"))
        {
            ySpeed -= jumpForce;
        }
    }
}
