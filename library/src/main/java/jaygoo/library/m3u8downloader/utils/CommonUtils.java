package jaygoo.library.m3u8downloader.utils;

import android.util.Log;

import java.util.Map;
import java.util.Set;

public class CommonUtils {
    public static void log(Object... objects) {
        log2("djjtest", objects);
    }

    public static void log(Map map) {
        Set<Map.Entry> set = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : set) {
            sb.append(entry.getKey()).append(" :").append(entry.getValue()).append(";");
        }
        log2("djjtest", sb.toString());
    }

    public static void log2(String TAG, Object... objects) {

        if (objects == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Throwable a = new Throwable();
        StackTraceElement[] traceElement = a.getStackTrace();
        sb.append(" \n╔═════════════════════════════════");
        sb.append("\n║➨➨at ");
        sb.append(traceElement[1]);
        sb.append("\n║➨➨➨➨at ");
        sb.append(traceElement[2]);
        sb.append("\n╟───────────────────────────────────\n");
        sb.append("║");
        for (Object o : objects) {
            if (o != null) {
                sb.append(o.toString());
            } else {
                sb.append("null");
            }
            sb.append("___");
        }
        sb.append("\n╚═════════════════════════════════");
        Log.e(TAG, sb.toString());
    }
    public static void logStackTrace(Object... objects) {

        if (objects == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Throwable a = new Throwable();
        sb.append(" \n╔═════════════════════════════════");
        String jiantou = "";
        for (StackTraceElement traceElement1 : a.getStackTrace()) {
            jiantou = jiantou + "➨";
            sb.append("\n║");
            sb.append(jiantou);
            sb.append("at ");
            sb.append(traceElement1);
        }
        sb.append("\n╟───────────────────────────────────\n");
        sb.append("║");
        for (Object o : objects) {
            if (o != null) {
                sb.append(o.toString());
            } else {
                sb.append("null");
            }
            sb.append("___");
        }
        sb.append("\n╚═════════════════════════════════");
        Log.e("djjtest", sb.toString());
    }
}
