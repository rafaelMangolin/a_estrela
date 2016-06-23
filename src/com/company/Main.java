package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String inicio = "1 12 11 10 0 13 15 9 2 14 6 8 3 4 5 7";
        Map<String, Estado> hashmap = new HashMap<>();

        List<Estado> A = new ArrayList<>();//Aberto
        List<Estado> F = new ArrayList<>();//Fechado
        List<Estado> S = new ArrayList<>();//Inicial
        List<Estado> T = new ArrayList<>();//Final

        S.add(new Estado(inicio));
        A.addAll(S);
        Estado v = Utils.menorFNaoContido(A, F);
        Estado resultado = null;
        while (v != null) {
            System.out.println(v);
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
                if (Utils.contemNoArray(m, A) == null && Utils.contemNoArray(m, T) == null) {
                    A.add(m);
                    m.setPai(v);
                    m.calcularhLinha();
                    m.calcularF();
                }
            }
            v = Utils.menorFNaoContido(A, F);
        }
        if ((v = Utils.menorFContido(A, F)) != null) {
            System.out.println("Sucesso --->\n" + resultado+"\ng:"+resultado.getG());
        } else {
            System.out.println("Erro --------#---------");
        }
    }
}
