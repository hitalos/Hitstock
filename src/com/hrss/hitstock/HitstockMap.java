package com.hrss.hitstock;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.MapActivity;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class HitstockMap extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapView map = new MapView(this,"0bB4h0ilXgoSPotAh9GwKqzDK4AmkQc_ZBhBaBg");
        map.setBuiltInZoomControls(true);
        MyLocationOverlay mlo = new MyLocationOverlay(this, map);
        mlo.enableMyLocation();
        map.getOverlays().add(mlo);
        map.postInvalidate();
        
        GeoPoint ml = mlo.getMyLocation();
        if(ml != null){
        	map.getController().animateTo(ml);
        	map.getController().setZoom(10);
        }
        else{
        	Toast.makeText(this, "Não foi possível obter a localização!", Toast.LENGTH_SHORT).show();
        }
        //double latitude = -9.416901 * 1E6;
        //double longitude = -35.508964 * 1E6;
        //GeoPoint casa_do_pipoca = new GeoPoint((int) latitude, (int) longitude);

        map.setSatellite(true);
        
        setContentView(map);
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
