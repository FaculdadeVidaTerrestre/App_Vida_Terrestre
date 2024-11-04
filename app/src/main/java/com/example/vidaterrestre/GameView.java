/*package com.example.vidaterrestre;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import java.util.Random;

import androidx.annotation.NonNull;

public class GameView extends View {

    int dWidth, dHeight;
    Bitmap fruit, basket, tree;
    Handler handler;
    Runnable runnable;
    long UPDATE_MILLIS = 30;
    int treeX, treeY;
    int fruitX, fruitY;
    Random random;
    boolean fruitAnimation = false;
    int points = 0;
    float TEXT_SIZE = 120;
    Paint textPaint;
    Paint healthPaint;
    int life = 3;
    Context context;
    int treeSpeed;
    int basketX, basketY;
    MediaPlayer mppointup, mpmusic, mpgameover;



    public GameView(Context context) {
        super(context);
        this.context = context;
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        basket = BitmapFactory.decodeResource(getResources(),R.drawable.i_cesta);
        tree = BitmapFactory.decodeResource(getResources(),R.drawable.i_arbusto);
        fruit = BitmapFactory.decodeResource(getResources(),R.drawable.i_maca);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        random = new Random();

        treeX = dWidth + random.nextInt(300);
        treeY = random.nextInt(600);
        fruitX = treeX;
        fruitY = treeY + tree.getHeight() - 30;
        textPaint = new Paint();
        textPaint.setColor(Color.rgb(255,0,0));
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        healthPaint = new Paint();
        healthPaint.setColor(Color.GREEN);
        treeSpeed = 21 + random.nextInt(30);
        basketX = dWidth/2 - basket.getWidth()/2;
        basketY = dHeight - basket.getHeight();
        mppointup = MediaPlayer.create(context, R.raw.pointup);
        mpgameover = MediaPlayer.create(context, R.raw.gameover);
        mpmusic = MediaPlayer.create(context, R.raw.music);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        if(fruitAnimation == false){
            treeX -= treeSpeed;
            fruitX -= treeSpeed;
        }
        if (treeX <= -tree.getWidth()){
            if (mppointup !=null){
                mppointup.start();
            }
            treeX = dWidth + random.nextInt(300);
            fruitX = treeX;
            treeY = random.nextInt(600);
            fruitY = treeY + tree.getHeight() - 30;
            treeSpeed = 21 + random.nextInt(30);
            basketX = tree.getWidth() + random.nextInt(dWidth - 2*tree.getWidth());
            life--;
            if (life == 0){
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("points",points);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        if (fruitAnimation){
            fruitY += 40;
            }
        if (fruitAnimation
                && (fruitX + fruit.getWidth() >= basketX)
                && (fruitX <= basketX + basket.getWidth())
                && (fruitY + fruit.getHeight() >= (dHeight - basket.getHeight()))
                && fruitY <= dHeight){
    if (mppointup != null){
        mppointup.start();
    }
    treeX = dWidth + random.nextInt(300);
    fruitX = treeX;
    treeY = random.nextInt(600);
    fruitY = treeY + tree.getHeight() - 30;
    treeSpeed = 21 + random.nextInt(30);
    points++;
    basketX = tree.getWidth() + random.nextInt(dWidth - 2*tree.getWidth());
    fruitAnimation = false;
            }
        if (fruitAnimation && (fruitY + fruit.getHeight()) >= dHeight ){
            if (mpgameover!= null){
                mpgameover.start();
            }
            life--;
            if (life == 0){
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("points",points);
                context.startActivity(intent);
                ((Activity) context).finish();
            }
            treeX = dWidth + random.nextInt(300);
            fruitX = treeX;
            treeY = random.nextInt(600);
            fruitY = treeY + tree.getHeight() - 30;
            basketX = tree.getWidth() + random.nextInt(dWidth - 2*tree.getWidth());
            fruitAnimation = false;
        }
        canvas.drawBitmap(basket, basketX, basketY, null);
        canvas.drawBitmap(tree, treeX, treeY, null);
        canvas.drawBitmap(fruit, fruitX, fruitY, null);
        canvas.drawText("" + points, 20, TEXT_SIZE, textPaint);
        if (life == 2)
            healthPaint.setColor(Color.YELLOW);
        else if (life == 1)
            healthPaint.setColor(Color.RED);
        canvas.drawRect(dWidth-200, 30, dHeight-200+60*life, 80, healthPaint);
        if (life != 0)
            handler.postDelayed(runnable, UPDATE_MILLIS);
        }

        }
    }

@Override
public boolean onTouchEvent(MotionEvent event) {
    float touchX = event.getX();
    float touchY = event.getY();

    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // Check if the touch is within the bounds of the tree and fruitAnimation is false
        if (!fruitAnimation &&
                (touchX >= treeX && touchX <= (treeX + tree.getWidth()) &&
                        touchY >= treeY && touchY <= (treeY + tree.getHeight()))) {
            fruitAnimation = true; // Start the fruit animation
            return true; // Indicate that the event was handled
        }
    }
    return false; // Return false if the event is not handled
}
 */

package com.example.vidaterrestre;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import java.util.Random;

