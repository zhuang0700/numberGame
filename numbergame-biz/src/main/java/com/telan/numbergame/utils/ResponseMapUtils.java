package com.telan.numbergame.utils;

import com.telan.numbergame.param.BaseResponseData;
import com.telan.numbergame.result.WeResultSupport;

import java.util.HashMap;
import java.util.Map;


public class ResponseMapUtils {
	public static Map convertWeResultSupportToMap(WeResultSupport result) {
		Map map = new HashMap();
		map.put("status", result.isSuccess()?1:0);
		map.put("msg", result.getResultMsg());
		map.put("code", result.getErrorCode());
		return map;
	}

	public static BaseResponseData getFailResponse(WeResultSupport resultSupport) {
		BaseResponseData response = new BaseResponseData();
		response.setStatus(0);
		response.setCode(resultSupport.getErrorCode());
		response.setMsg(resultSupport.getResultMsg());
		return response;
	}

	public static Map getFailResponseMap(WeResultSupport resultSupport) {
		Map map = new HashMap();
		map.put("status", 0);
		map.put("msg", resultSupport.getResultMsg());
		map.put("code", resultSupport.getErrorCode());
		return map;
	}
}