package com.gdg.bhopal.gdgfeedbackapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button SubmitBtn;
    EditText nameEdt;
    RadioButton profRB;
    EditText suggestionET;
    SeekBar ageSB;
    CheckBox agreeCB;
    Spinner qualificationSpn;
    RadioButton StudentRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        nameEdt=(EditText)findViewById(R.id.nameEdt);
        setSupportActionBar(toolbar);

        SubmitBtn= (Button)findViewById(R.id.submitBtn);
        profRB=(RadioButton)findViewById(R.id.ProfRB);
        suggestionET=(EditText)findViewById(R.id.suggestionET).getText().toString();
        ageSB=(SeekBar)findViewById(R.id.ageSB);
        agreeCB=(CheckBox)findViewById(R.id.consentCB);



        SubmitBtn.setOnClickListener(new View.OnClickListener() {

            String name=nameEdt.getText().toString();
            String suggestion= suggestionET.getText().toString();
            String qualification=qualificationSpn.getSelectedItem().toString();
            String occupation=null;
            if(StudentRB.isChecked()){
                occupation="Student";
            }
            if(profRB.isChecked()){
                occupation="Professional";
            }
            int age=ageSB.getProgress();
            boolean isAgree=agreeCB.isChecked();
//            int rating= rb.getNumStars();
            int rating= rb.getProgress();


            GDGFeedback gf= new GDGFeedback(name,occupation,rating,qualification,suggestion,age,isAgree);

            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,ThankYouActivity.class);
                i.putExtra("name",nameEdt.getText().toString());
                startActivity(i);
            }
        });

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
}
