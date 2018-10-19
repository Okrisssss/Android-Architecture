package com.example.mvvm_joke_random.databinding;



public class AppDataBindingComponent implements android.databinding.DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();

    }
}
