package WEB;

/**
 * Created by wissy on 2015/12/3.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络爬虫
 * 用来爬取一个站点的文件
 */
public class WebCrawler {
    public boolean webCrawler(URL url, String fileName) {
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        URLConnection urlConnection = null;
        try {
            urlConnection = url.openConnection();
        } catch (IOException e) {
            System.out.println("打开网页链接失败,检查网址是否正确");
        }
        try {
            fileOutputStream = new FileOutputStream(fileName);
            inputStream = urlConnection.getInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            fileOutputStream.write(b);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("写入文件失败!!");
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        WebCrawler webCrawler = new WebCrawler();
        webCrawler.webCrawler(new URL("http://www.baidu.com"), "aa/aa.html");
    }
}
