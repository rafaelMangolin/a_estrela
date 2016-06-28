package com.company;

import java.util.*;

public class Main {
//  Caso 1: 1 12 11 10 0  13 15 9 2  14 6 8 3 4 5 7
//  Caso 2: 12 11  10 9 1 13 15  0 2 14 6 8 3 4 5 7
//  Caso 3: 1 12 0 11 2 13 15 10 3 14 6 9 4 5 7 8
//  Caso 4: 2   1  12  11 3  0 15  10 4 13 6 9 5 14 7 8
//  Caso 5: 2 1 12 11 3 15 6  10 4 0 7 9 5 13 14 8
//  Caso 6: 11 15 4 5 0 14 2 10 3 6 1 9 13 12 8 7
//  Caso 7: 2 11 14 9 12 1 0 10 5 4 15 8 3 6 13 7, passos:28


    public static void main(String[] args) {
//      Lê dado do teclado
        Scanner keyboard = new Scanner(System.in);
        String inicio = keyboard.nextLine();


        long in = System.currentTimeMillis();
        HashMap<String, Estado> A = new HashMap<>();//Aberto
        HashMap<String, Estado> F = new HashMap<>();//Fechado
        HashMap<String, Estado> S = new HashMap<>();//Inicial


        Estado primeiro = new Estado(inicio);
        S.put(primeiro.getHashKey(), primeiro);
        A.putAll(S);
        Estado v = Utils.menorF(A);
        while (v != null && !v.ehFinal()) {
            A.remove(v.getHashKey());
            F.put(v.getHashKey(), v);
            for (Estado m : v.calculaFilhos()) {
                Estado mLinha = A.get(m.getHashKey());
                if (mLinha != null && mLinha.getG() > m.getG()) {
                    A.remove(mLinha);
                }
                Estado contidoA = A.get(m.getHashKey());
                Estado contidoF = F.get(m.getHashKey());
                if (contidoA == null && contidoF == null) {
                    A.put(m.getHashKey(), m);
                    m.setPai(v);
                    m.calcularhLinha();
                    m.calcularF();
                }
            }
//            Encontra o estado v com o menor f(v) em A que não esta contido em F
            v = Utils.menorF(A);
        }


//        Caso sucesso imprima o g(v)
        Estado estadoFinal = Utils.menorF(A);
        if (estadoFinal != null && estadoFinal.ehFinal()) {
            System.out.println(v.getG());
        }
        long out = System.currentTimeMillis();
        System.out.println(out - in);
    }
}
