public interface Interface_llista {

    void insertar(Transport vehiculo);

    boolean eliminar(String propietario, String matricula);

    String buscarPorNombre(String nombreVehiculo);

    void buscarPorPropietario(String propietario);

    String imprimirTodos();
}