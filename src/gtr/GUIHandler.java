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
	static int xmaxi = 10;
	static int xmini = -10;
	int yAchse = 607;
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
	private JTextField xminTF;
	private JTextField xmaxTF;
	private JLabel xminJF;
	private JLabel xmaxJF;
	private JPanel panel;

	HashMap<Integer, HashMap<Integer, Double>> graphs = new HashMap<Integer, HashMap<Integer, Double>>();

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
				// HIER KOMMT DER SHIAAT
				if (!(Integer.parseInt(xminTF.getText()) >= Integer
						.parseInt(xmaxTF.getText()))) {

					int signum = Long.signum(Integer.parseInt(xminTF.getText())
							* Integer.parseInt(xmaxTF.getText()));

					switch (signum) {
					case (0):
						if (Integer.parseInt(xminTF.getText()) == 0) {
							yAchse = 0;
						} else {
							yAchse = 1215;
						}

					case (1):
						if (Integer.parseInt(xminTF.getText()) > 0) {
							yAchse = 0;
						} else {
							yAchse = 1215;
						}

					case (-1):
						yAchse = (1215 * (-1 * Integer.parseInt(xminTF.getText())))/(Integer.parseInt(xmaxTF.getText()) - Integer.parseInt(xminTF.getText()));

					}
					xmaxi = (Integer.parseInt(xmaxTF.getText()));
					xmini = (Integer.parseInt(xminTF.getText()));
					try {
						HashMap<Integer, Double> punkte1 = Parser.parse(inp1.getText());
						graphs.put(0, punkte1);
						// draw(punkte1);
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}
					System.out.println(signum);
					System.out.println(Integer.parseInt(xminTF.getText()));
					System.out.println(yAchse);
					repaint();

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

		xminTF = new JTextField();
		xminTF.setText("-10");
		xminTF.setColumns(10);
		xminTF.setBounds(1030, 570, 190, 15);
		contentPane.add(xminTF);

		xmaxTF = new JTextField();
		xmaxTF.setText("10");
		xmaxTF.setColumns(10);
		xmaxTF.setBounds(1030, 590, 190, 15);
		contentPane.add(xmaxTF);

		xminJF = new JLabel("xMin: ");
		xminJF.setBounds(998, 570, 50, 15);
		contentPane.add(xminJF);

		xmaxJF = new JLabel("xMax: ");
		xmaxJF.setBounds(994, 590, 50, 15);
		contentPane.add(xmaxJF);

		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Koordinatensystem
				// X-Achse
				g.drawLine(0, 260, width, 260);
				// Y-Achse
				g.drawLine(yAchse + 10, 0, yAchse + 10, height);
				// xMin
				g.drawLine(10, 260, 10, 265);
				// xMax
				g.drawLine(1225, 260, 1225, 265);
				// Abstand zwischen xMin und xMax -> 1215
				// y-achse einrückung = 1215 * betrag von xMin / betrag von Xmin
				// + xMax

				// Trenn-Linie
				g.drawLine(0, 519, width, 519);
				for (int i7 = 0; i7 < graphs.size(); i7++) {
					for (int i8 = 0; i8 < graphs.get(i7).size(); i8++) {
						System.out.println(i8 + "- " + graphs.get(i7).get(i8));
						if(graphs.get(i7).get(i8) != null){
							g.drawRect(i8+yAchse-Math.abs(GUIHandler.xmini) , 260-(int) Math.floor(graphs.get(i7).get(i8)), 1, 1);
						}
					}
				}
			}

		};
		panel.setBounds(0, 0, width, 520);
		contentPane.add(panel);

	}

}
