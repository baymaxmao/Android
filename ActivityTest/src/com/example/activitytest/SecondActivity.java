package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
public class SecondActivity extends BaseActivity {
     protected void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 Log.d("SecondActivity", "Task id is"+getTaskId());
    	 requestWindowFeature(Window.FEATURE_NO_TITLE);
    	 setContentView(R.layout.second_layout);
    //	 Intent intent=getIntent();
    	// String data=intent.getStringExtra("extra_data");
    //	 Log.d("SecondActivity",data);
    	 Button button2=(Button) findViewById(R.id.button_2);
    	 button2.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			//Intent intent=new Intent(SecondActivity.this,FirstActivity.class);
                   Intent intent =new Intent(SecondActivity.this,ThirdActivity.class);
    		    startActivity(intent);
    			//Intent intent=new Intent();
    			//intent.putExtra("data_return", "Hello FirstActivity");
    			//setResult(RESULT_OK,intent);
    			//finish();
    		} 
    	 });
     }
     public void onBackPressed(){
    	 Intent intent=new Intent();
    	 intent.putExtra("data_return", "Hello FirstActivity");
    	 setResult(RESULT_OK, intent);
    	 finish();
     }
     public void onDestroy(){
    	 super.onDestroy();
    	 Log.d("SecondActivity", "onDestroy");
     }

}
