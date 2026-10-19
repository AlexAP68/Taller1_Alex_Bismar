public abstract class Transport {

   protected int velocitatMaxima;
   protected int numPlaces;
   protected String matricula;
   protected String nomPropietari;

    public Transport(int velocitatMaxima, int numPlaces, String matricula, String nomPropietari) {

        this.velocitatMaxima = velocitatMaxima;
        this.numPlaces = numPlaces;
        this.matricula = matricula;
        this.nomPropietari = nomPropietari;
    }

    public abstract int getvelocitatMaxima();
    public abstract int getnumPlaces();
    public abstract String getPropietari();
    public abstract String getMatricula();
    public abstract String getnomVehicle();
    public abstract String getTraccio();

     @Override
     public String toString() {
         return "Nombre: " + getnomVehicle() + "\n"
                 + "Propietario: " + getPropietari() + "\n"
                 + "Matrícula: " + getMatricula() + "\n"
                 + "Velocidad máxima: " + getvelocitatMaxima() + " km/h\n"
                 + "Número de plazas: " + getnumPlaces() + "\n"
                 + "Tracción: " + getTraccio() + "\n";
     }
}