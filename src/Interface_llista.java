
public interface Interface_llista {

    // Insertar un vehículo en la lista
    void insertar(Transport vehiculo);

    // Eliminar un vehículo por propietario y matrícula
    boolean eliminar(String propietario, String matricula);

    // Buscar vehículos por nombre
    Transport[] buscarPorNombre(String nombreVehiculo);

    // Buscar vehículos por propietario
    Transport[] buscarPorPropietario(String propietario);

    // Obtener todos los vehículos registrados
    Transport[] obtenerTodos();
}
