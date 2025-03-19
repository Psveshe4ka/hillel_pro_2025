package main.lessons_21;

import java.lang.reflect.Method;

public class AnnotationDemo {

    public static void main(String[] args) {
        Class<ArrayUtils> clazz = ArrayUtils.class;


        Method[] methods = clazz.getDeclaredMethods();


        for (Method method : methods) {

            if (method.isAnnotationPresent(MethodInfo.class) && method.isAnnotationPresent(Author.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);

                System.out.println("Method Name: " + methodInfo.name());
                System.out.println("Return Type: " + methodInfo.returnType());
                System.out.println("Description: " + methodInfo.description());
                System.out.println("Author: " + author.name() + " " + author.surname());
                System.out.println();
            }
        }
    }
}

