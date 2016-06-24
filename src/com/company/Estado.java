package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by rafael on 17/06/16.
 */
public class Estado {
    private String hashKey;
    private String[] matriz;
    private Estado pai;
    private final int g;
    private float hLinha;
    private float f;
    private List<Estado> filhos;

    public Estado(String valor) {
        this.hashKey = valor.trim().replaceAll("(\\s)+", "#");
        this.g = 0;
        this.matriz = valor.split("(\\s)+");
//        this.hLinha = Heuristica.getH1(this.matriz);
//        this.hLinha = Heuristica.getH2(this.matriz);
        this.hLinha = Heuristica.getH3(this.matriz);
//        this.hLinha = Heuristica.getH4(this.matriz);
//        this.hLinha = Heuristica.getH5(this.matriz);
        this.f = this.g + this.hLinha;
        this.pai = null;
    }

    public Estado(String valor, Estado pai) {
        this.hashKey = valor.trim().replaceAll("(\\s)+", "#");
        this.g = pai.getGMais1();
        this.matriz = valor.split("(\\s)+");
    }

    public List<Estado> calculaFilhos() {
        int zero = getZeroIndex();
        int i = zero / 4;
        int j = zero % 4;
        filhos = new ArrayList<>();
        //filho da esquerda
        if (j > 0) {
            addFilho(i, j, i, j - 1);
        }
        //filho da direita
        if (j < 3) {
            addFilho(i, j, i, j + 1);
        }
        //filho de cima
        if (i > 0) {
            addFilho(i, j, i - 1, j);
        }
        //filho de baixo
        if (i < 3) {
            addFilho(i, j, i + 1, j);
        }


        return null;
    }

    private void addFilho(int i, int j, int i2, int j2) {
        String[] arrAux = matriz.clone();
        String aux = matriz[(4 * i2) + j2];
        arrAux[(4 * i2) + j2] = "0";
        arrAux[(4 * i) + j] = aux;
        filhos.add(new Estado(String.join(" ", arrAux), this));
    }

    private int getZeroIndex() {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i].equals("0")) return i;
        }
        return -1;
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

    public Estado getPai() {
        return pai;
    }

    public void setPai(Estado pai) {
        this.pai = pai;
    }

    public int getG() {
        return g;
    }

    public List<Estado> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Estado> filhos) {
        this.filhos = filhos;
    }

    public int getGMais1() {
        return g + 1;
    }

    public float getF() {
        return f;
    }

    public float gethLinha() {
        return hLinha;
    }

    public void calcularhLinha() {
//        this.hLinha = Heuristica.getH1(this.matriz);
//        this.hLinha = Heuristica.getH2(this.matriz);
        this.hLinha = Heuristica.getH3(this.matriz);
//        this.hLinha = Heuristica.getH4(this.matriz);
//        this.hLinha = Heuristica.getH5(this.matriz);
    }

    public Boolean ehFinal() {
        return this.getHashKey().equals("1#12#11#10#2#13#0#9#3#14#15#8#4#5#6#7");
    }

    public void calcularF() {
        this.f = this.hLinha + this.g;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return !(hashKey != null ? !hashKey.equals(estado.hashKey) : estado.hashKey != null);
    }

    @Override
    public String toString() {
        String toPrint = "";

        for (int i = 0; i < matriz.length; i++) {
            toPrint += matriz[i];
            if (i % 4 == 3 ) {
                toPrint += "\n";
            } else {
                toPrint += "\t";
            }

        }
            return toPrint;
    }
}
