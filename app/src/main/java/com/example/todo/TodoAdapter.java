package com.example.todo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.Model.Item;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    List<Item>itemList;

    public TodoAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Item item=itemList.get(i);
        viewHolder.itemT.setText(item.getTitle()+"");
        viewHolder.itemB.setText(item.getBody()+"");
    }

    @Override
    public int getItemCount() {
        if (itemList==null)
            return 0;
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemT,itemB;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemT=itemView.findViewById(R.id.itemTitle);
            itemB=itemView.findViewById(R.id.itemBody);
        }
    }
}
