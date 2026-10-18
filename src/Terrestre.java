 abstract class Terrestre extends Transport {

    String nomTipus = "Terrestre";
    String nomMedi;

    public Terrestre(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari, String medi) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari);
        nomMedi = medi;
    }

    public abstract String getnomTipus();
    public abstract String getnomMedi();
}
