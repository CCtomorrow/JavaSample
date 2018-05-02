package com.qy.wxparser;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/5/2 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class DataIndexStruct {

    /**
     * 文件名长度
     */
    public int nameLen;
    /**
     * 文件名
     */
    public String name;
    /**
     * 文件在数据段中偏移值
     */
    public int dataOffset;
    /**
     * 文件的数据长度
     */
    public int dataLen;

    public DataIndexStruct() {
        nameLen = 0;
        name = null;
        dataOffset = 0;
        dataLen = 0;
    }

    public int getLen() {
        return 4 + nameLen + 4 + 4;
    }
}
