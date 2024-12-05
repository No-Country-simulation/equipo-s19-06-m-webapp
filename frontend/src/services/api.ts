export const fetchSongs = async (track: string) => {
    const response = await fetch(`http://144.33.15.219:8080/search?track=${encodeURIComponent(track)}`, {
        headers: {
            'accept': 'application/json'
        }
    });

    if (!response.ok) {
        throw new Error('Error fetching songs');
    }

    const data = await response.json();
    return data;
};
