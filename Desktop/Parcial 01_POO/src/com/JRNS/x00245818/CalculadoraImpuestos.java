package com.JRNS.x00245818;

public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos() {
    }

    //Metodos estaticos
    public static double calcularEmpleado(Empleado tipoEmpleado) {
        double sueldo = 0, renta = 0, restante, AFP, ISSS;
        //Si el empleado es de tipo ServicioProfesional
        if (tipoEmpleado instanceof ServicioProfesional) {
            renta = 0.1 * tipoEmpleado.getSalario();
            totalRenta += renta;
            sueldo = tipoEmpleado.getSalario() - renta;
        } else {
            AFP = 0.0625 * tipoEmpleado.getSalario();
            ISSS = 0.03 * tipoEmpleado.getSalario();
            totalAFP += AFP;
            totalISSS += ISSS;
            restante = tipoEmpleado.getSalario() - AFP - ISSS;

            if (restante > 0.01 && restante < 472)
                renta = 0;
            else if (restante > 472.01 && restante < 895.24) {
                renta = 0.1 * (restante - 472) + 17.67;
                totalRenta += renta;
            } else if (restante > 895.25 && restante < 2038.10) {
                renta = 0.2 * (restante - 895.24) + 60;
                totalRenta += renta;
            } else if (restante > 2038.11) {
                renta = 0.3 * (restante - 2038.10) + 288.57;
                totalRenta += renta;
            }
            sueldo = restante - renta;
        }
        return sueldo;
    }


    public static String mostrarTotales() {
        return  ("Total renta: " + totalRenta + "\n") +
                ("Total AFP: " + totalAFP + "\n") +
                ("Total ISSS: " + totalISSS);
    }
}
