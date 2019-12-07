package com.example.a12th_assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {


    ImageView imgView;
    GestureDetectorCompat detector;
    private boolean backgroundColorState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = findViewById(R.id.imageView);
        backgroundColorState = false;

        // Setup the gesture detector
        detector = new GestureDetectorCompat(this, this);
        detector.setOnDoubleTapListener(this);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.detector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        backgroundColorState = false; // Reset the state
        long totalEventTime = e2.getEventTime() - e1.getEventTime();
        double intensityRed = (Math.abs(e1.getX() - e2.getX()) / totalEventTime) * 25.5;
        double intensityBlue = (Math.abs(e1.getY() - e2.getY()) / totalEventTime) * 25.5;
        // Cap the intensity to 255
        if (intensityRed > 255) {
            intensityRed = 255;
        }
        if (intensityBlue > 255) {
            intensityBlue = 255;
        }

        imgView.setBackgroundColor(Color.rgb((int) intensityRed, 0, (int) intensityBlue));
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        // Toggles background color black(false) / white(true)
        backgroundColorState = !backgroundColorState;
        if (backgroundColorState) {
            imgView.setBackgroundResource(R.color.black);

        } else {
            imgView.setBackgroundResource(R.color.white);
        }

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        return true;
    }
}
