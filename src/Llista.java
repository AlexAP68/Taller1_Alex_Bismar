public class Llista implements Interface_llista {

    private Nodo cabeza;

    public Llista() {
        cabeza = null;
    }

    @Override
    public void insertar(Transport vehiculo) {

        Nodo nuevo = new Nodo(vehiculo);

        if (cabeza == null) {
            cabeza = nuevo;
        }
        else {
            Nodo actual = cabeza;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public boolean eliminar(String propietario, String matricula) {

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getPropietari().equals(propietario)
                    && vehiculo.getMatricula().equals(matricula)) {

                if (anterior == null) {
                    cabeza = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public void buscarPorNombre(String nombreVehiculo) {

        Nodo actual = cabeza;

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getnomVehicle().equals(nombreVehiculo)) {

                System.out.println(vehiculo.getMatricula());

            }

            actual = actual.getSiguiente();
        }
    }

    @Override
    public void buscarPorPropietario(String propietario) {

        Nodo actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getPropietari().equals(propietario)) {

                encontrado = true;

                System.out.println("Nombre: " + vehiculo.getnomVehicle());
                System.out.println("Matricula: " + vehiculo.getMatricula());
                System.out.println("Velocidad maxima: " + vehiculo.getvelocitatMaxima());
                System.out.println("Numero de plazas: " + vehiculo.getnumPlaces());
                System.out.println("Traccion: " + vehiculo.getTraccio());

                if (vehiculo instanceof Terrestre) {
                    System.out.println("Tipo: Terrestre");
                }
                else if (vehiculo instanceof Maritim) {
                    System.out.println("Tipo: Maritimo");
                }
                else if (vehiculo instanceof Aeri) {
                    System.out.println("Tipo: Aereo");
                }

                Motor motor = null;

                if (vehiculo instanceof TracMec) {
                    motor = ((TracMec) vehiculo).getmotor();
                }
                else if (vehiculo instanceof TracMecMaritim) {
                    motor = ((TracMecMaritim) vehiculo).getmotor();
                }
                else if (vehiculo instanceof TracMecAeri) {
                    motor = ((TracMecAeri) vehiculo).getmotor();
                }

                if (motor != null) {
                    System.out.println("Cilindrada: " + motor.getCilindrada());
                    System.out.println("Combustible: " + motor.getCombustible());
                }

                System.out.println("----------------------");
            }

            actual = actual.getSiguiente();
        }

        if (!encontrado) {
            System.out.println("Este propietario no tiene vehiculos registrados.");
        }
    }

    @Override
    public void imprimirTodos() {

        Nodo actual = cabeza;

        if (cabeza == null) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            System.out.println("Nombre: " + vehiculo.getnomVehicle());
            System.out.println("Propietario: " + vehiculo.getPropietari());
            System.out.println("Matrícula: " + vehiculo.getMatricula());
            System.out.println("Velocidad máxima: " + vehiculo.getvelocitatMaxima());
            System.out.println("Número de plazas: " + vehiculo.getnumPlaces());
            System.out.println("Tracción: " + vehiculo.getTraccio());

            if (vehiculo instanceof Terrestre) {
                System.out.println("Tipo: Terrestre");
            }
            else if (vehiculo instanceof Maritim) {
                System.out.println("Tipo: Marítimo");
            }
            else if (vehiculo instanceof Aeri) {
                System.out.println("Tipo: Aéreo");
            }

            Motor motor = null;

            if (vehiculo instanceof TracMec) {
                motor = ((TracMec) vehiculo).getmotor();
            }
            else if (vehiculo instanceof TracMecMaritim) {
                motor = ((TracMecMaritim) vehiculo).getmotor();
            }
            else if (vehiculo instanceof TracMecAeri) {
                motor = ((TracMecAeri) vehiculo).getmotor();
            }

            if (motor != null) {
                System.out.println("Cilindrada: " + motor.getCilindrada());
                System.out.println("Combustible: " + motor.getCombustible());
            }

            System.out.println("--------------------------");

            actual = actual.getSiguiente();
        }
    }
}