package com.aceproject.demo.dao;

import java.util.List;

import com.aceproject.demo.model.TeamPlayer;

public interface TeamPlayerDao {
	
	void insert(TeamPlayer teamPlayer);
	
	void update(TeamPlayer teamPlayer);
	
	List<TeamPlayer> list(int teamId);

}