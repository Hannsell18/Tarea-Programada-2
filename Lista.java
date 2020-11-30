
/**
 * Se encarga del manejo de listas para la ecuación.
 * 
 * @author Rodrigo Mendoza Quesada (C04813)/ Hannsell Solís Ramírez (C07677)
 * @version 17-11-2020.
 */
public class Lista
{
    //Instania de variables.
    private Nodo inicio;
    private int indice;
    private String signo;

    /**
     * Constructor por defecto de la clase.
     */
    public Lista()
    {
        //Inicialización de variables.
        inicio = null;
        indice = 0;
        signo = "+";
    }

    /**
     * Método encargado de crear y agregar un nuevo elemento.
     * @param int valor Valor de la constante.
     * @param String incognita  Incognita de la ecuación.
     * @param int exponente Contiene el exponente de la ecuación.
     */
    public void agregar(int valor, String incognita, int exponente, String signo){
        Nodo alfa = new Nodo (valor, incognita, exponente, signo);
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
     * Permite eliminar un nodo.
     * @param Nodo ecuacion Contiene el nodo que será eliminado.
     */
    public void eliminar(Nodo ecuacion){
        Nodo temporal = inicio;
        while (temporal.getSiguiente() != ecuacion && inicio != ecuacion){
            temporal = temporal.getSiguiente();
        }
        if (inicio == ecuacion){
            inicio = inicio.getSiguiente();
        }
        else if (temporal.getSiguiente().getSiguiente() != null){
            temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
        }
        else{
            temporal.setSiguiente(null);
        }
        indice --;
    }
    
    /**
     * Permite limpiar la lista.
     */
    public void limpiar(){
        inicio = null;
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
     * Permite obtener el signo de la lista.
     * @return String   Retorna el signo que posee la lista.
     */
    public String getSigno(){
        return signo;
    }
    
    /**
     * Permite establecer el signo de la lista.
     * @param String signo  Contiene el signo por agregar.
     */
    public void setSigno(String signo){
        this.signo = signo;
    }

    /**
     * Permite realizar la simplificación de la ecuación, de ser posible...
     */
    public void simplificar(){
        Nodo comparado = inicio;
        Nodo siguienteNodo = comparado.getSiguiente();
        Nodo temporal;
        int resultado;
        for (int contador = 0; contador < indice; contador++){
            while (comparado != null && siguienteNodo != null){
                if (comparado.getExponente() == siguienteNodo.getExponente()){
                    if (comparado.getSigno().equals(siguienteNodo.getSigno())){
                        comparado.setValor(Operaciones.suma(comparado, siguienteNodo));
                    }
                    else if (comparado.getSigno() != siguienteNodo.getSigno()) {
                        if (comparado.getValor() < siguienteNodo.getValor()){
                            comparado.setSigno(siguienteNodo.getSigno());
                        }
                        comparado.setValor(Operaciones.resta(comparado, siguienteNodo));
                    }
                    eliminar(siguienteNodo);
                    if (comparado.getValor() == 0){
                        eliminar(comparado);
                    }
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
    
    /**
     * Básicamente un señuelo.
     */
    public String dato(){
        return dato(inicio, "");
    }
    
    /**
     * Retorna de forma recursiva la lista de ecuaciones.
     * @param Nodo inicio   Contiene el primer nodo de la lista de ecuaciones.
     * @param String ecuacion   Contiene una lista donde se anotan las ecuaciones.
     */
    public String dato(Nodo inicio, String ecuacion){
        if (inicio.getSiguiente() != null){
            return dato(inicio.getSiguiente(), ecuacion += inicio.dato(this.inicio));
        }
        return "(" + ecuacion + inicio.dato(this.inicio) + ")";
    }
}
