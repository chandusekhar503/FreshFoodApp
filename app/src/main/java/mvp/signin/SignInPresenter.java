package mvp.signin;

import com.example.dineshkumarreddy.kirana.views.signin.SigninView;

public interface SignInPresenter<V extends SigninView>{

    void attachView(V view);

    void signIn(String mobileNumber, String password);
    void detachView();

    void verifyEmail(String mobile);
}
