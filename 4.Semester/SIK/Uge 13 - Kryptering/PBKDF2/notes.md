# PBKDF2 i Node.js (crypto)

## Hvad er PBKDF2?
PBKDF2 står for **Password-Based Key Derivation Function 2**.  
Det er en algoritme, der bruges til at omdanne et password til en sikker nøgle (hash), som kan gemmes i en database.

Formålet er at gøre det **svært og langsomt** for en angriber at gætte passwords (brute force).

---

## Hvordan fungerer PBKDF2?

PBKDF2 tager følgende input:

- **Password** – brugerens adgangskode
- **Salt** – en tilfældig værdi (forhindrer rainbow table angreb)
- **Iterations** – hvor mange gange hash-funktionen køres
- **Key length** – længden på den genererede nøgle
- **Digest** – hash-algoritme (fx `sha256`)

### Kort forklaret:
1. Password + salt kombineres
2. Hash-funktionen køres mange gange (iterations)
3. Resultatet bliver en sikker, afledt nøgle (hash)

Jo flere iterations → jo langsommere → jo mere sikker

---

## Eksempel i Node.js

```js
const crypto = require('crypto');

const password = 'mySecretPassword';
const salt = crypto.randomBytes(16).toString('hex');
const iterations = 100000;
const keylen = 64;
const digest = 'sha512';

crypto.pbkdf2(password, salt, iterations, keylen, digest, (err, derivedKey) => {
  if (err) throw err;
  console.log('Hash:', derivedKey.toString('hex'));
});