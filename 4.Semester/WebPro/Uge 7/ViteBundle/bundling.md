# Bundling med Vite

Denne vejledning beskriver både opsætning og brug af Vite.

## 1. Opsætning fra bunden

Hvis du starter et nyt projekt, kan du gøre følgende:

1.  **Initialisér projektet:**
    Kør følgende kommando og følg guiden (vælg "Vanilla" og "JavaScript" for et simpelt setup):
    ```bash
    npm create vite@latest .
    ```
    *(Punktummet til sidst betyder "i denne mappe")*

2.  **Alternativ (manuelt):**
    Hvis du allerede har filer, kan du installere Vite manuelt:
    ```bash
    npm install vite --save-dev
    ```
    Tilføj derefter scripts til din `package.json`:
    ```json
    "scripts": {
      "dev": "vite",
      "build": "vite build",
      "preview": "vite preview"
    }
    ```

3.  **Filstruktur:**
    Vite forventer som standard, at `index.html` ligger i rodmappen, og at dine JavaScript-filer importeres som moduler:
    ```html
    <script type="module" src="/main.js"></script>
    ```

## 2. Brug af projektet

1.  **Installation af afhængigheder:**
    ```bash
    npm install
    ```

2.  **Udvikling (Dev Server):**
    ```bash
    npm run dev
    ```

3.  **Bundling til produktion:**
    ```bash
    npm run build
    ```
    Dette genererer en `dist/` mappe med de optimerede filer.

## Hvorfor Vite?
Vite er ekstremt hurtig under udvikling, da den bruger native ES-moduler i browseren. Den behøver ikke at bundle hele koden hver gang du gemmer en fil, hvilket gør feedback-loopet øjeblikkeligt.
