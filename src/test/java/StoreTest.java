import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StoreTest {
    Store store = Store.getInstance();


    @Test
    @Order(1)
    public void checksIfShelfIsNull() {
        try {
            assertNotNull(store.getAllProducts());
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(2)
    public void setupProductsForFurtherTests() {
        try {
            store.addToShelf(Products.book);
            store.addToShelf(Products.music_cd);
            store.addToShelf(Products.chocolate_bar);
            store.addToShelf(Products.imported_box_of_chocolates);
            store.addToShelf(Products.imported_bottle_of_perfume);
            store.addToShelf(Products.imported_cheaper_bottle_of_perfume);
            store.addToShelf(Products.bottle_of_perfume);
            store.addToShelf(Products.packet_of_headache_pills);
            store.addToShelf(Products.different_imported_box_of_chocolates);
            assertTrue(true);
        } catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(3)
    public void returnsProductWhenProductIsSearched() {
        try {
            assertEquals("Book", store.shelfContains("Book"));
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(4)
    public void returnsProductPrice() {
        try {
            assertEquals(12.49, Products.book.getProductPrice());
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(5)
    public void returnsProductTax() {
        try {
            assertEquals(12.49, Products.book.getPriceWithTax());
            assertEquals(16.49, Products.music_cd.roundToTenths(Products.music_cd.getPriceWithTax()));
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(6)
    public void returnsProductTaxAndImportTax() {
        assertEquals(54.65, Products.imported_bottle_of_perfume.roundToTenths(Products.imported_bottle_of_perfume.getPriceWithTax()));;
    }

    @Test
    @Order(7)
    public void affirmsOnlyOneStoreCanExist() {
        try {
            Store store2 = Store.getInstance();
            if (System.identityHashCode(store) != System.identityHashCode(store2)) {
                fail("Store should not have been instantiate-able");
            }
            assertTrue(true);

        } catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(8)
    public void productsHaveIDs() {
        try {
            assertEquals(1, store.getProductIDinCart("Book"));

        } catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(9)
    public void storeHasMultipleCarts() {
        try {
            store.addShoppingCartToStore(new Carts(1, "Jim"));
            store.addShoppingCartToStore(new Carts(2, "Larry"));
            assertEquals("Jim", store.getCartNameInStore(1));

        } catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(10)
    public void productsCanBeAddedToDifferentCarts() {
        try {
            Carts julie = new Carts(3, "Julie");
            Carts john = new Carts(5, "John");
            store.addShoppingCartToStore(julie);
            store.addShoppingCartToStore(john);
            julie.addProductToCart(Store.getProductOffShelf(1));
            john.addProductToCart(Store.getProductOffShelf(1));
            for (Carts cart : store.getCartsInStore()) {
                if(cart.getName().equals("Julie") || cart.getName().equals("John")){
                    assertTrue(cart.containsProduct("Book"));
                }

            }

        } catch (final RuntimeException e) {
            fail();
        }
    }

    @Test
    @Order(11)
    public void cartCanTotalProducts(){
        try{
            Carts frank = new Carts(4, "Frank");
            store.addShoppingCartToStore(frank);
            frank.addProductToCart(Store.getProductOffShelf(1));
            frank.addProductToCart(Store.getProductOffShelf(2));
            frank.addProductToCart(Store.getProductOffShelf(3));
            assertEquals(29.83, frank.purchaseCart());

        }catch (final RuntimeException e){
            fail(e);
        }
    }

    @Test
    @Order(12)
    public void cartCanTotalTaxes(){
        try{
            Carts moppy = new Carts(8, "Moppy");
            store.addShoppingCartToStore(moppy);
            moppy.addProductToCart(Store.getProductOffShelf(1));
            moppy.addProductToCart(Store.getProductOffShelf(2));
            moppy.addProductToCart(Store.getProductOffShelf(3));
            System.out.println(moppy.toString());
            assertEquals(1.50, moppy.getCartTaxes());

        }catch (final RuntimeException e){
            fail(e);
        }
    }





}