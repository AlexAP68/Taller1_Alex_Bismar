
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class VentanaGrafica extends JFrame {

    // =====================================
    // ATRIBUTOS
    // =====================================

    private Llista lista;

    private JPanel panelMenu;
    private JPanel panelInteraccion;
    private JPanel panelResultados;

    private CardLayout gestorPaneles;
    private JTextArea areaResultados;

    // =====================================
    // CONSTRUCTOR
    // =====================================

    public VentanaGrafica() {

        lista = new Llista();

        // CONFIGURACION DE LA VENTANA
        setTitle("Gestión de Transportes");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel(
                new BorderLayout(5, 5)
        );

        // =====================================
        // PANEL IZQUIERDO: MENU
        // =====================================

        panelMenu = new JPanel();
        panelMenu.setBackground(new Color(245, 235, 225));
        panelMenu.setPreferredSize(new Dimension(260, 0));

        panelMenu.setLayout(
                new BoxLayout(panelMenu, BoxLayout.Y_AXIS)
        );

        JLabel tituloMenu = new JLabel("MENÚ");
        tituloMenu.setFont(new Font("Arial", Font.BOLD, 20));
        tituloMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BOTONES DEL MENU
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

        // TAMAÑO UNIFORME
        Dimension tamañoBoton = new Dimension(230, 65);

        JButton[] botones = {
                botonRegistrar,
                botonEliminar,
                botonBuscarNombre,
                botonBuscarPropietario,
                botonMostrarTodos
        };

        for (JButton boton : botones) {

            boton.setPreferredSize(tamañoBoton);
            boton.setMaximumSize(tamañoBoton);
            boton.setMinimumSize(tamañoBoton);

            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setFont(new Font("Arial", Font.BOLD, 14));
            boton.setFocusPainted(false);
        }

        // AÑADIR BOTONES
        panelMenu.add(Box.createVerticalStrut(25));
        panelMenu.add(tituloMenu);
        panelMenu.add(Box.createVerticalStrut(30));

        panelMenu.add(botonRegistrar);
        panelMenu.add(Box.createVerticalStrut(15));

        panelMenu.add(botonEliminar);
        panelMenu.add(Box.createVerticalStrut(15));

        panelMenu.add(botonBuscarNombre);
        panelMenu.add(Box.createVerticalStrut(15));

        panelMenu.add(botonBuscarPropietario);
        panelMenu.add(Box.createVerticalStrut(15));

        panelMenu.add(botonMostrarTodos);

        // =====================================
        // PANEL CENTRAL: INTERACCION
        // =====================================

        gestorPaneles = new CardLayout();
        panelInteraccion = new JPanel(gestorPaneles);
        panelInteraccion.setBackground(Color.WHITE);

        // PANTALLA INICIAL
        panelInteraccion.add(
                crearPanelTemporal("Selecciona una opción del menú"),
                "inicio"
        );

        // REGISTRAR
        panelInteraccion.add(
                crearPanelRegistrar(),
                "registrar"
        );

        // ELIMINAR
        panelInteraccion.add(
                crearPanelEliminar(),
                "eliminar"
        );

        // BUSQUEDAS PENDIENTES
        panelInteraccion.add(
                crearPanelTemporal("Buscar por nombre"),
                "nombre"
        );

        panelInteraccion.add(
                crearPanelTemporal("Buscar por propietario"),
                "propietario"
        );

        gestorPaneles.show(panelInteraccion, "inicio");

        // =====================================
        // PANEL DERECHO: RESULTADOS
        // =====================================

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
                "VER LISTA",
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

        // =====================================
        // ACCIONES DE LOS BOTONES DEL MENU
        // =====================================

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

        botonMostrarTodos.addActionListener(e -> {
            areaResultados.setText(lista.imprimirTodos());
            areaResultados.setCaretPosition(0);
        });

        // =====================================
        // AÑADIR LOS TRES PANELES
        // =====================================

        panelPrincipal.add(panelMenu, BorderLayout.WEST);
        panelPrincipal.add(panelInteraccion, BorderLayout.CENTER);
        panelPrincipal.add(panelResultados, BorderLayout.EAST);

        add(panelPrincipal);
    }

    // =====================================
    // PANELES TEMPORALES
    // =====================================

    private JPanel crearPanelTemporal(String titulo) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel etiqueta = new JLabel(
                titulo, SwingConstants.CENTER
        );

        etiqueta.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        panel.add(etiqueta, BorderLayout.CENTER);

        return panel;
    }

    // =====================================
    // FORMULARIO PARA REGISTRAR VEHICULOS
    // =====================================

    private JPanel crearPanelRegistrar() {

        JPanel panel = new JPanel(
                new GridLayout(0, 2, 8, 8)
        );

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createEmptyBorder(12, 10, 12, 10)
        );

        // CAMPOS DE TEXTO
        JTextField campoNombre = new JTextField();
        JTextField campoPropietario = new JTextField();
        JTextField campoMatricula = new JTextField();
        JTextField campoVelocidad = new JTextField();
        JTextField campoPlazas = new JTextField();
        JTextField campoMedio = new JTextField();
        JTextField campoCilindrada = new JTextField();
        JTextField campoCombustible = new JTextField();

        // RESTRICCIONES DE ENTRADA
        limitarCampo(campoMatricula, 7, false);
        limitarCampo(campoVelocidad, 5, true);
        limitarCampo(campoPlazas, 3, true);
        limitarCampo(campoCilindrada, 6, true);

        // SELECTORES
        JComboBox<String> selectorTipo = new JComboBox<>(
                new String[]{"Terrestre", "Marítimo", "Aéreo"}
        );

        JComboBox<String> selectorTraccion = new JComboBox<>(
                new String[]{"Mecánica", "No mecánica"}
        );

        // CAMPOS DEL FORMULARIO
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

        // DATOS DEL MOTOR
        JLabel etiquetaCilindrada =
                new JLabel("Cilindrada:");

        JLabel etiquetaCombustible =
                new JLabel("Combustible:");

        panel.add(etiquetaCilindrada);
        panel.add(campoCilindrada);

        panel.add(etiquetaCombustible);
        panel.add(campoCombustible);

        // MOSTRAR / OCULTAR DATOS DEL MOTOR
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

        // BOTON REGISTRAR
        JButton botonGuardar =
                new JButton("Registrar vehículo");

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

        // CONTENEDOR
        JScrollPane scroll = new JScrollPane(panel);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.add(scroll, BorderLayout.CENTER);

        return contenedor;
    }

    // =====================================
    // REGISTRAR UN VEHICULO
    // =====================================

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

        // COMPROBAR CAMPOS OBLIGATORIOS
        if (nombre.isEmpty()
                || propietario.isEmpty()
                || matricula.isEmpty()
                || medio.isEmpty()
                || campoVelocidad.getText().trim().isEmpty()
                || campoPlazas.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Rellena todos los campos obligatorios."
            );
            return;
        }

        // COMPROBAR CAMPOS DEL MOTOR
        if (mecanica && (
                campoCilindrada.getText().trim().isEmpty()
                        || campoCombustible.getText().trim().isEmpty())) {

            JOptionPane.showMessageDialog(
                    this,
                    "Introduce la cilindrada y el combustible."
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

                JOptionPane.showMessageDialog(
                        this,
                        "La velocidad y las plazas deben ser mayores que cero."
                );
                return;
            }

            // CREAR MOTOR
            Motor motor = null;

            if (mecanica) {

                int cilindrada = Integer.parseInt(
                        campoCilindrada.getText().trim()
                );

                if (cilindrada <= 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "La cilindrada debe ser mayor que cero."
                    );
                    return;
                }

                motor = new Motor(
                        cilindrada,
                        campoCombustible.getText().trim()
                );
            }

            // CREAR EL VEHICULO CORRESPONDIENTE
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

            // INSERTAR EN LA LISTA ENLAZADA
            lista.insertar(vehiculo);

            JOptionPane.showMessageDialog(
                    this,
                    "Vehículo registrado correctamente."
            );

            // LIMPIAR FORMULARIO
            campoNombre.setText("");
            campoPropietario.setText("");
            campoMatricula.setText("");
            campoVelocidad.setText("");
            campoPlazas.setText("");
            campoMedio.setText("");
            campoCilindrada.setText("");
            campoCombustible.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Introduce valores numéricos válidos."
            );
        }
    }

    // =====================================
    // FORMULARIO PARA ELIMINAR VEHICULOS
    // =====================================

    private JPanel crearPanelEliminar() {

        JPanel panel = new JPanel(
                new GridLayout(0, 1, 10, 15)
        );

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );

        // TITULO
        JLabel titulo = new JLabel("Eliminar vehículo");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        // CAMPOS
        JTextField campoPropietario = new JTextField();
        JTextField campoMatricula = new JTextField();

        limitarCampo(campoMatricula, 7, false);

        // BOTON
        JButton botonEliminar =
                new JButton("Eliminar vehículo");

        // AÑADIR COMPONENTES
        panel.add(titulo);

        panel.add(new JLabel("Nombre del propietario:"));
        panel.add(campoPropietario);

        panel.add(new JLabel("Matrícula:"));
        panel.add(campoMatricula);

        panel.add(botonEliminar);

        // ACCION PARA ELIMINAR
        botonEliminar.addActionListener(e -> {

            String propietario =
                    campoPropietario.getText().trim();

            String matricula =
                    campoMatricula.getText().trim();

            // COMPROBAR CAMPOS VACIOS
            if (propietario.isEmpty() || matricula.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Introduce el propietario y la matrícula."
                );
                return;
            }

            // ELIMINAR DE LA LISTA
            boolean eliminado =
                    lista.eliminar(propietario, matricula);

            if (eliminado) {

                JOptionPane.showMessageDialog(
                        this,
                        "Vehículo eliminado correctamente."
                );

                // ACTUALIZAR EL PANEL DERECHO
                areaResultados.setText(lista.imprimirTodos());
                areaResultados.setCaretPosition(0);

                // LIMPIAR CAMPOS
                campoPropietario.setText("");
                campoMatricula.setText("");

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No se ha encontrado ningún vehículo con esos datos."
                );
            }
        });

        // CONTENEDOR
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel, BorderLayout.NORTH);

        return contenedor;
    }

    // =====================================
    // LIMITAR CARACTERES DE LOS CAMPOS
    // =====================================

    private void limitarCampo(
            JTextField campo,
            int maximo,
            boolean soloNumeros
    ) {

        AbstractDocument documento =
                (AbstractDocument) campo.getDocument();

        documento.setDocumentFilter(new DocumentFilter() {

            @Override
            public void replace(
                    FilterBypass fb,
                    int offset,
                    int length,
                    String texto,
                    AttributeSet attrs
            ) throws BadLocationException {

                if (texto == null) {
                    return;
                }

                String actual = fb.getDocument().getText(
                        0, fb.getDocument().getLength()
                );

                String nuevo =
                        actual.substring(0, offset)
                                + texto
                                + actual.substring(offset + length);

                if (nuevo.length() <= maximo
                        && (!soloNumeros
                        || nuevo.matches("[0-9]*"))) {

                    super.replace(
                            fb, offset, length, texto, attrs
                    );
                }
            }

            @Override
            public void insertString(
                    FilterBypass fb,
                    int offset,
                    String texto,
                    AttributeSet attrs
            ) throws BadLocationException {

                replace(fb, offset, 0, texto, attrs);
            }
        });
    }
}
