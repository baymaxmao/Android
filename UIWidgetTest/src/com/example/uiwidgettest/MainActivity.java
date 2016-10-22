package com.example.uiwidgettest;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.edit_text);
        imageView=(ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        
       
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
    	case R.id.button:
    		//String inputText=editText.getText().toString();
    		//Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
    		//imageView.setImageResource(R.drawable.jelly_bean);
    		//if (progressBar.getVisibility()==View.GONE){
    			// progressBar.setVisibility(View.VISIBLE);  			
    		//}else{
    			//progressBar.setVisibility(View.GONE);
    		//}
    		int progress=progressBar.getProgress();
    		progress= progress+10;
    		progressBar.setProgress(progress);
    		break;
    		default:
    			break;
    	}
	}

    
}
