# Video Calling App

This Video Calling App is an open source project. 

## Installation

Open the project on [Android Studio](https://developer.android.com/studio).

Don't forget the change the [Firebase](https://console.firebase.google.com/) API key and use your own key.

In the peer.js file, change the signaling server address.

Run this command on terminal to install package globally

```bash
npm i peer -g
``` 
Run this command to start the signaling server on your local device. Ensure that both the signaling server and all other devices are on the identical network connection.

```bash
peerjs --port 9000 --key peerjs --path /videocallapp
``` 

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.
