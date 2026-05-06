package internetShop_v2;

import java.util.ArrayList;
import java.util.List;

public interface Promotion {
    public List<Product> calculateBasketAfterPromotion(Basket basket);
}
