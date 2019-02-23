package utils.deck;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Card implements  Comparable{
    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the {@code
     * Comparable} interface and violates this condition should clearly indicate this fact.  The recommended language is
     * "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        Card c = (Card)o;
        int v = this.value.getValue() - c.value.getValue();
        if(v==0){
            return this.suite.ordinal() - c.suite.ordinal();
        }else{
            return v;
        }
    }

    enum Suite {
        SPADE, HEART, DIAMOND, CLUB;
    }

    enum Value {
        ACE(14), TWO(2),
        THREE(3), FOUR(4),
        FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8),
        NINE(9), TEN(10),
        JACK(11),
        QUEEN(12), KING(13);

        private final int value;

        private Value(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }

    Suite suite;
    Value value;

    public Card(Suite suite, Value value) {
        this.suite = suite;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        return (this.suite.ordinal() == ((Card) o).suite.ordinal()
                && this.value.getValue() == ((Card) o).value.getValue());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(suite.ordinal())
                .append(value.getValue())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite.toString() +
                ", value=" + value.toString() +
                '}';
    }
}
