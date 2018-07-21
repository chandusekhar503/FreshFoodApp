package com.example.dineshkumarreddy.kirana.views.signin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dineshkumarreddy.kirana.views.base.BaseFragment;
import com.example.dineshkumarreddy.retrofit.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.adapter.ViewDataAdapter;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.exception.ConversionException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.signin.SignInPresenter;
import mvp.signin.SignInPresenterImpl;

/**
 * Created by dineshkumarreddy on 21/06/18.
 */

public class SignInFragment extends BaseFragment implements SigninView, Validator.ValidationListener{

    @BindView(R.id.tvSignUp)
    TextView tvSignUp;

    @Length(max = 10, min = 10, message = "Invalid Mobile Number")
    @Order(1)
    @BindView(R.id.tilMobile)
    TextInputLayout tilMobile;

    @BindView(R.id.etMobile)
    EditText etMobile;

    @Length(max = 20, min = 8, message = "Invalid Password")
    @Order(2)
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.progres_bar)
    ProgressBar progressBar;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    SignInScreen signInScreen;

    SignInPresenter presenter;
    protected Validator validator;


    public static SignInFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SignInFragment fragment = new SignInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validator = new Validator(this);
        validator.setValidationMode(Validator.Mode.BURST);
        validator.setValidationListener(this);
        validator.registerAdapter(TextInputLayout.class, mTextInputLayoutFixAdapter);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, null);
        ButterKnife.bind(this, view);
        presenter = new SignInPresenterImpl();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        signInScreen = (SignInScreen) context;
    }

    @OnClick(R.id.tvSignUp)
    public void OnSignUpClick(){
        signInScreen.launchRegisterActitivty();
    }

    @OnClick(R.id.btnLogin)
    public void OnSignInClick(){
        clearErrorMessages();
        validator.validate();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(presenter!= null){
            presenter.attachView(this);
        }
    }

    private ViewDataAdapter<TextInputLayout, String> mTextInputLayoutFixAdapter = new ViewDataAdapter<TextInputLayout, String>() {
        @Override
        public String getData(TextInputLayout view) throws ConversionException {
            return view.getEditText().getText().toString();
        }
    };

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        btnLogin.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoding() {
        btnLogin.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        signInScreen.launchHome();
    }

    @Override
    public void showEmailNotVerifiedDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_verify_mail);

        Button btnOk = (Button) dialog.findViewById(R.id.btnOk);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.verifyEmail(etMobile.getText().toString());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

    @Override
    public void showError(String message) {
        hideLoding();
        Snackbar.make(getView(), message, 400).show();
    }

    @Override
    public void onValidationSucceeded() {
        presenter.signIn(etMobile.getText().toString(), etPassword.getText().toString());

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            if (error.getView() instanceof TextInputLayout) {
                ((TextInputLayout) error.getView()).setErrorEnabled(true);
                ((TextInputLayout) error.getView()).setError(error.getCollatedErrorMessage(getContext()));
            }
        }
    }

    private void clearErrorMessages(){
        tilMobile.setError(null);
        tilMobile.setErrorEnabled(false);

        tilPassword.setError(null);
        tilPassword.setErrorEnabled(false);
    }
}
