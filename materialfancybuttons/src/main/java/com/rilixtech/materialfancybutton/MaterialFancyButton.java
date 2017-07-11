package com.rilixtech.materialfancybutton;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import com.rilixtech.materialfancybutton.utils.FontUtil;
import java.util.ArrayList;
import java.util.List;

public class MaterialFancyButton extends LinearLayout {

  public static final String TAG = MaterialFancyButton.class.getSimpleName();

  // # Background Attributes
  private int mDefaultBackgroundColor = Color.BLACK;
  private int mFocusBackgroundColor = 0;
  private int mDisabledBackgroundColor = Color.parseColor("#f6f7f9");
  private int mDisabledTextColor = Color.parseColor("#bec2c9");
  private int mDisabledBorderColor = Color.parseColor("#dddfe2");

  // # Text Attributes
  private int mDefaultTextColor = Color.WHITE;
  private int mDefaultIconColor = Color.WHITE;
  private int mTextPosition = 1;
  private int mDefaultTextSize = FontUtil.spToPx(getContext(), 15);
  private int mDefaultTextGravity = 0x11; // Gravity.CENTER
  private String mText = null;

  // # Icon Attributes
  private Drawable mIconResource = null;
  private int mFontIconSize = FontUtil.spToPx(getContext(), 15);
  private String mFontIcon = null;
  private int mIconPosition = 1;
  private String mIcon = null;

  private int mIconPaddingLeft = 10;
  private int mIconPaddingRight = 10;
  private int mIconPaddingTop = 0;
  private int mIconPaddingBottom = 0;

  private int mBorderColor = Color.TRANSPARENT;
  private int mBorderWidth = 0;

  private int mRadius = 0;
  private int mRadiusTopLeft = 0;
  private int mRadiusTopRight = 0;
  private int mRadiusBottomLeft = 0;
  private int mRadiusBottomRight = 0;

  private boolean mEnabled = true;

  private boolean mTextAllCaps = false;

  private Typeface mTextTypeFace = null;
  private Typeface mIconTypeFace = null;

  /**
   * Tags to identify icon position
   */
  public static final int POSITION_LEFT = 1;
  public static final int POSITION_RIGHT = 2;
  public static final int POSITION_TOP = 3;
  public static final int POSITION_BOTTOM = 4;

  private ImageView mIconView;
  private TextView mFontIconView;
  private TextView mTextView;

  private boolean mGhost = false; // Default is a solid button !
  //private boolean mUseSystemFont = false; // Default is using robotoregular.ttf
  private boolean mUseRippleEffect = true;

  /**
   * Default constructor
   *
   * @param context : Context
   */
  public MaterialFancyButton(Context context) {
    super(context);

    //mTextTypeFace = FontUtil.findFont(context, mDefaultTextFont, null);
    //mIconTypeFace = FontUtil.findFont(context, mDefaultIconFont, null);
    initializeMaterialFancyButton();
  }

  /**
   * Default constructor called from Layouts
   *
   * @param context : Context
   * @param attrs : Attributes Array
   */
  public MaterialFancyButton(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray attrsArray =
        context.obtainStyledAttributes(attrs, R.styleable.MaterialFancyButtonAttrs, 0, 0);
    initAttributesArray(attrsArray);
    attrsArray.recycle();

    initializeMaterialFancyButton();
  }

  /**
   * Initialize Button dependencies
   * - Initialize Button Container : The LinearLayout
   * - Initialize Button TextView
   * - Initialize Button Icon
   * - Initialize Button Font Icon
   */
  private void initializeMaterialFancyButton() {
    initializeButtonContainer();

    mTextView = setupTextView();
    mIconView = setupIconView();
    mFontIconView = setupFontIconView();
    if (mIcon != null) {
      Log.d(TAG, "mIcon = " + mIcon);
      setIcon(mIcon);
    }

    this.removeAllViews();
    setupBackground();

    List<View> views = new ArrayList<>();

    if (mIconPosition == POSITION_LEFT || mIconPosition == POSITION_TOP) {

      if (mIconView != null) {
        views.add(mIconView);
      }

      if (mFontIconView != null) {
        views.add(mFontIconView);
      }
      if (mTextView != null) {
        views.add(mTextView);
      }
    } else {
      if (mTextView != null) {
        views.add(mTextView);
      }

      if (mIconView != null) {
        views.add(mIconView);
      }

      if (mFontIconView != null) {
        views.add(mFontIconView);
      }
    }

    for (View view : views) {
      this.addView(view);
    }
  }

