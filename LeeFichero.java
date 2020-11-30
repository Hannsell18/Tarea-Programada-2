import java.io.*;
import javax.swing.JOptionPane;
/**
 * Se encarga de analizar el elarchivo .txt, convertirlo en un string y enviarlo al main. 
 * 
 * @author Rodrigo Mendoza Quesada (C04813)/ Hannsell Solís Ramírez (C07677).
 * @version 29-11-2020.
 */
class LeeFichero {
    public static String leer(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String ecuacion="";
        String nombre= JOptionPane.showInputDialog ("Por favor digite la direción entera del archivo a buscar ;)"
                +"\n Tome como ejemplo: nombredelfichero.txt");
        try {
            //Inicializar.\n Tome como ejemplo: C:\\Users\\pepe\\Downloads\\Fichero\\nombredelfichero.txt
            archivo = new File ("Archivos/"+nombre);  
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Recorrer el fichero y almacenarlo en un string.
            String linea;
            while((linea=br.readLine())!=null)
                ecuacion +=linea;

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        //Enviar el string al main.
        return ecuacion;
    }
}
