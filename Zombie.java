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
        // Add your action code here.
    }
}
