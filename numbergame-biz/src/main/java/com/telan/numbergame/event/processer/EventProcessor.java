package com.telan.numbergame.event.processer;

import com.telan.numbergame.param.BaseRequestData;
import com.telan.numbergame.param.BaseResponseData;

public interface EventProcessor {
	public BaseResponseData processRequest(BaseRequestData requestMessage);

}
