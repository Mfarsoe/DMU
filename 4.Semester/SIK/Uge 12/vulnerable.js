// vulnerable.js - Testfil med mange sårbarheder til SAST-scanning

const fs = require('fs');
const { exec } = require('child_process');
const crypto = require('crypto');

// 1. Hardcoded Secret (Sikkerhedsrisiko: Credentials i klartekst)
const API_KEY = "12345-ABCDE-67890-SECRET"; 

// 2. Farlig brug af eval() (Sikkerhedsrisiko: Code Injection)
function runUserCode(code) {
    eval(code); 
}

// 3. Command Injection (Sikkerhedsrisiko: OS Command Injection)
function deleteFile(filename) {
    // Brugerinput direkte i en shell-kommando
    exec("rm -rf " + filename); 
}

// 4. Path Traversal (Sikkerhedsrisiko: Uautoriseret filadgang)
function getFileContent(userInputPath) {
    // Ingen validering af stien
    fs.readFile("/var/www/uploads/" + userInputPath, (err, data) => {
        if (err) throw err;
        console.log(data);
    });
}

// 5. Insecure Randomness (Sikkerhedsrisiko: Forudsigelige tokens)
function generateSessionToken() {
    // Math.random() er ikke kryptografisk sikker
    return Math.random().toString(36).substring(2);
}

// 6. Insecure Cryptography (Sikkerhedsrisiko: Svag hashing)
function hashPassword(password) {
    // MD5 betragtes som usikkert/knækket
    return crypto.createHash('md5').update(password).digest('hex');
}

// 7. Regular Expression Denial of Service (ReDoS)
function validateInput(input) {
    // Et komplekst regex der kan få CPU'en til at hænge ved specifikke inputs
    const regex = /([a-z]+)+$/;
    return regex.test(input);
}

// 8. Object Injection
function updateConfig(userInputKey, userInputValue) {
    const config = {};
    // Direkte adgang til objekt-egenskaber via brugerinput
    config[userInputKey] = userInputValue;
}

// 9. Potentiel XSS (Cross-Site Scripting) i browser-miljø
function setUsername(name) {
    document.getElementById('user').innerHTML = "Velkommen, " + name;
}

console.log("Systemet kører...");
