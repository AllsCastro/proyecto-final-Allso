/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pfreservasg1;

import javax.swing.JOptionPane;
//Esta interfaz permite que el usuario interactúe con el programa fácilmente sin necesidad de consola

public class PFReservasG1 {

    public static void main(String[] args) {
        boolean sistemaActivo = false;
        
        while (!sistemaActivo) { //Este ciclo while verifica si el sistema aún no está activo
            try {
                String entrada = JOptionPane.showInputDialog("Bienvenido! ¿Desea ingresar al sistema? (SI = 1 / NO = 0):");
                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    return; // Cerrar programa si el usuario cancela
                }

                int ingresoSistema = Integer.parseInt(entrada);

                if (ingresoSistema == 1) { //al ingresar el 1 activa el programa y muestra el menú principal 
                    sistemaActivo = true;
                } else if (ingresoSistema == 0) {
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    return; // Salir del programa si el usuario elige 0
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida (1 o 0).");
                }
            } catch (NumberFormatException e) { //bloque try-catch para errores por parte del usuario y que el codigo no se caiga
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }

        boolean continuar = true;

        // Crea las instancias de las clases necesarias aplicando la modularidad para dividir el codigo en partes mas pequeñas
        Empleados empleados = new Empleados();
        Reservas reservas = new Reservas();
        Parqueo123 parqueos = new Parqueo123();
        Administrador administrador = new Administrador(empleados, reservas, parqueos);

        while (continuar) { // seguimiento despues de activarlo 
            try { // Código que puede causar error
                String opcionStr = JOptionPane.showInputDialog( 
    //El String representa texto para guardarlo y mostrarlo y la variable opcion representa lo digitado por el usuario
                        "Plataforma de Reservación y Administración de Espacios:\n"
                                + "1. Registro de datos de los empleados.\n"
                                + "2. Detalles de las Reservas.\n"
                                + "3. Parqueos.\n"
                                + "4. Salas / Áreas comunes.\n"
                                + "5. Administrador.\n"
                                + "6. Salir.\n"
                                + "Seleccione una opción:");
                
                if (opcionStr == null) {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    return; // Cerrar programa si el usuario cancela
                }

                int opcion = Integer.parseInt(opcionStr);
                //Aca nos podria dar el error por que si ponemos "Hola", no puede convertirlo a número 
                //y nos daria el error = numberformatexception.

                switch (opcion) { // revisa el número y entra en el case que coincida
                    case 1:
                        empleados.definirCantidadEmpleados(); //Llama a la clase y sus funciones o metodos
                        empleados.registroEmpleados();
                        empleados.mostrarEmpleados();
                        empleados.mostrarEmpleadosEstaticos(); 
                        break; //salir del switch después de ejecutar el código
                    case 2:
                        reservas.verEstadoReservas();
                        break;
                    case 3:
                        parqueos.MostrarParqueo();
                        parqueos.ReservarEspacio();
                        parqueos.EliminarReserva();
                        break;
                    case 4:
                        reservas.menuReservas();
                        break;
                    case 5:
                        administrador.menuAdministrador();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                        continuar = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) { 
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
                //se utilizo para evitar la caida del programa y errores que el usuario cometiera al digitar un caracter no numerico o solicitado.
            }
        }
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   
