package internetShop_v2;

import java.util.ArrayList;
import java.util.List;

public class twoPlusOnePromotion implements Promotion {
    public List<Product> calculateBasketAfterPromotion(Basket basket){
        int NotNull = 0;
        for (Product product : basket.getProducts()){
            if (product != null){
                NotNull++;
            }else{
                break;
            }
        }
        int NumberOfFreeCheapestProducts = NotNull / 3;
        int index = 0;
        for (Product product : basket.getProducts()){
            if (product == null){
                return basket.getProducts();
            }else{
                if (NotNull - NumberOfFreeCheapestProducts <= index){
                    product.setDicountPrice(0);
                }
            index++;
            }
        }
        return basket.getProducts();
    }
}
