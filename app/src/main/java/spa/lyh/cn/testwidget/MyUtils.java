package spa.lyh.cn.testwidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import spa.lyh.cn.lib_utils.PixelUtils;

public class MyUtils {


    public static Bitmap getRoundedCornerBitmap(Context context,Bitmap sourceBitmap) {

        try {

            Bitmap targetBitmap = Bitmap.createBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight(), Bitmap.Config.ARGB_8888);

            // 得到画布
            Canvas canvas = new Canvas(targetBitmap);

            // 创建画笔
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            // 值越大角度越明显
            float roundPx = PixelUtils.dip2px(context,10);
            float roundPy = PixelUtils.dip2px(context,10);

            Rect rect = new Rect(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight());
            RectF rectF = new RectF(rect);

            // 绘制
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, roundPx, roundPy, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(sourceBitmap, rect, rect, paint);

            return targetBitmap;

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }

        return null;

    }
}
