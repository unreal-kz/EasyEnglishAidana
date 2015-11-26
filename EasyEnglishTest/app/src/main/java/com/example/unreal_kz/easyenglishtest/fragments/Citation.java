package com.example.unreal_kz.easyenglishtest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.unreal_kz.easyenglishtest.R;
import com.example.unreal_kz.easyenglishtest.adapters.MyAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Citation extends Fragment {
    private Context myContext;

    public Citation() {
        //this.myContext = context;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_citation, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.citation_list_view);
        // Inflate the layout for this fragment
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Citation");
        query.addAscendingOrder("author");
        query.setLimit(1000);
        query.findInBackground(new FindCallback<ParseObject>() {
            private ArrayList<String> citation_eng;
            private ArrayList<String> author_eng;
            private List<ArrayList<String>> resource;

            @Override
            public void done(List<ParseObject> list, ParseException e) {
                citation_eng = new ArrayList<String>();
                author_eng = new ArrayList<String>();
                resource = new ArrayList<ArrayList<String>>();
                if (e == null) {
                    for (ParseObject parseObject : list) {
                        citation_eng.add(parseObject.getString("text"));
                        author_eng.add(parseObject.getString("author"));
                    }
                }
                resource.add(citation_eng);
                resource.add(author_eng);
                ArrayAdapter adapter = new MyAdapter(view.getContext(), resource);
                listView.setAdapter(adapter);
            }
        });
        return view;
    }
}
