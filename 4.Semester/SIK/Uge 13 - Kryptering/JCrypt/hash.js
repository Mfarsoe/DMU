//hashingimport bcrypt
const bcrypt = require('bcrypt');

//input from console
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

//ask user for password
rl.question('Enter a password to hash: ', (password) => {
    //hash the password
    console.time('Hashing time');
    bcrypt.hash(password, 12, (err, hash) => {
        if (err) {
            console.error('Error hashing password:', err);
            return;
        }
        console.log('Hashed password:', hash);
        console.timeEnd('Hashing time');
        rl.close();
    });
});
