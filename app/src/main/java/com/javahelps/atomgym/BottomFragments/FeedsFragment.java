package com.javahelps.atomgym.BottomFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javahelps.atomgym.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedsFragment extends Fragment {


    public FeedsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);
        return view;
    }

}
