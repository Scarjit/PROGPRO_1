package gtr;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.script.ScriptException;
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
import java.util.HashMap;

public class GUIHandler extends JFrame {

	int xmax = 0;
	int xmin = 0;
	static int width = 1240;
	static int height = 860;
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
		setBounds(75, 75, width, height);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(10, 530, 89, 23);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					HashMap<Integer, Double> punkte1 = Parser.parse(inp1
							.getText());
					// draw(punkte1);
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setBounds(109, 530, 89, 23);
		contentPane.add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
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
		btnExit.setBounds(850, 530, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		inp1 = new JTextField();
		inp1.setBounds(10, 570, 930, 15);
		contentPane.add(inp1);
		inp1.setColumns(10);

		inp2 = new JTextField();
		inp2.setColumns(10);
		inp2.setBounds(10, 590, 930, 15);
		contentPane.add(inp2);

		inp3 = new JTextField();
		inp3.setColumns(10);
		inp3.setBounds(10, 610, 930, 15);
		contentPane.add(inp3);

		inp4 = new JTextField();
		inp4.setColumns(10);
		inp4.setBounds(10, 630, 930, 15);
		contentPane.add(inp4);

		inp5 = new JTextField();
		inp5.setColumns(10);
		inp5.setBounds(10, 650, 930, 15);
		contentPane.add(inp5);

		inp6 = new JTextField();
		inp6.setColumns(10);
		inp6.setBounds(10, 670, 930, 15);
		contentPane.add(inp6);

		inp7 = new JTextField();
		inp7.setColumns(10);
		inp7.setBounds(10, 690, 930, 15);
		contentPane.add(inp7);

		inp8 = new JTextField();
		inp8.setColumns(10);
		inp8.setBounds(10, 710, 930, 15);
		contentPane.add(inp8);

		inp9 = new JTextField();
		inp9.setColumns(10);
		inp9.setBounds(10, 730, 930, 15);
		contentPane.add(inp9);

		inp10 = new JTextField();
		inp10.setColumns(10);
		inp10.setBounds(10, 750, 930, 15);
		contentPane.add(inp10);

		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawLine(0, 260,width ,260 );
				g.drawLine(620, 0, 620, height);
				g.drawLine(0, 519, width, 519);
			}

		};
		panel.setBounds(0, 0, width, 520);
		contentPane.add(panel);

	}

}
