
/**
 * Se encarga de realizar las operaciones aritmeticas.
 * 
 * @author Rodrigo Mendoza Quesada, C04813
 * @version (27-11-2020)
 */
public class Operaciones
{
   /**
    * Permite la suma de dos números enteros.
    * @param int numero1    Contiene el primer entero.
    * @param int numero2    Contiene el segundo entero.
    */
   public static int suma(int numero1, int numero2){
       return numero1 + numero2;
   }
   
   /**
    * Permite la resta de dos números enteros.
    * @param int numero1    Contiene el primer entero.
    * @param int numero2    Contiene el segundo entero.
    */
   public static int resta(int numero1, int numero2){
       return Math.abs(numero1 + numero2);
   }
}
