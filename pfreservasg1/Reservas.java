/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;

class Reservas {
     // Matriz para manejar las reservas de espacios de trabajo.
    // Cada fila tiene la capacidad del espacio y su estado (Disponible o Reservado).
    private String [][] espaciosTrabajo = {
        {"5 Personas", "Disponible"}, 
        {"10 Personas", "Disponible"}, 
        {"15 Personas", "Disponible"}, 
        {"20 Personas", "Disponible"}
    };
    
    // Matriz para manejar las reservas de cubículos insonorizados.
    private String[][] cubiculos = {
        {"Cubículo 1", "Disponible"},
        {"Cubículo 2", "Disponible"},
        {"Cubículo 3", "Disponible"},
        {"Cubículo 4", "Disponible"}
    };
    
    //Espacios para el auditorio en la mañama y en la tarde 
    private int cuposAuditorioAM = 50;
    private int cuposAuditorioPM = 50;
    
    // Matriz para manejar las reservas de espacios recreativos.
    private String [][] espaciosRecreacion =  {
        {"Ping Pong (30 min)", "Disponible"}, 
        {"Fútbol (12 jugadores)", "Disponible"}, 
        {"Baloncesto (10 jugadores)", "Disponible"}, 
        {"Tenis (2 jugadores)", "Disponible"}
    };
    
