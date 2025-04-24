package com.example.recyclerviewpraktikum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Model> list;
    private Context context;

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc, creator, date;
        ImageButton btnDelete;
        ImageView imgThumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            desc = itemView.findViewById(R.id.tvDesc);
            creator = itemView.findViewById(R.id.tvCreator);
            date = itemView.findViewById(R.id.tvDate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDescription());
        holder.creator.setText("By: " + model.getCreator());
        holder.date.setText("Published: " + model.getDate());
        holder.imgThumbnail.setImageResource(R.drawable.ic_placeholder);

        holder.btnDelete.setOnClickListener(view -> {
            new AlertDialog.Builder(context)
                    .setTitle("Konfirmasi Hapus")
                    .setMessage("Yakin akan menghapus konten ini?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, list.size());
                    })
                    .setNegativeButton("Batal", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
