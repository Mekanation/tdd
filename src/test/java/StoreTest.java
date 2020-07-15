import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StoreTest {
    @Test
    public void returnsNoResultsWhenNoProductsArePurchased() throws Exception {
        Store store = new Store();
        List<Products> empty = new ArrayList<>();
        List<Products> results = store.purchaseCart(empty);

        assertEquals(0,results.size());
    }


}