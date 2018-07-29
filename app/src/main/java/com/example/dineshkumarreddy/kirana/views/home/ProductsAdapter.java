package com.example.dineshkumarreddy.kirana.views.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dineshkumarreddy.kirana.model.Product;
import com.example.dineshkumarreddy.retrofit.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private List<Product> productList;
    private ListListner listListner;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemName;
        private TextView tvCost;
        private TextView tvCount;
        private TextView tvAdd;
        private TextView tvRemove;
        private Button btnAdd;


        private MyViewHolder(View view) {
            super(view);
            tvItemName = view.findViewById(R.id.tvItemName);
            tvCost = view.findViewById(R.id.tvCost);
            tvCount = view.findViewById(R.id.tvCount);
            tvRemove = view.findViewById(R.id.tvRemove);
            tvAdd = view.findViewById(R.id.tvAdd);
            btnAdd = view.findViewById(R.id.btnAdd);
        }
    }


    public ProductsAdapter(List<Product> productList, Context context) {
        this.productList = productList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tvItemName.setText(productList.get(position).getProductName());
        holder.tvCost.setText("₹"+ productList.get(position).getProductPrice());
        holder.tvCount.setText("0");
        holder.tvRemove.setEnabled(false);
        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddClick(holder, position);
            }
        });
        holder.tvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int oldCount = Integer.parseInt(holder.tvCount.getText().toString().trim());
                if(oldCount > 0) {
                    int newCount = oldCount -1;
                    holder.tvCount.setText(String.valueOf(newCount));
                    //productList.get(position).setItemCount(String.valueOf(newCount));
                    listListner.getCartDetails(productList);
                }
                if(oldCount == 1){
                    holder.tvRemove.setEnabled(false);
                    holder.btnAdd.setVisibility(View.VISIBLE);
                    holder.tvAdd.setVisibility(View.GONE);
                    holder.tvRemove.setVisibility(View.GONE);
                }
            }
        });
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddClick(holder, position);
            }
        });
    }

    private void onAddClick(MyViewHolder holder, int position){
        if(holder.btnAdd.getVisibility() == View.VISIBLE) {
            holder.btnAdd.setVisibility(View.GONE);
            holder.tvAdd.setVisibility(View.VISIBLE);
            holder.tvRemove.setVisibility(View.VISIBLE);
        }
        int oldCount = Integer.parseInt(holder.tvCount.getText().toString().trim());
        int newCount = oldCount+ 1;
        holder.tvCount.setText(String.valueOf(newCount));
        holder.tvRemove.setEnabled(true);
        //productList.get(position).setItemCount(String.valueOf(newCount));
        listListner.getCartDetails(productList);
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

    public interface ListListner{
        void getCartDetails(List<Product> cartItems);
    }

    public void setListener(ListListner listener) {
        this.listListner = listener;
    }
}
