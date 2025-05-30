const tmi = require('tmi.js');
const express = require('express');
const http = require('http');
const WebSocket = require('ws');

const CHANNEL_NAME = 'jellios1234'; // <-- Pas dit aan
const PORT = 3000;

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

// WebSocket broadcast functie
function broadcastRoll() {
  wss.clients.forEach(client => {
    if (client.readyState === WebSocket.OPEN) {
      const roll = Math.floor(Math.random() * 20) + 1;
      client.send(JSON.stringify({ roll }));
    }
  });
}

// Twitch-chat verbinden
const client = new tmi.Client({
  channels: [CHANNEL_NAME]
});

client.connect();

client.on('message', (channel, tags, message, self) => {
  if (self) return;
  if (message.trim().toLowerCase() === '!roll') {
    broadcastRoll();
  }
});

// Server start
app.use(express.static('public'));
server.listen(PORT, () => {
  console.log(`Server draait op http://localhost:${PORT}`);
});
