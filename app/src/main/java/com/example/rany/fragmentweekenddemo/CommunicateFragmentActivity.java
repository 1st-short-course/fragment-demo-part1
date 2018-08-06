package com.example.rany.fragmentweekenddemo;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rany.fragmentweekenddemo.fragment.ArticleFragment;

public class CommunicateFragmentActivity extends AppCompatActivity implements ArticleFragment.OnArticleItemClickListener {

    public static final String ARTICLE_FRAGMENT = "article fragment";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate_fragment);
        result = findViewById(R.id.tvArticle);
        showFragment();
    }

    private void showFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.article_container,
                ArticleFragment.getINSTANCE(ARTICLE_FRAGMENT),
                ARTICLE_FRAGMENT);
        transaction.commit();
    }

    @Override
    public void onItemClick(String title) {
        result.setText(title);
    }
}
