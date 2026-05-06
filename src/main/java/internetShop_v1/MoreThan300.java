package internetShop_v1;

public class MoreThan300 implements Promotion {
    public Product[] calculateBasketAfterPromotion(Basket basket){
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
