package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String inicio = "1 2 5 0 4 6 7 9 8 11 10 14 12 13 15 3";
        Map<String ,Estado> hashmap = new HashMap<>();

        List<Estado> A = new ArrayList<>();
        List<Estado> F = new ArrayList<>();
        List<Estado> S = new ArrayList<>();
        List<Estado> T = new ArrayList<>();

        S.add(new Estado(inicio));
        A.addAll(S);
//        Estado v = A.stream().reduce((a,b)-> {
//
//            return
//        });
//        while(!S.isEmpty()){
//
//        }

        System.out.println(S.get(0));
    }
}
