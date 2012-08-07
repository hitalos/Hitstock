package com.hrss.hitstock;

import org.apache.cordova.DroidGap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends DroidGap {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featuredId, MenuItem item){
    	switch(item.getItemId()){
    		case R.id.local:
    			Intent it = new Intent(this, HitstockMap.class);
    			startActivity(it);
    	}
    	
    	return false;
    }
}
