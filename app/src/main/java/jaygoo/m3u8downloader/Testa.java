package jaygoo.m3u8downloader;

import java.net.URI;

class Testa {

    public static void main(String[] a) {
        String s1 = "http://static.jystarfod.com/group1/M00/60/E4/";
        String s2 = "/group1/M00/60/DF/b0QEkl8hKTOAZ2AVACjxwIJpN9o3692.ts";
        URI uri=URI.create(s1);
        System.out.println(test(s1, s2));
       String[] ss= s1.split(uri.getHost());

        for(String s:ss){
            System.out.println(s);
        }
    }

    private static String test(String s1, String s2) {


        return s1 + s2;
    }
}
