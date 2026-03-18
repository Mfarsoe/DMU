document.addEventListener('DOMContentLoaded', () => {
    const menuToggle = document.querySelector('.menu-toggle');
    const mainMenu = document.querySelector('.main-menu');

    if (menuToggle && mainMenu) {
        menuToggle.addEventListener('click', () => {
            const isExpanded = menuToggle.getAttribute('aria-expanded') === 'true';
            menuToggle.setAttribute('aria-expanded', !isExpanded);
            mainMenu.classList.toggle('active');
            
            if (mainMenu.classList.contains('active')) {
                menuToggle.innerHTML = '✕ Luk';
            } else {
                menuToggle.innerHTML = '☰ Menu';
            }
        });
    }

    // Håndter Escape-tast til at lukke menuer
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Escape' && mainMenu.classList.contains('active')) {
            mainMenu.classList.remove('active');
            menuToggle.setAttribute('aria-expanded', 'false');
            menuToggle.innerHTML = '☰ Menu';
            menuToggle.focus();
        }
    });

    // Opdater aria-expanded på undermenuer ved tastatur-fokus
    const submenuParents = document.querySelectorAll('.has-submenu > a');
    submenuParents.forEach(parent => {
        parent.addEventListener('focus', () => {
            parent.setAttribute('aria-expanded', 'true');
        });
        
        // Når fokus forlader hele li'en (inklusiv dens submenu)
        parent.parentElement.addEventListener('focusout', (e) => {
            if (!parent.parentElement.contains(e.relatedTarget)) {
                parent.setAttribute('aria-expanded', 'false');
            }
        });
    });

    // Smooth scroll for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            if (this.getAttribute('href') === '#') return;
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth'
                });
                
                // Luk menu på mobil ved klik
                if (mainMenu.classList.contains('active')) {
                    mainMenu.classList.remove('active');
                    menuToggle.setAttribute('aria-expanded', 'false');
                    menuToggle.innerHTML = '☰ Menu';
                }

                // Sæt fokus på target for skærmlæsere
                target.setAttribute('tabindex', '-1');
                target.focus();
            }
        });
    });
});
