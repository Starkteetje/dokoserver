package doko.database.game;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rounds")
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private Long player1;

	@Column(nullable = false)
	private Long score1;

	@Column(nullable = false)
	private Long player2;

	@Column(nullable = false)
	private Long score2;

	@Column(nullable = false)
	private Long player3;

	@Column(nullable = false)
	private Long score3;

	@Column(nullable = false)
	private Long player4;

	@Column(nullable = false)
	private Long score4;

	@Column(nullable = false)
	private Long submitted;

	@Column(nullable = false)
	private Long gameId;

	@Column(nullable = false)
	private Long gameRoundId;

	public Round(Long player1, Long score1, Long player2, Long score2, Long player3, Long score3, Long player4,
			Long score4, Long submitted, Long gameId, Long gameRoundId) {
		this.player1 = player1;
		this.score1 = score1;
		this.player2 = player2;
		this.score2 = score2;
		this.player3 = player3;
		this.score3 = score3;
		this.player4 = player4;
		this.score4 = score4;
		this.submitted = submitted;
		this.gameId = gameId;
		this.gameRoundId = gameRoundId;
		// TODO validate
	}

	public Round(String player1, String score1, String player2, String score2, String player3, String score3,
			String player4, String score4, Long submitted, String gameId, String gameRoundId) {
		this(new Long(player1), new Long(score1), new Long(player2), new Long(score2),
				new Long(player3), new Long(score3), new Long(player4), new Long(score4),
				submitted, new Long(gameId), new Long(gameRoundId));
	}

	public Round() {
	}

	public List<Long> getPlayerIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(player1);
		ids.add(player2);
		ids.add(player3);
		ids.add(player4);
		ids.sort(null);
		return ids;
	}

	public List<Long> getScores() {
		List<Long> ids = getPlayerIds();
		List<Long> scores = new ArrayList<>();
		for (Long playerId : ids) {
			scores.add(getScoreOf(playerId));
		}
		return scores;
	}

	private Long getScoreOf(Long playerId) {
		if (playerId.equals(player1)) {
			return score1;
		} else if (playerId.equals(player2)) {
			return score2;
		} else if (playerId.equals(player3)) {
			return score3;
		} else if (playerId.equals(player4))
			return score4;
		return null;
	}
}