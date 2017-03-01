package feicui.edu.assetsmy.activity;

import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
//别忘了加权限
public class ExternalStorageUtils {
    static StringBuilder sb = null;

    static String readFileFromExteranlStorage() {//别忘了加权限
        InputStream is = null;
        StringBuilder sb = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || !Environment
                .isExternalStorageRemovable()) {//判断文件是否加载
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "mextranl" +
                    File.separator + "extranl.txt");//获取文件外存根目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                is = new FileInputStream(file);
                BufferedInputStream buffer = new BufferedInputStream(is);
                sb = new StringBuilder();
                byte[] bt = new byte[1024];
                while (buffer.read(bt) != -1) {
                    String str = new String(bt);
                    sb.append(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    static void writeFileFromExtranlStorage() {
        OutputStream os = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "mextranl" +
                    File.separator + "extranl.txt");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os = new FileOutputStream(file, true);
                    os.write("jiayouba!!!".getBytes());
                    os.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        os.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}

