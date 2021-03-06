/*
 * Copyright (c) 2015 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.patternlock;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import me.zhanghai.patternlock.internal.ConfirmPatternActivityDelegate;

// For AOSP implementations, see:
// https://android.googlesource.com/platform/packages/apps/Settings/+/master/src/com/android/settings/ConfirmLockPattern.java
// https://android.googlesource.com/platform/frameworks/base/+/43d8451/policy/src/com/android/internal/policy/impl/keyguard/KeyguardPatternView.java
// https://android.googlesource.com/platform/frameworks/base/+/master/packages/Keyguard/src/com/android/keyguard/KeyguardPatternView.java
public class ConfirmPatternActivity extends Activity implements ConfirmPatternActivityDelegate.Receiver {

    public static final int RESULT_FORGOT_PASSWORD = ConfirmPatternActivityDelegate.RESULT_FORGOT_PASSWORD;

    protected ConfirmPatternActivityDelegate delegate = new ConfirmPatternActivityDelegate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegate.onCreate(this, this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        delegate.onSaveInstanceState(outState);
    }

    @Override
    public boolean isStealthModeEnabled() {
        return delegate.defaultIsStealthModeEnabled();
    }

    @Override
    public boolean isPatternCorrect(List<PatternView.Cell> pattern) {
        return delegate.defaultIsPatternCorrect(pattern);
    }

    @Override
    public void onForgotPassword() {
        delegate.defaultOnForgotPassword();
    }

    @Override
    public void onCancel() {
        delegate.defaultOnCancel();
    }

    @Override
    public void onConfirmed() {
        delegate.defaultOnConfirmed();
    }
}
