# Projektbeskrivelse: Blogsite baseret på Jesse James Garretts 5 planer

I dette projekt skal du opbygge din egen blog-hjemmeside ved hjælp af WordPress.

Formålet er at forstå, hvordan et website udvikles fra idé til færdigt design ved hjælp af Jesse James Garretts **5 Planes-model**.

Temaet for demoen er *manga*, men du må vælge et alternativt tema, fx *gaming*.

## 1. Strategy (Strategi)

I strategifasen definerer du formålet med sitet.

### Mål
- Oprette en personlig blogside om et emne, du interesserer dig for (fx manga eller gaming).
- Præsentere indhold til andre studerende eller fans.
- Gøre det nemt for brugeren at læse opslag og navigere mellem sider.

### Brugerbehov
- Hurtig adgang til blogindlæg cross channel.
- Enkel navigation 
- Mobilvenlig oplevelse.

### Site-ejerens mål
- Publicere blogindlæg.
- Lære WordPress-struktur.

## 2. Scope (Kravspecifikation)

Her defineres funktioner og indholdskrav.

### Funktionelle krav
- Alle links skal virke.
- `Home`-knappen skal altid føre tilbage til forsiden.
- Sitet skal være responsivt (desktop + mobil).
- Navigation skal være ens på alle sider.

### Indholdskrav
- Forside.
- Blogside med opslag.
- About-side (om dig selv).
- Kontakt-side.
- Billeder kan anvendes fra XBI-materialet.

## 3. Structure (Struktur)

Her planlægges informationsarkitektur og navigation.
 
HOME
│
├── Blog Page
│   ├── Post 1
│   ├── Post 2
│   └── Post 3
│
├── About
│
└── Contact
 

### Navigationsregel
- Alle sider skal kunne føre tilbage til `HOME`.

## 4. Skeleton (Skelet/Layout)

Her organiseres elementerne på siden.

### Layoutprincipper
- Header med logo + navigation.
- Hovedindhold i midten.

### Indsæt i layout
- `nav` + `footer` block.
- Content med tekst/billede.

## 5. Surface (Visuelt design)

Her vælges det visuelle udtryk.

### Tema
- WordPress-tema: **Balasana**.

### Designvalg
- Rent og minimalistisk layout.

### Responsivt
- Desktop: menu vises vandret.
- Mobil: menu foldes sammen (hamburger-menu).
- Tekst og billeder skalerer automatisk.