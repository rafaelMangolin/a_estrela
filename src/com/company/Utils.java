package com.company;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rafael on 20/06/16.
 */
public class Utils {

    public static Estado menorF(HashMap<String,Estado> map) {
        Estado toReturn = null;
        for(Estado b: map.values()){
            if(toReturn == null || toReturn.getF() > b.getF()) toReturn = b;
        }
        return toReturn;
    }

}
