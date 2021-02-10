package com.potatodev.week2dl;

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

    Context context;
    LayoutInflater inflater;

    List<String> dummyLists;

    DummyAdapter(Context ctx, List<String> lists) {
        this.context = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.dummyLists = lists;
    }

    @NonNull
    @Override
    public DummyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dummy_item, parent, false);

        return new DummyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyViewHolder holder, final int position) {
        holder.tvDummy.setText(dummyLists.get(position));
        holder.llDummyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), dummyLists.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dummyLists.size();
    }

    public static class DummyViewHolder extends RecyclerView.ViewHolder{

        TextView tvDummy;
        LinearLayout llDummyItem;

        public DummyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDummy = itemView.findViewById(R.id.tvDummy);
            llDummyItem = itemView.findViewById(R.id.llDummyItem);
        }
    }
}
