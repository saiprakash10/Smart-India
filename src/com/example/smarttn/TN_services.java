package com.example.smarttn;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TN_services extends Activity {
Button aadhar,pan,voter,ration;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tn_services);
		aadhar=(Button)findViewById(R.id.adharcard);
		pan=(Button)findViewById(R.id.pancard);
		voter=(Button)findViewById(R.id.Voteridcard);
		ration=(Button)findViewById(R.id.rationcard);
		aadhar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle=new Bundle();
				Intent in=new Intent(TN_services.this,Add_Details.class);
				bundle.putString("type", "Aadhaar Card");
				in.putExtras(bundle);
				startActivity(in);
				
			}
		});
		pan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle=new Bundle();
				Intent in=new Intent(TN_services.this,Add_Details.class);
				bundle.putString("type", "Pan Card");
				in.putExtras(bundle);
				startActivity(in);;
				
			}
		});
		voter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle=new Bundle();
				Intent in=new Intent(TN_services.this,Add_Details.class);
				bundle.putString("type", "VoterId Card");
				in.putExtras(bundle);
				startActivity(in);
				
			}
		});
		ration.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bundle=new Bundle();
				Intent in=new Intent(TN_services.this,Add_Details.class);
				bundle.putString("type", "Ration Card");
				in.putExtras(bundle);
				startActivity(in);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tn_services, menu);
		return true;
	}

}
