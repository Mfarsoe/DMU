public class PengeKasse {
    private int tyvere, tiere, femmere, toere, enere;



    // Default Constructors
    public PengeKasse() {
        set(1, 0);
        set(2, 0);
        set(5, 0);
        set(10, 0);
        set(20, 0);
    }

    // Copy Constructor
    public PengeKasse(PengeKasse other) {
        tyvere = other.tyvere;
        tiere = other.tiere;
        femmere = other.femmere;
        toere = other.toere;
        enere = other.enere;
    }

    // toString
    public String toString() {
        return "[20:" + tyvere + "] [10:" + tiere + "] [5:" + femmere + "] [2:" + toere + "] [1:" + enere + "]";
    }

    // Set Method
    public void set(int Enhed, int antal) {
        switch (Enhed) {
            case 1:
                enere = antal;
                break;
            case 2:
                toere = antal;
                break;
            case 5:
                femmere = antal;
                break;
            case 10:
                tiere = antal;
                break;
            case 20:
                tyvere = antal;
                break;
            default:
                break;
        }
    }

    // Sum
    public int sum() {
        return tyvere * 20 + tiere * 10 + femmere * 5 + toere * 2 + enere;
    }

    // Get method
    public int get(int Pålydende) {
        switch (Pålydende) {
            case 1:
                return enere;
            case 2:
                return toere;
            case 5:
                return femmere;
            case 10:
                return tiere;
            case 20:
                return tyvere;
            default:
                return 0;
        }
    }
    public boolean equals(PengeKasse other) {
        return this.enere == other.enere &&
               this.toere == other.toere &&
               this.femmere == other.femmere &&
               this.tiere == other.tiere &&
               this.tyvere == other.tyvere;
    }

    public void add(PengeKasse other) {
        this.enere += other.enere;
        this.toere += other.toere;
        this.femmere += other.femmere;
        this.tiere += other.tiere;
        this.tyvere += other.tyvere;

        other.clear();
    }

    public void clear() {
        enere = 0;
        toere = 0;
        femmere = 0;
        tiere = 0;
        tyvere = 0;
    }
    //Returnere Pengekasse med antal mønter i, med størte mønt.
    // Gør vi ved modulus vores beløb for at se hvor mange gange beløbet går op i vores enheder,
    // hvorefter vi tilføjer det til vores returKasse instans. Derefter trækker vi vores nye varaible fra vores beløb.
    public PengeKasse givTilbage (int beløb) {
        PengeKasse returKasse = new PengeKasse();
        while (beløb > 0) {
            returKasse.set(20, beløb%20);
            beløb -= returKasse.tyvere*20;

            returKasse.set(10, beløb%10);
            beløb -= returKasse.tiere*10;

            returKasse.set(5, beløb%5);
            beløb -= returKasse.femmere*5;

            returKasse.set(2, beløb%2);
            beløb -= returKasse.toere*2;

            if (beløb > enere) {
                add(returKasse);
                return null;
            } else {
                    returKasse.set(1, enere);
                    beløb -= returKasse.enere;
                }

            }
        return returKasse;
    }
}
