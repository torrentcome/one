package com.exads.comeworld.app.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.exads.comeworld.app.R;
import com.exads.comeworld.app.database.DatabaseActionRecette;
import com.exads.comeworld.app.helper.TextHelper;
import com.exads.comeworld.app.model.Recette;
import com.exads.comeworld.app.view.MyStep;


/**
 * Created by come on 24/06/14.
 */
public class EditFragments extends Fragment implements View.OnClickListener {

    private LinearLayout array_step;
    private EditText origin;
    private EditText name;
    private TextView add_step;
    private TextView send;

//    private int number_step = 0;

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
        return inflater.inflate(R.layout.frg_edit_stuff, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = (EditText) view.findViewById(R.id.name);
        origin = (EditText) view.findViewById(R.id.origin);
        add_step = (TextView) view.findViewById(R.id.add_step);
        send = (TextView) view.findViewById(R.id.send);
        array_step = (LinearLayout) view.findViewById(R.id.array_step);

        add_step.setOnClickListener(this);
        send.setOnClickListener(this);

        addStep();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add_step:
                addStep();
                break;
            case R.id.send:
                String tname = null, torigin = null, tstep = null;
                tname = name.getText().toString();
                torigin = origin.getText().toString();
                tstep = recupStep();
                if (TextHelper.isOk(tname, torigin, tstep)) {
                    Recette recette = new Recette(tname, torigin, tstep);
                    Long e = DatabaseActionRecette.addRecette(recette);
                    Toast.makeText(getActivity(), "Record? = " + e, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "name or origin or step are null", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    private String recupStep() {
        String recup = null;
        int childcount = array_step.getChildCount();
        for (int i = 0; i < childcount; i++) {
            View v = array_step.getChildAt(i);
            if (v instanceof MyStep) {
                if (!TextUtils.isEmpty(((MyStep) v).getEditText().getText().toString()))
                    if (i == 0)
                        recup = ((MyStep) v).getEditText().getText().toString();
                    else
                        recup = recup + "##" + ((MyStep) v).getEditText().getText().toString();
            }
        }
        return recup;
    }

    private void addStep() {
        final MyStep e = new MyStep(getActivity(), null);
        array_step.addView(e);
        e.getEditText().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());
                alertDialogBuilder.setTitle("do you want remove this step ?");
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                array_step.removeView(e);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;
            }
        });
    }
}
