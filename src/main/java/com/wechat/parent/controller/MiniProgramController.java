package com.wechat.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.wechat.parent.request.course.MemberResponse;
import com.wechat.parent.util.HttpClientUtil;
import com.wechat.parent.util.MiniUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/miniprogram")
public class MiniProgramController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/miniUser", method = RequestMethod.GET)
    public @ResponseBody
    Object miniUser(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        logger.info("getOpenid with code: " + code);

        JSONObject result = new JSONObject();
        result.put("message", "成功");
        JSONObject data = new JSONObject();
        MiniUserInfo miniUserInfo = HttpClientUtil.getMiniUserInfo(code);
        result.put("data", data);
//        String open = RedisManager.get(miniUserInfo.getOpenid());
//        MemberResponse response1 = JsonUtil.parse(open, MemberResponse.class);
//        if (response1 != null) {
//            data.put("user", response1);
//            result.put("status", "0");
//        } else {

//            RedisManager.set(miniUserInfo.getOpenid() + 1, miniUserInfo.getUnionid() == null?"":miniUserInfo.getUnionid());
        MemberResponse response1 = new MemberResponse();
//        response1.setOpenid(miniUserInfo.getOpenid());
        response1.setUnionid(miniUserInfo.getUnionid());
        data.put("user", response1);
        result.put("status", "0");
//        }


        return result;
    }

}
