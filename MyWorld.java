import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Juan
 * @version January 2024
 */
public class MyWorld extends World
{
    private boolean gameOver = false;
    
    /**
     * Changing Variables (that worsen as the game continues)
     */
    
    int zombieSpeed = 5;
    private int spawnTime = 5000; //Milliseconds
    SimpleTimer spawnTimer = new SimpleTimer();
    
    int spawnAmount = 4; //Maximum amount of zombies that can spawn at once
    
    Guy guy;
    Floor floor;
    Gun gun;
    Zombie zombie;
    
    private int score = 0;
    private int oldScore = score;
    Label scoreLabel;
    
    private int life = 100;
    Label lifeLabel;
    
    static private final int floorWidth = 200;
    static private final int floorHeight = 20;
    
    GreenfootSound yowch = new GreenfootSound("uhuHUHweepow.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1500, 900, 1);
        
        //making guy to play as
        guy = new Guy();
        addObject(guy, getWidth() / 2, getHeight() - 50);
        
        //your Guy's gun model
        gun = new Gun();
        addObject(gun, guy.getX() - guy.getImage().getWidth() / 2, guy.getY());
        
        //Labels
        scoreLabel = new Label("score: " + score, 30);
        addObject(scoreLabel, scoreLabel.getImage().getWidth(), 40);
        
        lifeLabel = new Label("life: " + life, 30);
        addObject(lifeLabel, getWidth() - scoreLabel.getImage().getWidth(), 40);
        
        //Making tiles
        for(int i = 0; i < 4; i++)
        {
            //middle tiles
            makeFloor(floorWidth, floorHeight, getWidth() / 2, getHeight() - 200 - (200 * i));
            //left and right tiles
            makeFloor(floorWidth, floorHeight, getWidth() / 3, getHeight() - 100 - (200 * i));
            makeFloor(floorWidth, floorHeight, getWidth() / 3 * 2, getHeight() - 100 - (200 * i));
        }
        
        spawnTimer.mark();
        makeZombie(2);
    }
    
    public void makeFloor(int width, int height, int x, int y)
    {
        floor = new Floor(width, height);
        addObject(floor, x, y);
    }
    
    public void makeZombie(int amount)
    {
        for(int i = 0; i < amount; i++)
        {
            zombie = new Zombie();
            addObject(zombie, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("score: " + score);
    }
    
    public void increaseIntensity()
    {
        zombieSpeed+=2;
        spawnTime -= 150;
        spawnAmount += 2;
    }
    
    public void act()
    {
        //Allows user to exit to titlescreen whenever they want
        TitleScreen titleScreen = new TitleScreen();
        if(Greenfoot.isKeyDown("F"))
        {
            Greenfoot.setWorld(titleScreen);
        }
        
        if(guy.getLife() == 0)
        {
           gameOver = true; 
        }
        lifeLabel.setValue("life: " + guy.getLife());
        if(spawnTimer.millisElapsed() < spawnTime)
        {
            return;
        }
        else
        {
            spawnTimer.mark();
            makeZombie(Greenfoot.getRandomNumber(spawnAmount));
        }
        
        if(oldScore + 15 == score)
        {
            oldScore = score;
            increaseIntensity();
        }
    }
    
    public void gameEnded()
    {
        
        if(gameOver = true)
        {
            Label endLabel = new Label("Game Over \n Nice Try!! \n [F] to quit", 40);
            addObject(endLabel, getWidth() / 2, getHeight() / 2);
            yowch.play();
        }
    }
}
