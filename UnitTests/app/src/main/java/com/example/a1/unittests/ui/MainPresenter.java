package com.example.a1.unittests.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.a1.unittests.ApiManager;
import com.example.myapplication.backend.trainingApi.TrainingApi;
import com.example.myapplication.backend.trainingApi.model.MyBean;

import java.io.IOException;
import static android.content.ContentValues.TAG;

/**
 * Created by 1 on 11.10.2016.
 */

public class MainPresenter implements Contract.Presenter {
    private Contract.View view;
    private Handler handler;

    public MainPresenter(@NonNull Contract.View view) {
        this.view = view;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onReady() {
        view.showProgress(true);
        loadData();
    }

    private void loadData() {

        new Thread() {
            @Override
            public void run() {

                try {
                    TrainingApi.GetStats call = ApiManager.get().trainingsApi().getStats();
                    MyBean bean = call.execute();
                    String response = bean.getData();
                    notifyResponse(response);
                } catch (IOException e) {
                    Log.e(TAG, "run: ", e);
                    notifyError(e);
                }
            }
        }.start();
    }

    private void notifyResponse(final String response) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showData(response);
            }
        });
    }

    private void notifyError(final Throwable e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showError(e.getMessage());
            }
        });
    }
}