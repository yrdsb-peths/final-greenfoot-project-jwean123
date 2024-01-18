import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Juan
 * @version January 2024
 */
public class TitleScreen extends World
{
    Label mainLabel;
    Label rulesLabel;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        mainLabel = new Label("Welcome to the original zombie shooter!\n Press [E] to start and \n [F] to end game whenever", getWidth() / 16);
        addObject(mainLabel, getWidth() / 2, (getHeight() / 2) - mainLabel.getImage().getHeight());
        
        rulesLabel = new Label("A and D to move, space to jump \n Mouse to aim and Left Click to shoot \n \n It gets harder the longer you survive \n Good luck...", getWidth() / 20);
        addObject(rulesLabel, getWidth() / 2, (getHeight() / 2) + 70);
    }
    
    public void act()
    {
        MyWorld world = new MyWorld();
        if(Greenfoot.isKeyDown("E"))
        {
            Greenfoot.setWorld(world);
        }
    }
}
