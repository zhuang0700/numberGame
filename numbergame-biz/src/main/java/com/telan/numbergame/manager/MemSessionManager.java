package com.telan.numbergame.manager;

import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.utils.SessionHelper;
import com.telan.numbergame.utils.SessionKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;


public class MemSessionManager {
	private static final Logger logger = LoggerFactory.getLogger("SessionManager");

	public HashMap<String, UserDO> usersMap;

	public UserDO getUser(){
		return getUser(SessionHelper.getSessionKey());
	}

	public MemSessionManager(int initSize) {
		usersMap = new HashMap<>(initSize);
	}
	/**
	 * 将user缓存到tair
	 * @param sessionKey
	 * @param user
	 * @return
	 */
	public String addUser(String sessionKey, UserDO user) {
		user.setSessionKey(sessionKey);
		String numbergameSessionKey = SessionKeyUtil.generateSessionKey();
		usersMap.put(numbergameSessionKey, user);
		return numbergameSessionKey;
	}

	/**
	 * 根据sessionKey获取当前用户信息
	 * @param numbergameSessionKey
	 * @return
	 */
	public UserDO getUser(String numbergameSessionKey) {
		UserDO user = usersMap.get(numbergameSessionKey);
		return user;
	}


}