import androidx.annotation.NonNull;

public class GameView extends View {

    int dWidth, dHeight;
    Bitmap fruit, basket, tree;
    Handler handler;
    Runnable runnable;
    long UPDATE_MILLIS = 30;
    int treeX, treeY;
    int fruitX, fruitY;
    Random random;
    boolean fruitAnimation = false;
    int points = 0;
    float TEXT_SIZE = 120;
    Paint textPaint;
    Paint healthPaint;
    int life = 3;
    Context context;
    int treeSpeed;
    int basketX, basketY;
    MediaPlayer mppointup, mpmusic, mpgameover;

    public GameView(Context context) {
        super(context);
        this.context = context;
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;

        // Load bitmaps
        basket = BitmapFactory.decodeResource(getResources(), R.drawable.i_cesta);
        tree = BitmapFactory.decodeResource(getResources(), R.drawable.i_arbusto);
        fruit = BitmapFactory.decodeResource(getResources(), R.drawable.i_maca);

        // Initialize handler and runnable
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        // Initialize random
        random = new Random();

        // Initialize game state
        resetGame();

        // Initialize Paint objects
        textPaint = new Paint();
        textPaint.setColor(Color.rgb(255, 0, 0));
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);

        healthPaint = new Paint();
        healthPaint.setColor(Color.GREEN);

        // Load media players
        mppointup = MediaPlayer.create(context, R.raw.pointup);
        mpgameover = MediaPlayer.create(context, R.raw.gameover);
        mpmusic = MediaPlayer.create(context, R.raw.music);
    }

    private void resetGame() {
        treeX = dWidth + random.nextInt(300);
        treeY = random.nextInt(600);
        fruitX = treeX;
        fruitY = treeY + tree.getHeight() - 30;
        treeSpeed = 21 + random.nextInt(30);
        basketX = dWidth / 2 - basket.getWidth() / 2;
        basketY = dHeight - basket.getHeight();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(Color.GREEN);

            // Load the bitmap from resources
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.i_background2);

            // Get the dimensions of the view
            int width = getWidth();
            int height = getHeight();

            // Create a scaled bitmap that fits the view
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);

            // Draw the scaled bitmap on the canvas
            canvas.drawBitmap(scaledBitmap, 0, 0, null);



        if (!fruitAnimation) {
            treeX -= treeSpeed;
            fruitX -= treeSpeed;
        }

        // Check if tree has moved off screen
        if (treeX <= -tree.getWidth()) {
            if (mppointup != null) {
                mppointup.start();
            }
            resetGame();
            life--;
            if (life == 0) {
                endGame();
            }
        }

        // Handle fruit falling animation
        if (fruitAnimation) {
            fruitY += 40;
            if (fruitY + fruit.getHeight() >= dHeight) {
                if (mpgameover != null) {
                    mpgameover.start();
                }
                life--;
                if (life == 0) {
                    endGame();
                }
                resetGame();
                fruitAnimation = false;
            }
        }

        // Check for collision with basket
        if (fruitAnimation &&
                (fruitX + fruit.getWidth() >= basketX) &&
                (fruitX <= basketX + basket.getWidth()) &&
                (fruitY + fruit.getHeight() >= (dHeight - basket.getHeight())) &&
                fruitY <= dHeight) {
            if (mppointup != null) {
                mppointup.start();
            }
            points++;
            resetGame();
            fruitAnimation = false;
        }

                // Draw game elements
                canvas.drawBitmap(basket, basketX, basketY, null);
        canvas.drawBitmap(tree, treeX, treeY, null);
        canvas.drawBitmap(fruit, fruitX, fruitY, null);
        canvas.drawText("" + points, 20, TEXT_SIZE, textPaint);

        // Update health bar color based on remaining lives
        if (life == 2) {
            healthPaint.setColor(Color.YELLOW);
        } else if (life == 1) {
            healthPaint.setColor(Color.RED);
        } else {
            healthPaint.setColor(Color.GREEN); // Reset to green if life > 2
        }

        // Draw health bar
        canvas.drawRect(dWidth - 200, 30, dWidth - 200 + 60 * life, 80, healthPaint);

        // Continue the game loop if there are lives left
        if (life > 0) {
            handler.postDelayed(runnable, UPDATE_MILLIS);
        }
    }

    private void endGame() {
        Intent intent = new Intent(context, GameOver.class);
        intent.putExtra("points", points);
        context.startActivity(intent);
        ((Activity) context).finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Check if the touch is within the bounds of the tree and fruitAnimation is false
            if (!fruitAnimation &&
                    (touchX >= treeX && touchX <= (treeX + tree.getWidth()) &&
                            touchY >= treeY && touchY <= (treeY + tree.getHeight()))) {
                fruitAnimation = true; // Start the fruit animation
                return true; // Indicate that the event was handled
            }
        }
        return false; // Return false if the event is not handled
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // Release MediaPlayer resources
        if (mppointup != null) {
            mppointup.release();
            mppointup = null;
        }
        if (mpgameover != null) {
            mpgameover.release();
            mpgameover = null;
        }
        if (mpmusic != null) {
            mpmusic.release();
            mpmusic = null;
        }
    }
}


