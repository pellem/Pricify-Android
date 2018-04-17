package ca;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ca.ulaval.ima.tp2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InternetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InternetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InternetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InternetFragment() {
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
    public static InternetFragment newInstance(String param1, String param2) {
        InternetFragment fragment = new InternetFragment();
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

        View view = inflater.inflate(R.layout.fragment_internet,
                container, false);
        final TextView txtView=(TextView)view.findViewById(R.id.displaystatus);
        final ImageView imgView = view.findViewById(R.id.circle_green);
        final GradientDrawable drawable = (GradientDrawable) imgView.getDrawable();


        drawable.setColor(Color.WHITE);


        final Button button = (Button) view.findViewById(R.id.button_internet);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean haveConnectedWifi = false;
                boolean haveConnectedMobile = false;


                Log.d("myTag", "checking connexion");

                ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo[] netInfo = cm.getAllNetworkInfo();
                for (NetworkInfo ni : netInfo) {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected())
                            haveConnectedWifi = true;
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected())
                            haveConnectedMobile = true;

                }

                if (haveConnectedWifi == true) {

                    Log.d("myTag", "wifi");
                    txtView.setText("Statut de la connexion:\nWifi");
                    drawable.setColor(Color.GREEN);


                }
                else if (haveConnectedWifi == false && haveConnectedMobile == false) {
                    Log.d("myTag", "no");
                    //do something to handle if wifi & mobiledata is disabled
                    txtView.setText("Statut de la connexion:\nAucune connexion");
                    drawable.setColor(Color.RED);

                }
                else if (haveConnectedWifi == false && haveConnectedMobile == true) {
                    Log.d("myTag", "mobile");
                    txtView.setText("Statut de la connexion:\n3G/LTE");
                    drawable.setColor(Color.GREEN);

                    //do something to handle if wifi & mobiledata is disabled

                } else {
                    Log.d("myTag", "else");
                    txtView.setText("Statut de la connexion:\nAutre");
                    drawable.setColor(Color.GREEN);
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
