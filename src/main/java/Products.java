public class Products {


    private final String productName;
    private final double productPrice;
    private final boolean exempt;
    private final boolean imported;
    private final int productID;

    private Products(int productID, String productName, double productPrice, boolean exempt, boolean imported) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.exempt = exempt;
        this.imported = imported;
    }

            public static final Products book = new Products(1,"Book",12.49, true, false);
            public static final Products music_cd = new Products(2,"music CD", 14.99,false, false);
            public static final Products chocolate_bar = new Products(3,"chocolate bar",0.85, true, false);
            public static final Products imported_box_of_chocolates = new Products(4,"imported box of chocolates", 10.00, true, true);
            public static final Products imported_bottle_of_perfume = new Products(5,"imported bottle of perfume",47.50, false,true);
            public static final Products imported_cheaper_bottle_of_perfume = new Products(6,"imported cheaper bottle of perfume", 27.99,false,true);
            public static final Products bottle_of_perfume = new Products(7,"bottle of perfume", 18.99, false, false);
            public static final Products packet_of_headache_pills = new Products(8,"packet of headache pills", 9.75, true,false);
            public static final Products different_imported_box_of_chocolates = new Products(9,"different imported box of chocolates", 11.25, true, true);


    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

//    public double getPriceWithTax() {
//        double RoundedSalesTax = Math.round((productPrice * .10) * 20.00) / 20.00;
//        double RoundedImportTax = Math.round((productPrice * .05) * 20.00) / 20.00;
//
//        if(imported && exempt){
//            return RoundedImportTax + productPrice;
//        }else if(imported){
//            return RoundedImportTax + RoundedSalesTax + productPrice;
//        }else if(exempt){
//            return productPrice;
//        }
//        return productPrice + RoundedSalesTax;
//    }

    public double roundToTenths(double productPrice){
        return Math.round(productPrice * 100.00) / 100.00;
    }
    public int getProductID() {
        return productID;
    }

    public double getTaxes() {
        double RoundedSalesTax = Math.round((productPrice * .10) * 20.00) /20.00;
        double RoundedImportTax = Math.round((productPrice * .05) * 20.00) /20.00;

        if(imported && exempt){
            return RoundedImportTax;
        }else if(imported){
            return RoundedImportTax + RoundedSalesTax;
        }else if(exempt){
            return 0.00;
        }
        return RoundedSalesTax;

    }


}
