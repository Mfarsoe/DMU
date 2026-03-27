const crypto = require('crypto');
const fs = require('fs');
const path = require('path');
const readline = require('readline');

const ALGORITHM = 'aes-256-gcm';
const OUTPUT_FILE = path.join(__dirname, 'encrypted.json');

function encryptAesGcm(plainText) {
    const key = crypto.randomBytes(32);
    const iv = crypto.randomBytes(12);

    const cipher = crypto.createCipheriv(ALGORITHM, key, iv);
    const ciphertext = Buffer.concat([
        cipher.update(plainText, 'utf8'),
        cipher.final()
    ]);

    const tag = cipher.getAuthTag();

    return { ciphertext, iv, tag, key };
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter text to encrypt: ', inputText => {
    const result = encryptAesGcm(inputText);

    const payload = {
        algorithm: ALGORITHM,
        ciphertext: result.ciphertext.toString('hex'),
        iv: result.iv.toString('hex'),
        tag: result.tag.toString('hex'),
        key: result.key.toString('hex')
    };

    fs.writeFileSync(OUTPUT_FILE, JSON.stringify(payload, null, 2), 'utf8');
    console.log(`Encrypted data saved to ${OUTPUT_FILE}`);
    rl.close();
});
