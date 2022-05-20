import javax.swing.ImageIcon;

public class MainMethod {

	public int xp = 0, level = 0, currency = 0;

	MainMethod(){
		
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		SetWindow window; 
		//this allows for the pictures to be referenced by the class file, instead of the file location
		//and means it can be exported(compiled) properly
		window = new SetWindow("Rock Paper Scissors: XTREME");
		
		//Icons & sound effects
		window.windowIcon = new ImageIcon(MainMethod.class.getResource("testIcon.png"));
		window.setIconImage(window.windowIcon.getImage());
		
		window.theRock = new ImageIcon(MainMethod.class.getResource("Rock256.png"));
		window.thePaper = new ImageIcon(MainMethod.class.getResource("Paper256.png"));
		window.theScissor = new ImageIcon(MainMethod.class.getResource("Scissor256.png"));
		
		window.CPURockIcon = new ImageIcon(MainMethod.class.getResource("CPURock.png"));
		window.CPUPaperIcon = new ImageIcon(MainMethod.class.getResource("CPUPaper.png"));
		window.CPUScissorIcon = new ImageIcon(MainMethod.class.getResource("CPUScissor.png"));
	}	
}