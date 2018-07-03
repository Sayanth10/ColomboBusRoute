package com.sayanth10.colombobusroute;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class Map extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private View mapFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mapFragment = inflater.inflate(R.layout.map_layout, container, false);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        setHasOptionsMenu(true);
        return mapFragment;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoom = 15;
        // Move the camera to colombo and set the zoom level to 15
        LatLng home = new LatLng(6.9271,79.8612);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home,zoom));
    }

    /**
     *
     * @param menu
     * @param inflater
     *
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.map_options, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;

            default:
                break;
            //return super.onOptionsItemSelected(item);
        }
        return false;
    }

}
