package com.example.drawerlayout;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button mBtnAdd;
    private CheckBox mCbStatus1;
    private ImageButton mIbHeart1;
    private TextView mTvTodo1;

    public TodoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodoFragment newInstance(String param1, String param2) {
        TodoFragment fragment = new TodoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_todo, container, false);
        mBtnAdd = (Button)v.findViewById(R.id.btn_add);
        mTvTodo1 = (TextView)v.findViewById(R.id.tv_todo1);
        mCbStatus1 = (CheckBox)v.findViewById(R.id.cb_status1);
        mIbHeart1 = (ImageButton)v.findViewById(R.id.ib_heart1);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("/todos");
                    Log.d("check" , myRef.getRef().toString());
                    String id = "todo1";
                    String name = "This is the first todo";
                    String email = null;
                    Pattern gmailPattern = Patterns.EMAIL_ADDRESS;
                    Account[] accounts = AccountManager.get(getContext()).getAccounts();
                    for (Account account : accounts) {
                        if (gmailPattern.matcher(account.name).matches()) {
                            email = account.name;
                        }
                    }

                    boolean status = false;
                    String dateInString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                    myRef.child(id).child("name").setValue(name);
                    myRef.child(id).child("status").setValue(status);
                    myRef.child(id).child("date").setValue(dateInString);
                    myRef.child(id).child("Email").setValue(email);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

                try {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("/todos");
                    Log.d("check" , myRef.getRef().toString());
                    String id = "todo2";
                    String name = "This is the seccond todo";
                    boolean status = true;
                    String dateInString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                    myRef.child(id).child("name").setValue(name);
                    myRef.child(id).child("status").setValue(status);
                    myRef.child(id).child("date").setValue(dateInString);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void onStart(){
        super.onStart();
        try{
            mListener = (OnFragmentInteractionListener) getActivity();

        }
        catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "Must implement OnFragmentInteractionListener");
        }
    }
}
