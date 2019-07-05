package com.example.smarttn;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot_password extends Activity {
EditText username,npass,cpass,capenter;
TextView cap1,cap2;
Button retrive;
int counter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot_password);
		username=(EditText)findViewById(R.id.retriveuse);
		npass=(EditText)findViewById(R.id.newpass);
		cpass=(EditText)findViewById(R.id.confirmpass);
		capenter=(EditText)findViewById(R.id.entercap);
		cap1=(TextView)findViewById(R.id.chaptchatext);
		cap2=(TextView)findViewById(R.id.chaptchanew);
		retrive=(Button)findViewById(R.id.retrive);
		
		final SharedPreferences newPreferences=getSharedPreferences("prefer", MODE_PRIVATE);
		final String value=newPreferences.getString("valid1", "");
		
		cap1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (username.getText().toString().isEmpty()) {
					username.setError("type username");
					
				}
				
				else if (username.getText().toString().equals(value)) {
						counter++;
						
						if (counter==0) {
									
								cap1.setText("Regenrate captcha");
										cap2.setText("SFD4YG");
										cap2.setBackgroundResource(R.drawable.cap);
										
									
							
						}
						else if (counter==1) {
							
										cap1.setText("Regenrate captcha");
										cap2.setText("GH6VD7");
										cap2.setBackgroundResource(R.drawable.cap);
										
									
						}
						else if (counter==2) {
							
										
										
										cap1.setText("Regenrate captcha");
										cap2.setText("BJC57G");
										cap2.setBackgroundResource(R.drawable.cap);
										
										
						}
						else if (counter==3) {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("VHJ9FG");
										cap2.setBackgroundResource(R.drawable.cap);
										
									
						}
						else if (counter==4) {
							
										cap1.setText("Regenrate captcha");
										cap2.setText("JHF80N");
										cap2.setBackgroundResource(R.drawable.cap);
										
									
						}
						else if (counter==5) {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("LKV90C");
										cap2.setBackgroundResource(R.drawable.cap);
										
						}
						else if (counter==6) {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("XBS975");
										cap2.setBackgroundResource(R.drawable.cap);
										
										
						}
						else if (counter==7) {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("V23XPG");
										cap2.setBackgroundResource(R.drawable.cap);
										
						}
						else if (counter==8) {
							
										cap1.setText("Regenrate captcha");
										cap2.setText("O0PV6G");
										cap2.setBackgroundResource(R.drawable.cap);
										
									
						}
						else if (counter==9) {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("ZSD34B");
										cap2.setBackgroundResource(R.drawable.cap);
										
						}
						else {
							
										
										cap1.setText("Regenrate captcha");
										cap2.setText("SORRY");
										cap2.setBackgroundResource(R.drawable.cap);
										Toast.makeText(getApplicationContext(), "you reached maximum attemts", Toast.LENGTH_LONG).show();
										
										Intent in0=new Intent(Forgot_password.this,Welcome.class);
										startActivity(in0);
										
						}
						
					}
				else {
					username.setError("check username");
				}
				
			}
		});
		
		
		
		retrive.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (cap2.getText().toString().equals(capenter.getText().toString())) {
					
					if (npass.getText().toString().equals(cpass.getText().toString())) {
						
						SharedPreferences.Editor editor=newPreferences.edit();
						editor.putString("valid2", cpass.getText().toString());
						editor.apply();
		                  Intent inten=new Intent(Forgot_password.this,Welcome.class);
	                    	startActivity(inten);
						Toast.makeText(getApplicationContext(), "your password has been changed", Toast.LENGTH_SHORT).show();
					}
					else {
						cpass.setError("check password");
					}
					
				}
				else {
					capenter.setError("Incorrect captacha");
				}
				
				
				
				
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.forgot_password, menu);
		return true;
	}

}
