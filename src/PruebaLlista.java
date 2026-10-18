public class PruebaLlista {

    public static void main(String[] args) {

        // 1. Crear una lista vacía
        Llista lista = new Llista();

        // 2. Crear motores
        Motor motor1 = new Motor(1200, "Gasolina");
        Motor motor2 = new Motor(2000, "Diesel");

        // 3. Crear vehículos
        Transport coche1 = new TracMec(
                180, 5, "1234ABC", "Pedro",
                "Carretera", motor1, "Opel Corsa"
        );

        Transport coche2 = new TracMec(
                220, 5, "5678DEF", "Juan",
                "Carretera", motor2, "BMW 320"
        );

        Transport bicicleta = new TracNoMec(
                30, 1, "BICI001", "Pedro",
                "Carretera", "Bicicleta"
        );

        Transport bis = new TracMecAeri(
                300, 2, "AVION001", "Ana",
                "Aire", motor1, "Avioneta"
        );

        // 4. Insertar vehículos
        lista.insertar(coche1);
        lista.insertar(coche2);
        lista.insertar(bicicleta);

        // 5. Mostrar todos los vehículos
        System.out.println("=== TODOS LOS VEHICULOS ===");
       // lista.imprimirTodos();

        // 6. Buscar vehículos de Pedro
        System.out.println("\n=== VEHICULOS DE PEDRO ===");
        lista.buscarPorPropietario("Pedro");

        // 7. Buscar por nombre
        System.out.println("\n=== BUSCAR OPEL CORSA ===");
        lista.buscarPorNombre("Opel Corsa");

        // 8. Eliminar el coche de Juan
        System.out.println("\n=== ELIMINAR VEHICULO ===");

        boolean eliminado = lista.eliminar("Juan", "5678DEF");

        if (eliminado) {
            System.out.println("Vehiculo eliminado correctamente.");
        } else {
            System.out.println("Vehiculo no encontrado.");
        }

        // 9. Comprobar la lista después de eliminar
        System.out.println("\n=== LISTA FINAL ===");
      //  lista.imprimirTodos();


        System.out.println("\n=== PRUEBAS ESPECIALES ===");

// Eliminar el primer nodo
        System.out.println("Eliminar primer nodo:");
        System.out.println(lista.eliminar("Pedro", "1234ABC"));
       // lista.imprimirTodos();

// Eliminar un vehículo inexistente
        System.out.println("\nEliminar vehículo inexistente:");
        System.out.println(lista.eliminar("Ana", "9999ZZZ"));

// Eliminar el último vehículo
        System.out.println("\nEliminar último vehículo:");
        System.out.println(lista.eliminar("Pedro", "BICI001"));
       // lista.imprimirTodos();

// Intentar eliminar de una lista vacía
        System.out.println("\nEliminar de lista vacía:");
        System.out.println(lista.eliminar("Pedro", "BICI001"));
    }
}