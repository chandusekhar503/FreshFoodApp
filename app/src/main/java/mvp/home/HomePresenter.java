package mvp.home;

import com.example.dineshkumarreddy.kirana.views.home.HomeView;

public interface HomePresenter<V extends HomeView>{

    void attachView(V view);

    void detachView();

    void setProducts(String category,String product);

    void setCategory();
}
