package com.KaufLokal.KaufLokalApplication.common.utils;

public class ObjectUtils {

    /**
     * Prüft das der übergebende Parameter nicht Null ist.
     * @param obj das übergebende Objekt
     * @return true bei Null-value; false bei keien Null-value
     */
    public static Boolean isNotNull(Object obj){
        return obj != null;
    }

    /**
     * Prüft das, mehrer der übergebende Parameter nicht Null sind.
     * @param obj1 das übergebende Objekt
     * @param obj2 das übergebende Objekt
     * @return true bei Null-value; false bei keien Null-value
     */
    public static Boolean isNotNull(Object obj1, Object obj2 ){
        return obj1 != null && obj2 != null;
    }
}
