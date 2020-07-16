import java.util.ArrayList;

public class Store {
    private static ArrayList<Products> productsOnShelf;
    private static Store instance = null;
    private ArrayList<Carts> carts;

    private Store() {
        productsOnShelf = new ArrayList<>();
        carts = new ArrayList<>();
    }

    public static Store getInstance(){
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }

    public static Products getProductOffShelf(int productID) {
        for(Products product : productsOnShelf){
            if(product.getProductID() == productID){
                return product;
            }
        }
        return null;

    }

    public void addToShelf(Products product){
        productsOnShelf.add(product);
    }

    public ArrayList<Products> getAllProducts() {
        return productsOnShelf;
    }

    public ArrayList<Carts> getCartsInStore(){
        return carts;
    }

    public String shelfContains(String productName) {
        for (Products product : productsOnShelf) {
            if (product.getProductName().equals(productName)) {
                return product.getProductName();
            } else {
                return "Item not found";
            }
        }

        return "This item: " + productName + "was not found on the shelf";
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
