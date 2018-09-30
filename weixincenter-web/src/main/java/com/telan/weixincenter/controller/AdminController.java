package com.telan.weixincenter.controller;

import com.alibaba.fastjson.JSON;
import com.telan.weixincenter.annotation.LoginRequired;
import com.telan.weixincenter.event.EventAcceptor;
import com.telan.weixincenter.manager.WxSessionManager;
import com.telan.numbergame.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private EventAcceptor eventAcceptor;
	@Autowired
	private UserManager userManager;

//	@Autowired
//	private WeixinApiUrlHolder weixinApiUrlHolder;
	@Autowired
	private WxSessionManager wxSessionManager;

	@RequestMapping(value = "/gameInfo", method=RequestMethod.GET )
	public String gameInfo(@RequestParam("id") long id, Model model) throws IOException
	{
		return "";
	}
}
