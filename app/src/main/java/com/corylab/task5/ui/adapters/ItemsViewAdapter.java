package com.corylab.task5.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.corylab.task5.R;
import com.corylab.task5.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsViewAdapter extends RecyclerView.Adapter<ItemsViewAdapter.ItemsViewAdapterHolder> {
    Context context;
    List<Item> textBlocks;

    public ItemsViewAdapter(Context context) {
        this.context = context;
        this.textBlocks = new ArrayList<>();
    }

    public final static class ItemsViewAdapterHolder extends RecyclerView.ViewHolder {
        TextView text;
        RecyclerView comments;

        public ItemsViewAdapterHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.listTextValue);
        }
    }

    @NonNull
    @Override
    public ItemsViewAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(context).inflate(R.layout.fragment_text_block, parent, false);
        return new ItemsViewAdapterHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewAdapterHolder holder, @SuppressLint("RecyclerView") int position) {
        Item textBlock = textBlocks.get(position);
        holder.text.setText(textBlock.getText());
        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "нажали на " +
                        (position+1), Toast.LENGTH_LONG );
                toast.show();
            }});
    }

    @Override
    public int getItemCount() {
        return textBlocks.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void updateTextBlocks(List<Item> comments) {
        this.textBlocks.clear();
        this.textBlocks = comments;
        notifyDataSetChanged();
    }
}
