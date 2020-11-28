
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
    * @param Nodo ecuacion1    Contiene la primer ecuación.
    * @param Nodo ecuacion2    Contiene la seguna ecuación.
    */
   public static int suma(Nodo ecuacion1, Nodo ecuacion2){
       return ecuacion1.getValor() + ecuacion2.getValor();
   }
   
   /**
    * Permite la resta de dos números enteros.
    * @param Nodo ecuacion1    Contiene la primer ecuación.
    * @param Nodo ecuacion2    Contiene la seguna ecuación.
    */
   public static int resta(Nodo ecuacion1, Nodo ecuacion2){
       return Math.abs(ecuacion1.getValor() - ecuacion2.getValor());
   }
}
