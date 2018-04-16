package campusRecycle.util;

import java.util.Arrays;
import java.util.Optional;

public class OptionalUtils {
    @SafeVarargs
    public static <T> Optional<T> or(Optional<T> ... optionals) {
        return Arrays.stream(optionals)
                .filter(Optional::isPresent)
                .findFirst()
                .orElse(Optional.empty());
    }
}
