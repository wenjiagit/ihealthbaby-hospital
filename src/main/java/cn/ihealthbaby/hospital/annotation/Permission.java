package cn.ihealthbaby.hospital.annotation;

import java.lang.annotation.*;

/**
 * @author zuoge85 on 15/7/13.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    String[] value();
}