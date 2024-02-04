package com.yixin.studykotlin;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    public void main() {

        final String imageUrl = "";
        final ImageView imageView = new ImageView(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    public Bitmap downloadImage(String imageUrl) {
        return null;
    }
}
