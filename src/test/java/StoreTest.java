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
        try {
            List<Products> results = store.purchaseProducts(store.getProductsOnShelf());
            assertEquals(0, results.size());
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
            assertEquals("Book", store.cartContains("Book"));
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(4)
    public void returnsProductPriceWhenProductIsChosen() {
        try {
            assertEquals(12.49, store.getProductPrice("Book"));
        } catch (final RuntimeException e) {
            fail();
        }

    }

    @Test
    @Order(5)
    public void returnsProductTaxWhenProductIsChosen() {
        try {
            assertEquals(12.50, store.getProductTotal("Book"));
            assertEquals(16.50, store.getProductTotal("music CD"));
        } catch (final RuntimeException e) {
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
            store.addShoppingCartToStore(julie);
            julie.addProductToCart(Store.getProductOffShelf(1));

            for (Carts cart : store.getCartsInStore()) {
                if (cart.getName() == "Julie") {
                    assertEquals(true, cart.containsProduct("Book"));
                }
            }

        } catch (final RuntimeException e) {
            fail();
        }
    }




}