package com.example.smarttn;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText uname,uphone,umail,upass,ucpass;
	Button submit;
SharedPreferences newPreferences;
SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		uname=(EditText)findViewById(R.id.uname);
		uphone=(EditText)findViewById(R.id.uphone);
		umail=(EditText)findViewById(R.id.umail);
		upass=(EditText)findViewById(R.id.tpass);
		ucpass=(EditText)findViewById(R.id.cpass);
		submit=(Button)findViewById(R.id.sub);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String u1=uname.getText().toString();
				String u2=uphone.getText().toString();
				String u3=umail.getText().toString();
				String u4=upass.getText().toString();
				String u5=ucpass.getText().toString();
				
				 if (u1.isEmpty() && u2.isEmpty() && u3.isEmpty() && u4.isEmpty() && u5.isEmpty()) {
						Toast.makeText(Register.this,"Enter all the fields", Toast.LENGTH_SHORT).show();
						
					}
				 else if (u1.isEmpty()) {
						uname.setError("check username");
					}
					else if (u2.length()<10) {
						uphone.setError("enter valid 10 digit number");
					}
					else if (u3.isEmpty()) {
						umail.setError("check mailId");
					}
					else if (u4.isEmpty()) {
						upass.setError("Check password");
						
					}
					else if (u5.isEmpty()) {
						ucpass.setError("Check Confirm password");
					}
				 else if (u4.equals(u5)) {
					SharedPreferences newpreferences=getSharedPreferences("prefer", MODE_PRIVATE);
					SharedPreferences.Editor editor=newpreferences.edit();
					editor.putString("valid1", u1);
					editor.putString("valid2", u5);
					editor.apply();
					Intent intent=new Intent(Register.this,Welcome.class);
					startActivity(intent);
				}
			
				
				else {
					Toast.makeText(getApplicationContext(), "Invalid entry", Toast.LENGTH_SHORT).show();
				}
				
				
		
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
