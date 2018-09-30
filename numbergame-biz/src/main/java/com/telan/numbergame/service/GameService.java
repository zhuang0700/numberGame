package com.telan.numbergame.service;

import com.telan.numbergame.domain.GameDO;
import com.telan.numbergame.enums.BaseStatus;
import com.telan.numbergame.enums.WeErrorCode;
import com.telan.numbergame.game.enums.GameStatus;
import com.telan.numbergame.game.param.OperateGameParam;
import com.telan.numbergame.manager.GameManager;
import com.telan.numbergame.query.GamePageQuery;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WePageResult;
import com.telan.numbergame.result.WeResultSupport;
import com.telan.numbergame.utils.ResponseMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenliang on 15/11/3.
 *
 */
public class GameService {
	@Autowired
	private GameManager gameManager;

	private final static Logger log	= LoggerFactory.getLogger(GameService.class);

	public WeResultSupport updateGameProgress(OperateGameParam param) {
		WeBaseResult<GameDO> gameDOResult = gameManager.getGameById(param.getGameId());
		if(!gameDOResult.isSuccess() || gameDOResult.getValue() == null) {
			return gameDOResult;
		}
		GameDO gameDO = gameDOResult.getValue();
		if(param.getProgress() != null) {
			gameDO.setProgress(param.getProgress());
		}
	}

}
