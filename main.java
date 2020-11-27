public class main{
    public static void main(String args[]){
        //System.out.print("\f");
        Lista alfa = new Lista();
        alfa.agregar(4,"X",1);
        alfa.agregar(8,"X",2);
        alfa.agregar(12,"X",3);
        System.out.println(alfa.getIndice());
        System.out.println(alfa.dato(alfa.getInicio(),""));
        alfa.setEcuacion("(4X^2+7)*(3X^12+8X)");
    }
}