import './IndicatorsFormComponent.js';
import AppComponent from '../AppComponent.js';

class IndicatorsPage extends AppComponent {

    template() {
        return /*html*/ `
            <h1>Indicators page</h1>
            <p>Cette page permet d'ajouter des indicateurs par année.</p>
            <indicators-form></indicators-form>
        `;
    }
}

customElements.define('indicators-page', IndicatorsPage);