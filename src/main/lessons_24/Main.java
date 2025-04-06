package main.lessons_24;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Start");


        anotherMethod();

        Logger logger3 = Logger.getInstance();
        logger3.log("End");


        System.out.println("logger1 == logger3: " + (logger1 == logger3));
    }

    public static void anotherMethod() {
        Logger logger2 = Logger.getInstance();
        logger2.log("Log next");
    }
}
