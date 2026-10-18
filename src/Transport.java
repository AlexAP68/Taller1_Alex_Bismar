 abstract class Transport {

    int velocitatMaxima;
    int numPlaces;
    String matricula;
    String nomPropietari;

    public Transport(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari) {

        this.velocitatMaxima = velocitatMaxima;
        this.numPlaces = numPlaces;
        this.matricula = matricula;
        this.nomPropietari = nomPropietari;
    }

     abstract int getvelocitatMaxima();
     abstract int getnumPlaces();
     abstract String getPropietari();
     abstract String getMatricula();
     public abstract String getnomVehicle();
     public abstract String getTraccio();
}