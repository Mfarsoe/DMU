import { IPerson } from './IPerson';

export class Person implements IPerson {
  constructor(public name: string, public age: number) {}

  oldest(other: IPerson): IPerson {
    return other.age > this.age ? other : this;
  }
}
