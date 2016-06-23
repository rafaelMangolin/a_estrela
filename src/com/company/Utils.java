package com.company;

import java.util.List;

/**
 * Created by rafael on 20/06/16.
 */
public class Utils {

    public static Estado menorFNaoContido(List<Estado> list, List<Estado> fechados){
        return list.stream().reduce(null,(a,b)->{
            if(!fechados.contains(b) && (a == null || a.getF() > b.getF())) return b;
            return a;
        });
    }

    public static Estado menorFContido(List<Estado> list, List<Estado> fechados) {
        return list.stream().reduce(null,(a,b)->{
            if(fechados.contains(b) && (a == null || a.getF() > b.getF())) return b;
            return a;
        });
    }

    public static Estado contemNoArray(Estado m, List<Estado> lista) {
        return lista.stream().reduce(null,(base,valor)->{
            if(valor.equals(m) && m.getG() < valor.getG()) return valor;
            return base;
        });
    }

}
