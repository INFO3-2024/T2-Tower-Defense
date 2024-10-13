package Game.game.rounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import Game.game.gameActors.Enemy;

public class Rounds {

	private int round = 0;
	private float counterRoundCooldown = 0;
	private static final float roundCooldown = 2;
	private float counterSpawnCooldown = 0;
	private double spawnCooldown = 1;
	private int enemiesInThisRound = 0;

	public Rounds() {

	}

	public void updateSpawnCooldown() {
		counterSpawnCooldown += Gdx.graphics.getDeltaTime();
		counterRoundCooldown += Gdx.graphics.getDeltaTime();
	}

	public int getRound() {
		return round;
	}

	public void spawnMap1Enemies(Array<Actor> listaAtores, int enemiesAlive, int typeMap) {
		if (round == 0) {
			round = 1;
		}
		switch (round) {

		case 1:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				listaAtores.add(new Enemy(0, 615, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 2:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				if (enemiesInThisRound % 2 == 0) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				}
				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 3:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				if (enemiesInThisRound <= 7) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 4:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound % 3 == 2) { // 3
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
				} else if (enemiesInThisRound % 3 == 1) { // 1
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 3,typeMap)); // 2
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		// uma grande horda de zumbis se aproxima
		case 5:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 50) {

				if (enemiesInThisRound < 20) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
				} else if (enemiesInThisRound >= 20 && enemiesInThisRound < 35) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				} else if (enemiesInThisRound >= 35) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
				}

				enemiesInThisRound++;
				System.out.println(enemiesInThisRound);
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 50 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 6:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {

				if (enemiesInThisRound <= 10) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 7:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound <= 28) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 8:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 35) {

				if (enemiesInThisRound <= 15) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
				} else if (enemiesInThisRound > 15 && enemiesInThisRound <= 28) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 35 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 9:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {

				if (enemiesInThisRound <= 5) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
				} else if (enemiesInThisRound > 5 && enemiesInThisRound <= 10) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
				} else if (enemiesInThisRound > 10 && enemiesInThisRound <= 20) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
				} else if (enemiesInThisRound > 20 && enemiesInThisRound <= 30) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
				}

				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}

			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 10:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 100) {

				if (enemiesInThisRound <= 25) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					listaAtores.add(new Enemy(-30, 615, 2,typeMap));
					enemiesInThisRound++;
					enemiesInThisRound++;

				} else if (enemiesInThisRound > 25 && enemiesInThisRound <= 45) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
				} else if (enemiesInThisRound > 45 && enemiesInThisRound <= 60) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
				} else if (enemiesInThisRound > 60) {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;

					counterSpawnCooldown = 0;
				}

				if (enemiesInThisRound == 100 && enemiesAlive == 0) {
					round = 0;
					enemiesInThisRound = 0;
					counterRoundCooldown = 0;
				}
				break;
			}
		}
	}

	public void spawnMap2Enemies(Array<Actor> listaAtores, int enemiesAlive, int typeMap) {

		if (round == 0) {
			round = 1;
		}
		switch (round) {

		case 1:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				listaAtores.add(new Enemy(0, 105, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 2:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				listaAtores.add(new Enemy(0, 105, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 3:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				listaAtores.add(new Enemy(0, 105, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 4:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 5) {

				listaAtores.add(new Enemy(0, 105, 2,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 5 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 5:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				if (enemiesInThisRound < 8) {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 6:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				if (enemiesInThisRound < 6) {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 7:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 11) {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 8:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				if (enemiesInThisRound < 7) {
					listaAtores.add(new Enemy(0, 105, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 9:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 6) {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound >= 6 && enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 105, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 10:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 50) {

				if (enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 105, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 50 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 11:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				listaAtores.add(new Enemy(0, 105, 3,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 12:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {

				listaAtores.add(new Enemy(0, 105, 3,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 13:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {

				if (enemiesInThisRound % 2 == 0) {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 14:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound < 25) {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 15:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 8) {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 16:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {

				if (enemiesInThisRound % 5 == 0 || enemiesInThisRound % 5 == 1) {
					listaAtores.add(new Enemy(0, 105, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound % 5 == 2) {
					listaAtores.add(new Enemy(0, 105, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound % 5 == 3) {
					listaAtores.add(new Enemy(0, 105, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound % 5 == 4) {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 17:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 18:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 35) {

				if (enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 35 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 19:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 35) {

				if (enemiesInThisRound % 5 == 0) {
					listaAtores.add(new Enemy(0, 105, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 105, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 35 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 20:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {

				listaAtores.add(new Enemy(0, 105, 4,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round = 0;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		}

	}

	public void spawnMap3Enemies(Array<Actor> listaAtores, int enemiesAlive, int typeMap) {

		if (round == 0) {
			round = 1;
		}
		switch (round) {
		case 1:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 5) {

				listaAtores.add(new Enemy(0, 650, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 5 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 2:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				listaAtores.add(new Enemy(0, 615, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 3:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				listaAtores.add(new Enemy(0, 615, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 4:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				listaAtores.add(new Enemy(0, 615, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 5:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				listaAtores.add(new Enemy(0, 615, 1,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 6:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 7:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;

		case 8:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 9:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {

				if (enemiesInThisRound % 2 == 1) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 10:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound % 10 == 1) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 11:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound % 10 == 1) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 12:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 10) {

				listaAtores.add(new Enemy(0, 615, 3,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 10 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 13:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				if (enemiesInThisRound % 2 == 1) {
					listaAtores.add(new Enemy(0, 615, 1,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 14:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {

				if (enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 15:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 50) {

				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 2,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound >= 10 && enemiesInThisRound < 25) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else if (enemiesInThisRound >= 25) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 50 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 16:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				listaAtores.add(new Enemy(0, 615, 3,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;
			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 17:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {
				if (enemiesInThisRound < 25) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 18:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {
				if (enemiesInThisRound < 15) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 19:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {
				if (enemiesInThisRound < 6) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 20:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {
				listaAtores.add(new Enemy(0, 615, 4,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 21:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {
				if (enemiesInThisRound % 3 == 1) {
					listaAtores.add(new Enemy(0, 615, 3,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 22:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {
				if (enemiesInThisRound % 15 == 0) {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 23:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 20) {

				listaAtores.add(new Enemy(0, 615, 4,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 20 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 24:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 15) {

				listaAtores.add(new Enemy(0, 615, 5,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 15 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 25:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {
				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 26:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 25) {
				if (enemiesInThisRound % 4 == 0) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 25 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 27:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 30) {
				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 30 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 28:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {
				if (enemiesInThisRound < 10) {
					listaAtores.add(new Enemy(0, 615, 4,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				} else {
					listaAtores.add(new Enemy(0, 615, 5,typeMap));
					enemiesInThisRound++;
					counterSpawnCooldown = 0;
				}

			}
			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 29:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 40) {

				listaAtores.add(new Enemy(0, 615, 5,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 40 && enemiesAlive == 0) {
				round++;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		case 30:

			if (counterRoundCooldown >= roundCooldown && counterSpawnCooldown >= spawnCooldown
					&& enemiesInThisRound < 50) {

				listaAtores.add(new Enemy(0, 615, 5,typeMap));
				enemiesInThisRound++;
				counterSpawnCooldown = 0;

			}
			if (enemiesInThisRound == 50 && enemiesAlive == 0) {
				round=0;
				enemiesInThisRound = 0;
				counterRoundCooldown = 0;
			}
			break;
		}
	}
}
