package com.devkproject.mvpsample.view.main.presenter;

import android.content.Context;

import com.devkproject.mvpsample.adapter.contract.ImageAdapterContract;
import com.devkproject.mvpsample.data.source.image.SampleImageRepository;

public interface MainContract {

    interface View {

        void showToast(String title);
    }

    interface Presenter {

        void attachView(View view);

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);

        void setImageAdapterView(ImageAdapterContract.View adapterView);

        void detachView();

        void setSampleImageData(SampleImageRepository sampleImageData);

        void loadItems(Context context, boolean isClear);
    }
}