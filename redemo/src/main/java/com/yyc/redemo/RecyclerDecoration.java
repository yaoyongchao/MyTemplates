package com.yyc.redemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class RecyclerDecoration extends RecyclerView.ItemDecoration {

    /**
    * RecyclerView的布局方向，默认先赋值为纵向布局
    */
    private int mOrientation = LinearLayoutManager.VERTICAL;

    /**
     * item之间分割线的size默认为 2
     */
    private int mSize = 2;

    /**
     * 绘制item分割线的画笔，和设置其属性
     * 来绘制个性分割线
     */
    private Paint mPaint;
    private Context mContext;
    /**
     * 默认颜色为灰色
     */
    private int mColor = 0xff969696;
    /**
     * @param context     context
     * 默认为纵向布局、灰色、分割线为  2
     */
    public RecyclerDecoration(Context context) {
        this.mContext = context;
        setAttry();
    }

    /**
     * @param context     context
     * @param orientation 布局方向
     */
    public RecyclerDecoration(Context context,int orientation){
        this.mContext = context;
        this.mOrientation = orientation;
        setAttry();
    }

    /**
     * @param context     context
     * @param orientation 布局方向
     * @param color       颜色
     */
    public RecyclerDecoration(Context context, int orientation, int color) {
        this.mContext = context;
        this.mOrientation = orientation;
        this.mColor = color;
        setAttry();
    }

    /**
     * @param context     context
     * @param orientation 布局方向
     * @param color       颜色
     * @param mItemSize   item之间分割线的size
     */
    public RecyclerDecoration(Context context, int orientation, int color, int mItemSize) {
        this.mContext = context;
        this.mOrientation = orientation;
        this.mSize = mItemSize;
        this.mColor = color;
        setAttry();
    }

    /**
     * 设置属性
     */
    private void setAttry(){
        if (mOrientation != LinearLayoutManager.VERTICAL && mOrientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("LinearLayoutManager error");
        }
        mSize = (int) TypedValue.applyDimension(mSize, TypedValue.COMPLEX_UNIT_DIP, mContext.getResources().getDisplayMetrics());
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
         /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVertical(c, parent);
//        } else {
            drawHorizontal(c, parent);
//        }
    }

    /**
     * 绘制纵向 item 分割线
     * @param canvas canvas
     * @param parent parent
     */
    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mSize;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    /**
     * 绘制横向 item 分割线
     * @param canvas canvas
     * @param parent parent
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mSize;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }
    }

    /**
     * 设置item分割线的size
     * @param outRect outRect
     * @param view    view
     * @param parent  parent
     * @param state   state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        if (mOrientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0,mSize, mSize);
//        } else {
//            outRect.set(0, 0, mSize, 0);
//        }
    }
}