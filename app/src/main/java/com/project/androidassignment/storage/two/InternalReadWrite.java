package com.project.androidassignment.storage.two;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.project.androidassignment.databinding.ActivityInternalReadWriteBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class InternalReadWrite extends AppCompatActivity {
    private ActivityInternalReadWriteBinding binding;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInternalReadWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Uri data = result.getData().getData();

                        try {
                            OutputStream os = getContentResolver().openOutputStream(data);
                            os.write(text.getBytes());
                            os.close();

                            binding.editText3.setText("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        binding.saveButton.setOnClickListener(v -> {
            text = binding.editText3.getText().toString();

            Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TITLE, "Your title");
            launcher.launch(intent);
        });

        ActivityResultLauncher<String> getLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                try {
                    InputStream in = getContentResolver().openInputStream(result);


                    BufferedReader r = new BufferedReader(new InputStreamReader(in));
                    StringBuilder total = new StringBuilder();
                    for (String line; (line = r.readLine()) != null;) {
                        total.append(line).append('\n');
                    }

                    String content = total.toString();
                    binding.tv.setText(content);

                }catch (Exception e) {

                }
            }
        });

        binding.readButton.setOnClickListener(v -> {
            getLauncher.launch("text/plain");
        });
    }
}