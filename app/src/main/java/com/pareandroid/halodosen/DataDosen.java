package com.pareandroid.halodosen;

import com.pareandroid.halodosen.model.modeldata;

import java.util.ArrayList;

public class DataDosen {
    public static String [] [] data = new String[][]{
            {"Ade Hastuty","Desain & Anlisis Algoritma","085398029335","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT481_XZ_RWegtccxhUUiXs96SzU678BtGkhYuSU-tLdTa3UcLP"},
            {"Untung Suwardoyo","Pemrograman Berorientasi Objek","085240802223","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO8u5o4-gaW_VY05H93gfVOiZEgDUIcNvotycFLTLl_gIV5eG6"},
            {"Mughaffir Yunus","Pemrograman Web","082293016060","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJrsBJRXjqiaEVHNiLx5HSbdot8aabgbCdyBaEyvKsrNZnSqee"},
            {"Hamra","Grafika Komputer","085341368757","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Computer.svg/300px-Computer.svg.png"},
            {"Wahyu","Keamanan Komputer","082384091594","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4u9MIpvAkwgTfG1vIBShimQ-MMtZiZteu-tkPMwC0RD-PnR11"},
    };
    public static ArrayList<modeldata> getListData(){
        modeldata modeldata = null ;
        ArrayList <modeldata> list = new ArrayList<>();
        for (String[] aData :data){
            modeldata=new modeldata();
            modeldata.setNama(aData[0]);
            modeldata.setMatkul(aData[1]);
            modeldata.setNohp(aData[2]);
            modeldata.setPhoto(aData[3]);

            list.add(modeldata);
        }
        return list;
    }
}
