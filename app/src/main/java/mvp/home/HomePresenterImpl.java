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
    public void detachView() {
        homeView = null;
    }
}
