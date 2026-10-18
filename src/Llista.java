
public class Llista implements Interface_llista {

    // ATRIBUTOS
    private Nodo cabeza;

    // CONSTRUCTOR
    public Llista() {
        cabeza = null;
    }

    // =====================================
    // INSERTAR VEHICULO
    // =====================================

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

    // =====================================
    // ELIMINAR VEHICULO
    // =====================================

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

    // =====================================
    // BUSCAR POR NOMBRE
    // =====================================

    @Override
    public Transport[] buscarPorNombre(String nombreVehiculo) {

        int cantidad = 0;
        Nodo actual = cabeza;

        // PRIMER RECORRIDO: CONTAR COINCIDENCIAS
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getnomVehicle()
                    .equalsIgnoreCase(nombreVehiculo)) {

                cantidad++;
            }

            actual = actual.getSiguiente();
        }

        // CREAR ARRAY CON EL TAMAÑO NECESARIO
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        // SEGUNDO RECORRIDO: GUARDAR VEHICULOS
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

    // =====================================
    // BUSCAR POR PROPIETARIO
    // =====================================

    @Override
    public Transport[] buscarPorPropietario(String propietario) {

        int cantidad = 0;
        Nodo actual = cabeza;

        // PRIMER RECORRIDO: CONTAR COINCIDENCIAS
        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getPropietari()
                    .equalsIgnoreCase(propietario)) {

                cantidad++;
            }

            actual = actual.getSiguiente();
        }

        // CREAR ARRAY CON EL TAMAÑO NECESARIO
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        // SEGUNDO RECORRIDO: GUARDAR VEHICULOS
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

    // =====================================
    // OBTENER TODOS LOS VEHICULOS
    // =====================================

    @Override
    public Transport[] obtenerTodos() {

        int cantidad = 0;
        Nodo actual = cabeza;

        // PRIMER RECORRIDO: CONTAR VEHICULOS
        while (actual != null) {
            cantidad++;
            actual = actual.getSiguiente();
        }

        // CREAR ARRAY
        Transport[] resultado = new Transport[cantidad];

        int i = 0;
        actual = cabeza;

        // SEGUNDO RECORRIDO: GUARDAR VEHICULOS
        while (actual != null) {

            resultado[i] = actual.getDato();

            i++;
            actual = actual.getSiguiente();
        }

        return resultado;
    }
}
