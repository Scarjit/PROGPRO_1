package gtr;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//TODO Implement Painter.
//Damn ich sollt euch auch noch etwas überlassen vom programm :)
public class GTRGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton clrBtn;
	private JButton endBtn;
	private JButton parseBtn;
	private JTextArea inpStr1;
	private JTextArea inpStr2;
	private JTextArea inpStr3;
	private JTextArea inpStr4;
	private JTextArea inpStr5;
	private JTextArea inpStr6;
	private JTextArea inpStr7;
	private JTextArea inpStr8;
	private JTextArea inpStr9;
	private JPanel panel;
	private int width; //TODO EXPORT TO GLOBALS
	private int height; //TODO EXPORT TO GLOBALS
	public GTRGUI() {
		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) displaySize.getWidth(); //TODO EXPORT TO GLOBALS
		height = (int) displaySize.getHeight(); //TODO EXPORT TO GLOBALS
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(width-50, height-75);
		this.setLocation((int) (displaySize.getWidth() / 2) - (width-50)/2, (int) (displaySize.getHeight() / 2) - (height-60)/2); // WOW so responsive :)
		this.setTitle("GTR");
		//this.setResizable(false);
		System.out.println("Width: " + width + " Height: " + height);
		initGUI();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				beenden();
			}
		});
	}

	private void initGUI() {
		Container cp = this.getContentPane();
		panel = new JPanel(null);
		inpStr1 = new JTextArea();
		panel.add(inpStr1);
		inpStr1.setBounds(20, (height-360), width-90, 15);
		inpStr2 = new JTextArea();
		panel.add(inpStr2);
		inpStr2.setBounds(20, (height-340), width-90, 15);
		inpStr3 = new JTextArea();
		panel.add(inpStr3);
		inpStr3.setBounds(20, (height-320), width-90, 15);
		inpStr4 = new JTextArea();
		panel.add(inpStr4);
		inpStr4.setBounds(20, (height-300), width-90, 15);
		inpStr5 = new JTextArea();
		panel.add(inpStr5);
		inpStr5.setBounds(20, (height-280), width-90, 15);
		inpStr6 = new JTextArea();
		panel.add(inpStr6);
		inpStr6.setBounds(20, (height-260), width-90, 15);
		inpStr7 = new JTextArea();
		panel.add(inpStr7);
		inpStr7.setBounds(20, (height-240), width-90, 15);
		inpStr8 = new JTextArea();
		panel.add(inpStr8);
		inpStr8.setBounds(20, (height-220), width-90, 15);
		inpStr9 = new JTextArea();
		panel.add(inpStr9);
		inpStr9.setBounds(20, (height-200), width-90, 15);
		clrBtn = new JButton("Löschen");
		panel.add(clrBtn);
		clrBtn.setBounds(20, (height-150), 110, 30);
		parseBtn = new JButton("Parse Strings");
		parseBtn.setBounds(140, (height-150), 120, 30);
		panel.add(parseBtn);
		endBtn = new JButton("Beenden");
		endBtn.setBounds((width-200), (height-150), 110, 30);
		panel.add(endBtn);
		parseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ValidStr();
			}
		});
		clrBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetinpt();
				System.out.println("Cleared Input");
			}
		});
		endBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();
			}
		});
		cp.add(panel);
	}

	public void ValidStr() {
		// Für alle inpStr
		if (!(inpStr1.getText().isEmpty()) || inpStr1.equals("")) {
			// Erkennung der benutzten Vars durch ASCII (erkennung von
			// sin/cos..)
			System.out.println("inpStr1 is valid");
			System.out.println(inpStr1.getText());
			main.Main.main(inpStr1.getText());
		} else {
			System.out.println("inpStr1 is invalid");
			inpStr1.setBackground(Color.red);
			inpStr1.setForeground(Color.white);
			// 2 sekunden schlafen und dann farbe zurück ändern (schlafen im
			// anderen thread.)

		}
	}

	public void resetinpt() {// Das kann man garantiert auch hübscher machen :D
		inpStr1.setText("");
		inpStr2.setText("");
		inpStr3.setText("");
		inpStr4.setText("");
		inpStr5.setText("");
		inpStr6.setText("");
		inpStr7.setText("");
		inpStr8.setText("");
		inpStr9.setText("");
		inpStr1.setBackground(Color.white);
		inpStr1.setForeground(Color.black);
		inpStr2.setBackground(Color.white);
		inpStr2.setForeground(Color.black);
		inpStr3.setBackground(Color.white);
		inpStr3.setForeground(Color.black);
		inpStr4.setBackground(Color.white);
		inpStr4.setForeground(Color.black);
		inpStr5.setBackground(Color.white);
		inpStr5.setForeground(Color.black);
		inpStr6.setBackground(Color.white);
		inpStr6.setForeground(Color.black);
		inpStr7.setBackground(Color.white);
		inpStr7.setForeground(Color.black);
		inpStr8.setBackground(Color.white);
		inpStr8.setForeground(Color.black);
		inpStr9.setBackground(Color.white);
		inpStr9.setForeground(Color.black);
	}

	private void beenden() {
		System.exit(0);
	}
}
