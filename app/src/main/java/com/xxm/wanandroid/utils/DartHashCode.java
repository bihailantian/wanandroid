package com.xxm.wanandroid.utils;

public enum DartHashCode {
    A("A", 33620976),
    B("B", 389312086),
    C("C", 111070507),
    D("D", 446117147),
    E("E", 147624326),
    F("F", 507116640),
    G("G", 209213661),
    H("H", 87444056),
    I("I", 326641372),
    J("J", 177411345),
    K("K", 416051588),
    L("L", 216127918),
    M("M", 438285354),
    N("N", 296526659),
    O("O", 229361),
    P("P", 392523444),
    Q("Q", 85969449),
    R("R", 474593404),
    S("S", 176919808),
    T("T", 510459074),
    U("U", 205215839),
    V("V", 62900071),
    W("W", 301278162),
    X("X", 178656563),
    Y("Y", 416248198),
    Z("Z", 238083144);


    // 成员变量
    private String name;
    private int value;

    // 构造方法  
    private DartHashCode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    //    // 普通方法
//    public static String getName(int index) {  
//        for (DartHashCode c : DartHashCode.values()) {  
//            if (c.getIndex() == index) {  
//                return c.name;  
//            }  
//        }  
//        return null;  
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
