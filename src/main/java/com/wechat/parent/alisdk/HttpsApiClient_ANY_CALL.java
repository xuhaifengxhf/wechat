//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.wechat.parent.alisdk;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

public class HttpsApiClient_ANY_CALL extends ApacheHttpClient{
    public final static String HOST = "openapi.any-call.com";
    static HttpsApiClient_ANY_CALL instance = new HttpsApiClient_ANY_CALL();
    public static HttpsApiClient_ANY_CALL getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }



    public void test(String userName , String reportManTel , String reportMan , String reportTime , String systemNumCode , String repairSource , String faultDescription , String soundUrls , String shopCode , String photographUrls , ApiCallback callback) {
        String path = "/tests/service";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , false);
        request.addParam("reportManTel" , reportManTel , ParamPosition.QUERY , false);
        request.addParam("reportMan" , reportMan , ParamPosition.QUERY , false);
        request.addParam("reportTime" , reportTime , ParamPosition.QUERY , false);
        request.addParam("systemNumCode" , systemNumCode , ParamPosition.QUERY , false);
        request.addParam("repairSource" , repairSource , ParamPosition.QUERY , false);
        request.addParam("faultDescription" , faultDescription , ParamPosition.QUERY , false);
        request.addParam("soundUrls" , soundUrls , ParamPosition.QUERY , false);
        request.addParam("shopCode" , shopCode , ParamPosition.QUERY , false);
        request.addParam("photographUrls" , photographUrls , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
}