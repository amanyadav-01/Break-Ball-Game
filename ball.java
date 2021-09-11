
/** @Aman Yadav **/


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class ball extends JPanel implements ActionListener, KeyListener {
	
	Timer tm=new Timer(5, this);
     int x=530, velx=0;     
     int bx=530, by=240, velbx=2, velby=-2;
    int score=0;
   
    
    
    
     public ball()
     {
    	 tm.start();
    	 
    	 addKeyListener(this);
    	 setFocusable(true);
    	 setFocusTraversalKeysEnabled(false);
    	
     }
     
     public void paintComponent(Graphics g)
     {
    	 super.paintComponent(g); 
    	 g.setColor(Color.BLACK);                                    //road 
    	 g.fillRect(0, 0, 1340, 720); 
    	
    	 
    	 g.setColor(Color.green);                                    //road 
    	 g.fillRect(0, 0, 30, 720);
    	 g.setColor(Color.green);                                    //road 
    	 g.fillRect(1330, 0, 40, 720);
    	 g.setColor(Color.green);                                    //road 
    	 g.fillRect(0, 0, 1330, 30);
    	 
    	 
    	 g.setColor(Color.white);                                     //score
    	 g.setFont(new Font("serif",Font.BOLD, 25));                             //mera ho gya
    	 g.drawString("Score: "+score, 620,22);
    	 
    	 g.setColor(Color.red);                                    //road 
    	 g.fillRect(x, 590, 150, 40);
    	 
    	 if(by==572)
    	 {
    		 g.setColor(Color.black); 
        	 g.fillRect(bx,by,60,60);
        	 g.setColor(Color.black); 
        	 g.fillArc(bx,by,60,60,0,360);
    	 }
    	 else
    	 {
    	 g.setColor(Color.black); 
    	 g.fillRect(bx,by,60,60);
    	 g.setColor(Color.yellow); 
    	 g.fillArc(bx,by,60,60,0,360);
    	 }
    	 
    	 
     }
     
     public void actionPerformed(ActionEvent e)
     {
    	 
    	 if(bx==1270&&velbx==2&&velby==2)
    	 {
    		 velbx=-2;   
    		 velby=2;
    	
    	 }
    	 if(bx==1270&&velbx==2&&velby==-2)
    	 {
    		 velbx=-2;   
    		 velby=-2;
    	
    	 }
    	 if(by==30&&velbx==2&&velby==-2)
    	 {
    		 velbx=2;   
    		 velby=2;
    	
    	 }
    	 
    	 if(by==30&&velbx==-2&&velby==-2)
    	 {
    		 velbx=-2;   
    		 velby=2;
    	
    	 }
    	 if(bx==30&&velbx==-2&&velby==2)
    	 {
    		 velbx=2;   
    		 velby=2;
    	
    	 }
    	 if(bx==30&&velbx==-2&&velby==-2)
    	 {
    		 velbx=2;   
    		 velby=-2;
    	
    	 }
    	if(x<30)
    	{
    		x=30;
    		velx=0;
    	}
    	else if(x>1172)
    	{
    		x=1172;
    		velx=0;
    	}
    	
    	

    	
      if(new Rectangle(x, 590, 150, 40).intersects(new Rectangle(bx,by,60,60)) )
      {     
    	  score++;
    	    if(velbx==2&&velby==2)
    	    {   velbx=2;   
   		         velby=-2;
    	    }
    	    else
    	    {
    	    	velbx=-2;   
  		         velby=-2;
    	    }
    	  
      }
      else if(by==572)
       {
           JOptionPane.showMessageDialog(this,"Game Over");
    	   int i = JOptionPane.showConfirmDialog(this,"Do you want to Continue");
         
           if(i==0)
          {
        	   score=0;
        	 	 on();
        
          }
           if(i==1)
           {
         	  System.exit(0);
           }
           else
           {
        	   score=0;
        	     on();
           }  
    	  
      }   
      
      
      
                                           
    	    bx=bx+velbx;                                     //velocity  x axis mycar
    		by=by+velby;	                                    // velocity y axis  mycar
    		x=x+velx;                                     // velocity strip
    		
    	repaint();
     }
     
     public void keyPressed(KeyEvent e)
     {
    	 
    	 int c = e.getKeyCode();
    	 
    	 if(c==KeyEvent.VK_LEFT)
    	 {
    		 velx=-3;
    		 
    	 }
    	
    	 if(c==KeyEvent.VK_RIGHT)
    	 {
    		 velx=3;
    		 
    	 }  		 	 
    		 
    	
    	 
     }
     
     public void keyTyped(KeyEvent e)
     {
    	 
     }
     
     public void keyReleased(KeyEvent e) 
     {
    	 velx=0;
    	 
     }
     
   void on()
     {

		  velbx=2;
   	  velby=-2;
   	  velx=0; 
   	
   	  x=255;
   	  
     }
     void off()
     {
    	 velx=0;
    	  velbx=0;
       	  velby=0;
		
     }         
   
     
     public static void main(String[] args) 
     {
    	 ball t = new ball();
    	 JFrame jf = new JFrame();
    	 jf.setTitle("MY Project");
    	 jf.setSize(1400, 700);
    	 jf.setVisible(true);
    	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 jf.add(t);
    	 
    	 
    	 
     }
     
     
}
