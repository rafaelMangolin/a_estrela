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

    static final int[] posicaoFinal = {6,0,4,8,12,13,14,15,11,7,3,2,1,5,9,10};

    public static float getH5(String[] estado){
        float h1 = getH1(estado);
        float h2 = getH2(estado);
        float h3 = getH3(estado);
        return Math.max(Math.max(h1,h2),h3);
    }

    public static float getH4(String[] estado){
        float h1 = getH1(estado);
        float h2 = getH2(estado);
        float h3 = getH3(estado);

        float p1 = .4f;
        float p2 = .2f;
        float p3 = .4f;

        if(p1+p2+p3 != 1) throw new RuntimeException("Soma de p1, p2, p3 diferente de 1");

        return (p1*h1)+(p2*h2)+(p3*h3);
    }

    public static float getH3(String[] estado){
        int count = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int valor =Integer.valueOf(estado[(i*4)+j]);
                if(estadoFinal[i][j] != valor) {
                    int vetIndex = posicaoFinal[valor];
                    int x = vetIndex/4;
                    int y = vetIndex%4;
                    count += Math.abs(x-i) + Math.abs(y-j);
                }
            }
        }
        return count;
    }

    public static float getH2(String[] estado) {
        int count = 0;
        int value = -1;
        for(int x=0; x<caminhoFinal.length;x++){
            int i = caminhoFinal[x][0];
            int j = caminhoFinal[x][1];
            int data = Integer.valueOf(estado[(i*4)+j]);
            if(value > 0 && ((value == 15 && data != 0) || ((value != 15) && (value+1) != data))){
                count++;
            }
            value = data;
        }
        return count;
    }

    public static float getH1(String[] estado) {
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
