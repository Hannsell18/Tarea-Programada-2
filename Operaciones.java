
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
     * Permite calcular el Máximo Común Divisor.
     * @param int numero1   Contiene el valor del número 1.
     * @param int numero2   Contiene el valor del número 2.
     * @return int  Contiene el mcd.
     */
    public int maximoComunDivisor(int numero1, int numero2){
        while(numero1 != numero2)
            if(numero1>numero2)
                numero1= numero1-numero2;
            else
                numero2= numero2 -numero1;
        
        return numero1;
    }
    
    /**
     * Método que se encarga de multiplicar dos ecuaciones.
     * @param Lista[] listaEcuaciones    Contiene un arreglo que a su vez contiene la lista de las ecuaciones.
     */
    public void multiplicar(Lista[] listaEcuaciones ){
        Lista ecuacion1 = listaEcuaciones[0];
        Lista ecuacion2 = listaEcuaciones[1];
        Lista nuevaEcuacion = new Lista();
        Nodo temporal1 = ecuacion1.getInicio();
        Nodo temporal2 = ecuacion2.getInicio();
        String signo = "+";
        
        while (temporal2 != null){
            temporal1 = ecuacion1.getInicio();
            while (temporal1 != null){
                if ((temporal2.getSigno()).equals(temporal1.getSigno())){
                    signo = "+";
                }
                else{
                    signo = "-";
                }
                nuevaEcuacion.agregar((temporal2.getValor() * temporal1.getValor()), "X",
                    (temporal2.getExponente() + temporal1.getExponente()), signo);
                temporal1 = temporal1.getSiguiente();
            }
            temporal2 = temporal2.getSiguiente();
        }
        ecuacion1.limpiar();
        ecuacion2.limpiar();
        System.out.println("Lista multiplicada:\n" + nuevaEcuacion.dato());
        nuevaEcuacion.simplificar();
        System.out.println("Lista simple:\n" + nuevaEcuacion.dato());
    }

    /**
     * Permite realiar la división de monomios.
     * @param Lista[] listaEcuaciones   Contiene un arreglo que a su vez contiene la lista de las ecuaciones.
     */
    public void dividir(Lista[] listaEcuaciones){
        Lista ecuacion1 = listaEcuaciones[0];
        Lista ecuacion2 = listaEcuaciones[1];
        Nodo temporal1 = ecuacion1.getInicio();
        Nodo temporal2 = ecuacion2.getInicio();
        String signo = "";
        int mcd = maximoComunDivisor(temporal2.getValor(), temporal1.getValor());
        
        if (temporal2.getSigno() == temporal1.getSigno()){
            signo = "+";
        }
        else{
            signo = "-";
        }
        temporal1.setValor(temporal1.getValor()/mcd);
        temporal2.setValor(temporal2.getValor()/mcd);
        if (temporal1.getExponente() > temporal2.getExponente()){
            temporal1.setExponente((temporal1.getExponente() - temporal2.getExponente()));
            temporal2.setExponente(0);
        }
        else if (temporal2.getExponente() > temporal1.getExponente()){
            temporal2.setExponente((temporal2.getExponente() - temporal1.getExponente()));
            temporal1.setExponente(0);
        }
        else{
            temporal1.setExponente(0);
            temporal2.setExponente(0); 
        }
        
        System.out.println("Lista dividida:\n" + ecuacion1.dato() + "/" + ecuacion2.dato());
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
            else if ((temporal == "*".charAt(0) || temporal == "/".charAt(0)) && 
                     (ecuacion.charAt(contador+1)) == "(".charAt(0)){
                operadorDeListas = (Character.toString(temporal));
            }
            else if (temporal == ")".charAt(0)){
                listaEcuaciones[indice].agregar(Integer.parseInt(valor), "X", Integer.parseInt(valorExponente), signoNodo);
                valor = ""; valorExponente = ""; signoNodo = "+"; incognita = false;
                if (indice == 0){
                    indice = 1;
                }
            }
        }
        System.out.println("Ecuación inicial: \n" + listaEcuaciones[0].dato() + operadorDeListas + listaEcuaciones[1].dato());
        listaEcuaciones[0].simplificar(); listaEcuaciones[1].simplificar();
        System.out.println("Ecuación simple: \n" + listaEcuaciones[0].dato() + operadorDeListas + listaEcuaciones[1].dato());
        if (operadorDeListas.equals("*")){
            multiplicar(listaEcuaciones);
        }
        else if (operadorDeListas.equals("/")){
            if (listaEcuaciones[0].getIndice() > 1 || listaEcuaciones[1].getIndice() > 1){
                System.out.println("Solo se pueden dividir monomios simples...");
            }
            else{
                dividir(listaEcuaciones);
            }
        }
    }
}
