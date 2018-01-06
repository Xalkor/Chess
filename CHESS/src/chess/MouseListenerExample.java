package chess;

import java.awt.*;  
import java.awt.event.*;  
public class MouseListenerExample extends Frame implements MouseListener{  
    MouseListenerExample(){  
        addMouseListener(this);  
        add(new Canvas()) ; 
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
    }  
  
public static void main(String[] args) {  
    new MouseListenerExample();  
}
@Override
public void mouseClicked(MouseEvent e) {
	System.out.println(e.getX());
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}  
}  