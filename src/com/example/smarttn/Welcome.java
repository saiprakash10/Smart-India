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
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {
	EditText ed1,ed2;
Button login;
TextView reg,forgot;
SharedPreferences newPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		ed1=(EditText)findViewById(R.id.mobilenumber);
		ed2=(EditText)findViewById(R.id.password);
		reg=(TextView)findViewById(R.id.signin);
		login=(Button)findViewById(R.id.login);
		forgot=(TextView)findViewById(R.id.forgot);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent intent=new Intent(Welcome.this,Register.class);
			startActivity(intent);
				
			}
		});
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				newPreferences =getSharedPreferences("prefer", MODE_PRIVATE);
				String us1=newPreferences.getString("valid1", "");
				String us2=newPreferences.getString("valid2", "");
				if (ed1.getText().toString().isEmpty() && ed2.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
				}
				else if (ed1.getText().toString().isEmpty()) {
					ed1.setError("check username");
					}
				else if (ed2.getText().toString().isEmpty()) {
					ed2.setError("check password");
					}
				else if ((ed1.getText().toString().equals(us1)) && (ed2.getText().toString().equals(us2))) {
					Intent intent=new Intent(Welcome.this,TN_services.class);
					startActivity(intent);
				}
				
				else {
					Toast.makeText(getApplicationContext(), "invalid entry", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		forgot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Welcome.this,Forgot_password.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
