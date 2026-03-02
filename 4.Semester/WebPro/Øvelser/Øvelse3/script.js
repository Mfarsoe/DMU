// Reference til inputfeltet og feedback-beskeden
var plateInput = document.getElementById('plate');
var feedback = document.getElementById('feedback');

// Gem den seneste gyldige værdi for at kunne rulle tilbage ved ugyldig indtastning
var lastValidValue = "";

// Lyt efter indtastning i feltet
plateInput.addEventListener('input', function() {
    var value = plateInput.value;
    
    // Regex til at håndtere løbende indtastning:
    // Enten 0-2 bogstaver ELLER præcis 2 bogstaver efterfulgt af 0-5 tal.
    var enforcementRegex = /^([A-Za-z]{0,2}|[A-Za-z]{2}[0-9]{0,5})$/;

    // Hvis det nye input ikke passer regex, sætter vi det tilbage til den sidste gyldige værdi
    if (!enforcementRegex.test(value)) {
        plateInput.value = lastValidValue;
        return; 
    }

    // Opdater den gyldige værdi
    lastValidValue = plateInput.value;
    
    // Tjek om det er en fuldendt nummerplade
    var isFullMatch = /^[A-Za-z]{2}[0-9]{5}$/.test(lastValidValue);

    // Opdater feedback-beskeden
    if (lastValidValue === "") {
        feedback.textContent = 'Indtast 2 bogstaver og 5 tal';
        feedback.className = 'message';
    } 
    else if (isFullMatch) {
        feedback.textContent = 'Gyldig dansk nummerplade!';
        feedback.className = 'message valid';
    } 
    else {
        feedback.textContent = 'Fortsæt indtastning... (' + lastValidValue.length + '/7)';
        feedback.className = 'message';
    }
});
