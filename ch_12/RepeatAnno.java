// Demonstrate a repeated annotation

import java.lang.annotation.*;
import java.lang.reflect.*;

// Make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
    String str() default "Testing";

    int val() default 900;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}

class RepeatAnno {
    // Repeat MyAnno on myMeth()
    //
    @MyAnno(str = "First annotation", val = -1)
    @MyAnno(str = "Second annotation", val = 100)
    public static void myMeth(String str, int v) {
        RepeatAnno ob = new RepeatAnno();
        Class<?> c = ob.getClass();
        try {
            Method m = c.getMethod("myMeth", String.class, int.class);

            // All annotation implement the Annotation interface,
            // therefore this is ok.
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println("No Method Found");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
