package com.telan.numbergame.event;

import com.telan.numbergame.param.BaseRequestData;
import com.telan.numbergame.param.BaseResponseData;

public interface EventDistributor {
	public BaseResponseData distribute(BaseRequestData eventMsg);
}
