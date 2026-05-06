package internetShop_v2;

import java.util.ArrayList;

public class DollPromotion implements Promotion {
    public ArrayList<Product> calculateBasketAfterPromotion(Basket basket){
        ArrayList<Product> x = basket.getProducts();
        for (int i = 0; i < basket.getProducts().size(); i++){
            if (x.get(i) == null){
                break;
            }
            if (x.get(i).giveStats()[1] == "Doll"){
                x.get(i).setDicountPrice(0.7);
            }else{
                x.get(i).setDicountPrice(Double.parseDouble(x.get(i).giveStats()[2]));
            }
        }
        return basket.getProducts();
    }
}
