package com.devkproject.mvpsample.data.source.image;

import android.content.Context;

import com.devkproject.mvpsample.data.ImageItem;

import java.util.ArrayList;

public class SampleImageLocalDataSource implements SampleImageSource {

    @Override
    public void getImages(Context context, int size, LoadImageCallback loadImageCallback) {
        ArrayList<ImageItem> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int random = (int) (Math.random() * 15);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        if (loadImageCallback != null) {
            loadImageCallback.onImageLoaded(items);
        }
    }
}