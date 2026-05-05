export interface IPerson {
  name: string;
  age: number;
  oldest(other: IPerson): IPerson;
}
