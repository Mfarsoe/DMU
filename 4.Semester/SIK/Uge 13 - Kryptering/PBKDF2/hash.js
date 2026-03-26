//crypto
const crypto = require('crypto');

//user console input
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

//ask user for password
readline.question('Enter a password: ', password => {

    //time the hashing process
    console.time('Hashing Time');
    //generate a random salt
    const salt = crypto.randomBytes(16).toString('hex');
    //hash the password with the salt using PBKDF2
    crypto.pbkdf2(password, salt, 150000, 64, 'sha512', (err, derivedKey) => {
        if (err) throw err;
        //print the salt and the hashed password
        console.log(`Salt: ${salt}`);
        console.log(`Hashed Password: ${derivedKey.toString('hex')}`);
        //end the timer
        console.timeEnd('Hashing Time');
        //close the readline interface
        readline.close();
    });
});

