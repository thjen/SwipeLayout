package com.example.thjen.swipelayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;

public class recycAdapter extends RecyclerView.Adapter<recycAdapter.ViewHolder> {

    Context context;
    ArrayList<item> list;
    int layout;

    public recycAdapter(Context context, ArrayList<item> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getItem1());
        holder.tv2.setText(list.get(position).getItem2());
        holder.tv3.setText(list.get(position).getItem3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void RemoveItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3;
        ImageView ivTrash, ivEdit;

        SwipeLayout swipe;

        public ViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            tv3 = (TextView) itemView.findViewById(R.id.tv3);

            ivTrash = itemView.findViewById(R.id.ivTrash);
            ivEdit = itemView.findViewById(R.id.ivEdit);

            swipe = itemView.findViewById(R.id.swipe);

            ivTrash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RemoveItem(getAdapterPosition());
                }
            });

            ivEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                }
            });

            swipe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Swipe", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}
