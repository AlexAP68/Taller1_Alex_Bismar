import javax.swing.*;
import java.awt.*;

public class VentanaGrafica extends JFrame {

    //Variable lista para almacenar los vehículos registrados
    private Llista lista;

    //Variables graficas para los paneles y el área de resultados
    private JPanel panelMenu;
    private JPanel panelInteraccion;
    private JPanel panelResultados;

    private CardLayout gestorPaneles;
    private JTextArea areaResultados;


    public VentanaGrafica() {

        lista = new Llista();

        setTitle("Gestión de Transportes");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(
                new BorderLayout(5, 5)
        );

        //Panel izquierdo: menu de opciones

        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(245, 235, 225));
        panelMenu.setPreferredSize(new Dimension(260, 0));

        panelMenu.setLayout(
                new BoxLayout(panelMenu, BoxLayout.Y_AXIS)
        );

        JLabel tituloMenu = new JLabel("MENU");
        tituloMenu.setFont(new Font("Arial", Font.BOLD, 20));
        tituloMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botonRegistrar =
                new JButton("Registrar vehículo");

        JButton botonEliminar =
                new JButton("Eliminar vehículo");

        JButton botonBuscarNombre =
                new JButton("Buscar por nombre");

        JButton botonBuscarPropietario =
                new JButton("Buscar por propietario");

        JButton botonMostrarTodos =
                new JButton("Mostrar todos");

        Dimension tamanoBoton = new Dimension(230, 65);

        JButton[] botones = {
                botonRegistrar,
                botonEliminar,
                botonBuscarNombre,
                botonBuscarPropietario,
                botonMostrarTodos
        };

        for (JButton boton : botones) {

            boton.setPreferredSize(tamanoBoton);
            boton.setMaximumSize(tamanoBoton);
            boton.setMinimumSize(tamanoBoton);

            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setFont(new Font("Arial", Font.BOLD, 14));
            boton.setFocusPainted(false);
        }

        panelMenu.add(Box.createVerticalStrut(25));
        panelMenu.add(tituloMenu);
        panelMenu.add(Box.createVerticalStrut(30));

        for (JButton boton : botones) {
            panelMenu.add(boton);
            panelMenu.add(Box.createVerticalStrut(15));
        }

        // Panel central: formularios

        gestorPaneles = new CardLayout();

        panelInteraccion = new JPanel(gestorPaneles);
        panelInteraccion.setBackground(Color.WHITE);

        panelInteraccion.add(
                crearPanelTemporal("Selecciona una opción del menu"),
                "inicio"
        );

        panelInteraccion.add(
                crearPanelRegistrar(),
                "registrar"
        );

        panelInteraccion.add(
                crearPanelEliminar(),
                "eliminar"
        );

        panelInteraccion.add(
                crearPanelBuscarNombre(),
                "nombre"
        );

        panelInteraccion.add(
                crearPanelBuscarPropietario(),
                "propietario"
        );

        gestorPaneles.show(panelInteraccion, "inicio");

        // Panel derecho: resultados

        panelResultados = new JPanel(
                new BorderLayout(10, 10)
        );

        panelResultados.setBackground(
                new Color(255, 240, 245)
        );

        panelResultados.setPreferredSize(
                new Dimension(420, 0)
        );

        panelResultados.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel tituloResultados = new JLabel(
                "LISTA",
                SwingConstants.CENTER
        );

