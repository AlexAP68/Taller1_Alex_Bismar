public interface Interface_llista {

    void insertar(Transport vehiculo);

    boolean eliminar(String propietario, String matricula);

    void buscarPorNombre(String nombreVehiculo);

    void buscarPorPropietario(String propietario);

    void imprimirTodos();
}