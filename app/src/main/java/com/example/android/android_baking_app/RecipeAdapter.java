package com.example.android.android_baking_app;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_baking_app.databinding.RecipeListItemBinding;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final RecipeAdapterOnClickHandler mOnClickHandler;

    public interface RecipeAdapterOnClickHandler {
        void  onItemClick(Recipe recipe);
    }

    private List<Recipe> mRecipeList;

    public RecipeAdapter(List<Recipe> recipeList, RecipeAdapterOnClickHandler onClickHandler) {
        mRecipeList = recipeList;
        mOnClickHandler = onClickHandler;
    }


    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecipeListItemBinding recipeItemBinding = DataBindingUtil
                .inflate(layoutInflater, R.layout.recipe_list_item, parent, false);
        return new RecipeViewHolder(recipeItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        if (null == mRecipeList) return 0;
        return mRecipeList.size();
    }

    public void addAll(List<Recipe> recipeList) {
        mRecipeList.clear();
        mRecipeList.addAll(recipeList);
        notifyDataSetChanged();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecipeListItemBinding mRecipeItemBinding;

        public RecipeViewHolder(RecipeListItemBinding recipeItemBinding) {
            super(recipeItemBinding.getRoot());
            mRecipeItemBinding = recipeItemBinding;

            itemView.setOnClickListener(this);
        }

        void bind(Recipe recipe) {
            mRecipeItemBinding.tvName.setText(recipe.getName());
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Recipe recipe = mRecipeList.get(adapterPosition);
            mOnClickHandler.onItemClick(recipe);
        }
    }

}
