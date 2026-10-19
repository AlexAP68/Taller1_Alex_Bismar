
public class Llista implements Interface_llista {

    // Variables
    private Nodo cabeza;

    // CONSTRUCTOR
    public Llista() {
        cabeza = null;
    }

    // Insertamos vehiculo al final de la lista


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

    // Eliminamos un vehiculo por propietario y matricula

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
                }
                else {
                    anterior.setSiguiente(actual.getSiguiente());
                }

                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }


    // Buscamos vehiculos por nombre


    @Override
    public Transport[] buscarPorNombre(String nombreVehiculo) {

        int cantidad = 0;
        Nodo actual = cabeza;

        // Contamos cuantos vehículos coinciden con el nombre
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getnomVehicle()
                    .equalsIgnoreCase(nombreVehiculo)) {

                cantidad++;
            }

            actual = actual.getSiguiente();
        }

        // Creamos un array con el tamaño necesario
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        //Buscamos los vehículos que coinciden con el nombre y los guardamos en el array
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getnomVehicle()
                    .equalsIgnoreCase(nombreVehiculo)) {

                resultado[i] = vehiculo;
                i++;
            }

            actual = actual.getSiguiente();
        }

        return resultado;
    }


    // Buscamos vehiculos por propietario


    @Override
    public Transport[] buscarPorPropietario(String propietario) {

        int cantidad = 0;
        Nodo actual = cabeza;

        // Contamos cuantos vehículos coinciden con el propietario
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getPropietari()
                    .equalsIgnoreCase(propietario)) {

                cantidad++;
            }

            actual = actual.getSiguiente();
        }

        // Creamos un array con el tamaño necesario
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        // Buscamos los vehículos que coinciden con el propietario y los guardamos en el array
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getPropietari()
                    .equalsIgnoreCase(propietario)) {

                resultado[i] = vehiculo;
                i++;
            }

            actual = actual.getSiguiente();
        }

        return resultado;
    }


    // Obtenemos todos los vehiculos registrados


    @Override
    public Transport[] obtenerTodos() {

        int cantidad = 0;
        Nodo actual = cabeza;

        // Contamos cuantos vehículos hay en la lista
        while (actual != null) {
            cantidad++;
            actual = actual.getSiguiente();
        }

        // Creamos un array con el tamaño necesario
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        // Guardamos todos los vehículos en el array
        while (actual != null) {

            resultado[i] = actual.getDato();

            i++;
            actual = actual.getSiguiente();
        }

        return resultado;
    }
}
