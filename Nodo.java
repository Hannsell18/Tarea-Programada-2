
/**
 * Write a description of class Nodo here.
 * 
 * @author Rodrigo Mendoza Quesada.
 * @version 17-11-2020.
 */
public class Nodo
{
    //Instancia de variables.
    private int valor;
    private String incognita;
    private int exponente;
    private Nodo siguiente;

    /**
     * Constructor por defecto de la clase.
     */
    public Nodo()
    {
        //Inicializción de variables.
        valor = 0;
        incognita = "x";
        exponente = 0;
        siguiente = null;
    }
    
    /**
     * Constructor con parámetros de la clase.
     * @param int valor Valor de la constante.
     * @param String incognita  Incognita de la ecuación.
     * @param int exponente Contiene el exponente de la ecuación.
     */
    public Nodo(int valor, String incognita, int exponente){
        this.valor = valor;
        this.incognita = incognita;
        this.exponente = exponente;
        siguiente = null;
    }
    
    /**
     * Retorna el valor del nodo.
     * @return int  Contiene el valor númerico del nodo.
     */
    public int getValor(){
        return this.valor;
    }
    
    /**
     * Retorna el valor de la incognita.
     * @return String  Contiene la incognita de la ecuación.
     */
    public String getIncognita(){
        return this.incognita;
    }
    
    /**
     * Retorna el exponente del nodo.
     * @return int  Contiene el exponente del nodo.
     */
    public int getExponente(){
        return this.exponente;
    }
    
    /**
     * Permite establecer el valor del nodo.
     * @param int valor Contiene el valor a agregar.
     */
    public void setValor(int valor){
        this.valor = valor;
    }
    
    /**
     * Permite establecer la incognita del nodo.
     * @param String incognita Contiene el valor de la incognita a agregar.
     */
    public void setIncognita(String incognita){
        this.incognita = incognita;
    }
    
    /**
     * Permite establecer el exponente del nodo.
     * @param int exponente Contiene el exponente a agregar.
     */
    public void setExponente(int exponente){
        this.exponente = exponente;
    }
    
    /**
     * Permite establecer el valor del siguiente Nodo.
     * @param Nodo siguiente    Contiene el Nodo que será asignado.
     */
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    /**
     * Retorna el Nodo siguiente.
     * @return Nodo siguiente   Contiene una referencia hacia el nodo siguiente.
     */
    public Nodo getSiguiente(){
        return siguiente;
    }
    
    /**
     * Retorna un String con los datos del nodo.
     * @return String dato  Contiene un String estructurado con los datos
     */
    public String dato(){
        String dato = "";
        dato = valor + incognita + "^" +exponente +" ";
        return dato;
    }
}
