package com.iboomboom.xposedqiyi.hook;

/**
 * @author DEVIN
 */
public class HookConfig {
    public static final String CLASS_VIP = "org.qiyi.android.coreplayer.utils.b";
    public static final String CLASS_ICommunication="org.qiyi.video.module.icommunication.ICommunication";

    public static final String METHOD_IS_FUN_VIP = "isFunVip";
    public static final String METHOD_IS_PLATINUM_VIP = "isPlatinumVip";

    public static final String METHOD_IS_GOLD_VIP = "isGoldVip";
    public static final String METHOD_IS_SILVER_VIP = "isSilverVip";
    public static final String METHOD_IS_TENNIS_VIP = "isTennisVip";
    public static final String METHOD_IS_VALID_VIP = "isValidVip";
    public static final String METHOD_IS_VIP = "isVip";
    public static final String METHOD_IS_VIP_SUSPENDED = "isVipSuspended";
    public static final String METHOD_IS_VIP_VALID = "isVipValid";
    public static final String METHOD_JO = "jo";
    public static final String METHOD_BGE = "bge";
    public static final String METHOD_GET_DATA_FROM_MODULE ="getDataFromModule";

    public static final String PARAM_MODULE_BEAN = "org.qiyi.video.module.icommunication.ModuleBean";


}
