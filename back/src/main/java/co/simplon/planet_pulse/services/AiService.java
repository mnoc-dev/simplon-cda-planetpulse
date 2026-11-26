package co.simplon.planet_pulse.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient client;

    public AiService(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    public String testConnection() {
        return client.prompt()
                .user("Réponds uniquement en français : Connexion PlanetPulse réussie.")
                .call()
                .content();
    }
}
