package internetShop_v2;

public class Product {
    private String code;
    private String name;
    private double price;
    private double discountPrice; 

    public Product(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String[] giveStats(){
        return new String[]{code, name, String.valueOf(price), String.valueOf(discountPrice)};
    }

    public Product getReference(){
        return this;
    }

    public void setDicountPrice(double i){
        if (i > 1){
            this.discountPrice = price;
        }else{
            this.discountPrice = Math.round((this.discountPrice * i) * 100.0) / 100.0;
        }
    }
}
