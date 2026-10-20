// On sauvegarde le vrai fetch au cas où
const originalFetch = window.fetch;

window.fetch = async (url, options) => {
    // Si on appelle notre route d'import
    if (url.includes('/api/import-countries')) {
        console.log("🛠️ [MOCK] Interception de la requête d'import");
        
        try {
            // 1. On va chercher tes vraies données dans ton fichier JSON local
            // ATTENTION : adapte le chemin vers ton fichier JSON !
            const response = await originalFetch('../../import.json'); 
            const countries = await response.json();
            
            // 2. On simule un délai de 2 secondes (comme un vrai serveur)
            await new Promise(resolve => setTimeout(resolve, 2000));
            
            // 3. On renvoie le nombre de pays trouvés
            return {
                ok: true,
                json: async () => ({ count: countries.data.objects.length })
            };
            
        } catch (error) {
            console.error("Erreur avec le fichier JSON :", error);
            return {
                ok: false,
                json: async () => ({ message: "Impossible de lire les données." })
            };
        }
    }
    
    // Pour les autres requêtes, on laisse faire le vrai fetch
    return originalFetch(url, options);
};