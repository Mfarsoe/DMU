# AES-GCM forklaring

Denne fil forklarer de vigtigste begreber i scriptet i encrypt.js og hvordan Node.js metoderne bruges.

## Begreber

### Key
En key er den hemmelige noegle, som bruges til at kryptere og dekryptere data.
I scriptet laves en 256-bit key med:

```js
const key = crypto.randomBytes(32);
```

32 bytes = 256 bit.

### IV
IV betyder Initialization Vector (ofte kaldet nonce i GCM).
Det er en unik vaerdi, der bruges sammen med key, sa samme plaintext ikke giver samme ciphertext hver gang.
I AES-GCM bruges typisk 12 bytes IV:

```js
const iv = crypto.randomBytes(12);
```

### GCM
GCM (Galois/Counter Mode) er en mode for AES, som giver baade:
- fortrolighed (kryptering)
- integritet/autenticitet (via auth tag)

I scriptet vaelges GCM med algoritmen:

```js
const ALGORITHM = 'aes-256-gcm';
```

### Tag
Tag er en autenticitetskode (authentication tag), som genereres under AES-GCM kryptering.
Ved dekryptering bruges tag til at kontrollere, om data er aendret eller key/iv er forkert.
Tag hentes saadan:

```js
const tag = cipher.getAuthTag();
```

### Cipher og Ciphertext
Cipher er selve krypterings-objektet, oprettet med key + iv + algoritme.
Ciphertext er resultatet (den krypterede tekst) i bytes.

```js
const cipher = crypto.createCipheriv(ALGORITHM, key, iv);
```

## Metoder brugt i scriptet

### crypto.randomBytes
Genererer kryptografisk sikre tilfaeldige bytes.
Bruges her til baade key og iv:

```js
const key = crypto.randomBytes(32);
const iv = crypto.randomBytes(12);
```

### crypto.createCipheriv
Opretter et cipher-objekt med:
- algoritme
- key
- iv

```js
const cipher = crypto.createCipheriv(ALGORITHM, key, iv);
```

### cipher.update + cipher.final
Krypteringen sker i to trin:
1. `cipher.update(...)` behandler input-data
2. `cipher.final()` afslutter krypteringen og returnerer de sidste bytes

```js
cipher.update(plainText, 'utf8')
cipher.final()
```

### Buffer.concat
Da `update` og `final` hver returnerer en Buffer, samles de til en samlet ciphertext:

```js
const ciphertext = Buffer.concat([
  cipher.update(plainText, 'utf8'),
  cipher.final()
]);
```

## Data der printes
Efter kryptering udskrives:
- ciphertext (hex)
- iv (hex)
- tag (hex)
- key (hex)

Det giver alt, man skal bruge for senere dekryptering (forudsat korrekt key/iv/tag).
