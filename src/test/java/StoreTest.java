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
    public void returnsNoResultsWhenNoProductsArePurchased() {
        try{
            List<Products> results = store.purchaseProducts(store.getProductsList());
            assertEquals(0,results.size());
        }catch (final RuntimeException e){
            fail();
        }

    }
    @Test
    @Order(2)
    public void setupProductsForFurtherTests() {
        try{
            store.addToCart(new Products(1,"Book",12.49, true, false));
            store.addToCart(new Products(2,"music CD", 14.99,false, false));
            store.addToCart(new Products(3,"chocolate bar",0.85, true, false));
            store.addToCart(new Products(4,"imported box of chocolates", 10.00, true, true));
            store.addToCart(new Products(5,"imported bottle of perfume",47.50, false,true));
            store.addToCart(new Products(6,"imported cheaper bottle of perfume", 27.99,false,true));
            store.addToCart(new Products(7,"bottle of perfume", 18.99, false, false));
            store.addToCart(new Products(8,"packet of headache pills", 9.75, true,false));
            store.addToCart(new Products(9,"different imported box of chocolates", 11.25, true, true));
            assertTrue(true);
        }catch (final RuntimeException e){
            fail();
        }
    }
    @Test
    @Order(3)
    public void returnsProductWhenProductIsSearched() {
        try{
            assertEquals("Book", store.cartContains("Book"));
        }catch (final RuntimeException e){
            fail();
        }

    }

    @Test
    @Order(4)
    public void returnsProductPriceWhenProductIsChosen() {
        try{
            assertEquals(12.49,store.getProductPrice("Book"));
        }catch (final RuntimeException e){
            fail();
        }

    }

    @Test
    @Order(5)
    public void returnsProductTaxWhenProductIsChosen() {
        try{
            assertEquals(12.50, store.getProductTotal("Book"));
            assertEquals(16.50, store.getProductTotal("music CD"));
        }catch (final RuntimeException e){
            fail();
        }

    }

    @Test
    @Order(6)
    public void returnsProductTaxAndImportTaxWhenProductIsChosen() {

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
            fail();
        }
    }

    @Test
    @Order(8)
    public void productsHaveIDs(){
        try{
            assertEquals(1, store.getProductIDinCart("Book"));

        }catch (final RuntimeException e){
            fail();
        }
    }

    @Test
    @Order(9)
    public void storeHasMultipleCarts(){
        try{
            store.createShoppingCart(new Carts(1, "Jim"));
            store.createShoppingCart(new Carts(2, "Larry"));
            assertEquals("Jim", store.getCartNameInStore(1));

        }catch (final RuntimeException e){
            fail();
        }
    }


}