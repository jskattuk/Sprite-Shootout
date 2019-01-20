import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

//This class deals with displaying the final results of the game
public class Results extends SpriteShootout{
	
	public static void main(String[] args) {
		initialize();
	}
	
	public static void initialize() {
		//Initialize variables and components to be used in the JFrame
		JLabel prompt = new JLabel("");
		JLabel winnerIcon = new JLabel("");
		final JButton playAgain = new JButton();
		final JButton menuScreen = new JButton();
		final JButton quit = new JButton();
		
		//Set up the layout of the JFrame to accommodate the results screen
		frame.pack();
		frame.getContentPane().requestFocusInWindow();
		frame.setBounds(frame.getX(), frame.getY(), 900, 700);
		frame.setVisible(true);
		image = new ImageIcon("src\\Resources\\background.png");
		frame.setContentPane(new JLabel(image));
		
		//Add a prompt to the frame that announces the winner of the game
		image = new ImageIcon("src\\Resources\\winnerprompt.png");
		prompt.setIcon(image);
		prompt.setBounds(150, 30, 640, 60);
		frame.getContentPane().add(prompt);
		
		//Determine the icon and logo of the winner and display both in the frame
		if(healthWidth1 < healthWidth2) {
			winnerIcon.setIcon(p2ImageA);
			logo2.setBounds(355, 180, 300, 200);
			frame.getContentPane().add(logo2);
		} else {
			winnerIcon.setIcon(p1ImageA);
			logo1.setBounds(355, 180, 300, 200);
			frame.getContentPane().add(logo1);
		}
		winnerIcon.setBounds(390, 180, width, height);
		frame.getContentPane().add(winnerIcon);
		
		//Create a button that allows users to immediately play the game again
		image = new ImageIcon("src\\Resources\\playagain.png");
		playAgain.setIcon(image);
		playAgain.setBounds(300, 350, 233, 39);
		frame.getContentPane().add(playAgain);
		playAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playAgain.setActionCommand("clicked");
				if(playAgain.getActionCommand().equals("clicked")){
					//take the players back to the game screen to play once more
					frame.setVisible(false);
					SpriteShootout.gameScreen();
				}
			}
		});
		
		//Create a button that allows users to return to the game's main menu
		image = new ImageIcon("src\\Resources\\mainmenu.png");
		menuScreen.setIcon(image);
		menuScreen.setBounds(250, 400, 312, 39);
		frame.getContentPane().add(menuScreen);
		menuScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuScreen.setActionCommand("clicked");
				if(menuScreen.getActionCommand().equals("clicked")){
					//take the players back to game's main menu
					frame.setVisible(false);
					SpriteShootout.intro();
				}
			}
		});
		
		//Create a button that allows the user to exit the application when clicked
		image = new ImageIcon("src\\Resources\\quit.png");
		quit.setIcon(image);
		quit.setBounds(353, 450, 110, 39);
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
}
