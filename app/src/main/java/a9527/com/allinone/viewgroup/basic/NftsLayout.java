package a9527.com.allinone.viewgroup.basic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 9527 on 2015/12/22.
 */
public class NftsLayout extends ViewGroup {
    public NftsLayout(Context context) {
        super(context);
    }

    public NftsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NftsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 存储所有的View，按行记录
     */
    private List<List<View>> mAllViews = new ArrayList<List<View>>();
    /**
     * 记录每一行的最大高度
     */
    private List<Integer> mLineHeight = new ArrayList<Integer>();

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {




    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * 设置子控件的测量模式和大小，根据所有控件设置自己的大小
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得父容器为子控件设置的测量模式和大小
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //记录wrap_content情况下的宽和高
        int width = 0;
        int height = 0;

        //记录每一行的宽度，不断取最大值
        int lineWidth = 0;
        //每一行的高度，累加
        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            //测量每一个child的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
//当前子控件实际占据的宽度
            int childWith = child.getMeasuredWidth() + mlp.leftMargin + mlp.rightMargin;
            //当前子控件的高度
            int childHeight = child.getMeasuredHeight() + mlp.topMargin + mlp.bottomMargin;
//如果加入当前child,则超出最大宽度，则得到目前最大宽度给width,累加height，然后继续计算下一行
            if (lineWidth + childWith > sizeWidth) {
                width = Math.max(lineWidth, childWith);
                lineWidth = childWith;
                height += lineHeight;
                lineHeight = childHeight;

            } else {//累加lineWidth,lineHeight取最大值
                lineWidth += childWith;
                lineHeight = Math.max(lineHeight, childHeight);

            }
            //如果是最后一个，则将当前记录的最大宽度和当前lineWidth作比较
            if (i == childCount - 1) {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }

        }
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height);
    }
}
