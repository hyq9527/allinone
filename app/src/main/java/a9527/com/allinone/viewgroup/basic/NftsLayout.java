package a9527.com.allinone.viewgroup.basic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

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

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    /**
     * 设置子控件的测量模式和大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
