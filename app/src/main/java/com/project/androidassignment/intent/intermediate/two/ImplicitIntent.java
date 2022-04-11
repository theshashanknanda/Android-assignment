package com.project.androidassignment.intent.intermediate.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityImplicitIntentBinding;

public class ImplicitIntent extends AppCompatActivity {

    private ActivityImplicitIntentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImplicitIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.call.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"+91 8511671310"));
            startActivity(intent);
        });

        binding.email.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));

            Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"nandashashank101@gmail.com"});
            intent1.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent1.putExtra(Intent.EXTRA_TEXT, "Text");

            intent1.setSelector(intent);

            startActivity(intent1);
        });

        binding.sms.setOnClickListener(v -> {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:"+"+91 9879660807"));
            sendIntent.putExtra("sms_body", "Body");
            startActivity(sendIntent);
        });

        binding.website.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/questions/3004515/sending-an-intent-to-browser-to-open-specific-url"));
            startActivity(intent);
        });
    }
}