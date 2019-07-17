package AnnotationTest;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Annotation1 {
    String value() default "haha";

    String name() default "zz";
}
