using ThreadOpg2;

CascadeThread next = null;

for (int i = 0; i < 10; i++) {
    next = new CascadeThread("Thread " + i, next);
    next.Start();
}

next.isMyTurn();

