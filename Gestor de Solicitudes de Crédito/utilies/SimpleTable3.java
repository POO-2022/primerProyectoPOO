package utilies;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class SimpleTable3 extends JFrame {
  public SimpleTable3() {
    super("Calculo del Credito Personal en dolares con tasa fija");

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    for (int column = 0; column < 5; column++) {
      dtm.addColumn("Columna " + column);
    }

    // insertamos el contenido de las columnas
    for (int row = 0; row < 10; row++) {
      for (int column = 0; column < 5; column++) {
        data[column] = "Celda " + row + "," + column;
      }
      dtm.addRow(data);
    }

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);

    // Agregamos el JScrollPane al contenedor
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    // manejamos la salida
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    JButton button = new JButton("Salir");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    getContentPane().add(button, BorderLayout.SOUTH);
    setSize(600, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SimpleTable3 frame = new SimpleTable3();
    // frame.setSize(600, 400);
    // frame.setVisible(true);
  }
  // frame.setSize(600, 300);
  // frame.pack();
  // frame.setVisible(true);

  // }
}