package noval.surya.mandala.reflection.validation;

import noval.surya.mandala.reflection.annotation.NotBlank;

import java.lang.reflect.Field;

public class ValidateNoteBlank {

    public static void validateNotBlank(Object object) throws IllegalAccessException {

        // get class
        Class<?> aClass = object.getClass();

        // get all field
        Field[] declaredField = aClass.getDeclaredFields();

        for (var field : declaredField) {

            // get not blank annotation
            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            // check if @NotBlank is exists
            if (notBlank != null) {

                // get field value
                field.setAccessible(true);
                String value = (String) field.get(object);

                if (notBlank.allowEmptyString()) {
                    // allow empty string
                    // ignore
                } else {
                    // not allow empty string
                    // remove white space
                    value = value.trim();
                    // check if value is empty string
                    if ("".equals(value)){
                        throw new RuntimeException(field.getName() + " must not blank");
                    }
                }
            }
        }
    }
}
