const express = require('express');
const multer = require('multer');
const fs = require('fs');
const app = express();
const port = process.env.PORT || 3001;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'));

// Set up multer for file uploads
const storage = multer.diskStorage({
    destination: 'public/media',
    filename: (req, file, cb) => {
        cb(null, file.originalname);
    },
});
const upload = multer({ storage: storage });

// Mock data for the media catalog
const mediaCatalog = [];

app.post('/addMediaItem', upload.single('mediaFile'), (req, res) => {
    const { title, mediaType, genre, rating } = req.body;
    const mediaFile = req.file;

    if (!title || !mediaType || !mediaFile) {
        return res.status(400).json({ message: 'Title, media type, and media file are required.' });
    }

    mediaCatalog.push({ title, mediaType, genre, rating, mediaFile: mediaFile.originalname });
    res.json({ message: 'Media item added successfully' });
});

app.get('/getMediaItems', (req, res) => {
    res.json(mediaCatalog);
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
