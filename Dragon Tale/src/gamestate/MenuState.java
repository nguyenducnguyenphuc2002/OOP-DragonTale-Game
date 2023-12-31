package gamestate;

import tilemap.Background;
import ui.LoadBackground;
import ui.LoadKeys;

import java.awt.*;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {"Start","Help", "Quit"};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;

		bg = LoadBackground.loadBackground(LoadBackground.MENUBACKGROUND);
		
		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Century Gothic", 
							Font.PLAIN, 
							28);
		font = new Font("Arial", Font.PLAIN, 12);
	}

	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		bg.update();
		
	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Tale", 80, 70);
		
		// draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 110 + i * 18);
		}
	}

	public void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		} 
		if(currentChoice == 1) {
			// help
			// Set the state to HelpState when "Help" is selected
			gsm.setState(GameStateManager.HELPSTATE);
		} 
		if(currentChoice == 2) {
			System.exit(0);
		} 
	}
	
	@Override
	public void keyPressed(int k) {
		LoadKeys.ChooseOptions(k, this);
		
	}


	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

	public void setCurrentChoice(int currentChoice) {
		this.currentChoice = currentChoice;
	}

	public String[] getOptions() {
		return options;
	}

	public int getCurrentChoice() {
		return currentChoice;
	}
}
