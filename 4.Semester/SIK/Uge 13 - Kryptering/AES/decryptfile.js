const crypto = require('crypto');
const fs = require('fs');
const path = require('path');

const INPUT_FILE = path.join(__dirname, 'encrypted.json');

function decryptAesGcm(data) {
    const algorithm = data.algorithm || 'aes-256-gcm';
    const ciphertext = Buffer.from(data.ciphertext, 'hex');
    const iv = Buffer.from(data.iv, 'hex');
    const tag = Buffer.from(data.tag, 'hex');
    const key = Buffer.from(data.key, 'hex');

    const decipher = crypto.createDecipheriv(algorithm, key, iv);
    decipher.setAuthTag(tag);

    const plaintextBuffer = Buffer.concat([
        decipher.update(ciphertext),
        decipher.final()
    ]);

    return plaintextBuffer.toString('utf8');
}

const encryptedData = JSON.parse(fs.readFileSync(INPUT_FILE, 'utf8'));
const plaintext = decryptAesGcm(encryptedData);
console.log(`Decrypted text: ${plaintext}`);
