package com.corylab.task5;

import static androidx.core.content.ContextCompat.getSystemService;

import static com.corylab.task5.MainActivity.CHANNEL_ID;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.corylab.task5.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private static final int NOTIFICATION_ID = 1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    
    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        Button btn1 = binding.btn1;
        Button btn2 = binding.btn2;
        Button btnForNotification = binding.btnForNotification;

        btn1.setOnClickListener(v -> {
            Bundle arguments = new Bundle();
            String data = binding.editText1.getText().toString();
            arguments.putString("Data", data);
            Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_secondFragment,
                    arguments);
        });

        btn2.setOnClickListener(v -> {
            Bundle arguments = new Bundle();
            String data = binding.editText2.getText().toString();
            arguments.putString("Data", data);
            Navigation.findNavController(v).navigate(R.id.action_firstFragment_to_thirdFragment,
                    arguments);
        });

        btnForNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification("Example Name", "You added the ITEM to your favorites");
            }
        });
    }

    private void showNotification(String name, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentTitle(name)
                .setContentText(text)
                .setSmallIcon(R.mipmap.ic_launcher_round);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireActivity());
        if (ActivityCompat.checkSelfPermission(requireActivity(),  android.Manifest.permission.
                POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{ android.Manifest.permission.
                POST_NOTIFICATIONS }, 1);
    }
}