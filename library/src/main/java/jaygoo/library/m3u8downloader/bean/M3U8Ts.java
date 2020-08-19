package jaygoo.library.m3u8downloader.bean;

import android.support.annotation.NonNull;

import java.net.URI;

import jaygoo.library.m3u8downloader.utils.MD5Utils;

/**
 * m3u8切片类
 * Created by HDL on 2017/7/24.
 */

public class M3U8Ts implements Comparable<M3U8Ts> {
    private String url;
    private long fileSize;
    private float seconds;

    public M3U8Ts(String url, float seconds) {
        this.url = url;
        this.seconds = seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getSeconds() {
        return seconds;
    }

    public void setSeconds(float seconds) {
        this.seconds = seconds;
    }

    public String obtainEncodeTsFileName() {
        if (url == null) return "error.ts";
        return MD5Utils.encode(url).concat(".ts");
    }

    public String obtainFullUrl(String hostUrl) {
        if (url == null) {
            return null;
        }
        if (url.startsWith("http")) {
            return url;
        } else if (url.startsWith("//")) {
            return "http:".concat(url);
        } else {
            ///http://static.jystarfod.com/group1/M00/60/E4/b0QEkl8hKUKAZ8RKAAClJDHRb4s25.m3u8
            ///group1/M00/60/DF/b0QEkl8hKTOAEA25AAKZYHTznNo3097.ts
            // 这样的相当于只能保留host
            if (url.split("/").length > 2) {
                URI uri = URI.create(hostUrl);
                String[] ss = hostUrl.split(uri.getHost());
                return ss[0].concat(uri.getHost()).concat(url);
            }
            return hostUrl.concat(url);
        }
    }

    @Override
    public String toString() {
        return url + " (" + seconds + "sec)";
    }

    /**
     * 获取时间
     */
    public long getLongDate() {
        try {
            return Long.parseLong(url.substring(0, url.lastIndexOf(".")));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public int compareTo(@NonNull M3U8Ts o) {
        return url.compareTo(o.url);
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
