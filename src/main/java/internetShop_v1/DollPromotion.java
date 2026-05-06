package internetShop_v1;

public class DollPromotion implements Promotion {
    public Product[] calculateBasketAfterPromotion(Basket basket){
        Product[] x = basket.getProducts();
        for (int i = 0; i < basket.getProducts().length; i++){
            if (x[i] == null){
                break;
            }
            if (x[i].giveStats()[1] == "Doll"){
                x[i].setDicountPrice(0.7);
            }else{
                x[i].setDicountPrice(Double.parseDouble(x[i].giveStats()[2]));
            }
        }
        return basket.getProducts();
    }
}
