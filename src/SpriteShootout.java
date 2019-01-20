/* Sprite Shootout Program
 * By John Kattukudiyil
 * Teacher: Mr. D'Addario
 * Friday, January 26th, 2018
 * This program pits two players against each other in a pixelated shoot-out
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

//This class deals with the introductory screen as well as the gameplay screen
public class SpriteShootout implements ActionListener{
	
	//initialize JFrame and components to be added
	//initialize variables to be used throughout the program across methods and classes
	static JFrame frame = new JFrame();
	static int x1 = 100;
	static int y1 = 300;
	static int dx1 = 0;
	static int dy1 = 0;
	static int width = 80;
	static int height = 60;
	static int x2 = 700;
	static int y2 = 300;
	static int dx2 = 0;
	static int dy2 = 0;
	static int blastY;
	static int blastX = 10000;
	static int blastY2;
	static int blastX2 = -12000;
	static int blast1Counter;
	static int blast2Counter;
	static int healthWidth1 = 202;
	static int healthWidth2 = 202;
	static int counter = 0;
	static String p1Choice = "";
	static String p2Choice = "";
	static String stageChoice = "";
	private static boolean leftPressed1 = false;
	private static boolean rightPressed1 = false;
	private static boolean upPressed1 = false;
	private static boolean downPressed1 = false;
	private static boolean leftPressed2 = false;
	private static boolean rightPressed2 = false;
	private static boolean upPressed2 = false;
	private static boolean downPressed2 = false;
	private static boolean spacePressed = false;
	private static boolean enterPressed = false;
	private static boolean blasted = false;
	private static boolean blasted2 = false;
	private static boolean gameStart;
	private static boolean firstBootUp = true;
	static String blastTypeA = "";
	static String blastTypeB = "";

	static JLabel player1, logo1;
	static JLabel player2, logo2;
	static JLabel p1Blast;
	static JLabel p2Blast;
	static JLabel border;
	static JLabel healthBar1a;
	static JLabel healthBar1b;
	static JLabel healthBar2a;
	static JLabel healthBar2b;
	static JLabel countdown;
	static JLabel chargeBar1;
	static JLabel chargeBar2;
	static ImageIcon image;
	static ImageIcon p1ImageA, p1ImageB, p1Logo;
	static ImageIcon p2ImageA, p2ImageB, p2Logo;
	static SpriteShootout shoot = new SpriteShootout();
	static Timer timer = new Timer(10, shoot);

	//main method sets up the JFrame and window to be visible
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					SpriteShootout window = new SpriteShootout();
					SpriteShootout.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SpriteShootout() {
		//heads to the method that deals with the game's introductory screen
		intro();
		
	} 
	
	//Manage the game's introductory screen
	static void intro() {
		
		//set colour, size, position, layout, background and title of the JFrame
		frame.pack();
		frame.getContentPane().requestFocusInWindow();
		if (firstBootUp) {
			frame.setBounds(300, 50, 900, 700);
			firstBootUp = false;
		} else {
			frame.setBounds(frame.getX(),frame.getY(), 900, 700);
		}
		frame.setVisible(true);
		image = new ImageIcon("src\\Resources\\background.png");
		frame.setContentPane(new JLabel(image));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sprite Shootout");
		
		//Create a label that displays the game's logo
		JLabel title = new JLabel("");
		image = new ImageIcon("src\\Resources\\Logo.png");
		title.setIcon(image);
		title.setBounds(225, 150, 468, 194);
		frame.getContentPane().add(title);
		
		//Create a button that allows the user to start the game
		final JButton start = new JButton();
		image = new ImageIcon("src\\Resources\\start.png");
		start.setIcon(image);
		start.setBounds(400, 400, 112, 39);
		frame.getContentPane().add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start.setActionCommand("clicked");
				if(start.getActionCommand().equals("clicked")){
					//Hide current frame and run the class that deals with selecting Player 1's character
					frame.setVisible(false);
					Player1Select.initialize();
				}
			}
		});
		
		//Create a button that tells the user how to play the game when clicked
		final JButton howPlay = new JButton();
		image = new ImageIcon("src\\Resources\\howtoplay.png");
		howPlay.setIcon(image);
		howPlay.setBounds(355, 450, 208, 39);
		frame.getContentPane().add(howPlay);
		howPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				howPlay.setActionCommand("clicked");
				if(howPlay.getActionCommand().equals("clicked")){
					//Read instructions on how to play from a file and display it in a message box
					try {
						BufferedReader br = new BufferedReader(new FileReader("Instructions.txt"));
					    String line = null;
					    while ((line = br.readLine()) != null){
					            JOptionPane.showMessageDialog(null, line);
					    }        
							br.close();
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();}
						catch (IOException e) {
							
						}
					}
				}
			}
		);
		
		//Create a button that allows the user to exit the application when clicked
		final JButton quit = new JButton();
		image = new ImageIcon("src\\Resources\\quit.png");
		quit.setIcon(image);
		quit.setBounds(400, 500, 110, 39);
		frame.getContentPane().add(quit);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quit.setActionCommand("clicked");
				if(quit.getActionCommand().equals("clicked")){
					//terminate the application when the button is clicked
					System.exit(0);
				}
			}
		});
		
	}

	//Manage the game screen of the application
	public static void gameScreen() {
		
		//Format the JFrame to the game screen's specifications
		frame.pack();
		frame.getContentPane().requestFocusInWindow();
		frame.setBounds(frame.getX(),frame.getY(), 900, 700);
		frame.setVisible(true);
		//Do not allow the characters to move until the countdown has finished
		gameStart = false;
		//Run the method that displays the user's selected stage
		stageChoice();
		
		//Values are declared here for the purpose of resetting their values when the user selects the "play again" option
		x1 = 100;
		y1 = 300;
		dx1 = 0;
		dy1 = 0;
		width = 80;
		height = 60;
		x2 = 700;
		y2 = 300;
		dx2 = 0;
		dy2 = 0;
		//blastX and blastX2 (x coordinates of each Players' blasts) are given arbitrary values that change as soon as the method is executed
        blastX = 10000;
    	blastX2 = -12000;
    	counter = 0;
		
		//Create a label that displays a countdown timer
		countdown = new JLabel("");
		image = new ImageIcon("src\\Resources\\countdown3.png");
		countdown.setIcon(image);
		countdown.setBounds(370, 250, 150, 145);
		frame.getContentPane().add(countdown);
		countdown.setVisible(false);
		
		//Create a label that displays the first player's blast charge level
		chargeBar1 = new JLabel("");
		image = new ImageIcon("src\\Resources\\indicator1.png");
		chargeBar1.setIcon(image);
		chargeBar1.setBounds(100, 100, 60, 27);
		frame.getContentPane().add(chargeBar1);
		chargeBar1.setVisible(false);
		
		//Create a label that displays the second player's blast charge level
		chargeBar2 = new JLabel("");
		image = new ImageIcon("src\\Resources\\indicator1.png");
		chargeBar2.setIcon(image);
		chargeBar2.setBounds(100, 100, 60, 27);
		frame.getContentPane().add(chargeBar2);
		chargeBar2.setVisible(false);
		
		//Create a label that displays the boundary between the two players
		border = new JLabel("");
		image = new ImageIcon("src\\Resources\\boundary.png");
		border.setIcon(image);
		border.setBounds(425, 0, 50, 900);
		frame.getContentPane().add(border);
		
		//Create a label that displays the amount of health Player 1 has lost
		healthBar1a = new JLabel("");
		image = new ImageIcon("src\\Resources\\health bar1.png");
		healthBar1a.setIcon(image);
		healthWidth1 = 202;
		healthBar1a.setBounds(5, -10, healthWidth1, 60);
		frame.getContentPane().add(healthBar1a);
		
		//Create a label that displays the amount of health Player 1 has left
		healthBar1b = new JLabel("");
		image = new ImageIcon("src\\Resources\\health bar2.png");
		healthBar1b.setIcon(image);
		healthBar1b.setBounds(-10, -10, 234, 60);
		frame.getContentPane().add(healthBar1b);
		
		//Create a label that displays the amount of health Player 2 has lost
		healthBar2a = new JLabel("");
		image = new ImageIcon("src\\Resources\\health bar1.png");
		healthBar2a.setIcon(image);
		healthWidth2 = 202;
		healthBar2a.setBounds(686, -10, healthWidth2, 60);
		frame.getContentPane().add(healthBar2a);
		
		//Create a label that displays the amount of health Player 2 has left
		healthBar2b = new JLabel("");
		image = new ImageIcon("src\\Resources\\health bar2.png");
		healthBar2b.setIcon(image);
		healthBar2b.setBounds(670, -10, 234, 60);
		frame.getContentPane().add(healthBar2b);
		
		//Create a label to represent Player 1's sprite
		player1 = new JLabel("");
		player1.setBounds(x1, y1, width, height);
		player1.setFocusable(true);
		//Execute the method that displays Player 1's selected sprite
		player1Icons();
		player1.setIcon(p1ImageA);
		
		//Create a label to represent Player 2's sprite
		player2 = new JLabel("");
		player2.setBounds(x2, y2, width, height);
		player2.setFocusable(true);
		//Execute the method that displays Player 2's selected sprite
		player2Icons();
		player2.setIcon(p2ImageA);
		
		//Begin the timer
		timer.start();
		
		player1.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				//set boolean values corresponding to certain keys to true when they are pressed
				
				if(gameStart) {
				
				if (key == KeyEvent.VK_A) {
					leftPressed1 = true;
		        }

		        if (key == KeyEvent.VK_D) {
		        	rightPressed1 = true;
		        	
		        }

		        if (key == KeyEvent.VK_W) {
		        	upPressed1 = true;
		        }

		        if (key == KeyEvent.VK_S) {
		        	downPressed1 = true;
		        }
		        
		        if (key == KeyEvent.VK_SPACE) {
		        	spacePressed = true;
		        }
		        
		        if (key == KeyEvent.VK_LEFT) {
		        	leftPressed2 = true;
		        }
		        
		        if (key == KeyEvent.VK_RIGHT) {
		        	rightPressed2 = true;
		        }

		        if (key == KeyEvent.VK_UP) {
		        	upPressed2 = true;
		        }

		        if (key == KeyEvent.VK_DOWN) {
		        	downPressed2 = true;
		        }
		        
		        if (key == KeyEvent.VK_ENTER) {
		        	enterPressed = true;
		        }
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();

				//set boolean values corresponding to certain keys to false when they are released
				
				if (gameStart) {
		        if (key == KeyEvent.VK_A) {
		        	leftPressed1 = false;
		        }

		        if (key == KeyEvent.VK_D) {
		        	rightPressed1 = false;
		        }

		        if (key == KeyEvent.VK_W) {
		        	upPressed1 = false;
		        }

		        if (key == KeyEvent.VK_S) {
		        	downPressed1 = false;
		        }
		        
		        if (key == KeyEvent.VK_SPACE) {
		        	spacePressed = false;
		        	//Execute the method that fires a blast for Player 1 if the previous shot is out of screen
		        	if(blastX > 1000) {
		        	player1Shot();
		        	}
		        }
		        
		        if (key == KeyEvent.VK_LEFT) {
		        	leftPressed2 = false;
		        }

		        if (key == KeyEvent.VK_RIGHT) {
		        	rightPressed2 = false;
		        }

		        if (key == KeyEvent.VK_UP) {
		        	upPressed2 = false;
		        }

		        if (key == KeyEvent.VK_DOWN) {
		        	downPressed2 = false;
		        }
		        
		        if (key == KeyEvent.VK_ENTER) {
		        	enterPressed = false;
		        	//Execute the method that fires a blast for Player 2 if the previous shot is out of screen
		        	if(blastX2 < -165) {
		        	player2Shot();
		        	}
		        }
		 
			}
                      
			
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			
		});
		
		//Add both Player 1 and 2's sprites to the JFrame
		frame.getContentPane().add(player1);
		frame.getContentPane().add(player2);
		
		
	}

	//Perform these actions every time the timer is activated (every 10 milliseconds)
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//Set up a counter to time the animations for the beginning countdown of the game
		counter +=1;
		if (counter < 100) {
			countdown.setVisible(true);
		} else if (counter < 200) {
			image = new ImageIcon("src\\Resources\\countdown2.png");
			countdown.setIcon(image);
		} else if (counter < 300) {
			image = new ImageIcon("src\\Resources\\countdown1.png");
			countdown.setIcon(image);
			countdown.setBounds(390, 250, 100, 172);
		} else if (counter < 370) {
			image = new ImageIcon("src\\Resources\\countdowngo.png");
			countdown.setIcon(image);
			countdown.setBounds(300, 250, 350, 204);
		} else {
			countdown.setVisible(false);
			//Allow the characters to move after the countdown is finished
			gameStart = true;
			counter -=1;
		}
		
		//Evaluate the following procedures only if the game has been started
		if (gameStart) {
		//Move Player 1's position to the left if the left key is pressed
		if (leftPressed1 && x1 > 0) {
			dx1 = -5;
			x1 += dx1;
			player1.setBounds(x1, y1, width, height);
		}
		
		//Move Player 1's position to the right if the right key is pressed
		if (rightPressed1 && x1 < 375) {
			dx1 = 5;
			x1 += dx1;
			player1.setBounds(x1, y1, width, height);
		}
		
		//Move Player 1's position down if the down key is pressed
		if (downPressed1 && y1 < 615) {
			dy1 = 5;
			y1 += dy1;
			player1.setBounds(x1, y1, width, height);
		}
		
		//Move Player 1's position up if the up key is pressed
		if (upPressed1 && y1 > 35) {
			dy1 = -5;
			y1 += dy1;
			player1.setBounds(x1, y1, width, height);
		}
		
		//If the space key is pressed, update a counter that counts how long the button is being held for
		//Time a visual indicator to appear to indicate the type of blast being charged
		if(spacePressed) {
			//Display Player 1's alternate sprite
			player1.setIcon(p1ImageB);
			blast1Counter += 1;
			if(blast1Counter < 50) {
				chargeBar1.setVisible(false);
			} else if (blast1Counter < 150) {
				image = new ImageIcon("src\\Resources\\indicator1.png");
				chargeBar1.setIcon(image);
				chargeBar1.setBounds(x1, y1 - 20, 60, 27);
				chargeBar1.setVisible(true);
			} else {
				image = new ImageIcon("src\\Resources\\indicator2.png");
				chargeBar1.setIcon(image);
				chargeBar1.setBounds(x1, y1 - 20, 60, 27);
				chargeBar1.setVisible(true);
			}
		} else {
			//Display Player 1's default sprite
			player1.setIcon(p1ImageA);
		}
		
		//Move Player 2's position to the left if the A key is pressed
		if (leftPressed2 && x2 > 460) {
			dx2 = -5;
			x2 += dx2;
			player2.setBounds(x2, y2, width, height);
		}
		
		//Move Player 2's position to the right if the D key is pressed
		if (rightPressed2 && x2 < 835) {
			dx2 = 5;
			x2 += dx2;
			player2.setBounds(x2, y2, width, height);
		}
		
		//Move Player 2's position down if the S key is pressed
		if (downPressed2 && y2 < 615) {
			dy2 = 5;
			y2 += dy2;
			player2.setBounds(x2, y2, width, height);
		}
		
		//Move Player 2's position up if the W key is pressed
		if (upPressed2 && y2 > 35) {
			dy2 = -5;
			y2 += dy2;
			player2.setBounds(x2, y2, width, height);
		}
		
		//If the enter key is pressed, update a counter that counts how long the button is being held for
		//Time a visual indicator to appear to indicate the type of blast being charged
		if(enterPressed) {
			//Display Player 2's alternate sprite
			player2.setIcon(p2ImageB);
			blast2Counter += 1;
			if(blast2Counter < 50) {
				chargeBar2.setVisible(false);
			} else if (blast2Counter < 150) {
				image = new ImageIcon("src\\Resources\\indicator1.png");
				chargeBar2.setIcon(image);
				chargeBar2.setBounds(x2, y2 - 20, 60, 27);
				chargeBar2.setVisible(true);
			} else {
				image = new ImageIcon("src\\Resources\\indicator2.png");
				chargeBar2.setIcon(image);
				chargeBar2.setBounds(x2, y2 - 20, 60, 27);
				chargeBar2.setVisible(true);
			}
		} else {
			//Display Player 2's default sprite
			player2.setIcon(p2ImageA);
		}
		
		//Update Player 1's blast's x position
		if (blasted) {
			if (blastTypeA == "type3") {
				p1Blast.setBounds(blastX, blastY, 120, 95);
			} else if(blastTypeA == "type2"){
				p1Blast.setBounds(blastX, blastY, 85, 65);
			} else {
				p1Blast.setBounds(blastX, blastY, 40, 31);
			}
			blastX += 20;
		}
		
		//Update Player 2's blast's x position
		if (blasted2) {
			if (blastTypeB == "type3") {
				p2Blast.setBounds(blastX2, blastY2, 120, 95);
			} else if (blastTypeB.equals("type2")){
				p2Blast.setBounds(blastX2, blastY2, 85, 65);
			} else {
				p2Blast.setBounds(blastX2, blastY2, 40, 31);
			}
			blastX2 -= 20;
		}
		
		
		//Execute these conditions if Player 1's shots collide with Player 2's sprite
		if(blastTypeA.equals("type3")) {
			if (blastX >= x2 && blastY >= y2 - 70 && blastY <= y2 + 37) {
				image = new ImageIcon("nothing");
				p1Blast.setIcon(image);
				if (blastX <= x2 + 20) {
					healthWidth2 -= 30;
				}
			}
			healthBar2a.setBounds(686, -10, healthWidth2, 60);
		} else if (blastTypeA.equals("type2")) {
			if (blastX >= x2 && blastY >= y2 - 42 && blastY <= y2 + 42) {
				image = new ImageIcon("nothing");
				p1Blast.setIcon(image);
				if (blastX <= x2 + 20) {
					healthWidth2 -= 10;
				}
			}
			healthBar2a.setBounds(686, -10, healthWidth2, 60);
		} else {
			if (blastX >= x2 && blastY >= y2 - 15 && blastY <= y2 + 45) {
				image = new ImageIcon("nothing");
				p1Blast.setIcon(image);
				if (blastX <= x2 + 20) {
					healthWidth2 -= 3;
				}
			}
			//Update Player 2's health after the collision
			healthBar2a.setBounds(686, -10, healthWidth2, 60);
		}

		
		//Execute these conditions if Player 2's shots collide with Player 1's sprite
		if(blastTypeB.equals("type3")) {
			if (blastX2 <= x1 && blastY2 >= y1 - 70 && blastY2 <= y1 + 37) {
				image = new ImageIcon("nothing");
				p2Blast.setIcon(image);
				if(blastX2 >= x1 - 20) {
					healthWidth1 -= 30;
				}
			}
			healthBar1a.setBounds(5, -10, healthWidth1, 60);
		} else if(blastTypeB.equals("type2")) {
			if (blastX2 <= x1 && blastY2 >= y1 - 42 && blastY2 <= y1 + 42) {
				image = new ImageIcon("nothing");
				p2Blast.setIcon(image);
				if(blastX2 >= x1 - 20) {
					healthWidth1 -= 10;
				}
				healthBar1a.setBounds(5, -10, healthWidth1, 60);
			}
		} else {
			if (blastX2 <= x1 && blastY2 >= y1 - 15 && blastY2 <= y1 + 45) {
				image = new ImageIcon("nothing");
				p2Blast.setIcon(image);
				if(blastX2 >= x1 - 20) {
					healthWidth1 -= 3;
				}
				healthBar1a.setBounds(5, -10, healthWidth1, 60);
			}
		}
		
		//Stop the game if either of the players loses all of their health
		if(healthWidth1 <=0 || healthWidth2 <=0) {
			gameStart = false;
			counter +=1;
			if (counter < 500) {
				countdown.setVisible(true);
				image = new ImageIcon("src\\Resources\\endgame.png");
				countdown.setIcon(image);
				countdown.setBounds(200, 225, 500, 174);
			} else {
				timer.stop();
				countdown.setVisible(false);
				frame.setVisible(false);
				leftPressed1 = false;
	        	rightPressed1 = false;
	        	upPressed1 = false;
	        	downPressed1 = false;
	        	spacePressed = false;
	        	leftPressed2 = false;
	        	rightPressed2 = false;
	        	upPressed2 = false;
	        	downPressed2 = false;
	        	enterPressed = false;
				//send the players to the results screen
				Results.initialize();
			}
		}
		
	}
		}
		
		
	
	public static void player1Shot() {
		
		//determine the type of shot Player 1 fires depending on how long the space key was held
		p1Blast = new JLabel("");
		if(blast1Counter < 50) {
		image = new ImageIcon("src\\Resources\\blast1.png");
		p1Blast.setIcon(image);
		blastTypeA = "type1";
		} else if (blast1Counter < 150){
		image = new ImageIcon("src\\Resources\\blast2a.png");
		p1Blast.setIcon(image);
		blastTypeA = "type2";
		} else {
		image = new ImageIcon("src\\Resources\\blast3a.png");
		p1Blast.setIcon(image);
		blastTypeA = "type3";
		}
		if (blastTypeA == "type3") {
			p1Blast.setBounds(x1 + 30, y1, 120, 95);
			blastY = y1 - 5;
		} else if (blastTypeA == "type2") {
			p1Blast.setBounds(x1 + 30, y1, 80, 65);
			blastY = y1;
		} else {
			p1Blast.setBounds(x1 + 30, y1, 40, 31);
			blastY = y1 + 10;
		}
		//set the blast's coordinates to Player1's coordinates at the moment it was fired
		blastX = x1 + 30;
		p1Blast.setFocusable(true);
		blasted = true;
		//Add the blast to the JFrame
		frame.getContentPane().add(p1Blast);
		
		//Reset the blast timer and hide the blast charge level indicator
		blast1Counter = 0;
		chargeBar1.setVisible(false);
	}
	
	public static void player2Shot() {
		
		p2Blast = new JLabel("");
		//determine the type of shot Player 2 fires depending on how long the enter key was held
		if(blast2Counter < 50) {
			image = new ImageIcon("src\\Resources\\blast1.png");
			p2Blast.setIcon(image);
			blastTypeB = "type1";
			} else if (blast2Counter < 150){
			image = new ImageIcon("src\\Resources\\blast2b.png");
			p2Blast.setIcon(image);
			blastTypeB = "type2";
			} else {
			image = new ImageIcon("src\\Resources\\blast3b.png");
			p2Blast.setIcon(image);
			blastTypeB = "type3";
			}
		
		if (blastTypeB == "type3") {
			p2Blast.setBounds(x2 - 30, y2, 120, 95);
			blastY2 = y2 - 5;
		} else if(blastTypeB.equals("type2")){
			p2Blast.setBounds(x2 - 30, y2, 80, 65);
			blastY2 = y2;
		} else {
			p2Blast.setBounds(x2 - 30, y2, 40, 31);
			blastY2 = y2 + 10;
		}
		
		//set the blast's coordinates to Player2's coordinates at the moment it was fired
		blastX2 = x2 - 30;
		p2Blast.setFocusable(true); 
		blasted2 = true;
		//Add the blast to the JFrame
		frame.getContentPane().add(p2Blast);

		//Reset the blast timer and hide the blast charge level indicator
		blast2Counter = 0;
		chargeBar2.setVisible(false);
	}
	
	//Determine which default and alternate sprites to use and the name for Player 1 based on their choice in the previous screen
	public static void player1Icons() {
		if(p1Choice.equals("square")) {
			p1ImageA = new ImageIcon("src\\Resources\\square1.png");
			p1ImageB = new ImageIcon("src\\Resources\\square1.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 130, 40);
			p1Logo = new ImageIcon("src\\Resources\\squarelogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		} else if(p1Choice.equals("diamond")) {
			p1ImageA = new ImageIcon("src\\Resources\\diamond1.png");
			p1ImageB = new ImageIcon("src\\Resources\\diamond1.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 135, 47);
			p1Logo = new ImageIcon("src\\Resources\\diamondlogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}  else if(p1Choice.equals("hexagon")) {
			p1ImageA = new ImageIcon("src\\Resources\\hexa1.png");
			p1ImageB = new ImageIcon("src\\Resources\\hexa1.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 150, 48);
			p1Logo = new ImageIcon("src\\Resources\\hexagonlogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}   else if(p1Choice.equals("hourglass")) {
			p1ImageA = new ImageIcon("src\\Resources\\hour1.png");
			p1ImageB = new ImageIcon("src\\Resources\\hour1.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 170, 50);
			p1Logo = new ImageIcon("src\\Resources\\hourglasslogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("mario")) {
			p1ImageA = new ImageIcon("src\\Resources\\mario1.png");
			p1ImageB = new ImageIcon("src\\Resources\\mario1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 110, 50);
			p1Logo = new ImageIcon("src\\Resources\\mariologoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("link")) {
			p1ImageA = new ImageIcon("src\\Resources\\link1.png");
			p1ImageB = new ImageIcon("src\\Resources\\link1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 100, 50);
			p1Logo = new ImageIcon("src\\Resources\\linklogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("pacman")) {
			p1ImageA = new ImageIcon("src\\Resources\\pacman1.png");
			p1ImageB = new ImageIcon("src\\Resources\\pacman1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 150, 55);
			p1Logo = new ImageIcon("src\\Resources\\pacmanlogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("megaman")) {
			p1ImageA = new ImageIcon("src\\Resources\\megaman1.png");
			p1ImageB = new ImageIcon("src\\Resources\\megaman1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 160, 50);
			p1Logo = new ImageIcon("src\\Resources\\megamanlogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("kirby")) {
			p1ImageA = new ImageIcon("src\\Resources\\kirby1.png");
			p1ImageB = new ImageIcon("src\\Resources\\kirby1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 160, 50);
			p1Logo = new ImageIcon("src\\Resources\\kirbylogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		}    else if(p1Choice.equals("cuphead")) {
			p1ImageA = new ImageIcon("src\\Resources\\cuphead1.png");
			p1ImageB = new ImageIcon("src\\Resources\\cuphead1b.png");
			logo1 = new JLabel("");
			logo1.setBounds(250, 10, 140, 50);
			p1Logo = new ImageIcon("src\\Resources\\cupheadlogoA.png");
			logo1.setIcon(p1Logo);
			frame.getContentPane().add(logo1);
		} 
	}
	
	//determine which default and alternate sprites to use and the name for Player 2 based on their choice in the previous screen
		public static void player2Icons() {
			if(p2Choice.equals("square")) {
				p2ImageA = new ImageIcon("src\\Resources\\square2.png");
				p2ImageB = new ImageIcon("src\\Resources\\square2.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 130, 40);
				p2Logo = new ImageIcon("src\\Resources\\squarelogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
				
			} else if(p2Choice.equals("diamond")) {
				p2ImageA = new ImageIcon("src\\Resources\\diamond2.png");
				p2ImageB = new ImageIcon("src\\Resources\\diamond2.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 135, 47);
				p2Logo = new ImageIcon("src\\Resources\\diamondlogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}  else if(p2Choice.equals("hexagon")) {
				p2ImageA = new ImageIcon("src\\Resources\\hexa2.png");
				p2ImageB = new ImageIcon("src\\Resources\\hexa2.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 150, 48);
				p2Logo = new ImageIcon("src\\Resources\\hexagonlogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}   else if(p2Choice.equals("hourglass")) {
				p2ImageA = new ImageIcon("src\\Resources\\hour2.png");
				p2ImageB = new ImageIcon("src\\Resources\\hour2.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 170, 50);
				p2Logo = new ImageIcon("src\\Resources\\hourglasslogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("mario")) {
				p2ImageA = new ImageIcon("src\\Resources\\mario2.png");
				p2ImageB = new ImageIcon("src\\Resources\\mario2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 100, 50);
				p2Logo = new ImageIcon("src\\Resources\\mariologoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("link")) {
				p2ImageA = new ImageIcon("src\\Resources\\link2.png");
				p2ImageB = new ImageIcon("src\\Resources\\link2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 100, 50);
				p2Logo = new ImageIcon("src\\Resources\\linklogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("pacman")) {
				p2ImageA = new ImageIcon("src\\Resources\\pacman2.png");
				p2ImageB = new ImageIcon("src\\Resources\\pacman2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 150, 55);
				p2Logo = new ImageIcon("src\\Resources\\pacmanlogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("megaman")) {
				p2ImageA = new ImageIcon("src\\Resources\\megaman2.png");
				p2ImageB = new ImageIcon("src\\Resources\\megaman2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 160, 50);
				p2Logo = new ImageIcon("src\\Resources\\megamanlogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("kirby")) {
				p2ImageA = new ImageIcon("src\\Resources\\kirby2.png");
				p2ImageB = new ImageIcon("src\\Resources\\kirby2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 100, 40);
				p2Logo = new ImageIcon("src\\Resources\\kirbylogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			}    else if(p2Choice.equals("cuphead")) {
				p2ImageA = new ImageIcon("src\\Resources\\cuphead2.png");
				p2ImageB = new ImageIcon("src\\Resources\\cuphead2b.png");
				logo2 = new JLabel("");
				logo2.setBounds(500, 10, 140, 50);
				p2Logo = new ImageIcon("src\\Resources\\cupheadlogoB.png");
				logo2.setIcon(p2Logo);
				frame.getContentPane().add(logo2);
			} 
		}
	
	//Determine which stage to display based on the Players' choice in the previous screen
	public static void stageChoice() {
		if(stageChoice.equals("forest")) {
			image = new ImageIcon("src\\Resources\\dark forest.png");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("cave")) {
			image = new ImageIcon("src\\Resources\\ice cave.png");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("sunset")) {
			image = new ImageIcon("src\\Resources\\sunset.png");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("waterfall")) {
			image = new ImageIcon("src\\Resources\\waterfall.gif");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("city")) {
			image = new ImageIcon("src\\Resources\\ruined city.gif");
			frame.setContentPane(new JLabel(image));
		}  else if (stageChoice.equals("lab")) {
			image = new ImageIcon("src\\Resources\\secret lab.gif");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("carnival")) {
			image = new ImageIcon("src\\Resources\\carnival.gif");
			frame.setContentPane(new JLabel(image));
		} else if (stageChoice.equals("underworld")) {
			image = new ImageIcon("src\\Resources\\underworld.gif");
			frame.setContentPane(new JLabel(image));
		}
	}

	}
