public class Products {


    private String productName;
    private double productPrice;
    private boolean exempt;

    public Products(String productName, double productPrice, boolean exempt) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.exempt = exempt;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getPriceWithTax() {
        if(exempt){
            return productPrice;
        }
        return  (productPrice * .10) + productPrice;
    }
    public boolean getExemptionStatus(){
        return exempt;
    }
}
