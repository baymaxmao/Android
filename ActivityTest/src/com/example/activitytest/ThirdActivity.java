package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ThirdActivity extends Activity {
  protected void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	   setContentView(R.layout.third_layout);
	   
  }
}
