import { Person } from './person';

const p1 = new Person('Anna', 30);
const p2 = new Person('Gert', 35);

const eldest = p1.oldest(p2);
console.log(`${eldest.name} er ældst (${eldest.age} år)`);