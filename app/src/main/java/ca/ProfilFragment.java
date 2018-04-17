package ca;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import ca.ulaval.ima.tp2.MonProfil;
import ca.ulaval.ima.tp2.Profil;
import ca.ulaval.ima.tp2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InternetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
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
        final View view = inflater.inflate(R.layout.fragment_profil,
                container, false);
        final RadioGroup radioSexGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        final EditText nomEditText = (EditText) view.findViewById(R.id.EditText_FirstName);
        final EditText prenomEditText = (EditText) view.findViewById(R.id.EditText_LastName);
        final EditText dateEditText = (EditText) view.findViewById(R.id.EditText_BirthDate);
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);



        final Button button = (Button) view.findViewById(R.id.button_submit);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                final RadioButton  radioSexButton = (RadioButton) view.findViewById(selectedId);


                Log.d("myTag", nomEditText.getText().toString());
                Log.d("myTag", prenomEditText.getText().toString());
                Log.d("myTag", dateEditText.getText().toString());
                Log.d("myTag", radioSexButton.getText().toString());
                Log.d("myTag", spinner.getSelectedItem().toString());


                if (TextUtils.isEmpty(nomEditText.getText()) || TextUtils.isEmpty(prenomEditText.getText()) || TextUtils.isEmpty(dateEditText.getText())  || TextUtils.isEmpty(radioSexButton.getText()) || TextUtils.isEmpty(spinner.getSelectedItem().toString()) )
                {
                    Log.d("myTag", "empty");
                }
                else {
                    Profil profil = new Profil(nomEditText.getText().toString(), prenomEditText.getText().toString(), dateEditText.getText().toString(), radioSexButton.getText().toString(), spinner.getSelectedItem().toString());
                    // Start NewActivity.class
                    Intent myIntent = new Intent(getActivity(), MonProfil.class);

                    myIntent.putExtra("myProfil", profil);
                    startActivity(myIntent);

                }
            }
        });

        return view;
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
}
