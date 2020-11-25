
/**
 * Se encarga de tener los atributos de cada fragmento dentro de un respectivo parentesis. [(FRAGMENTO)(FRAGEMENTO)]
 *                                                                                                [ECUACIÓN]
 * @author (your name) 
 * @version 15/11/2020
 */
public class FragmentoN
{
    //Declarar variables.
    private String incognita;
    private int valor, potencia;

    //Constructor. 
    public FragmentoN(String incognita,int valor,int potencia){
        this.incognita=incognita;
        this.valor=valor;
        this.potencia=potencia;
    }

    public String toString(){
        return "Fragmento de la ecuación: "+getvalor()+ getincognita()+ "^"+ getpotencia();
    }
    //Asignar la incognita.
    public String getincognita(){
        return incognita;
    }

    public void setincognita(String incognita){
        this.incognita=incognita;
    }

    //Asignar el valor.
    public int getvalor(){
        return valor;
    }

    public void setvalor(int valor){
        this.valor=valor;
    }

    //Asignar la potancia.
    public int getpotencia(){
        return potencia;
    }

    public void setpotencia(int potencia){
        this.potencia=potencia;
    }

}
