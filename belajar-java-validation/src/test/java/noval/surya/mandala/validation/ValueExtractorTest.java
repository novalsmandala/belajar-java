package noval.surya.mandala.validation;

import jakarta.validation.Validation;
import noval.surya.mandala.validation.container.Data;
import noval.surya.mandala.validation.container.DataInteger;
import noval.surya.mandala.validation.container.Entry;
import noval.surya.mandala.validation.extractor.DataValueExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest{

    @Test
    void testSampleData() {

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setData(" ");

        validate(sampleData);
    }

    @Test
    void testSampleEtry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey(" ");
        sampleEntry.getEntry().setValue(" ");

        validate(sampleEntry);
    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(1);

        validate(sampleDataInteger);

    }
}
