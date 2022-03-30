package com.azmra.tasktelepresenz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import io.agora.rtc.Constants;

public class MainActivity extends AppCompatActivity {
    int channelProfile;
    public static final String channelMessage = "com.azmra.tasktelepresenz.CHANNEL";
    public static final String profileMessage = "com.azmra.tasktelepresenz.PROFILE";
    public static final String channelName = "LIVESTREAMFORTELEPRESENZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int MY_PERMISSIONS_REQUEST_CAMERA = 0;
        channelProfile = Constants.CLIENT_ROLE_BROADCASTER;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, MY_PERMISSIONS_REQUEST_CAMERA);
        }

    }

   public void gotoVideoActivity(int channelProfile,String channelName){
       Intent intent = new Intent(this, VideoActivity.class);
       intent.putExtra(channelMessage, channelName);
       intent.putExtra(profileMessage, channelProfile);
       startActivity(intent);
    }

    public void onStream(View view) {
        channelProfile = Constants.CLIENT_ROLE_BROADCASTER;
        gotoVideoActivity(channelProfile,channelName);
    }
    public void onJoin(View view) {
        channelProfile = Constants.CLIENT_ROLE_AUDIENCE;
        gotoVideoActivity(channelProfile,channelName);
    }
}