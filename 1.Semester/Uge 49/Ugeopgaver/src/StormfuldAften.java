public class StormfuldAften {
    public static void main(String[] args) {
        String text = "Det var en mørk og stormfuld aften.";
        int width = 50;

        //Splitter teksten i ord
        String[] words = text.split(" ");

        //Udregner total mængde af mellemrum vi skal fordele i vores textString
        int totalMellemrum = words.length - 1; //Mellemrum mellem ord i vores text String
        int lengthUdenMellemrum = text.replace(" ", "").length();
        int extraMellemrum = width - lengthUdenMellemrum; // Her har vi så total antal af mellemrum vi skal fordele i mellem ord.

        //Udregner antal mellemrum pr gap mellem ord
        int mellemrumPrGap = extraMellemrum / totalMellemrum; // Vi vil ende med rest så vi skal have modulus for at finde resterende vi skal tilføje
        int mellemrumRest = extraMellemrum % totalMellemrum;

        StringBuilder resultat = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            //Tilføjer ordet i Index i, og tilføjer det til vores resultat
            resultat.append(words[i]);
            //Sikre os at vi ikke tilføjer mellemrum efter sidste ord
            if (i < totalMellemrum) {
                //tilfojMellemrum udregnes.
                //Så længe i er større end mellemrum i rest, tilføjes der et 1 tal til vores tilfojMellemrum udregning
                //altså så længe i < vores rest, tilføjer vi 1, ellers tilføjer vi 0.
                int tilfojMellemrum = mellemrumPrGap + (i < mellemrumRest ? 1 : 0);
                resultat.append(" ".repeat(tilfojMellemrum));
            }
        }


        System.out.println(resultat.toString());
        System.out.println(resultat.length());
    }
}
