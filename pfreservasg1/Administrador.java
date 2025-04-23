/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;

public class Administrador {
    private Empleados empleados;
    private Reservas reservas;
    private Parqueo123 parqueos;

    public Administrador(Empleados empleados, Reservas reservas, Parqueo123 parqueos) {
        this.empleados = empleados;
        this.reservas = reservas;
        this.parqueos = parqueos;
    }

    public void menuAdministrador() {
        boolean continuar = true;
        while (continuar) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Menú de Administrador:\n"
                        + "1. Gestión de reservas\n"
                        + "2. Gestión de Empleados recientemente agregados y precargados\n"
                        + "3. Gestión de Parqueos\n"
                        + "4. Volver al Menú Principal\n"
                        + "Seleccione una opción:"));

                switch (opcion) {
                    case 1:
                        gestionReservas();
                        break;
                    case 2:
                        gestionEmpleados();
                        break;
                    case 3:
                        gestionParqueos();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Regresando al Menú Principal...");
                        continuar = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

    public void gestionEmpleados() {
    try {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Gestión de empleados:\n"
                + "1. Lista de empleados recientemente agregados y precargados\n"
                + "2. Eliminar empleados\n"
                + "3. Volver"));

        switch (opcion) {
            case 1:
                empleados.mostrarEmpleados();
                empleados.mostrarEmpleadosEstaticos(); 
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Solo se pueden eliminar empleados recientemente agregados.");
                // Obtener el ID del empleado a eliminar
                int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado registrado recientemente"));
                // Pasar el ID al método eliminarEmpleado de la clase Empleados
                if (empleados.eliminarEmpleado(idBuscar)) {
                    JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                }
                break;
            case 3:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
    }
}
    
    public void gestionParqueos() {
        try {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Gestión de Parqueos:\n"
                    + "1. Ver estado de parqueos\n"
                    + "2. Liberar espacio\n"
                    + "3. Volver"));

            switch (opcion) {
                case 1:
                    parqueos.MostrarParqueo();
                    break;
                case 2:
                    int espacioLiberar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el espacio que desea liberar:"));
                    parqueos.liberarEspacio(espacioLiberar);
                    break;
                case 3:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }

    public void gestionReservas() {
        try {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Gestión de Reservas:\n"
                    + "1. Ver estado de reservas\n"
                    + "2. Cancelar reserva\n"
                    + "3. Volver"));

            switch (opcion) {
                case 1:
                    reservas.verEstadoReservas();
                    break;
                case 2:
                    reservas.cancelarReserva();
                    break;
                case 3:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    }
}
