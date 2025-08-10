
using ThreadOpg1;

TennisSpiller t1 = new("John");
TennisSpiller t2 = new("Karl");

t1.SetModstander(t2);
t2.SetModstander(t1);


t1.Start();
t2.Start();

t1.ModtagBold();