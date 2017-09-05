package compiladores;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JTextArea;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Ingenieros
 */
public class LeerArchivo {

    private File archivo = null;
    private FileReader lectorArchivo = null;
    private BufferedReader buffer = null;
    private static ArrayList<String> listaString = new ArrayList<String>();
    private Automata auto = null;
    private JTextArea textoCaja;

    public LeerArchivo() {

    }

    public LeerArchivo(JTextArea textoCaja) {
        this.textoCaja = textoCaja;
    }

    public void Leer(String url) {

        try {
            archivo = new File(url);
            lectorArchivo = new FileReader(archivo);
            buffer = new BufferedReader(lectorArchivo);
            String linea;
            String salida = "";
            while ((linea = buffer.readLine()) != null) {
                salida = linea;
                separarCadena(salida);
                
            }
            validarCadena(listaString);

            

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (lectorArchivo != null) {
                    lectorArchivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void separarCadena(String cadena) {
        String delim = " ";
        String[] temp;
        temp = cadena.split(delim);
        for (int i = 0; i < temp.length; i++) {
            listaString.add(temp[i]);
        }
    }

    public void validarCadena(ArrayList<String> cadenas) {
        auto = new Automata();
        Estado es;
        for (String cadena : cadenas) {
            es = auto.validarCadena(cadena, textoCaja);
            switch (es) {
                case SUMAR:
                    textoCaja.append(" Sumar\n");
                    break;
                case RESTAR:
                    textoCaja.append(" Restar\n");
                    break;
                case ASIGNAR:
                    textoCaja.append(" Asignar\n");
                    break;
                case ENTERO:
                    textoCaja.append(" Entero\n");
                    break;
                case LETRAS:
                    textoCaja.append(" Letras\n");
                    break;
                case PRINT:
                    textoCaja.append(" Palabra reservada print\n");
                    break;
                case ERROR:
                    textoCaja.append(" Error\n");
                    break;
                default:
                    break;
            }

        }
    }

}
