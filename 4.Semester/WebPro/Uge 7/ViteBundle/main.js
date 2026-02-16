import "./style.css";
import { hilsen } from "./utils.js";

const button = document.getElementById("greet-btn");
const input = document.getElementById("name-input");
const output = document.getElementById("output");

button.addEventListener("click", () => {
    const navn = input.value || "fremmede";
    output.textContent = hilsen(navn);
    output.classList.add("visible");
});
