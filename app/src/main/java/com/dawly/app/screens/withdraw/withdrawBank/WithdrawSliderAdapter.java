package com.dawly.app.screens.withdraw.withdrawBank;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.dawly.app.BankAccountInfoFragment;
import com.dawly.app.BankAmountCurrencyFragment;

public class WithdrawSliderAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_FRAGMENTS = 2;
    private Context context;

    public WithdrawSliderAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BankAmountCurrencyFragment();
            case 1:
                return new BankAccountInfoFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }



}
