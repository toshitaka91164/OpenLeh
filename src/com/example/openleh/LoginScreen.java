package com.example.openleh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends Activity {
	private EditText  username=null;
	private EditText  password=null;
	private TextView attempts;
	private Button login;
	int counter = 3;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		username = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		login = (Button)findViewById(R.id.button1);
		attempts = (TextView)findViewById(R.id.textView5);
		attempts.setText(Integer.toString(counter));
	}
	

	public void login(View view){
		if(username.getText().toString().equals("admin") && 
				password.getText().toString().equals("admin")){
			Toast.makeText(getApplicationContext(), "Redirecting...", 
					Toast.LENGTH_SHORT).show();
			finish();
			Intent mainIntent = new Intent().setClass(LoginScreen.this, MainActivity.class);
			startActivity(mainIntent);
			
		}	
		else{
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
			attempts.setBackgroundColor(Color.RED);	
			counter--;
			attempts.setText(Integer.toString(counter));
			if(counter==0){
				login.setEnabled(false);
			}

		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}