        tituloResultados.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);

        areaResultados.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        areaResultados.setLineWrap(true);
        areaResultados.setWrapStyleWord(true);

        JScrollPane scrollResultados =
                new JScrollPane(areaResultados);

        panelResultados.add(
                tituloResultados,
                BorderLayout.NORTH
        );

        panelResultados.add(
                scrollResultados,
                BorderLayout.CENTER
        );

        // Acciones de los botones del menu

        botonRegistrar.addActionListener(e ->
                gestorPaneles.show(panelInteraccion, "registrar")
        );

        botonEliminar.addActionListener(e ->
                gestorPaneles.show(panelInteraccion, "eliminar")
        );

        botonBuscarNombre.addActionListener(e ->
                gestorPaneles.show(panelInteraccion, "nombre")
        );

        botonBuscarPropietario.addActionListener(e ->
                gestorPaneles.show(panelInteraccion, "propietario")
        );

        botonMostrarTodos.addActionListener(e ->
                mostrarVehiculos(lista.obtenerTodos())
        );

        // =====================================
        // AÑADIR LOS TRES PANELES
        // =====================================

        panelPrincipal.add(panelMenu, BorderLayout.WEST);
        panelPrincipal.add(panelInteraccion, BorderLayout.CENTER);
        panelPrincipal.add(panelResultados, BorderLayout.EAST);

        add(panelPrincipal);
    }

    // Panel inicial temporal que se muestra al abrir la ventana

    private JPanel crearPanelTemporal(String titulo) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel etiqueta = new JLabel(
                titulo, SwingConstants.CENTER
        );

        etiqueta.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(etiqueta, BorderLayout.CENTER);

        return panel;
    }

    // Mostrar los vehiculos en la lista de resultados

    private void mostrarVehiculos(Transport[] vehiculos) {

        areaResultados.setText("");

        if (vehiculos.length == 0) {
            areaResultados.setText(
                    "No se encontraron vehículos."
            );
            return;
        }

        for (Transport vehiculo : vehiculos) {

            areaResultados.append(vehiculo.toString());

            areaResultados.append(
                    "\n--------------------------\n\n"
            );
        }

        areaResultados.setCaretPosition(0);
    }

    // Registro de vehiculos


    private JPanel crearPanelRegistrar() {


        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));

        panel.setBackground(Color.WHITE);
        panel.setBorder(
                BorderFactory.createEmptyBorder(12, 10, 12, 10)
        );


        JTextField campoNombre = new JTextField();
        JTextField campoPropietario = new JTextField();
        JTextField campoMatricula = new JTextField();
        JTextField campoVelocidad = new JTextField();
        JTextField campoPlazas = new JTextField();
        JTextField campoMedio = new JTextField();
        JTextField campoCilindrada = new JTextField();
        JTextField campoCombustible = new JTextField();


        JComboBox<String> selectorTipo = new JComboBox<>(
                new String[]{"Terrestre", "Marítimo", "Aéreo"}
        );

        JComboBox<String> selectorTraccion = new JComboBox<>(
                new String[]{"Mecánica", "No mecánica"}
        );


        panel.add(new JLabel("Nombre del vehículo:"));
        panel.add(campoNombre);

        panel.add(new JLabel("Propietario:"));
        panel.add(campoPropietario);

        panel.add(new JLabel("Matrícula:"));
        panel.add(campoMatricula);

        panel.add(new JLabel("Velocidad máxima:"));
        panel.add(campoVelocidad);

        panel.add(new JLabel("Número de plazas:"));
        panel.add(campoPlazas);

        panel.add(new JLabel("Tipo de transporte:"));
        panel.add(selectorTipo);

        panel.add(new JLabel("Tracción:"));
        panel.add(selectorTraccion);

        panel.add(new JLabel("Medio de circulación:"));
        panel.add(campoMedio);


        JLabel etiquetaCilindrada = new JLabel("Cilindrada:");
        JLabel etiquetaCombustible = new JLabel("Combustible:");

        panel.add(etiquetaCilindrada);
        panel.add(campoCilindrada);

        panel.add(etiquetaCombustible);
        panel.add(campoCombustible);


        selectorTraccion.addActionListener(e -> {

            boolean tieneMotor =
                    selectorTraccion.getSelectedIndex() == 0;

            etiquetaCilindrada.setVisible(tieneMotor);
            campoCilindrada.setVisible(tieneMotor);

            etiquetaCombustible.setVisible(tieneMotor);
            campoCombustible.setVisible(tieneMotor);

            panel.revalidate();
            panel.repaint();
        });


        JButton botonGuardar = new JButton("Registrar vehículo");

        panel.add(new JLabel(""));
        panel.add(botonGuardar);


        botonGuardar.addActionListener(e -> registrarVehiculo(
                campoNombre,
                campoPropietario,
                campoMatricula,
                campoVelocidad,
                campoPlazas,
                campoMedio,
                campoCilindrada,
                campoCombustible,
                selectorTipo,
                selectorTraccion
        ));


        JScrollPane scroll = new JScrollPane(panel);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.add(scroll, BorderLayout.CENTER);

        return contenedor;
    }


    //Registrar un vehículo en la lista.


    private void registrarVehiculo(
            JTextField campoNombre,
            JTextField campoPropietario,
            JTextField campoMatricula,
            JTextField campoVelocidad,
            JTextField campoPlazas,
            JTextField campoMedio,
            JTextField campoCilindrada,
            JTextField campoCombustible,
            JComboBox<String> selectorTipo,
            JComboBox<String> selectorTraccion
    ) {


        String nombre = campoNombre.getText().trim();
        String propietario = campoPropietario.getText().trim();
        String matricula = campoMatricula.getText().trim();
        String medio = campoMedio.getText().trim();

        String tipo = (String) selectorTipo.getSelectedItem();

        boolean mecanica =
                selectorTraccion.getSelectedIndex() == 0;


        if (nombre.isEmpty()
                || propietario.isEmpty()
                || matricula.isEmpty()
                || medio.isEmpty()
                || campoVelocidad.getText().trim().isEmpty()
                || campoPlazas.getText().trim().isEmpty()) {

            areaResultados.setText(
                    "Error: rellena todos los campos obligatorios."
            );
            return;
        }


        if (mecanica && (
                campoCilindrada.getText().trim().isEmpty()
                        || campoCombustible.getText().trim().isEmpty())) {

            areaResultados.setText(
                    "Error: introduce la cilindrada y el combustible."
            );
            return;
        }


        if (matricula.length() > 7) {

            areaResultados.setText(
                    "Error: la matrícula no puede superar los 7 caracteres."
            );
            return;
        }

        try {


            int velocidad = Integer.parseInt(
                    campoVelocidad.getText().trim()
            );

            int plazas = Integer.parseInt(
                    campoPlazas.getText().trim()
            );


            if (velocidad <= 0 || plazas <= 0) {

                areaResultados.setText(
                        "Error: la velocidad y las plazas deben ser mayores que cero."
                );
                return;
            }


            Motor motor = null;

            if (mecanica) {

                int cilindrada = Integer.parseInt(
                        campoCilindrada.getText().trim()
                );

                if (cilindrada <= 0) {

                    areaResultados.setText(
                            "Error: la cilindrada debe ser mayor que cero."
                    );
                    return;
                }

                motor = new Motor(
                        cilindrada,
                        campoCombustible.getText().trim()
                );
            }


            Transport vehiculo;

            if (tipo.equals("Terrestre")) {

                if (mecanica) {

                    vehiculo = new TracMec(
                            velocidad, plazas, matricula,
                            propietario, medio, motor, nombre
                    );

                } else {

                    vehiculo = new TracNoMec(
                            velocidad, plazas, matricula,
                            propietario, medio, nombre
                    );
                }

            } else if (tipo.equals("Marítimo")) {

                if (mecanica) {

                    vehiculo = new TracMecMaritim(
                            velocidad, plazas, matricula,
                            propietario, medio, motor, nombre
                    );

                } else {

                    vehiculo = new TracNoMecMaritim(
                            velocidad, plazas, matricula,
                            propietario, medio, nombre
                    );
                }

            } else {


                if (mecanica) {

                    vehiculo = new TracMecAeri(
                            velocidad, plazas, matricula,
                            propietario, medio, motor, nombre
                    );

                } else {

                    vehiculo = new TracNoMecAeri(
                            velocidad, plazas, matricula,
                            propietario, medio, nombre
                    );
                }
            }

            // Insertar el vehículo en la lista
            lista.insertar(vehiculo);

           ;

            areaResultados.setText(
                    "Vehículo registrado correctamente.\n\n"
            );

            areaResultados.setCaretPosition(0);


            campoNombre.setText("");
            campoPropietario.setText("");
            campoMatricula.setText("");
            campoVelocidad.setText("");
            campoPlazas.setText("");
            campoMedio.setText("");
            campoCilindrada.setText("");
            campoCombustible.setText("");

        } catch (NumberFormatException ex) {

            areaResultados.setText(
                    "Error: velocidad, plazas y cilindrada deben contener números enteros válidos."
            );
        }
    }


    // Eliminar un vehículo de la lista


    private JPanel crearPanelEliminar() {


        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 15));

        panel.setBackground(Color.WHITE);
        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );


        JLabel titulo = new JLabel("Eliminar vehículo");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));


        JTextField campoPropietario = new JTextField();
        JTextField campoMatricula = new JTextField();


        JButton botonEliminar = new JButton("Eliminar vehículo");


        panel.add(titulo);
        panel.add(new JLabel("Nombre del propietario:"));
        panel.add(campoPropietario);
        panel.add(new JLabel("Matrícula:"));
        panel.add(campoMatricula);
        panel.add(botonEliminar);


        botonEliminar.addActionListener(e -> {

            String propietario = campoPropietario.getText().trim();
            String matricula = campoMatricula.getText().trim();


            if (propietario.isEmpty() || matricula.isEmpty()) {

                areaResultados.setText(
                        "Error: introduce el propietario y la matrícula."
                );
                return;
            }


            if (matricula.length() > 7) {

                areaResultados.setText(
                        "Error: la matrícula no puede superar los 7 caracteres."
                );
                return;
            }


            boolean eliminado = lista.eliminar(propietario, matricula);

            if (eliminado) {

                areaResultados.setText(
                        "Vehículo eliminado correctamente."
                );


                campoPropietario.setText("");
                campoMatricula.setText("");

            } else {

                areaResultados.setText(
                        "Vehículo no encontrado."
                );
            }
        });


        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel, BorderLayout.NORTH);

        return contenedor;
    }


    // Buscar vehículos por nombre

    private JPanel crearPanelBuscarNombre() {

        JPanel panel = new JPanel(
                new GridLayout(0, 1, 10, 15)
        );

        panel.setBackground(Color.WHITE);
        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );



        JLabel titulo = new JLabel("Buscar por nombre");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField campoNombre = new JTextField();
        JButton botonBuscar = new JButton("Buscar vehículos");

        panel.add(titulo);
        panel.add(new JLabel("Nombre del vehículo:"));
        panel.add(campoNombre);
        panel.add(botonBuscar);



        botonBuscar.addActionListener(e -> {

            String nombre = campoNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Introduce el nombre del vehículo."
                );
                return;
            }

            Transport[] vehiculos =
                    lista.buscarPorNombre(nombre);

            // Solo mostrar las matrículas de los vehículos encontrados
            areaResultados.setText("");

            if (vehiculos.length == 0) {
                areaResultados.setText(
                        "No se encontraron vehículos con ese nombre."
                );
            } else {

                areaResultados.append(
                        "Matrículas de " + nombre + ":\n\n"
                );

                for (Transport vehiculo : vehiculos) {
                    areaResultados.append(
                            vehiculo.getMatricula() + "\n"
                    );
                }
            }

            areaResultados.setCaretPosition(0);
        });

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel, BorderLayout.NORTH);

        return contenedor;
    }

    // Buscar vehículos por propietario

    private JPanel crearPanelBuscarPropietario() {

        JPanel panel = new JPanel(
                new GridLayout(0, 1, 10, 15)
        );

        panel.setBackground(Color.WHITE);
        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );

        JLabel titulo = new JLabel("Buscar por propietario");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField campoPropietario = new JTextField();
        JButton botonBuscar = new JButton("Buscar vehículos");

        panel.add(titulo);
        panel.add(new JLabel("Nombre del propietario:"));
        panel.add(campoPropietario);
        panel.add(botonBuscar);

        botonBuscar.addActionListener(e -> {

            String propietario =
                    campoPropietario.getText().trim();

            if (propietario.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Introduce el nombre del propietario."
                );
                return;
            }

            Transport[] vehiculos =
                    lista.buscarPorPropietario(propietario);

            mostrarVehiculos(vehiculos);
        });

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel, BorderLayout.NORTH);

        return contenedor;
    }


}
