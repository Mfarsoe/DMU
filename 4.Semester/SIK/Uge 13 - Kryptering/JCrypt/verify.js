//bcrypt
const bcrypt = require('bcrypt');

//input from console
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

//ask user for password and hash
rl.question('Enter a password to verify: ', (password) => {
    rl.question('Enter the hash to verify against: ', (hash) => {
        //verify the password against the hash
        bcrypt.compare(password, hash, (err, result) => {
            if (err) {
                console.error('Error verifying password:', err);
                return;
            } else if (result) {
                console.log('Password is valid!');
            } else {
                console.log('Password is invalid!');
            }
            rl.close();
        });
    });
});
