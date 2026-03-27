const crypto = require('crypto');
const readline = require('readline');

const ALGORITHM = 'aes-256-gcm';

function parseHex(value) {
    const text = (value || '').trim();
    const parts = text.split(':');
    const hex = (parts.length > 1 ? parts[parts.length - 1] : parts[0]).trim();
    return Buffer.from(hex, 'hex');
}

function decryptAesGcm(ciphertextHex, ivHex, tagHex, keyHex) {
    const ciphertext = parseHex(ciphertextHex);
    const iv = parseHex(ivHex);
    const tag = parseHex(tagHex);
    const key = parseHex(keyHex);

    const decipher = crypto.createDecipheriv(ALGORITHM, key, iv);
    decipher.setAuthTag(tag);

    const plaintextBuffer = Buffer.concat([
        decipher.update(ciphertext),
        decipher.final()
    ]);

    return plaintextBuffer.toString('utf8');
}


const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Paste ciphertext line/value: ', ciphertextHex => {
    rl.question('Paste iv line/value: ', ivHex => {
        rl.question('Paste tag line/value: ', tagHex => {
            rl.question('Paste key line/value: ', keyHex => {
                try {
                    const plaintext = decryptAesGcm(ciphertextHex, ivHex, tagHex, keyHex);
                    console.log(`Decrypted text: ${plaintext}`);
                } catch (error) {
                    console.error(`Dekryptering fejlede: ${error.message}`);
                } finally {
                    rl.close();
                }
            });
        });
    });
});



