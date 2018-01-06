package chess;

import java.awt.*; 

public class CanvasExample  {  
  public CanvasExample(){  
    Frame f= new Frame("Canvas Example");  
    MyCanvas c = new MyCanvas();
    c.setBounds(20, 40, 300, 200);
    f.add(c); 
    f.setLayout(null);  
    f.setSize(400, 400);  
    f.setVisible(true);  
  }  
  public static void main(String args[])   {  
    new CanvasExample();  
  }  
}  

class MyCanvas extends Canvas  {  
        public MyCanvas() {  
        setBackground (Color.GRAY);  
        setSize(300, 200);  
     }  
        
  public void paint(Graphics g)    {  
    g.setColor(Color.red);  
    g.fillOval(75, 75, 150, 75); 
    g.drawLine(0,0,100,100);
  }  
}    