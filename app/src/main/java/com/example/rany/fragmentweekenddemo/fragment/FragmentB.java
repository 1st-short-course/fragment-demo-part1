package com.example.rany.fragmentweekenddemo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rany.fragmentweekenddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {


    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_b, container, false);
    }

}