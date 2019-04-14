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

import com.example.android.android_baking_app.databinding.FragmentMasterListIngredientsBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.android_baking_app.Constant.EXTRA_RECIPE;

public class MasterListIngredientsFragment extends Fragment {

    private Recipe mRecipe;

    private IngredientsAdapter mIngredientsAdapter;

    private FragmentMasterListIngredientsBinding mMasterListBinding;

    public MasterListIngredientsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMasterListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_master_list_ingredients, container, false);

        View rootView = mMasterListBinding.getRoot();

        mRecipe = getRecipeData();
        List<Ingredient> ingredients = new ArrayList<>();

        mIngredientsAdapter = new IngredientsAdapter(ingredients);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        mMasterListBinding.rvIngredients.setLayoutManager(layoutManager);
        mMasterListBinding.rvIngredients.setHasFixedSize(true);

        mMasterListBinding.rvIngredients.setAdapter(mIngredientsAdapter);

        mIngredientsAdapter.addAll(mRecipe.getIngredients());

        setNumIngredients();

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

    private void setNumIngredients() {
        int numIngredients = mRecipe.getIngredients().size();
        mMasterListBinding.numIngredients.setText(String.valueOf(numIngredients));
    }
}
