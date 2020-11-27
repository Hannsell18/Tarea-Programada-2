
/**
 * Se encarga del manejo de listas para la ecuación.
 * 
 * @author Rodrigo Mendoza Quesada.
 * @version 17-11-2020.
 */
public class Lista
{
    //Instania de variables.
    private Nodo inicio;
    private int indice;

    /**
     * Constructor por defecto de la clase.
     */
    public Lista()
    {
        //Inicialización de variables.
        inicio = null;
        indice = 0;
    }

    /**
     * Método encargado de crear y agregar un nuevo elemento.
     * @param int valor Valor de la constante.
     * @param String incognita  Incognita de la ecuación.
     * @param int exponente Contiene el exponente de la ecuación.
     */
    public void agregar(int valor, String incognita, int exponente){
        Nodo alfa = new Nodo (valor, incognita, exponente);
        if (inicio == null){
            inicio = alfa;
            indice ++;
        }
        else{
            Nodo actual = inicio;
            while (actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(alfa);
            indice ++;
        }
    }
    
    /**
     * Permite obtener el primer nodo de la lista.
     * @return Nodo Contiene el valor de inicio de la lista de ecuaciones.
     */
    public Nodo getInicio(){
        return inicio;
    }
    
    /**
     * Permite obtener el indice de la lista.
     * @return int.
     */
    public int getIndice(){
        return indice;
    }
    
    /**
     * Retorna de forma recursiva la lista de ecuaciones.
     * @param Nodo inicio   Contiene el primer nodo de la lista de ecuaciones.
     * @param String ecuacion   Contiene una lista donde se anotan las ecuaciones.
     */
    public String dato(Nodo inicio, String ecuacion){
        if (inicio.getSiguiente() != null){
            return dato(inicio.getSiguiente(), ecuacion += inicio.dato());
        }
        return ecuacion + inicio.dato();
    }
    
    /**
     * Permite dividir el String en operaciones con monomios.
     * @param String ecuacion   Contiene la ecuación a analizar.
     */
    public void setEcuacion(String ecuacion){
        char temporal;
        int longitud = ecuacion.length();
        for (int contador = 0; contador < longitud; contador++){
            temporal = ecuacion.charAt(contador);
            if (temporal == "(".charAt(0)){
                System.out.println("Abro una nueva lista...");
            }
            else if (temporal == ")".charAt(0)){
                System.out.println("Cierro la lista...");
            }
        }
    }
    
    /**
     * Permite realizar la suma entre monomios, de ser posible...
     */
    public void suma(){
        Nodo comparado = inicio;
        Nodo siguienteNodo = comparado.getSiguiente();
        Nodo temporal;
        int resultado;
        for (int contador = 0; contador < indice; contador++){
            while (comparado != null && siguienteNodo != null){
                if (comparado.getExponente() == siguienteNodo.getExponente()){                    
                    resultado = comparado.getValor() + siguienteNodo.getValor();
                    comparado.setValor(resultado);
                    if (siguienteNodo.getSiguiente() != null){
                        temporal = siguienteNodo.getSiguiente();
                        comparado.setSiguiente(temporal);
                    }
                    else{
                        temporal = comparado;
                        while (temporal.getSiguiente() != siguienteNodo){
                            temporal = temporal.getSiguiente();
                        }
                        temporal.setSiguiente(null);
                    }
                    indice --;
                    siguienteNodo = comparado.getSiguiente();
                }
                else{
                    siguienteNodo = siguienteNodo.getSiguiente();
                }
            }
            if(comparado.getSiguiente() != null){
                comparado = comparado.getSiguiente();
                if (comparado.getSiguiente() != null){
                    siguienteNodo = comparado.getSiguiente();
                }
            }
        }
    }
}
