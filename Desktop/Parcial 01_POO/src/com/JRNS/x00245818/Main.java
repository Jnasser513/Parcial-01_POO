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

    public static void main(String[] args) {
	int opcionMenu, tipoEmpleado;
	//variables para agregar empleado de tipo Plaza fija y Servicio profesional
	String nombreEmpleado, puesto;
	int salario ,extension ,mesesContrato;
	String numDoc;

	//Objeto de tipo empresa
	Empresa negocio = new Empresa("INDUSTRIAS VICAL");

	opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,menuPrincipal()));

	do {
        switch (opcionMenu) {
            case 0:
                break;
            case 1:
                tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tipo de empleado que desea agregar: " + menuEmpleado()));
                switch (tipoEmpleado) {
                    case 0:
                        break;
                    case 1:
                        nombreEmpleado = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado a agregar");
                        puesto = JOptionPane.showInputDialog(null, "Ingrese el puesto del empleado");
                        salario = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el salario del empleado"));
                        extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingres la extension del empleado (numero telefonico)"));
                        negocio.addEmpleado(new PlazaFija(nombreEmpleado, puesto, salario, extension));
                        break;
                    case 2:
                        nombreEmpleado = JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado a agregar");
                        puesto = JOptionPane.showInputDialog(null,"Ingrese el puesto del empleado");
                        salario = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el salario del empleado"));
                        mesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de meses a contratarlo"));
                        negocio.addEmpleado(new ServicioProfesional(nombreEmpleado, puesto, salario, mesesContrato));
                        break;
                }
                break;
            case 2:
                nombreEmpleado = JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado a despedir");
                negocio.quitEmpleado(nombreEmpleado);
                break;
            case 3:
                //"Opcion #3"

                break;
            case 4:
                //"Opcion #4"
                break;
            case 5:
                //"Opcion #5"
                break;
        }
    }while(opcionMenu != 0);
    }
}
