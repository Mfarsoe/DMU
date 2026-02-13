const list = document.querySelector('ul');

for (let i = 0; i < list.children.length; i++) {
    if (list.children[i].textContent.includes('http')) {
        const url = list.children[i].textContent;
        list.children[i].innerHTML = `<a href="${url}">${url}</a>`;
    }
}