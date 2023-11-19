package com.example.sibal.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sibal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 다음 라인을 주석 처리하거나 삭제하여 textHome을 사용하지 않음을 나타냅니다.
        // binding.textHome.setVisibility(View.GONE);

        // 예제: ViewModel에서 가져온 데이터를 사용하는 방법
        homeViewModel.getText().observe(getViewLifecycleOwner(), text -> {
            // 여기에서 가져온 데이터를 사용하는 코드를 추가하세요.
            // 예를 들어, 가져온 데이터를 로그에 출력하는 코드
            Log.d("HomeFragment", "Received text from ViewModel: " + text);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}