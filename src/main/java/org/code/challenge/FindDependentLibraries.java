package org.code.challenge;

import java.util.*;

/** eBayApps --> eBayPayApps,  JShared
    JWGroup --> TxnGroup, JShared
    JShared --> ebaySharedApps
    ebaySharedApps --> SEShared, Core
    eBayPayApps --> ebaySharedApps, ALib
    TxnGroup --> ebaySharedApps, Wlib

    # Write a function that takes a library name  as input and  then provide all  the dependent libraries
    # In Such  an order that first level dependency are on top of the collection and followed by second level rep
    # and so on


    # Sample input for  - eBayApps
    Output --> eBayPayApps, JShared, ebaySharedApps, ALib, SEShared, Core*/
public class FindDependentLibraries {
    public static void main(String[] args) {
         LinkedHashSet<String> output = new LinkedHashSet<>();
         Map<String, List<String>> inputLibraryMap = new HashMap<>();
         inputLibraryMap.put("eBayApps", Arrays.asList("eBayPayApps","JShared"));
         inputLibraryMap.put("JWGroup", Arrays.asList("TxnGroup", "JShared"));
         inputLibraryMap.put("JShared", Arrays.asList("ebaySharedApps"));
         inputLibraryMap.put("ebaySharedApps", Arrays.asList("SEShared", "Core"));
         inputLibraryMap.put("eBayPayApps", Arrays.asList("ebaySharedApps", "ALib"));
         inputLibraryMap.put("TxnGroup", Arrays.asList("ebaySharedApps", "Wlib"));
         System.out.println(getDependentLibraries("eBayApps", output, inputLibraryMap));
    }

    public static LinkedHashSet<String> getDependentLibraries(String inputLibraryName, LinkedHashSet<String> output, Map<String, List<String>> inputLibraryMap){
        if(inputLibraryMap.isEmpty()){
            return null;
        }
        List<String> dependentLibraries = inputLibraryMap.get(inputLibraryName);
        if(Objects.nonNull(dependentLibraries)){
            output.addAll(dependentLibraries);
            dependentLibraries.stream().forEach(library -> getDependentLibraries(library, output, inputLibraryMap));
        }
        return output;
    }
}
