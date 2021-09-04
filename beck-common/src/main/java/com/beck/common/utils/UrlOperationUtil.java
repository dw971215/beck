package com.beck.common.utils;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 通过一个url地址下载文件
 * @Author dawei
 * @Date 2021/2/1 11:06
 */
public class UrlOperationUtil {

    public static String downLoad(String orgUrl,String name,HttpServletResponse response) throws IOException {
        if(!orgUrl.startsWith("http://") || !orgUrl.startsWith("https://")){
            return "请校验网络地址是否正确！";
        }
        OutputStream os = null;
        DataInputStream dataInputStream = null;
        try {
            URL url = null;
            url = new URL(orgUrl);
            dataInputStream = new DataInputStream(url.openStream());
            response.reset();
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(name + ".jpg", "utf-8"));
            os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;

            while ((length = dataInputStream.read(buffer)) != -1) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (os != null) {
                os.close();
            }
        }
        return "ok";
    }



    /**
     * 地址与参数进行拼接
     * @param reqUrl
     * @param params
     * @return
     */
    public static String buildReqUrl(String reqUrl, Map<String, String> params) {
        if ((reqUrl == null) || (params == null)) {
            return null;
        }

        String[] reqUrls = reqUrl.split("\\?");

        StringBuilder sp = new StringBuilder();

        sp.append(reqUrls[0]).append("?");

        List<NameValuePair> parameters = new ArrayList<NameValuePair>(params.size());

        for (Map.Entry<String, String> entry : params.entrySet()) {
            parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        sp.append(URLEncodedUtils.format(parameters, Consts.UTF_8));

        return sp.toString();
    }
}
