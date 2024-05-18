package diego;

public enum Experiencia {
    
    NOVATOS(1, 40), 
    EXPERIMENTADOS(40, 70), 
    VETERANOS(55, 100);
    
    private final int minExp;
    private final int maxExp;

    Experiencia(int minExp, int maxExp) {
        this.minExp = minExp;
        this.maxExp = maxExp;
    }

    public int getMinExp() {
        return minExp;
    }

    public int getMaxExp() {
        return maxExp;
    }
}
