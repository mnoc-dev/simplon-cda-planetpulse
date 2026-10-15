import AppComponent from "../../../lib/AppComponent.js";
import ImportButton from "../../components/import-countries/ImportButton.js"; 

class ImportPage extends AppComponent{
    template(){
        return `<h1>IMPORT COUNTRIES</h1>
        <p>description of the import
        </p>
        <import-button></import-button>
        `;
    }

}
customElements.define('import-page', ImportPage);