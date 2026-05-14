package internetShop_v2;

import java.util.List;

public class SortingByPriceDESCandByNameDESC implements Sort {
    public List<Product> SortThings(List<Product> productTable){
        // Sorting according to price and then name
        for (int i = 0; i < productTable.size(); i++){
            if (productTable.get(i) == null){
                break;
            }
            for (int j = i + 1; j < productTable.size(); j++){
                if (productTable.get(j) == null) { break; }
                if (Double.parseDouble(productTable.get(i).giveStats()[2]) < Double.parseDouble(productTable.get(j).giveStats()[2])){
                    Product memory = productTable.get(i);
                    productTable.set(i, productTable.get(j));
                    productTable.set(j, memory);
                }
                if ((Double.parseDouble(productTable.get(i).giveStats()[2])) == Double.parseDouble(productTable.get(j).giveStats()[2])){
                    if (productTable.get(i).giveStats()[1].compareTo(productTable.get(j).giveStats()[1]) < 0) {
                        Product memory = productTable.get(i);
                        productTable.set(i, productTable.get(j));
                        productTable.set(j, memory);
                    }
                }
            }
        }

        return productTable;
    } 
}
