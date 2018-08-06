package com.example.rany.fragmentweekenddemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rany.fragmentweekenddemo.fragment.FragmentA;
import com.example.rany.fragmentweekenddemo.fragment.FragmentB;

public class DynamicFragmentActivity extends AppCompatActivity {

    private Button btnAdd, btnReplace, btnRemove;
    public static final String FRAGMENT_A = "fragmentA";
    public static final String FRAGMENT_B = "fragmentB";
    public static final int ADD_FRAGMENT = 1;
    public static final int REPLACE_FRAGMENT = 0;
    public static final int REMOVE_FRAGMENT = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        //showFragment();
        initView();
        initEvent();

    }

    private void initEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //************* pure code **********************
//                FragmentTransaction t = getFragmentManager().beginTransaction();
//                t.add(R.id.container, FragmentA.getInstance(FRAGMENT_A), FRAGMENT_A);
//                t.commit();
                //************ function ************************
                manipulateFragment(R.id.container, FragmentA.getInstance(FRAGMENT_A),
                        FRAGMENT_A, false, ADD_FRAGMENT);
            }
        });
        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manipulateFragment(R.id.container, new FragmentB(),
                        FRAGMENT_B, true, REPLACE_FRAGMENT);
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manipulateFragment(0, new FragmentB(),
                        FRAGMENT_B,true, REMOVE_FRAGMENT);
            }
        });
    }

//    private void addFragment() {
//        FragmentTransaction t = getFragmentManager().beginTransaction();
//        t.add(R.id.container, FragmentA.getInstance(FRAGMENT_A), FRAGMENT_A);
//        t.commit();
//    }

    //-----------------------------------------------------------------------
    // ---- Manipulate (Add, Replace, Remove) in one function --------
    private void manipulateFragment(int container, Fragment fragment,
                             String tags, boolean addToBackStack, int status) {
        FragmentTransaction t = getFragmentManager().beginTransaction();
                switch (status){
                    case ADD_FRAGMENT:{
                        if(addToBackStack)
                            t.addToBackStack(null);
                        t.add(container, fragment, tags);
                        t.commit();
                        break;
                    }
                    case REPLACE_FRAGMENT:{
                        if(addToBackStack)
                            t.addToBackStack(null);
                        t.replace(container, fragment, tags);
                        t.commit();
                        break;
                    }
                    case REMOVE_FRAGMENT:{
                        fragment = getFragmentManager().findFragmentByTag(tags);
                        if(fragment != null){
                            if(addToBackStack)
                                t.addToBackStack(null);
                            t.remove(fragment);
                            t.commit();
                        }
                        else
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

                        break;
                    }
                }
    }


    private void initView() {
        btnAdd = findViewById(R.id.btnAdd);
        btnReplace = findViewById(R.id.btnReplace);
        btnRemove = findViewById(R.id.btnRemove);
    }

    // ------------------ For add fragment to activity
    private void addFragment(int container, Fragment fragment, String tag) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(container, fragment, tag);
        transaction.commit();
    }
    // ------------------ For replace fragement to activity
    private void replaceFragement(int container, Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(container, fragment, tag);
        if(addToBackStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
    // ------------------- For remove fragment from Activity
    private void removeFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragment = getFragmentManager().findFragmentByTag(tag);
        if(fragment != null){
            transaction.remove(fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

    }
}
