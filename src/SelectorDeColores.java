import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectorDeColores extends JFrame implements ItemListener {
    private JComboBox<String> comboBoxColores;
    private JPanel panelColor;

    public SelectorDeColores() {
        setTitle("Selector de Colores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        // Configuración del JComboBox
        String[] colores = {"Rojo", "Verde", "Azul"};
        comboBoxColores = new JComboBox<>(colores);
        comboBoxColores.addItemListener(this);

        // Configuración del JPanel
        panelColor = new JPanel();
        panelColor.setBackground(Color.WHITE);

        // Añadir componentes al contenedor principal
        add(comboBoxColores, BorderLayout.NORTH);
        add(panelColor, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String colorSeleccionado = (String) comboBoxColores.getSelectedItem();
            Color color = obtenerColor(colorSeleccionado);
            panelColor.setBackground(color);
        }
    }

    private Color obtenerColor(String colorString) {
        switch (colorString) {
            case "Rojo":
                return Color.RED;
            case "Verde":
                return Color.GREEN;
            case "Azul":
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SelectorDeColores selector = new SelectorDeColores();
                selector.setVisible(true);
            }
        });
    }
}
