package com.wx.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @Desc:   * 璁㈠崟缂栫爜鐮佺敓鎴愬櫒锛岀敓鎴�32浣嶆暟瀛楃紪鐮侊紝
 * @鐢熸垚瑙勫垯 1浣嶅崟鍙风被鍨�+17浣嶆椂闂存埑+14浣�(鐢ㄦ埛id鍔犲瘑&闅忔満鏁�)
 * @Author HealerJean
 * @Date 2018/8/21  涓嬪崍2:43.
 */
public class OrderCoderUtil {
    /** 璁㈠崟绫诲埆澶� */
    private static final String ORDER_CODE = "D";
    /** 閫�璐х被鍒ご */
    private static final String RETURN_ORDER = "T";
    /** 鎹㈣揣绫诲埆澶� */
    private static final String REFUND_ORDER = "H";
    /** 鏈粯娆鹃噸鏂版敮浠樺埆澶� */
    private static final String AGAIN_ORDER = "4";
    
    /**浜у搧绫诲埆缂栧彿澶� */
    private static final String PRODUCT_TYPE_ORDER = "PT";
    
    /**璇︾粏浜у搧缂栧彿澶� */
    private static final String PRODUCT_INFO_ORDER = "PI";
    
    /** 闅忓嵆缂栫爜 */
    private static final int[] r = new int[]{7, 9, 6, 2, 8 , 1, 3, 0, 5, 4};
    /** 鐢ㄦ埛id鍜岄殢鏈烘暟鎬婚暱搴� */
    private static final int maxLength = 14;
    /**
     * 浜у搧绫诲埆缂栧彿澶�
     * @param userId
     */
    public static String getProductTypeCode(Long userId){
    	return PRODUCT_TYPE_ORDER+ getCode(userId);
    }
    
    /**
     * 浜у搧璇︾粏缂栧彿澶�
     * @param userId
     */
    public static String getProductInfoCode(Long userId){
    	return PRODUCT_INFO_ORDER+ getCode(userId);
    }


    /**
     * 鐢熸垚璁㈠崟鍗曞彿缂栫爜
     * @param userId
     */
    public static String getOrderCode(Long userId){
        return ORDER_CODE + getCode(userId);
    }


    /**
     * 鐢熸垚閫�璐у崟鍙风紪鐮�
     * @param userId
     */
    public static String getReturnCode(Long userId){
        return RETURN_ORDER + getCode(userId);
    }

    /**
     * 鐢熸垚鎹㈣揣鍗曞彿缂栫爜
     * @param userId
     */
    public static String getRefundCode(Long userId){
        return REFUND_ORDER + getCode(userId);
    }

    /**
     * 鏈粯娆鹃噸鏂版敮浠�
     * @param userId
     */
    public static String getAgainCode(Long userId){
        return AGAIN_ORDER + getCode(userId);
    }
    /**
     * 鏇村叿id杩涜鍔犲瘑+鍔犻殢鏈烘暟缁勬垚鍥哄畾闀垮害缂栫爜
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1 ; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i)-'0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }
    /**
     * 鐢熸垚鏃堕棿鎴�
     */
    private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }
    /**
     * 鐢熸垚鍥哄畾闀垮害闅忔満鐮�
     * @param n    闀垮害
     */
    private static long getRandom(long n) {
        long min = 1,max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
        return rangeLong;
    }
    /**
     * 鐢熸垚涓嶅甫绫诲埆鏍囧ご鐨勭紪鐮�
     * @param userId
     */
    private static synchronized String getCode(Long userId){
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }
    public static void main(String[] args){
    	System.out.println();
    }
}
