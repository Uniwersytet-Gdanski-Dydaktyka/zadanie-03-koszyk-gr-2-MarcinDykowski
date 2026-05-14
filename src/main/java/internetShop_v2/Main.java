package internetShop_v2;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    Basket basket = new Basket(new SortingByPriceDESCandByNameDESC());
    basket.insertProduct(new Product("01", "Doll", 100));
    basket.insertProduct(new Product("02", "Car", 2137));
    basket.insertProduct(new Product("03", "Pope", 67));

    // System.out.println(Arrays.toString(basket.getProducts(0)));
    // System.out.println(basket.TheMostExpensive());
    // System.out.println(basket.TheCheapest());
    // System.out.println(basket.nMostEpsensive(2));
    // System.out.println(basket.nCheapest(2));
    // System.out.println(basket.nMostEpsensive(2));
    // System.out.println(basket.calculateSumOfPrices());


    // Promotion FreeCup = new FreeCup();
    // basket.setPromotion(FreeCup);
    // List<String[]> test = basket.getProductsFinalPricesAfterPromotions();
    // String[][] wynik = new String[test.size()][4];
    
    // int i = 0;
    // for (String[] productData : test) {
    //     wynik[i] = productData;
    //     i++;
    // }
    // System.out.println(Arrays.deepToString(wynik));

    // Promotion twoPlusOnePromotion = new DollPromotion();
    // basket.setPromotion(twoPlusOnePromotion);

    // System.out.println(basket.getProductsFinalPricesAfterPromotions());

    // String[][] wynik = basket.getProductsFinalPricesAfterPromotions();

    // System.out.println(Arrays.deepToString(wynik));
    // System.out.println(basket.calculateSumOfPrices());
}
}
