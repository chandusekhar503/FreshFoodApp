package com.example.dineshkumarreddy.kirana.views.base;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;

import com.mobsandgeeks.saripaar.adapter.ViewDataAdapter;
import com.mobsandgeeks.saripaar.exception.ConversionException;

import static com.example.dineshkumarreddy.kirana.views.base.BaseActivity.closeKeyboard;

/**
 * Created by dineshkumarreddy on 30/06/18.
 */

public abstract class BaseFragment extends Fragment {

    protected BackHandlerInterface backHandlerInterface;

    public interface BackHandlerInterface {

        void setSelectedFragment(BaseFragment backHandledFragment);

        void removeSelectedFragment(BaseFragment backHandledFragment);
    }

    public abstract boolean onBackPressed();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backHandlerInterface = (BackHandlerInterface) getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        closeKeyboard((Activity) getContext());
        backHandlerInterface.removeSelectedFragment(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

        // Mark this fragment as the selected Fragment.
        backHandlerInterface.setSelectedFragment(this);
    }

    protected boolean isGpsEnabled(Context context){
        boolean isEnabled = false;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if(locationManager!= null) {
            isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                return true;
        } else{
            return false;
        }
    }

}
