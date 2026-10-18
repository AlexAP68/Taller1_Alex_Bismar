public class TracMecAeri extends Aeri {

    String nomVehicle;
    private Motor mot;
    private String traccio = "Traccio a motor";

    public TracMecAeri(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari, String medi,
                       Motor m, String vehicle) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari, medi);
        mot = m;
        nomVehicle = vehicle;
    }

    public Motor getmotor() {
        return mot;
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