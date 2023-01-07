package noval.surya.mandala.validation;

import jakarta.validation.constraints.NotBlank;
import noval.surya.mandala.validation.container.Entry;

public class SampleEntry {

    private Entry<@NotBlank String, @NotBlank String> entry;

    public Entry<String, String> getEntry() {
        return entry;
    }

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }
}
