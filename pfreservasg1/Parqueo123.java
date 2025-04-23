/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;

class Parqueo123 {
// Declaración de las matrices que representan cada nivel del parqueo
    private String[][] nivel1;
    private String[][] nivel2;
    private String[][] nivel3;

    // Constructor que inicializa los niveles de parqueo
    public Parqueo123() {
        nivel1 = new String[4][5]; // Nivel 1: 4 filas x 5 columnas
        nivel2 = new String[5][5]; // Nivel 2: 5 filas x 5 columnas
        nivel3 = new String[6][5]; // Nivel 3: 6 filas x 5 columnas
        Niveles(); // Llama al método que configura los espacios en cada nivel
    }

    // Método que define los espacios disponibles, especiales y discapacitados en cada nivel
    private void Niveles() {
        // "O" = espacio libre, "D" = espacio para discapacitados, "E" = espacio especial
        
        // Configuración del nivel 1
        nivel1[0] = new String[]{"O", "D", "O", "O", "O"};
        nivel1[1] = new String[]{"O", "O", "O", "O", "O"};
        nivel1[2] = new String[]{"O", "O", "D", "O", "O"};
        nivel1[3] = new String[]{"E", "E", "E", "O", "O"};

        // Configuración del nivel 2
        nivel2[0] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[1] = new String[]{"O", "D", "O", "O", "O"};
        nivel2[2] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[3] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[4] = new String[]{"E", "E", "E", "O", "O"};

        // Configuración del nivel 3
        nivel3[0] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[1] = new String[]{"O", "D", "O", "O", "O"};
        nivel3[2] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[3] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[4] = new String[]{"O", "O", "D", "O", "O"};
        nivel3[5] = new String[]{"E", "E", "E", "O", "O"};
    }

    // Método para mostrar los tres niveles de parqueo al usuario
    public void MostrarParqueo() {
        String imprimirNiveles = "A continuación se mostrarán los 3 niveles de parqueos disponibles\n"
                + "Nivel 1:\n" + mostrar(nivel1) + "\n"
                + "Nivel 2:\n" + mostrar(nivel2) + "\n"
                + "Nivel 3:\n" + mostrar(nivel3);

        JOptionPane.showMessageDialog(null, imprimirNiveles);
    }

