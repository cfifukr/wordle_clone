// /js/scripts.js

const maxGuesses = 6;
let currentGuess = '';
let attempts = 0;

// Ensure targetWord is defined and use it
if (typeof targetWord === 'undefined' || !targetWord) {
    console.error('targetWord is not defined or is empty.');
    // Optionally, handle the error or provide a fallback
} else {
    console.log(`Target word is: ${targetWord}`);

    document.addEventListener('keydown', handleKeyPress);

    function handleKeyPress(event) {
        const guessInput = document.getElementById('guessInput');

        if (event.key === 'Enter') {
            if (currentGuess.length === targetWord.length) {
                handleGuess();
            }
        } else if (event.key === 'Backspace') {
            currentGuess = currentGuess.slice(0, -1);
            updateBoard();
        } else if (/^[a-zA-Z]$/.test(event.key)) {
            if (currentGuess.length < targetWord.length) {
                currentGuess += event.key.toUpperCase();
                updateBoard();
            }
        }
    }

    function handleGuess() {
        attempts++;

        const row = document.querySelector(`#board .row:nth-child(${attempts})`);

        for (let i = 0; i < currentGuess.length; i++) {
            const tile = row.children[i];

            if (currentGuess[i] === targetWord[i]) {
                tile.classList.add('green');
            } else if (targetWord.includes(currentGuess[i])) {
                tile.classList.add('yellow');
            } else {
                tile.classList.add('gray');
            }
        }

        if (currentGuess === targetWord) {
            displayMessage('Congratulations! You guessed the word!');
            document.removeEventListener('keydown', handleKeyPress);
        } else if (attempts >= maxGuesses) {
            displayMessage(`Game over! The word was ${targetWord}.`);
            document.removeEventListener('keydown', handleKeyPress);
        } else {
            currentGuess = '';
        }
    }

    function updateBoard() {
        const row = document.querySelector(`#board .row:nth-child(${attempts + 1})`);

        for (let i = 0; i < targetWord.length; i++) {
            const tile = row.children[i];
            tile.textContent = currentGuess[i] || '';
        }
    }

    function displayMessage(msg) {
        document.getElementById('message').textContent = msg;
    }

    function initializeBoard() {
        const board = document.getElementById('board');
        for (let i = 0; i < maxGuesses; i++) {
            const row = document.createElement('div');
            row.classList.add('row');
            row.style = `--ceils:${targetWord.length}`;
            for (let j = 0; j < targetWord.length; j++) {
                const tile = document.createElement('div');
                tile.classList.add('tile');
                row.appendChild(tile);
            }
            board.appendChild(row);
        }
    }

    initializeBoard();
}
