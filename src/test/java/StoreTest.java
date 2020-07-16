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
    public void returnsProductWhenProductIsSearched() throws Exception{
        Store store = new Store();
        store.addToCart(new Products("Book",12.49, true));
        assertEquals("Book", store.cartContains("Book"));
    }

    @Test
    public void returnsProductPriceWhenProductIsChosen() throws Exception{
        Store store = new Store();
        store.addToCart(new Products("Book", 12.49, true));
        assertEquals(12.49,store.getProductPrice("Book"));
    }

    @Test
    public void returnsProductTaxWhenProductIsChosen(){
        Store store = new Store();
        store.addToCart(new Products("Book", 12.49, true));
        store.addToCart(new Products("music CD", 14.99,false));
        assertEquals(12.49, store.getProductTotal("Book"));
        assertEquals(16.50, store.getProductTotal("music CD"));
    }


}