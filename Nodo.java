
/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version 15/11/2020
 */
public class Nodo
{
    private Nodo siguiente;
    private FragmentoN dato;

    public Nodo(FragmentoN dato, Nodo siguiente){
        this.siguiente=siguiente;
        this.dato=dato;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente){
        this.siguiente=siguiente;
    }
    
    public FragmentoN getDato(){
        return dato;
    }
    public void setDato(FragmentoN dato){
        this.dato=dato;
    }
    
}
