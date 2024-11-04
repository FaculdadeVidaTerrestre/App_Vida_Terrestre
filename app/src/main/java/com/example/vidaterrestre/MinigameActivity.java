/*package com.example.vidaterrestre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MinigameActivity extends Activity {
    public static class MinigameActivity extends Activity {
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.minigame_activity);
        }

        public void startGame (View view){
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
            finish();
        }
    }
} */

package com.example.vidaterrestre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MinigameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_activity);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}


