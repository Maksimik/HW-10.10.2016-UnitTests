package com.example.a1.unittests.ui;

/**
 * Created by 1 on 11.10.2016.
 */

public interface Contract {
    interface View {
        void showData(String data);

        void showError(String message);

        void showProgress(boolean isInProgress);
    }

    interface Presenter {
        void onReady();
    }
}
