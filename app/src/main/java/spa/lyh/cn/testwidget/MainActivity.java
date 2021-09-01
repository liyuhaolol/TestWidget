package spa.lyh.cn.testwidget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import spa.lyh.cn.lib_image.app.ImageLoadUtil;
import spa.lyh.cn.lib_utils.PixelUtils;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);
        /*RequestOptions options = new RequestOptions();
        options = options.apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(PixelUtils.dip2px(this,10),0, RoundedCornersTransformation.CornerType.ALL)));*/
        RoundedCorners corners = new RoundedCorners(PixelUtils.dip2px(this,10));
        RequestOptions options = new RequestOptions().transform(corners);
        ImageLoadUtil.displayImage(this,R.drawable.doge,iv,options);

        Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        sendBroadcast(intent);
    }

    public void onClick(View v){
        /*Intent intent = new Intent(this,TestWidgetProvider.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);*/
        Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        sendBroadcast(intent);

    }
}