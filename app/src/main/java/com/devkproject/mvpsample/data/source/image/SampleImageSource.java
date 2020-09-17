package com.devkproject.mvpsample.data.source.image;

import android.content.Context;

import com.devkproject.mvpsample.data.ImageItem;

import java.util.ArrayList;

public interface SampleImageSource {

    interface LoadImageCallback {
        void onImageLoaded(ArrayList<ImageItem> list);
    }
    void getImages(Context context, int size, LoadImageCallback loadImageCallback);
}
