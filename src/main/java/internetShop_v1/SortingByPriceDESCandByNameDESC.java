package internetShop_v1;

public class SortingByPriceDESCandByNameDESC implements Sort {
    public Product[] SortThings(Product[] productTable){
        for (int i = 0; i < productTable.length; i++){
            if (productTable[i] == null){
                break;
            }
            for (int j = i + 1; j < productTable.length; j++){
                if (productTable[j] == null) { break; }
                if (Double.parseDouble(productTable[i].giveStats()[2]) < Double.parseDouble(productTable[j].giveStats()[2])){
                    Product memory = productTable[i];
                    productTable[i] = productTable[j];
                    productTable[j] = memory;
                }
                if (Double.parseDouble(productTable[i].giveStats()[2]) == Double.parseDouble(productTable[j].giveStats()[2])){
                    if (productTable[i].giveStats()[1].compareTo(productTable[i].giveStats()[1]) < 0) {
                        Product memory = productTable[i];
                        productTable[i] = productTable[j];
                        productTable[j] = memory;
                    }
                }
            }
        }

        return productTable;
    } 
}
