package com.example.konitake.quiz_sample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag_question1 extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

       setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_question1, container, false);
        return v;

    }

}