package com.reactnativedevicestatus;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import android.content.Context;
import android.app.KeyguardManager;

@ReactModule(name = DeviceStatusModule.NAME)
public class DeviceStatusModule extends ReactContextBaseJavaModule {
    public static final String NAME = "DeviceStatus";
    private final ReactApplicationContext reactContext;

    public DeviceStatusModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void isDeviceSecure(Promise promise) {
        KeyguardManager km = (KeyguardManager) this.reactContext.getSystemService(Context.KEYGUARD_SERVICE);
        if (km.isKeyguardSecure())
        	promise.resolve(true);
        else
			promise.resolve(false);
    }

}
