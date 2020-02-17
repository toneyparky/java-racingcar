package racingcar.Util;

import java.util.*;

/**
 * 클래스 이름 : RandomNumberUtils.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */

public class RandomNumberUtils {
	private static List<Integer> numbers = new ArrayList<>(
			Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
	);

	private RandomNumberUtils() {
	}

	public static int createRandomNumber() {
		Collections.shuffle(numbers);
		return numbers.get(0);
	}
}
