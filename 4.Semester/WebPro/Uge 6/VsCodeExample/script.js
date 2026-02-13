// Find elementerne i DOM'en
const knap = document.getElementById('minKnap');
const beskedFelt = document.getElementById('besked');

// Klik event
knap.addEventListener('click', () => {
    beskedFelt.textContent = 'Du har klikket på knappen! JS virker.';
    console.log('Knappen blev klikket!');
});

// Mouseenter event (når musen føres over knappen)
knap.addEventListener('mouseenter', () => {
    knap.style.backgroundColor = '#0056b3'; // Mørkere blå
    beskedFelt.textContent = 'Musen er over knappen!';
});

// Mouseleave event (når musen forlader knappen)
knap.addEventListener('mouseleave', () => {
    knap.style.backgroundColor = '#007BFF'; // Original blå
    beskedFelt.textContent = ''; // Tøm beskeden eller sæt tilbage til start
});