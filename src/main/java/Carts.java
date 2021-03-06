import java.util.ArrayList;

public class Carts {
    private int ID;
    private String name;
    private ArrayList<Products> productsInCart;
    private double total = 0.00;
    private double taxes = 0.00;

    public Carts(int ID, String name) {
        this.ID = ID;
        this.name = name;
        productsInCart = new ArrayList<>();
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

    public double purchaseCart() {
        for(Products product : productsInCart){
           total += product.getTaxes() + product.getProductPrice();
        }
        return Math.round(total * 100.00) / 100.00;
    }
    public double getCartTaxes(){
        for(Products product : productsInCart){
            taxes += product.roundToTenths(product.getTaxes());
        }
        return Math.round(taxes * 100.00) / 100.00;
    }

    @Override
    public String toString() {
        for(Products products : productsInCart){
            System.out.println("1 "+ products.getProductName() + " at: " + ( Math.round( (products.getProductPrice() + products.getTaxes()) *100.00)/100.00));
        }
        return "Thank you!";
    }
}
