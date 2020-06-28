package com.devkproject.mvpsample.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

// AsyncTask 동작 순서
// 1.execute() 를 통해 AsyncTask 실행 2.AsyncTask 로 백그라운드 작업 실행전에 onPreExecuted() 실행
// 3.doInBackground() 메소드 작업이 끝나면 onPostExecute() 로 결과 파라미터를 리턴하고 리턴값을 통해
// 스레드 작업이 끝났을때의 동작 구현.

// AsyncTask 라는 별도의 쓰레드에서 작업 중이므로 사용자는 다른 창으로 이동할 수 있다.
// ImageView 에 WeakReference 를 가지고 있게 하여 사용자가 다른 창으로 이동하면 작업이 끝나지 않았더라도
// ImageView 가 GC 에 의해 제거됨.
public class ImageAsync extends AsyncTask<Integer, Void, Bitmap> {

    private Context context;
    private final WeakReference<ImageView> imageViewWeakReference;
// WeakReference 는 SoftReference 와 유사하지만 GC가 발생되기 전까지는 참조를 유지하고
// GC 가 발생하면 무조건 회수된다는 점에서 차이가 있습니다.
// 이는 유용하게 쓰일 수 있는데, 짧은 시간, 자주 쓰일 수 있는 객체를 이용할 때 유용하게 사용될 수 있습니다.


    public ImageAsync(Context context, ImageView imageView) {
        this.context = context;
        imageViewWeakReference = new WeakReference<>(imageView);
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return BitmapFactory.decodeResource(context.getResources(), params[0], options);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageViewWeakReference.get().setImageResource(0);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageViewWeakReference.get().setImageBitmap(bitmap);
    }
}