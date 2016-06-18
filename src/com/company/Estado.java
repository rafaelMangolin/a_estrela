package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 17/06/16.
 */
public class Estado {
    private String hashKey;
    private String[] matriz;
    private String pai;
    private final int g;
    private final int hLinha;
    private final int f;

    public Estado(String valor) {
        this.hashKey = valor.replace(" ","#");
        this.g = 0;
        this.matriz = valor.split(" ");
        this.hLinha = Heuristica.getH1(this.matriz);
        this.f = this.g + this.hLinha;
        this.pai = null;
    }


    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String[] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[] matriz) {
        this.matriz = matriz;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public int getG() {
        return g;
    }

}
