package org.java8.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * List to List
 */
public class FunctionFIListToListExample {

    public static void main(String[] args) {
        FunctionFIListToListExample obj = new FunctionFIListToListExample();
        List<String> list = Arrays.asList("Venkata","Krishna","Santhoshi","Hamsini","Abhirami","Karthikeya");
        Function<String, String> function = x -> obj.sha256(x);
        Function<String,String> function1 = obj::sha256;
        List list1 = obj.convertToList(list, function1);
        System.out.println(list1);
    }

    public <T,R> List<R> convertToList(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(function.apply(t));
        }
        return  result;
    }

    public String sha256(String str){
        return DigestUtils.md5Hex(str);
    }
}
