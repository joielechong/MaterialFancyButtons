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
import android.text.TextUtils;
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
  //private int mTextPosition = 1;
  private int mTextSize = FontUtil.spToPx(getContext(), 15);
  private int mTextGravity; // Gravity.CENTER
  private String mText = null;
  private int mTextStyle;

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

  private int mBorderColor;
  private int mBorderWidth = 0;

  private int mRadius = 0;
  private int mRadiusTopLeft = 0;
  private int mRadiusTopRight = 0;
  private int mRadiusBottomLeft = 0;
  private int mRadiusBottomRight = 0;

  private boolean mEnabled;
  private boolean mTextAllCaps;

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

  public MaterialFancyButton(Context context) {
    super(context);
    initializeMaterialFancyButton();
  }

  public MaterialFancyButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.MaterialFancyButton, 0, 0);
    initAttributesArray(arr);
    arr.recycle();
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
    setupTextView();
    setupFontIconView();
    setupIconView();
    if (mIcon != null) setIcon(mIcon);

    //this.removeAllViews();
    setupBackground();

    List<View> views = new ArrayList<>();

    if (mIconPosition == POSITION_LEFT || mIconPosition == POSITION_TOP) {
      if (mIconView != null) views.add(mIconView);
      if (mFontIconView != null) views.add(mFontIconView);
      if (mTextView != null) views.add(mTextView);
    } else {
      if (mTextView != null) views.add(mTextView);
      if (mIconView != null) views.add(mIconView);
      if (mFontIconView != null) views.add(mFontIconView);
    }

    for (View view : views) {
      addView(view);
    }
  }

  /**
   * Setup Text View
   *
   * @return : TextView
   */
  private void setupTextView() {
    if (mText == null) mText = "BUTTON";
    if (mTextView == null) mTextView = new TextView(getContext());

    mTextView.setText(mText);
    mTextView.setGravity(mTextGravity);
    mTextView.setTextColor(mEnabled ? mDefaultTextColor : mDisabledTextColor);
    mTextView.setTextSize(FontUtil.pxToSp(getContext(), mTextSize));
    mTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    mTextView.setTypeface(mTextView.getTypeface(), mTextStyle);
  }

  /**
   * Setup Font Icon View
   */
  private void setupFontIconView() {
    Log.d("setupFontIconView", "mFontIcon = " + mFontIcon);
    if (mFontIcon == null) return;
    if(mFontIconView == null) mFontIconView = new TextView(getContext());
    mFontIconView.setTextColor(mEnabled ? mDefaultIconColor : mDisabledTextColor);
    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params.rightMargin = mIconPaddingRight;
    params.leftMargin = mIconPaddingLeft;
    params.topMargin = mIconPaddingTop;
    params.bottomMargin = mIconPaddingBottom;

    if (mTextView == null) {
      params.gravity = Gravity.CENTER;
      mFontIconView.setGravity(Gravity.CENTER_VERTICAL);
    } else {
      if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
        params.gravity = Gravity.CENTER;
        mFontIconView.setGravity(Gravity.CENTER);
      } else {
        mFontIconView.setGravity(Gravity.CENTER_VERTICAL);
        params.gravity = Gravity.CENTER_VERTICAL;
      }
    }

    mFontIconView.setLayoutParams(params);
    mFontIconView.setTextSize(FontUtil.pxToSp(getContext(), mFontIconSize));
    mFontIconView.setText(mFontIcon);
    mFontIconView.setTypeface(mIconTypeFace);
    Log.d("setupFontIconView", "mIconTypeFace  =  " + mIconTypeFace.toString());
  }

  /**
   * Text Icon resource view
   *
   * @return : ImageView
   */
  private void setupIconView() {
    if (mIconView == null) mIconView = new ImageView(getContext());
    mIconView.setPadding(mIconPaddingLeft, mIconPaddingTop, mIconPaddingRight, mIconPaddingBottom);
    LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    if (TextUtils.isEmpty(mText)) {
      params.gravity = Gravity.CENTER_VERTICAL;
    } else {
      if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
        params.gravity = Gravity.CENTER;
      } else {
        params.gravity = Gravity.START;
      }
    }
    mIconView.setLayoutParams(params);

    if (mIconResource == null) {
      Log.d(TAG, "mIconResource is null");
    } else {
      mIconView.setImageDrawable(mIconResource);
      Log.d(TAG, "mIconResource is not null");
    }
  }

  /**
   * Initialize Attributes arrays
   *
   * @param attrs : Attributes array
   */
  private void initAttributesArray(TypedArray attrs) {
    mDefaultBackgroundColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_defaultColor, mDefaultBackgroundColor);
    mFocusBackgroundColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_focusColor, mFocusBackgroundColor);
    mDisabledBackgroundColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_disabledColor, mDisabledBackgroundColor);

    mEnabled = attrs.getBoolean(R.styleable.MaterialFancyButton_android_enabled, true);

    mDisabledTextColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_disabledTextColor, mDisabledTextColor);
    mDisabledBorderColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_disabledBorderColor, mDisabledBorderColor);
    mDefaultTextColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_textColor, mDefaultTextColor);
    // if default color is set then the icon's color is the same (the default for icon's color)
    mDefaultIconColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_iconColor, mDefaultTextColor);

    mTextSize = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_textSize, mTextSize);
    mTextSize = (int) attrs.getDimension(R.styleable.MaterialFancyButton_android_textSize, mTextSize);
    mTextStyle = attrs.getInt(R.styleable.MaterialFancyButton_android_textStyle, Typeface.NORMAL);

    mTextGravity = attrs.getInt(R.styleable.MaterialFancyButton_mfb_textGravity, Gravity.CENTER);

    mBorderColor = attrs.getColor(R.styleable.MaterialFancyButton_mfb_borderColor, Color.TRANSPARENT);
    mBorderWidth = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_borderWidth, mBorderWidth);

    // Handle radius for button.
    mRadius = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_radius, mRadius);

    mRadiusTopLeft = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_radiusTopLeft, mRadius);
    mRadiusTopRight = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_radiusTopRight, mRadius);
    mRadiusBottomLeft = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_radiusBottomLeft, mRadius);
    mRadiusBottomRight = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_radiusBottomRight, mRadius);

    mFontIconSize = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_fontIconSize, mFontIconSize);

    mIconPaddingLeft = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_iconPaddingLeft, mIconPaddingLeft);
    mIconPaddingRight = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_iconPaddingRight, mIconPaddingRight);
    mIconPaddingTop = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_iconPaddingTop, mIconPaddingTop);
    mIconPaddingBottom = (int) attrs.getDimension(R.styleable.MaterialFancyButton_mfb_iconPaddingBottom, mIconPaddingBottom);

    mTextAllCaps = attrs.getBoolean(R.styleable.MaterialFancyButton_mfb_textAllCaps, false);
    mTextAllCaps = attrs.getBoolean(R.styleable.MaterialFancyButton_android_textAllCaps, false);

    mGhost = attrs.getBoolean(R.styleable.MaterialFancyButton_mfb_ghost, mGhost);
    //mUseSystemFont = attrsArray.getBoolean(R.styleable.MaterialFancyButtonAttrs_fb_useSystemFont,
    //    mUseSystemFont);

    String text = attrs.getString(R.styleable.MaterialFancyButton_mfb_text);

    //no mfb_text attribute
    if (text == null) text = attrs.getString(R.styleable.MaterialFancyButton_android_text);

    mIconPosition = attrs.getInt(R.styleable.MaterialFancyButton_mfb_iconPosition, mIconPosition);

    String fontIcon = attrs.getString(R.styleable.MaterialFancyButton_mfb_fontIconResource);

    String iconFontFamily = attrs.getString(R.styleable.MaterialFancyButton_mfb_iconFont);
    String textFontFamily = attrs.getString(R.styleable.MaterialFancyButton_mfb_textFont);

    try {
      mIconResource = attrs.getDrawable(R.styleable.MaterialFancyButton_mfb_iconResource);
    } catch (Exception e) {
      mIconResource = null;
    }

    mIcon = attrs.getString(R.styleable.MaterialFancyButton_mfb_icon);

    Log.d(TAG, "mIcon = " + mIcon);
    if (fontIcon != null) mFontIcon = fontIcon;

    if (text != null) mText = mTextAllCaps ? text.toUpperCase() : text;

    if (mIcon == null) {
      if (iconFontFamily == null) {
        mIconTypeFace = FontUtil.findFont(getContext(), null, null);
      } else {
        mIconTypeFace = FontUtil.findFont(getContext(), iconFontFamily, null);
      }

      if (textFontFamily == null) {
        mTextTypeFace = FontUtil.findFont(getContext(), null, null);
      } else {
        mTextTypeFace = FontUtil.findFont(getContext(), textFontFamily, null);
      }
    }
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private Drawable getRippleDrawable(Drawable defaultDrawable, Drawable focusDrawable, Drawable disabledDrawable) {
    if (mEnabled) {
      return new RippleDrawable(ColorStateList.valueOf(mFocusBackgroundColor), defaultDrawable, focusDrawable);
    } else {
      return disabledDrawable;
    }
  }

  GradientDrawable defaultDrawable;
  GradientDrawable focusDrawable;
  GradientDrawable disabledDrawable;
  StateListDrawable states;
  GradientDrawable drawable2;

  @SuppressLint("NewApi")
  private void setupBackground() {
    GradientDrawable defaultDrawable = new GradientDrawable();
    defaultDrawable.setCornerRadius(mRadius);
    defaultDrawable.setCornerRadii(new float[] { mRadiusTopLeft, mRadiusTopLeft,
        mRadiusTopRight, mRadiusTopRight,
        mRadiusBottomRight, mRadiusBottomRight,
        mRadiusBottomLeft, mRadiusBottomLeft
    });

    if (mGhost) {
      // Hollow Background
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        defaultDrawable.setColor(getContext().getColor(android.R.color.transparent));
      } else {
        defaultDrawable.setColor(getResources().getColor(android.R.color.transparent));
      }
    } else {
      defaultDrawable.setColor(mDefaultBackgroundColor);
    }

    //Focus Drawable
    //if(focusDrawable == null) {
    GradientDrawable focusDrawable = new GradientDrawable();
    //}
    focusDrawable.setCornerRadius(mRadius);
    focusDrawable.setCornerRadii(new float[] {
        mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight, mRadiusBottomRight,
        mRadiusBottomLeft, mRadiusBottomLeft
    });
    focusDrawable.setColor(mFocusBackgroundColor);

    // Disabled Drawable
    //if(disabledDrawable == null) {
    GradientDrawable disabledDrawable = new GradientDrawable();
    //}
    disabledDrawable.setCornerRadius(mRadius);
    focusDrawable.setCornerRadii(new float[] {
        mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight, mRadiusBottomRight,
        mRadiusBottomLeft, mRadiusBottomLeft
    });
    disabledDrawable.setColor(mDisabledBackgroundColor);
    disabledDrawable.setStroke(mBorderWidth, mDisabledBorderColor);

    // Handle Border
    if (mBorderColor != 0) defaultDrawable.setStroke(mBorderWidth, mBorderColor);

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

    setupRippleEffect(defaultDrawable, focusDrawable, disabledDrawable);
  }

  private void setupRippleEffect(GradientDrawable defaultDrawable, GradientDrawable focusDrawable,
      GradientDrawable disabledDrawable) {
    if (mUseRippleEffect && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      setBackground(getRippleDrawable(defaultDrawable, focusDrawable, disabledDrawable));
    } else {
      StateListDrawable states = new StateListDrawable();
      GradientDrawable drawable2 = new GradientDrawable();
      drawable2.setCornerRadius(mRadius);
      focusDrawable.setCornerRadii(new float[] {
          mRadiusTopLeft, mRadiusTopLeft, mRadiusTopRight, mRadiusTopRight, mRadiusBottomRight, mRadiusBottomRight,
          mRadiusBottomLeft, mRadiusBottomLeft
      });
      if (mGhost) {
        drawable2.setColor(getResources().getColor(android.R.color.transparent)); // No focus color
      } else {
        drawable2.setColor(mFocusBackgroundColor);
      }

      // Handle Button Border
      if (mBorderColor != 0) {
        if (mGhost) {
          drawable2.setStroke(mBorderWidth, mFocusBackgroundColor); // Border is the main part of button now
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
        setBackgroundDrawable(states);
      } else {
        setBackground(states);
      }
    }
  }

  private void initializeButtonContainer() {
    if (mIconPosition == POSITION_TOP || mIconPosition == POSITION_BOTTOM) {
      setOrientation(LinearLayout.VERTICAL);
    } else {
      setOrientation(LinearLayout.HORIZONTAL);
    }

    if (getLayoutParams() == null) {
      LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      setLayoutParams(params);
    }

    setGravity(Gravity.CENTER);
    setClickable(true);
    setFocusable(true);
    if (mIconResource == null
        && mFontIcon == null
        && getPaddingLeft() == 0
        && getPaddingRight() == 0
        && getPaddingTop() == 0
        && getPaddingBottom() == 0) {

      //fix for all version of androids and screens
      setPadding(20, 0, 20, 0);
    }
  }

  /**
   * Set Text of the button
   *
   * @param text : Text
   */
  public void setText(String text) {
    text = mTextAllCaps ? text.toUpperCase() : text;
    mText = text;
    if(mTextView == null) setupView();
    mTextView.setText(text);
  }

  /**
   * Set text of the button by string resource id
   *
   * @param resId Resource id for the string
   */
  @SuppressWarnings("unused") public void setText(int resId) {
    String text = getContext().getString(resId);
    text = mTextAllCaps ? text.toUpperCase() : text;
    mText = text;
    if (mTextView == null) setupTextView();
    mTextView.setText(text);
  }

  /**
   * Set the capitalization of text
   *
   * @param textAllCaps : is text to be capitalized
   */
  @SuppressWarnings("unused") public void setTextAllCaps(boolean textAllCaps) {
    mTextAllCaps = textAllCaps;
    setText(mText);
  }

  /**
   * Set the color of text
   *
   * @param color : Color
   * use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setTextColor(int color) {
    mDefaultTextColor = color;
    if (mTextView == null) setupTextView();
    mTextView.setTextColor(color);
  }

  public void setTextStyle(/*@Typeface.Style*/ int style) {
    mTextSize = style;
    if(mTextView == null) setupTextView();
    mTextView.setTypeface(mTextView.getTypeface(), style);
  }

  /**
   * Setting the icon's color independent of the text color
   *
   * @param color : Color
   */
  @SuppressWarnings("unused") public void setIconColor(int color) {
    if (mFontIconView != null) mFontIconView.setTextColor(color);
  }

  /**
   * Set Background color of the button
   *
   * @param color : use Color.parse('#code')
   */
  public void setBackgroundColor(int color) {
    mDefaultBackgroundColor = color;
    setupView();
  }

  /**
   * Set Focus color of the button
   *
   * @param color : use Color.parse('#code')
   */
  public void setFocusBackgroundColor(int color) {
    mFocusBackgroundColor = color;
    setupView();
  }

  /**
   * Set Disabled state color of the button
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableBackgroundColor(int color) {
    mDisabledBackgroundColor = color;
    setupView();
  }

  /**
   * Set Disabled state color of the button text
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableTextColor(int color) {
    mDisabledTextColor = color;
    setupTextView();
    if (!mEnabled) mTextView.setTextColor(color);
  }

  /**
   * Set Disabled state color of the button border
   *
   * @param color : use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setDisableBorderColor(int color) {
    mDisabledBorderColor = color;
    if (mIconView != null || mFontIconView != null || mTextView != null) {
      setupBackground();
    }
  }

  /**
   * Set the size of Text in sp
   *
   * @param textSize : Text Size
   */
  public void setTextSize(int textSize) {
    mTextSize = FontUtil.spToPx(getContext(), textSize);
    if (mTextView != null) mTextView.setTextSize(textSize);
  }

  /**
   * Set the gravity of Text
   *
   * @param gravity : Text Gravity
   */
  @SuppressWarnings("unused") public void setTextGravity(int gravity) {
    mTextGravity = gravity;
    if (mTextView != null) mTextView.setGravity(gravity);
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
      mFontIconView.setPadding(mIconPaddingLeft, mIconPaddingTop, mIconPaddingRight, mIconPaddingBottom);
    }
  }

  /**
   * Set an icon from resources to the button
   *
   * @param drawable : Int resource
   */
  public void setIconResource(int drawable) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      mIconResource = getResources().getDrawable(drawable, getContext().getTheme());
    } else {
      mIconResource = getResources().getDrawable(drawable);
    }
    if (mIconView == null) setupIconView();
    if (mFontIconView == null) setupFontIconView();
    mIconView.setImageDrawable(mIconResource);
  }

  /**
   * Set a drawable to the button
   *
   * @param drawable : Drawable resource
   */
  @SuppressWarnings("unused") public void setIconResource(Drawable drawable) {
    mIconResource = drawable;
    if (mIconView == null) setupIconView();
    if(mFontIconView == null) setupFontIconView();
    mIconView.setImageDrawable(mIconResource);
  }

  /**
   * Set a font icon to the button (eg FFontAwesome or Entypo...)
   *
   * @param icon : Icon value eg : \uf082
   */
  public void setIconResource(String icon) {
    mIcon = icon;
    mFontIcon = icon;
    setupView();
  }

  public void setIcon(Character icon) {
    setIcon(icon.toString());
  }

  public void setIcon(String icon) {
    try {
      //Log.d(TAG, "icon.substring(0, 3) = " + icon.substring(0, 3));
      ITypeface font =
          CoreIcon.findFont(getContext().getApplicationContext(), icon.substring(0, CoreIcon.FONT_MAPPING_PREFIX));
      //Log.d(TAG, "Font characters = " + font.getCharacters().size());
      icon = icon.replace("-", "_");
      setIcon(font.getIcon(icon));
      //Log.d(TAG, font.getIcon(icon).getTypeface().getDescription());
    } catch (Exception ex) {
      Log.e(TAG, "Wrong icon name: " + icon);
    }
  }

  public void setIcon(IIcon icon) {
    ITypeface typeface = icon.getTypeface();
    Log.d(TAG, "Typeface = " + icon.getTypeface().getFontName());
    mIconTypeFace = typeface.getTypeface(getContext().getApplicationContext());
    setIconResource(String.valueOf(icon.getCharacter()));
  }

  /**
   * Set Icon size of the button (for only font icons) in sp
   *
   * @param iconSize : Icon Size
   */
  public void setFontIconSize(int iconSize) {
    mFontIconSize = FontUtil.spToPx(getContext(), iconSize);
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
    setupView();
  }

  /**
   * Set color of the button border
   *
   * @param color : Color
   * use Color.parse('#code')
   */
  @SuppressWarnings("unused") public void setBorderColor(int color) {
    mBorderColor = color;
    setupView();
  }

  /**
   * Set Width of the button
   *
   * @param width : Width
   */
  @SuppressWarnings("unused") public void setBorderWidth(int width) {
    mBorderWidth = width;
    setupView();
  }

  private void setupView() {
    setupFontIconView();
    setupTextView();
    setupBackground();
  }
  /**
   * Set Border Radius of the button
   *
   * @param radius : Radius
   */
  public void setRadius(int radius) {
    mRadius = radius;
    mRadiusTopLeft = radius;
    mRadiusTopRight = radius;
    mRadiusBottomLeft = radius;
    mRadiusBottomRight = radius;

    setupView();
    Log.d(TAG, "setRadius is called");
  }

  public void setRadius(int radiusTopLeft, int radiusTopRight, int radiusBottomLeft, int radiusBottomRight) {
    mRadiusTopLeft = radiusTopLeft;
    mRadiusTopRight = radiusTopRight;
    mRadiusBottomLeft = radiusBottomLeft;
    mRadiusBottomRight = radiusBottomRight;
    setupView();
  }

  /**
   * Set border radius top left of the button
   *
   * @param radiusTopLeft radius top left of the button
   */
  public void setRadiusTopLeft(int radiusTopLeft) {
    mRadiusTopLeft = radiusTopLeft;
    setupView();
  }

  /**
   * Set border radius top right of the button
   *
   * @param radiusTopRight radius top right of the button
   */
  public void setRadiusTopRight(int radiusTopRight) {
    mRadiusTopRight = radiusTopRight;
    setupView();
  }

  /**
   * Set border radius bottom left of the button
   *
   * @param radiusBottomLeft radius bottom left of the button
   */
  public void setRadiusBottomLeft(int radiusBottomLeft) {
    mRadiusBottomLeft = radiusBottomLeft;
    setupView();
  }

  /**
   * Set border radius bottom right of the button
   *
   * @param radiusBottomRight radius bottom right of the button
   */
  public void setRadiusBottomRight(int radiusBottomRight) {
    mRadiusBottomRight = radiusBottomRight;
    setupView();
  }

  /**
   * Set custom font for button Text
   *
   * @param fontName : Font Name
   * Place your text fonts in assets
   */
  public void setCustomTextFont(String fontName) {
    mTextTypeFace = FontUtil.findFont(getContext(), fontName, null);
    setupTextView();
    mTextView.setTypeface(mTextTypeFace);
  }

  /**
   * Set Custom font for button icon
   *
   * @param fontName : Font Name
   * Place your icon fonts in assets
   */
  @SuppressWarnings("unused") public void setIconFont(String fontName) {
    mIconTypeFace = FontUtil.findFont(getContext(), fontName, null);
    setupFontIconView();
    mFontIconView.setTypeface(mIconTypeFace);
  }

  /**
   * Override setEnabled and rebuild the fancybutton view
   * To redraw the button according to the state : enabled or disabled
   */
  @Override public void setEnabled(boolean value) {
    super.setEnabled(value);
    mEnabled = value;
    setupView();
  }

  /**
   * Setting the button to have hollow or solid shape
   */
  @SuppressWarnings("unused") public void setGhost(boolean ghost) {
    mGhost = ghost;
    setupView();
  }

  /**
   * Return Text of the button
   *
   * @return Text
   */
  @SuppressWarnings("unused") public CharSequence getText() {
    return mTextView != null ? mTextView.getText() : "";
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

//protected void applyStyle(Context context, AttributeSet attrs, int defStyleAttr,
//    int defStyleRes) {
//  getRippleManager().onCreate(this, context, attrs, defStyleAttr, defStyleRes, mCornerRadii);
//}

//protected RippleManager getRippleManager() {
//  if (mRippleManager == null) {
//    synchronized (RippleManager.class) {
//      if (mRippleManager == null) mRippleManager = new RippleManager();
//    }
//  }
//
//  return mRippleManager;
//}

//@Override protected void onDetachedFromWindow() {
//  super.onDetachedFromWindow();
//  RippleManager.cancelRipple(this);
//}

//@Override public void setOnClickListener(OnClickListener l) {
//  RippleManager rippleManager = getRippleManager();
//  if (l == rippleManager) {
//    super.setOnClickListener(l);
//  } else {
//    rippleManager.setOnClickListener(l);
//    setOnClickListener(rippleManager);
//  }
//}

//@Override public boolean onTouchEvent(MotionEvent event) {
//  boolean result = super.onTouchEvent(event);
//  return getRippleManager().onTouchEvent(this, event) || result;
//}
//}
