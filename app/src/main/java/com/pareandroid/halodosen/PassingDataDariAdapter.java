package com.pareandroid.halodosen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pareandroid.halodosen.R;

public class PassingDataDariAdapter extends AppCompatActivity {

    TextView tv_matkul,tv_nama;
    ImageView imageView;
    String nama,matkul,photo;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data_dari_adapter);

        tv_matkul = findViewById(R.id.tv_psg_matkul);
        tv_nama = findViewById(R.id.tv_psg_nama);
        imageView = findViewById(R.id.img_item_photops);

        //####################################################
        nama = getIntent().getStringExtra("nama");
        matkul = getIntent().getStringExtra("matkul");
        photo = getIntent().getStringExtra("photo");
        //###########"KODE TERIMA DATA DARI ADAPTER"########


        //############################################################
        Glide.with(this)
                .load(photo)//mengambil data di adapter
                .into(imageView);// untuk menampilkannya ke imageview
        //###"KODE INI MENGAMBIL DATA GAMBAR YANG DARI URL CLASS LISTDOSEN KE SINI"#####

        tv_nama.setText(nama);
        tv_matkul.setText(matkul);
    }


}
