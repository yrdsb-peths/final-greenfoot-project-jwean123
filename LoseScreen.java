import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{
    Label lossLabel;
    SadGuy sadGuy;
    /**
     * Constructor for objects of class LoseScreen.
     * 
     */
    public LoseScreen()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        lossLabel = new Label("You lost, but it's okay \n Press [E] to get right back in, \n or [F] to go back to the titlescreen", getWidth() / 20);
        addObject(lossLabel, getWidth() / 2, getHeight() / 2);
        
        sadGuy = new SadGuy();
        addObject(sadGuy, sadGuy.getImage().getWidth() / 2, sadGuy.getImage().getHeight() / 2);
    }
    
    public void act()
    {
        TitleScreen titleScreen = new TitleScreen();
        MyWorld world = new MyWorld();
        if(Greenfoot.isKeyDown("E"))
        {
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.isKeyDown("F"))
        {
            Greenfoot.setWorld(titleScreen);
        }
    }
}
