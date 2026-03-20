# Guide: Avanceret Sikkerhed (SCA & Secrets)

Denne guide viser, hvordan du tjekker dine eksterne pakker for sårbarheder (SCA) og sikrer, at du ikke uploader passwords eller API-nøgler til Git.

---

## 1. SCA: Tjek dine dependencies med `npm audit`

Når du bruger `npm install`, downloader du kode fra andre. SCA (Software Composition Analysis) tjekker, om nogle af disse pakker er kendt for at være usikre.

### Sådan gør du:
Vi har installeret en sårbar version af `glob-parent`. Kør denne kommando:

```bash
npm audit
```

### Forventet output:
Du vil se en rapport, der forklarer:
- **Hvad fejlen er:** F.eks. "Regular Expression Denial of Service (ReDoS)".
- **Hvor den findes:** Navnet på pakken og hvilken version du har.
- **Hvordan den fikses:** Oftest ved at opdatere til en nyere version.

**Tip:** Du kan ofte fiksa det automatisk ved at køre `npm audit fix`.

---

## 2. Secrets Scanning: Find glemte nøgler med Gitleaks

**Gitleaks** er en af de hurtigste og mest populære "Secrets Scanners" i verden. Den kigger efter mønstre som AWS-nøgler, private keys og database-passwords i din git-historik.

### Hurtig-metode (Ingen installation nødvendig):
Hvis du bare vil tjekke dine filer nu og her uden at installere noget permanent, kan du bruge `npx` til at køre en "wrapper" eller et alternativ som `secretlint` (som fungerer ligesom ESLint):

```bash
npx secretlint "**/*"
```

### Den Professionelle Metode (Gitleaks):
Hvis du vil have den "rigtige" Gitleaks på din computer, kan du installere den via [winget](https://learn.microsoft.com/en-us/windows/package-manager/winget/) (hvis du har Windows 10/11):

```powershell
# Installer Gitleaks via Windows Package Manager
winget install gitleaks
```

Når den er installeret, kan du scanne din mappe (hvis det er et Git-repo):
```bash
gitleaks detect --source . --no-git --verbose
```

### Forventet output:
Hvis du stadig har `API_KEY = "12345..."` i din `vulnerable.js`, vil Gitleaks (eller Secretlint) markere det som et fund. Den vil vise:
- **Filnavn og linjenummer.**
- **Hvilken type "Secret" den tror det er.**
- **Hvilken del af teksten der er farlig.**

---

## Opsummering: De 3 Søjler i Moderne SAST
1. **ESLint + security plugin:** Tjekker *din egen* kode for logiske fejl.
2. **npm audit:** Tjekker de *pakker*, du henter ind fra internettet.
3. **Gitleaks:** Tjekker at du ikke ved et uheld afslører *passwords* eller *nøgler*.

Prøv nu at køre `npm audit` og se rapporten for `glob-parent`!
