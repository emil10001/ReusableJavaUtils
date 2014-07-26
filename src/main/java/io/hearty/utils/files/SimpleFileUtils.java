package io.hearty.utils.files;

import java.io.*;

/**
 * Created by ejf3 on 3/9/14.
 */
public class SimpleFileUtils {
    private static final String TAG = "SimpleFileUtils";

    public static String write(String filename, byte[] data) {
        File pictureFile = new File(filename);

        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            fos.write(data);
            fos.close();
            System.out.println(TAG + " New Image saved:" + filename);
        } catch (Exception error) {
            System.out.println(TAG + " File" + filename + "not saved: " + error);
        }
        return filename;
    }

    public static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}
