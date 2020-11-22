(async () => {
    const url = 'http://localhost:8080/restaurants';
    const response = await fetch(url);
    const restaurants = await response.json();

    const element = document.getElementById('app');
    element.innerHTML = `
        ${restaurants.map(restaurant => `
            ${restaurant.id}
            ${restaurant.name}
            ${restaurant.address}
            <br>
        `).join('')}
    `;
})();