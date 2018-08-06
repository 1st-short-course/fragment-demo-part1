package com.example.rany.fragmentweekenddemo.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rany.fragmentweekenddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lvArticle;
    private String[] articles;
    private static ArticleFragment INSTANCE;
    private OnArticleItemClickListener listener;

    public static ArticleFragment getINSTANCE(String tags){

        if(INSTANCE == null)
            INSTANCE = new ArticleFragment();
        Bundle b = new Bundle();
        b.putString("ArticleFragment", tags);
        INSTANCE.setArguments(b);

        return INSTANCE;
    }

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        lvArticle = view.findViewById(R.id.lvArticle);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // data source
        articles = getResources().getStringArray(R.array.article);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                articles
        );
        lvArticle.setAdapter(adapter);
        lvArticle.setOnItemClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnArticleItemClickListener){
            listener = (OnArticleItemClickListener) context;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listener.onItemClick(articles[position]);
    }

    public interface OnArticleItemClickListener{
        void onItemClick(String title);
    }

}
