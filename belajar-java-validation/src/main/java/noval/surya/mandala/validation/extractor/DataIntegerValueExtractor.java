package noval.surya.mandala.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;
import noval.surya.mandala.validation.container.DataInteger;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = java.lang.Integer.class) DataInteger> {

    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger dataInteger, ValueReceiver valueReceiver) {
        valueReceiver.value(null, dataInteger.getData());
    }
}
