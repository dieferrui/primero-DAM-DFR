package programas_java.multiplication_game;

public class Player {
    
    String name;
    int playerNumber;
    boolean state;
    int lives;

    public Player(String name, int playerNumber) {

        this.name = name;
        this.playerNumber = playerNumber;
    }

    public Player(String name, int playerNumber, int lives) {

        this.name = name;
        this.playerNumber = playerNumber;
        this.lives = lives;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + playerNumber;
        result = prime * result + (state ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (playerNumber != other.playerNumber)
            return false;
        return (state != other.state);
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", playerNumber=" + playerNumber + "]";
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}
