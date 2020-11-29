
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
    public String signo= "+", operadorLista="+", signoEntreEcuac="";

    /**
     * Permite dividir el String en operaciones con monomios.
     * @param String ecuacion   Contiene la ecuación a analizar.
     */
    public void setEcuacion(String ecuacion){
        char temporal;
        int longitud = ecuacion.length();
        String operadorEntreEcua="";

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
            
            //Guardar el operando que está entre los parentesis.
            if(temporal==")".charAt(0) && contador<longitud-1){
                signoEntreEcuac=Character.toString(ecuacion.charAt(contador+1));
                System.out.println(signoEntreEcuac);
             }
            //Buscar el valor y operador.
            if (temporal == "x".charAt(0) && (Character.isDigit(ecuacion.charAt(contador-1)))){
                if(Character.isDigit(ecuacion.charAt(contador-2))){
                    String valor1=Character.toString(ecuacion.charAt(contador-2));
                    String valor2=Character.toString(ecuacion.charAt(contador-1));
                    String valorCompleto=valor1+valor2;
                    valor= Integer.parseInt(valorCompleto);
                    if(ecuacion.charAt(contador-3)=="-".charAt(0)){
                        signo="-";                   
                    }else{
                        signo="+";
                    }
                }else{
                    valor=Character.getNumericValue(ecuacion.charAt(contador-1));
                    if(ecuacion.charAt(contador-2)=="-".charAt(0)){
                        signo="-";
                    }else{
                        signo="+";
                    }
                }      
            }
            
            //Si solo sale un número.
            //if(Character.isDigit(temporal) && ecuacion.charAt(contador-1)!="^".charAt(0)){
              //  valor=Character.getNumericValue(temporal);
              //  exponente=1;
              //  operadorLista="";
              //  signoEntreEcuac="";
              //  agregar(operadorLista, valor, "X", exponente, signo, signoEntreEcuac);
            //}

            //Asignar el valor del exponente después del "^". Y mandar la información del nodo.
            if(temporal =="^".charAt(0)){
                exponente = Character.getNumericValue(ecuacion.charAt(contador+1));
                agregar(operadorLista, valor, "X", exponente, signo, signoEntreEcuac);
                operadorLista="";
                signo="+";
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
    public void agregar(String operadorLista,int valor, String incognita, int exponente, String signo, String signoEntreEcuac){
        Nodo alfa = new Nodo (operadorLista, valor, incognita, exponente, signo, signoEntreEcuac);
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
