import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
/**
 * Write a description of class escribir here.
 * 
 * @author Rodrigo Mendoza Quesada (C04813)/ Hannsell Solís Ramírez (C07677)
 * @version (29-11-2020)
 */
public class Escribir
{
    public static void escribir (String respuesta){
        try{
            //Si el archivo no existe lo crea. 
            FileWriter fw=new FileWriter("Archivos/respuestas.txt", true);
            fw.write("\n"+ respuesta);
            fw.close();
        }catch(IOException ex){
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
