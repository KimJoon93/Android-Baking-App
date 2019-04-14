package com.example.android.android_baking_app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_baking_app.databinding.ActivityPlayerBinding;

import static com.example.android.android_baking_app.Constant.EXTRA_RECIPE;
import static com.example.android.android_baking_app.Constant.EXTRA_STEP_INDEX;

public class PlayerActivity extends AppCompatActivity {

    private Step mStep;
    private Recipe mRecipe;
    private ActivityPlayerBinding mPlayerBinding;
    private int mStepIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayerBinding = DataBindingUtil.setContentView(this, R.layout.activity_player);

        // Only create a new fragment when there is no previously saved state
        if (savedInstanceState == null) {

            Intent intent = getIntent();
            if (intent != null) {
                if (intent.hasExtra(EXTRA_STEP_INDEX)) {
                    // Get the correct step index from the intent
                    Bundle b = intent.getBundleExtra(EXTRA_STEP_INDEX);
                    mStepIndex = b.getInt(EXTRA_STEP_INDEX);
                }
                if (intent.hasExtra(EXTRA_RECIPE)) {
                    // Get the recipe from the intent
                    Bundle b = intent.getBundleExtra(EXTRA_RECIPE);
                    mRecipe = b.getParcelable(EXTRA_RECIPE);
                }
            }

            // Create a new StepDetailFragment
            StepDetailFragment stepDetailFragment = new StepDetailFragment();
            // Set the step
            mStep = mRecipe.getSteps().get(mStepIndex);
            stepDetailFragment.setStep(mStep);
            stepDetailFragment.setStepIndex(mStepIndex);

            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.step_detail_container, stepDetailFragment)
                    .commit();
        }
    }


}
