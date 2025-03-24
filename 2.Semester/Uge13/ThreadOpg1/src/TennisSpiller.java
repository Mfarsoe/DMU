public class TennisSpiller extends Thread {
    private String navn;
    private boolean harBold;
    private TennisSpiller modstander;


    public TennisSpiller(String navn) {
        this.navn = navn;
        this.harBold = false;
    }

    @Override
    public void run() {
        while (true){
            while (!harBold)
                Sleeper.nap();

            Sleeper.sleepRandom(2);

            if (Math.random() > 0.20) {
                harBold = false;
                System.out.println(navn + " retunere!");

                modstander.modtagBold();
            } else {
                System.out.println(navn + " fumler bolden. Sikken en skandale!");
                break;
            }

        }

    }

    public void setModstander(TennisSpiller modstander) {
        this.modstander = modstander;
    }

    public void modtagBold() {
        harBold = true;
    }



}
