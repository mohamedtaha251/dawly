package com.dawly.app.screens.withdraw.withdrawPaypal;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.dawly.app.screens.withdraw.paypalAccountInfo.PaypalAccuntInfoFragment;
import com.dawly.app.screens.withdraw.paypalAmountCurrency.PaypalAmountCurrencyFragment;

public class PaypalSliderAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_FRAGMENTS = 2;
    private Context context;

    public PaypalSliderAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PaypalAmountCurrencyFragment();
            case 1:
                return new PaypalAccuntInfoFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }



}
