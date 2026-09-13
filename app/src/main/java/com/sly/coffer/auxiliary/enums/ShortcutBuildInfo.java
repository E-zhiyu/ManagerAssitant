package com.sly.coffer.auxiliary.enums;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.sly.coffer.R;
import com.sly.coffer.ui.pages.main.bookkeeping.RunningAccountInputActivity;
import com.sly.coffer.ui.pages.report.ReportActivity;

import java.util.function.Function;

public enum ShortcutBuildInfo {
    CHECK_REPORT(
            R.string.check_report,
            "check_report",
            R.drawable.outline_table_eye_24,
            context -> {
                Intent intent = new Intent(context, ReportActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                return intent;
            },
            true
    ),
    ADD_RUNNING_ACCOUNT(
            R.string.add_running_account,
            "add_running_account",
            R.drawable.outline_attach_money_24,
            context -> {
                Intent intent = new Intent(context, RunningAccountInputActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                return intent;
            },
            true
    );

    @StringRes
    private final int shortLabelRes;
    private final String id;
    @DrawableRes
    private final int iconRes;
    private final Function<Context, Intent> intentBuilder;
    private final boolean includeParent;

    ShortcutBuildInfo(int shortLabelRes, String id, int iconRes, Function<Context, Intent> intentBuilder, boolean includeParent) {
        this.shortLabelRes = shortLabelRes;
        this.id = id;
        this.iconRes = iconRes;
        this.intentBuilder = intentBuilder;
        this.includeParent = includeParent;
    }

    public int getShortLabelRes() {
        return shortLabelRes;
    }

    public String getId() {
        return id;
    }

    public int getIconRes() {
        return iconRes;
    }

    /**
     * 获取{@link Intent}对象
     *
     * @param context 上下文
     * @return 点击快捷方式后触发的{@link Intent}
     */
    public Intent getIntent(Context context) {
        return intentBuilder.apply(context);
    }

    public boolean isIncludeParent() {
        return includeParent;
    }
}
