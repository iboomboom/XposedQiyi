package com.iboomboom.xposedqiyi.hook;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.Field;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookManager {
    private XC_LoadPackage.LoadPackageParam mLoadPackageParam;
    private Context context;

    public HookManager(XC_LoadPackage.LoadPackageParam mLoadPackageParam) {
        this.mLoadPackageParam = mLoadPackageParam;
    }

    public void hook() {
        hookApplication();
    }

    private void hookApplication() {
        XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        context = (Context) param.args[0];
                        if (context.getPackageName().equals("com.qiyi.video")) {
                            final Class<?> aClass = context.getClassLoader().loadClass(HookConfig.CLASS_VIP);
                            hookVip(aClass);
                        }

                    }
                });
    }

    private void hookVip(Class<?> aClass) throws ClassNotFoundException {

        //是否是vip
        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("判断是否是VIP了");
                return true;
            }
        });

        //vip是否过期
        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_VIP_SUSPENDED, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("判断会员是否过期了");
                return true;
            }
        });

        //是否是黄金vip
        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_GOLD_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("判断是否是黄金会员");
                return true;
            }
        });

        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_SILVER_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return true;
            }
        });


        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_TENNIS_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return true;
            }
        });

        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_FUN_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return true;
            }
        });

        //是否是可用VIP
        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_VALID_VIP, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("是否需要VIP");
                return true;
            }
        });



        //VIP是否可用？
        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_IS_VIP_VALID, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("VIP是否可用");
                return true;
            }
        });

        XposedHelpers.findAndHookMethod(aClass, HookConfig.METHOD_BGE, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return true;
            }
        });
    }
}
