package gtr;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class GUIHandler extends JFrame {

	private JPanel contentPane;
	private JTextField inp1;
	private JTextField inp2;
	private JTextField inp3;
	private JTextField inp4;
	private JTextField inp5;
	private JTextField inp6;
	private JTextField inp7;
	private JTextField inp8;
	private JTextField inp9;
	private JTextField inp10;
	private JPanel panel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIHandler frame = new GUIHandler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIHandler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(10, 475, 89, 23);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//refresh
			}
		});
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setBounds(109, 475, 89, 23);
		contentPane.add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				inp1.setText("");
				inp2.setText("");
				inp3.setText("");
				inp4.setText("");
				inp5.setText("");
				inp6.setText("");
				inp7.setText("");
				inp8.setText("");
				inp9.setText("");
				inp10.setText("");
				repaint();
			}
		});
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(562, 475, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		inp1 = new JTextField();
		inp1.setBounds(10, 258, 641, 15);
		contentPane.add(inp1);
		inp1.setColumns(10);
		
		inp2 = new JTextField();
		inp2.setColumns(10);
		inp2.setBounds(10, 280, 641, 15);
		contentPane.add(inp2);
		
		inp3 = new JTextField();
		inp3.setColumns(10);
		inp3.setBounds(10, 300, 641, 15);
		contentPane.add(inp3);
		
		inp4 = new JTextField();
		inp4.setColumns(10);
		inp4.setBounds(10, 320, 641, 15);
		contentPane.add(inp4);
		
		inp5 = new JTextField();
		inp5.setColumns(10);
		inp5.setBounds(10, 340, 641, 15);
		contentPane.add(inp5);
		
		inp6 = new JTextField();
		inp6.setColumns(10);
		inp6.setBounds(10, 360, 641, 15);
		contentPane.add(inp6);
		
		inp7 = new JTextField();
		inp7.setColumns(10);
		inp7.setBounds(10, 380, 641, 15);
		contentPane.add(inp7);
		
		inp8 = new JTextField();
		inp8.setColumns(10);
		inp8.setBounds(10, 400, 641, 15);
		contentPane.add(inp8);
		
		inp9 = new JTextField();
		inp9.setColumns(10);
		inp9.setBounds(10, 420, 641, 15);
		contentPane.add(inp9);
		
		inp10 = new JTextField();
		inp10.setColumns(10);
		inp10.setBounds(10, 440, 641, 15);
		contentPane.add(inp10);
		
		panel = new JPanel(){
			private static final long serialVersionUID = 1L;
					public void paintComponent( Graphics g ) {
	                    super.paintComponent(g);
	                    Graphics2D g2 = (Graphics2D)g;
	                    Line2D line = new Line2D.Double(10, 10, 40, 40);
	                    g2.setColor(Color.blue);
	                    g2.setStroke(new BasicStroke(10));
	                    g2.draw(line);
	                 }
	            };
		panel.setBounds(0, 0, 661, 254);
		contentPane.add(panel);
	//	panel.repaint();
	}

}
