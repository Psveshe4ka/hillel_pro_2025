package main.lessons_3;

public class lessons_3 {private static final double Con_F = 5.0/9.0;

    public static void main (String [] args){
        System.out.println("Version 3.0");
        double F = 32;
        double C = 0;
        double Celseresult = convCtoF(F);
        double Fahrenheitresult = convFtoC(C);
        System.out.println("Result is "+ Celseresult + " degrees Celsius and " + Fahrenheitresult +" degrees fahrenheit.");
        System.out.println("Change Factor branch");
    }
    private static double convCtoF (double Celse) {
        return (Celse-32)* Con_F;
    }
    private static  double convFtoC (double Fahrenheit) {
        return (Fahrenheit/Con_F)+32;
    }

}
