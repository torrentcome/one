package com.comeworld.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.comeworld.app.R;
import com.comeworld.app.model.Recette;
import com.comeworld.app.view.MyStepTextView;

import java.util.List;
import java.util.Random;

public class RecettesListViewAdapter extends ArrayAdapter<Recette> {

    private Context context;
    private LayoutInflater inflater;
    private int[] tab_color = {R.color.google_blue_light, R.color.google_green_light, R.color.google_red_light, R.color.google_violet_light, R.color.google_yellow_light};


    public RecettesListViewAdapter(Context context, int resource, List<Recette> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        ViewHolderChild holder = null;
        if (row == null) {
            row = inflater.inflate(R.layout.view_recettes, parent, false);
            holder = new ViewHolderChild();

            holder.name = (TextView) row.findViewById(R.id.name);
            holder.origin = (TextView) row.findViewById(R.id.origin);
            holder.array_step = (LinearLayout) row.findViewById(R.id.array_step);
            holder.tableLayout = (TableLayout) row.findViewById(R.id.tableLayout);

            row.setTag(holder);
        } else
            holder = (ViewHolderChild) row.getTag();

        holder.array_step.removeAllViews();

        Recette recette = getItem(position);
        Random r = new Random();

        int rand = r.nextInt(tab_color.length - 1);
        holder.tableLayout.setBackgroundColor(context.getResources().getColor(tab_color[rand]));
        holder.name.setText(recette.getName());
        holder.origin.setText(recette.getOrigin());

        String[] split = recette.getStep().split("##");
        for (int i = 0; i < split.length; i++) {
            final MyStepTextView e = new MyStepTextView(context, null);
            e.getEditText().setText(split[i]);
            e.setNumber("#" + (i + 1));
            holder.array_step.addView(e);
        }

        return row;
    }

    protected static class ViewHolderChild {
        public TextView name, origin;
        public LinearLayout array_step;
        public TableLayout tableLayout;
    }
}