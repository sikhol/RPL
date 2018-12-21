package com.example.emfauzanashari.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.emfauzanashari.Model.ListMatakuliah.ResponseListMatakuliah;
import com.example.emfauzanashari.nyoba.MkActivity;
import com.example.emfauzanashari.nyoba.R;

import java.util.List;


    public class CustomAdapterMataKuliah  extends RecyclerView.Adapter<CustomAdapterMataKuliah.CustomViewHolder> {

        private final List<ResponseListMatakuliah> responseListMataKuliah;
        private List<ResponseListMatakuliah> responseListMatakuliah;

        public CustomAdapterMataKuliah(List<ResponseListMatakuliah> responseListMataKuliah) {
            this.responseListMataKuliah = responseListMataKuliah;
        }


        class CustomViewHolder extends RecyclerView.ViewHolder{

            public final View view;
            private Context context;

            TextView tvNama_mk;
            

            CustomViewHolder(View itemView){
                super(itemView);
                view = itemView;
                context = itemView.getContext();

                tvNama_mk = view.findViewById(R.id.tv_nama_mk);

                tvNama_mk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        switch (getAdapterPosition()){
                            case 0 :
                                intent = new Intent(context, MkActivity.class);

                                break;
                            case 1 :
                                intent = new Intent(context, MkActivity.class);

                                break;
                            case 2 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 3 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 4 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 5 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 6 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 7 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 8 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                            case 9 :
                                intent = new Intent(context, MkActivity.class);
                                break;
                        }
                        intent.putExtra("id", responseListMataKuliah.get(getAdapterPosition()).getIdMataKuliah());
                        context.startActivity(intent);
                    }
            });

        }
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.layout_matakuliah, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.tvNama_mk.setText(responseListMataKuliah.get(position).getNama_mk());

        }

        @Override
        public int getItemCount() {
            return responseListMataKuliah.size();
        }
    }


