package com.daelim.survey;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class SurveyNextButton implements View.OnClickListener {

    Class<?> anyClass = null;
    Context packageContext = null;


    public SurveyNextButton(Context packageContext, Class<?> anyClass) {
        this.packageContext = packageContext;
        this.anyClass = anyClass;
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(packageContext,anyClass);
        packageContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        // 인텐트에 태스크 추가
    }

}
