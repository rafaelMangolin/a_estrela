package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      Lê dado do teclado
        Scanner keyboard = new Scanner(System.in);
        String inicio = keyboard.nextLine();


//        Map<String, Estado> hashmap = new HashMap<>();

//
        List<Estado> A = new ArrayList<>();//Aberto
        List<Estado> F = new ArrayList<>();//Fechado
        List<Estado> S = new ArrayList<>();//Inicial
        List<Estado> T = new ArrayList<>();//Final

        S.add(new Estado(inicio));
        A.addAll(S);
        Estado v = Utils.menorFNaoContido(A, F);
        Estado resultado = null;
        while (v != null) {
            A.remove(v);
            F.add(v);
            if (v.ehFinal()) {
                resultado = v;
                break;
            }
            v.calculaFilhos();
            for (Estado m : v.getFilhos()) {
                Estado mLinha = Utils.contemNoArray(m, A);
                if (mLinha != null) {
                    A.remove(mLinha);
                }
                if (Utils.contemNoArray(m, A) == null && Utils.contemNoArray(m, F) == null) {
                    A.add(m);
                    m.setPai(v);
                    m.calcularhLinha();
                    m.calcularF();
                }
            }
//            Encontra o estado v com o menor f(v) em A que não esta contido em F
            v = Utils.menorFNaoContido(A, F);
        }


//        Caso sucesso imprima o g(v)
        if (Utils.menorFContido(A, F) != null) {
            System.out.println(resultado.getG());
        }
    }
}
