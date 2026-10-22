import AppComponent from "../AppComponent.js";

class CountryCard extends AppComponent {
    template() {
        return /* html */`
        <article class="card h-100 country-card">
            <img class="card-img-top country-flag" data-flag loading="lazy" decoding="async">
            <div class="card-body text-center">
                <h3 class="card-title h5">
                    <a class="stretched-link" data-link></a>
                </h3>
                <dl class="mb-0">
                    <dt>ISO code</dt>
                    <dd><span class="badge country-code" data-code></span></dd>
                    <dt>Region</dt>
                    <dd class="mb-0" data-region></dd>
                </dl>
            </div>        
        </article>

    `;
    }
    afterRender() {
        const { name, code, region, flag } = this.props;
        const link = this.querySelector("[data-link]");
        link.textContent = name || "Unknown country";
        link.href = `./country-detail.html?code=${encodeURIComponent(code)}`;

        this.querySelector("[data-code]").textContent = code || "—";
        this.querySelector("[data-region]").textContent = region || "Not available";

        const flagImage = this.querySelector("[data-flag]");
        flagImage.alt = `Flag of ${name || "unknown country"}`;
        flagImage.hidden = !flag;
        if (flag) {
            flagImage.addEventListener("error", () => {
                flagImage.hidden = true;
            }, { once: true });
            flagImage.src = flag;
        }
    }
}

customElements.define("country-card", CountryCard);
