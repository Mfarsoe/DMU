const questions = [
    { text: "Jeg finder det nemt at navigere rundt på DocJava med tastaturet.", type: "positive" },
    { text: "Jeg synes, der er for mange forhindringer, når jeg prøver at bruge DocJava uden mus.", type: "negative" },
    { text: "Det er klart, hvordan man kommer fra en side til en anden med tastaturkommandoer.", type: "positive" },
    { text: "Jeg føler mig ofte forvirret over, hvilke elementer jeg kan interagere med via tastaturet.", type: "negative" },
    { text: "Jeg kan hurtigt finde de materialer, jeg har brug for på DocJava, når jeg bruger tastaturet.", type: "positive" },
    { text: "Det tager for lang tid at udføre opgaver på DocJava med tastaturet alene.", type: "negative" },
    { text: "Jeg føler, at DocJava understøtter studerende med forskellige behov ved hjælp af keyboard navigation.", type: "positive" },
    { text: "Jeg oplever, at nogle funktioner ikke kan tilgås uden musen.", type: "negative" },
    { text: "Jeg kan nemt forstå strukturen af DocJava og hvordan jeg skal navigere via tastatur.", type: "positive" },
    { text: "Jeg bliver ofte nødt til at bruge musen, fordi keyboard navigation ikke er tilstrækkelig.", type: "negative" }
];

const introContainer = document.getElementById('intro-container');
const surveyContainer = document.getElementById('survey-container');
const startBtn = document.getElementById('start-btn');
const container = document.getElementById('questions-container');
const form = document.getElementById('sus-form');
const resultContainer = document.getElementById('result-container');
const scoreDisplay = document.getElementById('sus-score');
const interpretationDisplay = document.getElementById('score-interpretation');
const resetBtn = document.getElementById('reset-btn');

// Start Survey Logic
startBtn.addEventListener('click', () => {
    introContainer.classList.add('hidden');
    surveyContainer.classList.remove('hidden');
    window.scrollTo(0, 0);
});

// Render questions
function renderQuestions() {
    container.innerHTML = '';
    questions.forEach((q, index) => {
        const questionDiv = document.createElement('div');
        questionDiv.className = 'question-block';
        
        questionDiv.innerHTML = `
            <span class="question-text">${index + 1}. ${q.text}</span>
            <div class="likert-labels">
                <span>Helt uenig (1)</span>
                <span>Helt enig (5)</span>
            </div>
            <div class="likert-scale">
                ${[1, 2, 3, 4, 5].map(num => `
                    <label class="likert-option">
                        <input type="radio" name="q${index}" value="${num}" required>
                        <span>${num}</span>
                    </label>
                `).join('')}
            </div>
        `;
        container.appendChild(questionDiv);
    });
}

// Calculate SUS Score
form.addEventListener('submit', (e) => {
    e.preventDefault();
    
    let totalScore = 0;
    const formData = new FormData(form);
    
    questions.forEach((q, index) => {
        const value = parseInt(formData.get(`q${index}`));
        if (q.type === 'positive') {
            totalScore += (value - 1);
        } else {
            totalScore += (5 - value);
        }
    });
    
    const susScore = totalScore * 2.5;
    displayResult(susScore);
});

function displayResult(score) {
    surveyContainer.classList.add('hidden');
    resultContainer.classList.remove('hidden');
    scoreDisplay.innerText = score;
    
    let interpretation = "";
    if (score >= 80.3) {
        interpretation = "Fremragende! Brugerne elsker oplevelsen.";
    } else if (score >= 68) {
        interpretation = "Godt. Systemet er over gennemsnittet, men kan forbedres.";
    } else if (score >= 51) {
        interpretation = "Ok, men med plads til væsentlige forbedringer.";
    } else {
        interpretation = "Dårlig brugervenlighed. Systemet har brug for store ændringer.";
    }
    
    interpretationDisplay.innerText = interpretation;
}

resetBtn.addEventListener('click', () => {
    form.reset();
    introContainer.classList.remove('hidden');
    resultContainer.classList.add('hidden');
    window.scrollTo(0, 0);
});

// Initial render
renderQuestions();
