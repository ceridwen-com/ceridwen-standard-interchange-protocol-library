package com.ceridwen.circulation.SIP.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ceridwen.circulation.SIP.fields.FieldPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TaggedField {
    FieldPolicy value() default FieldPolicy.DEFAULT;
}