package com.example.phonebook;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class PhoneBookInAndOut {//commonnum.db文件的读取及写入到内存中
    Context mCtx;

    PhoneBookInAndOut(Context context){
        mCtx=context;
    }



    public void PhoneBookRW() {//commonnum.db文件的读取及写入到内存中
        InputStream in;
        File fileOut;
        OutputStream out;
        BufferedInputStream bufferIn = null;
        BufferedOutputStream bufferOut = null;
        try {
            AssetManager ass = mCtx.getAssets();
            in = ass.open("commonnum.db");
            fileOut = new File(mCtx.getFilesDir() + File.separator + "database" + File.separator + "commonnum.db");
            if (!fileOut.getParentFile().exists()) {
                fileOut.getParentFile().mkdirs();
            }
            bufferIn = new BufferedInputStream(in);
            out = new FileOutputStream(fileOut, true);
            bufferOut = new BufferedOutputStream(out);
            byte[] bt = new byte[1024];
            int len = 0;
            while (len != -1) {
                len = bufferIn.read(bt);
                if (len != -1) {
                    bufferOut.write(bt, 0, len);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferIn.close();
                bufferOut.flush();
                bufferOut.close();
            } catch (IOException e) {
            }
        }
    }
}