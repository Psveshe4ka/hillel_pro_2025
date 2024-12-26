package  main.lessons_2;

public class Main {private static final double CONV_M = 1.60934;

    public static void main (String [] args){
        System.out.println("Version 2.0");
        double Miles = 1;
        double Kils = 10;
        double kilos = convKgsToPounds(Miles);
        double miles = convPoundsToKgs(Kils);
        System.out.println("Result is "+ miles + " Miles and " + kilos +" Kilometrs.");
    }
    private static double convKgsToPounds (double Miles){
        return Miles * CONV_M;
    }
    private static  double convPoundsToKgs (double Kilos){
        return  Kilos / CONV_M;
    }
}
//probably name the variables incorrectly,
