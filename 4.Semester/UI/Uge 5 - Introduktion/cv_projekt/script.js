// Theme Toggle Logik
const toggleBtn = document.getElementById('theme-toggle');
const body = document.body;

function updateButtonText() {
    const isDark = body.getAttribute('data-theme') === 'dark' || 
                 (!body.hasAttribute('data-theme') && window.matchMedia('(prefers-color-scheme: dark)').matches);
    if (toggleBtn) toggleBtn.textContent = isDark ? 'Lyst tema' : 'Mørkt tema';
}

const savedTheme = localStorage.getItem('theme');
if (savedTheme) {
    body.setAttribute('data-theme', savedTheme);
}

updateButtonText();

if (toggleBtn) {
    toggleBtn.addEventListener('click', () => {
        const currentTheme = body.getAttribute('data-theme');
        let newTheme;
        if (!currentTheme) {
            newTheme = window.matchMedia('(prefers-color-scheme: dark)').matches ? 'light' : 'dark';
        } else {
            newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        }
        body.setAttribute('data-theme', newTheme);
        localStorage.setItem('theme', newTheme);
        updateButtonText();
    });
}

// Intersection Observer til Fade-in animationer
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px' // Starter animationen lidt før elementet er helt inde i view
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('visible');
            // Stop med at observere elementet når det først er vist
            observer.unobserve(entry.target);
        }
    });
}, observerOptions);

// Initialiser observer på alle elementer med .fade-in klassen
document.addEventListener('DOMContentLoaded', () => {
    const fadeElements = document.querySelectorAll('.fade-in');
    fadeElements.forEach(el => observer.observe(el));
});
