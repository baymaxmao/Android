package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
public class SecondActivity extends Activity {
     protected void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 requestWindowFeature(Window.FEATURE_NO_TITLE);
    	 setContentView(R.layout.second_layout);
     }

}
