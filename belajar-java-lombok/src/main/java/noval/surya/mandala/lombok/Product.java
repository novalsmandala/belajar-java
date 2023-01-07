package noval.surya.mandala.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
// override annotation
@RequiredArgsConstructor
@ToString(exclude = "price")
@AllArgsConstructor
public class Product {

    private final String id;

    private String name;

    private Long price;
}
