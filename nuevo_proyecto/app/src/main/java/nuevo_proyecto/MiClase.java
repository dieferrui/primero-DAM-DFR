package nuevo_proyecto;

public class MiClase {

    private int num;
    private String txt;
    
    public MiClase(int num, String txt) {
        this.num = num;
        this.txt = txt;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
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
        MiClase other = (MiClase) obj;
        if (num != other.num)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MiClase [num=" + num + ", txt=" + txt + "]";
    }

}
