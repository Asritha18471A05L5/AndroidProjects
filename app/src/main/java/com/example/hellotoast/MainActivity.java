package com.example.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView data;
Button c_button;
Button d_button;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.tv);
        c_button = findViewById(R.id.countBtn);
        d_button = findViewById(R.id.decBtn);
        if (savedInstanceState != null && savedInstanceState.containsKey("Asritha")) {
            count = savedInstanceState.getInt("Asritha");
            data.setText(String.valueOf(count));
        }
        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                data.setText(String.valueOf(count));
            }
        });
        d_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    count--;
                    data.setText(String.valueOf(count));
                }
            }
        });
    }

        public void showToastMessage (View view){
            Toast.makeText(this, "Now the count is : " + String.valueOf(count), Toast.LENGTH_SHORT).show();

        }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Asritha",count);
    }
}