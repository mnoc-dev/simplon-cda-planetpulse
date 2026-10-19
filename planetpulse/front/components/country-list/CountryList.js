import AppComponent from "../AppComponent.js";
import "./CountryCard.js";
import { countries } from "../../data/countries.js";

class CountryList extends AppComponent {
    template() {
        return /* html */`
            <section class="container" aria-labelledby="country-list-title">
                <h1 id="country-list-title" class="mb-3">Country list</h1>
                <p class="text-body-secondary">Sample countries</p>
                <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4" data-countries></div>
            </section>
        `;
    }

    afterRender() {
        this.attachChildren(this.querySelector("[data-countries]"), "country-card", countries);
    }
}

customElements.define("country-list", CountryList);
