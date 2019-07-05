package com.example.smarttn;


import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Details extends Activity {
	
EditText edit1,edit2,edit3,edit4,edit5;
Spinner gender;
Button insert;
String b;
String[] gen= {"select gender","Male","Female"};
SharedPreferences preferences;
ArrayAdapter<String> adapter;
SharedPreferences.Editor editor;
int  CAMERA_REQUEST=1888;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add__details);
		
		edit1=(EditText)findViewById(R.id.name);
		edit2=(EditText)findViewById(R.id.father);
	    edit3=(EditText)findViewById(R.id.Dob);
		edit4=(EditText)findViewById(R.id.address);
		edit5=(EditText)findViewById(R.id.mobileno);
		gender=(Spinner)findViewById(R.id.gen);
		insert=(Button)findViewById(R.id.procceed);
		Intent in=getIntent();
		Bundle bundle=in.getExtras();
		  b=bundle.getString("type");
		 preferences=getSharedPreferences("prefer", MODE_PRIVATE);
		  editor=preferences.edit();
		  
	edit3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			final Calendar calendar=Calendar.getInstance();
			int myear =calendar.get(Calendar.YEAR);
			int mmonth =calendar.get(Calendar.MONTH);
			int mday=calendar.get(Calendar.DAY_OF_MONTH);
			DatePickerDialog datePickerDialog=new DatePickerDialog(Add_Details.this,new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int month, int day) {
					// TODO Auto-generated method stub
					
					edit3.setText(day + "/"
                            + (month + 1) + "/" + year);
					
					
				}
			}, myear, mmonth, mday);
			datePickerDialog.show();
			
		}
	});
		adapter=new ArrayAdapter<String>(Add_Details.this, android.R.layout.simple_spinner_item,gen);
		gender.setBackgroundResource(R.drawable.shape);
		gender.setAdapter(adapter);
		
		
		
		
			
		insert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 if ((edit1.getText().toString().isEmpty()) || (edit2.getText().toString().isEmpty()) || (edit3.getText().toString().isEmpty()) || (edit4.getText().toString().isEmpty()) || (edit5.getText().toString().isEmpty())) {
						Toast.makeText(getApplicationContext(), "enter all the details", Toast.LENGTH_SHORT).show();
					}
				 
				 else {
					 Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  
		              startActivityForResult(cameraIntent, CAMERA_REQUEST);  
				}
				
	         }  
	        });  
	       }  
	  
	     protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	      if (requestCode == CAMERA_REQUEST) {  
	       Bitmap photo = (Bitmap) data.getExtras().get("data");
	       if (b.equals("Aadhaar Card")) {
	    	    
	    		      Intent intent=new Intent(Add_Details.this,Aadhar.class);
			    	  editor.putString("v1", edit1.getText().toString());
			    	  editor.putString("v2", edit2.getText().toString());
			    	  editor.putString("v4", edit4.getText().toString());
			    	  editor.putString("v3",edit3.getText().toString());
			    	  editor.putString("v5", gender.getSelectedItem().toString());
			    	  editor.putString("v6", edit5.getText().toString());
			    	  editor.apply();
				      intent.putExtra("bitmap", photo);
				      startActivity(intent);
			
		    	 
				
			}
		      else if (b.equals("Pan Card")) {
		    	  Bundle bun=new Bundle();
		    	  Intent intent=new Intent(Add_Details.this,Pancard.class);
		    	  editor.putString("v1", edit1.getText().toString());
		    	  editor.putString("v2", edit2.getText().toString());
		    	  editor.putString("v4", edit4.getText().toString());
		    	  editor.putString("v3",edit3.getText().toString());
		    	  editor.putString("v5", gender.getSelectedItem().toString());
		    	  editor.putString("v6", edit5.getText().toString());
		    	  editor.apply();
			      intent.putExtra("bitmap", photo);
			      startActivity(intent);
					
				}
		      else if (b.equals("VoterId Card")) {
		    	  Intent intent=new Intent(Add_Details.this,Voter_id.class);
		    	  editor.putString("v1", edit1.getText().toString());
		    	  editor.putString("v2", edit2.getText().toString());
		    	  editor.putString("v4", edit4.getText().toString());
		    	  editor.putString("v3",edit3.getText().toString());
		    	  editor.putString("v5", gender.getSelectedItem().toString());
		    	  editor.putString("v6", edit5.getText().toString());
		    	  editor.apply();
			      intent.putExtra("bitmap", photo);
			      startActivity(intent);
					
				}
		      else if (b.equals("Ration Card")) {
		    	  Intent intent=new Intent(Add_Details.this,Rationcard.class);
		    	  editor.putString("v1", edit1.getText().toString());
		    	  editor.putString("v2", edit2.getText().toString());
		    	  editor.putString("v4", edit4.getText().toString());
		    	  editor.putString("v3",edit3.getText().toString());
		    	  editor.putString("v5", gender.getSelectedItem().toString());
		    	  editor.putString("v6", edit5.getText().toString());
		    	  editor.apply();
			      intent.putExtra("bitmap", photo);
			      startActivity(intent);
					
				}
		      else {
				Toast.makeText(getApplicationContext(), "Invalid entry", Toast.LENGTH_LONG).show();
			}
	      }  
	     
		
	} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add__details, menu);
		return true;
	}
}
