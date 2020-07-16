import java.util.ArrayList;
import java.util.List;

public class Store {
    private static ArrayList<Products> productsOnShelf;
    private static Store instance = null;
    private ArrayList<Carts> carts;



    private Store() {
        productsOnShelf = new ArrayList<>();
        carts = new ArrayList<>();
    }

    public static Products getProductOffShelf(int productID) {
        for(Products product : productsOnShelf){
            if(product.getProductID() == productID){
                return product;
            }
        }
        return null;

    }

    public List<Products> purchaseProducts(List<Products> list) {

        return list;
    }

    public void addToShelf(Products product){
        productsOnShelf.add(product);
    }

    public List<Products> getProductsOnShelf() {
        return productsOnShelf;
    }

    public List<Carts> getCartsInStore(){
        return carts;
    }

    public String cartContains(String productName) {
        for (Products product : productsOnShelf) {
            if (product.getProductName().equals(productName)) {
                return product.getProductName();
            } else {
                return "Item not found";
            }
        }

        return "This item: " + productName + "was not found in the cart";
    }

    public double getProductPrice(String productName) {
        for(Products product : productsOnShelf){
            if(product.getProductName().equals(productName)){
                return product.getProductPrice();
            }
        }
        return 0.00;
    }

    public double getProductTotal(String productName) {
        for(Products product : productsOnShelf){
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
        for(Products product : productsOnShelf){
            if(product.getProductName().equals(productName)){
                return product.getProductID();
            }
        }
        return 0;
    }

    public void addShoppingCartToStore(Carts cart) {
        carts.add(cart);
    }

    public String getCartNameInStore(int id){
        for(Carts cart : this.carts){
            if(cart.getID() == id){
                return cart.getName();
            }
        }
        return "Cart not in Store";
    }


}
