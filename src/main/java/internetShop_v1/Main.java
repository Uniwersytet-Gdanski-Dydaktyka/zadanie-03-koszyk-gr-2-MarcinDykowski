package internetShop_v1;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    Sort Standard = new SortingByPriceDESCandByNameDESC();

    Basket basket = new Basket(Standard);
    basket.insertProduct(new Product("01", "Doll", 100));
    basket.insertProduct(new Product("02", "Car", 2137));
    basket.insertProduct(new Product("03", "Pope", 67));


    System.out.println(Arrays.toString(basket.getProducts(0)));
    System.out.println(basket.TheMostExpensive());
    System.out.println(basket.TheCheapest());
    System.out.println(basket.nMostEpsensive(2));
    System.out.println(basket.nCheapest(2));
    System.out.println(basket.nMostEpsensive(2));
    System.out.println(basket.calculateSumOfPrices());


    Promotion FreeCup = new FreeCup();
    basket.setPromotion(FreeCup);
    String[][] wynik = basket.getProductsFinalPricesAfterPromotions();

    System.out.println(Arrays.deepToString(wynik));

    // Promotion twoPlusOnePromotion = new DollPromotion();
    // basket.setPromotion(twoPlusOnePromotion);

    // System.out.println(basket.getProductsFinalPricesAfterPromotions());

    // String[][] wynik = basket.getProductsFinalPricesAfterPromotions();

    // System.out.println(Arrays.deepToString(wynik));
    // System.out.println(basket.calculateSumOfPrices());
}
}
