package com.company;

import java.util.List;

/**
 * Created by rafael on 20/06/16.
 */
public class Utils {

    public static Estado menorFNaoContido(List<Estado> list, List<Estado> fechados){
        return list.stream().reduce(null,(a,b)->{
            if(!fechados.contains(b) && (a == null || b.getF() > a.getF())) return a;
            return b;
        });
    }
}
