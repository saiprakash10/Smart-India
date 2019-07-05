package com.example.smarttn;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends Activity {
RatingBar rate;
TextView setrate;
EditText feedback;
Button thank;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		rate=(RatingBar)findViewById(R.id.rating);
		setrate=(TextView)findViewById(R.id.setrating);
		feedback=(EditText)findViewById(R.id.feedinfo);
		thank=(Button)findViewById(R.id.thank);
		rate.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar arg0, float position, boolean arg2) {
				// TODO Auto-generated method stub
				setrate.setText("Rating:"+position);
			}
		});
		
		thank.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				feedback.setText("");
				Toast.makeText(getApplicationContext(), "thanks for your support", Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

}
