import http from 'http';
const PORT = process.env.PORT;

const server = http.createServer((req, res) => {
    //res.setHeader('Content-Type', 'text/html');
    //res.statusCode = 404;

    try {
        //check if Get request
        if (req.method === 'GET') {
            console.log('Received a GET request');
        } else {
            console.log(`Received a ${req.method} request`);
        }
    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>Welcome to the Home Page!</h1>');
    } else if (req.url === '/about') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>About Us</h1><p>This is the about page.</p>');
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 Not Found</h1><p>The page you are looking for does not exist.</p>');
    }


});

server.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
