package com.example.smarttn;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Aadhar extends Activity {
	LinearLayout linear;
	TextView appname,appfather,Year,gen;
	ImageView view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aadhar);
		view=(ImageView)findViewById(R.id.adhar);
		appname=(TextView)findViewById(R.id.applyname);
		gen=(TextView)findViewById(R.id.gender);
		appfather=(TextView)findViewById(R.id.applyssfather);
		linear=(LinearLayout)findViewById(R.id.linear1);
		Year=(TextView)findViewById(R.id.year);
		Bitmap bitmap=(Bitmap)this.getIntent().getParcelableExtra("bitmap");
		view.setImageBitmap(bitmap);
		SharedPreferences preferences=getSharedPreferences("prefer", MODE_PRIVATE);
		final String n=preferences.getString("v1", "");
		String f=preferences.getString("v2", "");
		String g=preferences.getString("v5", "");
		String a=preferences.getString("v3", "");
		final String no=preferences.getString("v6", "");
		
		appname.setText(n);
		appfather.setText(f);
		gen.setText(g);
		Year.setText(a);
		linear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			final	AlertDialog.Builder builder=new Builder(Aadhar.this);
				builder.setIcon(R.drawable.emblem);
				builder.setMessage("May i help you...!!!");
				builder.setPositiveButton("proceed",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						final ProgressDialog dialog=new ProgressDialog(Aadhar.this);
						dialog.setMessage("please wait...!!!");
						dialog.setCancelable(false);
						dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
						dialog.show();
						new Thread(new Runnable() {
							public void run() {
								try {
									
								SmsManager manager=SmsManager.getDefault();
								manager.sendTextMessage(no, null,"Hi "+ n +" your aadhar card applied sucessfull,if you need any official information for our state use this link  http://www.tn.gov.in", null, null);
								Thread.sleep(1000);
								Intent in =new Intent(Aadhar.this,Applied.class);
								startActivity(in);
								} catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
								dialog.dismiss();
								
							}
						}).start();
					}
				});
				builder.setNeutralButton("webview", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent  intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.tn.gov.in"));
						startActivity(intent);
					}
				});
				builder.setNegativeButton("try again", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent in=new Intent(Aadhar.this,Add_Details.class);
						startActivity(in);
						
					}
				});
				
				AlertDialog alertDialog=builder.create();
				alertDialog.show();
				
			}
			
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			finishAffinity();
			break;
		case R.id.item2:
			Intent in=new Intent(this,Feedback.class);
			startActivity(in);
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
