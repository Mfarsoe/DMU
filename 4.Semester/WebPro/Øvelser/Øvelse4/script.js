const boardElement = document.getElementById('board');
let tiles = []; // Indeholder objekter med { id, currentPos, correctPos }
const size = 4;
let emptyPos = 15; // Sidste plads er tom (index 15)

// Initialiser spillet
function initGame() {
    tiles = [];
    for (let i = 0; i < size * size; i++) {
        tiles.push({
            id: i,
            correctPos: i,
            currentPos: i
        });
    }
    renderBoard();
}

// Tegn brættet
function renderBoard() {
    boardElement.innerHTML = '';
    tiles.sort((a, b) => a.currentPos - b.currentPos);

    tiles.forEach(tile => {
        const tileDiv = document.createElement('div');
        tileDiv.classList.add('tile');
        
        if (tile.id === 15) {
            tileDiv.classList.add('empty');
        } else {
            // Beregn række og kolonne for billedfilen baseret på original position (id)
            const row = Math.floor(tile.id / 4);
            const col = tile.id % 4;
            tileDiv.style.backgroundImage = `url('img/hall-${row}${col}.jpg')`;
            tileDiv.onclick = () => moveTile(tile.currentPos);
        }
        
        boardElement.appendChild(tileDiv);
    });
}

// Flyt en brik
function moveTile(pos) {
    if (isAdjacent(pos, emptyPos)) {
        swapTiles(pos, emptyPos);
        emptyPos = pos;
        renderBoard();
        checkWin();
    }
}

// Tjek om to positioner er ved siden af hinanden
function isAdjacent(pos1, pos2) {
    const r1 = Math.floor(pos1 / size);
    const c1 = pos1 % size;
    const r2 = Math.floor(pos2 / size);
    const c2 = pos2 % size;

    const rowDiff = Math.abs(r1 - r2);
    const colDiff = Math.abs(c1 - c2);

    return (rowDiff === 1 && colDiff === 0) || (rowDiff === 0 && colDiff === 1);
}

// Byt om på to brikker i arrayet
function swapTiles(pos1, pos2) {
    const tile1 = tiles.find(t => t.currentPos === pos1);
    const tile2 = tiles.find(t => t.currentPos === pos2);
    
    tile1.currentPos = pos2;
    tile2.currentPos = pos1;
}

// Bland brikkerne ved at simulere tilfældige træk (sikrer at det kan løses)
function shuffleGame() {
    for (let i = 0; i < 200; i++) {
        const neighbors = getNeighbors(emptyPos);
        const randomNeighbor = neighbors[Math.floor(Math.random() * neighbors.length)];
        swapTiles(randomNeighbor, emptyPos);
        emptyPos = randomNeighbor;
    }
    renderBoard();
}

function getNeighbors(pos) {
    const neighbors = [];
    const r = Math.floor(pos / size);
    const c = pos % size;

    if (r > 0) neighbors.push(pos - size);
    if (r < size - 1) neighbors.push(pos + size);
    if (c > 0) neighbors.push(pos - 1);
    if (c < size - 1) neighbors.push(pos + 1);

    return neighbors;
}

// Tjek om alle brikker er på rette plads
function checkWin() {
    const isWin = tiles.every(tile => tile.currentPos === tile.correctPos);
    if (isWin) {
        setTimeout(() => alert('Tillykke! Du løste puslespillet!'), 100);
    }
}

initGame();
