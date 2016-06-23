package com.company;

/**
 * Created by rafael on 17/06/16.
 */
public class Heuristica {

    static final int[][] estadoFinal =
            {{1,12,11,10},
             {2,13,0,9},
             {3,14,15,8},
             {4,5,6,7}};

    public static int getH1(String[] estado) {
        int count = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int x =Integer.valueOf(estado[(i*4)+j]);
                if(estadoFinal[i][j] != x) {
                    count++;
                }
            }
        }
        return count;
    }
}
