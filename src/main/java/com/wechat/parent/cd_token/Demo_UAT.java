//
//  Created by  fred on 2016/10/26.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.wechat.parent.cd_token;

import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.wechat.parent.util.VStringUtil;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

public class Demo_UAT {


    static{
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("25075061");
        httpParam.setAppSecret("b69b6d044dae5c5d8bc89e2ca6ecd27a");
        HttpApiClient_UAT.getInstance().init(httpParam);


        //HTTPS Client init
        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
        httpParam.setAppKey("25075061");
        httpParam.setAppSecret("b69b6d044dae5c5d8bc89e2ca6ecd27a");

        /**
        * HTTPS request use DO_NOT_VERIFY mode only for demo
        * Suggest verify for security
        */
        X509TrustManager xtm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] x509Certificates = new X509Certificate[0];
            return x509Certificates;
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
        HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        httpsParam.setSslSocketFactory(sslContext.getSocketFactory());
        httpsParam.setX509TrustManager(xtm);
        httpsParam.setHostnameVerifier(DO_NOT_VERIFY);

        HttpsApiClient_UAT.getInstance().init(httpsParam);


    }

    public static String getTokenHttp(String  loginName,String password){
        String token = "";
        ApiResponse response = HttpApiClient_UAT.getInstance().token(loginName , password);
        Map map1 = VStringUtil.json2map(new String(response.getBody(), SdkConstant.CLOUDAPI_ENCODING));
        if (map1 != null) {
            token = (String) map1.get("data");
        }
        return token;
    }

    public static void getTokenHttps(String  loginName,String password){
        HttpsApiClient_UAT.getInstance().UAT_获取授权API(loginName , password , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }



    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if(response.getCode() != 200){
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody() , SdkConstant.CLOUDAPI_ENCODING));

        return result.toString();
    }
}
