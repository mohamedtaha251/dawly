package com.dawly.app.screens.flights;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentAddFlightPaymentBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonBold;

public class AddFlightPaymentFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAddFlightPaymentBinding fragmentAddFlightBinding;
    DawlyButtonBold submitBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAddFlightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_flight_payment, container, false);
        submitBtn = fragmentAddFlightBinding.submitBtn;
        submitBtn.setOnClickListener(this);
        return fragmentAddFlightBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightPaypalFragment()).commit();
                break;
        }
    }
}