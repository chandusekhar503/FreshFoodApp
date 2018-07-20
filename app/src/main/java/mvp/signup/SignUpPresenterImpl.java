package mvp.signup.signup;

import com.example.dineshkumarreddy.kirana.RetrofitClient;
import com.example.dineshkumarreddy.kirana.model.ApiResponse;
import com.example.dineshkumarreddy.kirana.model.SignUpRequest;
import com.example.dineshkumarreddy.kirana.views.signup.SignupView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpPresenterImpl implements SignUpPresenter {
    SignupView signupView;


    @Inject
    public SignUpPresenterImpl( ) {
    }

    @Override
    public void attachView(SignupView view) {
        this.signupView = view;
    }

    @Override
    public void signUp(SignUpRequest request) {
        if (signupView != null) {
            signupView.showLoading();
            Call<ApiResponse> resp = RetrofitClient.getAPIClient().signUp( request);
            resp.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    signupView.hideLoding();
                    ApiResponse signupResponse = response.body();
                    if (signupResponse != null) {
                        if (signupResponse.getCode() == 200) {
                            signupView.navigateToSignIn();
                        } else {
                            signupView.showError(signupResponse.getMessage());
                        }
                    } else {
                        signupView.showError("something went wrong please try later");
                    }
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                 signupView.showError(t.getMessage());
                }
            });
        }
    }

    @Override
    public void detachView() {
        signupView = null;
    }
}
