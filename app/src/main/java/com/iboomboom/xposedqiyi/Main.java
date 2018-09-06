package com.iboomboom.xposedqiyi;

import com.iboomboom.xposedqiyi.hook.HookManager;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * xposed入口
 *
 * @author DEVIN
 */
public class Main implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam)  {
        try {
            HookManager hookManager = new HookManager(lpparam);
            hookManager.hook();
        } catch (Throwable e) {
            XposedBridge.log(e);
        }
    }
}
