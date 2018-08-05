package mvp.home;

import com.example.dineshkumarreddy.kirana.RetrofitClient;
import com.example.dineshkumarreddy.kirana.model.CategoryResponse;
import com.example.dineshkumarreddy.kirana.model.LoginResponse;
import com.example.dineshkumarreddy.kirana.model.Product;
import com.example.dineshkumarreddy.kirana.model.ProductResponse;
import com.example.dineshkumarreddy.kirana.views.home.HomeView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenterImpl implements HomePresenter {
    HomeView homeView;


    @Inject
    public HomePresenterImpl( ) {
    }

    @Override
    public void attachView(HomeView view) {
        homeView = view;
    }

    @Override
    public void detachView() {
        homeView = null;
    }

    @Override
    public void setProducts(String category, String product) {
        System.out.println(category+" : "+product);
        final Call<ProductResponse> productQueryResponse =  RetrofitClient.getAPIClient().queryProducts(category,product);
        productQueryResponse.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response!= null && response.code() == 200){
                    if(response.body() != null && response.body().getProductList() != null &&!response.body().getProductList().isEmpty())
                    homeView.showProducts(response.body().getProductList());
                }else{

                }
            }
            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });




    }

    @Override
    public void setCategory() {

        final Call<CategoryResponse> categoryQueryResponse =  RetrofitClient.getAPIClient().queryCategories();
        categoryQueryResponse.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response!= null && response.code() == 200){
                    if(response.body() != null && response.body().getCategoryList() != null &&!response.body().getCategoryList().isEmpty())
                        homeView.showCategories(response.body().getCategoryList());
                }else{

                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });






    }
}
