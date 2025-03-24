public class CascadeThread extends Thread {
    private String navn;
    private boolean myTurn;
    private CascadeThread nextC;



    public CascadeThread(String navn, CascadeThread c) {
        this.navn = navn;
        this.nextC = c;

        this.myTurn = false;
    }

    public void isMyTurn(){
        myTurn = true;
    }

    @Override
    public void run() {
        while (!myTurn)
            Sleeper.nap();
        System.out.println(navn);
        if (nextC != null) {
            nextC.isMyTurn();
        }
    }
}
