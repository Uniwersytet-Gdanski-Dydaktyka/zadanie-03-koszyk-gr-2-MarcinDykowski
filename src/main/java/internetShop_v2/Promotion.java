package internetShop_v2;

import java.util.ArrayList;

public interface Promotion {
    public ArrayList<Product> calculateBasketAfterPromotion(Basket basket);
}
