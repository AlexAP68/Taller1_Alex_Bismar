public class Motor {

    private int cilindrada;
    private String tipusCombustible;

    public Motor(int c, String combustible) {
        cilindrada = c;
        tipusCombustible = combustible;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public String getCombustible() {
        return tipusCombustible;
    }
}