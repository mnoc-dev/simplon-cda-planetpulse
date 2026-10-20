import AppComponent from "../../AppComponent.js";
import '../../indicators/IndicatorsFormComponent.js'

class IndicatorsPage extends AppComponent{

    template() {
         /*html*/
         return
    `
    <h1>indicators pages</h1>
    
    <p> indicators page mermit to add indicators per years </p>
    <indicators-page></indicators-page>

    `

    }

    }

customElements.define('indicators-form', IndicatorsForm);
