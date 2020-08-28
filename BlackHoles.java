//Name of the Game: Black Holes and Wormholes
//Author: Anudeep Das
//Purpose: An educational game to teach people about Black holes
//Pictures:
// spacepic:  �Galaxy on Fire 2 HD.� Accessed June 14, 2016. http://opiumpulses.com/store/106/galaxy-on-fire-2-hd.
//10.gif: Cain, Fraser. �How Do You Kill a Black Hole?� March 4, 2014. Accessed June 14, 2016. http://www.universetoday.com/109994/how-do-you-kill-a-black-hole/.
//1 to 4.gif and 6 to 8.gif: United NationsOffice for Outer Space Affairs. A History of Space. Accessed June 06, 2016. http://www.unoosa.org/oosa/en/timeline/index.html.
//5.gif: Illumination Of The Solar Gates. In5D Esoteric Metaphysical and Spiritual Database. 2015. Accessed June 06, 2016. http://in5d.com/illumination-of-the-solar-gates/.

//dice photos: Schropp, Landon and David Walsh. �7 Essential JavaScript Functions.� November 8, 2012. Accessed June 14, 2016. https://davidwalsh.name/flexbox-dice.
// card photos (0-6.jpg): �Bicycle Rider Back - Playing Cards Wiki.� April 7, 2012. Accessed June 14, 2016. http://playingcards.wikidot.com/bicycle:rider-back.

//33.gif in concentration: Inc, CBS Interactive. �Dying Star Screams as It Falls into Black Hole.� August 7, 2012. Accessed June 14, 2016. https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=&url=http%3A%2F%2Fwww.cbsnews.com%2Fnews%2Fdying-star-screams-as-it-falls-into-black-hole%2F&bvm=bv.124272578,d.amc&psig=AFQjCNFOxlzOMDpC-ZLUMf6ABHImnD85Fw&ust=1466028182865680.
// 32.gif: Wikipedia. Wikimedia Foundation, 2016. s.v �Black hole.� Accessed June 14, 2016. https://en.wikipedia.org/wiki/Black_hole.

