// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random quote to the page as a hidden div that toggles between
    randomized quotes once clicked and popupMessage() is called
 */

function pickRandomQuote() {
  const quotes =
      ['The secret of getting ahead is getting started.', 'What you do today can improve all your tomorrows',
       'A single sunbeam is enough to drive away many shadows',
       'It is never too late to be what you might have been.', 
       'A true friend never gets in your way unless you happen to be going down.'];

  // Pick a random quote.
    const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Return quote as string to be used elsewhere.
    return quote;
}

function popupMessage() {
    const quoteToDisplay = pickRandomQuote();
    document.getElementById("quoteDisplayer").innerHTML = quoteToDisplay;
}