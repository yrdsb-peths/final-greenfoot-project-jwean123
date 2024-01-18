import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SadGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SadGuy extends Actor
{
    public SadGuy()
    {
        GreenfootImage sadGuyImage = new GreenfootImage("emoticon in tears.png");
        sadGuyImage.scale(150, 150);
        this.setImage(sadGuyImage);
    }
    
    /**
     * Act - do whatever the SadGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
