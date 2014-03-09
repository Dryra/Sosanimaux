package sos;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Snake extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1733874068071912424L;
	private static int PANEL_WIDTH = 64;
	private static int PANEL_HEIGHT = 64;

	private static Color [] COLORS = new Color [] { 
		Color.GREEN, Color.RED, Color.PINK, Color.BLACK, Color.DARK_GRAY, Color.MAGENTA };

	private String direction = "left";
	private long scoreval = 0;
	private boolean scoreflag = true;
	private boolean wallflag = true;

	private int snake[][] = { { 2, 3 }, { 2, 4 }, { 2, 5 }, { 2, 6 }, { 2, 7 },
			{ 2, 8 }, { 2, 9 }, { 2, 10 }, { 2, 11 }, { 2, 12 }, { 2, 13 },
			{ 2, 14 }, { 2, 15 }, { 2, 16 }, { 2, 17 }, { 2, 18 }, { 2, 19 },
			{ 2, 20 }, { 2, 21 } };

	private int snake_length = snake.length;
	private int mage_length = 8;
	
	private JButton[][] but = null;
	private JLabel score = null;
	private JButton restart = null;

	public Snake(String name) {
		super(name);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		.addKeyEventDispatcher(new KeyEventDispatcher() {

			public boolean dispatchKeyEvent(KeyEvent ke) {
				String param = ke.paramString();
				System.out.println("params :: " + param);

				if (!param.startsWith("KEY_PRESSED")) {
					return true; // ignoring key released
				}

				switch (ke.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					System.out.println("left");
					if (!("right".equals(direction))) {
						direction = "left";
					}// end if

					return true;
				case KeyEvent.VK_RIGHT:
					System.out.println("right");
					if (!("left".equals(direction))) {
						direction = "right";
					}// end if

					return true;
				case KeyEvent.VK_UP:
					System.out.println("up");
					if (!("down".equals(direction))) {
						direction = "up";
					}// end if

					return true;
				case KeyEvent.VK_DOWN:
					System.out.println("down");
					if (!("up".equals(direction))) {
						direction = "down";
					}// end if

					return true;
				}// end switch

				return false;
			}// end method

		});

		//Build game panel
		buildGamePanel();

		//Start snake
		startSnake();
	}
	
	private void startSnake() {
		//the tail pixel is left in white, other are blue
		for (int i = 0; i < snake_length-1; i++) {
			this.but[snake[i][0]][snake[i][1]].setBackground(Color.BLUE);
		}// end for

		this.but[snake[snake_length - 1][0]][snake[snake_length - 1][1]]
				                                .setBackground(Color.WHITE);
		moveSnake();
		generateWalls();
		scoreWatcher();

	}// end constructor

	
	private void buildGamePanel() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		but = new JButton[PANEL_WIDTH][PANEL_HEIGHT];

		for (int i = 0; i < PANEL_WIDTH; i++) {

			for (int j = 0; j < PANEL_HEIGHT; j++) {

				this.but[i][j] = new JButton();
				this.but[i][j].setBounds(j * 5 + 10, i * 5 + 10, 5, 5);
				this.but[i][j].addActionListener(this);
				this.but[i][j].setBackground(Color.WHITE);
				this.getContentPane().add(this.but[i][j]);
			}
		}// end for
		
		score = new JLabel("score :: 0");
		score.setBounds(350, 0, 100, 50);
		this.getContentPane().add(score);

		restart = new JButton("restart");
		restart.setBounds(350, 40, 80, 30);
		restart.addActionListener(this);
		this.getContentPane().add(restart);
	}

	public void actionPerformed(ActionEvent ae) {

		System.out.println(" Source :: " + ae.getSource());
		if (ae.getSource() == restart) {
			restart();
		}
	}// end action method

	public void moveSnake() {

		Thread snakeThread = new Thread() {

			public void run() {
				while (true) {

					int hx = 0, hy = 0, tx = 0, ty = 0;
					synchronized (snake) {
						changePosition(direction);
						hx = snake[0][0];
						hy = snake[0][1];
						tx = snake[snake_length - 1][0];
						ty = snake[snake_length - 1][1];

						System.out.println(" hx ::" + hx + "hy :: " + hy);
						System.out.println(" tx ::" + tx + "ty :: " + ty);

						if (gameOver(hx, hy)) {
							// System.exit(0);
							break;
						}
						paintSnake(hx, hy, Color.BLUE);
						paintSnake(tx, ty, Color.WHITE);

					}// end sync
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}// end while

				scoreflag = false;
				setWallFlag(false);
			}// end run
		
		}; // end thread
		
		snakeThread.start();
	}// end method

	private void changePosition(String dir) {

		int hx = snake[0][0];
		int hy = snake[0][1];

		//starting the from the while pixel at tail
		//move all pixel positions to their previous pixel
		for (int i = snake_length - 1; i > 0; i--) {
			snake[i][0] = snake[i - 1][0];
			snake[i][1] = snake[i - 1][1];
		}// moving positions to right in array

		
		if ("left".equals(direction)) {
			hy--;
		}// end if

		if ("right".equals(direction)) {
			hy++;
		}// end if

		if ("up".equals(direction)) {
			hx--;
		}// end if

		if ("down".equals(direction)) {
			hx++;
		}// end if

		if (hx < 0)
			hx = 63;
		if (hx > 63)
			hx = 0;
		if (hy < 0)
			hy = 63;
		if (hy > 63)
			hy = 0;

		snake[0][0] = hx;
		snake[0][1] = hy;

	}// end method

	private void paintSnake(int x, int y, Color c) {
		this.but[x][y].setBackground(c);
	}// end method

	private void generateWalls() {

		Runnable ra = new Runnable() {
			public void run() {

				Random r = new Random();
				Random s = new Random();

				int x = 0, y = 0;
				boolean flag = getWallFlag();
				while (flag) {

					x = Math.abs(r.nextInt()) % 47 + 2;
					y = Math.abs(s.nextInt()) % 53 + 2;

					Color wallcol = getRandomWallColor();
					for (int i = 0; i < mage_length; i++) {

						if (x % 2 == 0) {
							Snake.this.but[x][y + i].setBackground(wallcol);
						} else {
							Snake.this.but[x + i][y].setBackground(wallcol);
						}
					}// end for

					int slp = Math.abs(r.nextInt()) % 9 + 4;

					try {
						Thread.sleep(slp * 1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					for (int i = 0; i < mage_length; i++) {

						if (x % 2 == 0) {
							Snake.this.but[x][y + i].setBackground(Color.WHITE);
						} else {
							Snake.this.but[x + i][y].setBackground(Color.WHITE);
						}
					}// end for
					flag = getWallFlag();

				}// end while

			}// end run

		}; // end thread

		for (int i = 0; i < 16; i++) {
			Thread wa = new Thread(ra);
			wa.start();
		}// end for

	}// end method

	private Color getRandomWallColor() {
		Random r = new Random();
		int val = Math.abs(r.nextInt()) % COLORS.length;
		if (val < COLORS.length) {
			return COLORS[val];
		}
		return Color.CYAN;
	}// end method

	//Any other color means collided with wall
	private boolean gameOver(int x, int y) {
		if (but[x][y].getBackground().equals(Color.BLUE)
				|| but[x][y].getBackground().equals(Color.WHITE)) {
			return false;
		}
		return true;
	}// end method

	private void scoreWatcher() {

		Thread sc = new Thread() {
			Random r = new Random();

			public void run() {

				while (scoreflag) {
					int val = Math.abs(r.nextInt()) % 9;
					scoreval += val;
					score.setText("score :: " + scoreval);
					try {
						Thread.sleep(400);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};// end thread
		sc.start();

	}// end method

	private synchronized boolean getWallFlag() {
		return wallflag;
	}// end method

	private synchronized void setWallFlag(boolean flag) {
		wallflag = flag;
	}// end method

	private void restart() {

		scoreflag = true;
		wallflag = true;
		scoreval = 0;

		System.out.println("Going to restart");
		startSnake();
	}// end method

	public static void main(String a[]) {
		Snake b = new Snake("BE THE CODER - Snake Game");
		b.setSize(450, 380);
		b.setLocation(50, 50);
		b.setVisible(true);
	}// end main

}// end class