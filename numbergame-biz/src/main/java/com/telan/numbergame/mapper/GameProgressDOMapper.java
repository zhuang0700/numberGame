package com.telan.numbergame.mapper;

import com.telan.numbergame.domain.GameProgressDO;
import com.telan.numbergame.query.GameProgressPageQuery;

import java.util.List;

public interface GameProgressDOMapper {
    int deleteByPrimaryKey(long id);

    int insert(GameProgressDO record);

    GameProgressDO selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(GameProgressDO record);

    List<GameProgressDO> pageQuery(GameProgressPageQuery pageQuery);
}