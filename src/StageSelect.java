import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Random;

//This class deals with the stage selection
public class StageSelect extends SpriteShootout {
	//Initialize components and variables to be used across methods
	static JLabel selection = new JLabel();
	static int randomChoice;
	static final JButton letsPlay = new JButton();
	
	public static void main(String[] args) {
	}

		//Set up the stage selection screen
		public static void initialize() {
			//initialize components needed for the screen
			JLabel prompt = new JLabel();
			final JButton random = new JButton();
			final JButton back = new JButton();
			
			//Format the frame to fit the requirements of the stage selection screen
			frame.pack();
			frame.getContentPane().requestFocusInWindow();
			frame.setBounds(frame.getX(), frame.getY(), 900, 700);
			frame.setVisible(true);
			image = new ImageIcon("src\\Resources\\background.png");
			frame.setContentPane(new JLabel(image));
			
			//Create a label that displays the screen's selection prompt
			image = new ImageIcon("src\\Resources\\stage select.png");
			prompt.setIcon(image);
			prompt.setBounds(100, 30, 669, 67);
			frame.getContentPane().add(prompt);
			
			//Create a button that allows the user to head to the game once they have picked a stage
			image = new ImageIcon("src\\Resources\\letsplay.png");
			letsPlay.setIcon(image);
			letsPlay.setBounds(600, 600, 213, 39);
			frame.getContentPane().add(letsPlay);
			letsPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					letsPlay.setActionCommand("clicked");
					if(letsPlay.getActionCommand().equals("clicked")){
						frame.setVisible(false);
						SpriteShootout.gameScreen();
						
					}
				}
			});
			//Disable this button until a stage has been chosen
			letsPlay.setEnabled(false);
			
			//Create a button that randomly chooses a stage
			image = new ImageIcon("src\\Resources\\random.png");
			random.setIcon(image);
			random.setBounds(100, 600, 144, 39);
			frame.getContentPane().add(random);
			random.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					random.setActionCommand("clicked");
					if(random.getActionCommand().equals("clicked")){
						//Use a randomizer to select an integer corresponding to one of the stages
						Random rand = new Random();
						randomChoice = rand.nextInt(7);
						switch(randomChoice) {
						case 0: stageChoice = "forest"; break;
						case 1: stageChoice = "cave"; break;
						case 2: stageChoice = "sunset"; break;
						case 3: stageChoice = "waterfall"; break;
						case 4: stageChoice = "city"; break;
						case 5: stageChoice = "lab"; break;
						case 6: stageChoice = "carnival"; break;
						case 7: stageChoice = "underworld"; break;
						}
						frame.setVisible(false);
						SpriteShootout.gameScreen();
					}
				}
			});
			
			//Create a button that allows the user to go to the previous screen
			image = new ImageIcon("src\\Resources\\back.png");
			back.setIcon(image);
			back.setBounds(400, 600, 97, 39);
			frame.getContentPane().add(back);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					back.setActionCommand("clicked");
					if(back.getActionCommand().equals("clicked")){
						frame.setVisible(false);
						//Take users back to the Player 2 selection
						Player2Select.initialize();
					}
				}
			});
			
			//Create a label that acts as an indicator of the user's chosen stage
		image = new ImageIcon("src\\Resources\\check.png");
		selection.setIcon(image);
		selection.setBounds(100, 100, 100, 80);
		frame.getContentPane().add(selection);
		selection.setVisible(false);
		
		//Display icons and logos for each of the stages
		forest();
		cave();
		sunset();
		waterfall();
		city();
		lab();
		carnival();
		underworld();
		
		}
		
		//Display the forest stage's icon and logo
		public static void forest() {
			JLabel forestIcon, forestLogo;
			
			forestIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\miniforest.png");
			forestIcon.setIcon(image);
			forestIcon.setBounds(78, 170, 170, 120);
			frame.getContentPane().add(forestIcon);
			
			forestIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(115, 170, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "forest";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			forestLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\forestlogo.png");
			forestLogo.setIcon(image);
			forestLogo.setBounds(70, 290, 190, 35);
			frame.getContentPane().add(forestLogo);			
			
		}
		
		//Display the cave stage's icon and logo
		public static void cave() {
			
			JLabel caveIcon, caveLogo;
			
			caveIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\minicave.png");
			caveIcon.setIcon(image);
			caveIcon.setBounds(278, 170, 170, 120);
			frame.getContentPane().add(caveIcon);
			
			caveIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(315, 170, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "cave";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			caveLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\cavelogo.png");
			caveLogo.setIcon(image);
			caveLogo.setBounds(290, 290, 140, 35);
			frame.getContentPane().add(caveLogo);
			
		}

		//Display the sunset stage's icon and logo
		public static void sunset() {
			
			JLabel sunsetIcon, sunsetLogo;
			
			sunsetIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\minisunset.png");
			sunsetIcon.setIcon(image);
			sunsetIcon.setBounds(478, 170, 170, 120);
			frame.getContentPane().add(sunsetIcon);
			
			sunsetIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(515, 170, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "sunset";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			sunsetLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\sunsetlogo.png");
			sunsetLogo.setIcon(image);
			sunsetLogo.setBounds(500, 290, 140, 35);
			frame.getContentPane().add(sunsetLogo);
			
		}

		//Display the waterfall stage's icon and logo
		public static void waterfall() {
			
			JLabel waterfallIcon, waterfallLogo;
			
			waterfallIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\miniwaterfall.png");
			waterfallIcon.setIcon(image);
			waterfallIcon.setBounds(678, 170, 170, 120);
			frame.getContentPane().add(waterfallIcon);
			
			waterfallIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(715, 170, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "waterfall";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			waterfallLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\waterfalllogo.png");
			waterfallLogo.setIcon(image);
			waterfallLogo.setBounds(675, 290, 180, 35);
			frame.getContentPane().add(waterfallLogo);
			
		}

		//Display the city stage's icon and logo
		public static void city() {
			JLabel cityIcon, cityLogo;
			
			cityIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\minicity.png");
			cityIcon.setIcon(image);
			cityIcon.setBounds(78, 370, 170, 120);
			frame.getContentPane().add(cityIcon);
			
			cityIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(115, 370, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "city";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			cityLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\citylogo.png");
			cityLogo.setIcon(image);
			cityLogo.setBounds(70, 490, 180, 35);
			frame.getContentPane().add(cityLogo);
		}

		//Display the lab stage's icon and logo
		public static void lab() {
			JLabel labIcon, labLogo;
			
			labIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\minilab.png");
			labIcon.setIcon(image);
			labIcon.setBounds(278, 370, 170, 120);
			frame.getContentPane().add(labIcon);
			
			labIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(315, 370, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "lab";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			labLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\lablogo.png");
			labLogo.setIcon(image);
			labLogo.setBounds(276, 490, 170, 35);
			frame.getContentPane().add(labLogo);
			
		}

		//Display the carnival stage's icon and logo
		public static void carnival() {
			JLabel carnivalIcon, carnivalLogo;
			
			carnivalIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\minicarnival.png");
			carnivalIcon.setIcon(image);
			carnivalIcon.setBounds(478, 370, 170, 120);
			frame.getContentPane().add(carnivalIcon);
			
			carnivalIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(515, 370, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "carnival";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			carnivalLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\carnivallogo.png");
			carnivalLogo.setIcon(image);
			carnivalLogo.setBounds(490, 490, 150, 35);
			frame.getContentPane().add(carnivalLogo);
			
		}

		//Display the underworld stage's icon and logo
		public static void underworld() {
			
			JLabel underworldIcon, underworldLogo;
			
			underworldIcon = new JLabel("");
			image = new ImageIcon("src\\Resources\\miniunderworld.png");
			underworldIcon.setIcon(image);
			underworldIcon.setBounds(678, 370, 170, 120);
			frame.getContentPane().add(underworldIcon);
			
			underworldIcon.addMouseListener(new MouseAdapter() {
		           @Override
		            public void mouseClicked(MouseEvent e) {
		        	   //Indicate the user's selection of the stage when the label is clicked
		                selection.setBounds(715, 370, 120, 120);
		                selection.setVisible(true);
		                stageChoice = "underworld";
		                //enable the user to confirm their selection
		        		letsPlay.setEnabled(true);
		            }

		        });
			
			underworldLogo = new JLabel("");
			image = new ImageIcon("src\\Resources\\underworldlogo.png");
			underworldLogo.setIcon(image);
			underworldLogo.setBounds(668, 490, 190, 35);
			frame.getContentPane().add(underworldLogo);
			
		}
		
}
