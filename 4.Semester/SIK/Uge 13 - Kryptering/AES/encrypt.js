const crypto = require('crypto');

const ALGORITHM = 'aes-256-gcm';


// Brug tekst fra kommandolinjen, ellers fallback til en hardkodet streng.
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

function encryptAesGcm(plainText) {
    const key = crypto.randomBytes(32); // 256-bit key
    const iv = crypto.randomBytes(12); // 96-bit nonce til GCM

    const cipher = crypto.createCipheriv(ALGORITHM, key, iv);
    const ciphertext = Buffer.concat([
        cipher.update(plainText, 'utf8'),
        cipher.final()
    ]);
    
    const tag = cipher.getAuthTag();

    return { key, iv, tag, ciphertext };
}
readline.question('Enter text to encrypt: ', inputText => {
    const result = encryptAesGcm(inputText);
    console.log(`Input: ${inputText}`);
    console.log(`ciphertext: ${result.ciphertext.toString('hex')}`);
    console.log(`iv: ${result.iv.toString('hex')}`);
    console.log(`tag: ${result.tag.toString('hex')}`);
    console.log(`key: ${result.key.toString('hex')}`);
    readline.close();
});


