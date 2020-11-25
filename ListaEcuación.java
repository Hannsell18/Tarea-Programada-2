import javax.swing.JOptionPane;
/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version 15/11/2020
 */
public class ListaEcuación
{
    private Nodo inicio;
    private Nodo fin;

    //Inicializar variables.
    public ListaEcuación(){
        inicio=null;
        fin= null;
    }

    //Verificar si existe algún nodo dentro de las listas de Ecuaciones.. 
    public boolean estaVacia(){
        if (inicio==null){
            return true;
        }else{
            return false;
        }
    }

    public void insertar(FragmentoN fragmentoN){
        Nodo actual;  

        if(estaVacia()){
            //Primer Nodo. 
            actual= new Nodo (fragmentoN,null);
            inicio=actual;
            fin=actual;
        }else{
            //hacer nuevo nodo.
            actual= new Nodo(fragmentoN,null);
            //otorgarle al nuevo nodo el valor de fin.
            fin.setSiguiente(actual);
            //actualizar referencia. 
            fin=actual;
        }
    }

    public void desplegar(){
        if(estaVacia()){
            JOptionPane.showMessageDialog(null,"Vacía");
            return;
        }else{
            Nodo temporal=inicio;
            while(temporal!=null){
                JOptionPane.showMessageDialog(null, temporal.getDato().toString());
                temporal=temporal.getSiguiente();
            }
        }
    }

}
