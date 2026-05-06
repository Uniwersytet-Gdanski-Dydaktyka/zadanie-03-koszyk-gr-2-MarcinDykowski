package internetShop_v2;

import java.util.ArrayList;

public class MoreThan300 implements Promotion {
    public ArrayList<Product> calculateBasketAfterPromotion(Basket basket){
        if (basket.calculateSumOfPrices() > 300){
            for (Product product : basket.getProducts()){
                if (product != null){
                    product.setDicountPrice(0.95);
                }else{
                    break;
                }
            }
        }
        return basket.getProducts();
    }
}
