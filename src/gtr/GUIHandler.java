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
	private static final long serialVersionUID = 1L;
	boolean fd = true;
	int xmax = 0;
	int xmin = 0;
	int xAchse = 260;
	static int xmaxi = 10;
	static int xmini = -10;
	int yAchse = 607;
	int maxY = 0;
	int minY = 9999999;
	int curY = 0;
	static int width = 1240;
	static int height = 860;
	private JPanel contentPane;
	private JTextField inp1;
	private JTextField xminTF;
	private JTextField xmaxTF;
	private JLabel xminJF;
	private JLabel xmaxJF;
	private JPanel panel;
	HashMap<Integer, Double> punkte = new HashMap<Integer, Double>();

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
		setTitle("GTR");
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
				punkte.clear();
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
						yAchse = (1215 * (-1 * Integer.parseInt(xminTF
								.getText())))
								/ (Integer.parseInt(xmaxTF.getText()) - Integer
										.parseInt(xminTF.getText()));

					}
					xmaxi = (Integer.parseInt(xmaxTF.getText()));
					xmini = (Integer.parseInt(xminTF.getText()));
					try {
						punkte = Parser.parse(inp1.getText());
						// draw(punkte1);
					} catch (ScriptException e1) {
						e1.printStackTrace();
					}
					System.out.println(signum);
					System.out.println(Integer.parseInt(xminTF.getText()));
					System.out.println(yAchse);

					maxY = 0;
					minY = 9999999;
					curY = 0;
					for (int i8 = 0; i8 < punkte.size(); i8++) {
						curY = (int) Math.floor(punkte.get(i8));
						if (curY > maxY) {
							System.out.println("New Max Y:" + curY);
							maxY = curY;
						}
						if (curY < minY) {
							System.out.println("New Min Y:" + curY);
							minY = curY;
						}
					}
					System.out.println("XXXX" + minY + "XXXX");
					xAchse = 0;
					int signum2 = Long.signum(minY * maxY);

					switch (signum2) {
					case (0):
						if (maxY == 0) {
							xAchse = 0;
						} else {
							xAchse = 520;
						}

					case (1):
						if (maxY > 0) {
							xAchse = 520;
						} else {
							xAchse = 0;
						}

					case (-1):
						xAchse = (520*maxY)/(maxY-minY);
					}

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
				// X-Achse+
				System.out.println("xAchse:" + xAchse + " maxY:" + maxY
						+ " minY:" + minY);
				// g.drawLine(0, 520 * (maxY) / (Math.abs(minY) + maxY), width,
				// 520 * (maxY) / (Math.abs(minY) + maxY));
				g.drawLine(0, xAchse, width, xAchse);
				// Y-Achse
				g.drawLine(yAchse, 0, yAchse, height);
				// xMin
				g.drawLine(10, 260, 10, 265);
				// xMax
				g.drawLine(1225, 260, 1225, 265);
				g.drawString(maxY+"", yAchse+2, 10);
				g.drawString(minY+"", yAchse+2, 515);
				g.drawString(xmaxi+"", 1215, xAchse-2);
				g.drawString(xmini+"", 5, xAchse-2);
				// Abstand zwischen xMin und xMax -> 1215
				// y-achse einrückung = 1215 * betrag von xMin / betrag von Xmin
				// + xMax

				// Trenn-Linie
				g.drawLine(0, 519, width, 519);
				boolean fd1 = true;
				int xprew = 0;
				int yprew = 0;
				for (int i8 = 0; i8 < (xmaxi - xmini + 1); i8++) {
					if (punkte.get(i8) != null) {
						System.out.println(i8);
						g.drawRect(
								(i8 * (1240 / (xmaxi - xmini + 1))) + 10,
								((520 * (maxY) / (Math.abs(minY) + maxY)))
										- (520 * (int) Math.floor(punkte
												.get(i8)) / (Math.abs(minY) + maxY)),
								1, 1);
						if (fd1 != true) {
							System.out.println("Drawing Connection...");
							g.drawLine(
									xprew,
									yprew,
									(i8 * (1240 / (xmaxi - xmini + 1))) + 10,
									((520 * (maxY) / (Math.abs(minY) + maxY)))
											- (520 * (int) Math.floor(punkte
													.get(i8)) / (Math.abs(minY) + maxY)));
						}
						xprew = (i8 * (1240 / (xmaxi - xmini + 1))) + 10;
						yprew = ((520 * (maxY) / (Math.abs(minY) + maxY)))
								- (520 * (int) Math.floor(punkte.get(i8)) / (Math
										.abs(minY) + maxY));
						System.out.println("xprew: " + xprew + " : yprew: "
								+ yprew);
						fd1 = false;

					}
				}
			}

		};
		panel.setBounds(0, 0, width, 520);
		contentPane.add(panel);
	}

}
