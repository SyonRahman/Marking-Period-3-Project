public class Miscellaneous {
    private int called;
    private ClickerGame[][] clickerGames;
    private MemoryGame[][] memoryGames;
    private Leaderboard[][] leaderboards;

    public Miscellaneous() {
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

}
