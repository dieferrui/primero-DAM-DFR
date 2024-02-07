package multiplication_game;

public class Player {
    
    String name;
    int playerNumber;
    boolean state;

    public Player(String name, int playerNumber) {

        this.name = name;
        this.playerNumber = playerNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
