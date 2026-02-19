// Her skal du skrive din JavaScript kode

// Referencer til links ('Less' og 'More') og containeren til tekstfelterne
var less = document.getElementById('less'); 
var more = document.getElementById('more');
var container = document.getElementById('container');

// Event listeners til 'Less' og 'More'
more.addEventListener('click', addTextField);
less.addEventListener('click', removeTextField);

// Tilføjer et tekstfelt (max 5)
function addTextField(event) {
    var textFields = container.getElementsByTagName('input').length;
    if (textFields < 5) {
        var newInput = document.createElement('input');
        newInput.type = 'text';
        container.appendChild(newInput);  
    }
}
// Fjerner et tekstfelt (min 0)
function removeTextField(event) {
    var textFields = container.getElementsByTagName('input');
    if (textFields.length > 0) {
        container.removeChild(textFields[textFields.length - 1]);
    }
}