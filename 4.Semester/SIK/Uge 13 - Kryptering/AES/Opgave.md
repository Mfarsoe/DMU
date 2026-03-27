# Øvelser om AES i Node.js
## Del 1 — Kryptering

Lav et script encrypt.js der:
1. Læser tekst fra kommandolinjen (eller en hardkodet værdi)
2. Genererer key og IV
3. Krypterer teksten med AES-GCM
4. Udskriver:
• ciphertext
• iv, tag og key

## Del 2 — Dekryptering
Lav decrypt.js der:
1. Læser ciphertext, iv, tag og key (fx fra fil eller terminalinput)
2. Dekrypterer data
3. Udskriver resultatet

## Del 3 — Tampering-angreb
1. Ændr én byte i ciphertext eller tag
2. Kør dekryptering

### Spørgsmål til diskussion:
• Hvad sker der — og hvorfor?
• Hvad fortæller det om autentificeret kryptering?

## Del 4 — Ekstraopgave
Lav et lille system hvor:
• “Bruger” indtaster en besked
• Beskeden krypteres og gemmes i en fil
• Et andet script læser filen og dekrypterer beskeden

Ekstra: Tilføj PBKDF2 til at aflede key ud fra et password.