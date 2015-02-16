package testarea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Graph sollte am besten RGB Wert in Classe haben.
 * Z.b. Graph1.setRed();
 * TODO: BTN Hintergrun entfernen.
 */
public class Main extends JFrame {
private static final long serialVersionUID = 1L;
  private JButton chooseBTN = new JButton("█"); // Unicode U+2588

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	this.setLocation((int) (displaySize.getWidth() / 2), (int) (displaySize.getHeight() / 2)); 
    this.setSize(50, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel1 = new JPanel();
    chooseBTN.addActionListener(new ButtonListener());
    chooseBTN.setBackground(null);
    panel1.add(chooseBTN);
    this.add(panel1);
    this.setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Color c = JColorChooser.showDialog(null, "Choose a Graph Color", chooseBTN.getForeground());
      if (c != null){
      	chooseBTN.setForeground(c);
      }
      System.out.println("R: " + c.getRed() + " G: " + c.getGreen() + " B: " + c.getBlue());
    }
  }
}