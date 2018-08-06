package com.example.rany.fragmentweekenddemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rany.fragmentweekenddemo.R;

public class FragmentA extends Fragment{

    private static FragmentA INSTANCE;
    public static FragmentA getInstance(String tags){

        if(INSTANCE == null)
            INSTANCE = new FragmentA();

        Bundle b = new Bundle();
        b.putString("fragmentA", tags);
        INSTANCE.setArguments(b);

        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_a, container, false);
    }
}
