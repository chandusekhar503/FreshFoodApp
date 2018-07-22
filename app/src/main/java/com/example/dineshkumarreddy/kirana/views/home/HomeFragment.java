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

import com.example.dineshkumarreddy.kirana.model.Products;
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

public class HomeFragment extends BaseFragment implements HomeView {

    @BindView(R.id.rvProducts)
    RecyclerView rvProducts;

    HomeScreen homeScreen;

    HomePresenter presenter;

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
//            presenter.getProducts();
            List<Products> productList = new ArrayList<>();
            productList.add(new Products("Milk", "20pl"));
            productList.add(new Products("Curd", "22pl"));
            ProductsAdapter adapter = new ProductsAdapter(productList, getActivity());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            rvProducts.setLayoutManager(mLayoutManager);
            rvProducts.setAdapter(adapter);
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
}
