package com.edu.todo.utils.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract int getLayoutResourceId();

    protected abstract void initView(View rootView);

    protected abstract void initData();

//    protected void replaceFragment(Fragment fragment, Boolean isAddToBackStack) {
//        if (isAddToBackStack) {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.fragmentContainerView, fragment)
//                    .commit();
//        } else {
//            requireActivity().getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragmentContainerView, fragment)
//                    .commit();
//        }
//    }
}