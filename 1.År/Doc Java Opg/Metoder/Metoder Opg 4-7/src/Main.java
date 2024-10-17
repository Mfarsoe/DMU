public class Main {
    public static void main(String[] args) {
        stjerneLinie();
        stjerneLinie(20);
        tegnLinie(20, "#");

    }

    public static void stjerneLinie() {
        int AntalStjerner = 20;

        tegnLinie(AntalStjerner, "*");
    }
    public static void stjerneLinie(int x) {
        tegnLinie(x, "*");
    }
    public static void tegnLinie(int x, String y) {
        for (int i = 0; i < x; i++) {
            System.out.print(y);
        }
        System.out.println();
    }
}
//OPGAVE 7
//Er det muligt at have de to metoder fra opgave 4 og 5 i samme program? - forklar!
//Ja, pga overloading.
//Lav ændringer i de tre metoder så det samlede program bliver kortest muligt (hint: Brug metoder, der kalder metoder).
//Ok