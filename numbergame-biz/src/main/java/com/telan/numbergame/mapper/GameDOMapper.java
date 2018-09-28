package com.telan.numbergame.mapper;

import com.telan.numbergame.domain.GameDO;
import com.telan.numbergame.query.GamePageQuery;

import java.util.List;

public interface GameDOMapper {
    int deleteByPrimaryKey(long id);

    int insert(GameDO record);

    GameDO selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(GameDO record);

    List<GameDO> pageQuery(GamePageQuery pageQuery);
}