  /**
   * Setup Text View
   *
   * @return : TextView
   */
  private TextView setupTextView() {
    if (mText == null) {
      mText = "Fancy Button";
    }

    TextView textView;
    if (mTextView == null) {
      textView = new TextView(getContext());
    } else {
      textView = mTextView;
    }
    textView.setText(mText);

    textView.setGravity(mDefaultTextGravity);
    textView.setTextColor(mEnabled ? mDefaultTextColor : mDisabledTextColor);
    textView.setTextSize(FontUtil.pxToSp(getContext(), mDefaultTextSize));
    textView.setLayoutParams(
        new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    //if (!isInEditMode() && !mUseSystemFont) {
    //  textView.setTypeface(mTextTypeFace); //we can pass null in first arg
    //}
    return textView;
  }

  /**
   * Setup Font Icon View
   *
   * @return : TextView
   */
  private TextView setupFontIconView() {
    if (mFontIcon != null) {
      TextView fontIconView = new TextView(getContext());
      fontIconView.setTextColor(mEnabled ? mDefaultIconColor : mDisabledTextColor);

      LayoutParams iconTextViewParams =
          new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      iconTextViewParams.rightMargin = mIconPaddingRight;
      iconTextViewParams.leftMargin = mIconPaddingLeft;
      iconTextViewParams.topMargin = mIconPaddingTop;
      iconTextViewParams.bottomMargin = mIconPaddingBottom;

      if (mTextView != null) {

        if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
          iconTextViewParams.gravity = Gravity.CENTER;
          fontIconView.setGravity(Gravity.CENTER);
        } else {
          fontIconView.setGravity(Gravity.CENTER_VERTICAL);
          iconTextViewParams.gravity = Gravity.CENTER_VERTICAL;
        }
      } else {
        iconTextViewParams.gravity = Gravity.CENTER;
        fontIconView.setGravity(Gravity.CENTER_VERTICAL);
      }

      fontIconView.setLayoutParams(iconTextViewParams);
      if (!isInEditMode()) {
        fontIconView.setTextSize(FontUtil.pxToSp(getContext(), mFontIconSize));
        fontIconView.setText(mFontIcon);
        fontIconView.setTypeface(mIconTypeFace);
      } else {
        fontIconView.setTextSize(FontUtil.pxToSp(getContext(), mFontIconSize));
        fontIconView.setText("O");
      }
      return fontIconView;
    }
    return null;
  }

