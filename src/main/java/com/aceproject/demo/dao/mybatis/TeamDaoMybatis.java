package com.aceproject.demo.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.aceproject.demo.dao.TeamDao;
import com.aceproject.demo.model.Team;
import com.aceproject.demo.support.CommonDaoSupport;

@Repository("teamDaoMybatis")
public class TeamDaoMybatis extends CommonDaoSupport implements TeamDao {

	@Override
	public void insert(Team team) {
		getSqlSession().insert("com.aceproject.demo.team.insert", team);
	}

	@Override
	public void update(Team team) {
		getSqlSession().update("com.aceproject.demo.team.update", team);
	}

	@Override
	public Team get(int teamId) {
		return getSqlSession().selectOne("com.aceproject.demo.team.select", teamId);
	}

}
