package com.example.dineshkumarreddy.kirana.views.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dineshkumarreddy.kirana.model.SignUpRequest;
import com.example.dineshkumarreddy.kirana.views.base.BaseFragment;
import com.example.dineshkumarreddy.kirana.views.signin.LoginActivity;
import com.example.dineshkumarreddy.retrofit.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.adapter.ViewDataAdapter;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import com.mobsandgeeks.saripaar.exception.ConversionException;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.signup.signup.SignUpPresenter;
import mvp.signup.signup.SignUpPresenterImpl;

/**
 * Created by dineshkumarreddy on 21/06/18.
 */

public class SignUpFragment extends BaseFragment implements SignupView, Validator.ValidationListener {

    @BindView(R.id.rgUserType)
    RadioGroup rgUserType;

    @BindView(R.id.rbCustomer)
    RadioButton rbCustomer;

    @BindView(R.id.rbMerc)
    RadioButton rbMerc;


    @Order(value = 1)
    @NotEmpty(sequence = 1)
    @BindView(R.id.tilFirstName)
    TextInputLayout tilFirstName;

    @BindView(R.id.etFirstName)
    EditText etFirstName;

    @Order(value = 2)
    @NotEmpty(sequence = 1)
    @BindView(R.id.tilSecondName)
    TextInputLayout tilSecondName;

    @BindView(R.id.etSecondName)
    EditText etLastName;

    @Order(value = 3)
    @NotEmpty(sequence = 1)
    @Email(sequence = 2)
    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @Order(value = 2)
    @NotEmpty(sequence = 1)
    @Length(sequence = 2, min = 8, max = 30)
    @Password(sequence = 3, min = 8, scheme = Password.Scheme.ALPHA_NUMERIC)
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @Order(value = 3)
    @NotEmpty(sequence = 1)
    @ConfirmPassword(sequence = 2)
    @BindView(R.id.tilConfirmPassword)
    TextInputLayout tilConfirmPassword;

    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;

    @Order(value = 1)
    @NotEmpty(sequence = 1)
    @Length(sequence = 2, min = 10, max = 10)
    @Pattern(sequence = 3, regex = "^[123456789]{1}\\\\d{9}$")
    @BindView(R.id.etMobile)
    EditText etMobile;

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.progres_bar)
    ProgressBar progressBar;

    @Inject
    SignUpPresenter presenter;

    private Validator validator;

    public static SignUpFragment newInstance() {

        Bundle args = new Bundle();

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SignUpPresenterImpl();
        validator = new Validator(this);
        validator.setValidationMode(Validator.Mode.BURST);
        validator.setValidationListener(this);
        validator.registerAdapter(TextInputLayout.class, mTextInputLayoutFixAdapter);
    }

    private ViewDataAdapter<TextInputLayout, String> mTextInputLayoutFixAdapter = new ViewDataAdapter<TextInputLayout, String>() {
        @Override
        public String getData(TextInputLayout view) throws ConversionException {
            return view.getEditText().getText().toString();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void showLoading() {
        btnRegister.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoding() {
        btnRegister.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToSignIn() {
        startActivity(new Intent(getContext(), LoginActivity.class));
    }

    @Override
    public void showError(String messsage) {
        hideLoding();
        if (getView() != null && isAdded()) {
            Snackbar.make(getView(), messsage, 400).show();
        }
    }

    @OnClick(R.id.btnRegister)
    public void onClick() {
        validator.validate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            if (error.getView() instanceof TextInputLayout) {
                ((TextInputLayout) error.getView()).setErrorEnabled(true);
                ((TextInputLayout) error.getView()).setError(error.getCollatedErrorMessage(getContext()));
                return;
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        if (presenter != null) {
            SignUpRequest signUpRequest = new SignUpRequest();
            signUpRequest.setUserFirstName(etFirstName.getText().toString());
            signUpRequest.setUserLastName(etLastName.getText().toString());
            signUpRequest.setUserEmail(etEmail.getText().toString());
            signUpRequest.setUserMobileNumber(etMobile.getText().toString());
            signUpRequest.setUserPassword(etPassword.getText().toString());
            signUpRequest.setUserType("customer");
            signUpRequest.setUserRoleId("5b34ca87284e4529a1ba646c");
            presenter.signUp(signUpRequest);
        }
    }
}
