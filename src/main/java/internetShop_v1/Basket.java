package internetShop_v1;

import java.util.Arrays;
import java.util.Collections;

public class Basket {
    private Product[] productTable;
    private Promotion currentPromotion;
    private Sort currentSorting;

    public Basket(Sort strategy){
        this.productTable = new Product[10];
        this.currentSorting = strategy;
    }

    public Product[] getProducts(){
        return productTable;
    }

    public void setPromotion(Promotion p){
        this.currentPromotion = p;
    }

public String[][] getProductsFinalPricesAfterPromotions() {
        Product[] dataSoruce;
        if (currentPromotion == null) {
            dataSoruce = this.productTable;
        } else {
            dataSoruce = currentPromotion.calculateBasketAfterPromotion(this);
        }

        int productCount = 0;
        for (int i = 0; i < dataSoruce.length; i++) {
            if (dataSoruce[i] != null) {
                productCount++;
            }
        }

        String[][] Score = new String[productCount][];
        
        int currentIndex = 0;
        for (int i = 0; i < dataSoruce.length; i++) {
            if (dataSoruce[i] != null) {
                Score[currentIndex] = dataSoruce[i].giveStats();
                currentIndex++;
            }
        }

        return Score;
    }    

    public String[] getProducts(int i) {
        return this.productTable[i].giveStats();
    }

    public void insertProduct(Product p){
        for (int i = 0; i < this.productTable.length; i++){
            if (this.productTable[i] == null){
                this.productTable[i] = p;
                break;
            }
        }
        this.productTable = currentSorting.SortThings(this.productTable);
        
    }

    public String TheMostExpensive(){
        if (this.productTable[0] != null){
            return Arrays.toString(getProducts(0));
        }
        return null;
    }

    public String TheCheapest(){
        for (int i = 0; i < this.productTable.length; i++){ 
            if ((this.productTable[i] != null && i+1 < this.productTable.length && this.productTable[i+1] == null) || (i+1 == this.productTable.length)){
                return Arrays.toString(getProducts(i));
            }
        }
        return null;
    }

    public String nMostEpsensive(int n){
        String[] answer = new String[n];
        for (int i = 0; i < n; i++){
            answer[i] = Arrays.toString(getProducts(i));
        }
        return Arrays.toString(answer);
    }

    public String nCheapest(int n){
        // checking if user wants more n than there are in total in an Array
        for (int i = 0; i < this.productTable.length; i++){
            if (this.productTable[i] == null && i < n){
                return null;
            }
        }
        int NotNull = 0;
        for (int i = 0; i < this.productTable.length; i++){
            if (this.productTable[i] == null){
                break;
            }else{
                NotNull++;
            }
        }
        String[] answer = new String[n];
        for (int i = NotNull - n; i < NotNull; i++){
            for (int j = 0; j < answer.length; j++)
                if (answer[j] == null){
                    answer[j] = Arrays.toString(getProducts(i));
                    break;
                }
        }
        return Arrays.toString(answer);
    }

    public String nMostExpensive(int n){
        // checking if user wants more n than there are in total in an Array
        for (int i = 0; i < this.productTable.length; i++){
            if (this.productTable[i] == null && i < n){
                return null;
            }
        }

        String[] answer = new String[n];
        for (int i = 0 ; i < n; i++){
            for (int j = 0; j < answer.length; j++)
                if (answer[j] == null){
                    answer[j] = Arrays.toString(getProducts(i));
                    break;
                }
        }
        return Arrays.toString(answer);

    }

    public double calculateSumOfPrices(){
        int NotNull = 0;
        for (int i = 0; i < this.productTable.length; i++){
            if (this.productTable[i] == null){
                break;
            }else{
                NotNull++;
            }
        }
        double answer = 0.0;
        for (int i = 0 ; i < NotNull; i++)
        {
            answer += Double.parseDouble(getProducts(i)[3]);
        }
        return answer;

    }
}
