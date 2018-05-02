package com.qy.wxparser;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/5/2 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class HeaderStruct {

    public byte magic1;
    public byte magic2;
    public int unknow;
    public int offsetLen;
    public int bodyDataLen;
    /**
     * 这个字段按照wx代码中是属于数据段的，这里为了类操作方便，就放在头部信息中了
     */
    public int fileCount;

    public HeaderStruct() {
        magic1 = 0;
        unknow = 0;
        offsetLen = 0;
        bodyDataLen = 0;
        magic2 = 0;
    }

    public int getLen() {
        return 1 + 4 + 4 + 4 + 1 + 4;
    }

    public boolean isValid() {
        return (-66 == magic1) && (-19 == magic2);
    }
}
