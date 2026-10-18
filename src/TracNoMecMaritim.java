public class TracNoMecMaritim extends Maritim {

    String nomVehicle;
    private String traccio = "Traccio no mecanica";

    public TracNoMecMaritim(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari, String medi,
                            String vehicle) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari, medi);
        nomVehicle = vehicle;
    }

    public String getTraccio() {
        return traccio;
    }

    public String getnomTipus() {
        return nomTipus;
    }

    public String getnomMedi() {
        return nomMedi;
    }

    public String getnomVehicle() {
        return nomVehicle;
    }

    public int getvelocitatMaxima() {
        return velocitatMaxima;
    }

    public int getnumPlaces() {
        return numPlaces;
    }

    public String getPropietari() {
        return nomPropietari;
    }

    public String getMatricula() {
        return matricula;
    }
}