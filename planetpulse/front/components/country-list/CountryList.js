import AppComponent from "../app-component.js";

class CountryList extends AppComponent {
    template() {
        return "Countries list";
    }
}

customElements.define("country-list", CountryList);