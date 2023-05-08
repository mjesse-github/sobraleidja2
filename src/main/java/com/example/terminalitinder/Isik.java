package com.example.terminalitinder;

class Isik {
    private String nimi;
    private int vanus;
    private String meeldibKokataJaKoristada;
    private String muusikamaitse;
    private String kasMüsliOnSupp;
    private int raudVõiSulg;
    private String meeldivadPikadJalutuskäigudRannas;
    private String kasAnanassPitsal;
    private String lemmiknumber; //tere

    public Isik(String nimi,
                int vanus,
                String meeldibKokataJaKoristada,
                String muusikamaitse,
                String kasMüsliOnSupp,
                int raudVõiSulg,
                String meeldivadPikadJalutuskäigudRannas,
                String kasAnanassPitsal,
                String lemmiknumber) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.meeldibKokataJaKoristada = meeldibKokataJaKoristada;
        this.muusikamaitse = muusikamaitse;
        this.kasMüsliOnSupp = kasMüsliOnSupp;
        this.raudVõiSulg = raudVõiSulg;
        this.meeldivadPikadJalutuskäigudRannas = meeldivadPikadJalutuskäigudRannas;
        this.kasAnanassPitsal = kasAnanassPitsal;
        this.lemmiknumber = lemmiknumber;
    }

    public String getNimi() {
        return nimi;
    }

    public int getVanus() {
        return vanus;
    }

    public String getMeeldibKokataJaKoristada() {
        return meeldibKokataJaKoristada;
    }

    public String getMuusikamaitse() {
        return muusikamaitse;
    }

    public String getKasMüsliOnSupp() {
        return kasMüsliOnSupp;
    }

    public int getRaudVõiSulg() {return raudVõiSulg;}

    public  String getMeeldivadPikadJalutuskäigudRannas() {
        return meeldivadPikadJalutuskäigudRannas;
    }

    public String getKasAnanassPitsal() {
        return kasAnanassPitsal;
    }

    public String getLemmiknumber() {
        return lemmiknumber;
    }

    public String toStringer() {
        return nimi+";"+vanus+";"+meeldibKokataJaKoristada + ";"+ muusikamaitse + ";" + kasMüsliOnSupp + ";" + raudVõiSulg +
                ";" + meeldivadPikadJalutuskäigudRannas +
                ";" + kasAnanassPitsal +
                ";" + lemmiknumber;
    }

    @Override
    public String toString() {
        return nimi + ", kes on " + vanus + " aastat vana";
    }
}