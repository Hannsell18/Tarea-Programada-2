import javax.swing.JOptionPane;
public class main{
    public static void main(String args[]){
        //System.out.print("\f");
        Lista alfa = new Lista();
        //alfa.agregar(4,"X",1);
        //alfa.agregar(8,"X",2);
        //alfa.agregar(12,"X",3);
        String ecuacion=JOptionPane.showInputDialog("Por favor digite la ecuación que desea simplificar ;)");
        alfa.setEcuacion(ecuacion);
        System.out.println(alfa.getIndice());
        System.out.println(alfa.dato(alfa.getInicio(),""));
        alfa.suma();
        System.out.println(alfa.getIndice());
        System.out.println(alfa.dato(alfa.getInicio(),""));
        //Intento.
    }
}
