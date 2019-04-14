package com.example.android.android_baking_app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_baking_app.databinding.FragmentMasterListStepsBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.android_baking_app.Constant.EXTRA_RECIPE;

public class MasterListStepsFragment extends Fragment {
    private Recipe mRecipe;

    private StepsAdapter mStepsAdapter;

    private FragmentMasterListStepsBinding mStepsBinding;

    public MasterListStepsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mStepsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_master_list_steps, container, false);

        View rootView = mStepsBinding.getRoot();

        mRecipe = getRecipeData();
        List<Step> steps = new ArrayList<>();

        mStepsAdapter = new StepsAdapter(steps);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mStepsBinding.rvSteps.setLayoutManager(layoutManager);
        mStepsBinding.rvSteps.setHasFixedSize(true);

        mStepsBinding.rvSteps.setAdapter(mStepsAdapter);

        mStepsAdapter.addAll(mRecipe.getmSteps());

        setNumSteps();

        return rootView;
    }

    private Recipe getRecipeData() {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (intent.hasExtra(EXTRA_RECIPE)) {
                Bundle b = intent.getBundleExtra(EXTRA_RECIPE);
                mRecipe = b.getParcelable(EXTRA_RECIPE);
            }
        }
        return mRecipe;
    }

    private void setNumSteps() {
        // Exclude zero step
        int numSteps = mRecipe.getmSteps().size() - 1;
        mStepsBinding.numSteps.setText(String.valueOf(numSteps));
    }
}
