package ru.lk.task20.obscloudservice.model;


/**
 * This record represents a simple pair of two values, consisting of a first element of type F and a second element of type S.
 * It provides a convenient way to group two values together and retrieve them using the generated accessor methods.
 *
 * @param <F> The type of the first element in the pair.
 * @param <S> The type of the second element in the pair.
 */
public record Pair<F, S>(F first, S second) {

    /**
     * Creates a new Pair object with the specified first and second elements.
     *
     * @param first  The first element of the pair.
     * @param second The second element of the pair.
     * @param <F>    The type of the first element.
     * @param <S>    The type of the second element.
     * @return A new Pair object with the specified elements.
     */
    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair<>(first, second);
    }
}
