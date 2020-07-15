import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StoreTest {
    @Test
    public void returnsNoResultsWhenNoProductsArePurchased() throws Exception {
        Store store = new Store();

        List<Products> results = store.purchaseProducts(store.getCart());

        assertEquals(0,results.size());
    }


    @Test
    public void returnsProductWhenProductIsPurchased() throws Exception{
        Store store = new Store();
        store.addToCart(new Products("Book"));

        List<Products> results = store.purchaseProducts(store.getCart());
        assertEquals("Book", store.cartContains("Book"));
    }


}