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

    public double getPriceWithTaxRounded() {
        if(exempt){
            return productPrice;
        }
        return  Math.round(((productPrice * .10) + productPrice) * 20.00) / 20.00;
    }

    public boolean getExemptionStatus(){
        return exempt;
    }
}
