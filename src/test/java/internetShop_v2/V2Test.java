package internetShop_v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
public class V2Test {
    
    private Basket basket;

    static String[][] Converter(ArrayList<String[]> score){
        String[][] wynik = new String[score.size()][4];
    
        int i = 0;
        for (String[] productData : score) {
            wynik[i] = productData;
            i++;
        }
        return wynik;
    }

    @BeforeEach
    void setUpTest() {
        basket = new Basket();

        basket.insertProduct(new Product("01", "Doll", 100));
        basket.insertProduct(new Product("02", "Car", 2137));
        basket.insertProduct(new Product("03", "Pope", 67));
    }

    @Test
    void shouldCalculateCorrectSumOfPrices() {

        double suma = basket.calculateSumOfPrices();

       assertEquals(2304.0, suma, "Sum should be 2304.0");
    }

    @Test
    void TheMostExpensiveTest(){
        assertEquals("[02, Car, 2137.0, 2137.0]", basket.TheMostExpensive());
    }

    @Test
    void TheCheapestTest(){
        assertEquals("[03, Pope, 67.0, 67.0]", basket.TheCheapest());
    }

    @Test 
    void nMostEpsensiveTest(){
        assertEquals("[[02, Car, 2137.0, 2137.0], [01, Doll, 100.0, 100.0]]", basket.nMostEpsensive(2));
    }

    @Test 
    void nCheapestTest(){
        assertEquals("[[01, Doll, 100.0, 100.0], [03, Pope, 67.0, 67.0]]", basket.nCheapest(2));
    }

    @Test
    void DollPromotionTest(){

        Promotion twoPlusOnePromotion = new DollPromotion();
        basket.setPromotion(twoPlusOnePromotion);
        ArrayList<String[]> score = basket.getProductsFinalPricesAfterPromotions();

        String[][] Converted = Converter(score);

        assertEquals("[[02, Car, 2137.0, 2137.0], [01, Doll, 100.0, 70.0], [03, Pope, 67.0, 67.0]]", Arrays.deepToString(Converted), "Two Arrays should be equal");
    }

    @Test
    void moreThan300Test(){

        Promotion MoreThan300 = new MoreThan300();
        basket.setPromotion(MoreThan300);
        ArrayList<String[]> score = basket.getProductsFinalPricesAfterPromotions();

        String[][] Converted = Converter(score);

        assertEquals("[[02, Car, 2137.0, 2030.15], [01, Doll, 100.0, 95.0], [03, Pope, 67.0, 63.65]]", Arrays.deepToString(Converted), "Two Arrays should be equal");
    }

    @Test
    void freeCupTest(){
        Promotion FreeCup = new FreeCup();
        basket.setPromotion(FreeCup);
        ArrayList<String[]> score = basket.getProductsFinalPricesAfterPromotions();

        String[][] Converted = Converter(score);

        assertEquals("[[02, Car, 2137.0, 2137.0], [01, Doll, 100.0, 100.0], [03, Pope, 67.0, 67.0], [10, Cup, 0.0, 0.0]]", Arrays.deepToString(Converted), "Two Arrays should be equal");

    }

}