//earth.jpg: Hamilton, Calvin J. �Earth Introduction.� 1995. Accessed June 14, 2016. http://solarviews.com/eng/earth.htm.


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class BlackHoles extends Applet implements ActionListener
{
  Panel p_card;
  CardLayout cdlayout = new CardLayout();
  Panel p1,p2,p3,p4,p5,p6;
  int grid[][]={{1, 10, 10, 5, 2}, {2, 1, 5, 10, 5}, {10, 8, 10, 6, 10}, {10, 12, 10, 2, 3}, {10, 6, 10, 5, 2}};
  String []facts = {"Did you know that the middle of a blackhole is called a signularity?", "The graviational pull of a blackhole is so strong that even light cannot escape!", "There is a giant blackhole in the centre of our Universe.",
    "If the Earth were to shrink into a blackhole, it would be the size of a nickel.", "A blackhole that sucks stars is called a quasar.", "The nearest blackhole is 20,000 light years away.", "Wormholes ae \"theoretical\" meaning they could exist, but none have ever been made or detected."};
  
  String [] f2= {"The side of a blackhole is called an event horizon.", "The centre of  a blackhole is called a singularity", "The stuff coming out of a blackhole is Hawking radiation"};
  
  int row=5; //for the dimensions � both row and col are the same. 
  JLabel f;
  JLabel b []; 
  JLabel dice;
  int dinum; 
  int play;
  int playrow=0;
  int playcol=0;
  int concen[] [] = {{1,2,3}, {2,3,1}};
  int player [] = new int[2];    //this will hold the player's moves
  Panel board = new Panel (new GridLayout(5,5));                      //game board
  int numholder=0;
  int played;      // this will indicate when the computer will start matching
  JButton c[];
  int minig=0;
  JLabel status;
  int num=0;         //forthe concentration
  int bpres = 0;
  
  int ilevel=4;  //for levelling
  int clevel=1;
  int sub=3;
  
  
  
  JLabel imp;  
    
  int[] izer={0,2,2,2};           //this will tell us how many of each card is occuring for the concentration game
  int w=0;
  
  
  int worm=0;
  
  int cant; //this will come in in minigame

  
  

  
  public void init()
  {
    minig=0;
    resize(1280, 720);
    setBackground(new Color (58,93,117));
    p_card=new Panel();
    p_card.setLayout(cdlayout);
    p_card.setPreferredSize(new Dimension(1280,720));
    screen1();
    screen2();
    screen3();
    screen4();
    screen5();
    screen6();
    
    add("Center", p_card);
    
  }
  
  
  
  
  public void screen1()
  {
    minig=0;
    //This is the splash screen
    //There are buttons that lead to the game and instructions
    p1= new Panel();
    p1.setPreferredSize(new Dimension(1280,720));
    JLabel title = new JLabel ("                                                           Black holes and Wormholes                                                       ");
    title.setFont(new Font("Papyrus", Font.BOLD, 40));
    title.setForeground(Color.white);
    
    
    p1.add(title);
    JRadioButton instr1 = new JRadioButton ("Instructions");
    instr1.setFont(new Font("Papyrus", Font.BOLD, 20));
    instr1.setPreferredSize(new Dimension(150,100));
    instr1.addActionListener(this);
    instr1.setActionCommand("3");
    instr1.setBackground(new Color(211,192,163));
    instr1.setForeground(Color.white);
    p1.add(instr1);
    JLabel back = new JLabel (createImageIcon("spacepic.gif"));
    
    p1.add(back);
    
    JRadioButton play = new JRadioButton ("Play");
    play.setPreferredSize(new Dimension(100,100));
    play.setFont(new Font("Papyrus", Font.BOLD, 20));
    play.setBackground(new Color(26,165,172));
    play.setForeground(Color.white);
    play.addActionListener(this);
    
    play.setActionCommand("2");
    p1.add(play);
    
    
    
    p_card.add("1", p1);
    
  }
  
  
  
  
  public void screen2()
  {
    minig=0;
    //This is the screen that hold the actual game
    p2 = new Panel();
    
    JLabel game = new JLabel ("               Game                                                                    ");
    game.setFont(new Font ("Papyrus", Font.BOLD, 40));
    game.setForeground(Color.white);
    p2.add(game);
    
    status= new JLabel ("");
    
    b=new JLabel[25]; 
    
    replay();
  
    
    
    p2.add(board);
    
    JLabel dir = new JLabel ("Roll your die to move your ship!");
    dir.setFont(new Font("Papyrus", Font.BOLD, 20));
    dir.setForeground(Color.white);
    p2.add(dir);
    
    dice = new JLabel (createImageIcon("1.jpg"));
    JButton roll = new JButton ("Roll");
    roll.setFont(new Font("Papyrus", Font.PLAIN, 20));
    roll.setBackground(new Color(26, 165, 172));
    roll.setForeground(Color.white);
    roll.addActionListener(this);
    roll.setActionCommand("roll");
    

    p2.add(dice);
    p2.add(roll);
    
    f=new JLabel ("                "+facts[0]);
    f.setFont(new Font("Papyrus", Font.PLAIN, 20));
    f.setForeground(Color.white);
    p2.add(f);
    
    
    p_card.add("2", p2);
  }
  
  
  
  
  public void screen3()
  {
    minig=0;
    //This screen holds the instructions
    p3= new Panel();
    JLabel title2 = new JLabel ("Instructions      ");
    JLabel pic = new JLabel (createImageIcon("snakes.jpg"));
    p3.add("left",pic);
    title2.setFont( new Font ("Papyrus", Font.BOLD, 40));
    title2.setForeground(Color.white);
    p3.add(title2);
    
    JLabel pic2 = new JLabel (createImageIcon("scrn.gif"));
    p3.add(pic2);
    
;
    JLabel s1= new JLabel ("");
    p3.add(s1);
    Panel text = new Panel (new GridLayout(8,1));
    JLabel first = new JLabel("You are an astronaut and you are returning to Earth from a space exploration. However, the journey home is not going to be easy!" );
    text.add(first);
    first.setForeground(Color.white);
    first.setFont(new Font("Arial", Font.PLAIN, 16));
    
    
    

    JLabel second=new JLabel("In this game, based off of Snakes and Ladders, you must make it to the end of your game board safely." );
    second.setForeground(Color.white);
    second.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(second);
    
    JLabel third=new JLabel("You can move your spaceship across the board by rolling the dice, and the computer will move your piece for you. However, watch out for the black hole!" );
    third.setForeground(Color.white);
    third.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(third);
    
    JLabel fourth=new JLabel("If you land on one of those, you will be transported to another screen where you must successfully play a minigame before you can return; these are like the snakes in Snakes and Ladders. ");
    fourth.setForeground(Color.white);
    fourth.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(fourth);
    
    JLabel fifth=new JLabel("When you return from a black hole, the gameboard will become more difficult as there will be more black holes introduced.");
    fifth.setForeground(Color.white);
    fifth.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(fifth);
    
    JLabel sixth=new JLabel("");
    text.add(sixth);
    
    JLabel seven=new JLabel("However, if you land on the mouth of a wormhole, you will be transported through space, closer to the end of the board; these are like the ladders in Snakes and Ladders." );
    seven.setForeground(Color.white);
    seven.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(seven);

    JLabel eight=new JLabel("Hope you have fun and learn a little more about some of the coolest objects in space!                                                                                                                 ");
    eight.setForeground(Color.white);
    eight.setFont(new Font("Arial", Font.PLAIN, 16));
    text.add(eight);
    
    p3.add("center",text);
    
    
    
    JButton back = new JButton ("Back");
    back.setBackground(new Color(211,192,163));
    back.setForeground(Color.white);
    back.setFont(new Font("Papyrus", Font.PLAIN, 20));
    back.addActionListener(this);
    back.setActionCommand("1");
    p3.add(back);
    
    p_card.add("3",p3);
  }
  
  
  
  
   public void screen4()
  {
     minig=1;
    //this screen contains a minigame
    p4=new Panel();
    JLabel mini = new JLabel ("                                                                                    Minigame                                                                                                                                    ");
    mini.setFont (new Font ("Papyrus", Font.PLAIN, 38));
    mini.setForeground(Color.white);
    p4.add(mini);
    
    Panel cards = new Panel (new GridLayout(2,3));
    c =new JButton [6];
    
    int car=0;
    cant=0;
    for (int i=0; i<2; i++)
    {
      for (int j=0; j<3; j++)
      {
        c[car]=new JButton (createImageIcon("0.gif"));
        c[car].addActionListener(this);
        c[car].setActionCommand(""+(30+car));
        cards.add(c[car]);
        car++;
      }
    }
      
    p4.add(cards);
    
    JButton instr2= new JButton ("Instructions");
    instr2.setFont(new Font("Papyrus", Font.PLAIN, 20));
    instr2.setBackground(new Color (137, 155, 163));
    instr2.setForeground(Color.white);
    instr2.addActionListener(this);
    instr2.setActionCommand("5");
    
    p4.add(instr2);
    p4.add(status);
    
    imp=new JLabel (" ");
    imp.setFont(new Font("Papyrus", Font.PLAIN, 20));
    imp.setForeground(Color.white);
    p4.add(imp);

    
    p_card.add("4",p4);
    minig=1;
  }
  
  
   public void screen5()
  {
     minig=0;
    //Minigame's instructions are here
    p5= new Panel();
    
    JLabel ins = new JLabel ("                                                                                                 Instructions                                                                                                             ");
    ins.setFont(new Font("Papyrus", Font.PLAIN, 40));
    ins.setForeground(Color.white);
    p5.add(ins);
    JLabel p = new JLabel (createImageIcon("eg.gif"));
    p5.add(p);
    
    
    Panel in = new Panel(new GridLayout(4,1));
    
    JLabel t1= new JLabel (" In this game you have to match identical picture of black holes by clicking the cards.");
    t1.setForeground(Color.white);
    t1.setFont(new Font ("Arial",Font.PLAIN, 15));
    in.add(t1);
    
    JLabel t2=new JLabel("   Once you click a card, a picture of a black hole will appear on it with a label on it. ");
    t2.setFont(new Font("Arial", Font.PLAIN, 15));
    t2.setForeground(Color.white);
    in.add(t2);
    
    JLabel t3=new JLabel("   You will have to find the same picture with the same label. ");
    t3.setFont(new Font("Arial", Font.PLAIN, 15));
    t3.setForeground(Color.white);
    in.add(t3);
    
    JLabel t4= new JLabel("  Once you have matched all of the cards, you will have won. ");
    t4.setFont(new Font("Arial", Font.PLAIN, 15));
    t4.setForeground(Color.white);
    in.add(t4);
    
    p5.add(in);
    
    JButton backer = new JButton ("Back");
    backer.setFont(new Font("Papyrus", Font.PLAIN, 20));
    backer.setBackground(new Color(211, 192, 163));
    backer.setForeground(Color.white);
    backer.addActionListener(this);
    backer.setActionCommand("4");
    p5.add(backer);
    
    p_card.add("5",p5);
  }  
   
   
   
   public void screen6()
   {
     p6= new Panel();
     
     JLabel won = new JLabel ("You won!");
     won.setFont(new Font("Papyrus", Font.BOLD, 60));
     won.setForeground(Color.white);
     p6.add(won);
     
     
     JLabel v = new JLabel (createImageIcon("earth.jpg"));
     p6.add(v);
     
     JButton ba=new JButton ("Play Again");
     ba.setFont(new Font("Papyrus", Font.PLAIN, 20));
     ba.setForeground(Color.white);
     ba.setBackground(new Color(26, 165, 172));
     ba.addActionListener(this);
     ba.setActionCommand("1");
     p6.add(ba);
     
    
     
     
     
     
     p_card.add("6", p6);
   }
  
    
   
   
  
  public void actionPerformed (ActionEvent e)
  {
    if (cant==2)
    {
      cant=0;
      reseter();
    }
    
    if (w==1)
      replay(); 
    
    if (e.getActionCommand().equals("roll"))
        roller();
    else 
    {
      num=Integer.parseInt(e.getActionCommand());
      if (num<30)
        cdlayout.show(p_card, e.getActionCommand());
      else      //if it is more than 30, it means that the card game is being placed and certain conditions must pass through
      {
        num=Integer.parseInt(e.getActionCommand());
       carding(num); 
       played++;
       if (played==3)
         played=0;
      }

      }
  }
       
       
   


  public void carding(int num)
  {
    //this is the logic behind the minigame
                        
       c[num-30].setIcon(createImageIcon(""+(concen[(num-30)/3][(num-30)%3]+30)+".gif"));
       if (played==0)
       {
         played=1;                   //this means that there was a card that was played
         numholder=num;             // that card's index was stored
         bpres=num-30;
       }
       
       
       
       player[played-1]=concen[(num-30)/3][(num-30)%3];        //added to an array is the value of the player's card
       
       if (played==2)                           //there has been another addition to the previous array
       {
         if (player[played-2]!=player[played-1])               //if the two cards don't match   
         {
           c[numholder-30].setIcon(createImageIcon("0.gif"));
           c[num-30].setIcon(createImageIcon("0.gif"));
           
         }
         
         else if (bpres==num-30)  //ensures the user does not click the same button twice
         {
           c[numholder-30].setIcon(createImageIcon("0.gif"));
           played=0;
           JOptionPane.showMessageDialog (null, "You cannot click the same card twice", "Illegal",
                                          JOptionPane.ERROR_MESSAGE);           //make this into a MESSAGE
         }
       
         
         else 
         {
           c[numholder-30].setEnabled(false);        //when there is a match, the buttons are disabled
           c[num-30].setEnabled(false);
           if (concen[(num-30)/3][(num-30)%3]==1)
             imp.setText(f2[0]);
           else if (concen[(num-30)/3][(num-30)%3]==2)
             imp.setText(f2[1]);
           else
             imp.setText(f2[2]);
             
           for (int i=0; i<player.length; i++)
             player[i]=0;
           verif();
         }
       }
  }


  
  public void roller()
  {
    //rolling the dice and executing different activities depending on it
    try{
    int r = (int)(Math.random()*6)+0;
    f.setText("                                                     "+facts[r]);
    dinum = (int) (Math.random()*6)+1;
        dice.setIcon(createImageIcon(""+dinum+".jpg"));           //rolls the dice and does a swap-ish function where the player's ship goes to the new location based on the dice and the old location picture is replaced using the array
        b[play-dinum].setIcon(createImageIcon("g1.gif"));
    }
    
    catch (ArrayIndexOutOfBoundsException a)  // if there is not enough dice roll to reach the end of the game
    {
      JOptionPane.showMessageDialog (null, "Roll a different number.", "Information",
                                           JOptionPane.ERROR_MESSAGE);
    }
        
       
        
        
        int level=(play-dinum)/5;
        
        if (level!=ilevel)
        {
          ilevel=level;
          clevel++;
          JOptionPane.showMessageDialog (null, "You are now on level "+clevel, "Information",  //displays level
                                           JOptionPane.ERROR_MESSAGE);
        }
        
        while (grid[(play-dinum)/5][(play-dinum)%5]==10 || grid[(play-dinum)/5][(play-dinum)%5]==5)  //handles black hole and wormholes
        {
          if (grid[(play-dinum)/5][(play-dinum)%5]==10)
          {
            JOptionPane.showMessageDialog (null, "You landed on a blackhole", "Information",
                                           JOptionPane.ERROR_MESSAGE);
            cdlayout.show(p_card,"4");
            break;
          }
          else if (grid[(play-dinum)/5][(play-dinum)%5]==5)
          {
            worm=1;
            JOptionPane.showMessageDialog (null, "You landed on a wormhole. You have moved 3 squares ahead", "Information",
                                           JOptionPane.ERROR_MESSAGE);
            b[play-dinum-3].setIcon(createImageIcon("g1.gif")); 
            b[play-dinum].setIcon(createImageIcon(""+grid[(play-dinum)/5][(play-dinum)%5]+".gif"));  //playcol for the second one
            play-=3;
            b[play+3].setIcon(createImageIcon(""+grid[(play+3)/5][(play+3)%5]+".gif"));
            playrow=(play-dinum-3)/5;
            playcol=(play-dinum-3)%5;
            if (play-dinum-3==0)
            {
              level=4;
              ilevel=4;
              clevel=1;
              w=1;
              cdlayout.show(p_card, "6");
            }
          }
        }
        
        if (play-dinum==0)  //if the game is over, levels are reset
        {
          level=4;
          ilevel=4;
          clevel=1;
          w=1;
          cdlayout.show(p_card, "6");
        }
       
  
        b[play].setIcon(createImageIcon(""+grid[play/5][play%5]+".gif"));
       
        if (worm==1)
        {
          worm=0;
        }
        
        play-=dinum;
  }
  
  
  public void replay()  //snakes and ladders is reset
  {
    int m=0;
    
    for(int i=0; i<row; i++)
    { 
      for (int j=0; j<row; j++)
      { 
        if ((j==row-1) && (i==row-1))
        {
          if (w==0)
            b[m]=new JLabel (createImageIcon("g1.gif"));
          else
            b[m].setIcon(createImageIcon("g1.gif"));
          
          play=m;
          playrow=i;
          playcol=j;
        }
        else
        {
         if (w==0) 
           b[m] = new JLabel (createImageIcon(grid[i][j]+".gif"));
         else
           b[m].setIcon(createImageIcon(grid[i][j]+".gif"));
        }
        
        if (w==0)
          board.add(b[m]);
        
        m++;
      }
    } 
    w=0;
  }
    
    
    
  
   public void verif()  //checking if the minigame has been answered correctly
  {
    for (int j=0; j<c.length; j++)
   {
             if (c[j].isEnabled())
             {
               cant=1;
               break;
             }
         
             if (j==c.length-1)
               cant=2;
           }
           if (cant==2)
           {
             cdlayout.show(p_card, "2");
           }
         
  }
   
   public void reseter()   //resets the minigame
   {
     int rand = (int) (Math.random()*5)+0;
     int ran=rand;
     int k=0;
     int tracker[]={0,0,0,0,0,0};
     int rej=0;
     for (int h=0; h<c.length; h++)   //resests
         {
           c[h].setIcon(createImageIcon("0.gif"));
           c[h].setEnabled(true);
         }
         
         for (int r=0; r<izer.length; r++)
         {
           k=izer[r];
           while(k>0)                    //random generation of the approriate number of images
           {
             concen[rand/3][rand%3]=r;
             k--;
             tracker[rand]++;
             for (int y=0; y<tracker.length; y++)
             if (tracker[rand]>=1)
             {
               rand++;
               if (rand==tracker.length)
                 rand=0;
             }
           }
         
        
           }
         }
   
  
      
  
  
  protected static ImageIcon createImageIcon (String path)
  {
    java.net.URL imgURL = BlackHoles.class.getResource (path);
    if (imgURL != null)
    {
      return new ImageIcon (imgURL);
    }
    else
    {
      System.err.println ("Couldn't find file: " + path);
      return null;
    }
   }
}
  
    