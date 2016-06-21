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

        List<Estado> A = new ArrayList<>();//Aberto
        List<Estado> F = new ArrayList<>();//Fechado
        List<Estado> S = new ArrayList<>();//Inicial
        List<Estado> T = new ArrayList<>();//Final

        S.add(new Estado(inicio));
        A.addAll(S);
        Estado v = Utils.menorFNaoContido(A,F);
        while(v != null){
            v = Utils.menorFNaoContido(A,F);
            A.remove(v);
            F.add(v);
        }
        S.get(0).calculaFilhos();
        System.out.println(S.get(0));
    }
}
