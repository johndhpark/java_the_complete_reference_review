import java.lang.annotation.*; // we need it to use @Retention
import java.lang.reflect.*; // we need it to use .getMethod() 

// An annotation type declaration that includes defaults.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str()

    default "Testing";

    int val() default 9000;
}

class Meta4 {

    // Annotate a method using the default values.
    @MyAnno()
    public static void myMeth() {
        Meta4 ob = new Meta4();

        // Obtain the annotation for this method
        // and display the values of the members.
        try {
            Class<?> cl = ob.getClass();

            Method m = cl.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}