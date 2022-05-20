import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SetWindow extends JFrame implements ActionListener{

	JPanel panelButtons, panelPictures;
	
	//user buttons
	JButton rock, paper, scissor;
	
	//WLT counter + CPU & player pick
	JLabel winLossTie, lvCounter, xpCounter;
	JLabel cpuPick, playerPick;
	String cpuText, playerText;
	
	//labels to hold the pictures
	JLabel playerPicLabel, CPUPicLabel;
	JLabel vs;
	
	//image icons to be the pictures
	ImageIcon windowIcon;
	ImageIcon theRock,thePaper,theScissor;
	
	//CPU Icons
	ImageIcon CPURockIcon, CPUPaperIcon, CPUScissorIcon;
	
	//Sound Effects
	File rockSE = new File("res/rockSE.wav");
	File paperSE = new File("res/paperSE.wav");
	File scissorSE = new File("res/scissorSE.wav");
	
	//Visibility Check
	int visibilty = 0;
	//winLossTie counters
	int win = 0, loss = 0, tie = 0;
	int lvlUp = 100, xpValue;
	
	//So variables can be passed to each other
	MainMethod joe = new MainMethod();	

	//progressBar
	JProgressBar xpBar = new JProgressBar(0,100);
	
	//constructor
	SetWindow(String title){

	//Initializes JLabel shiz
	playerPicLabel = new JLabel();
	CPUPicLabel = new JLabel();
	
	//rock picture label settings
	playerPicLabel.setIcon(theRock);
	playerPicLabel.setVisible(false);
	playerPicLabel.setBorder(BorderFactory.createLineBorder(new Color(101,115,126), 5));
	playerPicLabel.setBounds(200,120,256,256);
	//CPU picture label settings
	CPUPicLabel.setIcon(CPURockIcon);
	CPUPicLabel.setVisible(false);
	CPUPicLabel.setBorder(BorderFactory.createLineBorder(new Color(101,115,126), 5));
	CPUPicLabel.setBounds(600,120,256,256);
	
	//basic window settings
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(950,540);
	//this.setIconImage(windowIcon.setImage(null));
	this.setLocationRelativeTo(null);
	this.setTitle(title);
	this.setResizable(false);
	
	//create the button panel
	panelButtons = new JPanel();
	
	//button panel Configure
	panelButtons.setBackground(new Color(52,61,70));
	panelButtons.setBounds(0, 0, 150, 540);
	panelButtons.setLayout(null);
	this.add(panelButtons);
	
	//create Picture Panel
	panelPictures = new JPanel();
	
	//picture panel configure
	panelPictures.setBackground(new Color(79,91,103));
	panelPictures.setBounds(150, 0, 320, 540);
	panelPictures.setLayout(null);
	this.add(panelPictures);
	
	//Adding the picture labels to the picture panel
	panelPictures.add(playerPicLabel);
	panelPictures.add(CPUPicLabel);
	
	//winLossTie to button panel
	winLossTie = new JLabel();
	winLossTie.setText("W: " + win + " L: " + loss + " T: " + tie);
	winLossTie.setFont(new Font("Impact",Font.PLAIN,20));
	winLossTie.setBounds(10, 470, 150, 25);
	winLossTie.setForeground(new Color(193,197,206));
	panelButtons.add(winLossTie);
	
	//Xp & level counters
	xpCounter = new JLabel();
	lvCounter = new JLabel();
	
	xpCounter.setText("XP: " + joe.xp);
	xpCounter.setBounds(10, 10, 100, 25);
	xpCounter.setFont(new Font("Impact", Font.PLAIN, 15));
	xpCounter.setForeground(new Color(0xc1c5ce));
	xpCounter.setVisible(true);
	panelButtons.add(xpCounter);
	
	lvCounter.setText("Level: " + joe.level);
	lvCounter.setBounds(10, 30, 100, 25);
	lvCounter.setFont(new Font("Impact", Font.PLAIN, 15));
	lvCounter.setForeground(new Color(0xc1c5ce));
	lvCounter.setVisible(true);
	panelButtons.add(lvCounter);
	
	
	
	//adding CPU picking Options
	cpuPick = new JLabel();
	cpuPick.setText("CPU Picks: Nothing");
	cpuPick.setBounds(620, 50, 300, 100);
	cpuPick.setVisible(true);
	cpuPick.setFont(new Font("Impact",Font.PLAIN,30));
	panelPictures.add(cpuPick);
	
	//Player Picks
	playerPick = new JLabel();
	playerPick.setText("Player Picks: Nothing");
	playerPick.setBounds(220, 50, 300, 100);
	playerPick.setVisible(true);
	playerPick.setFont(new Font("Impact",Font.PLAIN,30));
	panelPictures.add(playerPick);
	
	
	//Adding VS label
	vs = new JLabel();
	vs.setText("VS");
	vs.setBounds(500, 0, 500, 500);
	vs.setVisible(true);
	vs.setFont(new Font("Impact",Font.ITALIC,50));
	panelPictures.add(vs);
	
	//add the rock button
	rock = new JButton();
	rock.setVisible(true);
	panelButtons.add(rock);
	rock.setBounds(15, 120, 120, 25);
	rock.setText("Rock");
	rock.setFocusable(false);
	rock.setBorder(BorderFactory.createLineBorder(new Color(101,115,126), 3));
	rock.addActionListener(this);
	
	//paper button
	paper = new JButton();
	paper.setVisible(true);
	paper.setBounds(15, 160, 120, 25);
	paper.setText("Paper");
	paper.setFocusable(false);
	paper.setBorder(BorderFactory.createLineBorder(new Color(101,115,126), 3));
	panelButtons.add(paper);
	paper.addActionListener(this);
	
	//scissor button
	scissor = new JButton();
	scissor.setVisible(true);
	scissor.setBounds(15, 200, 120, 25);
	scissor.setText("Scissors");
	scissor.setFocusable(false);
	scissor.setBorder(BorderFactory.createLineBorder(new Color(101,115,126), 3));
	panelButtons.add(scissor);
	scissor.addActionListener(this);
	

	xpBar.setValue(joe.xp);
	xpBar.setBounds(175,440,735, 50);
	xpBar.setVisible(true);
	xpBar.setFont(new Font("Impact", Font.PLAIN, 25));
	xpBar.setStringPainted(true);
	panelPictures.add(xpBar);
	
	// sets window to visible
	this.setVisible(true);
	//this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//changes label pictures
		playerPicLabel.setVisible(true);
		visibilty = 0;
		CPUPicLabel.setVisible(true);
		
		// checks which button is pressed, and executes method based on that
		if(e.getSource() == rock) {
				playerPick.setText("Player Picks: Rock");
				rockCPU();
				playerPicLabel.setIcon(theRock);
				
			
		} 	else if (e.getSource() == paper) {
				playerPick.setText("Player Picks: Paper");
				paperCPU();
				playerPicLabel.setIcon(thePaper);
		}	else if(e.getSource() == scissor ) {
				playerPick.setText("Player Picks: Scissor");
				scissorCPU();
				playerPicLabel.setIcon(theScissor);
			}
		
		//text Sets 
		winLossTie.setText("W: " + win + " L: " + loss + " T: " + tie);
		cpuPick.setText("CPU Picks: " + cpuText);
		xpBar.setValue(xpValue);
		lvCounter.setText("Level: " + joe.level);
	
		//xpBar refilling and emptying
		if (xpBar.getPercentComplete() == 1) {
			lvlUp = (int) (lvlUp * 1.1);
			System.out.println(lvlUp);
			xpBar.setMaximum(lvlUp);
			xpBar.setMinimum(0);
			if (xpValue > lvlUp)
			{
				xpValue = 0;
				xpBar.setValue(xpValue);
				joe.level +=1;
				lvCounter.setText("Level: " + joe.level);
				System.out.println(lvlUp);
			} else {
				xpValue = 0;
				xpBar.setValue(xpValue);
				joe.level +=1;
				lvCounter.setText("Level: " + joe.level);
				System.out.println(lvlUp);
			}
			
		}
		
	}
	
	public void rockCPU() {
		Random rand = new Random();
		int CPU = rand.nextInt(3);
		if (CPU == 0) {
			CPUPicLabel.setIcon(CPURockIcon);
			tie();
			cpuText = "Rock";
		} else if (CPU == 1) {
			CPUPicLabel.setIcon(CPUPaperIcon);
			loss();
			cpuText = "Paper";
		} else if (CPU == 2) {
			CPUPicLabel.setIcon(CPUScissorIcon);
			
			win();
			cpuText = "Scissor";
		}
		
	}
	
	public void paperCPU() {
		Random rand = new Random();
		int CPU = rand.nextInt(3);
		if (CPU == 0) {
			CPUPicLabel.setIcon(CPURockIcon);
			win();
			cpuText = "Rock";
		} else if (CPU == 1) {
			CPUPicLabel.setIcon(CPUPaperIcon);
			tie();
			cpuText = "Paper";
		} else if (CPU == 2) {
			CPUPicLabel.setIcon(CPUScissorIcon);
			loss();
			cpuText = "Scissor";
		}
		
	}
	public void scissorCPU() {
		Random rand = new Random();
		int CPU = rand.nextInt(3);
		if (CPU == 0) {
			CPUPicLabel.setIcon(CPURockIcon);
			loss();
			cpuText = "Rock";
		} else if (CPU == 1) {
			CPUPicLabel.setIcon(CPUPaperIcon);
			win();
			cpuText = "Paper";
		} else if (CPU == 2) {
			CPUPicLabel.setIcon(CPUScissorIcon);
			tie();
			cpuText = "Scissor";
		}
		
	}
	
	//randomized xpBarColor per level
	public void win(){
		++win;
		joe.xp += 10;
		xpValue +=10;
		xpCounter.setText("XP: " + joe.xp);
	}
	public void loss(){
		++loss;

	}
	public void tie(){
		++tie;
		joe.xp += 5;
		xpValue +=5;
		xpCounter.setText("XP: " + joe.xp);
	}

	

}
