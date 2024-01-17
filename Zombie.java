import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author Juan
 * @version January 2024
 */
public class Zombie extends Actor
{
    GreenfootImage rightMoving[] = new GreenfootImage[7];
    GreenfootImage leftMoving[] = new GreenfootImage[7];
    GreenfootImage rightIdle[] = new GreenfootImage[4];
    GreenfootImage leftIdle[] = new GreenfootImage[4];
    
    private boolean facingRight;
    SimpleTimer animationTimer = new SimpleTimer();
    
    
    /**
     * stuff that I copied over from the Guy class
     */
    boolean isGrounded;
    
    Actor floor;
    static final int gravity = 2;
    static final int jumpForce = 25;
    
    int walkSpeed = 7;
    int ySpeed = 0;
    
    int dx; //x-axis directional movement
    int dy; //y-axis directional movement
    
    SimpleTimer actionTimer = new SimpleTimer();
    int actionChoice = 0;
    /**
     * Constructor
     */
    public Zombie()
    {
        for(int i = 0; i < rightMoving.length; i++)
        {
            rightMoving[i] = new GreenfootImage("images/Zombie/moving" + i + "Right.png");
            rightMoving[i].scale(50, 60);
        }
        
        for(int i = 0; i < leftMoving.length; i++)
        {
            leftMoving[i] = new GreenfootImage("images/Zombie/moving" + i + "Left.png");
            leftMoving[i].scale(50,60);
        }
        
        for(int i = 0; i < rightIdle.length; i++)
        {
            rightIdle[i] = new GreenfootImage("images/Zombie/Idle" + i + "Right.png");
            rightIdle[i].scale(50,60);
        }
        
        for(int i = 0; i < leftIdle.length; i++)
        {
            leftIdle[i] = new GreenfootImage("images/Zombie/Idle" + i + "Left.png");
            leftIdle[i].scale(50,60);
        }
        
        animationTimer.mark();
        actionTimer.mark();
        
        //Initial zombie image
        setImage(rightIdle[0]);
        facingRight = true;
    }
    
    /**
     * Animate the zombie
     */
    public void animateZombie()
    {
        
    }
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        newAction();
        moveHorizontally();
        moveVertically();
    }
    
    public void newAction()
    {
        /**
         * Choice 3 is jumping, so I made it so that it'll only jump once rather
         * than continously jump for 5 seconds
         */
        if(actionTimer.millisElapsed() < 500)
        {
            return;
        }
        actionTimer.mark();
        
        actionChoice = Greenfoot.getRandomNumber(4);
    }
    
    public void moveHorizontally()
    {
        int myWidth = getImage().getWidth();
        dx = 0; //for the direction of movement
        
        //choose if moving left or right
        
        if(actionChoice == 1)
        {
            dx--;
        }
        if(actionChoice == 2)
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
        if(isGrounded && actionChoice == 3)
        {
            ySpeed -= jumpForce;
            actionTimer.mark();
        }
    }
}
