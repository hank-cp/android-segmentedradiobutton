/*
 * Copyright (C) 2011 Make Ramen, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.makeramen.segmented;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioGroup;

public class SegmentedRadioGroup extends RadioGroup {

    private int mBackgroundResId = R.drawable.segment_button;
    private int mBackgroundLeftResId = R.drawable.segment_radio_left;
    private int mBackgroundMiddleResId = R.drawable.segment_radio_middle;
    private int mBackgroundRightResId = R.drawable.segment_radio_right;

    public SegmentedRadioGroup(Context context) {
        super(context);
    }

    public SegmentedRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SegmentedRadioGroup);
        mBackgroundResId = a.getResourceId(
                R.styleable.SegmentedRadioGroup_android_background, R.drawable.segment_button);
        mBackgroundLeftResId = a.getResourceId(
                R.styleable.SegmentedRadioGroup_backgroundLeft, R.drawable.segment_radio_left);
        mBackgroundMiddleResId = a.getResourceId(
                R.styleable.SegmentedRadioGroup_backgroundMiddle, R.drawable.segment_radio_middle);
        mBackgroundRightResId = a.getResourceId(
                R.styleable.SegmentedRadioGroup_backgroundRight, R.drawable.segment_radio_right);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        changeButtonsImages();
    }

    private void changeButtonsImages(){
        int count = super.getChildCount();

        if(count > 1){
            super.getChildAt(0).setBackgroundResource(mBackgroundLeftResId);
            for(int i=1; i < count-1; i++){
                super.getChildAt(i).setBackgroundResource(mBackgroundMiddleResId);
            }
            super.getChildAt(count-1).setBackgroundResource(mBackgroundRightResId);
        }else if (count == 1){
            super.getChildAt(0).setBackgroundResource(mBackgroundResId);
        }
    }
}