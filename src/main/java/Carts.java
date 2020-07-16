import java.util.ArrayList;

public class Carts {
    private int ID;
    private String name;
    private ArrayList<Products> productsInCart;

    public Carts(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }


    public boolean containsProduct(String productName) {
        for(Products product : productsInCart){
            if(product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(Products product){
        productsInCart.add(product);
    }
}
