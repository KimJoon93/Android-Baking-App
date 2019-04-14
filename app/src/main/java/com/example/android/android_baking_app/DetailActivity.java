package com.example.android.android_baking_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.android.android_baking_app.Constant.EXTRA_RECIPE;
import static com.example.android.android_baking_app.Constant.EXTRA_STEP_INDEX;

public class DetailActivity extends AppCompatActivity implements MasterListStepsFragment.OnStepClickListener{

    private Recipe mRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mRecipe = getRecipeData();
        setTitle(mRecipe.getName());

    }

    private Recipe getRecipeData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(EXTRA_RECIPE)) {
                Bundle b = intent.getBundleExtra(EXTRA_RECIPE);
                mRecipe = b.getParcelable(EXTRA_RECIPE);
            }
        }
        return mRecipe;
    }

    @Override
    public void onStepSelected(int stepIndex) {
        Bundle b = new Bundle();
        b.putInt(EXTRA_STEP_INDEX, stepIndex);
        b.putParcelable(EXTRA_RECIPE, mRecipe);

        // Attach the Bundle to an intent
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra(EXTRA_STEP_INDEX, b);
        intent.putExtra(EXTRA_RECIPE, b);
        // Launch a new PlayerActivity
        startActivity(intent);
    }
}
