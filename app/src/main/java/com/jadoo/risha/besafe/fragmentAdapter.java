package com.jadoo.risha.besafe;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class fragmentAdapter extends FragmentStatePagerAdapter {

    Context context;

    public fragmentAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        fragmentButton fragment = new fragmentButton(position, context);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
