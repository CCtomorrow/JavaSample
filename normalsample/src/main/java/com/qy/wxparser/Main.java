package com.qy.wxparser;

import java.io.IOException;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/5/2 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class Main {

    static String filename;
    static String dir = "wxapkg/";
    static byte[] wxpkgByteAry;

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Input file path");
//            return;
//        }
//        filename = args[0];
        filename = "/Users/qingyong/Desktop/wx/_-841252585_5.wxapkg";
        try {
            wxpkgByteAry = Utils.getContent(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WxapkgStruct struct = new WxapkgStruct();

        boolean isSuc = struct.parse(wxpkgByteAry);
        if (!isSuc) {
            System.out.println("wxapkg file data error!");
            return;
        }

        for (DataIndexStruct indexStruct : struct.indexStructList) {
            String path = Utils.isSaveFile("/Users/qingyong/Desktop/wx/" + dir + indexStruct.name, Utils.copyByte(wxpkgByteAry, indexStruct.dataOffset, indexStruct.dataLen));
            if (path == null) {
                System.out.println(indexStruct.name + " compress error!");
            } else {
                System.out.println(indexStruct.name + " compress success at " + path);
            }
        }
    }
}
