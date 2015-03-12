package com.example.luisvalcourt.personal_agenda;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class Agenda_Activity extends Activity {




    private TextView message;
    private TextView subject;
    private File dir;
    Time today = new Time(Time.getCurrentTimezone());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_);

        subject = (TextView) findViewById(R.id.subject_text);
        message = (TextView) findViewById(R.id.message_text);


        today.setToNow();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agenda_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Clear(View view){
        message.setText("");
        subject.setText("");

    }

    public void Save(View view){
        String filename = "Nicolas_TestFile" + today.monthDay + "_" + today.format("%k:%M:%S");
        String test0 = subject.getText().toString();
        String test = message.getText().toString();



        //Creates user file
        BufferedWriter output;
        dir = getAlbumStorageDir(filename);
        File file = new File(dir, filename);
        FileWriter writer;
        try {
            writer = new FileWriter(file,true);
            output = new BufferedWriter(writer);
            output.append("");
            output.append(test.toString());
            output.append("");
            Toast.makeText(this,"File Saved.", Toast.LENGTH_LONG).show();
            output.close();
        } catch (IOException e) {
            Toast.makeText(this,"Error, File not saved", Toast.LENGTH_LONG).show();
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public File getAlbumStorageDir(String fN) {
        // Get the directory for the user's public download directory.
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);

//        if (!path.mkdirs()) {
//            Log.e("Error", "Directory not created");
//        }
        return path;
    }


}