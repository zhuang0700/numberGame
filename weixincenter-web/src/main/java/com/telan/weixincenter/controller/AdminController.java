package com.telan.weixincenter.controller;

import com.alibaba.fastjson.JSON;
import com.telan.weixincenter.annotation.LoginRequired;
import com.telan.weixincenter.event.EventAcceptor;
import com.telan.weixincenter.manager.WxSessionManager;
import com.telan.weixincenter.utils.SpringHttpHolder;
import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.game.domain.ActionResult;
import com.telan.numbergame.game.domain.GameInfo;
import com.telan.numbergame.game.domain.JudgeAction;
import com.telan.numbergame.game.domain.PlayerAction;
import com.telan.numbergame.game.param.CreateGameParam;
import com.telan.numbergame.game.param.OperateGameParam;
import com.telan.numbergame.game.process.GameProcessor;
import com.telan.numbergame.game.vo.UserGameConfig;
import com.telan.numbergame.manager.MemGameManager;
import com.telan.numbergame.manager.UserManager;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WeResultSupport;
import com.telan.numbergame.utils.ResponseMapUtils;
import com.telan.numbergame.utils.SessionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private EventAcceptor eventAcceptor;
	@Autowired
	private GameProcessor gameProcessor;
	@Autowired
	private UserManager userManager;
	@Autowired
	private MemGameManager memGameManager;
	
//	@Autowired
//	private WeixinApiUrlHolder weixinApiUrlHolder;
	@Autowired
	private WxSessionManager wxSessionManager;

	@RequestMapping(value = "/gameInfo", method=RequestMethod.GET )
	public String gameInfo(@RequestParam("id") long id, Model model) throws IOException
	{
		GameInfo gameInfo = memGameManager.getGame(id);
		model.addAttribute("gameInfo", gameInfo);
		System.out.println("admin request gameInfo");
		return "gameInfo";
	}
}
