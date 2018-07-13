package me.blr3.parsestagram;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    ImageButton logout;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }
        // Inflate the layout for this fragment


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            final Intent intent = new Intent(getActivity(), MainActivity.class);
            logout = view.findViewById(R.id.ivLogout);

            logout.setOnClickListener(new View.OnClickListener()   {
                public void onClick(View v) {
                    ParseUser.logOut();
                    startActivity(intent);

                    }

            });


    }


    }


