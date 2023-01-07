package noval.surya.mandala.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import noval.surya.mandala.validation.container.Entry;

public class EntryValueExtractorKey implements ValueExtractor<Entry<@ExtractedValue ?, ?>> {

    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "key", entry.getKey());
    }
}
