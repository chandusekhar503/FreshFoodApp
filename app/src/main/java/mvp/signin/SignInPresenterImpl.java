package mvp.signin;

import com.example.dineshkumarreddy.kirana.RetrofitClient;
import com.example.dineshkumarreddy.kirana.model.ApiResponse;
import com.example.dineshkumarreddy.kirana.model.LoginResponse;
import com.example.dineshkumarreddy.kirana.views.signin.SigninView;

import javax.inject.Inject;

import mvp.signin.SignInPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInPresenterImpl implements SignInPresenter {
    SigninView signinView;


    @Inject
    public SignInPresenterImpl( ) {
    }

    @Override
    public void attachView(SigninView view) {
        this.signinView = view;
    }

    @Override
    public void signIn(String mobile, String password) {
        if (signinView != null) {
            signinView.showLoading();
            Call<LoginResponse> resp = RetrofitClient.getAPIClient().signIn(mobile, password);
            resp.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    signinView.hideLoding();
                    if(response.body().getCode() == 201){
                        signinView.showEmailNotVerifiedDialog();
                    }else {
                        signinView.navigateToHome();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    System.out.println(t.getMessage());
                    signinView.showError(t.getMessage());
                }
            });
        }
    }

    @Override
    public void detachView() {
        signinView = null;
    }

    @Override
    public void verifyEmail(String mobile) {
        if(signinView != null){
            signinView.showLoading();
            Call<ApiResponse> resp = RetrofitClient.getAPIClient().verifyEmail(mobile);
            resp.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    signinView.hideLoding();
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    System.out.println(t.getMessage());
                    signinView.showError(t.getMessage());
                }
            });
        }
    }
}
