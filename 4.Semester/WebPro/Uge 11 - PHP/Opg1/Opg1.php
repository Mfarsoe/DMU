<?php

$filnavn = "Opg1.txt";

// Tjekker om filen findes
if (file_exists($filnavn)) {
    // Åbner filen til læsning ("r" står for readonly)
    $fil = fopen($filnavn, "r");

    // Kører så længe der er flere linjer i filen
    while (($linje = fgets($fil)) !== false) {
        // Udskriver linjen
        echo $linje;
    }

    // Lukker filen igen
    fclose($fil);
} else {
    echo "Fejl: Filen '$filnavn' blev ikke fundet.";
}
