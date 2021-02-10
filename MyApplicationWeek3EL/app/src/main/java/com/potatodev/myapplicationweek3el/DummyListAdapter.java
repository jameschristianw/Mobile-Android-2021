package com.potatodev.myapplicationweek3el;

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

public class DummyListAdapter extends RecyclerView.Adapter<DummyListAdapter.DummyListViewHolder> {
    private LayoutInflater inflater;
    private List<String> dummyList;

    DummyListAdapter(Context context, List<String> lists){
        this.dummyList = lists;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DummyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dummy_item, parent, false);
        return new DummyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DummyListViewHolder holder, final int position) {
        holder.tvDummyText.setText(dummyList.get(position));
        holder.llDummyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), dummyList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dummyList.size();
    }

    static class DummyListViewHolder extends RecyclerView.ViewHolder{
        TextView tvDummyText;
        LinearLayout llDummyItem;

        public DummyListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDummyText = itemView.findViewById(R.id.tvDummyText);
            llDummyItem = itemView.findViewById(R.id.llDummyItem);
        }
    }
}
