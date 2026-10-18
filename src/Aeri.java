 abstract class Aeri extends Transport {

    String nomTipus = "Aeri";
    String nomMedi;

    public Aeri(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari, String medi) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari);
        nomMedi = medi;
    }

    public abstract String getnomTipus();
    public abstract String getnomMedi();
}