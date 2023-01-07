package noval.surya.mandala.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import noval.surya.mandala.validation.extractor.DataIntegerValueExtractor;
import noval.surya.mandala.validation.extractor.DataValueExtractor;
import noval.surya.mandala.validation.extractor.EntryValueExtractorKey;
import noval.surya.mandala.validation.extractor.EntryValueExtractorValue;
import org.hibernate.validator.internal.engine.groups.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();

    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("========================");
        }
    }

    void validateWithException(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    void validateWithGorup(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("========================");
        }
    }

    @Test
    void validateExtractor(Object o) {

        Set<ConstraintViolation<Object>> violations = validator.validate(o);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("========================");
        }
    }

}
