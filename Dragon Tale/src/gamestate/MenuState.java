package gamestate;

import storage.LoadBackground;
import storage.LoadKeys;
import tilemap.Background;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;

public class MenuState extends GameState {
    private Background bg;
    private int currentChoice = 0;
    private final String[] options = new String[]{"Start", "Help", "Quit"};
    private Color titleColor;
    private Font titleFont;
    private Font font;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        bg = LoadBackground.loadBackground(LoadBackground.MENUBACKGROUND); // load background
        bg.setVector(-0.1, 0);

        titleColor = new Color(128, 0, 0);
        titleFont = new Font("Century Gothic",
                Font.PLAIN,
                28);
        font = new Font("Arial", Font.PLAIN, 12);

    }

    public void init() {
    }

    public void update() {
        bg.update();
    }

    public void draw(Graphics2D g) {
        bg.draw(g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Dragon Tale", 80, 70);
        g.setFont(font);

        for(int i = 0; i < options.length; ++i) {
            if (i == currentChoice) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }

            g.drawString(options[i], 145, 140 + i * 15);
        }

    }

    public void select() {
        if(currentChoice == 0) {
            gsm.setState(GameStateManager.LEVEL1STATE);
        }
        if(currentChoice == 1) {
//            gsm.setState(GameStateManager.HELPSTATE);
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    public void keyPressed(int k) {
        LoadKeys.ChooseOptions(k, this);
    }
    public void keyReleased(int k) {}

    public void setCurrentChoice(int currentChoice) {
        currentChoice = currentChoice;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }
}
