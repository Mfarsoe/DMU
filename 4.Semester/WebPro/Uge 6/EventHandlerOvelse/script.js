// 2. DOM Property - Man tildeler en funktion direkte til en property på objektet
const propertyBtn = document.getElementById('propertyBtn');
const output = document.getElementById('output');

propertyBtn.onclick = function() {
    output.textContent = 'Brugte .onclick property!';
    console.log('Klik via property');
};

// 3. addEventListener - Den mest moderne og fleksible måde
// Fordel: Man kan tilføje flere forskellige funktioner til samme event
const listenerBtn = document.getElementById('listenerBtn');

listenerBtn.addEventListener('click', function(event) {
    output.textContent = 'Brugte addEventListener! Dette er den anbefalede måde.';
    console.log('Klik via addEventListener', event);
});

// Du kan også lytte efter andre ting, f.eks. musen der bevæger sig over knappen
listenerBtn.addEventListener('mouseover', () => {
    listenerBtn.style.backgroundColor = 'lightblue';
});

listenerBtn.addEventListener('mouseout', () => {
    listenerBtn.style.backgroundColor = '';
});
