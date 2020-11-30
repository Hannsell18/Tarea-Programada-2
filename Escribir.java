import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
/**
 * Write a description of class escribir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escribir
{
    public static void escribir (String respuesta){
        try{
            //Si el archivo no existe lo crea. 
            FileWriter fw=new FileWriter("Archivos/intento.txt", true);
            fw.write("\n"+ respuesta);
            fw.close();
        }catch(IOException ex){
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
