package com.example.dineshkumarreddy.kirana.views.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dineshkumarreddy.kirana.model.Category;
import com.example.dineshkumarreddy.kirana.model.Product;
import com.example.dineshkumarreddy.kirana.views.base.BaseFragment;
import com.example.dineshkumarreddy.retrofit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.home.HomePresenter;
import mvp.home.HomePresenterImpl;

/**
 * Created by dineshkumarreddy on 21/06/18.
 */

public class HomeFragment extends BaseFragment implements HomeView, ProductsAdapter.ListListner {

    @BindView(R.id.rvProducts)
    RecyclerView rvProducts;

    @BindView(R.id.tvTotalItems)
    TextView tvTotalItems;

    @BindView(R.id.tvTotalCost)
    TextView tvTotalCost;

    HomeScreen homeScreen;

    HomePresenter presenter;

    @BindView(R.id.search_spinner)
    Spinner searchSpinner;

    @BindView(R.id.search_edittext)
    EditText searchEditText;


    private final String defaultSearchCategory="ALL";
    private final String defaultSearchProduct="ALL";

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        presenter = new HomePresenterImpl();


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeScreen = (HomeScreen) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(presenter!= null){
            presenter.attachView(this);



            //get products from server
            //presenter.setProducts();
            presenter.setProducts(defaultSearchCategory,defaultSearchProduct);

            //get Categories from server
            //presenter.setCategory();
            presenter.setCategory();

            /*List<Product> productList = new ArrayList<>();
            productList.add(new Product("Milk", "20","",""));
            productList.add(new Product("Curd", "22","",""));
            ProductsAdapter adapter = new ProductsAdapter(productList, getActivity());
            adapter.setListener(this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

            rvProducts.setLayoutManager(mLayoutManager);
            rvProducts.setAdapter(adapter);*/
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void navigateToHome() {
        homeScreen.launchHome();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, 400).show();
    }

    @Override
    public void showProducts(List<Product> productList) {
        ProductsAdapter adapter = new ProductsAdapter(productList, getActivity());
        adapter.setListener(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvProducts.setLayoutManager(mLayoutManager);
        rvProducts.setAdapter(adapter);

    }

    @Override
    public void showCategories(List<Category> categoryList) {
        List<String> cata = new ArrayList<>();
        cata.add("All"+"_ ");
        for (Category category: categoryList){
            cata.add(category.getCategoryName()+"_"+category.getCategoryId());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,cata);
        searchSpinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        searchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                String[] categoryArray = selectedItem.split("_");
                String category = categoryArray[1];
                presenter.setProducts(category,defaultSearchProduct);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void getCartDetails(List<Product> cartItem) {
        System.out.println("cartitems::"+ cartItem.size());
        tvTotalItems.setText(String.valueOf(cartItem.size()));
        tvTotalCost.setText(String.valueOf((getTotal(cartItem))));
    }

    private double getTotal(List<Product> cartItem) {
        double total = 0;
        /*for(int i=0; i< cartItem.size(); i++){
            Product products = cartItem.get(i);
            double itemPrice = Double.valueOf(products.getProductPrice());
            if(products.getItemCount() != null) {
                double itemCount = Double.valueOf(products.getItemCount());
                total = total + (itemCount * itemPrice);
            }
        }*/
        return total;
    }
}
