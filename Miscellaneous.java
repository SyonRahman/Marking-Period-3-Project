import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class Miscellaneous extends RoundButton {
    private int called;
    private ClickerGame[][] clickerGames;
    private MemoryGame[][] memoryGames;
    private Leaderboard[][] leaderboards;


    public Miscellaneous(Color color1, Color color2) {
        super(color1, color2);
        clickerGames = new ClickerGame[10][10];
        memoryGames = new MemoryGame[10][10];
        leaderboards = new Leaderboard[10][10];
    }

    public void createClickerGames() {
        for (int r = 0; r < clickerGames.length; r++) {
            for (int c = 0; c < clickerGames[0].length; c++) {
                clickerGames[r][c] = new ClickerGame();
            }
        }
    }

    public void createMemoryGames() {
        for (int c = 0; c < memoryGames[0].length; c++) {
            for (int r = 0; r < memoryGames.length; r++) {
                memoryGames[r][c] = new MemoryGame();
            }
        }
    }

    public void addcalled() {
        for (ClickerGame[] games : clickerGames) {
            for (ClickerGame game : games) {
                called++;
            }
        }
    }

    public void createButtons() {
        paintComponent(getGraphics());
        JButton[][] buttons = new JButton[10][10];
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                buttons[r][c] = new RoundButton(Color.BLACK, Color.WHITE);
                buttonList.add(buttons[r][c]);
            }
        }
        JButton buttonreplacer = new RoundButton(Color.BLACK, Color.WHITE);
        buttons[5][5] = buttonreplacer;
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[0].length; c++) {
                buttons[r][c].setFocusPainted(true);
                buttons[r][c].setBorderPainted(true);
                buttons[r][c].setOpaque(true);
                buttons[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    public String toString() {
        return "Miscelleanous";
    }

}
