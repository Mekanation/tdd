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
        cart.add(product);
    }

    public List<Products> getCart() {
        return cart;
    }

    public String cartContains(String productName) {
        for (Products product : cart) {
            if (product.getProductName().equals(productName)) {
                return product.getProductName();
            } else {
                return "Item not found";
            }
        }

        return "This item: " + productName + "was not found in the cart";
    }

    public double getProductPrice(String productName) {
        for(Products product : cart){
            if(product.getProductName().equals(productName)){
                return product.getProductPrice();
            }
        }
        return 0.00;
    }

    public double getProductTotal(String productName) {
        for(Products product : cart){
            if(product.getProductName().equals(productName)){
                return product.getRoundedPrice(product.getPriceWithTaxRounded());
            }
        }
        return 0.00;
    }
}
