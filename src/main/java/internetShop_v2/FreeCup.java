package internetShop_v2;

import java.util.ArrayList;

public class FreeCup implements Promotion {
    public ArrayList<Product> calculateBasketAfterPromotion(Basket basket){
        if (basket.calculateSumOfPrices() > 200){
            ArrayList<Product> x = basket.getProducts();
            for (int i = 0; i < basket.getProducts().size() ;i++){
                if (x.get(i) == null){
                    x.add((new Product("10", "Cup", 0)));
                    break;
                }else{
                    x.get(i).setDicountPrice(Double.parseDouble(x.get(i).giveStats()[2]));
                
            }
        }
        x.add((new Product("10", "Cup", 0)));
    }
        return basket.getProducts();
    }
}
