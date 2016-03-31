package org.rbt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.rbt.disableviewpager.R;

/**
 * Created by saikrishna.pawar on 31/03/16.
 */
public class FragmentThree extends Fragment {

    private static float setAlpha;
    private int image;

    // newInstance constructor for creating fragment with arguments
    public static FragmentThree newInstance(float alphaValue) {
        setAlpha = alphaValue;

        FragmentThree fragmentThree = new FragmentThree();
        Bundle args = new Bundle();
        args.putInt("image", R.drawable.android3);
        fragmentThree.setArguments(args);
        return fragmentThree;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = getArguments().getInt("image", 0);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        ImageView iv = (ImageView) view.findViewById(R.id.imageViewThree);
        iv.setImageResource(image);//sets the alpha value directly for the image
        iv.setAlpha(setAlpha);

        return view;
    }
}
