public class TracNoMec extends Terrestre {

    String nomVehicle;
    private String traccio = "Traccio no mecanica";

    public TracNoMec(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari,
                     String medi, String vehicle) {

        super(velocitatMaxima, numPlaces, matricula, nomPropietari, medi);
        nomVehicle = vehicle;
    }

    public String getTraccio() {
        return traccio;
    }

    public String getnomMedi() {
        return nomMedi;
    }

    public String getnomTipus() {
        return nomTipus;
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



    @Override
    public String toString() {
        return super.toString()
                + "Tipo: Terrestre\n"
                + "Medio de circulación: " + getnomMedi() + "\n";
    }

}
