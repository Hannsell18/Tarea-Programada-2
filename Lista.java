
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
    public int valor=0, exponente=1;
    public String signo= "+", operadorLista="+";

    /**
     * Permite dividir el String en operaciones con monomios.
     * @param String ecuacion   Contiene la ecuación a analizar.
     */
    public void setEcuacion(String ecuacion){
        char temporal;
        int longitud = ecuacion.length();

        for (int contador = 0; contador < longitud; contador++){
            temporal = ecuacion.charAt(contador);

            //Analizar si hay un signo antes del parentesis abierto. A la vez, otorgarle el valor a la variable.
            if(temporal=="(".charAt(0)){ 
                //INICIAR NUEVA LISTA
                Lista alfa = new Lista();

                if(contador>0 && ecuacion.charAt(contador-1)=="-".charAt(0)){
                    operadorLista="-";
                }else if(contador>0 && ecuacion.charAt(contador-1)=="*".charAt(0)){
                    operadorLista="*";
                }else{
                    operadorLista="+";
                }
            }

            //Buscar el valor.
            if (temporal == "x".charAt(0) && (Character.isDigit(ecuacion.charAt(contador-1)))){
                if(Character.isDigit(ecuacion.charAt(contador-2))){
                    valor=22;
                    //Character.getNumericValue(ecuacion.charAt(contador-1) + ecuacion.charAt(contador-2));
                    //Aquí falla la unión. 
                }else{
                    valor=Character.getNumericValue(ecuacion.charAt(contador-1));
                }      
            }
            if(Character.isDigit(temporal)){
                valor=temporal;
            }

            //Asignar el valor de los operadores. 
            if(temporal == "-".charAt(0)){
                signo="-";
            } 
            if(temporal == "*".charAt(0)){
                signo="*";
            }
            if(temporal == "+".charAt(0)){
                signo="+";
            }

            //Asignar el valor del exponente después del "^". Y mandar la información del nodo. 
            if(temporal =="^".charAt(0)){
                exponente = Character.getNumericValue(ecuacion.charAt(contador+1));
                agregar(operadorLista, valor, "X", exponente, signo);
                operadorLista="";
                signo="+";
            }

            if(temporal==")".charAt(0)){                
                signo= Character.toString(temporal);

                operadorLista="";
                //CERRAR LISTA. 

            }
        }
    }

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
    public void agregar(String operadorLista,int valor, String incognita, int exponente, String signo){
        Nodo alfa = new Nodo (operadorLista, valor, incognita, exponente, signo);
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
                    if (comparado.getSigno() == siguienteNodo.getSigno()){
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

}
