package com.example.android.android_baking_app;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.android_baking_app.databinding.IngredientsListItemBinding;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>{

    private List<Ingredient> mIngredients;

    public IngredientsAdapter(List<Ingredient> ingredients) {
        mIngredients = ingredients;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        IngredientsListItemBinding ingredientsItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.ingredients_list_item, parent, false);
        return new IngredientsViewHolder(ingredientsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        Ingredient ingredient = mIngredients.get(position);
        holder.bind(ingredient);
    }

    public void addAll(List<Ingredient> ingredients) {
        mIngredients.clear();
        mIngredients.addAll(ingredients);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (null == mIngredients) return 0;
        return mIngredients.size();
    }

    public class IngredientsViewHolder extends RecyclerView.ViewHolder {

        private IngredientsListItemBinding mIngredientsItemBinding;

        public IngredientsViewHolder(IngredientsListItemBinding ingredientsItemBinding) {
            super(ingredientsItemBinding.getRoot());
            mIngredientsItemBinding = ingredientsItemBinding;
        }

        void bind(Ingredient ingredient) {
            mIngredientsItemBinding.tvQuantity.setText(String.valueOf(ingredient.getmQuantity()));
            mIngredientsItemBinding.tvMeasure.setText(ingredient.getmMeasure());
            mIngredientsItemBinding.tvIngredient.setText(ingredient.getmIngredient());
        }
    }
}


