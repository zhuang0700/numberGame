package com.telan.numbergame.mapper;

import com.telan.numbergame.domain.PlayerDO;
import com.telan.numbergame.game.domain.Player;
import com.telan.numbergame.query.PlayerPageQuery;

import java.util.List;

public interface PlayerDOMapper {
    int deleteByPrimaryKey(long id);

    int insert(PlayerDO record);

    PlayerDO selectByPrimaryKey(long id);

    List<PlayerDO> pageQuery(PlayerPageQuery playerPageQuery);

    int updateByPrimaryKeySelective(PlayerDO record);
}