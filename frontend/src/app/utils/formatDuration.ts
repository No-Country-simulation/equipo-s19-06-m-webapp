export function formatDuration(durationInSeconds: string): string {
    const totalSeconds = parseInt(durationInSeconds, 10);
    const minutes = Math.floor(totalSeconds / 60);
    const seconds = totalSeconds % 60;
    return `${minutes}:${seconds.toString().padStart(2, "0")}`;
}
