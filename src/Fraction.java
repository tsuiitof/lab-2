class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)
            this.denominator = 1;
        else if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    // Getter для числителя
    public int getNumerator() {
        return numerator;
    }

    // Setter для числителя
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Getter для знаменателя
    public int getDenominator() {
        return denominator;
    }

    // Setter для знаменателя
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            // Если знаменатель равен 0, устанавливаем его в 1
            this.denominator = 1;
        } else if (denominator < 0) {
            // Если знаменатель отрицательный, инвертируем знаки числителя и знаменателя
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
    }
}