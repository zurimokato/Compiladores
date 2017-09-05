package compiladores;

import javax.swing.JTextArea;

/**
 *
 * @author Ingenieros
 */
public class Automata {

    public Automata() {

    }

    public Estado validarCadena(String cadena, JTextArea area) {
        Estado estado = Estado.INICIO;
        int con = 0;
        boolean error = false;
        int cadeaTam = cadena.length() - 1;
        while (con < cadena.length() && error == false) {
            switch (estado) {
                case INICIO:
                    area.append("Inicio " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) == '+') {
                        estado = Estado.SUMAR;
                    } else if (cadena.charAt(con) == '-') {
                        estado = Estado.RESTAR;
                    } else if (cadena.charAt(con) == '=') {
                        estado = Estado.ASIGNAR;
                    } else if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.TRANSITORIO1;
                    } else if (cadena.charAt(con) != 112 && cadena.charAt(con) >= 97 && cadena.charAt(con) < 122 || cadena.charAt(con) >= 65 && cadena.charAt(con) <= 90) {
                        estado = Estado.LETRAS;
                    } else if (cadena.charAt(con) == 112) {
                        estado = Estado.R;
                    } else {
                        estado = Estado.ERROR;
                    }
                    break;
                case SUMAR:
                    area.append("Sumar " + cadena.charAt(con)+"\n");
                    //System.out.print("Sumar ");
                    estado = Estado.SUMAR;
                    break;
                case RESTAR:
                     area.append("Restar " + cadena.charAt(con)+"\n");
                    //System.out.print("Restar ");
                    estado = Estado.RESTAR;
                    break;
                case ASIGNAR:
                     area.append("Asignar " + cadena.charAt(con)+"\n");
                    //System.out.print("Asignar ");
                    estado = Estado.ASIGNAR;
                    break;
                case TRANSITORIO1:
                     area.append("Transitorio1 " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.TRANSITORIO1;
                        if (con == cadeaTam - 1) {
                            estado = Estado.ENTERO;
                        }
                    } else {
                        estado = Estado.ERROR;
                    }
                    break;
                case ENTERO:
                     area.append("Entero " + cadena.charAt(con)+"\n");
                    //System.out.print("Entero ");
                    estado = Estado.ENTERO;
                    break;
                case LETRAS:
                    if (cadena.charAt(con) >= 65 && cadena.charAt(con) <= 90
                            || cadena.charAt(con) >= 97
                            && cadena.charAt(con) <= 122) {
                        area.append("Letras " + cadena.charAt(con)+"\n");
                        estado = Estado.LETRAS;
                    } else if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        area.append("Letras " + cadena.charAt(con)+"\n");
                        estado = Estado.LETRAS;

                    } else {
                        estado = Estado.ERROR;
                    }
                    break;
                case R:
                    area.append("R " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) >= 65 && cadena.charAt(con) <= 90
                            || cadena.charAt(con) >= 97
                            && cadena.charAt(con) <= 122
                            && cadena.charAt(con) != 114) {
                        estado = Estado.LETRAS;
                    } else if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.ERROR;
                    } else if (cadena.charAt(con) == 114) {
                        estado = Estado.I;
                    }
                    break;
                case I:
                    System.out.println("I " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) >= 65 && cadena.charAt(con) <= 90
                            || cadena.charAt(con) >= 97
                            && cadena.charAt(con) <= 122
                            && cadena.charAt(con) != 105) {
                        estado = Estado.LETRAS;
                    } else if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.ERROR;
                    } else if (cadena.charAt(con) == 105) {
                        estado = Estado.N;
                    }
                    break;
                case N:
                    area.append("N " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) >= 65 && cadena.charAt(con) <= 90
                            || cadena.charAt(con) >= 97
                            && cadena.charAt(con) <= 122
                            && cadena.charAt(con) != 110) {
                        estado = Estado.LETRAS;
                    } else if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.ERROR;
                    } else if (cadena.charAt(con) == 110) {
                        estado = Estado.T;
                    }
                    break;
                case T:
                    area.append("T " + cadena.charAt(con)+"\n");
                    if (cadena.charAt(con) >= 49 && cadena.charAt(con) <= 57) {
                        estado = Estado.ERROR;
                    } else {
                        estado = Estado.PRINT;

                    }
                    break;
                case ERROR:
                    area.append("Error " + cadena.charAt(con)+"\n");
                    //error = true;
                    estado = Estado.ERROR;
                    //System.out.print ("Error");
                    break;
                case PRINT:
                    area.append("print " + cadena.charAt(con)+"\n");
                    //System.out.print("palabra reservada print ");
                    estado = Estado.PRINT;
                    break;

            }
            con++;
        }

        return estado;
    }

  
}
