package internetShop_v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Basket {
    private List<Product> productTable;
    private Promotion currentPromotion;
    private Sort currentSorting;

    public Basket(Sort strategy){
        this.productTable = new ArrayList<Product>();
        this.currentSorting = strategy;
    }

    public List<Product> getProducts(){
        return productTable;
    }

    public void setPromotion(Promotion p){
        this.currentPromotion = p;
    }

public List<String[]> getProductsFinalPricesAfterPromotions() {
        List<Product> dataSoruce;
        if (currentPromotion == null) {
            dataSoruce = this.productTable;
        } else {
            dataSoruce = currentPromotion.calculateBasketAfterPromotion(this);
        }

        List<String[]> Score = new ArrayList<String[]>();
        
        for (int i = 0; i < dataSoruce.size(); i++) {
            if (dataSoruce.get(i) != null) {
                Score.add(dataSoruce.get(i).giveStats());
            }
        }

        return Score;
    }    

    public String[] getProducts(int i) {
        return this.productTable.get(i).giveStats();
    }

    public void insertProduct(Product p){
        this.productTable.add(p);
        this.productTable = currentSorting.SortThings(this.productTable);
        // Sorting according to price and then name
        // for (int i = 0; i < this.productTable.size(); i++){
        //     if (this.productTable.get(i) == null){
        //         break;
        //     }
        //     for (int j = i + 1; j < this.productTable.size(); j++){
        //         if (this.productTable.get(j) == null) { break; }
        //         if (Double.parseDouble(getProducts(i)[2]) < Double.parseDouble(getProducts(j)[2])){
        //             Product memory = this.productTable.get(i);
        //             this.productTable.set(i, this.productTable.get(j));
        //             this.productTable.set(j, memory);
        //         }
        //         if (Double.parseDouble(getProducts(i)[2]) == Double.parseDouble(getProducts(j)[2])){
        //             if (getProducts(i)[1].compareTo(getProducts(j)[1]) < 0) {
        //                 Product memory = this.productTable.get(i);
        //                 this.productTable.set(i, this.productTable.get(j));
        //                 this.productTable.set(j, memory);
        //             }
        //         }
        //     }
        // }
        
    }

    public String TheMostExpensive(){
        if (this.productTable.get(0) != null){
            return Arrays.toString(getProducts(0));
        }
        return null;
    }

    public String TheCheapest(){
        for (int i = 0; i < this.productTable.size(); i++){ 
            if ((this.productTable.get(i) != null && i+1 < this.productTable.size() && this.productTable.get(i+1) == null) || (i+1 == this.productTable.size())){
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
        for (int i = 0; i < this.productTable.size(); i++){
            if (this.productTable.get(i) == null && i < n){
                return null;
            }
        }
        int NotNull = 0;
        for (int i = 0; i < this.productTable.size(); i++){
            if (this.productTable.get(i) == null){
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
        for (int i = 0; i < this.productTable.size(); i++){
            if (this.productTable.get(i) == null && i < n){
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
        for (int i = 0; i < this.productTable.size(); i++){
            if (this.productTable.get(i) == null){
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
