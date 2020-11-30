import javax.swing.JOptionPane;
/**
 * Se encarga de invocar las clases necesarias para realizar el ingreso de datos por medio de archivos o manualmente.
 * 
 * @author Rodrigo Mendoza Quesada (C04813)/ Hannsell Solís Ramírez (C07677).
 * @version 29-11-2020.
 */
public class main{
    public static void main(String args[]){
        Operaciones alfa = new Operaciones();
        String ecuacion="";
        String entrada="";
        String respuesta;
        entrada= JOptionPane.showInputDialog ("Menú\n"
            + "Esta calculadora se encarga de simplificar ecuaciones.\n"
            + "a. Deseas ingresar el problema manualmente.\n"
            + "b. Usar un archivo txt donde se encuentre el problema.\n"
            + "c. SALIR\n");
        //Elegir entre las opciones
        switch (entrada.toLowerCase()){
            case "a":
            ecuacion=JOptionPane.showInputDialog("Por favor digite el par de ecuaciones que desea simplificar ;)");
            alfa.setEcuacion(ecuacion);
            respuesta=alfa.setEcuacion(ecuacion);
            Escribir.escribir(Operaciones.modificarCadena(ecuacion, respuesta));
            System.exit(0);

            case "b":
            LeeFichero beta= new LeeFichero();
            ecuacion=Operaciones.modificarCadena(beta.leer());
            respuesta=alfa.setEcuacion(ecuacion);
            Escribir.escribir(Operaciones.modificarCadena(ecuacion, respuesta));
            System.exit(0);

            case "c":

            System.exit(0);
        }
    }

}

