package com.zireck.projectk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zireck.projectk.R;
import com.zireck.projectk.adapter.FoodRepositoryRecyclerAdapter;
import com.zireck.projectk.model.Food;
import com.zireck.projectk.presenter.FoodRepositoryPresenter;
import com.zireck.projectk.presenter.FoodRepositoryPresenterImpl;
import com.zireck.projectk.view.FoodRepositoryView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Zireck on 16/07/2015.
 */
public abstract class FoodRepositoryBaseFragment extends BaseFragment implements FoodRepositoryView {

    @Bind(R.id.food_list)
    RecyclerView mRecyclerView;
    protected FoodRepositoryRecyclerAdapter mAdapter;
    protected FoodRepositoryPresenter mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadPresenter();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    public abstract void loadPresenter();

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_food_repository;
    }

    @Override
    public void setFoodItems(List<Food> foodItems) {
        mAdapter = new FoodRepositoryRecyclerAdapter(foodItems, R.layout.food_repository_recyclerview_item);
        mRecyclerView.setAdapter(mAdapter);
    }
}