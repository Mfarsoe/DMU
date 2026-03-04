document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('susForm');
    const resultDiv = document.getElementById('result');
    const scoreValueSpan = document.getElementById('scoreValue');
    const feedbackText = document.getElementById('feedbackText');
    const resetBtn = document.getElementById('resetBtn');

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        let totalScore = 0;
        let allAnswered = true;

        // Loop gennem alle 10 spørgsmål
        for (let i = 1; i <= 10; i++) {
            const questionName = 'q' + i;
            const selectedOption = document.querySelector(`input[name="${questionName}"]:checked`);
            
            if (selectedOption) {
                const value = parseInt(selectedOption.value);
                
                // Da alle spørgsmål i denne SUS er positivt formulerede:
                // Bidrag = (Svarværdi - 1)
                // Eksempel: 5 (Helt enig) giver 4 point. 1 (Helt uenig) giver 0 point.
                
                totalScore += (value - 1);
            } else {
                allAnswered = false;
                alert('Besvar venligst alle spørgsmål før beregning.');
                break; 
            }
        }

        if (allAnswered) {
            // SUS Score beregning: Sum * 2.5
            const finalSusScore = totalScore * 2.5;
            
            // Vis resultat
            scoreValueSpan.textContent = finalSusScore;
            
            // Feedback baseret på score
            let feedback = "";
            if (finalSusScore >= 80.3) {
                feedback = "Fremragende! Brugerne elsker dit system.";
            } else if (finalSusScore >= 68) {
                feedback = "Godt. Dit system er brugervenligt, men kan forbedres.";
            } else if (finalSusScore >= 51) {
                feedback = "Okay, men der er plads til forbedring.";
            } else {
                feedback = "Kritisk. Der er alvorlige brugervenlighedsproblemer.";
            }
            
            feedbackText.textContent = feedback;
            
            // Skjul form og vis resultat
            form.classList.add('hidden');
            resultDiv.classList.remove('hidden');
        }
    });

    resetBtn.addEventListener('click', function() {
        form.reset();
        resultDiv.classList.add('hidden');
        form.classList.remove('hidden');
        window.scrollTo(0, 0);
    });
});