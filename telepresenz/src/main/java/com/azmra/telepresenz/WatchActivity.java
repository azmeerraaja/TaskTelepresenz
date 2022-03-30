package com.azmra.telepresenz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.azmra.telepresenz.databinding.ActivityWatchBinding;

public class WatchActivity extends Activity {

    private ActivityWatchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}