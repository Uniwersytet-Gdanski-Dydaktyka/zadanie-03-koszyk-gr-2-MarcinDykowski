package internetShop_v1;

public class FreeCup implements Promotion {
    public Product[] calculateBasketAfterPromotion(Basket basket){
        if (basket.calculateSumOfPrices() > 200){
            Product[] x = basket.getProducts();
            for (int i = 0; i < basket.getProducts().length ;i++){
                if (x[i] == null){
                    x[i] = (new Product("10", "Cup", 0));
                    break;
                }else{
                    x[i].setDicountPrice(Double.parseDouble(x[i].giveStats()[2]));
                }
            }
        }
    return basket.getProducts();
    }
}