    // Método auxiliar para construir un string que represente gráficamente un nivel
    private String mostrar(String[][] nivel) {
        String mostrarLosNiveles = "";
        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[i].length; j++) {
                mostrarLosNiveles = mostrarLosNiveles + "| " + nivel[i][j] + " ";
            }
            mostrarLosNiveles = mostrarLosNiveles + "|\n";
        }
        return mostrarLosNiveles;
    }

    // Método para reservar un espacio en el parqueo
    public void ReservarEspacio() {
        boolean continuar = true;

        while (continuar) {
            // Solicitar nivel de parqueo
            int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de parqueo que desea (1-2-3)"));

            // Validación de nivel
            if (nivel < 1 || nivel > 3) {
                JOptionPane.showMessageDialog(null, "Número de nivel incorrecto. Intente nuevamente.");
                continue;
            }

            // Seleccionar la matriz correspondiente al nivel ingresado
            String[][] ParqueoSeleccionado;
            if (nivel == 1) {
                ParqueoSeleccionado = nivel1;
            } else if (nivel == 2) {
                ParqueoSeleccionado = nivel2;
            } else {
                ParqueoSeleccionado = nivel3;
            }

            // Mostrar el nivel al usuario
            String nivelSeleccionado = "Nivel " + nivel + ":\n" + mostrar(ParqueoSeleccionado);
            JOptionPane.showMessageDialog(null, nivelSeleccionado);

            // Solicitar fila y columna para reservar
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila en la que desea reservar el espacio")) - 1;
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna en la que desea reservar el espacio")) - 1;

            // Validar que la fila y columna estén dentro del rango
            if (fila < 0 || fila >= ParqueoSeleccionado.length || columna < 0 || columna >= ParqueoSeleccionado[0].length) {
                JOptionPane.showMessageDialog(null, "Fila o columna fuera de rango. Intente nuevamente.");
                continue;
            }

            // Verificar el estado del espacio seleccionado
            String estado = ParqueoSeleccionado[fila][columna];
            if (estado.equals("O") || estado.equals("E")) {
                ParqueoSeleccionado[fila][columna] = "P"; // Marcar como reservado
                JOptionPane.showMessageDialog(null, "Reserva exitosa");
            } else if (estado.equals("D")) {
                JOptionPane.showMessageDialog(null, "No se puede reservar en este espacio");
            } else {
                JOptionPane.showMessageDialog(null, "El espacio seleccionado no está disponible");
            }

            // Menú de opciones después de reservar
            String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n1. Reservar otro espacio\n2. Eliminar una reserva\n3. Salir\nIngrese su opción:");

            if (opcion.equals("1")) {
                continue; // Repetir el ciclo para otra reserva
            } else if (opcion.equals("2")) {
                EliminarReserva(); // Llamar al método para eliminar reservas
                continuar = true;  // Seguir en el ciclo
            } else if (opcion.equals("3")) {
                JOptionPane.showMessageDialog(null, "¡Gracias por utilizar el sistema de reservas!");
                continuar = false; // Salir del ciclo
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Saliendo...");
                continuar = false;
            }
        }
    }

    // Método para eliminar una reserva de parqueo
    public void EliminarReserva() {
        // Solicitar el nivel
        int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de parqueo donde desea eliminar la reserva (1-2-3):"));

        // Validación del nivel
        if (nivel < 1 || nivel > 3) {
            JOptionPane.showMessageDialog(null, "Número de nivel incorrecto. Intente nuevamente.");
            return;
        }

        // Selección del nivel correspondiente
        String[][] ParqueoSeleccionado;
        if (nivel == 1) {
            ParqueoSeleccionado = nivel1;
        } else if (nivel == 2) {
            ParqueoSeleccionado = nivel2;
        } else {
            ParqueoSeleccionado = nivel3;
        }

        // Mostrar el nivel antes de eliminar
        String nivelSeleccionado = "Nivel " + nivel + ":\n" + mostrar(ParqueoSeleccionado);
        JOptionPane.showMessageDialog(null, nivelSeleccionado);

        // Solicitar fila y columna
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila del espacio a eliminar")) - 1;
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna del espacio a eliminar")) - 1;

        // Validación de rangos
        if (fila < 0 || fila >= ParqueoSeleccionado.length || columna < 0 || columna >= ParqueoSeleccionado[0].length) {
            JOptionPane.showMessageDialog(null, "Fila o columna fuera de rango. Intente nuevamente.");
            return;
        }

        // Verificación y eliminación de la reserva
        String estado = ParqueoSeleccionado[fila][columna];
        if (estado.equals("P")) {
            ParqueoSeleccionado[fila][columna] = "O"; // Liberar el espacio
            JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito.");
        } else if (estado.equals("E")) {
            ParqueoSeleccionado[fila][columna] = "O"; // También se libera si era especial
            JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito en el espacio marcado como especial.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna reserva en este espacio.");
        }

        // Menú de opciones después de eliminar
        String opcion = JOptionPane.showInputDialog("Seleccione una opción:\n1. Reservar otro espacio\n2. Eliminar una reserva\n3. Salir\nIngrese su opción:");

        if (opcion.equals("1")) {
            ReservarEspacio(); // Llamar al método de reservar
        } else if (opcion.equals("2")) {
            EliminarReserva(); // Repetir la eliminación
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida. Saliendo...");
        }
    }

    // Método pendiente por implementar (liberar espacio)
    void liberarEspacio(int espacioLiberar) {
        throw new UnsupportedOperationException("Not supported yet."); // Método aún no implementado
    }

    // Método pendiente por implementar (calcular ocupación)
    void calcularPorcentajeOcupacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Método aún no implementado
    }
}