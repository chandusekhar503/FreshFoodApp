package mvp.signup.signup;

import com.example.dineshkumarreddy.kirana.model.SignUpRequest;
import com.example.dineshkumarreddy.kirana.views.signup.SignupView;

public interface SignUpPresenter<V extends SignupView>{

    void attachView(V view);

    void signUp(SignUpRequest request);
    void detachView();
}
