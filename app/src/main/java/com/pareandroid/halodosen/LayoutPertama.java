package com.pareandroid.halodosen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pareandroid.halodosen.Adapter.ListDosen;
import com.pareandroid.halodosen.model.modeldata;

import java.util.ArrayList;

public class LayoutPertama extends AppCompatActivity {
    private RecyclerView rv_daftarmenu;
    private ArrayList<modeldata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pertama);
         rv_daftarmenu = findViewById(R.id.rv_daftar);

         rv_daftarmenu.setHasFixedSize(true);

         list.addAll(DataDosen.getListData());
        showRecyclerList();



    }

    private void  showRecyclerList () {
        rv_daftarmenu.setLayoutManager(new LinearLayoutManager(this));
        ListDosen listDosen = new ListDosen(this);
        listDosen.setListdosen(list);
        rv_daftarmenu.setAdapter(listDosen);
    }
}
