package com.potatodev.week3bl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.DummyViewHolder> {
    Context ctx;
    List<String> lists;

    DummyAdapter(Context context, List<String> data){
        this.ctx = context;
        this.lists = data;
    }

    @NonNull
    @Override
    public DummyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.dummy_item, parent, false);

        return new DummyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyViewHolder holder, final int position) {
        holder.tvDummyItem.setText(lists.get(position));
        holder.llDummyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, lists.get(position) + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class DummyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDummyItem;
        LinearLayout llDummyItem;

        public DummyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDummyItem = itemView.findViewById(R.id.tvDummyItem);
            llDummyItem = itemView.findViewById(R.id.llDummyItem);
        }
    }
}
