package com.example.broadcasttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
     private IntentFilter intentFilter;
     private LocalReceiver localReceiver;
     private LocalBroadcastManager localBroadcastManager;
     private NetworkChangeReceiver networkChangeReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		localBroadcastManager=LocalBroadcastManager.getInstance(this);
		Button button=(Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent=new Intent("com.example.broadcasttest.MY_BROADCAST");
				//sendOrderedBroadcast(intent,null);
				Intent intent=new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
				localBroadcastManager.sendBroadcast(intent);
				
			}
			
		});
		intentFilter =new IntentFilter();
		//intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
		localReceiver=new LocalReceiver();
		localBroadcastManager.registerReceiver(localReceiver, intentFilter);
		networkChangeReceiver=new NetworkChangeReceiver ();
		registerReceiver(networkChangeReceiver,intentFilter);
	}
	
@Override
protected void onDestroy(){
	super.onDestroy();
	//unregisterReceiver(networkChangeReceiver);
	localBroadcastManager.unregisterReceiver(localReceiver);
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class NetworkChangeReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			ConnectivityManager connectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo=connectionManager.getActiveNetworkInfo();
			if (networkInfo!=null&& networkInfo.isAvailable()){
				Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
			}
			
		}
		
	}
	class LocalReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Toast.makeText(context,"received local broadcast", Toast.LENGTH_SHORT).show();
			
		}
		
		
	}
}
