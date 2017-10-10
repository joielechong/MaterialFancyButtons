package com.rilixtech.materialfancybutton.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.rilixtech.materialfancybutton.R;
import com.rilixtech.materialfancybutton.drawable.RippleDrawable;

public final class RippleManager implements View.OnClickListener {

  private View.OnClickListener mClickListener;
  private boolean mClickScheduled = false;

  public RippleManager() {
  }

  /**
   * Should be called in the construction method of view to create a RippleDrawable.
   */
  public void onCreate(View v, Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes, float[] cornerRadii) {
    if (v.isInEditMode()) return;

    TypedArray a =
        context.obtainStyledAttributes(attrs, R.styleable.RippleView, defStyleAttr, defStyleRes);
    int rippleStyle = a.getResourceId(R.styleable.RippleView_rd_style, 0);
    RippleDrawable drawable = null;

    //mCornerRadii = new float[] {
    //    mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight,
    //    mRadiusBottomRight, mRadiusBottomLeft, mRadiusBottomLeft
    //};

    if (rippleStyle != 0) {
      drawable =
          new RippleDrawable.Builder(context, rippleStyle).backgroundDrawable(getBackground(v))
              .topLeftCornerRadius((int) cornerRadii[0])
              .topRightCornerRadius((int) cornerRadii[2])
              .bottomRightCornerRadius((int) cornerRadii[4])
              .bottomLeftCornerRadius((int) cornerRadii[6])
              .build();
    } else {
      boolean rippleEnable = a.getBoolean(R.styleable.RippleView_rd_enable, false);
      if (rippleEnable) {
        drawable = new RippleDrawable.Builder(context, attrs, defStyleAttr,
            defStyleRes).backgroundDrawable(getBackground(v))
            .topLeftCornerRadius((int) cornerRadii[0])
            .topRightCornerRadius((int) cornerRadii[2])
            .bottomRightCornerRadius((int) cornerRadii[4])
            .bottomLeftCornerRadius((int) cornerRadii[6])
            .build();
      }
    }

    a.recycle();

    if (drawable != null) ViewUtil.setBackground(v, drawable);
  }

  private Drawable getBackground(View v) {
    Drawable background = v.getBackground();
    if (background == null) return null;

    if (background instanceof RippleDrawable) {
      return ((RippleDrawable) background).getBackgroundDrawable();
    }

    return background;
  }

  public void setOnClickListener(View.OnClickListener l) {
    mClickListener = l;
  }

  public boolean onTouchEvent(View v, MotionEvent event) {
    Drawable background = v.getBackground();
    return background != null
        && background instanceof RippleDrawable
        && ((RippleDrawable) background).onTouch(v, event);
  }

  @Override public void onClick(View v) {
    Drawable background = v.getBackground();
    long delay = 0;

    if (background != null) {
      if (background instanceof RippleDrawable) {
        delay = ((RippleDrawable) background).getClickDelayTime();
      }
    }

    if (delay > 0 && v.getHandler() != null && !mClickScheduled) {
      mClickScheduled = true;
      v.getHandler().postDelayed(new ClickRunnable(v), delay);
    } else {
      dispatchClickEvent(v);
    }
  }

  private void dispatchClickEvent(View v) {
    if (mClickListener != null) mClickListener.onClick(v);
  }

  /**
   * Cancel the ripple effect of this view and all of it's children.
   */
  public static void cancelRipple(View v) {
    Drawable background = v.getBackground();
    if (background instanceof RippleDrawable) ((RippleDrawable) background).cancel();

    if (v instanceof ViewGroup) {
      ViewGroup vg = (ViewGroup) v;
      for (int i = 0, count = vg.getChildCount(); i < count; i++)
        RippleManager.cancelRipple(vg.getChildAt(i));
    }
  }

  private class ClickRunnable implements Runnable {
    View mView;

    ClickRunnable(View v) {
      mView = v;
    }

    @Override public void run() {
      mClickScheduled = false;
      dispatchClickEvent(mView);
    }
  }
}
