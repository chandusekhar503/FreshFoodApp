package mvp.home;

import com.example.dineshkumarreddy.kirana.RetrofitClient;
import com.example.dineshkumarreddy.kirana.model.LoginResponse;
import com.example.dineshkumarreddy.kirana.views.home.HomeView;
import com.example.dineshkumarreddy.kirana.views.signin.SigninView;

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

    }

    @Override
    public void signIn(String mobile, String password) {
        if (homeView != null) {
            homeView.showLoading();
            Call<LoginResponse> resp = RetrofitClient.getAPIClient().signIn(mobile, password);
            resp.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    homeView.hideLoding();
                    homeView.navigateToHome();
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    System.out.println(t.getMessage());
                    homeView.showError(t.getMessage());
                }
            });
        }
    }

    @Override
    public void detachView() {
        homeView = null;
    }
}
