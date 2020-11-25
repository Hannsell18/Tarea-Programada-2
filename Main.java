import javax.swing.JOptionPane;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String []args){
        ListaEcuación l= new ListaEcuación();
        int op=0;
        do{
            String eleccion=JOptionPane.showInputDialog(null, "Agregar ecuaciones\n1-Insertar\n2-Mostrar \n 3-Salir");
            op=Integer.parseInt(eleccion);

            switch(op){
                case 1:
                {
                    String incognita;
                    int potencia,valor;
                    valor=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor"));
                    incognita=JOptionPane.showInputDialog(null,"Ingrese la incognita");
                    potencia=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la potencia"));
                    l.insertar(new FragmentoN(incognita, valor,potencia));
                    break;
                }
                
                case 2:{
                 l.desplegar();
                 break;
                }
                
            }
        }while(op!=3);

    }
}
