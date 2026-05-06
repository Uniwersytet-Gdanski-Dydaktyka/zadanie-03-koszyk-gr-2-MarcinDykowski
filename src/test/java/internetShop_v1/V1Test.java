package internetShop_v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class BasketTest {

    private Basket basket;

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
    void DollPromotionTest(){

        Promotion twoPlusOnePromotion = new DollPromotion();
        basket.setPromotion(twoPlusOnePromotion);
        String[][] score = basket.getProductsFinalPricesAfterPromotions();

        assertEquals("[[02, Car, 2137.0, 2137.0], [01, Doll, 100.0, 70.0], [03, Pope, 67.0, 67.0]]", Arrays.deepToString(score), "Two Arrays should be equal");
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
    void moreThan300Test(){
        Promotion Plus300 = new MoreThan300();
        basket.setPromotion(Plus300);
        assertEquals("[[02, Car, 2137.0, 2030.15], [01, Doll, 100.0, 95.0], [03, Pope, 67.0, 63.65]]", Arrays.deepToString(basket.getProductsFinalPricesAfterPromotions()));
    }

    @Test
    void freeCupTest(){
        Promotion FreeCup = new FreeCup();
        basket.setPromotion(FreeCup);
        assertEquals("[[02, Car, 2137.0, 2137.0], [01, Doll, 100.0, 100.0], [03, Pope, 67.0, 67.0], [10, Cup, 0.0, 0.0]]", Arrays.deepToString(basket.getProductsFinalPricesAfterPromotions()));
    }
}