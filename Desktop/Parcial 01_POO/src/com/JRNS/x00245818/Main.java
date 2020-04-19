package com.JRNS.x00245818;

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
    public static void main(String[] args) {
	int opcionMenu;
	String numDoc;
	Scanner entrada = new Scanner(System.in);

	//Objeto de tipo empresa
	Empresa emp = new Empresa("INDUSTRIAS VICAL");

	System.out.println("MENU PRINCIPAL\n" + menuPrincipal());
	System.out.println("Introduzca la opcion a realizar");
	opcionMenu = entrada.nextInt();

	switch(opcionMenu){
        case 0:
            break;
        case 1:

            break;
        case 2:
            System.out.println("Digite el documento del empleado que desea despedir: ");
            numDoc = entrada.nextLine();
            String numDocFinal = numDoc;
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

    }
}
