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
 * randomized quotes once clicked and popupMessage() is called
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

function divMessage() {
  const quoteToDisplay = pickRandomQuote();
  document.getElementById('quote-displayer').innerText = quoteToDisplay;
}

function fetchMyName() {
  console.log('Fetching your name...');
  const responsePromise = fetch('/data');
  responsePromise.then(handleResponse);
}

function handleNameResponse(nameResponse) {
  console.log('Handling response...');
  const namePromise = nameResponse.text();
  namePromise.then(addName);
}

function addName(name) {
    console.log('Adding name to DOM...');
    const nameDiv = document.getElementById('name-container');
    nameDiv.innerText = name;
}

function fetchComments() {
    fetch('/data').then(response => response.json()).then((comments) => {
        console.log('Fetching comments...');
        console.log(comments);
        const commentListElement = document.getElementById('comment-list');
        commentListElement.innerHTML = '';
        for (const tempComment of comments) {
            commentListElement.appendChild(
            createCommentElement(tempComment));
        }
    });
}

function createCommentElement(comment) {
    const commentElement = document.createElement('li');
    commentElement.innerText = comment;
    return commentElement;
}

function createMap() {
  const map = new google.maps.Map(
    document.getElementById('map'),
    {center: {lat: 34.052, lng: -118.245}, zoom: 10});

  const favoriteRestaurantMarker = new google.maps.Marker({
    position: {lat: 34.0831169, lng: -118.3410553},
    map: map,
    title: 'Italian Dream'
  });

  const favoriteOutdoorMarketMarker = new google.maps.Marker({
    position: {lat: 34.0498131, lng: -118.2519937},
    map: map,
    title: 'Grand Central Market'
  });

  const familyRootsMarker = new google.maps.Marker({
    position: {lat:34.0095081, lng: -118.2896097},
    map: map,
    title: 'East Los Angeles'
  });
}

function onloadFunction() {
  fetchComments();
  createMap();
}