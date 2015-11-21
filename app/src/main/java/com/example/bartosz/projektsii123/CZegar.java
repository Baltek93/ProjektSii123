package com.example.bartosz.projektsii123;

/**
 * Created by Maciej on 2015-11-20.
 */
public class CZegar {

    private int godzina=1;
    private int minuta=1;
    private int godzinaZapytana=1;
    private int minutaZapytana=1;
    private int checker = 0 ;
    private int iloscPrzejsc = 0;
    private int dzwiekZegar = 0;
    private int pierwszyRaz = 0 ;

    public int getPierwszyRaz() {
        return pierwszyRaz;
    }

    public void setPierwszyRaz(int pierwszyRaz) {
        this.pierwszyRaz = pierwszyRaz;
    }

    public int getDzwiekZegar() {
        return dzwiekZegar;
    }

    public void setDzwiekZegar(int dzwiekZegar) {
        this.dzwiekZegar = dzwiekZegar;
    }

    public int getIloscPrzejsc() {
        return iloscPrzejsc;
    }

    public void setIloscPrzejsc(int iloscPrzejsc) {
        this.iloscPrzejsc = iloscPrzejsc;
    }

    public int getChecker() {
        return checker;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public int getGodzinaZapytana() {
        return godzinaZapytana;
    }

    public void setGodzinaZapytana(int godzinaZapytana) {
        this.godzinaZapytana = godzinaZapytana;
    }

    public int getMinutaZapytana() {
        return minutaZapytana;
    }

    public void setMinutaZapytana(int minutaZapytana) {
        this.minutaZapytana = minutaZapytana;
    }

    public int getGodzina() {
        return godzina;
    }

    public void setGodzina(int godzina) {
        this.godzina = godzina;
    }

    public int getMinuta() {
        return minuta;
    }

    public void setMinuta(int minuta) {
        this.minuta = minuta;
    }
}
