package com.telan.numbergame.event.processer;

import com.alibaba.fastjson.JSONObject;
import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.enums.SocketMsgType;
import com.telan.numbergame.enums.WeErrorCode;
import com.telan.numbergame.game.param.OperateGameParam;
import com.telan.numbergame.manager.MemSessionManager;
import com.telan.numbergame.param.BaseRequestData;
import com.telan.numbergame.param.BaseResponseData;
import com.telan.numbergame.param.GameBaseRequest;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WeResultSupport;
import com.telan.numbergame.utils.ResponseMapUtils;
import com.telan.numbergame.utils.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseProcessor implements EventProcessor {
	private static Logger LOGGER = LoggerFactory.getLogger(BaseProcessor.class);

	@Autowired
	private MemSessionManager memSessionManager;

	public BaseResponseData processRequest(BaseRequestData requestMessage) {
		LOGGER.debug("requestMessage={}", JSONObject.toJSONString(requestMessage));

		// 消息类型
		SocketMsgType msgType = SocketMsgType.valueOfCode(requestMessage.getMsgType());

		// 通过sessionId获取UserDO
		String thirdSessionKey = requestMessage.getSessionId();
		UserDO userDO = memSessionManager.getUser(thirdSessionKey);
		if(userDO == null) {
			WeResultSupport resultSupport = new WeResultSupport();
			resultSupport.setErrorCode(WeErrorCode.WEIXIN_LOGIN_ERROR);
			return ResponseMapUtils.getFailResponse(resultSupport);
		}
//		LOGGER.debug("response={}",JSONObject.toJSONString(responseData));
		return null;
	}

}
