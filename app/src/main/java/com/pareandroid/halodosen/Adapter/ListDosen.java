package com.pareandroid.halodosen.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pareandroid.halodosen.PassingDataDariAdapter;
import com.pareandroid.halodosen.R;
import com.pareandroid.halodosen.model.modeldata;


import java.util.ArrayList;

public class ListDosen extends RecyclerView.Adapter<ListDosen.CategoryViewHolder> {

    private Context context;

    public ArrayList<modeldata> getListdosen() {
        return listdosen;
    }

    public void setListdosen(ArrayList<modeldata> listdosen) {
        this.listdosen = listdosen;
    }

    public ListDosen(Context context) {
        this.context = context;
    }


    private ArrayList<modeldata> listdosen;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu, viewGroup, false);

        return new CategoryViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, int i) {

        categoryViewHolder.tvnama.setText(getListdosen().get(i).getNama());
        categoryViewHolder.tvmatkul.setText(getListdosen().get(i).getMatkul());
        categoryViewHolder.call.setText(getListdosen().get(i).getNohp());

        Glide.with(context)
                .load(getListdosen().get(i).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imagephoto);

        final String nama = listdosen.get(i).getNama();
        final String matkul = listdosen.get(i).getMatkul();
        final String photo = listdosen.get(i).getPhoto();




        categoryViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //################################################################
                Intent intent = new Intent(context, PassingDataDariAdapter.class);
                intent.putExtra("nama", nama);
                intent.putExtra("matkul", matkul);
                intent.putExtra("photo", photo);
                //#################"KODE DIATAS UNTUK PASSING DATA KE CLASS LAIN"###########

                context.startActivity(intent);
            }
        });



        categoryViewHolder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + categoryViewHolder.call.getText()));
                call.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

                context.startActivity(call);

            }
        });

    }

    @Override
    public int getItemCount() {
        return getListdosen().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvnama;
        TextView tvmatkul;
        ImageView imagephoto;
        RelativeLayout relativeLayout;
        Button call;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvmatkul = itemView.findViewById(R.id.tv_mata_kuliah);
            imagephoto = itemView.findViewById(R.id.img_item_photo);
            relativeLayout = itemView.findViewById(R.id.rv_item_menu);
            call = itemView.findViewById(R.id.btn_call);
        }
    }
}
