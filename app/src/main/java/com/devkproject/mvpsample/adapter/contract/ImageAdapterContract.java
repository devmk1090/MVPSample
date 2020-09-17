package com.devkproject.mvpsample.adapter.contract;

import com.devkproject.mvpsample.data.ImageItem;
import com.devkproject.mvpsample.listener.OnItemClickListener;

import java.util.ArrayList;

public interface ImageAdapterContract {

    interface View {
        void setOnClickListener(OnItemClickListener clickListener);
        void notifyAdapter();
    }

    interface Model {
        void addItems(ArrayList<ImageItem> imageItems);
        void clearItem();
        ImageItem getItem(int position);
    }
}
