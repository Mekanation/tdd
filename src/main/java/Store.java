import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Products> cart;

    public Store() {
        cart = new ArrayList<>();
    }

    public List<Products> purchaseProducts(List<Products> list) {

        return list;
    }

    public void addToCart(Products product){

    }

    public List<Products> getCart() {
        return cart;
    }

    public String cartContains(String itemToFind) {
        for (Products product : cart) {
            if (product.getProductName().equals(itemToFind)) {
                return product.toString();
            } else {
                return "Item not found";
            }
        }

        return "This item: " + itemToFind + "was not found in the cart";
    }
}
