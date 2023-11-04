const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.send('Welcome to the home page!');
});

app.listen(port, '10.111.119.44', () => {
    console.log(`Server is running on http://192.168.1.100:${port}`);
});
