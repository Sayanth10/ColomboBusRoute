package com.sayanth10.colombobusroute;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchOptions extends Fragment implements View.OnClickListener {

    private View mView;
    private TextView startToEnd;
    private TextView currentToEnd;
    private TextView routeNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.search_options_layout, container, false);
        startToEnd = mView.findViewById(R.id.start_to_destination);
        startToEnd.setOnClickListener(this);
        currentToEnd = mView.findViewById(R.id.current_to_destination);
        currentToEnd.setOnClickListener(this);
        routeNumber = mView.findViewById(R.id.route_number);
        routeNumber.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View v) {
        Fragment selectedFragment =null;
        switch (v.getId()){
            case R.id.start_to_destination:
                selectedFragment = new StartToDestination();
                break;
            case R.id.current_to_destination:
                selectedFragment = new StartToDestination();
                break;
            case R.id.route_number:
                selectedFragment = new SearchRouteNumber();
                break;
            default:
                break;

        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

    }

}
