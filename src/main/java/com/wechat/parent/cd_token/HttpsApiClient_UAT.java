//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.wechat.parent.cd_token;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

public class HttpsApiClient_UAT extends ApacheHttpClient{
    public final static String HOST = "uat.openapi.any-call.com";
    static HttpsApiClient_UAT instance = new HttpsApiClient_UAT();
    public static HttpsApiClient_UAT getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }



    public void UAT_获取授权API(String userName , String password , ApiCallback callback) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , true);
        request.addParam("password" , password , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }
}