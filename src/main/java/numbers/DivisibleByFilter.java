package numbers;

public class DivisibleByFilter implements GenericListFilter {

    private int divisor;


    public DivisibleByFilter(int divisor) {
        if (divisor !=0){
        this.divisor = divisor;
        }
    }


    @Override
    public boolean accept(Integer number) {

        return number % divisor == 0;

    }
}
