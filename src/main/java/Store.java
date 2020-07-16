import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Products> cart;
    private static Store instance = null;


    private Store() {
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
                return product.getRoundedPrice(product.getPriceWithTax());
            }
        }
        return 0.00;
    }
    public static Store getInstance(){
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }

    public int getProductIDinCart(String productName) {
        return 0;
    }
}
