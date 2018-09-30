package com.telan.weixincenter.controller;

import com.alibaba.fastjson.JSON;
import com.telan.numbergame.domain.GameDO;
import com.telan.numbergame.manager.GameManager;
import com.telan.weixincenter.annotation.LoginRequired;
import com.telan.weixincenter.event.EventAcceptor;
import com.telan.weixincenter.manager.WxSessionManager;
import com.telan.numbergame.utils.ResponseMapUtils;
import com.telan.weixincenter.utils.SpringHttpHolder;
import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.game.domain.*;
import com.telan.numbergame.game.param.CreateGameParam;
import com.telan.numbergame.game.param.OperateGameParam;
import com.telan.numbergame.manager.UserManager;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WeResultSupport;
import com.telan.numbergame.utils.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/numbergame")
@LoginRequired
public class GameController {
	private final static Logger LOGGER = LoggerFactory.getLogger(GameController.class);
	@Autowired
	private EventAcceptor eventAcceptor;
	@Autowired
	private UserManager userManager;
	@Autowired
	private GameManager gameManager;
//	@Autowired
//	private WeixinApiUrlHolder weixinApiUrlHolder;
	@Autowired
	private WxSessionManager wxSessionManager;

	@RequestMapping(value = "/test", method=RequestMethod.GET )
	public void hello() throws IOException
	{
		HttpServletResponse response = SpringHttpHolder.getResponse();
		PrintWriter out = response.getWriter();

		out.print("hello");
		out.close();
		out = null;
	}

	@ResponseBody
	@RequestMapping(value = "/finishGame", method=RequestMethod.POST )
	@LoginRequired
	public Map joinGame(@RequestBody OperateGameParam param, ModelMap modelMap) throws IOException
	{
		Map map = new HashMap();
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/updateProgress", method=RequestMethod.POST )
	@LoginRequired
	public Map updateProgress(@RequestBody OperateGameParam param, ModelMap modelMap) throws IOException
	{

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/startGame", method=RequestMethod.POST )
	@LoginRequired
	public Map startGame(long gameId, ModelMap modelMap) throws IOException
	{
		Map map = new HashMap();
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/quitGame", method=RequestMethod.POST )
	@LoginRequired
	public Map quitGame(@RequestBody OperateGameParam param, ModelMap modelMap) throws IOException
	{
		Map map = new HashMap();
		return map;
	}
}
