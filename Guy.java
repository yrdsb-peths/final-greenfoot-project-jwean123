import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class guy here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Guy extends Actor
{
    private int life = 100;
    SimpleTimer dmgTick = new SimpleTimer();
    
    
    MouseInfo mouse;
    
    boolean isGrounded;
    
    Actor gun;
    
    Actor floor;
    static final int gravity = 2;
    static final int jumpForce = 25;
    
    int walkSpeed = 5;
    int ySpeed = 0;
    
    int dx; //x-axis directional movement
    int dy; //y-axis directional movement
    
    GreenfootSound pew = new GreenfootSound("PewPewPew.mp3");
    
    public Guy()
    {
        GreenfootImage guyImage = new GreenfootImage("green guy.png");
        guyImage.scale(30, 30);
        this.setImage(guyImage);
        dmgTick.mark();
    }
    /**
     * Act - do whatever the guy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        moveHorizontally();
        moveVertically();
        shooting();
    }
    
    
    public void moveHorizontally()
    {
        int myWidth = getImage().getWidth();
        dx = 0; //for the direction of movement
        
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
        isGrounded = false;
        
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
        
        /*
         * Floor collision!!
         */
        dy = (int) Math.signum(ySpeed); //whether you fall or go up
        while(isTouching(Floor.class))
        {
            setLocation(getX(), getY() - dy);
            if(dy > 0)
            {
                ySpeed = 0;
                isGrounded = true;
            }
        }
        
        
        //jumping functionality
        if(isGrounded && Greenfoot.isKeyDown("space"))
        {
            ySpeed -= jumpForce;
        }
    }
    
    public void shooting()
    {
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            if(Greenfoot.mousePressed(null)) //if left click
            {
                pew.play();
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet, getX(), getY()  - getImage().getHeight() / 2);
                bullet.turnTowards(mouse.getX(), mouse.getY());
            }
        }
    }
    
    public void takeDamage()
    {
        if(dmgTick.millisElapsed() < 2500) //How long before damage can be taken again
        {
            return;
        }
        else
        {
            if(isTouching(Zombie.class))
            {
                life -= 20;
                dmgTick.mark();
            }
        }
    }
    
    public int getLife()
    {
        return life;
    }
}