  /**
   * Text Icon resource view
   *
   * @return : ImageView
   */
  private ImageView setupIconView() {
    if (mIconResource != null) {
      ImageView iconView;
      if (mIconView == null) {
        iconView = new ImageView(getContext());
      } else {
        iconView = mIconView;
      }
      //ImageView iconView = new ImageView(getContext());
      iconView.setImageDrawable(mIconResource);
      iconView.setPadding(mIconPaddingLeft, mIconPaddingTop, mIconPaddingRight, mIconPaddingBottom);

      LayoutParams iconViewParams =
          new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      if (mTextView != null) {
        if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
          iconViewParams.gravity = Gravity.CENTER;
        } else {
          iconViewParams.gravity = Gravity.START;
        }

        iconViewParams.rightMargin = 10;
        iconViewParams.leftMargin = 10;
      } else {
        iconViewParams.gravity = Gravity.CENTER_VERTICAL;
      }
      iconView.setLayoutParams(iconViewParams);

      return iconView;
    }
    return null;
  }

  /**
   * Initialize Attributes arrays
   *
   * @param attrsArray : Attributes array
   */
  private void initAttributesArray(TypedArray attrsArray) {

    mDefaultBackgroundColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_defaultColor,
            mDefaultBackgroundColor);
    mFocusBackgroundColor = attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_focusColor,
        mFocusBackgroundColor);
    mDisabledBackgroundColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_disabledColor,
            mDisabledBackgroundColor);

    mEnabled = attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_android_enabled, true);

    mDisabledTextColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_disabledTextColor,
            mDisabledTextColor);
    mDisabledBorderColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_disabledBorderColor,
            mDisabledBorderColor);
    mDefaultTextColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_textColor, mDefaultTextColor);
    // if default color is set then the icon's color is the same (the default for icon's color)
    mDefaultIconColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_iconColor, mDefaultTextColor);

    mDefaultTextSize =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_textSize,
            mDefaultTextSize);
    mDefaultTextSize =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_android_textSize,
            mDefaultTextSize);

    mDefaultTextGravity =
        attrsArray.getInt(R.styleable.MaterialFancyButtonAttrs_mfb_textGravity, mDefaultTextGravity);

    mBorderColor =
        attrsArray.getColor(R.styleable.MaterialFancyButtonAttrs_mfb_borderColor, mBorderColor);
    mBorderWidth =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_borderWidth,
            mBorderWidth);

    // Handle radius for button.
    mRadius =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_radius, mRadius);

    mRadiusTopLeft =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_radiusTopLeft,
            mRadius);
    mRadiusTopRight =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_radiusTopRight,
            mRadius);
    mRadiusBottomLeft =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_radiusBottomLeft,
            mRadius);
    mRadiusBottomRight =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_radiusBottomRight,
            mRadius);

    mFontIconSize =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_fontIconSize,
            mFontIconSize);

    mIconPaddingLeft =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_iconPaddingLeft,
            mIconPaddingLeft);
    mIconPaddingRight =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_iconPaddingRight,
            mIconPaddingRight);
    mIconPaddingTop =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_iconPaddingTop,
            mIconPaddingTop);
    mIconPaddingBottom =
        (int) attrsArray.getDimension(R.styleable.MaterialFancyButtonAttrs_mfb_iconPaddingBottom,
            mIconPaddingBottom);

    mTextAllCaps =
        attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_mfb_textAllCaps, false);
    mTextAllCaps =
        attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_android_textAllCaps, false);

    mGhost = attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_mfb_ghost, mGhost);
    //mUseSystemFont = attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_fb_useSystemFont,
    //    mUseSystemFont);

    String text = attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_mfb_text);

    if (text == null) { //no mfb_text attribute
      text = attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_android_text);
    }

    mIconPosition =
        attrsArray.getInt(R.styleable.MaterialFancyButtonAttrs_mfb_iconPosition, mIconPosition);

    String fontIcon =
        attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_mfb_fontIconResource);

    String iconFontFamily = attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_mfb_iconFont);
    String textFontFamily = attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_mfb_textFont);

    try {
      mIconResource = attrsArray.getDrawable(R.styleable.MaterialFancyButtonAttrs_mfb_iconResource);
    } catch (Exception e) {
      mIconResource = null;
    }

    mIcon = attrsArray.getString(R.styleable.MaterialFancyButtonAttrs_mfb_icon);

    Log.d(TAG, "mIcon = " + mIcon);
    if (fontIcon != null) mFontIcon = fontIcon;

    if (text != null) mText = mTextAllCaps ? text.toUpperCase() : text;

    if (!isInEditMode()) {
      if(mIcon != null) {

      } else {
        if (iconFontFamily != null) {
          mIconTypeFace = FontUtil.findFont(getContext(), iconFontFamily, null);
        } else {
          mIconTypeFace = FontUtil.findFont(getContext(), null, null);
        }

        if (textFontFamily != null) {
          mTextTypeFace = FontUtil.findFont(getContext(), textFontFamily, null);
        } else {
          mTextTypeFace = FontUtil.findFont(getContext(), null, null);
        }
      }
    }
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private Drawable getRippleDrawable(Drawable defaultDrawable, Drawable focusDrawable,
      Drawable disabledDrawable) {
    if (!mEnabled) {
      return disabledDrawable;
    } else {
      return new RippleDrawable(ColorStateList.valueOf(mFocusBackgroundColor), defaultDrawable,
          focusDrawable);
    }
  }

  @SuppressLint("NewApi") private void setupBackground() {

    // Default Drawable
    GradientDrawable defaultDrawable = new GradientDrawable();
    defaultDrawable.setCornerRadius(mRadius);
    defaultDrawable.setCornerRadii(new float[] {
        mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight,
        mRadiusBottomRight, mRadiusBottomLeft, mRadiusBottomLeft
    });
    if (mGhost) {
      // Hollow Background
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        defaultDrawable.setColor(getContext().getColor(android.R.color.transparent));
      } else {
        //noinspection deprecation
        defaultDrawable.setColor(getResources().getColor(android.R.color.transparent));
      }

    } else {
      defaultDrawable.setColor(mDefaultBackgroundColor);
    }

    //Focus Drawable
    GradientDrawable focusDrawable = new GradientDrawable();
    focusDrawable.setCornerRadius(mRadius);
    focusDrawable.setCornerRadii(new float[] {
        mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight,
        mRadiusBottomRight, mRadiusBottomLeft, mRadiusBottomLeft
    });
    focusDrawable.setColor(mFocusBackgroundColor);

    // Disabled Drawable
    GradientDrawable disabledDrawable = new GradientDrawable();
    disabledDrawable.setCornerRadius(mRadius);
    focusDrawable.setCornerRadii(new float[] {
        mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight,
        mRadiusBottomRight, mRadiusBottomLeft, mRadiusBottomLeft
    });
    disabledDrawable.setColor(mDisabledBackgroundColor);
    disabledDrawable.setStroke(mBorderWidth, mDisabledBorderColor);

    // Handle Border
    if (mBorderColor != 0) {
      defaultDrawable.setStroke(mBorderWidth, mBorderColor);
    }

    // Handle disabled border color
    if (!mEnabled) {
      defaultDrawable.setStroke(mBorderWidth, mDisabledBorderColor);
      if (mGhost) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          disabledDrawable.setColor(getContext().getColor(android.R.color.transparent));
        } else {
          //noinspection deprecation
          disabledDrawable.setColor(getResources().getColor(android.R.color.transparent));
        }
      }
    }

    if (mUseRippleEffect && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      this.setBackground(getRippleDrawable(defaultDrawable, focusDrawable, disabledDrawable));
    } else {

      StateListDrawable states = new StateListDrawable();

      // Focus/Pressed Drawable
      GradientDrawable drawable2 = new GradientDrawable();
      drawable2.setCornerRadius(mRadius);
      focusDrawable.setCornerRadii(new float[] {
          mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight,
          mRadiusBottomRight, mRadiusBottomLeft, mRadiusBottomLeft
      });
      if (mGhost) {
        drawable2.setColor(getResources().getColor(android.R.color.transparent)); // No focus color
      } else {
        drawable2.setColor(mFocusBackgroundColor);
      }

      // Handle Button Border
      if (mBorderColor != 0) {
        if (mGhost) {
          drawable2.setStroke(mBorderWidth,
              mFocusBackgroundColor); // Border is the main part of button now
        } else {
          drawable2.setStroke(mBorderWidth, mBorderColor);
        }
      }

      if (!mEnabled) {
        if (mGhost) {
          drawable2.setStroke(mBorderWidth, mDisabledBorderColor);
        } else {
          drawable2.setStroke(mBorderWidth, mDisabledBorderColor);
        }
      }

      if (mFocusBackgroundColor != 0) {
        states.addState(new int[] { android.R.attr.state_pressed }, drawable2);
        states.addState(new int[] { android.R.attr.state_focused }, drawable2);
        states.addState(new int[] { -android.R.attr.state_enabled }, disabledDrawable);
      }

      states.addState(new int[] {}, defaultDrawable);

      if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        this.setBackgroundDrawable(states);
      } else {
        this.setBackground(states);
      }
    }
  }

  /**
   * Initialize button container
   */
  private void initializeButtonContainer() {

    if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
      this.setOrientation(LinearLayout.VERTICAL);
    } else {
      this.setOrientation(LinearLayout.HORIZONTAL);
    }

    if (this.getLayoutParams() == null) {
      LayoutParams containerParams =
          new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      this.setLayoutParams(containerParams);
    }

    this.setGravity(Gravity.CENTER);
    this.setClickable(true);
    this.setFocusable(true);
    if (mIconResource == null
        && mFontIcon == null
        && getPaddingLeft() == 0
        && getPaddingRight() == 0
        && getPaddingTop() == 0
        && getPaddingBottom() == 0) {
      this.setPadding(20, 20, 20, 20);
    }
  }

  /**
   * Set Text of the button
   *
   * @param text : Text
   */
  public void setText(String text) {
    text = mTextAllCaps ? text.toUpperCase() : text;
    this.mText = text;
    if (mTextView == null) {
      initializeMaterialFancyButton();
    } else {
      mTextView.setText(text);
    }
  }

  /**
   * Set text of the button by string resource id
   *
   * @param resId Resource id for the string
   */
  @SuppressWarnings("unused") public void setText(int resId) {
    String text = getContext().getString(resId);
    text = mTextAllCaps ? text.toUpperCase() : text;
    this.mText = text;
    if (mTextView == null) {
      initializeMaterialFancyButton();
    } else {
      mTextView.setText(text);
    }
  }

  /**
   * Set the capitalization of text
   *
   * @param textAllCaps : is text to be capitalized
   */
  @SuppressWarnings("unused") public void setTextAllCaps(boolean textAllCaps) {
    this.mTextAllCaps = textAllCaps;
    setText(mText);
  }

  /**
   * Set the color of text
   *
   * @param color : Color
   * use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setTextColor(int color) {
    this.mDefaultTextColor = color;
    if (mTextView == null) {
      initializeMaterialFancyButton();
    } else {
      mTextView.setTextColor(color);
    }
  }

  /**
   * Setting the icon's color independent of the text color
   *
   * @param color : Color
   */
  @SuppressWarnings("unused") public void setIconColor(int color) {
    if (mFontIconView != null) {
      mFontIconView.setTextColor(color);
    }
  }

  /**
   * Set Background color of the button
   *
   * @param color : use Color.parse('#code')
   */
  public void setBackgroundColor(int color) {
    this.mDefaultBackgroundColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set Focus color of the button
   *
   * @param color : use Color.parse('#code')
   */
  public void setFocusBackgroundColor(int color) {
    this.mFocusBackgroundColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) this.setupBackground();
  }

  /**
   * Set Disabled state color of the button
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableBackgroundColor(int color) {
    this.mDisabledBackgroundColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) this.setupBackground();
  }

  /**
   * Set Disabled state color of the button text
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableTextColor(int color) {
    this.mDisabledTextColor = color;
    if (mTextView == null) {
      initializeMaterialFancyButton();
    } else if (!mEnabled) mTextView.setTextColor(color);
  }

  /**
   * Set Disabled state color of the button border
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableBorderColor(int color) {
    this.mDisabledBorderColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set the size of Text in sp
   *
   * @param textSize : Text Size
   */
  public void setTextSize(int textSize) {
    this.mDefaultTextSize = FontUtil.spToPx(getContext(), textSize);
    if (mTextView != null) mTextView.setTextSize(textSize);
  }

  /**
   * Set the gravity of Text
   *
   * @param gravity : Text Gravity
   */
  @SuppressWarnings("unused") public void setTextGravity(int gravity) {
    this.mDefaultTextGravity = gravity;
    if (mTextView != null) {
      mTextView.setGravity(gravity);
    }
  }

  /**
   * Set Padding for mIconView and mFontIconSize
   *
   * @param paddingLeft : Padding Left
   * @param paddingTop : Padding Top
   * @param paddingRight : Padding Right
   * @param paddingBottom : Padding Bottom
   */
  public void setIconPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
    this.mIconPaddingLeft = paddingLeft;
    this.mIconPaddingTop = paddingTop;
    this.mIconPaddingRight = paddingRight;
    this.mIconPaddingBottom = paddingBottom;
    if (mIconView != null) {
      mIconView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight,
          this.mIconPaddingBottom);
    }
    if (mFontIconView != null) {
      mFontIconView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight,
          this.mIconPaddingBottom);
    }
  }

  /**
   * Set an icon from resources to the button
   *
   * @param drawable : Int resource
   */
  public void setIconResource(int drawable) {
    if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
      this.mIconResource = getResources().getDrawable(drawable);
    } else {
      this.mIconResource = getResources().getDrawable(drawable, getContext().getTheme());
    }
    if (mIconView == null || mFontIconView != null) {
      mFontIconView = null;
      initializeMaterialFancyButton();
    } else {
      mIconView.setImageDrawable(mIconResource);
    }
  }

  /**
   * Set a drawable to the button
   *
   * @param drawable : Drawable resource
   */
  @SuppressWarnings("unused") public void setIconResource(Drawable drawable) {
    this.mIconResource = drawable;
    if (mIconView == null || mFontIconView != null) {
      mFontIconView = null;
      initializeMaterialFancyButton();
    } else {
      mIconView.setImageDrawable(mIconResource);
    }
  }

  /**
   * Set a font icon to the button (eg FFontAwesome or Entypo...)
   *
   * @param icon : Icon value eg : \uf082
   */
  public void setIconResource(String icon) {
    this.mFontIcon = icon;
    if (mFontIconView == null) {
      mIconView = null;
      initializeMaterialFancyButton();
    } else {
      mFontIconView.setText(icon);
    }
  }

  public void setIcon(Character icon) {
    setIcon(icon.toString());
  }

  public void setIcon(String icon) {
    try {
      Log.d(TAG, "icon.substring(0, 3) = " + icon.substring(0, 3));
      ITypeface font =
          CoreIcon.findFont(getContext().getApplicationContext(), icon.substring(0, CoreIcon.FONT_MAPPING_PREFIX));
      Log.d(TAG, "Font characters = " + font.getCharacters().size());
      icon = icon.replace("-", "_");
      setIcon(font.getIcon(icon));
      Log.d(TAG, font.getIcon(icon).getTypeface().getDescription());
    } catch (Exception ex) {
      Log.e(TAG, "Wrong icon name: " + icon);
    }
    //setIconResource(icon);
  }

  public void setIcon(IIcon icon) {
    ITypeface typeface = icon.getTypeface();
    Log.d(TAG, "Typeface = " + icon.getTypeface().getAuthor());
    mIconTypeFace = typeface.getTypeface(getContext().getApplicationContext());
    setIconResource(String.valueOf(icon.getCharacter()));
  }

  /**
   * Set Icon size of the button (for only font icons) in sp
   *
   * @param iconSize : Icon Size
   */
  public void setFontIconSize(int iconSize) {
    this.mFontIconSize = FontUtil.spToPx(getContext(), iconSize);
    if (mFontIconView != null) mFontIconView.setTextSize(iconSize);
  }

  /**
   * Set Icon Position
   * Use the global variables (FancyButton.POSITION_LEFT, FancyButton.POSITION_RIGHT,
   * FancyButton.POSITION_TOP, FancyButton.POSITION_BOTTOM)
   *
   * @param position : Position
   */
  public void setIconPosition(int position) {
    if (position > 0 && position < 5) {
      mIconPosition = position;
    } else {
      mIconPosition = POSITION_LEFT;
    }

    initializeMaterialFancyButton();
  }

  /**
   * Set color of the button border
   *
   * @param color : Color
   * use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setBorderColor(int color) {
    this.mBorderColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set Width of the button
   *
   * @param width : Width
   */
  @SuppressWarnings("unused") public void setBorderWidth(int width) {
    this.mBorderWidth = width;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set Border Radius of the button
   *
   * @param radius : Radius
   */
  public void setRadius(int radius) {
    this.mRadius = radius;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  public void setRadius(int radiusTopLeft, int radiusTopRight, int radiusBottomLeft, int radiusBottomRight) {
    this.mRadiusTopLeft = radiusTopLeft;
    this.mRadiusTopRight = radiusTopRight;
    this.mRadiusBottomLeft = radiusBottomLeft;
    this.mRadiusBottomRight = radiusBottomRight;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set border radius top left of the button
   * @param radiusTopLeft radius top left of the button
   */
  public void setRadiusTopLeft(int radiusTopLeft) {
    this.mRadiusTopLeft = radiusTopLeft;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set border radius top right of the button
   * @param radiusTopRight radius top right of the button
   */
  public void setRadiusTopRight(int radiusTopRight) {
    this.mRadiusTopRight = radiusTopRight;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set border radius bottom left of the button
   * @param radiusBottomLeft radius bottom left of the button
   */
  public void setRadiusBottomLeft(int radiusBottomLeft) {
    this.mRadiusBottomLeft = radiusBottomLeft;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set border radius bottom right of the button
   * @param radiusBottomRight radius bottom right of the button
   */
  public void setRadiusBottomRight(int radiusBottomRight) {
    this.mRadiusBottomRight = radiusBottomRight;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  /**
   * Set custom font for button Text
   *
   * @param fontName : Font Name
   * Place your text fonts in assets
   */
  public void setCustomTextFont(String fontName) {
    mTextTypeFace = FontUtil.findFont(getContext(), fontName, null);

    if (mTextView == null) {
      initializeMaterialFancyButton();
    } else {
      mTextView.setTypeface(mTextTypeFace);
    }
  }

  /**
   * Set Custom font for button icon
   *
   * @param fontName : Font Name
   * Place your icon fonts in assets
   */
  @SuppressWarnings("unused") public void setIconFont(String fontName) {

    mIconTypeFace = FontUtil.findFont(getContext(), fontName, null);

    if (mFontIconView == null) {
      initializeMaterialFancyButton();
    } else {
      mFontIconView.setTypeface(mIconTypeFace);
    }
  }

  /**
   * Override setEnabled and rebuild the fancybutton view
   * To redraw the button according to the state : enabled or disabled
   */
  @Override public void setEnabled(boolean value) {
    super.setEnabled(value);
    this.mEnabled = value;
    initializeMaterialFancyButton();
  }

  /**
   * Setting the button to have hollow or solid shape
   */
  @SuppressWarnings("unused") public void setGhost(boolean ghost) {
    this.mGhost = ghost;

    if (mIconView != null || mFontIconView != null || mTextView != null) {
      this.setupBackground();
    }
  }

  ///**
  // * If enabled, the button title will ignore its custom font and use the default system font
  // *
  // * @param status : true || false
  // */
  //@SuppressWarnings("unused") public void setUsingSystemFont(boolean status) {
  //  this.mUseSystemFont = status;
  //}

  /**
   * Return Text of the button
   *
   * @return Text
   */
  @SuppressWarnings("unused") public CharSequence getText() {
    if (mTextView != null) {
      return mTextView.getText();
    } else {
      return "";
    }
  }

  /**
   * Return TextView Object of the FancyButton
   *
   * @return TextView Object
   */
  @SuppressWarnings("unused") public TextView getTextViewObject() {
    return mTextView;
  }

  /**
   * Return Icon Font of the FancyButton
   *
   * @return TextView Object
   */
  @SuppressWarnings("unused") public TextView getIconFontObject() {
    return mFontIconView;
  }

  /**
   * Return Icon of the FancyButton
   *
   * @return ImageView Object
   */
  @SuppressWarnings("unused") public ImageView getIconImageObject() {
    return mIconView;
  }
}
