public class Main {
    public static void main(String[] args) {
        Store solutionStore = Store.getInstance();

        solutionStore.addToShelf(Products.book);
        solutionStore.addToShelf(Products.music_cd);
        solutionStore.addToShelf(Products.chocolate_bar);
        solutionStore.addToShelf(Products.imported_box_of_chocolates);
        solutionStore.addToShelf(Products.imported_bottle_of_perfume);
        solutionStore.addToShelf(Products.imported_cheaper_bottle_of_perfume);
        solutionStore.addToShelf(Products.bottle_of_perfume);
        solutionStore.addToShelf(Products.packet_of_headache_pills);
        solutionStore.addToShelf(Products.different_imported_box_of_chocolates);

        Carts cart1 = new Carts(1, "Input 1");
        solutionStore.addShoppingCartToStore(cart1);

        Carts cart2 = new Carts(2, "Input 2");
        solutionStore.addShoppingCartToStore(cart2);

        Carts cart3 = new Carts(3, "Input 3");
        solutionStore.addShoppingCartToStore(cart3);

        cart1.addProductToCart(Store.getProductOffShelf(1));
        cart1.addProductToCart(Store.getProductOffShelf(2));
        cart1.addProductToCart(Store.getProductOffShelf(3));

        cart2.addProductToCart(Store.getProductOffShelf(4));
        cart2.addProductToCart(Store.getProductOffShelf(5));

        cart3.addProductToCart(Store.getProductOffShelf(6));
        cart3.addProductToCart(Store.getProductOffShelf(7));
        cart3.addProductToCart(Store.getProductOffShelf(8));
        cart3.addProductToCart(Store.getProductOffShelf(9));

        System.out.println(cart1.toString() + " Your Totals: Sales Taxes: " + cart1.getCartTaxes() + " Total: " +  cart1.purchaseCart());
        System.out.println("-----------------------------");
        System.out.println(cart2.toString() + " Your Totals: Sales Taxes: " + cart2.getCartTaxes() + " Total: " +  cart2.purchaseCart());
        System.out.println("-----------------------------");
        System.out.println(cart3.toString() + " Your Totals: Sales Taxes: " + cart3.getCartTaxes() + " Total: " +  cart3.purchaseCart());





    }
}
