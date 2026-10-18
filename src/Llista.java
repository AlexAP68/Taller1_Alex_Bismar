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
    public String buscarPorNombre(String nombreVehiculo) {

        StringBuilder resultado = new StringBuilder();

        Nodo actual = cabeza;
        int encontrados = 0;

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            if (vehiculo.getnomVehicle().equalsIgnoreCase(nombreVehiculo)) {

                resultado.append(vehiculo.getMatricula()).append("\n");
                encontrados++;
            }

            actual = actual.getSiguiente();
        }

        if (encontrados == 0) {
            return "No se encontraron vehículos con ese nombre.";
        }

        return "Matrículas de " + nombreVehiculo + ":\n\n"
                + resultado.toString();
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

    public String imprimirTodos() {

        StringBuilder resultado = new StringBuilder();

        Nodo actual = cabeza;

        if (actual == null) {
            return "No hay vehículos registrados.";
        }

        while (actual != null) {

            Transport vehiculo = actual.getDato();

            resultado.append("Nombre: ")
                    .append(vehiculo.getnomVehicle()).append("\n");

            resultado.append("Propietario: ")
                    .append(vehiculo.getPropietari()).append("\n");

            resultado.append("Matrícula: ")
                    .append(vehiculo.getMatricula()).append("\n");

            resultado.append("Velocidad máxima: ")
                    .append(vehiculo.getvelocitatMaxima()).append("\n");

            resultado.append("Número de plazas: ")
                    .append(vehiculo.getnumPlaces()).append("\n");

            resultado.append("Tracción: ")
                    .append(vehiculo.getTraccio()).append("\n");

            if (vehiculo instanceof Terrestre) {
                resultado.append("Tipo: Terrestre\n");
            } else if (vehiculo instanceof Maritim) {
                resultado.append("Tipo: Marítimo\n");
            } else if (vehiculo instanceof Aeri) {
                resultado.append("Tipo: Aéreo\n");
            }

            Motor motor = null;

            if (vehiculo instanceof TracMec) {
                motor = ((TracMec) vehiculo).getmotor();
            } else if (vehiculo instanceof TracMecMaritim) {
                motor = ((TracMecMaritim) vehiculo).getmotor();
            } else if (vehiculo instanceof TracMecAeri) {
                motor = ((TracMecAeri) vehiculo).getmotor();
            }

            if (motor != null) {
                resultado.append("Cilindrada: ")
                        .append(motor.getCilindrada()).append("\n");

                resultado.append("Combustible: ")
                        .append(motor.getCombustible()).append("\n");
            }

            resultado.append("--------------------------\n\n");

            actual = actual.getSiguiente();
        }

        return resultado.toString();
    }
}