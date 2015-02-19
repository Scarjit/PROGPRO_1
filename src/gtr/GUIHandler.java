package gtr;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

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
	private JLabel zeile0JF;
	private JLabel zeile1JF;
	private JLabel zeile2JF;
	private JLabel zeile3JF;
	private JPanel panel;

	HashMap<Integer, Double> punkte = new HashMap<Integer, Double>();

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() { // Verhindert die Blockade der
												// GUI durch Funktionen
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

		// Refresh-Button
		JButton btnRefresh = new JButton("Zeichnen");
		btnRefresh.setBounds(10, 530, 89, 23);
		contentPane.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				punkte.clear();
				if (!(Integer.parseInt(xminTF.getText()) >= Integer // Abtasten
																	// ob xMin
																	// kleiner
																	// xMax ist,
																	// wenn ja
																	// switch
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
						xAchse = (520 * maxY) / (maxY - minY);
					}

					repaint();
				}
			}
		});

		// Löschen-Button
		JButton btnClearAll = new JButton("Löschen");
		btnClearAll.setBounds(109, 530, 89, 23);
		contentPane.add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inp1.setText("");
				repaint();
			}
		});
		
		//Speichern-Button
		JButton btnSave = new JButton("Speichern");
		btnSave.setBounds(850, 630, 95, 23);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter out = null;
				try {
					out = new PrintWriter("GTR.sav");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				out.println(inp1.getText());
				out.close();
				System.out.println("String gespeichert");
			}
		});
		
		//Laden-Button
		JButton btnLoad = new JButton("Laden");
		btnLoad.setBounds(850, 600, 95, 23);
		contentPane.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String read = null;
				try {
					read = new Scanner(new File("GTR.sav")).useDelimiter("\\Z")
							.next();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				System.out.println(read);
				inp1.setText(read);
				System.out.println("String geladen");
			}
		});
		
		//Beenden-Button
		JButton btnExit = new JButton("Beenden");
		btnExit.setBounds(1125, 800, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		//Potenz-Button
		JButton btnpow = new JButton("Math.pow()");
		btnpow.setBounds(10, 680, 150, 23);
		contentPane.add(btnpow);
		btnpow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inp1.setText(inp1.getText() + "Math.pow(basis,exponent)");
			}
		});
		
		//Eingabefelder
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

		zeile0JF = new JLabel("Eingabe für Sonderzeichen:");
		zeile0JF.setBounds(10, 600, 300, 15);
		contentPane.add(zeile0JF);

		zeile1JF = new JLabel("cos() : cosinus || sin() : sinus || tan() : tangens");
		zeile1JF.setBounds(10, 620, 300, 15);
		contentPane.add(zeile1JF);

		zeile2JF = new JLabel("ln() : logarithmus || sqrt() : wurzel || e() : e");
		zeile2JF.setBounds(10, 640, 300, 15);
		contentPane.add(zeile2JF);

		zeile3JF = new JLabel("math.pow(basis,exponent) : basis^exponent");
		zeile3JF.setBounds(10, 660, 300, 15);
		contentPane.add(zeile3JF);

		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Koordinatensystem
				// X-Achse
				g.drawLine(0, xAchse, width, xAchse);
				// Y-Achse
				g.drawLine(yAchse, 0, yAchse, height);
				// xMin
				g.drawLine(10, 260, 10, 265);
				// xMax
				g.drawLine(1225, 260, 1225, 265);
				// Koordinatenbeschriftung
				g.drawString(maxY + "", yAchse + 2, 10);
				g.drawString(minY + "", yAchse + 2, 515);
				g.drawString(xmaxi + "", 1215, xAchse - 2);
				g.drawString(xmini + "", 5, xAchse - 2);
				

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
