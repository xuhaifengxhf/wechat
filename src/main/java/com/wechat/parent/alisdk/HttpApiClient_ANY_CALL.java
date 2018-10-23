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


public class HttpApiClient_ANY_CALL extends ApacheHttpClient{
    public final static String HOST = "openapi.any-call.com";
    static HttpApiClient_ANY_CALL instance = new HttpApiClient_ANY_CALL();
    public static HttpApiClient_ANY_CALL getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }


    public void msgPushLog(String templateid , String openid , String msg , ApiCallback callback) {
        String path = "/openapi/createWxmsgPushLog";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
//        request.addParam("idToken" , idToken , ParamPosition.QUERY , false);
        request.addParam("templateid" , templateid , ParamPosition.QUERY , false);
        request.addParam("openid" , openid , ParamPosition.QUERY , false);
        request.addParam("msg" , msg , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }



    /**
     * crateWxUser
     *
//     * @param idToken
     * @param openid
     * @param unionid
     * @param mobileNo
     * @param imageurl
     * @param type
     * @param userid
     * @param callback
     */
    public void crateWxUser( String openid , String unionid , String mobileNo , String imageurl , String type , String userid , ApiCallback callback) {
        String path = "/openapi/createWxUser";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
//        request.addParam("idToken" , idToken , ParamPosition.QUERY , false);
        request.addParam("openid" , openid , ParamPosition.QUERY , false);
        request.addParam("unionid" , unionid , ParamPosition.QUERY , false);
        request.addParam("mobileNo" , mobileNo , ParamPosition.QUERY , false);
        request.addParam("imageurl" , imageurl , ParamPosition.QUERY , false);
        request.addParam("type" , type , ParamPosition.QUERY , false);
        request.addParam("userid" , userid , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }
}