package com.exads.comeworld.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.exads.comeworld.app.R;
import com.exads.comeworld.app.adapter.RecettesListViewAdapter;
import com.exads.comeworld.app.database.DatabaseActionRecette;


/**
 * Created by come on 24/06/14.
 */
public class ListFragments extends Fragment {

    private ListView _listview;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement SelectInTab");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _listview = (ListView) view.findViewById(R.id.listview);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        if (DatabaseActionRecette.getRecettes() != null) {
            RecettesListViewAdapter recettesListViewAdapter = new RecettesListViewAdapter(getActivity(), 0, DatabaseActionRecette.getRecettes(), inflater);
            _listview.setAdapter(recettesListViewAdapter);
        }
    }
}
