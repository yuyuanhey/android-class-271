package com.example.user.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2016/7/27.
 */
public class OrderAdapter extends BaseAdapter{
    List<Order> orders;
    LayoutInflater inflater;

    public OrderAdapter(Context context, List<Order> orderList){
        this.orders = orderList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    //to get the amount of the data
    public int getCount() {
        return orders.size();
    }

    @Override
    //input a index and it will return the data
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_order_item, null);
            TextView noteTextView = (TextView)convertView.findViewById(R.id.noteTextView);
            TextView drinkTextView = (TextView)convertView.findViewById(R.id.drinkTextView);
            TextView storeInfoTextView = (TextView)convertView.findViewById(R.id.storeInfoTextView);
            holder = new Holder();
            holder.noteTextView = noteTextView;
            holder.drinkTextView = drinkTextView;
            holder.storeInfoTextView = storeInfoTextView;
            convertView.setTag(holder);
        }
        else{
            holder = (Holder)convertView.getTag();
        }

        Order order = orders.get(position);
        holder.noteTextView.setText(order.note);
        holder.drinkTextView.setText(order.drink);
        holder.storeInfoTextView.setText(order.storeInfo);

        return convertView;
    }
    class Holder{
        TextView noteTextView;
        TextView drinkTextView;
        TextView storeInfoTextView;
    }
}
