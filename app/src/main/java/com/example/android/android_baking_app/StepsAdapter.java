package com.example.android.android_baking_app;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.android_baking_app.databinding.StepsListItemBinding;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsViewHolder> {

    private List<Step> mSteps;

    private final StepsAdapterOnClickHandler mOnClickHandler;

    public interface StepsAdapterOnClickHandler {
        void onItemClick(int stepIndex);
    }

    public StepsAdapter(List<Step> steps, StepsAdapterOnClickHandler onClickHandler) {
        mSteps = steps;
        mOnClickHandler = onClickHandler;
    }


    @NonNull
    @Override
    public StepsAdapter.StepsViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        StepsListItemBinding stepsItemBinding = DataBindingUtil
                .inflate(layoutInflater, R.layout.steps_list_item, parent, false);
        return new StepsViewHolder(stepsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.StepsViewHolder holder, int position) {
        Step step = mSteps.get(position);
        holder.bind(step);
    }

    @Override
    public int getItemCount() {
        if (null == mSteps) return 0;
        return mSteps.size();
    }

    public void addAll(List<Step> steps) {
        mSteps.clear();
        mSteps.addAll(steps);
        notifyDataSetChanged();
    }

    public class StepsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private StepsListItemBinding mStepsItemBinding;

        public StepsViewHolder(StepsListItemBinding stepsItemBinding) {
            super(stepsItemBinding.getRoot());
            mStepsItemBinding = stepsItemBinding;
            itemView.setOnClickListener(this);
        }

        void bind(Step step) {
            String stepId = itemView.getContext().getString(R.string.step) + step.getStepId();
            mStepsItemBinding.tvStepId.setText(stepId);
            mStepsItemBinding.tvStepShortDescription.setText(step.getShortDescription());
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            mOnClickHandler.onItemClick(adapterPosition);
        }
    }
}
