package com.wechat.parent.cd_token;//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;


public class HttpApiClient_UAT extends ApacheHttpClient{
    public final static String HOST = "uat.openapi.any-call.com";
    static HttpApiClient_UAT instance = new HttpApiClient_UAT();
    public static HttpApiClient_UAT getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public ApiResponse token(String userName , String password) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , true);
        request.addParam("password" , password , ParamPosition.QUERY , true);

        return sendSyncRequest(request);
    }
}