package mvp.home;

import com.example.dineshkumarreddy.kirana.views.home.HomeView;

import javax.inject.Inject;

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
}
