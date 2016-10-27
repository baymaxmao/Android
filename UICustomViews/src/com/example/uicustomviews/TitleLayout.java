package com.example.uicustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.app.Activity;

public class TitleLayout extends LinearLayout{
	public TitleLayout(Context context,AttributeSet attrs){
		super(context,attrs);
		LayoutInflater.from(context).inflate(R.layout.title, this);
		Button titleBack=(Button) findViewById(R.id.title_back);
		Button titleEdit=(Button) findViewById(R.id.title_edit);
		titleBack.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((Activity) getContext()).finish();
			}
			
		});
		titleEdit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getContext(),"You clicked Edit Button",Toast.LENGTH_SHORT).show();
			}
			
		});
		
	}

}
