package progpro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	static List<Integer> pixelX = new ArrayList<Integer>();
	static List<Integer> pixelY = new ArrayList<Integer>();
   @SuppressWarnings("unused")
public static void main(String[] a) throws InterruptedException{
	   for(int i=0;i<1500;i++){
		   pixelX.add((int) (Math.sin(i)*10)+250);
		   pixelY.add(i);
	   }
	Main gtr = new Main();
   }
   public Main() throws InterruptedException{
	   	Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Hello World");   
		JFrame Mainframe = new JFrame();
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.setTitle("GTR");
		Mainframe.setBounds((int) (displaySize.getWidth()/2)-750, (int) (displaySize.getHeight()/2)-250, 1500, 500);
		Mainframe.setResizable(false);
		ImageIcon img = new ImageIcon(".\\bg.png");
		Mainframe.setIconImage(img.getImage());
		Mainframe.add(new DrawPanel());
		Mainframe.setVisible(true); //Muss immer am ende kommen oder Mainframe.repaint()20200
   }
   public class DrawPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	protected void paintComponent(Graphics g){
		   super.paintComponent(g);
		   //g.drawLine(x1, y1, x2, y2);
		   g.drawLine(750, 0, 750, 500);
		   g.drawLine(0, 250, 1500, 250);
		   for(int i=0;i<pixelX.size();i++){
			   if(i!=0){
				   System.out.println("Pos: " + pixelX.get(i) + " : " + pixelY.get(i));
				   g.drawLine(pixelY.get(i-1),pixelX.get(i-1),pixelY.get(i),pixelX.get(i));
				   g.setColor(Color.black);
			   }
		   }
	   }
   }
}