
/**
 * Se encarga de realizar las operaciones aritmeticas.
 * 
 * @author Rodrigo Mendoza Quesada, C04813
 * @version (27-11-2020)
 */
public class Operaciones
{
    //Instancia de variables.
    private Lista[] listaEcuaciones;
    private String operadorDeListas;
    
    /**
     * Constructor por defecto de la clase.
     */
    public Operaciones(){
        listaEcuaciones = new Lista[2];
        operadorDeListas = "*";
    }
    
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

    /**
     * Divide el String en operaciones con monomios.
     * @param String ecuaccion   Contiene la ecuación a analizar.
     */
    public void setEcuacion(String ecuacion){
        char temporal;
        int indice = 0;
        String valor = "";
        String valorExponente = "";
        String signoNodo = "+";
        boolean incognita = false;
        for (int contador = 0; contador < ecuacion.length(); contador++){
            temporal = ecuacion.charAt(contador);
            if (temporal == "(".charAt(0)){
                listaEcuaciones[indice] = new Lista();
            }
            else if (temporal == "-".charAt(0) && !incognita && (ecuacion.charAt(contador+1)) != "(".charAt(0)){
                signoNodo = "-";
            }
            else if (Character.isDigit(temporal) && !incognita){
                valor += (Character.toString(temporal));
            }
            else if (temporal == "x".charAt(0) || temporal == "X".charAt(0)){
                incognita = true;
            }
            else if (Character.isDigit(temporal) && incognita){
                valorExponente += (Character.toString(temporal));
            }
            else if ((temporal == "+".charAt(0) || temporal == "-".charAt(0)) &&
                     (Character.isDigit(ecuacion.charAt(contador+1)))){
                listaEcuaciones[indice].agregar(Integer.parseInt(valor), "X", Integer.parseInt(valorExponente), signoNodo);
                valor = ""; valorExponente = ""; signoNodo = Character.toString(temporal); incognita = false;
            }
            else if ((temporal == "+".charAt(0) || temporal == "-".charAt(0) || temporal == "*".charAt(0) || 
                     temporal == "/".charAt(0)) && (ecuacion.charAt(contador+1)) == "(".charAt(0)){
                operadorDeListas = (Character.toString(temporal));
            }
            else if (temporal == ")".charAt(0)){
                listaEcuaciones[indice].agregar(Integer.parseInt(valor), "X", Integer.parseInt(valorExponente), signoNodo);
                valor = ""; valorExponente = ""; signoNodo = "+"; incognita = false;
                if (indice == 0){
                    indice = 1;
                    //contador = -1;
                }
            }
        }
        System.out.println(listaEcuaciones[0].dato() + operadorDeListas + listaEcuaciones[1].dato());
        listaEcuaciones[0].simplificar();
        listaEcuaciones[1].simplificar();
        System.out.println(listaEcuaciones[0].dato() + operadorDeListas + listaEcuaciones[1].dato());
    }
}
