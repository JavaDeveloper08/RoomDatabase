package com.example.myapplication.ui.addactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.MyViewModel;
import com.example.myapplication.R;

public class AddActivity extends AppCompatActivity {

    private MyViewModel myViewModel;

    private Spinner spinnerActivity, spinnerTab;
    private EditText editTextFirstName, editTextLastName, editTextAge;
    private Button buttonSubmit;

    private String strActivity, strTab;

    private String arrActivity[] = {"Select", "Home", "Dashboard", "Notification"};
    private String arrTab[] = {"Select", "TAB 1", "TAB 2", "TAB 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        spinnerActivity = findViewById(R.id.spinnerActivity);
        spinnerTab = findViewById(R.id.spinnerTab);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapterActivity = new ArrayAdapter(AddActivity.this, android.R.layout.simple_spinner_item, arrActivity);
        adapterActivity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter(adapterActivity);

        spinnerActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    strActivity = "";
                } else {
                    strActivity = arrActivity[position];
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                strActivity = "";
            }
        });


        ArrayAdapter<String> adapterTab = new ArrayAdapter(AddActivity.this, android.R.layout.simple_spinner_item, arrTab);
        adapterTab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTab.setAdapter(adapterTab);

        spinnerTab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    strTab = "";
                } else {
                    strTab = arrTab[position];
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                strTab = "";
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSubmit();
            }
        });

    }

    public void setButtonSubmit() {
        String firstName, lastName, age;

        firstName = editTextFirstName.getText().toString();
        lastName = editTextLastName.getText().toString();
        age = editTextAge.getText().toString();

        if (TextUtils.isEmpty(strActivity)) {
            Toast.makeText(this, "Please Select Acticity!!", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(strTab)) {
            Toast.makeText(this, "Please Select Tab!!", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(firstName)) {
            editTextFirstName.setError("Required Field");
        } else if (TextUtils.isEmpty(lastName)) {
            editTextLastName.setError("Required Field");
        } else if (TextUtils.isEmpty(age)) {
            editTextAge.setError("Required Field");
        } else {
            Intent intent = new Intent();
            intent.putExtra("activity", strActivity);
            intent.putExtra("tab", strTab);
            intent.putExtra("firstName", firstName);
            intent.putExtra("lastName", lastName);
            intent.putExtra("age", age);
            setResult(RESULT_OK, intent);
            finish();
        }

    }
}
