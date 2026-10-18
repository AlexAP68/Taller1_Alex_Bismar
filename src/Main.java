import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            VentanaGrafica ventana = new VentanaGrafica();
            ventana.setVisible(true);
        });

    }
}