package org.sorinb.spring.training.endpoint;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface Logable {
    String value() default "DEFAULT";
}