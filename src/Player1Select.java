
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Random;

//This class deals with Player 1's character selection
public class Player1Select extends SpriteShootout{
	//Initialize components and variables to be referred to across methods
	static JLabel selection = new JLabel("");
	final static JButton confirm = new JButton();
	static int randomChoice;
	
	public static void main(String[] args) {

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
		image = new ImageIcon("src\\Resources\\p1choice.png");
		selection.setIcon(image);
		selection.setBounds(-3, 30, 100, 100);
		frame.getContentPane().add(selection);
		//Set the indicator to invisible until the user makes a selection
		selection.setVisible(false);
		
		//Display a prompt that tells the user to select a character
		image = new ImageIcon("src\\Resources\\p1select.png");
		prompt.setIcon(image);
		prompt.setBounds(-3, 30, 900, 67);
		frame.getContentPane().add(prompt);
		
		//Display a button that allows the users to move onto Player 2 selection once they have decided on the first.
		image = new ImageIcon("src\\Resources\\confirm.png");
		confirm.setIcon(image);
		confirm.setBounds(600, 500, 198, 39);
		frame.getContentPane().add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm.setActionCommand("clicked");
				if(confirm.getActionCommand().equals("clicked")){
					frame.setVisible(false);
					Player2Select.initialize();
					
				}
			}
		});
		//Do not let users advance until they have chosen a character.
		confirm.setEnabled(false);
		
		//Create a button that randomly picks a character for the user and then advances onto the next character's selection
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
					case 0: p1Choice = "square"; break;
					case 1: p1Choice = "diamond"; break;
					case 2: p1Choice = "hexagon"; break;
					case 3: p1Choice = "hourglass"; break;
					case 4: p1Choice = "mario"; break;
					case 5: p1Choice = "link"; break;
					case 6: p1Choice = "pacman"; break;
					case 7: p1Choice = "megaman"; break;
					case 8: p1Choice = "kirby"; break;
					case 9: p1Choice = "cuphead"; break;
					}
					Player2Select.initialize();
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
					//Take users back to introductory screen
					SpriteShootout.intro();
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
		image = new ImageIcon("src\\Resources\\square1.png");
		squareIcon.setIcon(image);
		frame.getContentPane().add(squareIcon);
		
		//Indicate the user's selection upon clicking the icon
		squareIcon.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(78, 170, 120, 120);
                selection.setVisible(true);
                p1Choice = "square";
        		confirm.setEnabled(true);
            }

        });
		
		squareLogo = new JLabel("");
		squareLogo.setBounds(60, 275, 130, 40);
		image = new ImageIcon("src\\Resources\\squarelogoA.png");
		squareLogo.setIcon(image);
		frame.getContentPane().add(squareLogo);
		
	}
	
	//display the diamond character's icon and logo
	public static void diamond() {
		JLabel diamondIcon, diamondLogo;
		
		diamondIcon = new JLabel("");
		diamondIcon.setBounds(250, 200, width, height);
		image = new ImageIcon("src\\Resources\\diamond1.png");
		diamondIcon.setIcon(image);
		frame.getContentPane().add(diamondIcon);
		
		//Indicate the user's selection upon clicking the icon
		diamondIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(228, 170, 120, 120);
                selection.setVisible(true);
                p1Choice = "diamond";
                confirm.setEnabled(true);
            }

        });
		
		diamondLogo = new JLabel("");
		diamondLogo.setBounds(210, 270, 135, 47);
		image = new ImageIcon("src\\Resources\\diamondlogoA.png");
		diamondLogo.setIcon(image);
		frame.getContentPane().add(diamondLogo);

	}
	
	//display the hexagon character's icon and logo
	public static void hexagon() {
		JLabel hexaIcon, hexaLogo;
		
		hexaIcon = new JLabel("");
		hexaIcon.setBounds(400, 200, width, height);
		image = new ImageIcon("src\\Resources\\hexa1.png");
		hexaIcon.setIcon(image);
		frame.getContentPane().add(hexaIcon);
		
		//Indicate the user's selection upon clicking the icon
		hexaIcon.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(378, 170, 120, 120);
                selection.setVisible(true);
                p1Choice = "hexagon";
                confirm.setEnabled(true);
            }

        });
		
		hexaLogo = new JLabel("");
		hexaLogo.setBounds(355, 271, 150, 48);
		image = new ImageIcon("src\\Resources\\hexagonlogoA.png");
		hexaLogo.setIcon(image);
		frame.getContentPane().add(hexaLogo);
	}

	//display the hourglass character's icon and logo
	public static void hourglass() {
		JLabel hourIcon, hourLogo;
		
		hourIcon = new JLabel("");
		hourIcon.setBounds(550, 200, width, height);
		image = new ImageIcon("src\\Resources\\hour1.png");
		hourIcon.setIcon(image);
		frame.getContentPane().add(hourIcon);
		
		//Indicate the user's selection upon clicking the icon
		hourIcon.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(528, 170, 120, 120);
                selection.setVisible(true);
                p1Choice = "hourglass";
                confirm.setEnabled(true);
            }
		});
		
		hourLogo = new JLabel("");
		hourLogo.setBounds(500, 270, 170, 50);
		image = new ImageIcon("src\\Resources\\hourglasslogoA.png");
		hourLogo.setIcon(image);
		frame.getContentPane().add(hourLogo);
	}

	//display mario's icon and logo
	public static void mario() {
		JLabel marioIcon, marioLogo;
		
		marioIcon = new JLabel("");
		marioIcon.setBounds(700, 200, width, height);
		image = new ImageIcon("src\\Resources\\mario1.png");
		marioIcon.setIcon(image);
		frame.getContentPane().add(marioIcon);
		
		//Indicate the user's selection upon clicking the icon
		marioIcon.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(678, 170, 120, 120);
                selection.setVisible(true);
                p1Choice = "mario";
                confirm.setEnabled(true);
            }
		});
		
		marioLogo = new JLabel("");
		marioLogo.setBounds(675, 270, 110, 50);
		image = new ImageIcon("src\\Resources\\mariologoA.png");
		marioLogo.setIcon(image);
		frame.getContentPane().add(marioLogo);
	}
	
	//display link's icon and logo
	public static void link() {
		JLabel linkIcon, linkLogo;
		
		linkIcon = new JLabel("");
		linkIcon.setBounds(100, 350, width, height);
		image = new ImageIcon("src\\Resources\\link1.png");
		linkIcon.setIcon(image);
		frame.getContentPane().add(linkIcon);
		
		//Indicate the user's selection upon clicking the icon
		linkIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selection.setBounds(78, 320, 120, 120);
                selection.setVisible(true);
                p1Choice = "link";
                confirm.setEnabled(true);
            }
		});
		
		linkLogo = new JLabel("");
		linkLogo.setBounds(80, 420, 100, 50);
		image = new ImageIcon("src\\Resources\\linklogoA.png");
		linkLogo.setIcon(image);
		frame.getContentPane().add(linkLogo);
		
	}
	
	//display pacman's icon and logo
	public static void pacman() {
		JLabel pacIcon, pacLogo;
		
		pacIcon = new JLabel("");
		pacIcon.setBounds(250, 350, width, height);
		image = new ImageIcon("src\\Resources\\pacman1.png");
		pacIcon.setIcon(image);
		frame.getContentPane().add(pacIcon);
		
		//Indicate the user's selection upon clicking the icon
		pacIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(228, 320, 120, 120);
	                selection.setVisible(true);
	                p1Choice = "pacman";
	                confirm.setEnabled(true);
	            }

	        });
		
		pacLogo = new JLabel("");
		pacLogo.setBounds(210, 416, 150, 55);
		image = new ImageIcon("src\\Resources\\pacmanlogoA.png");
		pacLogo.setIcon(image);
		frame.getContentPane().add(pacLogo);
	}
	
	//display megaman's icon and logo
	public static void megaman() {
		JLabel megaIcon, megaLogo;
		
		megaIcon = new JLabel("");
		megaIcon.setBounds(405, 350, width, height);
		image = new ImageIcon("src\\Resources\\megaman1.png");
		megaIcon.setIcon(image);
		frame.getContentPane().add(megaIcon);
		
		//Indicate the user's selection upon clicking the icon
		megaIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(378, 320, 120, 120);
	                selection.setVisible(true);
	                p1Choice = "megaman";
	                confirm.setEnabled(true);
	            }

	        });
		
		megaLogo = new JLabel("");
		megaLogo.setBounds(350, 420, 160, 50);
		image = new ImageIcon("src\\Resources\\megamanlogoA.png");
		megaLogo.setIcon(image);
		frame.getContentPane().add(megaLogo);
		
	}
	
	//display kirby's icon and logo
	public static void kirby() {
		JLabel kirbyIcon, kirbyLogo;
		
		kirbyIcon = new JLabel("");
		kirbyIcon.setBounds(550, 350, width, height);
		image = new ImageIcon("src\\Resources\\kirby1.png");
		kirbyIcon.setIcon(image);
		frame.getContentPane().add(kirbyIcon);
		
		//Indicate the user's selection upon clicking the icon
		kirbyIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(528, 320, 120, 120);
	                selection.setVisible(true);
	                p1Choice = "kirby";
	                confirm.setEnabled(true);
	            }

	        });
		
		kirbyLogo = new JLabel("");
		kirbyLogo.setBounds(520, 420, 160, 50);
		image = new ImageIcon("src\\Resources\\kirbylogoA.png");
		kirbyLogo.setIcon(image);
		frame.getContentPane().add(kirbyLogo);
	}
	
	//display cuphead's icon and logo
	public static void cuphead() {
		JLabel cupIcon, cupLogo;
		
		cupIcon = new JLabel("");
		cupIcon.setBounds(700, 350, width, height);
		image = new ImageIcon("src\\Resources\\cuphead1.png");
		cupIcon.setIcon(image);
		frame.getContentPane().add(cupIcon);
		
		//Indicate the user's selection upon clicking the icon
		cupIcon.addMouseListener(new MouseAdapter() {
	           @Override
	            public void mouseClicked(MouseEvent e) {
	                selection.setBounds(678, 320, 120, 120);
	                selection.setVisible(true);
	                p1Choice = "cuphead";
	                confirm.setEnabled(true);
	            }

	        });
		
		cupLogo = new JLabel("");
		cupLogo.setBounds(670, 420, 140, 50);
		image = new ImageIcon("src\\Resources\\cupheadlogoA.png");
		cupLogo.setIcon(image);
		frame.getContentPane().add(cupLogo);
	}
	

}
