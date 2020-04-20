package com.JRNS.x00245818;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static String menuPrincipal() {
        return  "1. Agregar empleado\n" +
                "2. Despedir empleado\n" +
                "3. Ver lista de empleados\n" +
                "4. Calcular sueldo\n" +
                "5. Mostrar totales\n" +
                "0. Salir";
    }

    static String menuEmpleado(){
        return  "1. Plaza fija\n" +
                "2. Servicio Profesional\n" +
                "0. Regresar al menu principal";
    }

    static String menuMostrarEmpleado(){
        return  "Elija la lista de empleados que desea que se le muestre\n" +
                "1. Plaza fija\n" +
                "2. Servicio profesional\n" +
                "0. Regresar al menu principal";
    }

    public static void main(String[] args) {
	int opcionMenu, tipoEmpleado;
	//variables para agregar empleado de tipo Plaza fija y Servicio profesional
	String nombreEmpleado, puesto;
	int salario ,extension ,mesesContrato;

	//Objeto de tipo empresa
	Empresa negocio = new Empresa("INDUSTRIAS VICAL");

	do{
	    opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,menuPrincipal()));
	    switch (opcionMenu) {
	        case 0:
	            break;
            case 1:
                tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tipo de empleado que desea agregar\n" + menuEmpleado()));
                switch (tipoEmpleado) {
                    case 0:
                        break;
                    case 1:
                        nombreEmpleado = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado a agregar");
                        puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto del empleado");
                        salario = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el salario del empleado"));
                        extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la extension del empleado (numero telefonico)"));
                        negocio.addEmpleado(new PlazaFija(nombreEmpleado, puesto, salario, extension));
                        break;
                    case 2:
                        nombreEmpleado = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado a agregar");
                        puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto del empleado");
                        salario = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el salario del empleado"));
                        mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de meses a contratarlo"));
                        negocio.addEmpleado(new ServicioProfesional(nombreEmpleado, puesto, salario, mesesContrato));
                        break;
                }
                break;
            case 2:
                nombreEmpleado = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado a despedir");
                negocio.quitEmpleado(nombreEmpleado);
                break;
            case 3:
                int eleccion;
                eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, menuMostrarEmpleado()));
                switch (eleccion) {
                    case 0:
                        break;
                    case 1:
                        //Imprime solo los empleados de tipo plaza fija
                        negocio.getPlanilla().forEach(obj -> {
                            if (obj instanceof PlazaFija) {
                                JOptionPane.showMessageDialog(null, "Empleado: " + obj.getNombre() + "\n" +
                                        "Puesto: " + obj.getPuesto() + "\n" +
                                        "Salario: " + obj.getSalario() + "\n" +
                                        "Extension: " + ((PlazaFija) obj).getExtension());
                            }
                        });
                        break;
                    case 2:
                        //Imprime solo los empleados de tipo servicio profesional
                        negocio.getPlanilla().forEach(obj -> {
                            if (obj instanceof ServicioProfesional) {
                                JOptionPane.showMessageDialog(null, "Empleado: " + obj.getNombre() + "\n" +
                                        "Puesto: " + obj.getPuesto() + "\n" +
                                        "Salario: " + obj.getSalario() + "\n" +
                                        "Meses del contrato: " + ((ServicioProfesional) obj).getMesesContrato());
                            }
                        });
                }
                break;
            case 4:
                int nombreemp;
                nombreemp = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado que desea ver su sueldo"));
                

                break;
            case 5:
                JOptionPane.showMessageDialog(null,CalculadoraImpuestos.mostrarTotales());
                break;
        }
    }while(opcionMenu != 0);

    }
}