    // Menú principal de reservas, permite al usuario seleccionar diferentes opciones.
    public void menuReservas() {  // Cambiado a public
        boolean continuar = true;
        while (continuar) {
            // Mostrar menú de opciones al usuario
            String opcionStr = JOptionPane.showInputDialog(
                "Gestión de Salas / Áreas Comunes:\n" +
                "1. Reservar Espacio de Trabajo.\n" +
                "2. Reservar Cubículo Insonorizado.\n" +
                "3. Reservar Auditorio.\n" +
                "4. Reservar Espacio de Recreación.\n" +
                "5. Cancelar Reserva.\n" +
                "6. Ver Estado de Reservas.\n" +
                "7. Volver al menú principal.\n" +
                "Seleccione una opción:");
            
            if (opcionStr == null) { // Si el usuario presiona cancelar, salir del menú
            continuar = false;
            break;
        }
        
        try {
            int opcion = Integer.parseInt(opcionStr);
            switch (opcion) {
                case 1:
                    reservarEspacioTrabajo();
                    break;
                case 2:
                    reservarCubiculo();
                    break;
                case 3:
                    reservarAuditorio();
                    break;
                case 4:
                    reservarEspacioRecreacion();
                    break;
                case 5:
                    cancelarReserva();
                    break;
                case 6:
                    verEstadoReservas();
                    break;
                case 7:
                    continuar = false; // Esto debe salir del bucle y regresar al menú principal
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }
}
    
    // Método para reservar un espacio de trabajo según la capacidad requerida.
    public void reservarEspacioTrabajo() {  // Cambiado a public
        String mensaje = "Seleccione la capacidad de personas en el espacio de trabajo:\n";
        for (int i = 0; i < espaciosTrabajo.length; i++) {
            mensaje += (i + 1) + ". " + espaciosTrabajo[i][0] + " - " + espaciosTrabajo[i][1] + "\n";
        }
        String seleccion = JOptionPane.showInputDialog(mensaje);

        if (seleccion != null) {
            try {
                int indice = Integer.parseInt(seleccion) - 1;
                if (indice >= 0 && indice < espaciosTrabajo.length && espaciosTrabajo[indice][1].equals("Disponible")) {
                    espaciosTrabajo[indice][1] = "Reservado"; // Marcar como reservado
                    JOptionPane.showMessageDialog(null, "Espacio reservado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida o ya reservada.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
        
    }

    public void reservarCubiculo() { 
        String mensaje = "Seleccione el cubículo que desea reservar:\n";
        for (int i = 0; i < cubiculos.length; i++) {
            mensaje += (i + 1) + ". " + cubiculos[i][0] + " - " + cubiculos[i][1] + "\n";
        }

        String seleccion = JOptionPane.showInputDialog(mensaje);
        int indice = Integer.parseInt(seleccion) - 1;

        if (indice >= 0 && indice < cubiculos.length) {
            if (cubiculos[indice][1].equals("Disponible")) {
                cubiculos[indice][1] = "Reservado";
                JOptionPane.showMessageDialog(null, "Cubículo reservado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El cubículo ya está reservado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }
    
    public void reservarAuditorio() { 
        String mensaje = "Seleccione el horario del auditorio que desea reservar:\n" +
                     "1. Auditorio 10:00 AM\n" +
                     "2. Auditorio 3:00 PM\n";
    String seleccion = JOptionPane.showInputDialog(mensaje);

    if (seleccion != null) {
        try {
            int opcion = Integer.parseInt(seleccion);
            if (opcion == 1) {
                if (cuposAuditorioAM == 50) {
                    cuposAuditorioAM = 0; // Todos los 50 cupos están reservados
                    JOptionPane.showMessageDialog(null, "Auditorio de 10:00 AM reservado correctamente. Todos los 50 espacios están ahora ocupados.");
                } else {
                    JOptionPane.showMessageDialog(null, "El auditorio de 10:00 AM ya está reservado.");
                }
            } else if (opcion == 2) {
                if (cuposAuditorioPM == 50) {
                    cuposAuditorioPM = 0; // Todos los 50 cupos están reservados
                    JOptionPane.showMessageDialog(null, "Auditorio de 3:00 PM reservado correctamente. Todos los 50 espacios están ahora ocupados.");
                } else {
                    JOptionPane.showMessageDialog(null, "El auditorio de 3:00 PM ya está reservado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }
}
    
    public void reservarEspacioRecreacion() {
          boolean continuar = true;
    while (continuar) {
        String mensaje = "Seleccione el espacio recreativo:\n";
        for (int i = 0; i < espaciosRecreacion.length; i++) {
            mensaje += (i + 1) + ". " + espaciosRecreacion[i][0] + " - " + espaciosRecreacion[i][1] + "\n";
        }
        mensaje += (espaciosRecreacion.length + 1) + ". Volver al menú principal";

        String seleccion = JOptionPane.showInputDialog(mensaje);
        if (seleccion != null) {
            try {
                int indice = Integer.parseInt(seleccion) - 1;

                if (indice >= 0 && indice < espaciosRecreacion.length) {
                    if (espaciosRecreacion[indice][1].equals("Disponible")) {
                        espaciosRecreacion[indice][1] = "Reservado";
                        JOptionPane.showMessageDialog(null, "Espacio recreativo reservado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Espacio no disponible o ya reservado.");
                    }
                } else if (indice == espaciosRecreacion.length) {
                    continuar = false; // Volver al menú principal
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }
}
    
    public void cancelarReserva() { 
           String seleccion = JOptionPane.showInputDialog("Seleccione el espacio que desea liberar:\n 1. Espacio de Trabajo\n 2. Cubiculo\n 3.Auditorio\n 4.Espacio Recreativo");
      if (seleccion != null) {
        try {
            int opcion = Integer.parseInt(seleccion);
            if (opcion == 1) {
                liberarEspacioTrabajo();
            } else if (opcion == 2) {
                liberarCubiculo();
            } else if (opcion == 3) {
                liberarAuditorio(); // este lo añadimos a continuación
            } else if (opcion == 4) {
                liberarEspacioRecreativo();
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }
}
    
public void liberarEspacioTrabajo() {
           String seleccion = JOptionPane.showInputDialog("Seleccione el espacio de trabajo que desea liberar:");
        if (seleccion != null) {
            try {
                int indice = Integer.parseInt(seleccion) - 1;
                if (indice >= 0 && indice < espaciosTrabajo.length && espaciosTrabajo[indice][1].equals("Reservado")) {
                    espaciosTrabajo[indice][1] = "Disponible";
                    JOptionPane.showMessageDialog(null, "Espacio de trabajo liberado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay ninguna reserva en este espacio.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

public void liberarCubiculo() {
    String mensaje = "Seleccione el cubículo que desea liberar:\n";
    for (int i = 0; i < cubiculos.length; i++) {
        mensaje += (i + 1) + ". " + cubiculos[i][0] + " - " + cubiculos[i][1] + "\n";
    }

    String seleccion = JOptionPane.showInputDialog(mensaje);

    if (seleccion != null) {
        try {
            int indice = Integer.parseInt(seleccion) - 1;
            if (indice >= 0 && indice < cubiculos.length && cubiculos[indice][1].equals("Reservado")) {
                cubiculos[indice][1] = "Disponible";
                JOptionPane.showMessageDialog(null, "Cubículo liberado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Cubículo no reservado o índice inválido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }
}

 public void liberarAuditorio() {
   String mensaje = "Seleccione el horario del auditorio que desea liberar:\n" +
                     "1. Auditorio 10:00 AM\n" +
                     "2. Auditorio 3:00 PM\n";
    String seleccion = JOptionPane.showInputDialog(mensaje);
    int opcion = Integer.parseInt(seleccion);

    if (opcion == 1) {
        if (cuposAuditorioAM < 50) {
            cuposAuditorioAM = 50;
            JOptionPane.showMessageDialog(null, "Auditorio de 10:00 AM liberado correctamente. Todos los 50 espacios están ahora disponibles.");
        } else {
            JOptionPane.showMessageDialog(null, "El auditorio ya está disponible para la mañana.");
        }
    } else if (opcion == 2) {
        if (cuposAuditorioPM < 50) {
            cuposAuditorioPM = 50; 
            JOptionPane.showMessageDialog(null, "Auditorio de 3:00 PM liberado correctamente. Todos los 50 espacios están ahora disponibles.");
        } else {
            JOptionPane.showMessageDialog(null, "El auditorio ya está disponible para la tarde.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Opción inválida.");
    }
}

public void liberarEspacioRecreativo() {
        String seleccion = JOptionPane.showInputDialog("Seleccione el espacio recreativo que desea liberar:");
        if (seleccion != null) {
            try {
                int indice = Integer.parseInt(seleccion) - 1;
                if (indice >= 0 && indice < espaciosRecreacion.length && espaciosRecreacion[indice][1].equals("Reservado")) {
                    espaciosRecreacion[indice][1] = "Disponible";
                    JOptionPane.showMessageDialog(null, "Espacio recreativo liberado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay ninguna reserva en este espacio.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

  public void verEstadoReservas() {
        String estado = "Estado de las Reservas:\n\n";

    // Mostrar el estado de los espacios de trabajo
    estado += "Espacios de Trabajo:\n";
    for (int i = 0; i < espaciosTrabajo.length; i++) {
        estado += "Espacio " + (i + 1) + ": " + espaciosTrabajo[i][0] + " - " + espaciosTrabajo[i][1] + "\n";
    }

    // Mostrar el estado de los cubículos
    estado += "\nCubículos Insonorizados:\n";
    for (int i = 0; i < cubiculos.length; i++) {
        estado += cubiculos[i][0] + ": " + cubiculos[i][1] + "\n";
    }

    // Mostrar el estado del auditorio (mañana y tarde)
    estado += "\nAuditorio:\n";
    estado += "Auditorio 10:00 AM - " + (cuposAuditorioAM < 50 ? "Reservado" : "Disponible") + "\n";
    estado += "Auditorio 3:00 PM - " + (cuposAuditorioPM < 50 ? "Reservado" : "Disponible") + "\n";

    // Mostrar el estado de los espacios recreativos
    estado += "\nEspacios Recreativos:\n";
    for (int i = 0; i < espaciosRecreacion.length; i++) {
        estado += "Espacio " + (i + 1) + ": " + espaciosRecreacion[i][0] + " - " + espaciosRecreacion[i][1] + "\n";
    }
    JOptionPane.showMessageDialog(null, estado);
}
    void mostrarCantidadReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void mostrarRankingAreas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void editarReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
    
   