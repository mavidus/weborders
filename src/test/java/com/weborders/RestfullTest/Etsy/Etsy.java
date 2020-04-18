package com.weborders.RestfullTest.Etsy;

import java.util.ArrayList;
import java.util.List;

public class Etsy {

    /*
    Imagine this is API GET Method
     */
    //Get Action(/search)
    public static List<String> search(String q){

        List<String> matchingProducts=new ArrayList<>();
        for(String product:dataBase() ){

            if(product.toLowerCase().contains(q.toLowerCase())){
                matchingProducts.add(product);
            }
        }

        return matchingProducts;
    }

    /*
    this method is acting like a database normally product needs to be
    store oin oracle, Mysql or any oher database. this is just a practice

     */
    private static List<String> dataBase(){


        List<String> productDataBAse=new ArrayList<>();

        productDataBAse.add("Custom wooden spoon");
        productDataBAse.add("Olive tree wooden spoon-nice");
        productDataBAse.add("Italian wallet");
        productDataBAse.add("Leather brown wallet");
        productDataBAse.add("American flag umbrella");
        productDataBAse.add("Japanese flag umbrella");
        productDataBAse.add("Wool white scarf");
        productDataBAse.add("Silk pink scarf");

        return productDataBAse;
    }
}
