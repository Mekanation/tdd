import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StoreTest {
    Store store = Store.getInstance();



    @Test
    @Order(1)
    public void returnsNoResultsWhenNoProductsArePurchased() throws Exception {

        List<Products> results = store.purchaseProducts(store.getCart());
        assertEquals(0,results.size());
    }
    @Test
    @Order(2)
    public void setupProductsForFurtherTests() throws Exception {
        try{
            store.addToCart(new Products("Book",12.49, true, false));
            store.addToCart(new Products("music CD", 14.99,false, false));
            store.addToCart(new Products("chocolate bar",0.85, true, false));
            store.addToCart(new Products("imported box of chocolates", 10.00, true, true));
            store.addToCart(new Products("imported bottle of perfume",47.50, false,true));
            store.addToCart(new Products("imported cheaper bottle of perfume", 27.99,false,true));
            store.addToCart(new Products("bottle of perfume", 18.99, false, false));
            store.addToCart(new Products("packet of headache pills", 9.75, true,false));
            store.addToCart(new Products("different imported box of chocolates", 11.25, true, true));
            assertTrue(true);
        }catch (final RuntimeException e){
            System.out.println("Products were not implemented");
        }
    }
    @Test
    @Order(3)
    public void returnsProductWhenProductIsSearched() throws Exception{
        assertEquals("Book", store.cartContains("Book"));
    }

    @Test
    @Order(4)
    public void returnsProductPriceWhenProductIsChosen() throws Exception{
        assertEquals(12.49,store.getProductPrice("Book"));
    }

    @Test
    @Order(5)
    public void returnsProductTaxWhenProductIsChosen(){
        assertEquals(12.50, store.getProductTotal("Book"));
        assertEquals(16.50, store.getProductTotal("music CD"));
    }

    @Test
    @Order(6)
    public void returnsProductTaxAndImportTaxWhenProductIsChosen(){
        assertEquals(54.65, store.getProductTotal("imported bottle of perfume"));
        assertEquals(16.50, store.getProductTotal("music CD"));
    }

    @Test
    @Order(7)
    public void affirmsOnlyOneStoreCanExist(){
    try{
        Store store2 = Store.getInstance();
        if(System.identityHashCode(store) != System.identityHashCode(store2)){
            fail("Store should not have been instantiate-able");
        }
        assertTrue(true);

    }catch (final RuntimeException e){
        System.out.println("Store was instantiated multiple times");
    }


    }


}