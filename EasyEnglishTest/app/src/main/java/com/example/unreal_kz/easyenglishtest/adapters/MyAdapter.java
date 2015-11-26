package com.example.unreal_kz.easyenglishtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unreal_kz.easyenglishtest.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<ArrayList<String>> {


    public MyAdapter(Context context, List<ArrayList<String>> objects) {
        super(context, R.layout.list_view_adapter, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.list_view_adapter, parent, false);

        ArrayList<String> data = getItem(position);

        TextView textCitation = (TextView) convertView.findViewById(R.id.text_citation);
        TextView textAuthor = (TextView) convertView.findViewById(R.id.author_citation);
        textCitation.setText(data.get(0));
        return convertView;
    }
}
