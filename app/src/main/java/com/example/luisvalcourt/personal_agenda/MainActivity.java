package com.example.luisvalcourt.personal_agenda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {

    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.edit_Username);
        password = (TextView) findViewById(R.id.edit_Password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Log(View view){
        String user = "valcourt";
        String pass = "nico";
        Intent intent = new Intent(this, Agenda_Activity.class);
        if(username.getText().toString().equals(user) && password.getText().toString().equals(pass)){
            Toast.makeText(this,"Existing User, loading data......", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }

        else{
            Toast.makeText(this,"Wrong Username/Password. Please Try Again", Toast.LENGTH_LONG).show();
            username.setText("");
            password.setText("");
        }



    }
    public void Clear(View view) {

        username.setText("");
        password.setText("");
    }
}
