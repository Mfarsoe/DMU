# Guide: SAST med ESLint

Denne guide viser, hvordan du opsætter og bruger ESLint som et simpelt SAST-værktøj (Static Application Security Testing) til at scanne din kode for sårbarheder og dårlig kodestil.

## 1. Installation

Sørg for, at du har [Node.js](https://nodejs.org/) installeret.

Kør følgende kommandoer i din terminal:

```bash
# Initialiser npm i din mappe (hvis du ikke allerede har gjort det)
npm init -y

# Installer ESLint som en development dependency
npm install eslint --save-dev

# Initialiser ESLint konfiguration
npx eslint --init
```

Vælg de standardindstillinger, der passer til dit projekt (f.eks. JavaScript, CommonJS, og 'To check syntax and find problems').

## 2. Tilføj Sikkerhedsregler

For at gøre ESLint til et bedre sikkerhedsværktøj, kan du tilføje `eslint-plugin-security`.

```bash
npm install eslint-plugin-security --save-dev
```

Tilføj derefter `"plugin:security/recommended"` til din `eslint.config.js` (eller `.eslintrc.json`).

## 3. Kørsel af scan

For at scanne din kode (f.eks. filen `vulnerable.js`), kør:

```bash
npx eslint vulnerable.js
```

## 4. Forventet Output

ESLint vil give dig en liste over fejl og advarsler. For `vulnerable.js` bør du forvente noget i retning af:

- **'var' is used instead of 'let' or 'const'**: Advarsel mod forældet variabel-deklaration.
- **'eval' can be harmful**: En alvorlig sikkerhedsadvarsel, da `eval()` kan køre vilkårlig kode.
- **'x' is assigned a value but never used**: En advarsel om død kode, som kan rydde op i dit projekt.

Eksempel på terminal output:
```text
  4:1   error  Unexpected var, use let or const instead          no-var
  8:5   error  eval can be harmful                               no-eval
  12:9  error  'x' is assigned a value but never used            no-unused-vars
```

---
Dette simple setup hjælper dig med at fange sårbarheder tidligt i udviklingsprocessen.
