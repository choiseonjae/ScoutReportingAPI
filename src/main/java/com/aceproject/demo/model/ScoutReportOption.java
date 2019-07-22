package com.aceproject.demo.model;

import java.util.function.Predicate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoutReportOption {

	private String teamCode;
	private boolean costUp;

	private static final int OPTION_DEFAULT_AP = 50;
	private static final int OPTION_ONE_AP = 100;
	private static final int OPTION_TWO_AP = 150;
	public static final int COST_UP = 5;

	// 옵션 선택 x
	public static final ScoutReportOption DEFAULT_OPTION = new ScoutReportOption(null, false);

	public ScoutReportOption(String teamCode, boolean costUp) {
		this.teamCode = teamCode;
		this.costUp = costUp;
	}

	
	// TODO option 이 할일을 option이 해결 -> 객체 지향
	public int getAp() {
		// 차감 시 필요한 ap 계산
		int refreshtAp = OPTION_ONE_AP;

		// cost up, 특정 teamCode 필터 -> 150
		// cost up x, 특정 teamCode 필터 x -> 50
		if (isCostUp() && getTeamCode() != null)
			refreshtAp = OPTION_TWO_AP;
		else if (!isCostUp() && getTeamCode() == null)
			refreshtAp = OPTION_DEFAULT_AP;

		return refreshtAp;
	}

	// filter 사용
	public Predicate<Player> getFilter() {
		if (teamCode != null && costUp)
			return p -> p.getTeamCode().equals(teamCode) && p.getCost() >= COST_UP;
		else if (teamCode != null)
			return p -> p.getTeamCode().equals(teamCode);
		else if (costUp)
			return p -> p.getCost() >= COST_UP;
		return null;
	}

}
