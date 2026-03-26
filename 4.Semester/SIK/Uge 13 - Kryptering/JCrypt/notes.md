# jcrypt i Node.js – Forklaring

## Hvad er jcrypt?
`jcrypt` er en Node.js-implementering af den klassiske Unix `crypt`-funktion. Den bruges til at hash’e passwords, men er **meget ældre og mindre sikker** end moderne metoder som PBKDF2, bcrypt eller argon2.

Den er primært relevant hvis du:
- Skal arbejde med legacy-systemer
- Skal verificere gamle password-hashes

---

## Hvordan virker jcrypt?
jcrypt tager:
- En adgangskode
- Et salt (typisk 2 tegn)

Den bruger en ældre hash-algoritme baseret på DES (Data Encryption Standard).

**Vigtige begrænsninger:**
- Kun de første 8 tegn af password bruges
- Salt er meget kort (2 tegn)
- Lav modstand mod brute-force angreb

---

## Installation

```bash
npm install jcrypt