package com.qy.reflect;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/2/5 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class IFImpl extends IFParent implements IF {

    @Override
    public void goLogin() {
    }

//    @Override
//    protected void goIngo() {
//        super.goIngo();
//    }

    public void goCenter() {
    }

    private String getName() {
        return "ll";
    }

    protected int getAge() {
        return 18;
    }

}
