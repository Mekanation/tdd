public class Products {


    private String productName;
    private double productPrice;
    private boolean exempt;
    private boolean imported;

    public Products(String productName, double productPrice, boolean exempt, boolean imported) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.exempt = exempt;
        this.imported = imported;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getPriceWithTaxRounded() {
        double unRoundedSalesTax = (productPrice * .10);
        double unRoundedImportTax = (productPrice * .05);

        if(imported && exempt){
            return unRoundedImportTax + productPrice;
        }else if(imported){
            return unRoundedImportTax + unRoundedSalesTax + productPrice;
        }else if(exempt){
            return productPrice;
        }
        return productPrice + unRoundedSalesTax;
    }

    public double getRoundedPrice(Double unroundedPrice){
        return Math.round(unroundedPrice * 20.00) / 20.00;
    }

    public boolean getExemptionStatus(){
        return exempt;
    }
    public boolean getImportStatus(){
        return imported;
    }
}
