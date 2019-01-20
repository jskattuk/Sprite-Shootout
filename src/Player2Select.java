import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Random;

//This class deals with Player 2's character selection
public class Player2Select extends SpriteShootout{
	//Initialize components and variables to be referred to across methods
	static JLabel selection = new JLabel("");
	final static JButton confirm = new JButton();
	static int randomChoice;
	
	public static void main(String[] args) {
		initialize();

	}
	public static void initialize() {
		//Declare components to be stored in the JFrame
		JLabel prompt = new JLabel();
		final JButton random = new JButton();
		final JButton back = new JButton();
		
		//Set up the layout of the JFrame, including background, position, size, etc.
		frame.pack();
		frame.getContentPane().requestFocusInWindow();
		frame.setBounds(frame.getX(), frame.getY(), 900, 600);
		frame.setVisible(true);
		image = new ImageIcon("src\\Resources\\background.png");
		frame.setContentPane(new JLabel(image));
		
		//Create a label that indicates to the user which character they have chosen
		image = new ImageIcon("src\\Resources\\p2choice.png");
		selection.setIcon(image);
		selection.setBounds(-3, 30, 100, 100);
		frame.getContentPane().add(selection);
		//Set the indicator to invisible until the user makes a selection
		selection.setVisible(false);
		
		//Display a prompt that tells the user to select a character
		image = new ImageIcon("src\\Resources\\p2select.png");
		prompt.setIcon(image);
		prompt.setBounds(-3, 30, 900, 65);
		frame.getContentPane().add(prompt);
		
		//Display a button that allows the users to move onto Stage selection once they have decided on their character.
		image = new ImageIcon("src\\Resources\\confirm.png");
		confirm.setIcon(image);
		confirm.setBounds(600, 500, 198, 39);
		frame.getContentPane().add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm.setActionCommand("clicked");
				if(confirm.getActionCommand().equals("clicked")){
					frame.setVisible(false);
					StageSelect.initialize();
				}
			}
		});
		//Do not let users advance until they have chosen a character.
		confirm.setEnabled(false);
		
		//Create a button that randomly picks a character for the user and then advances onto the stage selection
		image = new ImageIcon("src\\Resources\\random.png");
		random.setIcon(image);
		random.setBounds(100, 500, 144, 39);
		frame.getContentPane().add(random);
		random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random.setActionCommand("clicked");
				if(random.getActionCommand().equals("clicked")){
					//Use a randomizer to select an integer corresponding to one of the characters
					Random rand = new Random();
					randomChoice = rand.nextInt(9);
					switch(randomChoice) {
					case 0: p2Choice = "square"; break;
					case 1: p2Choice = "diamond"; break;
					case 2: p2Choice = "hexagon"; break;
					case 3: p2Choice = "hourglass"; break;
					case 4: p2Choice = "mario"; break;
					case 5: p2Choice = "link"; break;
					case 6: p2Choice = "pacman"; break;
					case 7: p2Choice = "megaman"; break;
					case 8: p2Choice = "kirby"; break;
					case 9: p2Choice = "cuphead"; break;
					}
					StageSelect.initialize();
				}
			}
		});
		
		//Create a button that allows the user to go back to the previous screen
		image = new ImageIcon("src\\Resources\\back.png");
		back.setIcon(image);
		back.setBounds(400, 500, 97, 39);
		frame.getContentPane().add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				back.setActionCommand("clicked");
				if(back.getActionCommand().equals("clicked")){
					frame.setVisible(false);
					//Take users back to the Player 1 selection
					Player1Select.initialize();
				}
			}
		});
		
		//Display icons and logos for each of the characters
		square();
		diamond();
		hexagon();
		hourglass();
		mario();
		link();
		pacman();
		megaman();
		kirby();
		cuphead();
	}
	
	//display the square character's icon and logo
	public static void square() {
		JLabel squareIcon, squareLogo;
		
		squareIcon = new JLabel("");
		squareIcon.setBounds(100, 200, width, height);
		image = new ImageIcon("src\\Resources\\square2.png");
		squareIcon.setIcon(image);
		frame.getContentPane().add(squareIcon);
		
		//Indicate the user's selection upon clicking the icon
		squareIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(78, 170, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "square";
	        		confirm.setEnabled(true);
	            }

	        });
			
			squareLogo = new JLabel("");
			squareLogo.setBounds(60, 275, 130, 40);
			image = new ImageIcon("src\\Resources\\squarelogoB.png");
			squareLogo.setIcon(image);
			frame.getContentPane().add(squareLogo);
			
	}
	
	//display the diamond character's icon and logo
	public static void diamond() {
		JLabel diamondIcon, diamondLogo;
		
		diamondIcon = new JLabel("");
		diamondIcon.setBounds(250, 200, width, height);
		image = new ImageIcon("src\\Resources\\diamond2.png");
		diamondIcon.setIcon(image);
		frame.getContentPane().add(diamondIcon);
		
		//Indicate the user's selection upon clicking the icon
		diamondIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(228, 170, 120, 120);
                selection.setVisible(true);
                p2Choice = "diamond";
                confirm.setEnabled(true);
            }

        });
		
		diamondLogo = new JLabel("");
		diamondLogo.setBounds(210, 270, 135, 47);
		image = new ImageIcon("src\\Resources\\diamondlogoB.png");
		diamondLogo.setIcon(image);
		frame.getContentPane().add(diamondLogo);
	}
	
	//display the hexagon character's icon and logo
	public static void hexagon() {
		JLabel hexaIcon, hexaLogo;
		
		hexaIcon = new JLabel("");
		hexaIcon.setBounds(400, 200, width, height);
		image = new ImageIcon("src\\Resources\\hexa2.png");
		hexaIcon.setIcon(image);
		frame.getContentPane().add(hexaIcon);
		
		//Indicate the user's selection upon clicking the icon
		hexaIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(378, 170, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "hexagon";
	                confirm.setEnabled(true);
	            }

	        });
			
			hexaLogo = new JLabel("");
			hexaLogo.setBounds(355, 271, 150, 48);
			image = new ImageIcon("src\\Resources\\hexagonlogoB.png");
			hexaLogo.setIcon(image);
			frame.getContentPane().add(hexaLogo);
	}

	//display the hourglass character's icon and logo
	public static void hourglass() {
		JLabel hourIcon, hourLogo;
		
		hourIcon = new JLabel("");
		hourIcon.setBounds(550, 200, width, height);
		image = new ImageIcon("src\\Resources\\hour2.png");
		hourIcon.setIcon(image);
		frame.getContentPane().add(hourIcon);
		
		//Indicate the user's selection upon clicking the icon
		hourIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(528, 170, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "hourglass";
	                confirm.setEnabled(true);
	            }
			});
			
			hourLogo = new JLabel("");
			hourLogo.setBounds(500, 270, 170, 50);
			image = new ImageIcon("src\\Resources\\hourglasslogoB.png");
			hourLogo.setIcon(image);
			frame.getContentPane().add(hourLogo);
	}

	//display mario's icon and logo
	public static void mario() {
		JLabel marioIcon, marioLogo;
		
		marioIcon = new JLabel("");
		marioIcon.setBounds(700, 200, width, height);
		image = new ImageIcon("src\\Resources\\mario2.png");
		marioIcon.setIcon(image);
		frame.getContentPane().add(marioIcon);
		
		//Indicate the user's selection upon clicking the icon
		marioIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(678, 170, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "mario";
	                confirm.setEnabled(true);
	            }
			});
			
			marioLogo = new JLabel("");
			marioLogo.setBounds(675, 270, 100, 50);
			image = new ImageIcon("src\\Resources\\mariologoB.png");
			marioLogo.setIcon(image);
			frame.getContentPane().add(marioLogo);
		
	}
	
	//display link's icon and logo
	public static void link() {
		JLabel linkIcon, linkLogo;
		
		linkIcon = new JLabel("");
		linkIcon.setBounds(100, 350, width, height);
		image = new ImageIcon("src\\Resources\\link2.png");
		linkIcon.setIcon(image);
		frame.getContentPane().add(linkIcon);
		
		//Indicate the user's selection upon clicking the icon
		linkIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(78, 320, 120, 120);
                selection.setVisible(true);
                p2Choice = "link";
                confirm.setEnabled(true);
            }
		});
		
		linkLogo = new JLabel("");
		linkLogo.setBounds(80, 420, 100, 50);
		image = new ImageIcon("src\\Resources\\linklogoB.png");
		linkLogo.setIcon(image);
		frame.getContentPane().add(linkLogo);
	}
	
	//display pacman's icon and logo
	public static void pacman() {
		JLabel pacIcon, pacLogo;
		
		pacIcon = new JLabel("");
		pacIcon.setBounds(250, 350, width, height);
		image = new ImageIcon("src\\Resources\\pacman2.png");
		pacIcon.setIcon(image);
		frame.getContentPane().add(pacIcon);
		
		//Indicate the user's selection upon clicking the icon
		pacIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(228, 320, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "pacman";
	                confirm.setEnabled(true);
	            }

	        });
		
		pacLogo = new JLabel("");
		pacLogo.setBounds(210, 416, 150, 55);
		image = new ImageIcon("src\\Resources\\pacmanlogoB.png");
		pacLogo.setIcon(image);
		frame.getContentPane().add(pacLogo);
	}
	
	//display megaman's icon and logo
	public static void megaman() {
		JLabel megaIcon, megaLogo;
		
		megaIcon = new JLabel("");
		megaIcon.setBounds(390, 350, width, height);
		image = new ImageIcon("src\\Resources\\megaman2.png");
		megaIcon.setIcon(image);
		frame.getContentPane().add(megaIcon);
		
		//Indicate the user's selection upon clicking the icon
		megaIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(378, 320, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "megaman";
	                confirm.setEnabled(true);
	            }

	        });
		
		megaLogo = new JLabel("");
		megaLogo.setBounds(350, 420, 160, 50);
		image = new ImageIcon("src\\Resources\\megamanlogoB.png");
		megaLogo.setIcon(image);
		frame.getContentPane().add(megaLogo);
	}
	
	//display kirby's icon and logo
	public static void kirby() {
		JLabel kirbyIcon, kirbyLogo;
		
		kirbyIcon = new JLabel("");
		kirbyIcon.setBounds(550, 350, width, height);
		image = new ImageIcon("src\\Resources\\kirby2.png");
		kirbyIcon.setIcon(image);
		frame.getContentPane().add(kirbyIcon);
		
		//Indicate the user's selection upon clicking the icon
		kirbyIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(528, 320, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "kirby";
	                confirm.setEnabled(true);
	            }

	        });
		
		kirbyLogo = new JLabel("");
		kirbyLogo.setBounds(530, 420, 100, 40);
		image = new ImageIcon("src\\Resources\\kirbylogoB.png");
		kirbyLogo.setIcon(image);
		frame.getContentPane().add(kirbyLogo);
	}
	
	//display cuphead's icon and logo
	public static void cuphead() {
		JLabel cupIcon, cupLogo;
		
		cupIcon = new JLabel("");
		cupIcon.setBounds(700, 350, width, height);
		image = new ImageIcon("src\\Resources\\cuphead2.png");
		cupIcon.setIcon(image);
		frame.getContentPane().add(cupIcon);
		
		//Indicate the user's selection upon clicking the icon
		cupIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(678, 320, 120, 120);
	                selection.setVisible(true);
	                p2Choice = "cuphead";
	                confirm.setEnabled(true);
	            }

	        });
		
		cupLogo = new JLabel("");
		cupLogo.setBounds(665, 420, 140, 50);
		image = new ImageIcon("src\\Resources\\cupheadlogoB.png");
		cupLogo.setIcon(image);
		frame.getContentPane().add(cupLogo);
	}

}
