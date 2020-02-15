package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Domain.Car;
import racingcar.Domain.TrialTime;
import racingcar.Util.RandomNumberUtils;
import racingcar.Util.StringUtils;
import racingcar.View.InputView;
import racingcar.View.OutputView;

/**
 * 클래스 이름 : Game.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Game {
	private static final int INDEX_START = 0;
	private static final int COMPARING_START_INDEX = 1;

	private static List<Car> cars = new ArrayList<>();
	private static TrialTime trialTime = null;

	public static void initialize() {
		String inputCarName = InputView.inputCarName();
		List<String> carNames =  StringUtils.splitCarNames(inputCarName);
		carNames = StringUtils.trimCarNames(carNames);
		carNames.forEach(carName -> cars.add(new Car(carName)));
		int inputTrialTime = InputView.inputTrialTime();
		trialTime = new TrialTime(inputTrialTime);
	}

	public static void race() {
		OutputView.printResultMessage();
		for (int index = INDEX_START, end = trialTime.getTrialTime(); index < end; index++) {
			raceOneRound();
			OutputView.printNewLine();
		}
	}

	private static void raceOneRound() {
		for (Car car : cars) {
			car.goOrNot(RandomNumberUtils.createRandomNumber());
			car.showCurrentPosition();
		}
	}

	public static void showWinner() {
		Car topPositionCar = findTopPositionCar(cars);
		cars.forEach(topPositionCar::findWinners);
		OutputView.printWinners(topPositionCar.getWinners());
	}

	public static Car findTopPositionCar(final List<Car> cars) {
		Car winner = cars.get(0);
		int carSize = cars.size();
		if (carSize == 1) {
			return winner;
		}
		for (int index = COMPARING_START_INDEX; index < carSize; index++) {
			if (!winner.comparePosition(cars.get(index))) {
				winner = cars.get(index);
			}
		}
		return winner;
	}

}
