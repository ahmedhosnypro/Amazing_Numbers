import java.util.HashSet;
import java.util.Optional;
import java.util.function.LongPredicate;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

import static java.lang.Character.getNumericValue;

public enum NumberProperty implements LongPredicate {
    EVEN(x -> x % 2 == 0),
    ODD(x -> x % 2 != 0),
    BUZZ(x -> x % 7 == 0 || x % 10 == 7),
    DUCK(number -> digits(number).anyMatch(digit -> digit == 0)),
    PALINDROMIC(number -> {
        final var digits = String.valueOf(number);
        return new StringBuilder(digits).reverse().toString().equals(digits);
    }),
    GAPFUL(number -> number >= 100 &&
            number % (getNumericValue(String.valueOf(number).charAt(0)) * 10L + number % 10) == 0),
    SPY(x -> digits(x).sum() == digits(x).reduce(1L, (a, b) -> a * b)),
    SQUARE(number -> pow((long) Math.sqrt(number), 2) == number),
    SUNNY(number -> NumberProperty.SQUARE.test(number + 1)),
    JUMPING(number -> {
        for (long previous = number % 10, rest = number / 10; rest > 0; rest /= 10) {
            long current = rest % 10;
            long delta = previous - current;
            if (delta * delta != 1) {
                return false;
            }
            previous = current;
        }
        return true;
    }),
    HAPPY(NumberProperty::isHappy),
    SAD(number -> !isHappy(number));

    private final LongPredicate hasProperty;
    private final Pattern pattern = Pattern.compile(
            name() + "\\s*[:-]\\s*(?<value>true|false)",
            Pattern.CASE_INSENSITIVE
    );

    NumberProperty(LongPredicate hasProperty) {
        this.hasProperty = hasProperty;
    }

    private static LongStream digits(long number) {
        return Long.toString(number).chars().mapToLong(Character::getNumericValue);
    }

    @Override
    public boolean test(long number) {
        return hasProperty.test(number);
    }

    public Optional<Boolean> extractValue(String output) {
        final var matcher = pattern.matcher(output);
        final var isFound = matcher.find();
        return Optional
                .ofNullable(isFound ? matcher.group("value") : null)
                .map(Boolean::valueOf);
    }

    public static long pow(long n, long p) {
        long result = 1;
        for (long i = p; i > 0; --i) {
            result *= n;
        }
        return result;
    }

    private static boolean isHappy(long number) {
        final var sequence = new HashSet<Long>();
        return LongStream
                .iterate(number, i -> !sequence.contains(i), NumberProperty::happyNext)
                .peek(sequence::add)
                .anyMatch(i -> i == 1);
    }

    private static long happyNext(long number) {
        long result = 0;
        for (long i = number; i > 0; i /= 10) {
            int digit = (int) (i % 10);
            result += digit * digit;
        }
        return result;
    }
}
