package mvp.home;

import com.example.dineshkumarreddy.kirana.views.home.HomeView;

public interface HomePresenter<V extends HomeView>{

    void attachView(V view);

    void signIn(String mobileNumber, String password);
    void detachView();
}
