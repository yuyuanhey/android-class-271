package com.example.user.simpleui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.DialogPreference;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDrinkOrderListener} interface
 * to handle interaction events.
 * Use the {@link DrinkOrderDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkOrderDialog extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DRINK_PARAM = "drink";
    Drink drink;
    NumberPicker mediumNumberPicker;
    NumberPicker largeNumberPicker;
    RadioGroup iceRadioGroup;
    RadioGroup sugarRadioGroup;
    EditText noteEditText;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnDrinkOrderListener mListener;

    public DrinkOrderDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DrinkOrderDialog.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkOrderDialog newInstance(Drink drink) {
        DrinkOrderDialog fragment = new DrinkOrderDialog();
        Bundle args = new Bundle();
        
        args.putParcelable(DRINK_PARAM, drink);

        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//        }
//        mListener.onDrinkOrderFinished();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_drink_order_dialog, container, false);
//
//    }
    //@NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        if(getArguments() != null){
            drink = getArguments().getParcelable(DRINK_PARAM);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View content = getActivity().getLayoutInflater().inflate(R.layout.fragment_drink_order_dialog, null);
        builder.setView(content)
               .setTitle(drink.name)
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
        mediumNumberPicker = (NumberPicker)content.findViewById(R.id.mediumNumberPicker);
        largeNumberPicker = (NumberPicker)content.findViewById(R.id.largeNumberPicker);
        iceRadioGroup = (RadioGroup)content.findViewById(R.id.iceRadioGroup);
        sugarRadioGroup = (RadioGroup)content.findViewById(R.id.sugarRadioGroup);
        noteEditText = (EditText)content.findViewById(R.id.noteEditText);

        mediumNumberPicker.setMaxValue(100);
        mediumNumberPicker.setMinValue(0);
        largeNumberPicker.setMaxValue(100);
        largeNumberPicker.setMinValue(0);
        return builder.create();
    }


    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDrinkOrderListener) {
            mListener = (OnDrinkOrderListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDrinkOrderListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDrinkOrderListener {
        // TODO: Update argument type and name
        void onDrinkOrderFinished();
    }
}
