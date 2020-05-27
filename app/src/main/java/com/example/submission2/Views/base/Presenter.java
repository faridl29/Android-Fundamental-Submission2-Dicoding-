package com.example.submission2.Views.base;

public interface Presenter<T extends View> {
    void onAttach(T view);

    void onDetach();
}
