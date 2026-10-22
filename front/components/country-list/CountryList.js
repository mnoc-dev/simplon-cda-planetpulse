import AppComponent from "../AppComponent.js";
import "./CountryCard.js";
import { countries } from "../../data/countries.js";
import { APP_TEXTS } from "../../utils/constants.js";

class CountryList extends AppComponent {
    template() {
        return /* html */`
            <section class="container text-center" aria-labelledby="country-list-title">
                <h1 id="country-list-title" class="mb-3">${APP_TEXTS.TITLES.COUNTRY}</h1>
                <p class="text-body-secondary">${APP_TEXTS.BRAND_NAME}</p>
                <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4" data-countries></div>
            </section>
        `;
    }

    afterRender() {
        this.attachChildren(this.querySelector("[data-countries]"), "country-card", countries);
    }
}

customElements.define("country-list", CountryList);
