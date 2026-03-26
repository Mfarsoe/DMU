//crypto
const crypto = require('crypto');

//hashfunction
function hash(password, salt) {
    return crypto.pbkdf2Sync(password, salt, 100000, 64, 'sha512').toString('hex');
}

//user console input
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

//ask user for password and salt
readline.question('Enter the password to verify: ', password => {
    readline.question('Enter the salt used for hashing: ', salt => {
        readline.question('Enter the hashed password to compare against: ', hashedPassword => {
            //hash the input password with the provided salt
            const hashedInput = hash(password, salt);
            //compare the hashed input with the provided hashed password
            if (hashedInput === hashedPassword) {
                console.log('Password is correct!');
            } else {
                console.log('Password is incorrect!');
            }
            //close the readline interface
            readline.close();
        });
    });
});