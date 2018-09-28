package com.telan.numbergame.event.processer;

import org.springframework.context.ApplicationContext;

public interface ProcessorMatcher {
	public EventProcessor match(String toUserName, ApplicationContext applicationContext);
}
