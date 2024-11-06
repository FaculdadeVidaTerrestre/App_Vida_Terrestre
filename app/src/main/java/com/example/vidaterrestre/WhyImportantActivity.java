package com.example.vidaterrestre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WhyImportantActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whyimportant_activity);

        Button btnMoreInfo = findViewById(R.id.btn_more_info);
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação para exibir mais informações ou abrir uma nova Activity
                Intent intent = new Intent(WhyImportantActivity.this, MoreInfoActivity.class);
                startActivity(intent);
            }
        });


    }

}
