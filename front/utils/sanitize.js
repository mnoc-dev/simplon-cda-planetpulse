// Escape angle brackets before inserting text into an HTML template.
export function sanitize(value) {
    return String(value ?? "")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;");
}
