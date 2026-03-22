import js from "@eslint/js";
import globals from "globals";
import pluginSecurity from "eslint-plugin-security";

export default [
  js.configs.recommended,
  pluginSecurity.configs.recommended,
  {
    files: ["**/*.{js,mjs,cjs}"],
    languageOptions: {
      sourceType: "module",
      globals: {
        ...globals.browser,
        ...globals.node,
      },
    },
    rules: {
      "no-unused-vars": "off",
      "no-undef": "off",

      // Kerne sikkerhed
      "no-eval": "error",
      "security/detect-child-process": "error",
      "security/detect-object-injection": "error",
      "security/detect-non-literal-fs-filename": "error",

      // --- CUSTOM SAST SECURITY RULES ---
      
      "no-restricted-syntax": [
        "error",
        {
          // Catching #5: Insecure Randomness
          "selector": "CallExpression[callee.object.name='Math'][callee.property.name='random']",
          "message": "SAST ERROR: Math.random() is not cryptographically secure. Use crypto.getRandomValues() instead."
        },
        {
          // Catching #6: Insecure Cryptography (MD5)
          "selector": "Literal[value='md5']",
          "message": "SAST ERROR: MD5 is a weak hashing algorithm. Use SHA-256 or stronger."
        },
        {
          // Catching #1: Hardcoded Secrets (simple version)
          "selector": "VariableDeclarator[id.name=/SECRET|API_KEY|PASSWORD/][init.type='Literal']",
          "message": "SAST ERROR: Potential hardcoded secret found in variable name."
        }
      ]
    },
  },
];
