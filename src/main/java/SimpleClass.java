import java.util.Random;

public class SimpleClass {

    public int add(int a, int b){

        return  a + b;
    }

    public int divide(int a, int b){

        return a / b;
    }

    public void exceptionThrow(){
        throw new RuntimeException();
    }

    public int generateRandom(int bound){

        Random random = new Random();

        int result = random.nextInt(bound);

        return result;
    }
}
