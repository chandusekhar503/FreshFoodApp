package com.example.dineshkumarreddy.kirana.views.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dineshkumarreddy.kirana.model.Products;
import com.example.dineshkumarreddy.retrofit.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private List<Products> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemName;
        private TextView tvCost;
        private TextView tvCount;
        private TextView tvAdd;
        private TextView tvRemove;


        private MyViewHolder(View view) {
            super(view);
            tvItemName = view.findViewById(R.id.tvItemName);
            tvCost = view.findViewById(R.id.tvCost);
            tvCount = view.findViewById(R.id.tvCount);
            tvRemove = view.findViewById(R.id.tvRemove);
            tvAdd = view.findViewById(R.id.tvAdd);
        }
    }


    public ProductsAdapter(List<Products> productList, Context context) {
        this.productList = productList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tvItemName.setText(productList.get(position).getItemName());
        holder.tvCost.setText("₹"+ productList.get(position).getItemCost());
        holder.tvCount.setText("0");
        holder.tvRemove.setEnabled(false);
        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int oldCount = Integer.parseInt(holder.tvCount.getText().toString().trim());
                int newCount = oldCount+ 1;
                holder.tvCount.setText(String.valueOf(newCount));
                holder.tvRemove.setEnabled(true);
            }
        });
        holder.tvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int oldCount = Integer.parseInt(holder.tvCount.getText().toString().trim());
                if(oldCount > 0) {
                    int newCount = oldCount -1;
                    holder.tvCount.setText(String.valueOf(newCount));
                }
                if(oldCount == 1){
                    holder.tvRemove.setEnabled(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

}
