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

    static final int[][] caminhoFinal = { {0,0}, {1,0}, {2,0}, {3,0},
            {3,1}, {3,2}, {3,3}, {2,3},
            {1,3}, {0,3}, {0,2}, {0,1},
            {1,1}, {2,1}, {2,2}, {1,2}
    };

    public static int getH2(String[] estado) {
        int count = 0;
        int value = -1;
        for(int x=0;x<caminhoFinal.length;x++){
            int i = caminhoFinal[x][0];
            int j = caminhoFinal[x][1];
            int data = Integer.valueOf(estado[(i*4)+j]);
            if(value > 0 && ((value == 15 && data != 0) || (value != 15 && (value+1) != data))){
                count++;
            }
            value = data;
        }
        //2 1 12 11
        //3 15 6 10
        //4 0  7  9
        //5 13 14 8
        return count;
    }

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
