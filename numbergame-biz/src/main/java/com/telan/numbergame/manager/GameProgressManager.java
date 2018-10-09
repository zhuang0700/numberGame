package com.telan.numbergame.manager;

import com.telan.numbergame.domain.GameProgressDO;
import com.telan.numbergame.enums.BaseStatus;
import com.telan.numbergame.enums.WeErrorCode;
import com.telan.numbergame.game.enums.GameStatus;
import com.telan.numbergame.mapper.GameProgressDOMapper;
import com.telan.numbergame.query.GamePageQuery;
import com.telan.numbergame.query.GameProgressPageQuery;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WePageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenliang on 15/11/3.
 *
 */
public class GameProgressManager {
	@Autowired
	private GameProgressDOMapper gameProgressDOMapper;

	private final static Logger log	= LoggerFactory.getLogger(GameProgressManager.class);

//	public Map<Long, GameInfo> batchQueryGameInfo(GamePageQuery gamePageQuery, GameQueryOption queryOption) {
//		List<GameProgressDO> gameProgressDOList = gameProgressDOMapper.pageQuery(gamePageQuery);
//		Map<Long, GameInfo> gameInfoMap = GameConvertor.convertGameInfoMap(gameProgressDOList);
//
//		return gameInfoMap;
//	}

	public WePageResult<GameProgressDO> batchQueryGameProgressDO(GameProgressPageQuery gameProgressPageQuery) {
		List<GameProgressDO> gameProgressDOList = gameProgressDOMapper.pageQuery(gameProgressPageQuery);
		WePageResult<GameProgressDO> gameProgressDOWePageResult = new WePageResult<>();
		gameProgressDOWePageResult.setList(gameProgressDOList);
		return gameProgressDOWePageResult;
	}

	public WeBaseResult<GameProgressDO> getGameById(long id) {
		WeBaseResult<GameProgressDO> result = new WeBaseResult<GameProgressDO>();
		if (id <= 0) {
			result.setErrorCode(WeErrorCode.PARAM_ERROR);
			return result;
		}
		try {
			GameProgressDO gameProgressDO = gameProgressDOMapper.selectByPrimaryKey(id);
			result.setValue(gameProgressDO);
		} catch (Exception e) {
			log.error("gameProgressDOMapper.selectByPrimaryKey(id); exception " + id, e);
			result.setErrorCode(WeErrorCode.READ_DB_ERROR);
		}
		return result;
	}

	public Boolean updateGameById(GameProgressDO gameProgressDO) {
		try {
			int c = gameProgressDOMapper.updateByPrimaryKeySelective(gameProgressDO);
			return c == 1;
		} catch (Exception e) {
			log.error("int c = gameProgressDOMapper.updateByPrimaryKey(gameProgressDO); exception,gameProgressDO:" + gameProgressDO, e);
		}
		return false;
	}

	public Boolean deleteGameById(GameProgressDO gameProgressDO) {
		try {
			if (gameProgressDO.getStatus() == BaseStatus.DELETED.getType())
				return true;
			gameProgressDO.setStatus(BaseStatus.DELETED.getType());
			int c = gameProgressDOMapper.deleteByPrimaryKey(gameProgressDO.getId());
			return c == 1;
		} catch (Exception e) {
			log.error("gameProgressDOMapper.updateByPrimaryKey(gameProgressDO); exception,gameProgressDO:" + gameProgressDO, e);
		}
		return false;
	}

	public GameProgressDO insertGame(GameProgressDO gameProgressDO) {
		gameProgressDO.setStatus(GameStatus.CREATE.getType());
		Date now = new Date();
		gameProgressDO.setGmtCreated(now);
		gameProgressDO.setGmtModified(now);
		int row = gameProgressDOMapper.insert(gameProgressDO);
		return gameProgressDO;
	}

}
