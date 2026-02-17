# Design System - CV Projekt

Dette dokument beskriver de designvalg og komponenter, der udgør det visuelle fundament for CV-sitet. Systemet er bygget til at være konsistent, tilgængeligt og let at vedligeholde via CSS-variabler.

## 1. Farvepalette

### Brand Farver
Disse farver bruges til at skabe identitet og fremhæve vigtige elementer.
- **Primær:** `#2d6a4f` (Mørkegrøn) – Bruges til overskrifter, knapper og accenter.
- **Primær Lys:** `#40916c` – Bruges til hover-tilstande.
- **Sekundær:** `#52b788` – Bruges primært i mørkt tema.
- **Accent:** `#74c69d` – Bruges til dekorative elementer som h2-linjer.

### Neutrale Farver
Bruges til baggrunde, tekst og grænser.
- **Neutral 100:** `#f8faf9` – Tekstfarve i mørkt tema.
- **Neutral 200:** `#f0f4f1` – Baggrundsgradient start (Lyst tema).
- **Neutral 300:** `#d8e2dc` – Baggrundsgradient slut (Lyst tema).
- **Neutral 400:** `#b7c4bc` – Muted tekst i mørkt tema.
- **Neutral 800:** `#4a5d50` – Muted tekst i lyst tema.
- **Neutral 900:** `#1b3022` – Hovedtekstfarve i lyst tema.

---

## 2. Typografi

Systemet bruger en moderne sans-serif font-stack for optimal læsbarhed.

- **Font Family:** `'Segoe UI', system-ui, -apple-system, sans-serif`
- **Base størrelse:** `1rem` (16px)
- **Overskrifter:**
    - **H1:** `3.5rem` (Bold 800) – Med gradient-effekt.
    - **H2:** `1.2rem` (Uppercase, Spacing 2px).
    - **H3:** `1.1rem` (Semibold 600).
- **Vægte:** 400 (Normal), 500 (Medium), 600 (Semibold), 800 (Bold).

---

## 3. Spacing & Layout

Der benyttes en fast skala for at sikre ensartet luft i designet.

- **XS:** `0.5rem` (Små detaljer)
- **SM:** `0.8rem` (Gaps i grids)
- **MD:** `1rem` (Standard padding/margin)
- **LG:** `1.5rem` (Sektions-padding)
- **XL:** `2rem` (Mellemrum mellem sektioner)
- **XXL:** `3rem` (Container padding)
- **Huge:** `4rem` (Top/bund margin for container)

---

## 4. UI Komponenter

### Kort (Cards)
Bruges til erhvervserfaring og uddannelse.
- **Border-radius:** `16px` (`--radius-md`)
- **Accent:** 4px solid venstre kant i primær farve.
- **Interaktion:** Flytter sig 10px til højre ved hover.

### Knapper & Tags
- **Pill-shape:** `50px` border-radius for et moderne, blødt udtryk.
- **Shadow:** Let dybde med `0 4px 12px rgba(0,0,0,0.1)`.

### Tema-skift
Understøtter både `prefers-color-scheme: dark` og manuel overstyring via `[data-theme="dark"]` på body-tagget.
