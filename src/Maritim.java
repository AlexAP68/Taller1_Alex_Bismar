 abstract class Maritim extends Transport {

    String nomTipus = "Maritim";
    String nomMedi;

    public Maritim(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari, String medi) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari);
        nomMedi = medi;
    }

    public abstract String getnomTipus();
    public abstract String getnomMedi();
}
